package com.brokeneye.a_001;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by a007 on 2017. 2. 6..
 */

public class MainActivity extends AppCompatActivity {

    static ArrayList<Finshgame> displaygame = new ArrayList<>();
    static ArrayList<Integer> displaygameimage=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ListView mainList;
        ListView playphotos;
        playphotos= (ListView)findViewById(R.id.play_photo);
        mainList = (ListView) findViewById(R.id.mainlist);


        displaygame.add(new Finshgame(R.drawable.logo512,R.drawable.logo512,"희융이네","우경이네","1","1"));
        displaygame.add(new Finshgame(R.drawable.logo512,R.drawable.logo512,"희융이네","우경이네","1","1"));
        displaygameimage.add(R.drawable.logo512);
        displaygameimage.add(R.drawable.logo512);
        displaygameimage.add(R.drawable.logo512);


        final ListViewAdapter_M adapter_M;
        final ListViewAdapter adapter_P;
        // Adapter 생성
        adapter_M = new ListViewAdapter_M();
        adapter_P = new ListViewAdapter();
        // 리스트뷰 참조 및 Adapter달기
        mainList.setAdapter(adapter_M);
        playphotos.setAdapter(adapter_P);
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
    public class ListViewAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return displaygameimage.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos =position;
            final Context context = parent.getContext();
            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.playphoto_listlayout, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            ImageView playphoto = (ImageView) convertView.findViewById(R.id.playphoto);

            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            Integer listViewItem = displaygameimage.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            playphoto.setImageResource(listViewItem);

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return displaygameimage.size();
        }
    }
}
