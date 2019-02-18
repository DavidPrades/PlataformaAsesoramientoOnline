package com.example.plataformaasesoramientoonline;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Color color;
    private TextView email, name;
    private static final String TAG = "FireBaseDavid";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListner;
    private TextView textViewNameHeader;
    private TextView textViewEmailHeader;

    FirebaseDatabase database;

    DatabaseReference usuarios;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FirebaseApp.initializeApp(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }





        Fragment fragment1= new FragmentSobreMi();

        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment1).commit();



        mAuth = FirebaseAuth.getInstance();
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null) {
                    startActivity(new Intent(MainActivity.this, SingIn.class));
                }
            }
        };


        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final NavigationView navView = (NavigationView) findViewById(R.id.navview);
        navView.setCheckedItem(R.id.sobreMi);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        View header = navView.getHeaderView(0);






        loadProfile();
        textViewNameHeader = header.findViewById(R.id.textViewNameHeader);
        textViewEmailHeader = header.findViewById(R.id.textViewEmailHeader);
        final ImageView circular_avatar = header.findViewById(R.id.imageViewHeader);
        Bitmap bm = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.tytyy);
        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(this.getResources(), bm);
        drawable.setCircular(true);
        circular_avatar.setImageDrawable(drawable);




        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;
                menuItem.setChecked(true);

                switch (menuItem.getItemId()) {
                    case R.id.sobreMi:
                        fragment = new FragmentSobreMi();
                        fragmentTransaction = true;
                        toolbar.setTitle(menuItem.getTitle());
                        break;
                    case R.id.coaching:
                        toolbar.setTitle(menuItem.getTitle());
                        fragment = new FragmentEntrenamientos();
                        fragmentTransaction = true;
                        break;
                    case R.id.transformaciones:
                        toolbar.setTitle(menuItem.getTitle());
                        fragment = new FragmentTransformation();

                        fragmentTransaction = true;
                        break;
                    case R.id.contacto:
                        toolbar.setTitle(menuItem.getTitle());
                        fragment = new ContactFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.logout:
                        mAuth.signOut();
                        break;

                }

                if(fragmentTransaction) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
                    menuItem.setChecked(true);
                    getSupportActionBar().setTitle(menuItem.getTitle());

                }

                drawerLayout.closeDrawers();
                return true;

            }
        });

    }

    public void loadProfile(){

       database = FirebaseDatabase.getInstance();
         usuarios = database.getReference("UsuariosRegistrados");

        usuarios.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).exists()) {
                    textViewNameHeader.setText(dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()+"/name").getValue(String.class));
                    textViewEmailHeader.setText(dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()+"/email").getValue(String.class));
                }else{
                    //createUser
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shop:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
