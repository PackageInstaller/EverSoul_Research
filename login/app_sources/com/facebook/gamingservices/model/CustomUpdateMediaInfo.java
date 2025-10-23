package com.facebook.gamingservices.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomUpdateContent.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m839d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CustomUpdateMediaInfo {
    private final String url;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ CustomUpdateMediaInfo copy$default(CustomUpdateMediaInfo customUpdateMediaInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customUpdateMediaInfo.url;
        }
        return customUpdateMediaInfo.copy(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CustomUpdateMediaInfo copy(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new CustomUpdateMediaInfo(url);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CustomUpdateMediaInfo) && Intrinsics.areEqual(this.url, ((CustomUpdateMediaInfo) other).url);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.url.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "CustomUpdateMediaInfo(url=" + this.url + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomUpdateMediaInfo(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUrl() {
        return this.url;
    }
}
