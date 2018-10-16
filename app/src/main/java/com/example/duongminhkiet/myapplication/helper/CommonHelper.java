/**
 * Author: Duong Minh Kiet
 * */
package com.example.duongminhkiet.myapplication.helper;

import android.content.Context;

import com.example.duongminhkiet.myapplication.object.Item;
import com.example.duongminhkiet.myapplication.object.Room;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CommonHelper {
    public static Room processData(int[] arr) {
        Room room = CommonHelper.initRoom(arr);
        calculateAmountFacingEachItemInRoom(room);
        calculateOptimizePositionInRoom(room);
        room.setInArr(arr);//just for show text on UI
        return room;
    }

    //init Room from int array
    private static Room initRoom(int[] arr) {
        ArrayList<Item> mArrItem = new ArrayList<>();
        int users = 0;
        if (arr.length == 3) {
            int row = arr[0];
            int col = arr[1];
            users = arr[2];
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    Item item = new Item();
                    item.setRow(i);
                    item.setCol(j);
                    item.setValue(1);//default
                    item.setNumberContact(0);
                    mArrItem.add(item);
                }
            }

        }
        return new Room(mArrItem, users);
    }

    private static int checkItemExistingInArrayWithValue(ArrayList<Item> mArr, Item item) {
        for (Item x : mArr) {
            if ((item.getRow() == x.getRow()) && (item.getCol() == x.getCol())) {
                return x.getValue();
            }
        }
        return 0;//not existing
    }

    //calculate amount facing each item ( maximum is 4 )
    private static void calculateAmountFacingEachItemInRoom(Room room) {
        ArrayList<Item> mArr = room.getmArrItem();
        for (Item x : mArr) {
            if (x.getValue() != 0) {
                Item left = new Item(x.getRow(), x.getCol() - 1);
                Item top = new Item(x.getRow() - 1, x.getCol());
                Item right = new Item(x.getRow(), x.getCol() + 1);
                Item bottom = new Item(x.getRow() + 1, x.getCol());
                if (checkItemExistingInArrayWithValue(mArr, left) != 0) {
                    x.increaseNumberContact1();
                }
                if (checkItemExistingInArrayWithValue(mArr, top) != 0) {
                    x.increaseNumberContact1();
                }
                if (checkItemExistingInArrayWithValue(mArr, right) != 0) {
                    x.increaseNumberContact1();
                }
                if (checkItemExistingInArrayWithValue(mArr, bottom) != 0) {
                    x.increaseNumberContact1();
                }
            } else {
                x.setNumberContact(0);
            }
        }
    }

    private static void calculateOptimizePositionInRoom(Room room) {
        int maxUsers = room.getmArrItem().size();
        int realUsers = room.getAmountUsers();
        if (realUsers <= maxUsers) {
            int amountItemEmpty = maxUsers - realUsers;
            int i = 0;
            while (amountItemEmpty - i > 0) {
                i++;
                Item itemFoundMaxNumberContact = sortByNumberContactDESC(room);//find optimize item
                itemFoundMaxNumberContact.setValue(0);

                //reset numberContact
                resetNumberContact(room);//reset Number Contact
                calculateAmountFacingEachItemInRoom(room);//re-Calculate

            }

            calculateResult(room);
        }
    }


    private static void resetNumberContact(Room room) {
        ArrayList<Item> mArr = room.getmArrItem();
        for (Item it : mArr) {
            it.setNumberContact(0);
        }
    }

    private static void calculateResult(Room room) {
        ArrayList<Item> mArr = room.getmArrItem();

        for (Item x : mArr) {
            if (x.getValue() != 0) {
                Item right = new Item(x.getRow(), x.getCol() + 1);
                Item bottom = new Item(x.getRow() + 1, x.getCol());
                if (checkItemExistingInArrayWithValue(mArr, right) != 0) {
                    room.increaseValueFacing1();
                }
                if (checkItemExistingInArrayWithValue(mArr, bottom) != 0) {
                    room.increaseValueFacing1();
                }
            }

        }
    }

    private static Item sortByNumberContactDESC(Room room) {
        Object mArr = room.getmArrItem().clone();
        Collections.sort((ArrayList) mArr, new Comparator<Item>() {
            @Override
            public int compare(Item it1, Item it2) {
                if (it1.getNumberContact() < it2.getNumberContact()) {
                    return 1;
                } else {
                    if (it1.getNumberContact() == it2.getNumberContact()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
        Item itemMaxNumberContact = (Item) ((ArrayList) mArr).get(0);//item with index 0 have highest contact number

        return itemMaxNumberContact;
    }

    //processing data input by json file
    public static ArrayList<int[]> getArrayIntFromAssetJsonFile(Context ct, String fileName) {
        ArrayList<int[]> mArr = new ArrayList<>();
        String json = loadJSONFromAsset(ct, fileName);
        JSONArray jsonArr = null;
        try {
            jsonArr = new JSONArray(json);

        } catch (Exception e1) {
            System.out.print(e1.getMessage());
        }
        if (jsonArr != null && jsonArr.length() > 0) {
            for (int n = 0; n < jsonArr.length(); n++) {
                try {
                    JSONArray jr = jsonArr.getJSONArray(n);
                    String[] resultingArray = jr.join(",").split(",");
                    int[] ari = StringArrToIntArr(resultingArray);
                    mArr.add(ari);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }
        return mArr;
    }

    private static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    private static String loadJSONFromAsset(Context ct, String fileName) {
        String json = null;
        try {
            InputStream is = ct.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
