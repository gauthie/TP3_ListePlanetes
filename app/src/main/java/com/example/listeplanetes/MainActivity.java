package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    protected ArrayList<Data> planetes;
    protected ListView listview;
    protected PlaneteAdapter adapter;
    protected Data data;
    protected Button btnCheck;
    protected Spinner spinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listView);
        data = new Data();
        adapter = new PlaneteAdapter(this, data);
        listview.setAdapter(adapter);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setEnabled(false);
        btnCheck.setOnClickListener(btnCkeckOnClickListener);
    }

    View.OnClickListener btnCkeckOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            int i = 0;
            String[] tailles = data.getTaillePlanete();

            for (int j = 0; j < tailles.length; j++) {
                v = listview.getChildAt(j);
                spinner = v.findViewById(R.id.spinner);
                String taille = spinner.getSelectedItem().toString();
                if (taille.equals(tailles[j])) {
                    i++;
                }
            }
            Toast.makeText(MainActivity.this, i + " on " + tailles.length, Toast.LENGTH_LONG).show();
        }
    };
}