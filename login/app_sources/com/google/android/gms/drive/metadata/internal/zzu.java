package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.UserMetadata;
import com.kakaogame.KGSession;
import com.kakaogame.server.ServerConstants;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes.dex */
public final class zzu extends zzm<UserMetadata> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzu(String str, int i) {
        super(str, Arrays.asList(zza(str, "permissionId"), zza(str, KGSession.KGAppInfo.KEY_DISPLAY_NAME), zza(str, "picture"), zza(str, "isAuthenticatedUser"), zza(str, ServerConstants.EMAIL_ADDRESS)), Collections.emptyList(), GmsVersion.VERSION_MANCHEGO);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    protected final boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.hasColumn(zzh("permissionId")) && !dataHolder.hasNull(zzh("permissionId"), i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zzh(String str) {
        return zza(getName(), str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String zza(String str, String str2) {
        return new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()).append(str).append(".").append(str2).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        String string = dataHolder.getString(zzh("permissionId"), i, i2);
        if (string == null) {
            return null;
        }
        String string2 = dataHolder.getString(zzh(KGSession.KGAppInfo.KEY_DISPLAY_NAME), i, i2);
        String string3 = dataHolder.getString(zzh("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.getBoolean(zzh("isAuthenticatedUser"), i, i2));
        return new UserMetadata(string, string2, string3, valueOf.booleanValue(), dataHolder.getString(zzh(ServerConstants.EMAIL_ADDRESS), i, i2));
    }
}
