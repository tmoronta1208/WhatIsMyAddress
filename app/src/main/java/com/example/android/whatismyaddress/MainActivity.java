package com.example.android.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private EditText editText;
    private SharedPreferences input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.edit_text);

        input = getApplicationContext().getSharedPreferences("address_shared_preferences", MODE_PRIVATE);

        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = input.edit();
                editor.putString("email address", editText.getText().toString());
                editor.commit();
                editText.setText("");


            }
        });


        button2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra("sharedpref", "address_shared_preferences");
                startActivity(intent);

            }
        });

    }
}
