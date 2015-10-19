package com.example.mohak.materialtabviewpager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mohak on 4/10/15.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.Cityholder> {

    ArrayList<single> data;
    LayoutInflater inflater;
    Context context;
    private Bitmap b;
    int mPosition = -1;
    //List<SingleRow> refers to list of objects of SingleRow

    public CustomRecyclerAdapter(Context context, ArrayList<single> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public Cityholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Whenever new row is to be displayed this fn is called
        View view = inflater.inflate(R.layout.single_city, viewGroup, false);
        Cityholder viewHolder = new Cityholder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(Cityholder viewHolder, int position) {
        //used to set data to be displayed int the recycler view and update it as per the position (i)

        single current = data.get(position);
        viewHolder.textView.setText(current.Item);
        viewHolder.imageView.setImageResource(current.Id);
        //        viewHolder.textView.setOnClickListener(clickListener);
//        viewHolder.textView2.setOnClickListener(clickListener);
//        viewHolder.textView.setTag(viewHolder);
//        viewHolder.textView2.setTag(viewHolder);
        // viewHolder.circleImageView.setImageResource(current.icon);


    }


    //Click on recycler view with unknown elements

    @Override
    public int getItemCount() {
        return data.size();
    }


    class Cityholder extends RecyclerView.ViewHolder
            //This class needs to be a sub class of the Adapter class
    {
        TextView textView;

        ImageView imageView;

        public Cityholder(View itemView) {
            super(itemView);
            ;
            textView = (TextView) itemView.findViewById(R.id.Mytext);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}