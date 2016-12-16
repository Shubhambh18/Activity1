package com.example.mindfak3.activity1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Button b2;
    String e1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent j=getIntent();
        e1=j.getStringExtra("e1");
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(SecondActivity.this,MainActivity.class);
                Bundle bundle=getIntent().getExtras();
                String message=bundle.getString("send_message");
                Toast.makeText(getApplicationContext(),"Hello "+message,Toast.LENGTH_LONG).show();
                startActivity(k);

            }
        });
    }
}
