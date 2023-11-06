package com.example.tiktak.MainRecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import com.example.tiktak.Models.MediaObject;
import com.example.tiktak.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {
    FrameLayout media_container;
    TextView title, user_id;
    ImageView thumbnail, volumeControl,soundDisc,likeBtn;
    ProgressBar progressBar;
    View parent;
    RequestManager requestManager;
    Boolean isLike=false;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);

        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.title);
        progressBar = itemView.findViewById(R.id.progressBar);
        volumeControl = itemView.findViewById(R.id.volume_up);
        user_id = itemView.findViewById(R.id.user_name);
        soundDisc = itemView.findViewById(R.id.imgv_disc);
        likeBtn = itemView.findViewById(R.id.like);
    }
    public void onBind(MediaObject mediaObject,RequestManager requestManager){
        this.requestManager = requestManager;
        parent.setTag(this);
        title.setText(mediaObject.getDescription()+",\n"+mediaObject.getDate());
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLike){
                    likeBtn.setImageResource(R.drawable.favo);
                    isLike= true;
                }else {
                    likeBtn.setImageResource(R.drawable.like_icon);
                    isLike = false;
                }
            }
        });

        this.requestManager.load(mediaObject.getThumbnail()).into(thumbnail);
    }
}
