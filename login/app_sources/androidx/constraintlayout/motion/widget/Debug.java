package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class Debug {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logStack(String tag, String msg, int n) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(n, stackTrace.length - 1);
        String str = StringUtils.SPACE;
        for (int i = 1; i <= min; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            String str2 = ".(" + stackTrace[i].getFileName() + CertificateUtil.DELIMITER + stackTrace[i].getLineNumber() + ") " + stackTrace[i].getMethodName();
            str = str + StringUtils.SPACE;
            Log.v(tag, msg + str + str2 + str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void printStack(String msg, int n) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(n, stackTrace.length - 1);
        String str = StringUtils.SPACE;
        for (int i = 1; i <= min; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            String str2 = ".(" + stackTrace[i].getFileName() + CertificateUtil.DELIMITER + stackTrace[i].getLineNumber() + ") ";
            str = str + StringUtils.SPACE;
            System.out.println(msg + str + str2 + str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")";
        Class<?> cls = obj.getClass();
        System.out.println(str + "------------- " + cls.getName() + " --------------------");
        for (Field field : cls.getFields()) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    System.out.println(str + "    " + field.getName() + StringUtils.SPACE + obj2);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(str + "------------- " + cls.getSimpleName() + " --------------------");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getName(Context context, int id) {
        if (id == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(id);
        } catch (Exception unused) {
            return "?" + id;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getName(Context context, int[] id) {
        String str;
        try {
            String str2 = id.length + "[";
            int i = 0;
            while (i < id.length) {
                String str3 = str2 + (i == 0 ? "" : StringUtils.SPACE);
                try {
                    str = context.getResources().getResourceEntryName(id[i]);
                } catch (Resources.NotFoundException unused) {
                    str = "? " + id[i] + StringUtils.SPACE;
                }
                str2 = str3 + str;
                i++;
            }
            return str2 + "]";
        } catch (Exception e) {
            Log.v("DEBUG", e.toString());
            return "UNKNOWN";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getState(MotionLayout layout, int stateId) {
        return getState(layout, stateId, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getState(MotionLayout layout, int stateId, int len) {
        int length;
        if (stateId == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = layout.getContext().getResources().getResourceEntryName(stateId);
        if (len == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > len) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        return (resourceEntryName.length() <= len || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) ? resourceEntryName : resourceEntryName.replaceAll(CharBuffer.allocate((resourceEntryName.length() - len) / length).toString().replace((char) 0, ClassUtils.PACKAGE_SEPARATOR_CHAR) + "_", "_");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getActionType(MotionEvent event) {
        int action = event.getAction();
        for (Field field : MotionEvent.class.getFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getCallFrom(int n) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[n + 2];
        return ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ")";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void dumpLayoutParams(ViewGroup layout, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ") " + str + "  ";
        int childCount = layout.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i = 0; i < childCount; i++) {
            View childAt = layout.getChildAt(i);
            System.out.println(str2 + "     " + getName(childAt));
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                        System.out.println(str2 + "       " + field.getName() + StringUtils.SPACE + obj);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void dumpLayoutParams(ViewGroup.LayoutParams param, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ") " + str + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + str2 + "  " + param.getClass().getName());
        for (Field field : param.getClass().getFields()) {
            try {
                Object obj = field.get(param);
                String name = field.getName();
                if (name.contains("To") && !obj.toString().equals("-1")) {
                    System.out.println(str2 + "       " + name + StringUtils.SPACE + obj);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
    }
}
