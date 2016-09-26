package cualmemo.memoshop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProductosActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        PageAdapater  adapater= new PageAdapater(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(adapater);

        actionBar =getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener= new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        //frgmentos a utilizar
        ActionBar.Tab tab = actionBar.newTab().setText("Pollos").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Frisdelicias").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Línea liviana").setTabListener(tabListener);
        actionBar.addTab (tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);

            }
        });
    }
    public class PageAdapater extends FragmentPagerAdapter {

        public PageAdapater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new PollosFragment();
                case 1: return new FrisdeliciasFragment();
                case 2: return new LivianaFragment();
                default:return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
