package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class Loader<D> {
    Context mContext;
    int mId;
    OnLoadCompleteListener<D> mListener;
    OnLoadCanceledListener<D> mOnLoadCanceledListener;
    boolean mStarted = false;
    boolean mAbandoned = false;
    boolean mReset = true;
    boolean mContentChanged = false;
    boolean mProcessingChange = false;

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(Loader<D> loader);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(Loader<D> loader, D d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onAbandon() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean onCancelLoad() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onForceLoad() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onReset() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onStartLoading() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onStopLoading() {
    }

    public final class ForceLoadContentObserver extends ContentObserver {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Loader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void deliverResult(D d) {
        OnLoadCompleteListener<D> onLoadCompleteListener = this.mListener;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(this, d);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void deliverCancellation() {
        OnLoadCanceledListener<D> onLoadCanceledListener = this.mOnLoadCanceledListener;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Context getContext() {
        return this.mContext;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getId() {
        return this.mId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerListener(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = onLoadCompleteListener;
        this.mId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregisterListener(OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.mListener;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCompleteListener2 != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mListener = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.mOnLoadCanceledListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mOnLoadCanceledListener = onLoadCanceledListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.mOnLoadCanceledListener;
        if (onLoadCanceledListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCanceledListener2 != onLoadCanceledListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mOnLoadCanceledListener = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isStarted() {
        return this.mStarted;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isReset() {
        return this.mReset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean cancelLoad() {
        return onCancelLoad();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void forceLoad() {
        onForceLoad();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d, sb);
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }
}
