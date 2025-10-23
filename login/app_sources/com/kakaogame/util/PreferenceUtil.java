package com.kakaogame.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreferenceUtil.kt */
@Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007J\"\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007J*\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0007J \u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J*\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0010H\u0007J$\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007J.\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\"\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007J*\u0010\u0015\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0007J*\u0010\u0017\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0007J*\u0010\u0018\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/util/PreferenceUtil;", "", "()V", "PREFERENCES_MODE", "", "TAG", "", "contains", "", "context", "Landroid/content/Context;", "name", "key", "getBoolean", "defValue", "getLong", "", "getString", "remove", "", "removeKey", "setBoolean", "value", "setLong", "setString", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PreferenceUtil {
    public static final PreferenceUtil INSTANCE = new PreferenceUtil();
    private static final int PREFERENCES_MODE = 0;
    private static final String TAG = "PreferenceUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PreferenceUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean contains(Context context, String name, String key) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        String str = y.֬ڱܱײٮ(-1159015383) + name + y.ݮڮֲڭܩ(-628756788) + key;
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, str);
        if (context == null) {
            return false;
        }
        try {
            boolean z = true;
            if (name.length() == 0) {
                return false;
            }
            if (key.length() != 0) {
                z = false;
            }
            if (z || (sharedPreferences = context.getSharedPreferences(name, 0)) == null) {
                return false;
            }
            return sharedPreferences.contains(key);
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean getBoolean(Context context, String name, String key) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        return getBoolean(context, name, key, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean getBoolean(Context context, String name, String key, boolean defValue) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        StringBuilder append = new StringBuilder(y.٬ݯح׭٩(576277958)).append(name);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(key).append(str).append(defValue).toString();
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, sb);
        if (context == null) {
            return defValue;
        }
        try {
            boolean z = true;
            if (name.length() == 0) {
                return defValue;
            }
            if (key.length() != 0) {
                z = false;
            }
            return (z || (sharedPreferences = context.getSharedPreferences(name, 0)) == null) ? defValue : sharedPreferences.getBoolean(key, defValue);
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
            return defValue;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setBoolean(Context context, String name, String key, boolean value) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        StringBuilder append = new StringBuilder(y.ٲٴݴ״ٰ(1782551752)).append(name);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(key).append(str).append(value).toString();
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, sb);
        try {
            boolean z = true;
            if (name.length() > 0) {
                if (key.length() <= 0) {
                    z = false;
                }
                if (z) {
                    SharedPreferences.Editor edit = (context == null || (sharedPreferences = context.getSharedPreferences(name, 0)) == null) ? null : sharedPreferences.edit();
                    if (edit != null) {
                        edit.putBoolean(key, value);
                        edit.commit();
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getLong(Context context, String name, String key) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        return getLong(context, name, key, 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final long getLong(Context context, String name, String key, long defValue) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        StringBuilder append = new StringBuilder(y.֬ڱܱײٮ(-1159014567)).append(name);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(key).append(str).append(defValue).toString();
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, sb);
        if (context == null) {
            return defValue;
        }
        try {
            boolean z = true;
            if (name.length() == 0) {
                return defValue;
            }
            if (key.length() != 0) {
                z = false;
            }
            return (z || (sharedPreferences = context.getSharedPreferences(name, 0)) == null) ? defValue : sharedPreferences.getLong(key, defValue);
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
            return defValue;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setLong(Context context, String name, String key, long value) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        StringBuilder append = new StringBuilder(y.ٴسسݬߨ(1393198098)).append(name);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(key).append(str).append(value).toString();
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, sb);
        try {
            boolean z = true;
            if (name.length() > 0) {
                if (key.length() <= 0) {
                    z = false;
                }
                if (z) {
                    SharedPreferences.Editor edit = (context == null || (sharedPreferences = context.getSharedPreferences(name, 0)) == null) ? null : sharedPreferences.edit();
                    if (edit != null) {
                        edit.putLong(key, value);
                        edit.commit();
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getString(Context context, String name, String key) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        return getString(context, name, key, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getString(Context context, String name, String key, String defValue) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        StringBuilder append = new StringBuilder(y.ٲٴݴ״ٰ(1782551976)).append(name);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(key).append(str).append(defValue).toString();
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, sb);
        if (context == null) {
            return defValue;
        }
        try {
            boolean z = true;
            if (name.length() == 0) {
                return defValue;
            }
            if (key.length() != 0) {
                z = false;
            }
            if (!z && (sharedPreferences = context.getSharedPreferences(name, 0)) != null) {
                String string = sharedPreferences.getString(key, defValue);
                if (string != null) {
                    return string;
                }
            }
            return defValue;
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
            return defValue;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setString(Context context, String name, String key, String value) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Intrinsics.checkNotNullParameter(value, y.ݬֲ֮ܲت(1512942783));
        StringBuilder append = new StringBuilder(y.دײܮڳܯ(2051245781)).append(name);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(key).append(str).append(value).toString();
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, sb);
        try {
            boolean z = true;
            if (name.length() > 0) {
                if (key.length() <= 0) {
                    z = false;
                }
                if (z) {
                    SharedPreferences.Editor edit = (context == null || (sharedPreferences = context.getSharedPreferences(name, 0)) == null) ? null : sharedPreferences.edit();
                    if (edit != null) {
                        edit.putString(key, value);
                        edit.commit();
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void remove(Context context, String name) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        String str = y.ݬֲ֮ܲت(1512284351) + name;
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, str);
        try {
            if (name.length() > 0) {
                SharedPreferences.Editor edit = (context == null || (sharedPreferences = context.getSharedPreferences(name, 0)) == null) ? null : sharedPreferences.edit();
                if (edit != null) {
                    edit.clear();
                    edit.commit();
                }
            }
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void removeKey(Context context, String name, String key) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        String str = y.ݬֲ֮ܲت(1512284399) + name + y.ݮڮֲڭܩ(-628756788) + key;
        String str2 = y.ݬֲ֮ܲت(1512284911);
        Log.v(str2, str);
        try {
            boolean z = true;
            if (name.length() > 0) {
                if (key.length() <= 0) {
                    z = false;
                }
                if (z) {
                    SharedPreferences.Editor edit = (context == null || (sharedPreferences = context.getSharedPreferences(name, 0)) == null) ? null : sharedPreferences.edit();
                    if (edit != null) {
                        edit.remove(key);
                        edit.commit();
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(str2, th.toString(), th);
        }
    }
}
