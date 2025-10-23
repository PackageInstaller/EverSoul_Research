package com.google.zxing.client.result;

/* loaded from: classes3.dex */
abstract class AbstractDoCoMoResultParser extends ResultParser {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AbstractDoCoMoResultParser() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String[] matchDoCoMoPrefixedField(String str, String str2, boolean z) {
        return matchPrefixedField(str, str2, ';', z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String matchSingleDoCoMoPrefixedField(String str, String str2, boolean z) {
        return matchSinglePrefixedField(str, str2, ';', z);
    }
}
