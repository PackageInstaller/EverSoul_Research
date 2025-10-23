package com.facebook.gamingservices;

import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GamingContext.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m839d2 = {"Lcom/facebook/gamingservices/GamingContext;", "", "contextID", "", "(Ljava/lang/String;)V", "getContextID", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GamingContext {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_TIMEOUT = 5;
    private static GamingContext currentContext;
    private final String contextID;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ GamingContext copy$default(GamingContext gamingContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gamingContext.contextID;
        }
        return gamingContext.copy(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final GamingContext getCurrentGamingContext() {
        return INSTANCE.getCurrentGamingContext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setCurrentGamingContext(GamingContext gamingContext) {
        INSTANCE.setCurrentGamingContext(gamingContext);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.contextID;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final GamingContext copy(String contextID) {
        Intrinsics.checkNotNullParameter(contextID, "contextID");
        return new GamingContext(contextID);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GamingContext) && Intrinsics.areEqual(this.contextID, ((GamingContext) other).contextID);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.contextID.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "GamingContext(contextID=" + this.contextID + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GamingContext(String contextID) {
        Intrinsics.checkNotNullParameter(contextID, "contextID");
        this.contextID = contextID;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getContextID() {
        return this.contextID;
    }

    /* compiled from: GamingContext.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m839d2 = {"Lcom/facebook/gamingservices/GamingContext$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "currentContext", "Lcom/facebook/gamingservices/GamingContext;", "getCurrentGamingContext", "setCurrentGamingContext", "", "ctx", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final GamingContext getCurrentGamingContext() {
            JSONObject jSONObject;
            if (!CloudGameLoginHandler.isRunningInCloud()) {
                return GamingContext.currentContext;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            GraphResponse executeAndWait = DaemonRequest.executeAndWait(FacebookSdk.getApplicationContext(), null, SDKMessageEnum.CONTEXT_GET_ID, 5);
            String string = (executeAndWait == null || (jSONObject = executeAndWait.getJSONObject()) == null) ? null : jSONObject.getString("id");
            if (string == null) {
                return null;
            }
            return new GamingContext(string);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void setCurrentGamingContext(GamingContext ctx) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            if (CloudGameLoginHandler.isRunningInCloud()) {
                return;
            }
            GamingContext.currentContext = ctx;
        }
    }
}
