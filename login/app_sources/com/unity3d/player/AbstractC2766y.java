package com.unity3d.player;

import android.view.inputmethod.InputMethodSubtype;

/* renamed from: com.unity3d.player.y */
/* loaded from: classes3.dex */
abstract class AbstractC2766y {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static String m836a(InputMethodSubtype inputMethodSubtype) {
        return PlatformSupport.NOUGAT_SUPPORT ? inputMethodSubtype.getLanguageTag() : inputMethodSubtype.getLocale();
    }
}
