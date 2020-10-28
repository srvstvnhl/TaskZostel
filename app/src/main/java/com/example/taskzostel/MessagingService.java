package com.example.taskzostel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MessagingService extends FirebaseMessagingService {
    String deviceAppUID;

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d("TAG", "onNewToken: "+s);
        // token: f5ga4AB0R4K4dfZ-J1kdjZ:APA91bG0_z7boke8jIdA9sLH-BXFHBbCCy257BRN1ajPdTVbcvXHH2lbkWDHGXxcXinDj-XBx54jg5xHanQ-BJ9zF8ytmAG-2LtZaJmoMClQdNgrzDmdFnAftqd5RsvcCncn45uYqqwS


        deviceAppUID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        storeDatabase(s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

    }

    //Not used
    private void sendRegistrationToServer(String token) {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/saving-data/IDs");

//        ref.push().setValue(token);
        ref.child(deviceAppUID).setValue(token);
    }

    public void storeDatabase(String token){
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("server/saving-data/DeviceIds");

        UtmSourceInfo utmSourceInfo=CampaignReceiver.retrieveReferralParams(getApplicationContext());

        String src = utmSourceInfo.getUtmSource();
        String term = utmSourceInfo.getUtmTerm();
        String medium = utmSourceInfo.getUtmMedium();
        String camp = utmSourceInfo.getUtmCampaign();
        String content = utmSourceInfo.getUtmContent();

        UtmSourceInfo push = new UtmSourceInfo(src,medium,term,content,camp,token);
        reference.child(deviceAppUID).setValue(push);
    }



    //Not used
    public void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "MyNotification";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Hi Zostel")
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }



}
