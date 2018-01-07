package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

/**
 * Created by borde on 1/6/18.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    // COMP (24) Override onCreateViewHolder
    // COMP (25) Within onCreateViewHolder, inflate the list item xml into a view
    // COMP (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter

    // COMP (27) Override onBindViewHolder
    // COMP (28) Set the text of the TextView to the weather for this list item's position

    // COMP (29) Override getItemCount
    // COMP (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

    // COMP (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // COMP (32) After you save mWeatherData, call notifyDataSetChanged
    // Within ForecastAdapter.java /////////////////////////////////////////////////////////////////

    public void setWeatherData(String []weatherData) {
        mWeatherData = weatherData;
        this.notifyDataSetChanged();
    }

    private String []mWeatherData;

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View inflated = inflater.inflate(R.layout.forecast_list_item, parent, false);

        return new ForecastAdapterViewHolder(inflated);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null)
            return 0;
        else
            return mWeatherData.length;
    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
        // COMP (18) Create a public final TextView variable called mWeatherTextView

        // COMP (19) Create a constructor for this class that accepts a View as a parameter
        // COMP (20) Call super(view) within the constructor for ForecastAdapterViewHolder
        // COMP (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////

        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            this.mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }

    public ForecastAdapter() {
        this.mWeatherData = mWeatherData;
    }

    // Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
    // COMP (15) Add a class file called ForecastAdapter
    // COMP (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

    // COMP (23) Create a private string array called mWeatherData

    // COMP (47) Create the default constructor (we will pass in parameters in a later lesson)

    // COMP (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // COMP (17) Extend RecyclerView.ViewHolder

}
