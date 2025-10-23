package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface TimeZone extends Serializable {
    String getName();

    String tzinfoName();

    int utcOffset();
}
