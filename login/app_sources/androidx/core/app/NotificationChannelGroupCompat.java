package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(String str) {
            this.mGroup = new NotificationChannelGroupCompat(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setName(CharSequence charSequence) {
            this.mGroup.mName = charSequence;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDescription(String str) {
            this.mGroup.mDescription = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NotificationChannelGroupCompat(String str) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup, List<NotificationChannel> list) {
        this(Api26Impl.getId(notificationChannelGroup));
        this.mName = Api26Impl.getName(notificationChannelGroup);
        if (Build.VERSION.SDK_INT >= 28) {
            this.mDescription = Api28Impl.getDescription(notificationChannelGroup);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.mBlocked = Api28Impl.isBlocked(notificationChannelGroup);
            this.mChannels = getChannelsCompat(Api26Impl.getChannels(notificationChannelGroup));
        } else {
            this.mChannels = getChannelsCompat(list);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> list) {
        ArrayList arrayList = new ArrayList();
        for (NotificationChannel notificationChannel : list) {
            if (this.mId.equals(Api26Impl.getGroup(notificationChannel))) {
                arrayList.add(new NotificationChannelCompat(notificationChannel));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NotificationChannelGroup getNotificationChannelGroup() {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannelGroup createNotificationChannelGroup = Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setDescription(createNotificationChannelGroup, this.mDescription);
        }
        return createNotificationChannelGroup;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getId() {
        return this.mId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getName() {
        return this.mName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDescription() {
        return this.mDescription;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isBlocked() {
        return this.mBlocked;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    static class Api26Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api26Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static NotificationChannelGroup createNotificationChannelGroup(String str, CharSequence charSequence) {
            return new NotificationChannelGroup(str, charSequence);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getId(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static CharSequence getName(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static List<NotificationChannel> getChannels(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getChannels();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getGroup(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isBlocked(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.isBlocked();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getDescription(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getDescription();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setDescription(NotificationChannelGroup notificationChannelGroup, String str) {
            notificationChannelGroup.setDescription(str);
        }
    }
}
