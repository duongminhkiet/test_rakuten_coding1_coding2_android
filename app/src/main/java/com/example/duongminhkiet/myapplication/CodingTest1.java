/**
 * Author: Duong Minh Kiet
 * */
package com.example.duongminhkiet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CodingTest1 extends AParent {

    private Button id_btn_increase_number;
    private TextView sample_text;
    public native int numberFromJNIC();
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding_test1);
        commonFunction();

        sample_text.setText(String.valueOf(numberFromJNIC()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btn_increase_number:
                sample_text.setText(String.valueOf(numberFromJNIC()));
                break;
            default: break;
        }
    }

    @Override
    protected void initComponent() {
        sample_text = (TextView) findViewById(R.id.sample_text);
        id_btn_increase_number = (Button)findViewById(R.id.id_btn_increase_number);
    }

    @Override
    protected void addListener() {
        id_btn_increase_number.setOnClickListener(this);
    }
}
