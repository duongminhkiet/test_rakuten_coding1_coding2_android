/**
 * Author: Duong Minh Kiet
 * */
package com.example.duongminhkiet.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.duongminhkiet.myapplication.helper.CommonHelper;
import com.example.duongminhkiet.myapplication.object.Room;

import java.util.ArrayList;

public class CodingTest2 extends AParent {
    private ArrayList<int []> mArrdata;
    private TextView id_tv;
    String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding_test2);
        commonFunction();
        new DataInput().execute();

    }
    private class DataInput extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showLoading();
        }
        @Override
        protected Void doInBackground(Void... params) {
            mArrdata = CommonHelper.getArrayIntFromAssetJsonFile(CodingTest2.this,"data.json");
            for(int[] myList : mArrdata){
                Room room =  CommonHelper.processData(myList);
                str+=""+room.getInArrString()+"  =>  "+room.getValueFacing() +"\n";
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void param) {
            disMissLoading();
            showData();
        }
    }
    private void showData(){


        id_tv.setText(str);
    }
    @Override
    protected void initComponent() {
        id_tv = (TextView)findViewById(R.id.id_tv);
    }

    @Override
    protected void addListener() {

    }
    public void exampleTest(){
        //        int[] myList = {1,16,1};
//        Room room =  CommonHelper.initRoom(myList);
//        CommonHelper.calculateAmountFacingEachItemInRoom(room);
//        CommonHelper.showAmountFacingEachItemInRoom(room);
//        CommonHelper.calculateOptimizePositionInRoom(room);
    }
}
