package com.example.ipremios.mainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ipremios.R;
import com.example.ipremios.model.listItem.Item;
import com.example.ipremios.network.NetworkClient;
import com.example.ipremios.network.NetworkInterface;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String BEARER = "Bearer ";

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SharedPreferences sharedPreferences = getSharedPreferences("mysettings",
                Context.MODE_PRIVATE);
        String accessToken = sharedPreferences.getString(getString(R.string.accessToken), "");
        Log.d(TAG, "onCreate: mystring " + accessToken);


        recyclerView = findViewById(R.id.recyclerView);

        String token = BEARER + accessToken;

        NetworkInterface networkInterface = NetworkClient.getRetrofit().create(NetworkInterface.class);


        final Call<Item> call = networkInterface.getData(token);

        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {

                if (response.isSuccessful()) {
                    Item item = response.body();
                    Log.d(TAG, "onResponse: " + item.getItens().get(0).getTitle());
                    ListAdapter adapter = new ListAdapter(MainActivity.this, item.getItens());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
            }
            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }

}
