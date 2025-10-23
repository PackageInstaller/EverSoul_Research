package com.kakao.sdk.common.util;

import kotlin.Metadata;

/* compiled from: PersistentKVStore.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0000H&J\b\u0010\u0003\u001a\u00020\u0000H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H&J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000e"}, m839d2 = {"Lcom/kakao/sdk/common/util/PersistentKVStore;", "", "apply", "commit", "getLong", "", "key", "", "fallbackValue", "getString", "putLong", "value", "putString", "remove", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface PersistentKVStore {
    PersistentKVStore apply();

    PersistentKVStore commit();

    long getLong(String key, long fallbackValue);

    String getString(String key, String fallbackValue);

    PersistentKVStore putLong(String key, long value);

    PersistentKVStore putString(String key, String value);

    PersistentKVStore remove(String key);

    /* compiled from: PersistentKVStore.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ String getString$default(PersistentKVStore persistentKVStore, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return persistentKVStore.getString(str, str2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ long getLong$default(PersistentKVStore persistentKVStore, String str, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
            }
            if ((i & 2) != 0) {
                j = 0;
            }
            return persistentKVStore.getLong(str, j);
        }
    }
}
