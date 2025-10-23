package com.facebook.bolts;

import android.net.Uri;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppLink.kt */
@Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, m839d2 = {"Lcom/facebook/bolts/AppLink;", "", "sourceUrl", "Landroid/net/Uri;", "targets", "", "Lcom/facebook/bolts/AppLink$Target;", "webUrl", "(Landroid/net/Uri;Ljava/util/List;Landroid/net/Uri;)V", "getSourceUrl", "()Landroid/net/Uri;", "getTargets", "()Ljava/util/List;", "getWebUrl", "Target", "facebook-bolts_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class AppLink {
    private final Uri sourceUrl;
    private final List<Target> targets;
    private final Uri webUrl;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppLink(Uri sourceUrl, List<Target> list, Uri webUrl) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        this.sourceUrl = sourceUrl;
        this.webUrl = webUrl;
        this.targets = list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri getSourceUrl() {
        return this.sourceUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri getWebUrl() {
        return this.webUrl;
    }

    /* compiled from: AppLink.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m839d2 = {"Lcom/facebook/bolts/AppLink$Target;", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "className", "url", "Landroid/net/Uri;", "appName", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getClassName", "getPackageName", "getUrl", "()Landroid/net/Uri;", "facebook-bolts_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Target {
        private final String appName;
        private final String className;
        private final String packageName;
        private final Uri url;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Target(String packageName, String className, Uri url, String appName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(appName, "appName");
            this.packageName = packageName;
            this.className = className;
            this.url = url;
            this.appName = appName;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getPackageName() {
            return this.packageName;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getClassName() {
            return this.className;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Uri getUrl() {
            return this.url;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getAppName() {
            return this.appName;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Target> getTargets() {
        List<Target> unmodifiableList = Collections.unmodifiableList(this.targets);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(field)");
        return unmodifiableList;
    }
}
