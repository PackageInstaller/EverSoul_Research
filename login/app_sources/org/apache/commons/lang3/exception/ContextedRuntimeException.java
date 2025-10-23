package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: classes2.dex */
public class ContextedRuntimeException extends RuntimeException implements ExceptionContext {
    private static final long serialVersionUID = 20110706;
    private final ExceptionContext exceptionContext;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextedRuntimeException() {
        this.exceptionContext = new DefaultExceptionContext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextedRuntimeException(String str) {
        super(str);
        this.exceptionContext = new DefaultExceptionContext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextedRuntimeException(Throwable th) {
        super(th);
        this.exceptionContext = new DefaultExceptionContext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextedRuntimeException(String str, Throwable th) {
        super(str, th);
        this.exceptionContext = new DefaultExceptionContext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextedRuntimeException(String str, Throwable th, ExceptionContext exceptionContext) {
        super(str, th);
        this.exceptionContext = exceptionContext == null ? new DefaultExceptionContext() : exceptionContext;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public ContextedRuntimeException addContextValue(String str, Object obj) {
        this.exceptionContext.addContextValue(str, obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public ContextedRuntimeException setContextValue(String str, Object obj) {
        this.exceptionContext.setContextValue(str, obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(String str) {
        return this.exceptionContext.getContextValues(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(String str) {
        return this.exceptionContext.getFirstContextValue(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        return this.exceptionContext.getContextEntries();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        return this.exceptionContext.getContextLabels();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String getMessage() {
        return getFormattedExceptionMessage(super.getMessage());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getRawMessage() {
        return super.getMessage();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String str) {
        return this.exceptionContext.getFormattedExceptionMessage(str);
    }
}
