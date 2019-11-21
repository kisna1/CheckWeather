package com.org.checkweather.view.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.org.checkweather.R;
import com.org.checkweather.network.client.APIClient;
import com.org.checkweather.network.interfaces.APIInterface;
import com.org.checkweather.view.adapters.ExcursionAdapter;
import com.org.checkweather.view.model.Excursion;

import java.util.ArrayList;
import java.util.List;

public class ExcursionActivity extends AppCompatActivity {

    private static final int ADD_EXCURSION_REQUEST = 1 ;
    private static final String TAG = ExcursionActivity.class.getSimpleName();
    private RecyclerView rcyExcursion;
    private RecyclerView.Adapter addExcursionAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Excursion> excursionList;

    private FloatingActionButton fabAddExcursion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion);

        actionBarSetting("Excursions", "");

        rcyExcursion = findViewById(R.id.rcyExcursion);

        fabAddExcursion = findViewById(R.id.fabAddExcursion);

        layoutManager = new LinearLayoutManager(this);
        rcyExcursion.setLayoutManager(layoutManager);
        rcyExcursion.setItemAnimator(new DefaultItemAnimator());
        excursionList = new ArrayList<>();

        addExcursionAdapter = new ExcursionAdapter(ExcursionActivity.this, excursionList);
        rcyExcursion.setAdapter(addExcursionAdapter);

        fabAddExcursion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExcursionActivity.this, ExcursionFormActivity.class);
                startActivityForResult(intent, ADD_EXCURSION_REQUEST);
            }
        });

    }

    private void actionBarSetting(String Title, String subTitle) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View lView = mInflater.inflate(R.layout.toolbar_custom, null);
        mActionBar.setCustomView(lView);
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        mActionBar.setDisplayShowCustomEnabled(true);
        TextView lTitle = lView.findViewById(R.id.txt_title);
        lTitle.setText(Title);
        ImageView lBack = lView.findViewById(R.id.img_back);

        TextView lSubTitle = lView.findViewById(R.id.txt_sub_title);
        lSubTitle.setVisibility(View.VISIBLE);
        lSubTitle.setText(subTitle);

        lBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            Excursion excursion = data.getParcelableExtra("excursion");
            excursionList.add(excursion);

            addExcursionAdapter = new ExcursionAdapter(this, excursionList);
            rcyExcursion.setAdapter(addExcursionAdapter);
        }
    }
}
