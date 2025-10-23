package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

/* loaded from: classes.dex */
public final class RemoteActionCompat implements VersionedParcelable {
    public PendingIntent mActionIntent;
    public CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public CharSequence mTitle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RemoteActionCompat(IconCompat iconCompat, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(iconCompat);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(charSequence);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(charSequence2);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RemoteActionCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RemoteActionCompat(RemoteActionCompat remoteActionCompat) {
        Preconditions.checkNotNull(remoteActionCompat);
        this.mIcon = remoteActionCompat.mIcon;
        this.mTitle = remoteActionCompat.mTitle;
        this.mContentDescription = remoteActionCompat.mContentDescription;
        this.mActionIntent = remoteActionCompat.mActionIntent;
        this.mEnabled = remoteActionCompat.mEnabled;
        this.mShouldShowIcon = remoteActionCompat.mShouldShowIcon;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RemoteActionCompat createFromRemoteAction(RemoteAction remoteAction) {
        Preconditions.checkNotNull(remoteAction);
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(remoteAction)), Api26Impl.getTitle(remoteAction), Api26Impl.getContentDescription(remoteAction), Api26Impl.getActionIntent(remoteAction));
        remoteActionCompat.setEnabled(Api26Impl.isEnabled(remoteAction));
        if (Build.VERSION.SDK_INT >= 28) {
            remoteActionCompat.setShouldShowIcon(Api28Impl.shouldShowIcon(remoteAction));
        }
        return remoteActionCompat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEnabled() {
        return this.mEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShouldShowIcon(boolean z) {
        this.mShouldShowIcon = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IconCompat getIcon() {
        return this.mIcon;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getTitle() {
        return this.mTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RemoteAction toRemoteAction() {
        RemoteAction createRemoteAction = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(createRemoteAction, isEnabled());
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setShouldShowIcon(createRemoteAction, shouldShowIcon());
        }
        return createRemoteAction;
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean shouldShowIcon(RemoteAction remoteAction) {
            return remoteAction.shouldShowIcon();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setShouldShowIcon(RemoteAction remoteAction, boolean z) {
            remoteAction.setShouldShowIcon(z);
        }
    }

    static class Api26Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api26Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static CharSequence getContentDescription(RemoteAction remoteAction) {
            return remoteAction.getContentDescription();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static PendingIntent getActionIntent(RemoteAction remoteAction) {
            return remoteAction.getActionIntent();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static CharSequence getTitle(RemoteAction remoteAction) {
            return remoteAction.getTitle();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Icon getIcon(RemoteAction remoteAction) {
            return remoteAction.getIcon();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isEnabled(RemoteAction remoteAction) {
            return remoteAction.isEnabled();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static RemoteAction createRemoteAction(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
            return new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setEnabled(RemoteAction remoteAction, boolean z) {
            remoteAction.setEnabled(z);
        }
    }
}
