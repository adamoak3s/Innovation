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
        textView = (TextView) this.findViewById(R.id.textView);

        HashMap<String,String> params = new HashMap<>();
        HttpCall httpCallPost = new HttpCall();
        httpCallPost.setMethodtype(HttpCall.POST);
        httpCallPost.setUrl("http://192.168.60.169:8080/www/sgs");
        HashMap<String,String> paramsPost = new HashMap<>();
        params.put("command","get_stb_notification");
        params.put("receiver","XTJ191170439614");
        params.put("cid","65535");
        Log.e("adam", "\n\n\nabout to send POST...\n\n\n");
        httpCallPost.setParams(params);
        new HttpRequest(){
            @Override
            public void onResponse(String response) {
                super.onResponse(response);
                textView.setText(textView.getText()+"\nPost:"+response);
            }
        }.execute(httpCallPost);
        Log.e("adam", "\n\n\nPOST *should* be sent...\n\n\n");
    }
}