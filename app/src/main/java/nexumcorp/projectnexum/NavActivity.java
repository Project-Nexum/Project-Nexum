package nexumcorp.projectnexum;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import nexumcorp.projectnexum.accounts.LoginActivity;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int REQUEST_CODE = 1;
    private String TAG;
    private FirebaseAuth.AuthStateListener mauthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nexum");



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setupFirebaseListener();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.d(TAG,"Attempting to sign out User");
            FirebaseAuth.getInstance().signOut();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_favourites) {
            favourites fav= new favourites();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.viewpager_container, fav).commit();
        }else if (id == R.id.nav_post) {
            post post= new post();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.viewpager_container, post).commit();
        }
        else if (id == R.id.nav_search) {

            Log.d(TAG, "onClick: navigating to filters activity.");
            Intent intent = new Intent(NavActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_account) {

            account account= new account();
            FragmentManager manager= getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.viewpager_container, account).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setupFirebaseListener(){
        Log.d(TAG,"Setting up the auth state listener");
        mauthStateListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.d(TAG,"signed_in"+user.getUid());
                }else{
                    Log.d(TAG,"onAuthstateChanged: signed_out");
                    Toast.makeText(NavActivity.this,"Signed out",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(NavActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mauthStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mauthStateListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mauthStateListener);
        }
    }

}
