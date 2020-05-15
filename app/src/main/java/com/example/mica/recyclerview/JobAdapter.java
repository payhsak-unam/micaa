package com.example.mica.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import interfacess.Jobitem_clicklistener;

import com.example.mica.GlideApp;
import com.example.mica.Model.Job;
import com.example.mica.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.jobviewholder> {


    List<Job> mdata;
    Jobitem_clicklistener jobitemClicklistener;



    @NonNull
    @Override
    public jobviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job,parent,false);
        return new jobviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull jobviewholder holder, int position) {

        GlideApp.with(holder.itemView.getContext()).load(mdata.get(position).getDrawableResources()).transform(new CenterCrop(),new RoundedCorners(16)).into(holder.imgLogo);

        holder.ratingBar.setRating(4.13f);
        holder.company.setText(mdata.get(position).getCompany());
        holder.jobtitle.setText(mdata.get(position).getJob());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public JobAdapter(List<Job> mdata,Jobitem_clicklistener jobitem_clicklistener)
    {
        this.mdata=mdata;
        this.jobitemClicklistener=jobitem_clicklistener;
    }





    public class jobviewholder extends RecyclerView.ViewHolder{

        ImageView imgLogo,imgFav;
        TextView jobtitle,company,score,ratings;
        RatingBar ratingBar;


        public jobviewholder(@NonNull View itemView)
        {
            super(itemView);

            imgFav=itemView.findViewById(R.id.fav_imgi);
            imgLogo=itemView.findViewById(R.id.logoimgintern);
            jobtitle=itemView.findViewById(R.id.intern_title);
            company=itemView.findViewById(R.id.companyi);
            score=itemView.findViewById(R.id.item_scorei);
            ratings=itemView.findViewById(R.id.ratingvaluei);
            ratingBar=itemView.findViewById(R.id.ratingBari);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  //  Intent intent=new Intent(this,)

                    jobitemClicklistener.onJobClick(mdata.get(getAdapterPosition()),imgLogo);
                }
            });


        }

    }

}
