package com.brokeneye.a_001;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gmldb on 2017-02-27.
 */

public class MainpageActivity extends Fragment {
    ListView mainList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.main_list, container, false);

        mainList = (ListView) rootView.findViewById(R.id.mainlist);


        final ListViewAdapter adapter = new ListViewAdapter();
        // Adapter 생성


        // 리스트뷰 참조 및 Adapter달기
        mainList.setAdapter(adapter);

        mainList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               /* Snackbar.make(view, "경기를 자세히 보시겠습니까?", Snackbar.LENGTH_LONG)
                        .setAction("네", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getContext(), List_playimage.class));
                            }
                        }).show();*/

                Toast.makeText(getContext(), "경기 자세히 보기", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), List_playimage.class));
                return false;

            }
        });
        return rootView;
    }

    class ListViewAdapter extends BaseAdapter {


        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return MainActivity.displaygame.size();
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
            MainActivity.Finshgame listViewItem = MainActivity.displaygame.get(position);

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
            return MainActivity.displaygame.get(position);
        }

        // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    }
}