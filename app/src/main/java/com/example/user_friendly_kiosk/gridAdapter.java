package com.example.user_friendly_kiosk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class gridAdapter extends BaseAdapter {
    LayoutInflater inflater;

    ArrayList<String> textArr = new ArrayList<>();
    ArrayList<Integer> picArr = new ArrayList<Integer>();

    public gridAdapter(LayoutInflater layoutInflater, int selectedList) {
        this.inflater=layoutInflater;

        //여기서 디비에 저장된 메뉴 사진과 이름을 받아서 저장하면 됨

        switch (selectedList){
            case 0:
                for (int i = 0 ; i < 9 ; i++) {
                    picArr.add(R.drawable.buger);
                    textArr.add("추천메뉴" + Integer.toString(i));
                }
                break;

            case 1:
                for (int i = 0 ; i < 9 ; i++) {
                    picArr.add(R.drawable.buger);
                    textArr.add("햄버거" + Integer.toString(i));
                }
                break;

            case 2:
                for (int i = 0 ; i < 9 ; i++) {
                    picArr.add(R.drawable.buger);
                    textArr.add("사이드메뉴" + Integer.toString(i));
                }
                break;

            case 3:
                for (int i = 0 ; i < 9 ; i++) {
                    picArr.add(R.drawable.buger);
                    textArr.add("파이" + Integer.toString(i));
                }
                break;
        }
    }

    @Override
    public int getCount() {
        return picArr.size();
    }

    @Override
    public Object getItem(int position) {
        return picArr.get(position);    //아이템을 호출할 때 사용하는 메소드
    }

    @Override
    public long getItemId(int position) {
        return position;    //아이템의 아이디를 구할 때 사용하는 메소드
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.itmes, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        final TextView textView;
        textView = (TextView) convertView.findViewById(R.id.textView);

        //디비에서 불러온 사진과 메뉴 이름을 여기에 붙임
        imageView.setImageResource(picArr.get(position));
        textView.setText(textArr.get(position));


        imageView.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {
                // TODO Auto-generated method stub
                // 메뉴 사진(이미지뷰)를 터치했을때 동작하는 곳
                textView.setText("hihihii");

            }

        });

        textView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // 메뉴 이름(텍스트뷰) 터치했을때 동작하는 곳
                textView.setText("byebye");
            }
        });

        return convertView;
    }
}
