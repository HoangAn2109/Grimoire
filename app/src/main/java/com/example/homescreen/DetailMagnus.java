package com.example.homescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.homescreen.adapters.ChapAdapter;
import com.example.homescreen.adapters.RecyclerViewInterface;
import com.example.homescreen.models.ChapModel;

import java.util.ArrayList;
import java.util.List;

public class DetailMagnus extends AppCompatActivity implements RecyclerViewInterface {

    ImageButton btn_follow;

    RecyclerView recyclerView;

    ChapAdapter chapAdapter;

    List<ChapModel> chaps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        createNotificationChannel();
        btn_follow = findViewById(R.id.btn_follow);
        btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailMagnus.this, ReminderBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(DetailMagnus.this, 0, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                long timeclick = System.currentTimeMillis();
                long tensecs = 1000*10;
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeclick + tensecs, pendingIntent);
            }
        });


        chaps = new ArrayList<>();
        chaps.add(new ChapModel("Chapter 1", getString(R.string.magnus_chap1)));
        chaps.add(new ChapModel("Chapter 2", getString(R.string.magnus_chap2)));
        chaps.add(new ChapModel("Chapter 3", "grgrgr"));
        chaps.add(new ChapModel("Chapter 4", "grgrgrgrg"));
        setChapter(chaps);
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Channel name?";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Followed", name, importance);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

    private void setChapter(List<ChapModel> list2) {
        recyclerView = findViewById(R.id.recChap);
        SpacingChapters spacingChapters = new SpacingChapters(30);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        chapAdapter = new ChapAdapter(this, this, list2);
        recyclerView.setAdapter(chapAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(DetailMagnus.this, chapters.class);
        intent.putExtra("Chap_number", chaps.get(position).getChap_num());
        intent.putExtra("Chap_content", chaps.get(position).getChap_content());
        startActivity(intent);
    }
}