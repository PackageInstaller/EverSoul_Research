package com.kakaogame.security;

import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SecondaryPWService.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\f¨\u0006\u0017"}, m839d2 = {"Lcom/kakaogame/security/UserState;", "", "isRegistered", "", "isBlocked", "blockMin", "", "blockSec", "(ZZII)V", "getBlockMin", "()I", "getBlockSec", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserState {
    private final int blockMin;
    private final int blockSec;
    private final boolean isBlocked;
    private final boolean isRegistered;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ UserState copy$default(UserState userState, boolean z, boolean z2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = userState.isRegistered;
        }
        if ((i3 & 2) != 0) {
            z2 = userState.isBlocked;
        }
        if ((i3 & 4) != 0) {
            i = userState.blockMin;
        }
        if ((i3 & 8) != 0) {
            i2 = userState.blockSec;
        }
        return userState.copy(z, z2, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component1() {
        return this.isRegistered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component2() {
        return this.isBlocked;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component3() {
        return this.blockMin;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component4() {
        return this.blockSec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final UserState copy(boolean isRegistered, boolean isBlocked, int blockMin, int blockSec) {
        return new UserState(isRegistered, isBlocked, blockMin, blockSec);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserState)) {
            return false;
        }
        UserState userState = (UserState) other;
        return this.isRegistered == userState.isRegistered && this.isBlocked == userState.isBlocked && this.blockMin == userState.blockMin && this.blockSec == userState.blockSec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((((Boolean.hashCode(this.isRegistered) * 31) + Boolean.hashCode(this.isBlocked)) * 31) + Integer.hashCode(this.blockMin)) * 31) + Integer.hashCode(this.blockSec);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1159072503) + this.isRegistered + y.٬ݯح׭٩(576351438) + this.isBlocked + y.ݮڮֲڭܩ(-628253380) + this.blockMin + y.֬ڱܱײٮ(-1159072535) + this.blockSec + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserState(boolean z, boolean z2, int i, int i2) {
        this.isRegistered = z;
        this.isBlocked = z2;
        this.blockMin = i;
        this.blockSec = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ UserState(boolean z, boolean z2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isRegistered() {
        return this.isRegistered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isBlocked() {
        return this.isBlocked;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getBlockMin() {
        return this.blockMin;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getBlockSec() {
        return this.blockSec;
    }
}
