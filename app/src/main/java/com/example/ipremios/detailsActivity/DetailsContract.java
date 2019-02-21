package com.example.ipremios.detailsActivity;


import com.example.ipremios.model.listItem.ItensItem;

public interface DetailsContract  {

    interface presenter {

        void getItem(ItensItem itensItem);

    }

    interface DetailsView {

        void displayText(ItensItem itensItem);

    }
}
