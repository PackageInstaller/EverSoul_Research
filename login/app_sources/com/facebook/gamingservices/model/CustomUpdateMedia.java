package com.facebook.gamingservices.model;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CustomUpdateContent.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, m839d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "", "gif", "Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "(Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;)V", "getGif", "()Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "getVideo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CustomUpdateMedia {
    private final CustomUpdateMediaInfo gif;
    private final CustomUpdateMediaInfo video;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomUpdateMedia() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ CustomUpdateMedia copy$default(CustomUpdateMedia customUpdateMedia, CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            customUpdateMediaInfo = customUpdateMedia.gif;
        }
        if ((i & 2) != 0) {
            customUpdateMediaInfo2 = customUpdateMedia.video;
        }
        return customUpdateMedia.copy(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CustomUpdateMediaInfo component1() {
        return this.gif;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CustomUpdateMediaInfo component2() {
        return this.video;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CustomUpdateMedia copy(CustomUpdateMediaInfo gif, CustomUpdateMediaInfo video) {
        return new CustomUpdateMedia(gif, video);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomUpdateMedia)) {
            return false;
        }
        CustomUpdateMedia customUpdateMedia = (CustomUpdateMedia) other;
        return Intrinsics.areEqual(this.gif, customUpdateMedia.gif) && Intrinsics.areEqual(this.video, customUpdateMedia.video);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        int hashCode = (customUpdateMediaInfo == null ? 0 : customUpdateMediaInfo.hashCode()) * 31;
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        return hashCode + (customUpdateMediaInfo2 != null ? customUpdateMediaInfo2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "CustomUpdateMedia(gif=" + this.gif + ", video=" + this.video + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2) {
        this.gif = customUpdateMediaInfo;
        this.video = customUpdateMediaInfo2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : customUpdateMediaInfo, (i & 2) != 0 ? null : customUpdateMediaInfo2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CustomUpdateMediaInfo getGif() {
        return this.gif;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CustomUpdateMediaInfo getVideo() {
        return this.video;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        if (customUpdateMediaInfo != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", customUpdateMediaInfo.getUrl());
            jSONObject.put("gif", jSONObject2);
        }
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        if (customUpdateMediaInfo2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("url", customUpdateMediaInfo2.getUrl());
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, jSONObject3);
        }
        return jSONObject;
    }
}
