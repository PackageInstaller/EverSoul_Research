package androidx.multidex;

import android.app.Application;
import android.content.Context;

/* loaded from: classes.dex */
public class MultiDexApplication extends Application {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
