package com.kakao.sdk.common.util;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedPrefsWrapper.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0001H\u0016J\b\u0010\n\u001a\u00020\u0001H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakao/sdk/common/util/SharedPrefsWrapper;", "Lcom/kakao/sdk/common/util/PersistentKVStore;", "appCache", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getAppCache", "()Landroid/content/SharedPreferences;", "editor", "Landroid/content/SharedPreferences$Editor;", "apply", "commit", "getLong", "", "key", "", "fallbackValue", "getString", "putLong", "value", "putString", "remove", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SharedPrefsWrapper implements PersistentKVStore {
    private final SharedPreferences appCache;
    private final SharedPreferences.Editor editor;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SharedPrefsWrapper(SharedPreferences appCache) {
        Intrinsics.checkNotNullParameter(appCache, "appCache");
        this.appCache = appCache;
        SharedPreferences.Editor edit = appCache.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "appCache.edit()");
        this.editor = edit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SharedPreferences getAppCache() {
        return this.appCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.PersistentKVStore
    public PersistentKVStore remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.editor.remove(key);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.PersistentKVStore
    public String getString(String key, String fallbackValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.appCache.getString(key, fallbackValue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.PersistentKVStore
    public long getLong(String key, long fallbackValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.appCache.getLong(key, fallbackValue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.PersistentKVStore
    public PersistentKVStore putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.editor.putString(key, value);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.PersistentKVStore
    public PersistentKVStore putLong(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.editor.putLong(key, value);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.PersistentKVStore
    public PersistentKVStore commit() {
        this.editor.commit();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.PersistentKVStore
    public PersistentKVStore apply() {
        this.editor.apply();
        return this;
    }
}
