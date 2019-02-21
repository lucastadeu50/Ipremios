package com.example.ipremios.detailsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ipremios.R;
import com.example.ipremios.model.listItem.ItensItem;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.DetailsView{

    ItensItem itensItem;
    TextView textViewTitle;
    TextView textViewDescription;
    ImageView imageViewMedium;
    Context context = DetailsActivity.this;

    private DetailsContract.presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        itensItem = getIntent().getParcelableExtra("itens");



        textViewTitle = findViewById(R.id.textViewTitle);
        textViewDescription = findViewById(R.id.textViewDescription);
        imageViewMedium = findViewById(R.id.imageViewMedium);

        presenter = new DetailsPresenterImpl(this);
        presenter.getItem(itensItem);



    }

    @Override
    public void displayText(ItensItem itensItem) {
        textViewTitle.setText(itensItem.getTitle());
        textViewDescription.setText(itensItem.getDescription());
        Glide.with(context)
                .asBitmap()
                .load(itensItem.getImageMedium())
                .into(imageViewMedium);
    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
