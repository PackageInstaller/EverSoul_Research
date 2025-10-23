package com.kakaogame.log;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.kakaogame.Logger;
import com.kakaogame.log.service.BasicLogService;
import com.liapp.y;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: KGSelectorReceiver.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/log/KGSelectorReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "sendSelectedChannelLog", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGSelectorReceiver extends BroadcastReceiver {
    private static final String CODE_COPY = "etccopy";
    private static final String CODE_EMAIL = "etcemail";
    private static final String CODE_FACEBOOK = "etcfb";
    private static final String CODE_KAKAO = "etckko";
    private static final String CODE_MESSAGE = "etcmsg";
    private static final String CODE_OTHERS = "etcother";
    private static final String CODE_TWITTER = "etctw";
    private static final String TAG = "KGSelectorReceiver";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(intent, y.ݬֲ֮ܲت(1512852487));
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576470814);
        String str2 = y.ݬֲ֮ܲت(1512493063);
        logger.m699d(str2, str);
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        for (String str3 : extras.keySet()) {
            try {
                Bundle extras2 = intent.getExtras();
                Intrinsics.checkNotNull(extras2);
                ComponentName componentName = (ComponentName) extras2.get(str3);
                PackageManager packageManager = context.getPackageManager();
                Intrinsics.checkNotNull(componentName);
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(componentName.getPackageName(), 128));
                Intrinsics.checkNotNull(applicationLabel, "null cannot be cast to non-null type kotlin.String");
                Logger.INSTANCE.m699d(str2, "Application Name: " + ((String) applicationLabel) + " :  " + componentName.getPackageName());
                String packageName = componentName.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                sendSelectedChannelLog(context, packageName);
            } catch (Exception unused) {
                Logger.INSTANCE.m701e(str2, y.ۮڭڭܬި(862690571));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendSelectedChannelLog(Context context, String packageName) {
        String str;
        String str2;
        String lowerCase = packageName.toLowerCase(Locale.ROOT);
        String str3 = y.ݮڮֲڭܩ(-628797244);
        Intrinsics.checkNotNullExpressionValue(lowerCase, str3);
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) y.ۮڭڭܬި(862689179), false, 2, (Object) null)) {
            str = CODE_KAKAO;
        } else {
            String lowerCase2 = packageName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, str3);
            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) y.ۮڭڭܬި(862688795), false, 2, (Object) null)) {
                str = CODE_FACEBOOK;
            } else {
                String lowerCase3 = packageName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, str3);
                if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) y.֬ڱܱײٮ(-1158778103), false, 2, (Object) null)) {
                    str = CODE_TWITTER;
                } else {
                    String lowerCase4 = packageName.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, str3);
                    if (!StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) y.ۮڭڭܬި(862688915), false, 2, (Object) null)) {
                        String lowerCase5 = packageName.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase5, str3);
                        boolean contains$default = StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) y.ۮڭڭܬި(862687539), false, 2, (Object) null);
                        String str4 = y.دײܮڳܯ(2051472053);
                        if (!contains$default) {
                            String lowerCase6 = packageName.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase6, str3);
                            if (!StringsKt.contains$default((CharSequence) lowerCase6, (CharSequence) y.ٲٴݴ״ٰ(1782244864), false, 2, (Object) null)) {
                                String lowerCase7 = packageName.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase7, str3);
                                str = StringsKt.contains$default((CharSequence) lowerCase7, (CharSequence) y.ۮڭڭܬި(862687483), false, 2, (Object) null) ? CODE_COPY : CODE_OTHERS;
                            }
                        }
                        str2 = str4;
                        BasicLogService.writeBasicActionLog(context, y.٬ݯح׭٩(575673646), y.ۮڭڭܬި(862688139), y.ۮڭڭܬި(862688227), str2, null, null, null);
                    }
                    str = CODE_MESSAGE;
                }
            }
        }
        str2 = str;
        BasicLogService.writeBasicActionLog(context, y.٬ݯح׭٩(575673646), y.ۮڭڭܬި(862688139), y.ۮڭڭܬި(862688227), str2, null, null, null);
    }
}
