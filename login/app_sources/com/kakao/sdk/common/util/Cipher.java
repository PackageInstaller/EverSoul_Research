package com.kakao.sdk.common.util;

import kotlin.Metadata;

/* compiled from: Cipher.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m839d2 = {"Lcom/kakao/sdk/common/util/Cipher;", "", "decrypt", "", "encrypted", "encrypt", "value", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface Cipher {
    String decrypt(String encrypted);

    String encrypt(String value);
}
