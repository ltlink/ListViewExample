package com.example.service_admin.listviewexample;

import android.content.Context;

import java.util.List;

public class DatabaseAdapter {

    DatabaseHelper helper;
    public DatabaseAdapter(Context context) {
        this.helper = new DatabaseHelper(context,"ListViewExample",null,1);
    }

    public List<Item> getItemList(){
        return helper.getItemList();
    }

    public void addItem(Item item){
        helper.addItem(item);
    }
}
