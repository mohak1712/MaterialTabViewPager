package com.example.mohak.materialtabviewpager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imageView;
    int[] img = {R.mipmap.king, R.mipmap.trop};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        imageView = (ImageView) findViewById(R.id.htab_header);
        imageView.setImageResource(R.mipmap.king);
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setupviewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                imageView.setImageResource(img[position]);

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                imageView.setImageResource(img[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.king);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int primaryDark = getResources().getColor(R.color.primary_dark);
                int primary = getResources().getColor(R.color.primary);
                Palette.Swatch vibraant = palette.getVibrantSwatch();
                Palette.Swatch darkvibrant = palette.getDarkVibrantSwatch();
                if (vibraant != null) {
                    collapsingToolbarLayout.setContentScrimColor(vibraant.getBodyTextColor());
                } else {
                    collapsingToolbarLayout.setContentScrimColor(primary);

                }
                if (darkvibrant != null) {
                    collapsingToolbarLayout.setStatusBarScrimColor(darkvibrant.getBodyTextColor());
                } else {
                    collapsingToolbarLayout.setStatusBarScrimColor(primaryDark);

                }

            }
        });




    }

    private void setupviewPager(ViewPager viewPager) {

        Mypager adapter = new Mypager(getSupportFragmentManager());
        adapter.addFragment(frag1.newInstance("", ""), "YO");
        adapter.addFragment(frag2.newInstance("", ""), "YOYO");
        viewPager.setAdapter(adapter);

    }


    public class Mypager extends FragmentPagerAdapter {

        ArrayList<Fragment> frag = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();

        public Mypager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frag.get(position);
        }


        void addFragment(Fragment fragment, String Title)

        {
            frag.add(fragment);
            title.add(Title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title.get(position);
        }

//        public android.graphics.drawable.Drawable getPageIcon(int position) {
//            return ResourcesCompat.getDrawable(getResources(), icon[position], null);
//        }

        @Override
        public int getCount() {
            return frag.size();
        }


    }

}







