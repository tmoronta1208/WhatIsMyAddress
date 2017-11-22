package com.example.android.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by TatianaM on 11/21/17.
 */

public class RecyclerActivity extends AppCompatActivity {

    private SharedPreferences recyclerpref;
    private TextView itemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        recyclerpref = getApplicationContext().getSharedPreferences(getIntent().getStringExtra("shared_pref"), MODE_PRIVATE);


        //The code below i looked up on the internet - not familiar with the question mark but didn't have enough time to change it
        ArrayList<String> inputArray = new ArrayList<>();
        Map<String, ?> allinput = recyclerpref.getAll();
        for (Map.Entry<String, ?> entry : allinput.entrySet()) {
            inputArray.add(String.valueOf(allinput.entrySet()));
            Log.d("allinput values", entry.getKey() + ": " + entry.getValue().toString());

            RecyclerView sharedPrefRecycle = (RecyclerView) findViewById(R.id.sharedPref_recyclerview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            itemView = (TextView) findViewById(R.id.itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RecyclerActivity.this, DisplayActivity.class);

                    startActivity(intent);
                }
            });



        }
    }
}
