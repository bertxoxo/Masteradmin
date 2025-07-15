package com.masteradmin.app;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SleepLogAdapter extends BaseAdapter {
    private final Activity context;
    private final ArrayList<String> logs;

    public SleepLogAdapter(Activity context, ArrayList<String> logs) {
        this.context = context;
        this.logs = logs;
    }

    @Override
    public int getCount() {
        return logs.size();
    }

    @Override
    public Object getItem(int position) {
        return logs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_sleep_log, null, true);

        TextView logText = rowView.findViewById(R.id.logText);
        logText.setText(logs.get(position));

        return rowView;
    }
      }
