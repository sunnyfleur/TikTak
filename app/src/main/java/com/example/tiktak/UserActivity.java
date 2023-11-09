package com.example.tiktak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class UserActivity extends AppCompatActivity {
    private TextView username,follow_btn,message_btn;
    private FrameLayout followed_btn;
    private boolean isFollow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        username = findViewById(R.id.user_name);
        follow_btn = findViewById(R.id.follow);
        message_btn = findViewById(R.id.message);
        followed_btn = findViewById(R.id.followed);
        // Lấy text từ SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        String text = sharedPreferences.getString("username", "");

        username.setText(text);
        follow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followBtn(v);
            }
        });
        followed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followedBtn(v);
            }
        });
    }
    public void backFromUser(View view){
        Intent intent = new Intent(UserActivity.this,HomeActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        Animatoo.animateSlideRight(this);
        finish();
    }
    private void followedBtn(View view){
        if (!isFollow){
            follow_btn.setVisibility(View.GONE);
            followed_btn.setVisibility(View.VISIBLE);
            isFollow = true;
        }else {
            follow_btn.setVisibility(View.VISIBLE);
            followed_btn.setVisibility(View.GONE);
            isFollow = false;
        }
    }
    private void followBtn(View view){
        if (!isFollow){
            followed_btn.setVisibility(View.VISIBLE);
            follow_btn.setVisibility(View.GONE);
            isFollow = true;
        }else {
            followed_btn.setVisibility(View.GONE);
            follow_btn.setVisibility(View.VISIBLE);
            isFollow = false;
        }
    }
}