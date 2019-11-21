package com.org.checkweather.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.checkweather.R;
import com.org.checkweather.view.model.Excursion;
import com.org.checkweather.view.model.Forecast;

import java.util.List;

public class ExcursionAdapter extends RecyclerView.Adapter<ExcursionAdapter.ViewHolder> {

    private Context mContext;
    private List<Excursion> excursionList;

    public ExcursionAdapter(Context mContext, List<Excursion> excursionList) {
        this.mContext = mContext;
        this.excursionList = excursionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_excursion_item, parent, false);

        return new ExcursionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Excursion excursion = excursionList.get(position);

        viewHolder.txtExcSrcName.setText("Source :" + excursion.getSourceName());

        viewHolder.txtExcDstName.setText("Destination :" +excursion.getDestName());

        viewHolder.txtExcPrice.setText("Price :" +excursion.getPrice());


        viewHolder.txtExcFrDate.setText("From Date :" +excursion.getStartDate());

        viewHolder.txtExcToDate.setText("To Date :" +excursion.getEndDate());

    }

    @Override
    public int getItemCount() {
        if(excursionList != null )
            return  excursionList.size();
        else
            return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtExcSrcName, txtExcDstName, txtExcPrice, txtExcFrDate, txtExcToDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtExcSrcName = itemView.findViewById(R.id.txtExcSrcName);
            this.txtExcDstName = itemView.findViewById(R.id.txtExcDstName);
            this.txtExcPrice = itemView.findViewById(R.id.txtExcPrice);
            this.txtExcFrDate = itemView.findViewById(R.id.txtExcFrDate);
            this. txtExcToDate  = itemView.findViewById(R.id.txtExcToDate);
        }
    }

    public void add(Excursion excursion) {

        try {
            this.excursionList.add(excursion);

        } catch (Exception e) {
            e.printStackTrace();
        }

        notifyDataSetChanged();
    }
}
