package com.example.tiktak.MainRecyclerView;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import com.example.tiktak.HomeActivity;
import com.example.tiktak.MainActivity;
import com.example.tiktak.Models.MediaObject;
import com.example.tiktak.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {
    FrameLayout media_container;
    TextView description, user_name,music_name;
    ImageView thumbnail, volumeControl,soundDisc,likeBtn,followBtn;
    ProgressBar progressBar;
    View parent;
    RequestManager requestManager;
    Boolean isLike = false;
    Boolean isFollow = false;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);

        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        description = itemView.findViewById(R.id.title);
        progressBar = itemView.findViewById(R.id.progressBar);
        volumeControl = itemView.findViewById(R.id.volume_up);
        user_name = itemView.findViewById(R.id.user_name);
        soundDisc = itemView.findViewById(R.id.imgv_disc);
        likeBtn = itemView.findViewById(R.id.like);
        music_name = itemView.findViewById(R.id.music_name);
        followBtn = itemView.findViewById(R.id.addbtn);
    }
    public void onBind(MediaObject mediaObject,RequestManager requestManager){
        this.requestManager = requestManager;
        parent.setTag(this);
        description.setText(mediaObject.getDescription()+",\n"+mediaObject.getDate());
        user_name.setText(mediaObject.getUser_name());
        music_name.setText(mediaObject.getPost_categories());
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLike){
                    likeBtn.setImageResource(R.drawable.favo);
                    isLike = true;
                }else {
                    likeBtn.setImageResource(R.drawable.like_icon);
                    isLike = false;
                }
            }
        });
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFollow){
                    followBtn.setImageResource(R.drawable.checked);
                    Toast.makeText(followBtn.getContext(), "Followed",Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            followBtn.setVisibility(View.GONE);
                        }
                    }, 1000);
                    isFollow= true;
                }else {
                    followBtn.setImageResource(R.drawable.add_icon);
                    isFollow = false;
                }
            }
        });
        this.requestManager.load(mediaObject.getThumbnail()).into(thumbnail);
    }
}
