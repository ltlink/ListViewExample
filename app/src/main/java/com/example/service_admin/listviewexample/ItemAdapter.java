package com.example.service_admin.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private final Context context;
    List<Item> itemList;
    LayoutInflater layoutInflater;
    DatabaseAdapter databaseAdapter;
    public ItemAdapter(List<Item> itemList, Context context, DatabaseAdapter databaseAdapter){
        this.itemList = itemList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.databaseAdapter = databaseAdapter;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder holder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item_layout,null);
        }
        holder = new ItemViewHolder(convertView);
        Item item = this.itemList.get(position);

        holder.imgView.setImageResource(item.imageId);
        holder.nameView.setText(item.name);
        holder.descriptionView.setText(item.description);

        return convertView;
    }

    public void AddItem(Item item){
        this.itemList.add(item);
        databaseAdapter.addItem(item);
        this.notifyDataSetChanged();
    }

    static class ItemViewHolder{
            ImageView imgView;
            TextView nameView;
            TextView descriptionView;

        public ItemViewHolder(View view) {
            imgView = view.findViewById(R.id.ImgItem);
            nameView = view.findViewById(R.id.txtName);
            descriptionView = view.findViewById(R.id.textDescription);
        }
    }
}
