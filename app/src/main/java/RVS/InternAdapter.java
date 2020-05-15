package RVS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mica.GlideApp;
import com.example.mica.Model.Intern;
import com.example.mica.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import interfacess.Internitem_clicklistener;

public class InternAdapter extends RecyclerView.Adapter<InternAdapter.internviewholder> {

    Internitem_clicklistener internitem_clicklistener;
    List<Intern> mdata;

    @NonNull
    @Override
    public internviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_intern,parent,false);
        return new internviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull internviewholder holder, int position) {
        GlideApp.with(holder.itemView.getContext()).load(mdata.get(position).getDrawableResources()).transform(new CenterCrop(),new RoundedCorners(16)).into(holder.imgLogo);

        holder.ratingBar.setRating(4.13f);
        holder.company.setText(mdata.get(position).getCompany());
        holder.jobtitle.setText(mdata.get(position).getJob());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public InternAdapter(List<Intern> mdata,Internitem_clicklistener internitem_clicklistener)
    {
        this.mdata=mdata;
        this.internitem_clicklistener=internitem_clicklistener;
    }


    public class internviewholder extends RecyclerView.ViewHolder{

        ImageView imgLogo,imgFav;
        TextView jobtitle,company,score,ratings;
        RatingBar ratingBar;


        public internviewholder(@NonNull View itemView)
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

                    internitem_clicklistener.onInternClick(mdata.get(getAdapterPosition()),imgLogo);
                }
            });


        }

    }
}
