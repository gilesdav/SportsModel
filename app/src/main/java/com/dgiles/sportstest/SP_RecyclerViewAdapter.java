package com.dgiles.sportstest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SP_RecyclerViewAdapter extends RecyclerView.Adapter<SP_RecyclerViewAdapter.MyViewHolder> {

    private static final String TAG = "RecycleViewAdaptor";

    Context context;
    ArrayList<SportsModel> sportsModels;

    public SP_RecyclerViewAdapter(Context context, ArrayList<SportsModel> sportsModels){
        this.context = context;
        this.sportsModels = sportsModels;
    }

    @NonNull
    @Override
    public SP_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is wheere you inflate the layout (Giving a look to our rows)
        Log.d(TAG, "SP_RecyclerViewAdpater onCreateViewGolder: called.");
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent,false);
        return new SP_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SP_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the recycle_view_row layout file
        // based on the position of the recycler view
        Log.d(TAG, "SP_RecyclerViewAdpater onBindViewGolder: called.");
        holder.tvName.setText(sportsModels.get(position).getSportName());
        holder.tv1Letter.setText(sportsModels.get(position).getSportAbbreviation());
        holder.tvSeason.setText(sportsModels.get(position).getSportSeason());
        holder.imageView.setImageResource(sportsModels.get(position).getImage());
        Log.d(TAG, "SP_RecyclerViewAdpater onBindViewGolder: finished.");
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want displayed
        Log.d(TAG, "SP_RecyclerViewAdpater getItemCount: called.");
        return sportsModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // grabbing the views from our recycler_view_row layout file
        // Kinda like in the onCreare method
        ImageView imageView;
        TextView tvName, tv1Letter, tvSeason;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           Log.d(TAG, "SP_RecyclerViewAdpater MyViewHolder: called.");
           imageView = itemView.findViewById(R.id.imageView);
           tvName = itemView.findViewById(R.id.textView);
           tv1Letter = itemView.findViewById(R.id.textView2);
           tvSeason = itemView.findViewById(R.id.textView3);
           Log.d(TAG, "SP_RecyclerViewAdpater MyViewHolder: finished.");
        }
    }
}


