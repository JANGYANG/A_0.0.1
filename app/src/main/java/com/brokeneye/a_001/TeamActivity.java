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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gmldb on 2017-02-25.
 */

public class TeamActivity extends Fragment {

    static ArrayList<myteamplay> myteamplay_list = new ArrayList<>();
    static ArrayList<teamrank> myteamrank_list = new ArrayList<>();
    static ArrayList<singlerank> mysinglerank_list = new ArrayList<>();
    static ArrayList<formation> myformation_list = new ArrayList<>();



    ListView myteam_ListView;
    ListView TeamRank_ListView;
    ListView SingleRank_ListView;
    ListView Formation_ListView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_team, container, false);
        myteam_ListView = (ListView) rootView.findViewById(R.id.myteam_Record_List);
        TeamRank_ListView = (ListView)rootView.findViewById(R.id.Team_TeamRank_List);
        SingleRank_ListView = (ListView)rootView.findViewById(R.id.Team_SingleRank_List);
        Formation_ListView = (ListView)rootView.findViewById(R.id.Team_Formation_List);

        myteamplay_list.add(new myteamplay("2017-03-20","승",1,2,R.drawable.logo512,"희융이네","송파구"));
        myteamrank_list.add(new teamrank(1,R.drawable.logo512,"희융이네",100));
        mysinglerank_list.add(new singlerank(1,"박희융"));
        myformation_list.add(new formation(1,"442포메이션"));
        final ListViewAdapter adapter = new ListViewAdapter();
        final ListViewAdapter1 adapter1 = new ListViewAdapter1();
        final ListViewAdapter2 adapter2 = new ListViewAdapter2();
        final ListViewAdapter3 adapter3 = new ListViewAdapter3();

        myteam_ListView.setAdapter(adapter);
        TeamRank_ListView.setAdapter(adapter1);
        SingleRank_ListView.setAdapter(adapter2);
        Formation_ListView.setAdapter(adapter3);



        return rootView;
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

    class teamrank{
        int rank;
        int logo;
        String name;
        int score;

        teamrank(int rank, int logo, String name, int score){
            this.rank = rank; this.logo = logo; this.name = name; this.score = score;
        }
    }

    class singlerank{
        int rank;
        String name;

        singlerank(int rank, String name){
            this.rank=rank; this.name=name;
        }
    }

    class formation{
        int rank;
        String fm;

        formation(int rank, String fm){
            this.rank=rank; this.fm=fm;
        }
    }

    class ListViewAdapter extends BaseAdapter {


        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return TeamActivity.myteamplay_list.size();
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listlayout_teampage_record, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            TextView day = (TextView) convertView.findViewById(R.id.day);
            TextView result = (TextView) convertView.findViewById(R.id.result);
            TextView score1 = (TextView) convertView.findViewById(R.id.Score1);
            TextView score2 = (TextView) convertView.findViewById(R.id.Score2);
            TextView name = (TextView) convertView.findViewById(R.id.name2);
            TextView place = (TextView) convertView.findViewById(R.id.place);
            ImageView logo = (ImageView) convertView.findViewById(R.id.logo2);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            TeamActivity.myteamplay listViewItem = TeamActivity.myteamplay_list.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            day.setText(listViewItem.day);
            result.setText(listViewItem.result);
            score1.setText(Integer.toString(listViewItem.score1));
            score2.setText(Integer.toString(listViewItem.score2));
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
            return TeamActivity.myteamplay_list.get(position);
        }
    }



    //팀순위 리스트
    class ListViewAdapter1 extends BaseAdapter {

        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return TeamActivity.myteamrank_list.size();
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listlayout_teampage_teamrank, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            TextView rank = (TextView) convertView.findViewById(R.id.rank);
            ImageView logo = (ImageView) convertView.findViewById(R.id.logo);
            TextView name =(TextView) convertView.findViewById(R.id.name);
            TextView score = (TextView) convertView.findViewById(R.id.score);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            TeamActivity.teamrank listViewItem = TeamActivity.myteamrank_list.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            rank.setText(Integer.toString(listViewItem.rank));
            logo.setImageResource(listViewItem.logo);
            name.setText(listViewItem.name);
            score.setText(Integer.toString(listViewItem.score));

            return convertView;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return TeamActivity.myteamrank_list.get(position);
        }
    }



    //개인 랭크 정보


    class ListViewAdapter2 extends BaseAdapter {

        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return TeamActivity.mysinglerank_list.size();
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listlayout_teampage_singlerank, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            TextView rank = (TextView) convertView.findViewById(R.id.rank);
            TextView name =(TextView) convertView.findViewById(R.id.name);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            TeamActivity.singlerank listViewItem = TeamActivity.mysinglerank_list.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            rank.setText(Integer.toString(listViewItem.rank));
            name.setText(listViewItem.name);

            return convertView;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return TeamActivity.mysinglerank_list.get(position);
        }
    }


    //포메이션 정보

    class ListViewAdapter3 extends BaseAdapter {

        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return TeamActivity.myformation_list.size();
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listlayout_teampage_formation, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            TextView rank = (TextView) convertView.findViewById(R.id.rank);
            TextView formation = (TextView) convertView.findViewById(R.id.formation_name);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            TeamActivity.formation listViewItem = TeamActivity.myformation_list.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            rank.setText(Integer.toString(listViewItem.rank));
            formation.setText(listViewItem.fm);
            return convertView;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return TeamActivity.myformation_list.get(position);
        }
    }

}
