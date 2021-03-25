package com.example.listeplanetes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

class PlaneteAdapter extends BaseAdapter {

    private Data planetes;
    private LayoutInflater inflater;
    private ArrayAdapter<String> spinadapter;

    public PlaneteAdapter(Context context, Data planetes){
        this.planetes = planetes;
        this.inflater = LayoutInflater.from(context);
        this.spinadapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, planetes.getTaillePlanete());
    }

    public int getCount() {
        return planetes.size();
    }

    public Object getItem(int i) {
        return planetes.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View itemView = convertView;
        if (convertView == null) {
            holder = new ViewHolder();
            itemView = inflater.inflate(R.layout.listitem, null);
            holder.nomPlanete = (TextView) itemView.findViewById(R.id.textView);
            holder.checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            holder.spinner = (Spinner) itemView.findViewById(R.id.spinner);
            itemView.setTag(holder);
        }else{
            holder = (ViewHolder)itemView.getTag();
        }
        holder.nomPlanete.setText(planetes.get(position).getNom());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner.setAdapter(spinadapter);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {
                    holder.spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();
                } else {
                    holder.spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                }
            }
        });
        return itemView;
    }

    private class ViewHolder{
        ArrayAdapter<String> spinadapter;
        TextView nomPlanete;
        CheckBox checkBox;
        Spinner spinner;
    }



}