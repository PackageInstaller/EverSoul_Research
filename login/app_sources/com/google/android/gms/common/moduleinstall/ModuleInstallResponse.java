package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new zad();
    private final int zaa;
    private final boolean zab;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ModuleInstallResponse(int i) {
        this(i, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean areModulesAlreadyInstalled() {
        return this.zaa == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSessionId() {
        return this.zaa;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getSessionId());
        SafeParcelWriter.writeBoolean(parcel, 2, this.zab);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zaa() {
        return this.zab;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ModuleInstallResponse(int i, boolean z) {
        this.zaa = i;
        this.zab = z;
    }
}
