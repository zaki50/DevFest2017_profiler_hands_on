package com.example.devfest.profiler_hands_on.network.retrofit2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.devfest.profiler_hands_on.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class NetworkProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_network_profile);

        final GoogleRepositoryService googleRepositoryApi = createRepositoryApi();
        findViewById(R.id.fetch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Call<String> request = googleRepositoryApi.listGroups();
                request.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                        final String bodyString = response.body();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(NetworkProfileActivity.this, bodyString, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull Call<String> call, @NonNull final Throwable t) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(NetworkProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }

    private GoogleRepositoryService createRepositoryApi() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.google.com/dl/android/maven2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit.create(GoogleRepositoryService.class);
    }
}
