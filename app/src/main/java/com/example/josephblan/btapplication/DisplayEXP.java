package com.example.josephblan.btapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayEXP extends AppCompatActivity {
    ListView lvEXP;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_exp2);

        Toast.makeText(this, "display", Toast.LENGTH_SHORT).show();

        lvEXP = findViewById(R.id.listViewEXP);
    }
}