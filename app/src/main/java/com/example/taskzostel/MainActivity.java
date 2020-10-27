package com.example.taskzostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FirebaseApp.initializeApp(this);

        WebView webView = findViewById(R.id.webView);

        String input="https://www.zostel.com/";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(input);

//        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
//            NotificationChannel notificationChannel = new NotificationChannel("MyNotification","Notification", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager  manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(notificationChannel);
//        }
////        FirebaseApp.initializeApp(this);
//        FirebaseMessaging.getInstance().subscribeToTopic("general")
//                .addOnCompleteListener(task -> {
//                    String msg ="Successful";
//                    if (!task.isSuccessful()) {
//                        msg = "Failed";
//                    }
//                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//                });

    }

}