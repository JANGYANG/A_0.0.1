package com.brokeneye.a_001;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gmldb on 2017-02-25.
 */

public class UserActivity extends Fragment{

    static ArrayList<myteamplay> play_list = new ArrayList<>();
    static ArrayList<player1> player1_list = new ArrayList<>();
    static ArrayList<player2> player2_list = new ArrayList<>();
    ListView inplay;
    ListView player1_tv;
    ListView player2_tv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_user, container, false);

        play_list.add(new myteamplay("2017-3-20","승",2,1,R.drawable.logo512,"희융이네","동국대학교"));

        player1_list.add(new player1(11,"박희융","공격수"));
        player2_list.add(new player2(11,"박희융","공격수"));


        inplay=(ListView) rootView.findViewById(R.id.myplaygame);
        player1_tv=(ListView) rootView.findViewById(R.id.player1);
        player2_tv=(ListView) rootView.findViewById(R.id.player2);
        final ListViewAdapter adapter = new ListViewAdapter();
        final ListViewAdapter1 adapter1 = new ListViewAdapter1();
        final ListViewAdapter2 adapter2 = new ListViewAdapter2();
        return rootView;
    }

    class player1{
        int number;
        String name;
        String postition;
        player1(int number, String name, String postition){
            this.number=number; this.name=name; this.postition=postition;
        }
    }

    class player2{
        int number;
        String name;
        String postition;
        player2(int number, String name, String postition){
            this.number=number; this.name=name; this.postition=postition;
        }
    }


    class myteamplay {
        String day;
        String result;
        int score1;
        int score2;
        String teamname;
        int logo;
        String place;

        myteamplay(String day, String result, int score1, int score2, int logo, String teamname, String place) {
            this.day = day;this.result = result;this.score1 = score1;this.score2 = score2;this.logo = logo;this.teamname = teamname;this.place = place;
        }
    }

    class ListViewAdapter extends BaseAdapter

        {


            // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
            @Override
            public int getCount() {
            return UserActivity.play_list.size();
        }

            // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listlayout_userpage_playgame, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            TextView day = (TextView) convertView.findViewById(R.id.Team_day_record);
            TextView result = (TextView) convertView.findViewById(R.id.Team_result_record);
            TextView score1 = (TextView) convertView.findViewById(R.id.Team_Score1_record);
            TextView score2 = (TextView) convertView.findViewById(R.id.Team_Score2_record);
            TextView name = (TextView) convertView.findViewById(R.id.Team_name2_record);
            TextView place = (TextView) convertView.findViewById(R.id.Team_place_record);
            ImageView logo = (ImageView) convertView.findViewById(R.id.Team_logo2);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            UserActivity.myteamplay listViewItem = UserActivity.play_list.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            day.setText(listViewItem.day);
            result.setText(listViewItem.result);
            score1.setText(listViewItem.score1);
            score2.setText(listViewItem.score2);
            name.setText(listViewItem.teamname);
            place.setText(listViewItem.place);
            logo.setImageResource(listViewItem.logo);

            return convertView;
        }
            @Override
            public long getItemId(int position) {
            return position;
        }

            // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
            @Override
            public Object getItem(int position) {
            return TeamActivity.myteamplay.get(position);
        }
    }

    class ListViewAdapter1 extends BaseAdapter {

        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return UserActivity.player1_list.size();
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listlayout_userpage_player1, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            TextView num = (TextView) convertView.findViewById(R.id.number);
            TextView name =(TextView) convertView.findViewById(R.id.name);
            TextView ps=(TextView) convertView.findViewById(R.id.position);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            UserActivity.player1 listViewItem = UserActivity.player1_list.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            num.setText(listViewItem.number);
            name.setText(listViewItem.name);
            ps.setText(listViewItem.postition);

            return convertView;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return UserActivity.player1_list.get(position);
        }
    }

    class ListViewAdapter2 extends BaseAdapter {

        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return UserActivity.player2_list.size();
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listlayout_userpage_player2, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            TextView num = (TextView) convertView.findViewById(R.id.number);
            TextView name =(TextView) convertView.findViewById(R.id.name);
            TextView ps=(TextView) convertView.findViewById(R.id.position);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            UserActivity.player2 listViewItem = UserActivity.player2_list.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            num.setText(listViewItem.number);
            name.setText(listViewItem.name);
            ps.setText(listViewItem.postition);

            return convertView;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return UserActivity.player2_list.get(position);
        }
    }

}
