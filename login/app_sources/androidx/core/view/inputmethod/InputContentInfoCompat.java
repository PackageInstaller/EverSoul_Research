package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class InputContentInfoCompat {
    private final InputContentInfoCompatImpl mImpl;

    private interface InputContentInfoCompatImpl {
        Uri getContentUri();

        ClipDescription getDescription();

        Object getInputContentInfo();

        Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    private static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
        private final Uri mContentUri;
        private final ClipDescription mDescription;
        private final Uri mLinkUri;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InputContentInfoCompatBaseImpl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.mContentUri = uri;
            this.mDescription = clipDescription;
            this.mLinkUri = uri2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.mContentUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.mDescription;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.mLinkUri;
        }
    }

    private static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
        final InputContentInfo mObject;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InputContentInfoCompatApi25Impl(Object obj) {
            this.mObject = (InputContentInfo) obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.mObject = new InputContentInfo(uri, clipDescription, uri2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.mObject.getContentUri();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.mObject.getDescription();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.mObject.getLinkUri();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return this.mObject;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
            this.mObject.requestPermission();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
            this.mObject.releasePermission();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.mImpl = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.mImpl = new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InputContentInfoCompat(InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.mImpl = inputContentInfoCompatImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static InputContentInfoCompat wrap(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void releasePermission() {
        this.mImpl.releasePermission();
    }
}
