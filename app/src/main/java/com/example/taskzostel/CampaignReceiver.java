package com.example.taskzostel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class CampaignReceiver extends BroadcastReceiver {
    public final static String[] EXPECTED_PARAMETER = {"utm_source",
            "utm_medium", "utm_term", "utm_content", "utm_campaign"};
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        Bundle extras = intent.getExtras();
//        if(extras!=null) {
//            String referrerString = extras.getString("referrer");
//            Log.d("Referrer", referrerString);
//
//            String[] params = referrerString.split("&");
//            for (String param : params){
//                Log.d("TAGRef", "onReceive: "+param);
//            }
//
//
////            for (String param : params) {
////                String[] pair = param.split("="); // $NON-NLS-1$
////
////                if (pair.length == 1) {
////                    referralParams.put(pair[0], "AndroidApp");
////                } else if (pair.length == 2) {
////                    referralParams.put(pair[0], pair[1]);
////                }
////            }
//        }
//
//
////        try {
////            new ReferralReceiver().onReceive(context,intent);
////
////        }
////        catch (Exception e){
////            e.printStackTrace();
////        }
//    }


    @Override
    public void onReceive(Context context, Intent intent) {

        Map<String, String> referralParams = new HashMap<String, String>();
        if (intent == null) {
            return;
        }
        if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) {
            return;
        }

        String referrer = intent.getStringExtra("referrer");
        if (referrer == null || referrer.length() == 0) {
            return;
        }

        try {
            referrer = URLDecoder.decode(referrer, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        try {
            String[] params = referrer.split("&");

            for (String param : params) {
                String[] pair = param.split("=");

                if (pair.length == 1) {
                    referralParams.put(pair[0], "AndroidApp");
                } else if (pair.length == 2) {
                    referralParams.put(pair[0], pair[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CampaignReceiver.storeReferralParam(context, referralParams);
    }

    public static void storeReferralParam(Context context, Map<String, String> referralParams){
        for (String curr : CampaignReceiver.EXPECTED_PARAMETER) {
            String value = referralParams.get(curr);
            Log.d("value", "onReceive: "+value);

            curr = value;
            Log.d("value", "onReceive: "+curr);

        }
    }

    public static UtmSourceInfo retrieveReferralParams(Context context) {
        UtmSourceInfo utmSourceInfo = new UtmSourceInfo();

        utmSourceInfo.setUtmSource(CampaignReceiver.EXPECTED_PARAMETER[0]);
        utmSourceInfo.setUtmMedium(CampaignReceiver.EXPECTED_PARAMETER[1]);
        utmSourceInfo.setUtmTerm(CampaignReceiver.EXPECTED_PARAMETER[2]);
        utmSourceInfo.setUtmContent(CampaignReceiver.EXPECTED_PARAMETER[3]);
        utmSourceInfo.setUtmCampaign(CampaignReceiver.EXPECTED_PARAMETER[4]);

        return utmSourceInfo;
    }



}
