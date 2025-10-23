package com.android.volley.toolbox;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.liapp.y;
import java.io.File;

/* loaded from: classes.dex */
public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, (HttpStack) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestQueue newRequestQueue(Context context, int i) {
        return newRequestQueue(context, null, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        return newRequestQueue(context, httpStack, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack, int i) {
        File file = new File(context.getCacheDir(), y.ݬֲ֮ܲت(1512861391));
        if (httpStack == null) {
            httpStack = new HurlStack();
        }
        if (httpStack == null) {
            throw new IllegalStateException("No HttpStack available!");
        }
        BasicNetwork basicNetwork = new BasicNetwork(httpStack);
        RequestQueue requestQueue = i <= -1 ? new RequestQueue(new DiskBasedCache(file), basicNetwork) : new RequestQueue(new DiskBasedCache(file, i), basicNetwork);
        requestQueue.start();
        return requestQueue;
    }
}
