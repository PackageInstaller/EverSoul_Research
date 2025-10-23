package com.kakaogame.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.kakaogame.Logger;
import com.liapp.y;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p031io.CloseableKt;
import kotlin.p031io.TextStreamsKt;
import kotlin.text.Charsets;

/* compiled from: ResourceUtil.kt */
@Metadata(m838d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J.\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\"\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J7\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0017\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J7\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0017\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0019J'\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, m839d2 = {"Lcom/kakaogame/util/ResourceUtil;", "", "()V", "TAG", "", "getColor", "", "context", "Landroid/content/Context;", "resId", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getLayout", "Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "attachToRoot", "", "getResourceId", "name", "defType", "getString", "obj", "", "(Landroid/content/Context;I[Ljava/lang/Object;)Ljava/lang/String;", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "getStringArray", "(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/String;", "readJSONResource", "resources", "Landroid/content/res/Resources;", "id", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ResourceUtil {
    public static final ResourceUtil INSTANCE = new ResourceUtil();
    private static final String TAG = "ResourceUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ResourceUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getString(Context context, int resId) {
        String str;
        String str2 = y.ݮڮֲڭܩ(-628182692);
        if (context == null) {
            return "";
        }
        if (resId != 0) {
            try {
                try {
                    str = context.getString(resId);
                } catch (Resources.NotFoundException e) {
                    Logger.INSTANCE.m702e(str2, e.toString(), e);
                    str = "Not Defined String";
                }
            } catch (Exception e2) {
                Logger.INSTANCE.m702e(str2, e2.toString(), e2);
                return "";
            }
        } else {
            str = "";
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getString(Context context, String name) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        if (context == null) {
            return "";
        }
        try {
            return getString(context, getResourceId(context, name, TypedValues.Custom.S_STRING));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628182692), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getString(Context context, int resId, Object... obj) {
        String str;
        String str2 = y.ݮڮֲڭܩ(-628182252);
        Intrinsics.checkNotNullParameter(obj, y.ٴسسݬߨ(1393125978));
        String str3 = y.ݮڮֲڭܩ(-628182692);
        if (context == null) {
            return "";
        }
        try {
            if (resId == 0) {
                Logger.INSTANCE.m701e(str3, str2 + resId);
                return "";
            }
            try {
                str = context.getString(resId, Arrays.copyOf(obj, obj.length));
            } catch (Resources.NotFoundException e) {
                Logger.INSTANCE.m702e(str3, e.toString(), e);
                str = "Not Defined String";
            }
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e2) {
            Logger.INSTANCE.m702e(str3, e2.toString(), e2);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getString(Context context, String name, Object... obj) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(obj, y.ٴسسݬߨ(1393125978));
        if (context == null) {
            return "";
        }
        try {
            return getString(context, getResourceId(context, name, TypedValues.Custom.S_STRING), Arrays.copyOf(obj, obj.length));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628182692), e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String[] getStringArray(Context context, String name) {
        String str = y.ݮڮֲڭܩ(-628182252);
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        String str2 = y.ݮڮֲڭܩ(-628182692);
        try {
            if (context == null) {
                return new String[0];
            }
            int resourceId = getResourceId(context, name, "array");
            if (resourceId == 0) {
                Logger.INSTANCE.m701e(str2, str + resourceId);
                return new String[0];
            }
            String[] stringArray = context.getResources().getStringArray(resourceId);
            Intrinsics.checkNotNull(stringArray);
            return stringArray;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return new String[0];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final View getLayout(Context context, int resId) {
        if (context == null) {
            return null;
        }
        try {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            return ((LayoutInflater) systemService).inflate(resId, (ViewGroup) null);
        } catch (InflateException e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628182692), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final View getLayout(Context context, int resId, ViewGroup root, boolean attachToRoot) {
        if (context == null) {
            return null;
        }
        try {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            return ((LayoutInflater) systemService).inflate(resId, root, attachToRoot);
        } catch (InflateException e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int getColor(Context context, int resId) {
        int i = -1;
        if (context == null) {
            return -1;
        }
        String str = y.ݮڮֲڭܩ(-628182692);
        try {
            if (resId == 0) {
                Logger.INSTANCE.m701e(str, "Not Found Color");
            } else {
                try {
                    i = ContextCompat.getColor(context, resId);
                } catch (Resources.NotFoundException e) {
                    Logger.INSTANCE.m702e(str, e.toString(), e);
                }
            }
        } catch (InflateException e2) {
            Logger.INSTANCE.m702e(str, e2.toString(), e2);
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Drawable getDrawable(Context context, int resId) {
        Drawable drawable = null;
        if (context == null) {
            return null;
        }
        String str = y.ݮڮֲڭܩ(-628182692);
        try {
            if (resId == 0) {
                Logger.INSTANCE.m701e(str, "Not Found Drawable");
            } else {
                try {
                    drawable = ContextCompat.getDrawable(context, resId);
                } catch (Resources.NotFoundException e) {
                    Logger.INSTANCE.m702e(str, e.toString(), e);
                }
            }
        } catch (InflateException e2) {
            Logger.INSTANCE.m702e(str, e2.toString(), e2);
        }
        return drawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int getResourceId(Context context, String name, String defType) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(defType, y.ۮڭڭܬި(862907467));
        String str = y.ݮڮֲڭܩ(-628182692);
        String str2 = y.ݮڮֲڭܩ(-628756788);
        if (context != null) {
            if (!(name.length() == 0)) {
                if (!(defType.length() == 0)) {
                    int identifier = context.getResources().getIdentifier(name, defType, context.getPackageName());
                    if (identifier == 0) {
                        Logger.INSTANCE.m701e(str, y.֬ڱܱײٮ(-1159014151) + name + str2 + defType);
                    }
                    return identifier;
                }
            }
        }
        Logger.INSTANCE.m701e(str, y.ٴسسݬߨ(1393198634) + context + str2 + name + str2 + defType);
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String readJSONResource(Resources resources, int id) {
        String str = y.ٲٴݴ״ٰ(1782552816);
        String str2 = y.ݮڮֲڭܩ(-628182692);
        String str3 = y.ٴسسݬߨ(1393197530);
        Intrinsics.checkNotNullParameter(resources, str3);
        InputStream openRawResource = resources.openRawResource(id);
        Intrinsics.checkNotNullExpressionValue(openRawResource, "openRawResource(...)");
        try {
            try {
                try {
                    Reader inputStreamReader = new InputStreamReader(openRawResource, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        str3 = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, null);
                        openRawResource.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        openRawResource.close();
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(str2, str, e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                Logger.INSTANCE.m702e(str2, str, e2);
                str3 = "";
                openRawResource.close();
            }
        } catch (Exception e3) {
            Logger.INSTANCE.m702e(str2, str, e3);
        }
        return str3;
    }
}
