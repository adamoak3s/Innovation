package com.example.innovation4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doTheThing();
    }

    private void doTheThing() {
        textView = (TextView) this.findViewById(R.id.textView);

        HttpCall httpCallPost = new HttpCall();
        httpCallPost.setUrl("http://192.168.60.169:8080/www/sgs");

        //Eric -> just set the variable from an input element
        String id = "adam";
        httpCallPost.setId(id);

        new HttpRequest(){
            @Override
            public void onResponse(String response) {
                super.onResponse(response);
                textView.setText(textView.getText()+"\nPost:"+response);
            }

        }.execute(httpCallPost);
    }
}