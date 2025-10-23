package org.apache.commons.lang3.exception;

import com.liapp.y;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class ExceptionUtils {
    private static final String[] CAUSE_METHOD_NAMES = {y.ۮڭڭܬި(862228523), y.ٴسسݬߨ(1392572722), y.ݮڮֲڭܩ(-628830804), y.دײܮڳܯ(2051668205), y.֬ڱܱײٮ(-1159682511), y.دײܮڳܯ(2051668445), y.ٲٴݴ״ٰ(1781918472), y.دײܮڳܯ(2051667645), y.ٲٴݴ״ٰ(1781918256), y.ٴسسݬߨ(1392571802), y.ݮڮֲڭܩ(-628833740), y.֬ڱܱײٮ(-1159681063)};
    static final String WRAPPED_MARKER = " [wrapped] ";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static String[] getDefaultCauseMethodNames() {
        return (String[]) ArrayUtils.clone(CAUSE_METHOD_NAMES);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static Throwable getCause(Throwable th) {
        return getCause(th, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static Throwable getCause(Throwable th, String[] strArr) {
        Throwable causeUsingMethodName;
        if (th == null) {
            return null;
        }
        if (strArr == null) {
            Throwable cause = th.getCause();
            if (cause != null) {
                return cause;
            }
            strArr = CAUSE_METHOD_NAMES;
        }
        for (String str : strArr) {
            if (str != null && (causeUsingMethodName = getCauseUsingMethodName(th, str)) != null) {
                return causeUsingMethodName;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Throwable getRootCause(Throwable th) {
        List<Throwable> throwableList = getThrowableList(th);
        if (throwableList.isEmpty()) {
            return null;
        }
        return throwableList.get(throwableList.size() - 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Throwable getCauseUsingMethodName(Throwable th, String str) {
        Method method;
        try {
            method = th.getClass().getMethod(str, new Class[0]);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
            try {
                return (Throwable) method.invoke(th, new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getThrowableCount(Throwable th) {
        return getThrowableList(th).size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Throwable[] getThrowables(Throwable th) {
        List<Throwable> throwableList = getThrowableList(th);
        return (Throwable[]) throwableList.toArray(new Throwable[throwableList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<Throwable> getThrowableList(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = th.getCause();
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int indexOfThrowable(Throwable th, Class<?> cls) {
        return indexOf(th, cls, 0, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int indexOfThrowable(Throwable th, Class<?> cls, int i) {
        return indexOf(th, cls, i, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int indexOfType(Throwable th, Class<?> cls) {
        return indexOf(th, cls, 0, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int indexOfType(Throwable th, Class<?> cls, int i) {
        return indexOf(th, cls, i, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int indexOf(Throwable th, Class<?> cls, int i, boolean z) {
        if (th != null && cls != null) {
            if (i < 0) {
                i = 0;
            }
            Throwable[] throwables = getThrowables(th);
            if (i >= throwables.length) {
                return -1;
            }
            if (z) {
                while (i < throwables.length) {
                    if (cls.isAssignableFrom(throwables[i].getClass())) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < throwables.length) {
                    if (cls.equals(throwables[i].getClass())) {
                        return i;
                    }
                    i++;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void printRootCauseStackTrace(Throwable th) {
        printRootCauseStackTrace(th, System.err);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void printRootCauseStackTrace(Throwable th, PrintStream printStream) {
        if (th == null) {
            return;
        }
        Validate.isTrue(printStream != null, y.دײܮڳܯ(2051667373), new Object[0]);
        for (String str : getRootCauseStackTrace(th)) {
            printStream.println(str);
        }
        printStream.flush();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void printRootCauseStackTrace(Throwable th, PrintWriter printWriter) {
        if (th == null) {
            return;
        }
        Validate.isTrue(printWriter != null, y.٬ݯح׭٩(575878366), new Object[0]);
        for (String str : getRootCauseStackTrace(th)) {
            printWriter.println(str);
        }
        printWriter.flush();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[] getRootCauseStackTrace(Throwable th) {
        List<String> list;
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwables = getThrowables(th);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        int i = length - 1;
        List<String> stackFrameList = getStackFrameList(throwables[i]);
        while (true) {
            length--;
            if (length >= 0) {
                if (length != 0) {
                    list = getStackFrameList(throwables[length - 1]);
                    removeCommonFrames(stackFrameList, list);
                } else {
                    list = stackFrameList;
                }
                if (length == i) {
                    arrayList.add(throwables[length].toString());
                } else {
                    arrayList.add(y.٬ݯح׭٩(575877990) + throwables[length].toString());
                }
                arrayList.addAll(stackFrameList);
                stackFrameList = list;
            } else {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void removeCommonFrames(List<String> list, List<String> list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list.size() - 1;
        for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[] getStackFrames(Throwable th) {
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return getStackFrames(getStackTrace(th));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String[] getStackFrames(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, System.lineSeparator());
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static List<String> getStackFrameList(Throwable th) {
        StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th), System.lineSeparator());
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(y.ٲٴݴ״ٰ(1781917864));
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                arrayList.add(nextToken);
                z = true;
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getMessage(Throwable th) {
        if (th == null) {
            return "";
        }
        return ClassUtils.getShortClassName(th, null) + y.ݬֲ֮ܲت(1512932847) + StringUtils.defaultString(th.getMessage());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getRootCauseMessage(Throwable th) {
        Throwable rootCause = getRootCause(th);
        if (rootCause != null) {
            th = rootCause;
        }
        return getMessage(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <R> R rethrow(Throwable th) {
        return (R) typeErasure(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <R, T extends Throwable> R typeErasure(Throwable th) throws Throwable {
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <R> R wrapAndThrow(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new UndeclaredThrowableException(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasCause(Throwable th, Class<? extends Throwable> cls) {
        if (th instanceof UndeclaredThrowableException) {
            th = th.getCause();
        }
        return cls.isInstance(th);
    }
}
