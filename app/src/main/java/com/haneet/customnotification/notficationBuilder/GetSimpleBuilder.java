package com.haneet.customnotification.notficationBuilder;

import static com.haneet.customnotification.notificationHelper.NotificationHelper.channelID;

import android.content.Context;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.haneet.customnotification.R;

public class GetSimpleBuilder {

    public static NotificationCompat.Builder getSimpleBuilder(Context context){
        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context.getApplicationContext(), channelID)
                .setContentTitle("Title of the notification")
                .setContentText("Body of the notification")
                .setColor(ContextCompat.getColor(context,R.color.purple_200))
                .setColorized(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground);

        return mBuilder;
    }

    public static NotificationCompat.Builder getLargeIconNotification(Context context){
        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context.getApplicationContext(), channelID)
                .setContentTitle("Title of the notification")
                .setContentText("Body of the notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.android));

        return mBuilder;
    }

}
