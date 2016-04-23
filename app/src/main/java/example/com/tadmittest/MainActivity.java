package example.com.tadmittest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import example.com.tadmittest.fragments.PostFragment;
import example.com.tadmittest.models.POJO.POJOpost;
import example.com.tadmittest.models.Post;
import example.com.tadmittest.network.RestClient;
import example.com.tadmittest.utils.Utils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private NavigationView nvDrawer;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posts = new ArrayList<>();

        //Set up the GET request to th wp-APIs URL
        setUpGETRequest();

        //Set up the drawer and connect it to the toolbar
        setUpDrawerView();


    }

    //Set up get request on a background thread
    private void setUpGETRequest() {

        //Call REST API request
        RestClient restClient = new RestClient();
        restClient.getService().getArray(new Callback<List<POJOpost>>() {
            //On finish parse JSON callback
            @Override
            public void success(List<POJOpost> items, Response response) {
                //On success parsing
                //Check there is at least two articles
                if (items.size() > 1){
                    //Loop on POJO items
                    for (int i = 0; i < 2;i++){
                         //Add clean post from current POJO item list to post list
                        posts.add(Utils.convertPOJOtoPost(items.get(i)));
                    }
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                Log.wtf("here", "--------------------------------------------" + error.getMessage().toString());
            }
        });
    }

    //Set up the drawer view
    private void setUpDrawerView() {
        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);
    }

    //Build action bar instance
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    //Set listener on the the navigation view "nvDrawer"
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    //Handle drawer selection
    public void selectDrawerItem(MenuItem menuItem) {

        //Check data was actually acquired from the REST API - if not, don't initialize fragment instance
        if (posts != null && posts.size() == 2) {

            String fTag = null;
            Post fPost = null;

            //Build Post instance with right post value and tag var with right tag value
            switch (menuItem.getItemId()) {

                case R.id.nav_first_fragment:
                    fTag = Constants.POST_ONE_FRAGMENT_TAG;
                    fPost = posts.get(0);
                    break;

                case R.id.nav_second_fragment:
                    fTag = Constants.POST_TWO_FRAGMENT_TAG;
                    fPost = posts.get(1);
                    break;

            }
            //Build new instance of the fragment
            PostFragment postFragment = PostFragment.newInstance(fPost);

            //Set up fragment manager in order to make the transaction
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place_holder, postFragment, fTag);

            // replace
            ft.commit();
        }
        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }


}
