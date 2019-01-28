package com.example.plataformaasesoramientoonline;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
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

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Color color;
    private TextView email, name;
    private FloatingActionButton fab;
    private static final String TAG = "FireBaseDavid";
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(color.RED);
        }
        Fragment fragment1= new FragmentSobreMi();

        setSupportActionBar(toolbar);


        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment1).commit();


        email = findViewById(R.id.textViewEmailHeader);
        name = findViewById(R.id.textViewNameHeader);
        fab = findViewById(R.id.exit);

        mAuth = FirebaseAuth.getInstance();
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null) {
                    startActivity(new Intent(MainActivity.this, SingIn.class));
                }
            }
        };
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final NavigationView navView = (NavigationView) findViewById(R.id.navview);
        navView.setCheckedItem(R.id.sobreMi);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        View header = navView.getHeaderView(0);
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
                    case R.id.entrenamientos:
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
