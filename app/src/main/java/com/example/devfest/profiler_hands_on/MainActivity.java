package com.example.devfest.profiler_hands_on;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.devfest.profiler_hands_on.cpu.CpuProfileActivity;
import com.example.devfest.profiler_hands_on.memory.MemoryProfileActivity;
import com.example.devfest.profiler_hands_on.network.retrofit2.NetworkProfileActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cpu_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CpuProfileActivity.class));
            }
        });
        findViewById(R.id.memory_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MemoryProfileActivity.class));
            }
        });
        findViewById(R.id.network_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NetworkProfileActivity.class));
            }
        });
    }
}
