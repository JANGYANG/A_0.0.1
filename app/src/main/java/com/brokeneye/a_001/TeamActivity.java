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

public class TeamActivity extends Fragment {

    static ArrayList<myteamplay> myteamplay = new ArrayList<>();



    ListView myteam_ListView;
    ListView TeamRank;
    ListView SingleRank;
    ListView Formation;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_team, container, false);
        myteam_ListView = (ListView) rootView.findViewById(R.id.myteam_Record_List);
        TeamRank = (ListView)rootView.findViewById(R.id.Team_TeamRank_List);
        SingleRank = (ListView)rootView.findViewById(R.id.Team_SingleRank_List);
        Formation = (ListView)rootView.findViewById(R.id.Team_Formation_List);

        final ListViewAdapter adapter = new ListViewAdapter();

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
            this.rank = rank; this.logo = logo this.name = name; this.score = score;
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
        String formation;

        formation(int rank)
    }

    class ListViewAdapter extends BaseAdapter {


        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return TeamActivity.myteamplay.size();
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
            TextView day = (TextView) convertView.findViewById(R.id.Team_day_record);
            TextView result = (TextView) convertView.findViewById(R.id.Team_result_record);
            TextView score1 = (TextView) convertView.findViewById(R.id.Team_Score1_record);
            TextView score2 = (TextView) convertView.findViewById(R.id.Team_Score2_record);
            TextView name = (TextView) convertView.findViewById(R.id.Team_name2_record);
            TextView place = (TextView) convertView.findViewById(R.id.Team_place_record);
            ImageView logo = (ImageView) convertView.findViewById(R.id.Team_logo2);
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            TeamActivity.myteamplay listViewItem = TeamActivity.myteamplay.get(position);

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
}
