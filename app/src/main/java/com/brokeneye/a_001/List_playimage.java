package com.brokeneye.a_001;

import android.content.Context;
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
 * Created by gmldb on 2017-02-24.
 */

public class List_playimage extends Fragment {


   ListView playImage_List;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.playphoto_list, container, false);



        playImage_List = (ListView) rootView.findViewById(R.id.playImage_List);


        final ListViewAdapter adapter= new ListViewAdapter();
        // Adapter 생성


        // 리스트뷰 참조 및 Adapter달기
        playImage_List.setAdapter(adapter);

        playImage_List.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "경기 자세히 보기", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return rootView;
    }

    class ListViewAdapter extends BaseAdapter {


        // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
        @Override
        public int getCount() {
            return MainActivity.displaygameimage.size();
        }

        // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.playphoto_listlayout, parent, false);
            }

            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            ImageView playImage = (ImageView) convertView.findViewById(R.id.playImage);

            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득


            // 아이템 내 각 위젯에 데이터 반영

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return MainActivity.displaygameimage.get(position);
        }

        // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    }

}


