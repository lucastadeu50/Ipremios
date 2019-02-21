package com.example.ipremios.detailsActivity;


import com.example.ipremios.model.listItem.Item;
import com.example.ipremios.model.listItem.ItensItem;

public class DetailsPresenterImpl implements DetailsContract.presenter{
    private DetailsContract.DetailsView detailsView;

    public DetailsPresenterImpl(DetailsContract.DetailsView detailsView) {
        this.detailsView = detailsView;
    }

    @Override
    public void getItem(ItensItem itensItem) {
        detailsView.displayText(itensItem);
    }
}
