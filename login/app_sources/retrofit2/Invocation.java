package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static Invocation m904of(Method method, List<?> list) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new Invocation(method, new ArrayList(list));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Invocation(Method method, List<?> list) {
        this.method = method;
        this.arguments = Collections.unmodifiableList(list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Method method() {
        return this.method;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<?> arguments() {
        return this.arguments;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.format("%s.%s() %s", this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments);
    }
}
