package com.example.josephblan.btapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Display_EXP extends Activity {
    ListView lvEXP;
    ArrayList<EXP> ary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_exp);
        Toast.makeText(this, "display", Toast.LENGTH_SHORT).show();

        lvEXP = findViewById(R.id.listViewEXP);
        Dal dal = new Dal(this);
        ary = dal.getAllEXP();
        Toast.makeText(this, "size="+ary.size()+"", Toast.LENGTH_SHORT).show();


        EXP_Adapter ad = new EXP_Adapter(this, R.layout.exp_layout, ary);
        lvEXP.setAdapter(ad);

        lvEXP.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent i = new Intent();
            //i = new Intent(this, Graphs_page.class);
        }
    };
}