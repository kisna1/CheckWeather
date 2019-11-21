package com.org.checkweather.view.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.org.checkweather.R;
import com.org.checkweather.view.model.Excursion;

public class ExcursionFormActivity extends AppCompatActivity {

    private EditText edtSourceName, edtDestName, edtTripPrice, edtTripStartDate, edtTripEndDate, edtTripWeather;

    private ImageView imgCalFrom, imgCalTo, imgWeather;

    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_form);

        actionBarSetting("Excursions Form", "");

        edtSourceName = findViewById(R.id.edtSourceName);
        edtDestName = findViewById(R.id.edtDestName);
        edtTripPrice = findViewById(R.id.edtTripPrice);
        edtTripStartDate = findViewById(R.id.edtTripStartDate);
        edtTripEndDate = findViewById(R.id.edtTripEndDate);
        edtTripWeather = findViewById(R.id.edtTripWeather);
        btnSave = findViewById(R.id.btnSave);

        imgCalFrom = findViewById(R.id.imgCalStartDate);
        imgCalTo = findViewById(R.id.imgCalEndDate);
        imgWeather = findViewById(R.id.imgWeather);

        imgCalFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgCalTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtSourceName.getText().toString())){
                    Toast.makeText(ExcursionFormActivity.this, "Please enter source", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(edtDestName.getText().toString())){
                    Toast.makeText(ExcursionFormActivity.this, "Please enter destination", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(edtTripPrice.getText().toString())){
                    Toast.makeText(ExcursionFormActivity.this, "Please enter price", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(edtTripStartDate.getText().toString())){
                    Toast.makeText(ExcursionFormActivity.this, "Please enter start date", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(edtTripEndDate.getText().toString())){
                    Toast.makeText(ExcursionFormActivity.this, "Please enter end date", Toast.LENGTH_SHORT).show();
                    return;
                }


                Excursion excursion = new Excursion(edtSourceName.getText().toString(),
                        edtDestName.getText().toString(),
                        edtTripPrice.getText().toString(),
                        edtTripStartDate.getText().toString(),
                        edtTripEndDate.getText().toString(),
                        "");
                Intent i = new Intent();
                i.putExtra("excursion", excursion);
                setResult(RESULT_OK, i);
                finish();
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
}
