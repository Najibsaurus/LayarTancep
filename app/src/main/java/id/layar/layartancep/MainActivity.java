package id.layar.layartancep;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import id.layar.layartancep.ui.home.HomeFragment;
import id.layar.layartancep.ui.tv.TeveFragment;


public class MainActivity extends AppCompatActivity {


    private final String SELECTED_MENU = "selected_menu";
    private BottomNavigationView navView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                Fragment fragment = null;
                if (item.getItemId() == R.id.navigation_movie) {
                    fragment = HomeFragment.newInstance();
                } else if (item.getItemId() == R.id.navigation_tv_show) {
                    fragment = TeveFragment.newInstance();
                }

                if (fragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.container, fragment)
                            .commit();
                }
                return true;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            navView.setSelectedItemId(R.id.navigation_movie);
        }
    }

}
