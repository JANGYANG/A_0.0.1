package com.brokeneye.a_001;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.R.id.list;

/**
 * Created by a007 on 2017. 2. 6..
 */

public class MainActivity extends AppCompatActivity  {

    static ArrayList<Finshgame> displaygame = new ArrayList<>();
    static ArrayList<Integer> displaygameimage=new ArrayList<>();
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ListView mainList;
        mainList = (ListView) findViewById(R.id.mainlist);






        displaygame.add(new Finshgame(R.drawable.logo512,R.drawable.logo512,"희융이네","우경이네","1","1"));
        displaygame.add(new Finshgame(R.drawable.logo512,R.drawable.logo512,"희융이네","우경이네","1","1"));
        displaygameimage.add(R.drawable.logo512);
        displaygameimage.add(R.drawable.logo512);
        displaygameimage.add(R.drawable.logo512);


       /*  final ListViewAdapter adapter;
        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        mainList.setAdapter(adapter);
*/


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        //툴바 사용시 필요


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "매칭신청하기", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(),MatchingPage.class));
                /*
                //snackbar 토스트의 바의 상위버전 , setAction" 버튼이름", new onclickListener
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                           public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                            }
                        }).show();*/
            }
        });

    }






    static class Finshgame {
        int TeamLogo1;
        int TeamLogo2;
        String TeamName1;
        String TeamName2;
        String TeamScore1;
        String TeamScore2;

        Finshgame(int TeamLogo1, int TeamLogo2, String TeamName1, String TeamName2, String TeamScore1, String TeamScore2) {
            this.TeamLogo1=TeamLogo1; this.TeamLogo2=TeamLogo2; this.TeamName1=TeamName1; this.TeamName2=TeamName2; this.TeamScore1=TeamScore1; this.TeamScore2=TeamScore2;
            //데이터값에서 받는 형으로 쓸것(ex 값의 위치.TeamLogo= TeamLogo1
        }
    }



}

class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MainpageActivity tab1=new MainpageActivity();
                return tab1;
            //여기 에러를 어떻게 처리할까요?

            case 1:
                tab1Activity tab2=new tab1Activity();
                return tab2;
            case 2:
                tab2Activity tab3=new tab2Activity();
                return tab3;
            case 3:
                tab3Activity tab4=new tab3Activity();
                return tab4;
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "main_page";
            case 1:
                return "tab1page";
            case 2:
                return "tab2page";
            case 3:
                return "tab3page";
        }
        return null;
    }
}