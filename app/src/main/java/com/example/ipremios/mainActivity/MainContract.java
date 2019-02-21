package com.example.ipremios.mainActivity;

import com.example.ipremios.model.listItem.Item;
import com.example.ipremios.model.listItem.ItensItem;

import java.util.List;

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface presenter{

        void onButtonClick(String token);

        void requestDataFromServer(String token);

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {

        void setDataToRecyclerView(List<ItensItem> itens);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetDataIntractor {

        interface OnFinishedListener {
            void onFinished(List<ItensItem> itens);
            void onFailure(Throwable t);
        }

        void getDataList(OnFinishedListener onFinishedListener, String token);
    }
}
