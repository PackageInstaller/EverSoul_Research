package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.CustomTabPrefetchHelper;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTab.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, m839d2 = {"Lcom/facebook/internal/CustomTab;", "", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "openCustomTab", "", "activity", "Landroid/app/Activity;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "Companion", "facebook-common_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public class CustomTab {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Uri uri;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static Uri getURIForAction(String str, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(CustomTab.class)) {
            return null;
        }
        try {
            return INSTANCE.getURIForAction(str, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CustomTab.class);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomTab(String action, Bundle bundle) {
        Uri uRIForAction;
        Intrinsics.checkNotNullParameter(action, "action");
        bundle = bundle == null ? new Bundle() : bundle;
        GamingAction[] valuesCustom = GamingAction.valuesCustom();
        ArrayList arrayList = new ArrayList(valuesCustom.length);
        for (GamingAction gamingAction : valuesCustom) {
            arrayList.add(gamingAction.getRawValue());
        }
        if (arrayList.contains(action)) {
            Utility utility = Utility.INSTANCE;
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            uRIForAction = Utility.buildUri(ServerProtocol.getGamingDialogAuthority(), Intrinsics.stringPlus("/dialog/", action), bundle);
        } else {
            uRIForAction = INSTANCE.getURIForAction(action, bundle);
        }
        this.uri = uRIForAction;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final Uri getUri() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setUri(Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(uri, "<set-?>");
            this.uri = uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean openCustomTab(Activity activity, String packageName) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            CustomTabsIntent build = new CustomTabsIntent.Builder(CustomTabPrefetchHelper.INSTANCE.getPreparedSessionOnce()).build();
            build.intent.setPackage(packageName);
            try {
                build.launchUrl(activity, this.uri);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* compiled from: CustomTab.kt */
    @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017¨\u0006\t"}, m839d2 = {"Lcom/facebook/internal/CustomTab$Companion;", "", "()V", "getURIForAction", "Landroid/net/Uri;", "action", "", "parameters", "Landroid/os/Bundle;", "facebook-common_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
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
        public Uri getURIForAction(String action, Bundle parameters) {
            Intrinsics.checkNotNullParameter(action, "action");
            Utility utility = Utility.INSTANCE;
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            String dialogAuthority = ServerProtocol.getDialogAuthority();
            StringBuilder sb = new StringBuilder();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return Utility.buildUri(dialogAuthority, sb.append(FacebookSdk.getGraphApiVersion()).append("/dialog/").append(action).toString(), parameters);
        }
    }
}
