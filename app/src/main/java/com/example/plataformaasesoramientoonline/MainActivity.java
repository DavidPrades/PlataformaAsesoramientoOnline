package com.example.plataformaasesoramientoonline;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final NavigationView navView = (NavigationView) findViewById(R.id.navview);

        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        //El listener realiza una pequeña animación sobre el icono al cerrar el navegador
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        View header = navView.getHeaderView(0);
        final ImageView circular_avatar = header.findViewById(R.id.imageView);
        Bitmap bm = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.tytyy);
        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(this.getResources(), bm);
        drawable.setCircular(true);
        circular_avatar.setImageDrawable(drawable);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.sobreMi:
                        toolbar.setTitle(menuItem.getTitle());

                        break;
                    case R.id.entrenamientos:
                        toolbar.setTitle(menuItem.getTitle());

                        break;
                    case R.id.transformaciones:
                        toolbar.setTitle(menuItem.getTitle());
                        fragment = new FragmentTransformation();

                        fragmentTransaction = true;
                        break;
                    case R.id.contacto:
                        toolbar.setTitle(menuItem.getTitle());
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
