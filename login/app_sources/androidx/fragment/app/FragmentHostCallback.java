package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {
    private final Activity mActivity;
    private final Context mContext;
    final FragmentManager mFragmentManager;
    private final Handler mHandler;
    private final int mWindowAnimations;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentContainer
    public View onFindViewById(int i) {
        return null;
    }

    public abstract E onGetHost();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onHasWindowAnimations() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void onRequestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onShouldShowRequestPermissionRationale(String str) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onSupportInvalidateOptionsMenu() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FragmentHostCallback(Context context, Handler handler, int i) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = (Context) Preconditions.checkNotNull(context, "context == null");
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "handler == null");
        this.mWindowAnimations = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        onStartActivityFromFragment(fragment, intent, i, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        ContextCompat.startActivity(this.mContext, intent, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.startIntentSenderForResult(this.mActivity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Activity getActivity() {
        return this.mActivity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Context getContext() {
        return this.mContext;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Handler getHandler() {
        return this.mHandler;
    }
}
