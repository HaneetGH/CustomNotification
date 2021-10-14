package com.haneet.customnotification.notficationBuilder;

import static android.content.Context.NOTIFICATION_SERVICE;
import static com.haneet.customnotification.notificationHelper.NotificationHelper.channelID;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.haneet.customnotification.R;


public class GetCustomLayBuilder {
    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    private final static String default_notification_channel_id = "default";

    public static NotificationCompat.Builder getCustomLayNotification(Context context) {
        RemoteViews smallLayout = new RemoteViews(context.getPackageName(), R.layout.small_notification_layout);
        RemoteViews expandedLayout = new RemoteViews(context.getPackageName(), R.layout.expanded_notification_layout);

        smallLayout.setTextViewText(R.id.title, "Custom notification title");
        smallLayout.setTextViewText(R.id.text, "Text for the notification");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context.getApplicationContext(), channelID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setColor(ContextCompat.getColor(context, R.color.purple_200))
                .setColorized(true)
                .setCustomContentView(smallLayout);

        return mBuilder;
    }


    public static NotificationCompat.Builder createNotification(Context activity) {
        RemoteViews contentView = new RemoteViews(activity.getPackageName(), R.layout.custom_notification_layout);
        NotificationManager mNotificationManager = (NotificationManager) activity.getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(activity, default_notification_channel_id);
        mBuilder.setContent(contentView);
        mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        mBuilder.setAutoCancel(true);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
        return mBuilder;
      /*  assert mNotificationManager != null;
        mNotificationManager.notify((int) System.currentTimeMillis(),
                mBuilder.build());*/
    }

}
