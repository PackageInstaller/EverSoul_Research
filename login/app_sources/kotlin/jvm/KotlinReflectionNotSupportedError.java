package kotlin.jvm;

import com.kakaogame.server.ServerConstants;
import kotlin.Metadata;

/* compiled from: KotlinReflectionNotSupportedError.kt */
@Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m839d2 = {"Lkotlin/jvm/KotlinReflectionNotSupportedError;", "Ljava/lang/Error;", "()V", "message", "", "(Ljava/lang/String;)V", ServerConstants.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class KotlinReflectionNotSupportedError extends Error {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KotlinReflectionNotSupportedError(String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KotlinReflectionNotSupportedError(String str, Throwable th) {
        super(str, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KotlinReflectionNotSupportedError(Throwable th) {
        super(th);
    }
}
