package com.kakaogame.core;

import android.content.Context;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.server.ServerService;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConnectionManager.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\"\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/core/ConnectionManager;", "", "()V", "PREF_NAME", "", "TAG", "isHttpConnection", "", "context", "Landroid/content/Context;", "config", "Lcom/kakaogame/config/Configuration;", "setConnectionType", "", "useHttpConnection", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ConnectionManager {
    public static final ConnectionManager INSTANCE = new ConnectionManager();
    private static final String PREF_NAME = "SeverConnectionType";
    private static final String TAG = "ConnectionManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConnectionManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isHttpConnection(Context context, Configuration config) {
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        String appId = config.getAppId();
        String serverTypeString = config.getServerTypeString();
        if (!StringsKt.equals(Configuration.KGServerType.LIVE.getValue(), serverTypeString, true)) {
            appId = appId + '_' + serverTypeString;
        }
        boolean z = PreferenceUtil.getBoolean(context, PREF_NAME, appId, false);
        Logger.INSTANCE.m704i(y.٬ݯح׭٩(576592582), y.ٲٴݴ״ٰ(1782104408) + appId + y.ݮڮֲڭܩ(-628756788) + z);
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setConnectionType(Context context, Configuration config, boolean useHttpConnection) {
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        String appId = config.getAppId();
        String serverTypeString = config.getServerTypeString();
        if (!StringsKt.equals(Configuration.KGServerType.LIVE.getValue(), serverTypeString, true)) {
            appId = appId + '_' + serverTypeString;
        }
        if (!SDKVersion.isPublishing) {
            useHttpConnection = true;
        }
        PreferenceUtil.setBoolean(context, PREF_NAME, appId, useHttpConnection);
        Logger.INSTANCE.m704i(y.٬ݯح׭٩(576592582), y.ݮڮֲڭܩ(-628495396) + appId + y.ݮڮֲڭܩ(-628756788) + useHttpConnection);
        if (useHttpConnection) {
            ServerService.useHttpConnection();
        } else {
            ServerService.useSessionConnection();
        }
    }
}
