package com.example.devfest.profiler_hands_on.memory;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.devfest.profiler_hands_on.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MemoryProfileActivity extends AppCompatActivity {

    private static List<String> leakingList = new ArrayList<>();

    @SuppressLint("HandlerLeak")
    private Handler leakingHandler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MemoryProfileActivity.this, (String) msg.obj, Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_profile);

        findViewById(R.id.leak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String message = "leaking " + leakingList.size();
                leakingList.add(message);
                new MyThread(leakingHandler, message).start();
            }
        });
    }
}

class MyThread extends Thread {
    private final Handler handler;

    private final String message;

    public MyThread(Handler handler, String message) {
        this.handler = handler;
        this.message = message;
    }

    @Override
    public void run() {
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(20));
        handler.sendMessage(handler.obtainMessage(0, message));
    }
}

