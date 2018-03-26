package com.fengwenyi.app.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fengwenyi.app.simple.tool.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.loading(this);
    }
}
