/**
 * Author: Duong Minh Kiet
 * */
package com.example.duongminhkiet.myapplication.object;

import java.util.ArrayList;

public class Room {
    private int[] inArr;
    private ArrayList<Item> mArrItem;
    private int amountUsers;
    private int valueFacing;

    public Room() {

    }

    public Room(ArrayList<Item> mArrItem, int amountUsers) {
        this.mArrItem = mArrItem;
        this.amountUsers = amountUsers;
    }

    public ArrayList<Item> getmArrItem() {
        return mArrItem;
    }

    public void setmArrItem(ArrayList<Item> mArrItem) {
        this.mArrItem = mArrItem;
    }

    public int getAmountUsers() {
        return amountUsers;
    }

    public void setAmountUsers(int amountUsers) {
        this.amountUsers = amountUsers;
    }

    public int getValueFacing() {
        return valueFacing;
    }

    public void setValueFacing(int valueFacing) {
        this.valueFacing = valueFacing;
    }
    public void increaseValueFacing1(){
        this.valueFacing++;
    }

    public int[] getInArr() {
        return inArr;
    }

    public void setInArr(int[] inArr) {
        this.inArr = inArr;
    }
    public String getInArrString(){
        String str = "[";
        if(inArr.length==3){
            int row = inArr[0];
            int col = inArr[1];
            int users = inArr[2];
            str+=""+row+","+col+","+users+"]";

        }
        return str;
    }
}
