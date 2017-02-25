package com.brokeneye.a_001;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ListView mainList;
        mainList = (ListView) findViewById(R.id.mainlist);




        displaygame.add(new Finshgame(R.drawable.logo512,R.drawable.logo512,"희융이네","우경이네","1","1"));
        displaygame.add(new Finshgame(R.drawable.logo512,R.drawable.logo512,"희융이네","우경이네","1","1"));
        displaygameimage.add(R.drawable.logo512);
        displaygameimage.add(R.drawable.logo512);
        displaygameimage.add(R.drawable.logo512);


        final ListViewAdapter_M adapter_M;
        // Adapter 생성
        adapter_M = new ListViewAdapter_M();

        // 리스트뷰 참조 및 Adapter달기
        mainList.setAdapter(adapter_M);


        mainList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "경기 자세히 보기", Toast.LENGTH_SHORT).show();
                return false;
            }
        });



        //툴바 사용시 필요


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "매칭신청하기", Toast.LENGTH_SHORT).show();

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

    public class ListViewAdapter_M extends BaseAdapter {


        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return displaygame.size();
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.play_listlayout, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            ImageView Team_logo1 = (ImageView) convertView.findViewById(R.id.Team_logo1);
            ImageView Team_logo2 = (ImageView) convertView.findViewById(R.id.Team_logo2);
            TextView Team_name1 = (TextView) convertView.findViewById(R.id.Team_name1);
            TextView Team_name2 = (TextView) convertView.findViewById(R.id.Team_name2);
            TextView Team_score1 = (TextView) convertView.findViewById(R.id.Team_Score1);
            TextView Team_score2 = (TextView) convertView.findViewById(R.id.Team_Score2);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            Finshgame listViewItem = displaygame.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            Team_logo1.setImageResource(listViewItem.TeamLogo1);
            Team_logo2.setImageResource(listViewItem.TeamLogo2);
            Team_name1.setText(listViewItem.TeamName1);
            Team_name2.setText(listViewItem.TeamName2);
            Team_score1.setText(listViewItem.TeamScore1);
            Team_score2.setText(listViewItem.TeamScore2);

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return displaygame.get(position);
        }

        // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    }

}
