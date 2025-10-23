package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.messaging.Constants;
import com.singular.sdk.internal.Constants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes.dex */
public final class CloudMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zzb();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    final Intent zza;
    private Map zzb;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CloudMessage(Intent intent) {
        this.zza = intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzb(String str) {
        if (zza.zza(str, Constants.HIGH)) {
            return 1;
        }
        return zza.zza(str, Constants.NORMAL) ? 2 : 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getCollapseKey() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.COLLAPSE_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Map<String, String> getData() {
        if (this.zzb == null) {
            Bundle extras = this.zza.getExtras();
            ArrayMap arrayMap = new ArrayMap();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    Object obj = extras.get(str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!str.startsWith(Constants.MessagePayloadKeys.RESERVED_PREFIX) && !str.equals("from") && !str.equals(Constants.MessagePayloadKeys.MESSAGE_TYPE) && !str.equals(Constants.MessagePayloadKeys.COLLAPSE_KEY)) {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
            this.zzb = arrayMap;
        }
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getFrom() {
        return this.zza.getStringExtra("from");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Intent getIntent() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getMessageId() {
        String stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        return stringExtra == null ? this.zza.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER) : stringExtra;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getMessageType() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getOriginalPriority() {
        String stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.ORIGINAL_PRIORITY);
        if (stringExtra == null) {
            stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return zzb(stringExtra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPriority() {
        String stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.DELIVERED_PRIORITY);
        if (stringExtra == null) {
            if (zza.zza(this.zza.getStringExtra(Constants.MessagePayloadKeys.PRIORITY_REDUCED_V19), AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                return 2;
            }
            stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return zzb(stringExtra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] getRawData() {
        return this.zza.getByteArrayExtra(Constants.MessagePayloadKeys.RAW_DATA);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSenderId() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.SENDER_ID);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getSentTime() {
        Bundle extras = this.zza.getExtras();
        Object obj = extras != null ? extras.get(Constants.MessagePayloadKeys.SENT_TIME) : null;
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("CloudMessage", "Invalid sent time: ".concat(String.valueOf(String.valueOf(obj))));
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getTo() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.f438TO);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTtl() {
        Bundle extras = this.zza.getExtras();
        Object obj = extras != null ? extras.get(Constants.MessagePayloadKeys.TTL) : null;
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("CloudMessage", "Invalid TTL: ".concat(String.valueOf(String.valueOf(obj))));
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Integer zza() {
        if (this.zza.hasExtra(Constants.MessagePayloadKeys.PRODUCT_ID)) {
            return Integer.valueOf(this.zza.getIntExtra(Constants.MessagePayloadKeys.PRODUCT_ID, 0));
        }
        return null;
    }
}
