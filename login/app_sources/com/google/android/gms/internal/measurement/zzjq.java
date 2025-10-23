package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public class zzjq extends IOException {
    private zzkr zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjp zza() {
        return new zzjp("Protocol message tag had invalid wire type.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjq zzb() {
        return new zzjq("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjq zzc() {
        return new zzjq("Protocol message contained an invalid tag (zero).");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjq zzd() {
        return new zzjq("Protocol message had invalid UTF-8.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjq zze() {
        return new zzjq("CodedInputStream encountered a malformed varint.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjq zzf() {
        return new zzjq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjq zzg() {
        return new zzjq("Failed to parse the message.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjq zzh() {
        return new zzjq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzjq(String str) {
        super(str);
        this.zza = null;
    }
}
