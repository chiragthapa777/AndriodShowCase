package com.example.andriodshowcase.activities.layout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.andriodshowcase.R;

public class RelativeLayoutExample extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        System.out.println("check");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_example);
    }
}
