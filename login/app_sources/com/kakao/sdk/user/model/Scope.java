package com.kakao.sdk.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.user.Constants;
import com.kakaogame.KGSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScopeInfo.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010JX\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020#HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020#HÖ\u0001R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006."}, m839d2 = {"Lcom/kakao/sdk/user/model/Scope;", "Landroid/os/Parcelable;", "id", "", KGSession.KGAppInfo.KEY_DISPLAY_NAME, "type", "Lcom/kakao/sdk/user/model/ScopeType;", Constants.USING, "", Constants.DELEGATED, Constants.AGREED, Constants.REVOCABLE, "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/user/model/ScopeType;ZLjava/lang/Boolean;ZLjava/lang/Boolean;)V", "getAgreed", "()Z", "getDelegated", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplayName", "()Ljava/lang/String;", "getId", "getRevocable", "getType", "()Lcom/kakao/sdk/user/model/ScopeType;", "getUsing", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/user/model/ScopeType;ZLjava/lang/Boolean;ZLjava/lang/Boolean;)Lcom/kakao/sdk/user/model/Scope;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Scope implements Parcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new Creator();
    private final boolean agreed;
    private final Boolean delegated;
    private final String displayName;
    private final String id;
    private final Boolean revocable;
    private final ScopeType type;
    private final boolean using;

    /* compiled from: ScopeInfo.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Scope> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Scope createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ScopeType valueOf2 = ScopeType.valueOf(parcel.readString());
            boolean z = parcel.readInt() != 0;
            Boolean bool = null;
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Scope(readString, readString2, valueOf2, z, valueOf, z2, bool);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Scope[] newArray(int i) {
            return new Scope[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Scope copy$default(Scope scope, String str, String str2, ScopeType scopeType, boolean z, Boolean bool, boolean z2, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scope.id;
        }
        if ((i & 2) != 0) {
            str2 = scope.displayName;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            scopeType = scope.type;
        }
        ScopeType scopeType2 = scopeType;
        if ((i & 8) != 0) {
            z = scope.using;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            bool = scope.delegated;
        }
        Boolean bool3 = bool;
        if ((i & 32) != 0) {
            z2 = scope.agreed;
        }
        boolean z4 = z2;
        if ((i & 64) != 0) {
            bool2 = scope.revocable;
        }
        return scope.copy(str, str3, scopeType2, z3, bool3, z4, bool2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.displayName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ScopeType component3() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component4() {
        return this.using;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component5() {
        return this.delegated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component6() {
        return this.agreed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component7() {
        return this.revocable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Scope copy(String id, String displayName, ScopeType type, boolean using, Boolean delegated, boolean agreed, Boolean revocable) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Scope(id, displayName, type, using, delegated, agreed, revocable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Scope)) {
            return false;
        }
        Scope scope = (Scope) other;
        return Intrinsics.areEqual(this.id, scope.id) && Intrinsics.areEqual(this.displayName, scope.displayName) && this.type == scope.type && this.using == scope.using && Intrinsics.areEqual(this.delegated, scope.delegated) && this.agreed == scope.agreed && Intrinsics.areEqual(this.revocable, scope.revocable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.type.hashCode()) * 31;
        boolean z = this.using;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        Boolean bool = this.delegated;
        int hashCode2 = (i2 + (bool == null ? 0 : bool.hashCode())) * 31;
        boolean z2 = this.agreed;
        int i3 = (hashCode2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        Boolean bool2 = this.revocable;
        return i3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Scope(id=" + this.id + ", displayName=" + this.displayName + ", type=" + this.type + ", using=" + this.using + ", delegated=" + this.delegated + ", agreed=" + this.agreed + ", revocable=" + this.revocable + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.displayName);
        parcel.writeString(this.type.name());
        parcel.writeInt(this.using ? 1 : 0);
        Boolean bool = this.delegated;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeInt(this.agreed ? 1 : 0);
        Boolean bool2 = this.revocable;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Scope(String id, String displayName, ScopeType type, boolean z, Boolean bool, boolean z2, Boolean bool2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.displayName = displayName;
        this.type = type;
        this.using = z;
        this.delegated = bool;
        this.agreed = z2;
        this.revocable = bool2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ScopeType getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getUsing() {
        return this.using;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getDelegated() {
        return this.delegated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getAgreed() {
        return this.agreed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getRevocable() {
        return this.revocable;
    }
}
