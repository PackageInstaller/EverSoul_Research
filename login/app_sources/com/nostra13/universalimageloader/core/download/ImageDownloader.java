package com.nostra13.universalimageloader.core.download;

import com.liapp.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes3.dex */
public interface ImageDownloader {
    InputStream getStream(String str, Object obj) throws IOException;

    public enum Scheme {
        HTTP(y.٬ݯح׭٩(576051006)),
        HTTPS(y.٬ݯح׭٩(576050958)),
        FILE(y.֬ڱܱײٮ(-1159307271)),
        CONTENT(y.֬ڱܱײٮ(-1159406207)),
        ASSETS(y.٬ݯح׭٩(576300798)),
        DRAWABLE(y.ٴسسݬߨ(1393328082)),
        UNKNOWN("");

        private String scheme;
        private String uriPrefix;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Scheme ofUri(String str) {
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String wrap(String str) {
            return this.uriPrefix + str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String crop(String str) {
            if (!belongsTo(str)) {
                throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
            }
            return str.substring(this.uriPrefix.length());
        }
    }
}
