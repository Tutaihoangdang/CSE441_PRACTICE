package com.example.service;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnPlay, btnStop;
    private TextView tvSongTitle;
    private static final String AUDIO_URL =
            "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"; // Thay bằng URL bài hát của bạn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        tvSongTitle = findViewById(R.id.txtTen);
        btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            intent.putExtra("audioUrl", AUDIO_URL);
            startService(intent);
            tvSongTitle.setText("Đang phát: SoundHelix-Song-1.mp3");
        });
        btnStop.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            stopService(intent);
            tvSongTitle.setText("Dừng phát nhạc");
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
