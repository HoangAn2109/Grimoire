package com.example.homescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.homescreen.LoginNSignup.Login;
import com.example.homescreen.adapters.RecBooksAdapter;
import com.example.homescreen.models.RecBooksModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    RecyclerView recBooks;

    Boolean isPlaying = false;
    ImageButton music, logout;
    CardView cardmagnus, cardundetectable;

    private FirebaseAuth mAuth;
    RecBooksAdapter recBooksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        cardmagnus = findViewById(R.id.card_magnus);
        cardundetectable = findViewById(R.id.card_undetectable);
        mediaPlayer = MediaPlayer.create(this, R.raw.gn_music);
        music = findViewById(R.id.music);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    pauseMusic();
                } else {
                    playMusic();
                }
            }
        });



        cardmagnus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailMagnus.class);
                startActivity(intent);
            }
        });


        List<RecBooksModel> list = new ArrayList<>();
        list.add(new RecBooksModel(R.drawable.hp_card, "Harry Potter Series"));
        list.add(new RecBooksModel(R.drawable.lotr_card, "The Lord of the Rings"));
        list.add(new RecBooksModel(R.drawable.hmc_card, "Howl's moving castle"));
        list.add(new RecBooksModel(R.drawable.got_card, "Game of Throne"));
        setRecBooks(list);
    }

    private void playMusic() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            isPlaying = true;
            music.setImageResource(R.drawable.baseline_pause_24);
        }
    }
    private void pauseMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPlaying = false;
            music.setImageResource(R.drawable.baseline_play_arrow_24);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void setRecBooks(List<RecBooksModel> list1){
        recBooks = findViewById(R.id.RecBooks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recBooks.setLayoutManager(layoutManager);
        SpacingItems spacingItems = new SpacingItems(30);
        recBooks.addItemDecoration(spacingItems);
        recBooksAdapter = new RecBooksAdapter(this, list1);
        recBooks.setAdapter(recBooksAdapter);
    }



}