/**
 * Author: Duong Minh Kiet
 * */
package com.example.duongminhkiet.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.duongminhkiet.myapplication.helper.CommonHelper;
import com.example.duongminhkiet.myapplication.object.Item;
import com.example.duongminhkiet.myapplication.object.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AParent{


    private Button id_btn_1,id_btn_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        commonFunction();




    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btn_1:
                startActivity(new Intent(getApplicationContext(),CodingTest1.class));
                break;
            case R.id.id_btn_2:
                startActivity(new Intent(getApplicationContext(),CodingTest2.class));
                break;
            default: break;
        }
    }

    @Override
    protected void initComponent() {
        id_btn_1 = (Button)findViewById(R.id.id_btn_1);
        id_btn_2 = (Button)findViewById(R.id.id_btn_2);
    }

    @Override
    protected void addListener() {
        id_btn_1.setOnClickListener(this);
        id_btn_2.setOnClickListener(this);
    }
}
