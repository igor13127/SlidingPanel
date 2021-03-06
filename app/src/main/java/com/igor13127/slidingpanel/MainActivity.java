package com.igor13127.slidingpanel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.igor13127.slidingpanelmodule.DragLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();

        final List<String> stringList = new ArrayList<>();

        stringList.clear();

        for (int i = 0 ; i < 50 ; i++){
            stringList.add("Line : " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, stringList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
                    }
                });

                return view;
            }
        };

        ListView listView = (ListView)findViewById(R.id.listView);
        if (listView != null) {
            listView.setAdapter(adapter);
        }

        DragLayout dragLayout = (DragLayout)findViewById(R.id.DragLayout);
        dragLayout.setScrollableView(listView);
        dragLayout.setTouchEnabled(true);
    }
}
