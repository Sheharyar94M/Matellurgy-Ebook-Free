package com.qsa.metallurgy_material_free.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qsa.metallurgy_material_free.Model.Books;
import com.qsa.metallurgy_material_free.R;
import com.qsa.metallurgy_material_free.VideoPlayerActivity;

import java.util.List;

public class FavoriteVideoAdapter extends RecyclerView.Adapter<FavoriteVideoAdapter.MyFavViewHolder>
        {
        Context context;
        List<Books> dataList;

public FavoriteVideoAdapter(Context context,List<Books> dataList){
        this.context=context;
        this.dataList=dataList;
        }

@NonNull
@Override
public MyFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.design_for_pdf_video,parent,false);
        return new MyFavViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull MyFavViewHolder holder,int position){

final Books books=dataList.get(position);
        Glide.with(context)
        .load(books.getBookImage())
        .into(holder.bookImage);
        holder.heading.setText(books.getBookName());
        holder.description.setText(books.getDescription());

        holder.videoLayout.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
        Intent intent=new Intent(context, VideoPlayerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("categoryName",books.getCategoryName());
        intent.putExtra("youtubeUrl",books.getYoutubeUrl());
        intent.putExtra("type","favourite");
        context.startActivity(intent);
        }
        });

        holder.playBtn.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){

        Intent intent=new Intent(context,VideoPlayerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("categoryName",books.getCategoryName());
        intent.putExtra("youtubeUrl",books.getYoutubeUrl());
        intent.putExtra("type","favourite");
        context.startActivity(intent);

        }
        });


        }

@Override
public int getItemCount(){
        return dataList.size();
        }

public class MyFavViewHolder extends RecyclerView.ViewHolder {
    CardView videoLayout;
    ImageView playBtn;
    ImageView bookImage;
    TextView heading;
    TextView description;

    public MyFavViewHolder(@NonNull View itemView) {
        super(itemView);

        videoLayout = itemView.findViewById(R.id.videoLayout);
        playBtn = itemView.findViewById(R.id.favBtn);
        heading = itemView.findViewById(R.id.text1);
        description = itemView.findViewById(R.id.text2);
        bookImage = itemView.findViewById(R.id.bookImageFavourite);
    }
}
}

