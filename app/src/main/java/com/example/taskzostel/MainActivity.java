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
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView webView = findViewById(R.id.webView);

        String input="https://www.zostel.com/";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(input);

//        UtmSourceInfo utmSourceInfo=CampaignReceiver.retrieveReferralParams(getApplicationContext());
//        utmSourceInfo.getUtmSource();
//        Log.d("TAGUTM", "onCreate: "+utmSourceInfo.getUtmSource());
//        utmSourceInfo.getUtmTerm();
//        Log.d("TAGUTM", "onCreate: "+utmSourceInfo.getUtmTerm());
//        utmSourceInfo.getUtmMedium();
//        Log.d("TAGUTM", "onCreate: "+utmSourceInfo.getUtmMedium());
//        utmSourceInfo.getUtmCampaign();
//        Log.d("TAGUTM", "onCreate: "+utmSourceInfo.getUtmCampaign());
//        utmSourceInfo.getUtmContent();
//        Log.d("TAGUTM", "onCreate: "+utmSourceInfo.getUtmContent());




    }

}