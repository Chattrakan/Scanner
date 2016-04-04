package com.example.user.scanner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        String txt = getIntent().getStringExtra("txt");
        TextView txt1 = (TextView) findViewById(R.id.txt);

        String a []= txt.split(";");
        txt1.setText("Data : "+ a[1]);
    }


}
