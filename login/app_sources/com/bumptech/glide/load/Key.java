package com.bumptech.glide.load;

import com.liapp.y;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public interface Key {
    public static final Charset CHARSET = Charset.forName(y.٬ݯح׭٩(576116366));
    public static final String STRING_CHARSET_NAME = "UTF-8";

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
