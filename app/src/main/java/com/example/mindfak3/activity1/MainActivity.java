package com.example.mindfak3.activity1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        //e1=(EditText)findViewById(R.id.editText1) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               EditText txtEmail = (EditText)findViewById(R.id.editText1);
                if(validateEmail(txtEmail.getText().toString())) {
                    String message=txtEmail.getText().toString();

                    Intent j = new Intent(MainActivity.this, SecondActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("send_message",message);
                    j.putExtras(bundle);



                    startActivity(j);
                }else{
                    Toast.makeText(getApplicationContext(),"Enter valid email address",Toast.LENGTH_LONG).show();
                }
            }
        });
    }







    public boolean validateEmail(String strEmail) {
        Matcher matcher;
        String EMAIL_PATTERN = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
                + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
                + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(strEmail);
        return matcher.matches();
    }

}
