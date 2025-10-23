package com.kakaogame.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.messaging.Constants;
import com.kakaogame.Logger;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputUtil.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ&\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/util/InputUtil;", "", "()V", "TAG", "", "hideKeyboard", "", "activity", "Landroid/app/Activity;", "setClipboardText", "context", "Landroid/content/Context;", Constants.ScionAnalytics.PARAM_LABEL, "text", "showKeyboard", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InputUtil {
    public static final InputUtil INSTANCE = new InputUtil();
    private static final String TAG = "InputUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InputUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showKeyboard(Activity activity, View view) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628191700);
        String str2 = y.٬ݯح׭٩(576290326);
        logger.m706v(str2, str);
        try {
            if (activity == null) {
                Logger.INSTANCE.m708w(str2, "activity is null");
                return;
            }
            if (view == null) {
                Logger.INSTANCE.m708w(str2, "view is null");
                return;
            }
            view.requestFocus();
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(view, 1);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void hideKeyboard(Activity activity) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862900355);
        String str2 = y.٬ݯح׭٩(576290326);
        logger.m706v(str2, str);
        try {
            if (activity == null) {
                Logger.INSTANCE.m708w(str2, "activity is null");
                return;
            }
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                Logger.INSTANCE.m708w(str2, "current focus view is null");
                return;
            }
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setClipboardText(Context context, String label, String text) {
        if (context != null) {
            Object systemService = context.getSystemService(y.٬ݯح׭٩(576289558));
            Intrinsics.checkNotNull(systemService, y.ݬֲ֮ܲت(1512281319));
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(label, text));
        }
    }
}
