package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CustomPropertyKey extends AbstractSafeParcelable {
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;
    private final int visibility;
    private final String zziz;
    public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new zzc();
    private static final Pattern zzja = Pattern.compile("[\\w.!@$%^&*()/-]+");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomPropertyKey(String str, int i) {
        Preconditions.checkNotNull(str, "key");
        Preconditions.checkArgument(zzja.matcher(str).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "visibility must be either PUBLIC or PRIVATE");
        this.zziz = str;
        this.visibility = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zziz, false);
        SafeParcelWriter.writeInt(parcel, 3, this.visibility);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getKey() {
        return this.zziz;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getVisibility() {
        return this.visibility;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.zziz;
        return new StringBuilder(String.valueOf(str).length() + 11).append(str).append(this.visibility).toString().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
            if (customPropertyKey.getKey().equals(this.zziz) && customPropertyKey.getVisibility() == this.visibility) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        String str = this.zziz;
        return new StringBuilder(String.valueOf(str).length() + 31).append("CustomPropertyKey(").append(str).append(",").append(this.visibility).append(")").toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", getKey());
        jSONObject.put("visibility", getVisibility());
        return jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomPropertyKey fromJson(JSONObject jSONObject) throws JSONException {
        return new CustomPropertyKey(jSONObject.getString("key"), jSONObject.getInt("visibility"));
    }
}
