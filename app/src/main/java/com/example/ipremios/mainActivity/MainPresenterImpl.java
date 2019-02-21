package com.example.ipremios.mainActivity;

import com.example.ipremios.model.listItem.ItensItem;
import com.example.ipremios.model.responsePost.Token;

import java.util.List;

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetDataIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetDataIntractor getDataIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetDataIntractor getDataIntractor) {
        this.mainView = mainView;
        this.getDataIntractor = getDataIntractor;
    }


    @Override
    public void requestDataFromServer(String token) {
        getDataIntractor.getDataList(this, token);
    }


    @Override
    public void onFinished(List<ItensItem> itens) {
        if (mainView != null) {
            mainView.setDataToRecyclerView(itens);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (mainView != null) {
            mainView.onResponseFailure(t);
        }
    }

}
