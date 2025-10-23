package com.yasirkula.unity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.liapp.y;

/* loaded from: classes3.dex */
public class DebugConsole {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void CopyText(Context context, String str) {
        ((ClipboardManager) context.getSystemService(y.٬ݯح׭٩(576289558))).setPrimaryClip(ClipData.newPlainText(y.دײܮڳܯ(2051241165), str));
    }
}
