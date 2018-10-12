/**
 * Author: Duong Minh Kiet
 * */
package com.example.duongminhkiet.myapplication.object;

public class Item {
    private int row;//row in array
    private int col;//colume in array
    private int value;// 0: empty, 1: existing ( first time = 1 )
    private int numberContact;//amount facing with other item ( user )

    @Override
    public String toString() {
        return "ROW: "+row+"  COL: "+col+"  value: "+value+" numberContact: "+numberContact;
    }

    public Item(){

    }
    public Item(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(int numberContact) {
        this.numberContact = numberContact;
    }
    public void increaseNumberContact1(){
        this.numberContact++;
    }
}
