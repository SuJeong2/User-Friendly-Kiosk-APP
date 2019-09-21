package com.example.user_friendly_kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Menu extends AppCompatActivity {

    GridView gridView;
    TextView textView;

    int gender, age;
    String genderValue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //사용자의 나이와 성별의 데이터 값을 받아옴
        Intent intent = getIntent();
        gender = intent.getExtras().getInt("gender");
        age = intent.getExtras().getInt("age");

        /*
        테스트를 위해 일단 넣어봄
         */
        if(gender==0){
            genderValue="남자";
        }
        else  genderValue="여자";

        ListView listview = (ListView)findViewById(R.id.listview);

        //초기 메뉴 화면은 추천 메뉴
        textView = (TextView)findViewById(R.id.selectedMenu);
        textView.setText(age+"살의 "+genderValue+"인 손님이 많이 시킨 메뉴 입니다");

        gridView = (GridView) findViewById(R.id.gridView);
        /*
        나이가 많을 경우 -> column수를 줄여서 아이템이 크게 보이게 함
        나이가 어릴 경우 -> column수를 늘려서 아이템 크기를 작게 함

        현재는 나이가 많을 경우를 age>50으로 잡음
         */
        if(age>50){
            gridView.setNumColumns(3);
        }

        gridAdapter itemAdapter = new gridAdapter(getLayoutInflater(), 0);
        gridView.setAdapter(itemAdapter);

        //메뉴 리스트를 strings.xml에서 가져옴
        String[] menu_list=getResources().getStringArray(R.array.list_items);
        String[] menu_list_for_older=getResources().getStringArray(R.array.list_items_for_older);
        //데이터를 저장하게 되는 리스트
        /*
        이 부분은 strings.xml에 스트링 배열을 만들어서 한꺼번에 가져오도록 만듬
        List<String> list = new ArrayList<>();
        //리스트뷰에 보여질 아이템을 추가
        list.add("추천 메뉴");
        list.add("햄버거");
        list.add("사이드메뉴");
        list.add("파이");
        */

        //리스트뷰와 리스트를 연결하기 위해 사용되는 어댑터
        ArrayAdapter<String> adapter;

        /*
        나이가 많을 경우 --> 글자 크기가 큰 list view 사용 + 메뉴 이름을 쉽게 바꿈

        글자 크기가 큰 list view 사용 --> custom list view, 글자 크기를 키운 리스트뷰를 사용하고 싶음 -->아직은 못함
        메뉴 이름을 쉽게 바꿈 --> strings.xml에 menu_list_for_older이라는 배열에 넣어서 사용
         */
        if(age>50){
            adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu_list_for_older);
            listview.setAdapter(adapter);
        }

        else{
            //리스트뷰의 어댑터를 지정해준다.
            adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu_list);
            listview.setAdapter(adapter);
        }

        //리스트뷰의 아이템을 클릭시 해당 아이템의 문자열을 가져오기 위한 처리
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                //클릭한 아이템의 문자열을 가져옴
                String selected_item = (String)adapterView.getItemAtPosition(position);
                if(position==0){
                    textView.setText(age+"살의 "+genderValue+"인 손님이 많이 시킨 메뉴 입니다");
                }
                else textView.setText(selected_item);

                gridAdapter itemAdapter = new gridAdapter(getLayoutInflater(), position);
                gridView.setAdapter(itemAdapter);
            }
        });

    }
}

