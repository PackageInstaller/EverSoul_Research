package com.facebook.gamingservices.cloudgaming;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.GamingMediaUploader;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public abstract class AppToUserNotificationSender {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void scheduleAppToUserNotification(String title, String body, Bitmap media, int timeInterval, String payload, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, media, getParameters(), new MediaUploadCallback(title, body, timeInterval, payload, callback));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void scheduleAppToUserNotification(String title, String body, File media, int timeInterval, String payload, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, media, getParameters(), new MediaUploadCallback(title, body, timeInterval, payload, callback));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void scheduleAppToUserNotification(String title, String body, Uri media, int timeInterval, String payload, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, media, getParameters(), new MediaUploadCallback(title, body, timeInterval, payload, callback));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Bundle getParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("upload_source", "A2U");
        return bundle;
    }
}
