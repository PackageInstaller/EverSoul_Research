package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getMessage(Response<?> response) {
        Objects.requireNonNull(response, "response == null");
        return "HTTP " + response.code() + StringUtils.SPACE + response.message();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpException(Response<?> response) {
        super(getMessage(response));
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int code() {
        return this.code;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String message() {
        return this.message;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Nullable
    public Response<?> response() {
        return this.response;
    }
}
