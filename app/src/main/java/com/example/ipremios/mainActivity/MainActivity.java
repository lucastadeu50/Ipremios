package com.example.ipremios.mainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ipremios.R;
import com.example.ipremios.model.listItem.ItensItem;


import java.util.List;


public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private static final String TAG = "MainActivity";
    private static final String BEARER = "Bearer ";

    private RecyclerView recyclerView;

    private MainContract.presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeRecyclerView();

        SharedPreferences sharedPreferences = getSharedPreferences("mysettings",
                Context.MODE_PRIVATE);
        String accessToken = sharedPreferences.getString(getString(R.string.accessToken), "");
        Log.d(TAG, "onCreate: mystring " + accessToken);

        String token = BEARER + accessToken;

        presenter = new MainPresenterImpl(this, new GetDataInteractorImpl());
        presenter.requestDataFromServer(token);


    }

    private void initializeRecyclerView() {


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public void setDataToRecyclerView(List<ItensItem> itens) {
        ListAdapter adapter = new ListAdapter(MainActivity.this, itens);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }
}
