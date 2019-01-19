package com.example.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabLayout= (TabLayout)findViewById(R.id.tabs);
        ViewPager viewPager=findViewById(R.id.pager);

        viewPager.setAdapter(new SectionPageAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


    }



    public class SectionPageAdapter extends FragmentPagerAdapter
    {
        public  SectionPageAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position)
            {
                case 0:
                    return new fragmentA();

                case 1:
                    return new fragmentB();

                    default:
                        return new Fragment();
            }

        }


        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch(position)
            {
                case 0:
                    return "First Tab";
                case 1:
                    return "Second Tab";
                default:
                    return "Lo que sea";


            }
        }
    }
}
