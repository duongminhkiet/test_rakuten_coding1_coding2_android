/**
 * Author: Duong Minh Kiet
 * */
package com.example.duongminhkiet.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class AParent extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onClick(View v) {

    }
    protected abstract void initComponent();

    protected abstract void addListener();
    public void commonFunction(){
        initComponent();
        addListener();
    }
    private ProgressDialog dialogLoading;
    public void showLoading() {
        if (dialogLoading != null) {
            dialogLoading.dismiss();
        }
        if (dialogLoading == null) {
            dialogLoading = new ProgressDialog(this);
        }
        dialogLoading.setTitle(this.getResources().getString(R.string.app_name));
        dialogLoading.setMessage(getString(R.string.app_name));
        dialogLoading.setCanceledOnTouchOutside(false);
        dialogLoading.setCancelable(false);
        dialogLoading.show();
    }

    public void disMissLoading() {

        if (dialogLoading != null) {
            dialogLoading.dismiss();
        }
    }
}
