package com.org.checkweather.view.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.org.checkweather.R;
import com.org.checkweather.view.adapters.ExcursionAdapter;
import com.org.checkweather.view.model.Excursion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ExcursionFormActivity extends AppCompatActivity {

    private static final int ADD_WEATHER_REQUEST = 2 ;

    private EditText edtSourceName, edtDestName, edtTripPrice, edtTripStartDate, edtTripEndDate, edtTripWeather;

    private ImageView imgCalFrom, imgCalTo, imgWeather;

    private Button btnSave;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private int mYear = 0, mMonth = 0, mDay = 0;
    private String strDate;

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


        calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);//Locale.getDefault());
        strDate = dateFormat.format(calendar.getTime());



        imgCalFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate(edtTripStartDate);
            }
        });

        imgCalTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate(edtTripEndDate);
            }
        });

        imgWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExcursionFormActivity.this, MainActivity.class);
                startActivityForResult(intent, ADD_WEATHER_REQUEST);
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

    private void setDate(final EditText edtView){

            mYear = calendar.get(Calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);
            // Launch Date Picker Dialog
            final DatePickerDialog lDpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(@NonNull DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            // Display Selected date
                            if (view.isShown()) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, monthOfYear);
                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                strDate = dateFormat.format(calendar.getTime());
                                mYear = year;
                                mMonth = monthOfYear;
                                mDay = dayOfMonth;
                                edtView.setText(dateFormat.format(calendar.getTime()));
                            }
                        }
                    }, mYear, mMonth, mDay);
            lDpd.show();
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {


        }
    }
}
