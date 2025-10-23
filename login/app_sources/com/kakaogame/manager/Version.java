package com.kakaogame.manager;

import com.kakaogame.Logger;
import com.liapp.y;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Version.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016J\u0011\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0002J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0004¨\u0006&"}, m839d2 = {"Lcom/kakaogame/manager/Version;", "Ljava/util/Comparator;", "versionString", "", "(Ljava/lang/String;)V", "buildType", "getBuildType", "()Ljava/lang/String;", "setBuildType", "maintenanceVersion", "", "getMaintenanceVersion", "()I", "setMaintenanceVersion", "(I)V", "majorVersion", "getMajorVersion", "setMajorVersion", "minorVersion", "getMinorVersion", "setMinorVersion", "revision", "getRevision", "setRevision", "version", "getVersion", "setVersion", "compare", "lhs", "rhs", "compareTo", "anotherVersion", "equals", "", "obj", "", "toString", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Version implements Comparator<Version> {
    private static final String TAG = "Version";
    private String buildType;
    private int maintenanceVersion;
    private int majorVersion;
    private int minorVersion;
    private int revision;
    private String version;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Version(String str) {
        String str2 = y.ݮڮֲڭܩ(-628412556);
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576511926));
        this.version = "";
        this.buildType = y.٬ݯح׭٩(576511950);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ٲٴݴ״ٰ(1782188880) + str;
        String str4 = y.ۮڭڭܬި(862682539);
        logger.m699d(str4, str3);
        try {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"-"}, false, 0, 6, (Object) null);
            this.version = (String) split$default.get(0);
            List split$default2 = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            Logger.INSTANCE.m699d(str4, str2 + split$default2.size());
            if (!split$default2.isEmpty()) {
                if (((CharSequence) split$default2.get(0)).length() > 0) {
                    this.majorVersion = Integer.parseInt((String) split$default2.get(0));
                }
            }
            if (split$default2.size() >= 2) {
                if (((CharSequence) split$default2.get(1)).length() > 0) {
                    this.minorVersion = Integer.parseInt((String) split$default2.get(1));
                }
            }
            if (split$default2.size() >= 3) {
                if (((CharSequence) split$default2.get(2)).length() > 0) {
                    this.maintenanceVersion = Integer.parseInt((String) split$default2.get(2));
                }
            }
            if (split$default2.size() >= 4) {
                if (((CharSequence) split$default2.get(3)).length() > 0) {
                    this.revision = Integer.parseInt((String) split$default2.get(3));
                }
            }
            if (split$default.size() >= 2) {
                this.buildType = (String) split$default.get(1);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getVersion() {
        return this.version;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        this.version = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getMajorVersion() {
        return this.majorVersion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setMajorVersion(int i) {
        this.majorVersion = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getMinorVersion() {
        return this.minorVersion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setMinorVersion(int i) {
        this.minorVersion = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getMaintenanceVersion() {
        return this.maintenanceVersion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setMaintenanceVersion(int i) {
        this.maintenanceVersion = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRevision() {
        return this.revision;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setRevision(int i) {
        this.revision = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBuildType() {
        return this.buildType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setBuildType(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        this.buildType = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(getClass(), obj.getClass())) {
            return false;
        }
        Version version = (Version) obj;
        return this.majorVersion == version.majorVersion && this.minorVersion == version.minorVersion && this.maintenanceVersion == version.maintenanceVersion && this.revision == version.revision;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Comparator
    public int compare(Version lhs, Version rhs) {
        Intrinsics.checkNotNullParameter(lhs, y.ٲٴݴ״ٰ(1781808512));
        Intrinsics.checkNotNullParameter(rhs, y.ۮڭڭܬި(862276491));
        int i = lhs.majorVersion - rhs.majorVersion;
        if (i != 0) {
            return i;
        }
        int i2 = lhs.minorVersion - rhs.minorVersion;
        if (i2 != 0) {
            return i2;
        }
        int i3 = lhs.maintenanceVersion - rhs.maintenanceVersion;
        return i3 != 0 ? i3 : lhs.revision - rhs.revision;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int compareTo(Version anotherVersion) {
        Intrinsics.checkNotNullParameter(anotherVersion, y.֬ڱܱײٮ(-1158723111));
        int compare = compare(this, anotherVersion);
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862682539), y.ٴسسݬߨ(1393497402) + compare);
        return compare;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݬֲ֮ܲت(1512455767) + this.version + y.ۮڭڭܬި(862682963) + this.majorVersion + y.ٴسسݬߨ(1393497778) + this.minorVersion + y.֬ڱܱײٮ(-1158722999) + this.maintenanceVersion + y.ݮڮֲڭܩ(-628415364) + this.revision + y.ٴسسݬߨ(1393496266) + this.buildType + ']';
    }
}
