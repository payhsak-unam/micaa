package com.example.mica.recyclerview;

import android.view.animation.AnimationUtils;

import com.example.mica.R;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class CustomItemAnimator extends DefaultItemAnimator {
    @Override
    public long getRemoveDuration() {
        return 500;
    }

    @Override
    public long getAddDuration() {
        return 500;
    }

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {

        holder.itemView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.viewholder_remove_animation));


        return super.animateRemove(holder);
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {

        holder.itemView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.viewholder_anim));


        return super.animateAdd(holder);
    }
}
