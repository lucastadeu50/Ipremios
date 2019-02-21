package com.example.ipremios.mainActivity;



import com.example.ipremios.model.listItem.Item;
import com.example.ipremios.network.NetworkClient;
import com.example.ipremios.network.NetworkInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetDataInteractorImpl implements MainContract.GetDataIntractor {


    @Override
    public void getDataList(final OnFinishedListener onFinishedListener, String token) {
        NetworkInterface networkInterface = NetworkClient.getRetrofit().create(NetworkInterface.class);





        final Call<Item> call = networkInterface.getData(token);

        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {

                if (response.isSuccessful()) {
                    onFinishedListener.onFinished(response.body().getItens());
                }
            }
            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
