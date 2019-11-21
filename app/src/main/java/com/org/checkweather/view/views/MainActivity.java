package com.org.checkweather.view.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.org.checkweather.R;
import com.org.checkweather.network.client.APIClient;
import com.org.checkweather.network.interfaces.APIInterface;
import com.org.checkweather.network.utils.Utility;
import com.org.checkweather.view.adapters.ForecastAdapter;
import com.org.checkweather.view.model.Forecast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView rcyForeCast;
    private RecyclerView.Adapter forecastAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText edtSearchCity;
    private APIInterface apiInterface;
    private ProgressDialog progressDialog ;
    private List<Forecast.list> forecastList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcyForeCast = findViewById(R.id.rcyForecast);
        layoutManager = new LinearLayoutManager(this);
        rcyForeCast.setLayoutManager(layoutManager);
        rcyForeCast.setItemAnimator(new DefaultItemAnimator());
        edtSearchCity = findViewById(R.id.editTextSearch);

        forecastList = new ArrayList<>();
        apiInterface = APIClient.getClient().create(APIInterface.class);

        progressDialog =  new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        forecastAdapter = new ForecastAdapter(forecastList, MainActivity.this);
        rcyForeCast.setAdapter(forecastAdapter);

        edtSearchCity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    callToGetForecast();
                    return true;
                }
                return false;
            }
        });



    }

    private void callToGetForecast(){
        progressDialog.show();
        String cityName = edtSearchCity.getText().toString();

        Call<Forecast> call = apiInterface.doGetForecast(cityName, Utility.APP_ID, Utility.COUNT, Utility.UNITS);
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                progressDialog.dismiss();
                Log.d(TAG, "Response :" + response.body().toString());
                forecastList =  response.body().list;

                forecastAdapter = new ForecastAdapter(forecastList, MainActivity.this);
                rcyForeCast.setAdapter(forecastAdapter);
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                progressDialog.dismiss();
                Log.e(TAG, t.toString());
            }
        });

    }
}
