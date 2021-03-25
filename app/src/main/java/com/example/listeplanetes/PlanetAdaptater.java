package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

class PlaneteAdapter extends BaseAdapter {

    private final MainActivity mainActivityContext;
    private Data data;
    private ArrayList<Planete> planetes;
    public static int nb = 0;

    public PlaneteAdapter(MainActivity mainActivityContext, Data planetes){
        this.planetes = data.getPlanetes();
        this.data = data;
        this.mainActivityContext = mainActivityContext;
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

    public int getViewCount(){
        return getCount();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inf.inflate(R.layout.listitem, null);
        }
        final TextView planetName = itemView.findViewById(R.id.textView);
        final CheckBox checkbox = itemView.findViewById(R.id.checkbox);
        final Spinner spinner = itemView.findViewById(R.id.spinner);

        planetName.setText(this.planetes.get(position).getNom());

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(mainActivityContext, android.R.layout.simple_spinner_item, data.getTaillePlanete());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkbox.setOnCheckedChangeListener((compoundButton, b)-> {
            CheckBox checkBox = compoundButton.findViewById(R.id.checkbox);
            spinner.setEnabled(!checkbox.isChecked());
            if(checkBox.isChecked()){
                nb++;
            }
            else{
                nb--;
            }

            Button btn = mainActivityContext.btnCheck;

            if(nb == planetes.size()){
                btn.setEnabled(true);
            }
            else{
                btn.setEnabled(false);
            }
        });
        return itemView;
    }
}