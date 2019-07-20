package com.example.a2506app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

class ChatAdapter extends BaseExpandableListAdapter {

    Context Context;
    ArrayList<Chatlist> chatlists;


    public ChatAdapter(MainActivity mainActivity, ArrayList<Chatlist> arrayChatList) {
        this.chatlists = arrayChatList;
    }

    @Override
    public int getGroupCount() {
        return chatlists.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return chatlists.get(groupPosition).getChildlists().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return chatlists.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return chatlists.get(groupPosition).getChildlists().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) Context.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_chat,null);
        ImageView iv = convertView.findViewById(R.id.custom_chat_iv);
        TextView name = convertView.findViewById(R.id.custom_chat_name);

        name.setText(chatlists.get(groupPosition).getName());
        iv.setImageResource(chatlists.get(groupPosition).getImages());
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) Context.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_child,null);
        ImageView iv = convertView.findViewById(R.id.custom_child_iv);
        TextView name = convertView.findViewById(R.id.custom_child_name);

        name.setText(chatlists.get(groupPosition).getName());
        iv.setImageResource(chatlists.get(groupPosition).getImages());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
