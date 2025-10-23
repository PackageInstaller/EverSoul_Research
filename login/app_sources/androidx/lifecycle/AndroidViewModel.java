package androidx.lifecycle;

import android.app.Application;

/* loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {
    private Application mApplication;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AndroidViewModel(Application application) {
        this.mApplication = application;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T extends Application> T getApplication() {
        return (T) this.mApplication;
    }
}
