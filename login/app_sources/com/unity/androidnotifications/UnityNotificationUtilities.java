package com.unity.androidnotifications;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.AnalyticsEvents;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
class UnityNotificationUtilities {
    private static final int INTENT_SERIALIZATION_VERSION = 0;
    private static final int NOTIFICATION_SERIALIZATION_VERSION = 3;
    static final String SAVED_NOTIFICATION_FALLBACK_KEY = "fallback.data";
    static final String SAVED_NOTIFICATION_PRIMARY_KEY = "data";
    static final byte[] UNITY_MAGIC_NUMBER = {85, 77, 78, 78};
    private static final byte[] UNITY_MAGIC_NUMBER_PARCELLED = {85, 77, 78, 80};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UnityNotificationUtilities() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static int findResourceIdInContextByName(Context context, String str) {
        if (str == null) {
            return 0;
        }
        try {
            Resources resources = context.getResources();
            if (resources != null) {
                int identifier = resources.getIdentifier(str, "mipmap", context.getPackageName());
                return identifier == 0 ? resources.getIdentifier(str, "drawable", context.getPackageName()) : identifier;
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static void serializeNotification(SharedPreferences sharedPreferences, Notification notification, boolean z) {
        String encodeToString;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (z) {
                Intent intent = new Intent();
                intent.putExtra(UnityNotificationManager.KEY_NOTIFICATION, notification);
                if (!serializeNotificationParcel(intent, dataOutputStream)) {
                    return;
                }
                dataOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                encodeToString = Base64.encodeToString(byteArray, 0, byteArray.length, 0);
            } else {
                if (!serializeNotificationCustom(notification, dataOutputStream)) {
                    return;
                }
                dataOutputStream.flush();
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                encodeToString = Base64.encodeToString(byteArray2, 0, byteArray2.length, 0);
            }
            SharedPreferences.Editor clear = sharedPreferences.edit().clear();
            clear.putString("data", encodeToString);
            clear.apply();
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean serializeNotificationParcel(Intent intent, DataOutputStream dataOutputStream) {
        try {
            byte[] serializeParcelable = serializeParcelable(intent);
            if (serializeParcelable != null && serializeParcelable.length != 0) {
                dataOutputStream.write(UNITY_MAGIC_NUMBER_PARCELLED);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(serializeParcelable.length);
                dataOutputStream.write(serializeParcelable);
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", e);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", e2);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean serializeNotificationCustom(Notification notification, DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.write(UNITY_MAGIC_NUMBER);
            dataOutputStream.writeInt(3);
            boolean z = notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false);
            dataOutputStream.writeInt(notification.extras.getInt("id"));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_TITLE));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_TEXT));
            serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_SMALL_ICON));
            serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_LARGE_ICON));
            dataOutputStream.writeLong(notification.extras.getLong(UnityNotificationManager.KEY_FIRE_TIME, -1L));
            dataOutputStream.writeLong(notification.extras.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, -1L));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_BIG_TEXT));
            dataOutputStream.writeBoolean(notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false));
            dataOutputStream.writeBoolean(z);
            serializeString(dataOutputStream, notification.extras.getString("data"));
            dataOutputStream.writeBoolean(notification.extras.getBoolean(UnityNotificationManager.KEY_SHOW_IN_FOREGROUND, true));
            String string = notification.extras.getString(UnityNotificationManager.KEY_BIG_PICTURE);
            serializeString(dataOutputStream, string);
            if (string != null && string.length() > 0) {
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_LARGE_ICON));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_CONTENT_TITLE));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_CONTENT_DESCRIPTION));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_SUMMARY_TEXT));
                dataOutputStream.writeBoolean(notification.extras.getBoolean(UnityNotificationManager.KEY_BIG_SHOW_WHEN_COLLAPSED, false));
            }
            serializeString(dataOutputStream, Build.VERSION.SDK_INT < 26 ? null : notification.getChannelId());
            Integer notificationColor = UnityNotificationManager.getNotificationColor(notification);
            dataOutputStream.writeBoolean(notificationColor != null);
            if (notificationColor != null) {
                dataOutputStream.writeInt(notificationColor.intValue());
            }
            dataOutputStream.writeInt(notification.number);
            dataOutputStream.writeBoolean((notification.flags & 16) != 0);
            serializeString(dataOutputStream, notification.getGroup());
            dataOutputStream.writeBoolean((notification.flags & 512) != 0);
            dataOutputStream.writeInt(UnityNotificationManager.getNotificationGroupAlertBehavior(notification));
            serializeString(dataOutputStream, notification.getSortKey());
            if (z) {
                dataOutputStream.writeLong(notification.when);
            }
            return true;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification", e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void serializeString(DataOutputStream dataOutputStream, String str) throws IOException {
        if (str == null || str.length() == 0) {
            dataOutputStream.writeInt(0);
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static byte[] serializeParcelable(Parcelable parcelable) {
        try {
            Parcel obtain = Parcel.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelable("obj", parcelable);
            obtain.writeParcelable(bundle, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", e2);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Object deserializeNotification(Context context, SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("data", "");
        if (string != null && string.length() > 0) {
            Object deserializeNotification = deserializeNotification(context, Base64.decode(string, 0));
            if (deserializeNotification != null) {
                return deserializeNotification;
            }
            String string2 = sharedPreferences.getString(SAVED_NOTIFICATION_FALLBACK_KEY, "");
            if (string2 != null && string2.length() > 0) {
                return deserializeNotification(context, Base64.decode(string2, 0));
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Object deserializeNotification(Context context, byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        Notification deserializeNotificationParcelable = deserializeNotificationParcelable(dataInputStream);
        if (deserializeNotificationParcelable != null) {
            return deserializeNotificationParcelable;
        }
        byteArrayInputStream.reset();
        Notification.Builder deserializeNotificationCustom = deserializeNotificationCustom(context, dataInputStream);
        return deserializeNotificationCustom == null ? deserializedFromOldIntent(context, bArr) : deserializeNotificationCustom;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean readAndCheckMagicNumber(DataInputStream dataInputStream, byte[] bArr) {
        for (byte b : bArr) {
            try {
                if (dataInputStream.readByte() != b) {
                    return false;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Notification deserializeNotificationParcelable(DataInputStream dataInputStream) {
        int readInt;
        try {
            if (readAndCheckMagicNumber(dataInputStream, UNITY_MAGIC_NUMBER_PARCELLED) && (readInt = dataInputStream.readInt()) >= 0 && readInt <= 0) {
                return (Notification) ((Intent) deserializeParcelable(dataInputStream)).getParcelableExtra(UnityNotificationManager.KEY_NOTIFICATION);
            }
            return null;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x013e A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0169 A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017e A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c9 A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ce A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d5 A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ed A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f4 A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0229 A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TRY_LEAVE, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0184 A[Catch: OutOfMemoryError -> 0x0233, Exception -> 0x0239, TryCatch #3 {Exception -> 0x0239, OutOfMemoryError -> 0x0233, blocks: (B:27:0x0134, B:29:0x013e, B:30:0x0145, B:32:0x0169, B:33:0x0170, B:35:0x017e, B:37:0x01c9, B:39:0x01ce, B:42:0x01d5, B:44:0x01ed, B:46:0x01f4, B:47:0x01f9, B:49:0x0205, B:51:0x020b, B:52:0x0210, B:54:0x021c, B:56:0x0222, B:58:0x0229, B:62:0x01e4, B:63:0x0184, B:65:0x019b, B:68:0x01aa, B:71:0x01b5, B:72:0x01bc), top: B:26:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0143  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.Notification.Builder deserializeNotificationCustom(android.content.Context r48, java.io.DataInputStream r49) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity.androidnotifications.UnityNotificationUtilities.deserializeNotificationCustom(android.content.Context, java.io.DataInputStream):android.app.Notification$Builder");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Notification.Builder deserializedFromOldIntent(Context context, byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            Bundle bundle = new Bundle();
            bundle.readFromParcel(obtain);
            int i = bundle.getInt("id", -1);
            String string = bundle.getString(UnityNotificationManager.KEY_CHANNEL_ID);
            String string2 = bundle.getString("textTitle");
            String string3 = bundle.getString("textContent");
            String string4 = bundle.getString("smallIconStr");
            boolean z = bundle.getBoolean("autoCancel", false);
            boolean z2 = bundle.getBoolean("usesChronometer", false);
            long j = bundle.getLong(UnityNotificationManager.KEY_FIRE_TIME, -1L);
            long j2 = bundle.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, -1L);
            try {
                String string5 = bundle.getString("largeIconStr");
                try {
                    int i2 = bundle.getInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, -1);
                    int i3 = bundle.getInt(TypedValues.Custom.S_COLOR, 0);
                    int i4 = bundle.getInt(Base2ndPWViewData.KEY_NUMBER, 0);
                    String string6 = bundle.getString("data");
                    String string7 = bundle.getString("group");
                    boolean z3 = bundle.getBoolean("groupSummary", false);
                    String string8 = bundle.getString("sortKey");
                    int i5 = bundle.getInt("groupAlertBehaviour", -1);
                    boolean z4 = bundle.getBoolean("showTimestamp", false);
                    Notification.Builder createNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(string);
                    createNotificationBuilder.getExtras().putInt("id", i);
                    createNotificationBuilder.setContentTitle(string2);
                    createNotificationBuilder.setContentText(string3);
                    UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, string4);
                    createNotificationBuilder.setAutoCancel(z);
                    createNotificationBuilder.setUsesChronometer(z2);
                    createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, j);
                    createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, j2);
                    UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, string5);
                    if (i2 == 2) {
                        createNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string3));
                    }
                    if (i3 != 0) {
                        UnityNotificationManager.setNotificationColor(createNotificationBuilder, i3);
                    }
                    if (i4 >= 0) {
                        createNotificationBuilder.setNumber(i4);
                    }
                    if (string6 != null) {
                        createNotificationBuilder.getExtras().putString("data", string6);
                    }
                    if (string7 != null && string7.length() > 0) {
                        createNotificationBuilder.setGroup(string7);
                    }
                    createNotificationBuilder.setGroupSummary(z3);
                    if (string8 != null && string8.length() > 0) {
                        createNotificationBuilder.setSortKey(string8);
                    }
                    UnityNotificationManager.setNotificationGroupAlertBehavior(createNotificationBuilder, i5);
                    createNotificationBuilder.setShowWhen(z4);
                    return createNotificationBuilder;
                } catch (Exception e) {
                    e = e;
                    str3 = "Failed to deserialize old style notification";
                    str4 = "UnityNotifications";
                    Log.e(str4, str3, e);
                    return null;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    str = "Failed to deserialize old style notification";
                    str2 = "UnityNotifications";
                    Log.e(str2, str, e);
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                str4 = "UnityNotifications";
                str3 = "Failed to deserialize old style notification";
            } catch (OutOfMemoryError e4) {
                e = e4;
                str2 = "UnityNotifications";
                str = "Failed to deserialize old style notification";
            }
        } catch (Exception e5) {
            e = e5;
            str3 = "Failed to deserialize old style notification";
            str4 = "UnityNotifications";
        } catch (OutOfMemoryError e6) {
            e = e6;
            str = "Failed to deserialize old style notification";
            str2 = "UnityNotifications";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String deserializeString(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        if (readInt <= 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        if (dataInputStream.read(bArr) != readInt) {
            throw new IOException("Insufficient amount of bytes read");
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T extends Parcelable> T deserializeParcelable(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        if (readInt <= 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        if (dataInputStream.read(bArr) != readInt) {
            throw new IOException("Insufficient amount of bytes read");
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, readInt);
            obtain.setDataPosition(0);
            Bundle bundle = (Bundle) obtain.readParcelable(UnityNotificationUtilities.class.getClassLoader());
            obtain.recycle();
            if (bundle != null) {
                return (T) bundle.getParcelable("obj");
            }
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", e);
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", e2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Class<?> getOpenAppActivity(Context context) {
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                Bundle bundle = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("custom_notification_android_activity")) {
                    try {
                        return Class.forName(bundle.getString("custom_notification_android_activity"));
                    } catch (ClassNotFoundException e) {
                        Log.e("UnityNotifications", "Specified activity class for notifications not found: " + e.getMessage());
                    }
                }
                Log.w("UnityNotifications", "No custom_notification_android_activity found, attempting to find app activity class");
                boolean z = true;
                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(context.getPackageName(), 1).activities;
                if (activityInfoArr == null) {
                    Log.e("UnityNotifications", "Could not get package activities");
                    return null;
                }
                int length = activityInfoArr.length;
                String str = null;
                int i = 0;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    if (i >= length) {
                        z = z3;
                        break;
                    }
                    ActivityInfo activityInfo = activityInfoArr[i];
                    if (activityInfo.enabled && activityInfo.targetActivity == null) {
                        boolean isUnityActivity = isUnityActivity(activityInfo.name);
                        if (str == null) {
                            str = activityInfo.name;
                        } else if (z2 == isUnityActivity) {
                            if (z2 && isUnityActivity) {
                                break;
                            }
                            z3 = true;
                        } else if (isUnityActivity) {
                            str = activityInfo.name;
                            z3 = false;
                        }
                        z2 = isUnityActivity;
                    }
                    i++;
                }
                if (z) {
                    Log.e("UnityNotifications", "Multiple choices for activity for notifications, set activity explicitly in Notification Settings");
                    return null;
                }
                if (str == null) {
                    Log.e("UnityNotifications", "Activity class for notifications not found");
                    return null;
                }
                return Class.forName(str);
            } catch (ClassNotFoundException e2) {
                Log.e("UnityNotifications", "Failed to find activity class: " + e2.getMessage());
                return null;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isUnityActivity(String str) {
        return str.endsWith(".UnityPlayerActivity") || str.endsWith(".UnityPlayerGameActivity");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Notification.Builder recoverBuilder(Context context, Notification notification) {
        try {
            Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification);
            recoverBuilder.setExtras(notification.extras);
            return recoverBuilder;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to recover builder for notification!", e);
            return recoverBuilderCustom(context, notification);
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to recover builder for notification!", e2);
            return recoverBuilderCustom(context, notification);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Notification.Builder recoverBuilderCustom(Context context, Notification notification) {
        Notification.Builder createNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(notification.extras.getString(UnityNotificationManager.KEY_CHANNEL_ID));
        UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, notification.extras.getString(UnityNotificationManager.KEY_SMALL_ICON));
        String string = notification.extras.getString(UnityNotificationManager.KEY_LARGE_ICON);
        if (string != null && !string.isEmpty()) {
            UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, string);
        }
        createNotificationBuilder.setContentTitle(notification.extras.getString(NotificationCompat.EXTRA_TITLE));
        createNotificationBuilder.setContentText(notification.extras.getString(NotificationCompat.EXTRA_TEXT));
        createNotificationBuilder.setAutoCancel((notification.flags & 16) != 0);
        if (notification.number >= 0) {
            createNotificationBuilder.setNumber(notification.number);
        }
        String string2 = notification.extras.getString(NotificationCompat.EXTRA_BIG_TEXT);
        if (string2 != null) {
            createNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string2));
        }
        createNotificationBuilder.setWhen(notification.when);
        String group = notification.getGroup();
        if (group != null && !group.isEmpty()) {
            createNotificationBuilder.setGroup(group);
        }
        createNotificationBuilder.setGroupSummary((notification.flags & 512) != 0);
        String sortKey = notification.getSortKey();
        if (sortKey != null && !sortKey.isEmpty()) {
            createNotificationBuilder.setSortKey(sortKey);
        }
        createNotificationBuilder.setShowWhen(notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false));
        Integer notificationColor = UnityNotificationManager.getNotificationColor(notification);
        if (notificationColor != null) {
            UnityNotificationManager.setNotificationColor(createNotificationBuilder, notificationColor.intValue());
        }
        UnityNotificationManager.setNotificationUsesChronometer(createNotificationBuilder, notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false));
        UnityNotificationManager.setNotificationGroupAlertBehavior(createNotificationBuilder, UnityNotificationManager.getNotificationGroupAlertBehavior(notification));
        createNotificationBuilder.getExtras().putInt("id", notification.extras.getInt("id", 0));
        createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, notification.extras.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, 0L));
        createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, notification.extras.getLong(UnityNotificationManager.KEY_FIRE_TIME, 0L));
        String string3 = notification.extras.getString("data");
        if (string3 != null && !string3.isEmpty()) {
            createNotificationBuilder.getExtras().putString("data", string3);
        }
        return createNotificationBuilder;
    }
}
