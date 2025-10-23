package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(String str, int i) {
            this.mChannel = new NotificationChannelCompat(str, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setName(CharSequence charSequence) {
            this.mChannel.mName = charSequence;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setImportance(int i) {
            this.mChannel.mImportance = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDescription(String str) {
            this.mChannel.mDescription = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setGroup(String str) {
            this.mChannel.mGroupId = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setShowBadge(boolean z) {
            this.mChannel.mShowBadge = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSound(Uri uri, AudioAttributes audioAttributes) {
            this.mChannel.mSound = uri;
            this.mChannel.mAudioAttributes = audioAttributes;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLightsEnabled(boolean z) {
            this.mChannel.mLights = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLightColor(int i) {
            this.mChannel.mLightColor = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setVibrationEnabled(boolean z) {
            this.mChannel.mVibrationEnabled = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setVibrationPattern(long[] jArr) {
            this.mChannel.mVibrationEnabled = jArr != null && jArr.length > 0;
            this.mChannel.mVibrationPattern = jArr;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setConversationId(String str, String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mChannel.mParentId = str;
                this.mChannel.mConversationId = str2;
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NotificationChannelCompat build() {
            return this.mChannel;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NotificationChannelCompat(String str, int i) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(str);
        this.mImportance = i;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NotificationChannelCompat(NotificationChannel notificationChannel) {
        this(Api26Impl.getId(notificationChannel), Api26Impl.getImportance(notificationChannel));
        this.mName = Api26Impl.getName(notificationChannel);
        this.mDescription = Api26Impl.getDescription(notificationChannel);
        this.mGroupId = Api26Impl.getGroup(notificationChannel);
        this.mShowBadge = Api26Impl.canShowBadge(notificationChannel);
        this.mSound = Api26Impl.getSound(notificationChannel);
        this.mAudioAttributes = Api26Impl.getAudioAttributes(notificationChannel);
        this.mLights = Api26Impl.shouldShowLights(notificationChannel);
        this.mLightColor = Api26Impl.getLightColor(notificationChannel);
        this.mVibrationEnabled = Api26Impl.shouldVibrate(notificationChannel);
        this.mVibrationPattern = Api26Impl.getVibrationPattern(notificationChannel);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mParentId = Api30Impl.getParentChannelId(notificationChannel);
            this.mConversationId = Api30Impl.getConversationId(notificationChannel);
        }
        this.mBypassDnd = Api26Impl.canBypassDnd(notificationChannel);
        this.mLockscreenVisibility = Api26Impl.getLockscreenVisibility(notificationChannel);
        if (Build.VERSION.SDK_INT >= 29) {
            this.mCanBubble = Api29Impl.canBubble(notificationChannel);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImportantConversation = Api30Impl.isImportantConversation(notificationChannel);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NotificationChannel getNotificationChannel() {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel createNotificationChannel = Api26Impl.createNotificationChannel(this.mId, this.mName, this.mImportance);
        Api26Impl.setDescription(createNotificationChannel, this.mDescription);
        Api26Impl.setGroup(createNotificationChannel, this.mGroupId);
        Api26Impl.setShowBadge(createNotificationChannel, this.mShowBadge);
        Api26Impl.setSound(createNotificationChannel, this.mSound, this.mAudioAttributes);
        Api26Impl.enableLights(createNotificationChannel, this.mLights);
        Api26Impl.setLightColor(createNotificationChannel, this.mLightColor);
        Api26Impl.setVibrationPattern(createNotificationChannel, this.mVibrationPattern);
        Api26Impl.enableVibration(createNotificationChannel, this.mVibrationEnabled);
        if (Build.VERSION.SDK_INT >= 30 && (str = this.mParentId) != null && (str2 = this.mConversationId) != null) {
            Api30Impl.setConversationId(createNotificationChannel, str, str2);
        }
        return createNotificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
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
    public int getImportance() {
        return this.mImportance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Uri getSound() {
        return this.mSound;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldShowLights() {
        return this.mLights;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLightColor() {
        return this.mLightColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getGroup() {
        return this.mGroupId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getParentChannelId() {
        return this.mParentId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getConversationId() {
        return this.mConversationId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean canBubble() {
        return this.mCanBubble;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    static class Api26Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api26Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static NotificationChannel createNotificationChannel(String str, CharSequence charSequence, int i) {
            return new NotificationChannel(str, charSequence, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getId(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getImportance(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static CharSequence getName(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getDescription(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setDescription(NotificationChannel notificationChannel, String str) {
            notificationChannel.setDescription(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getGroup(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setGroup(NotificationChannel notificationChannel, String str) {
            notificationChannel.setGroup(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean canShowBadge(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setShowBadge(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.setShowBadge(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Uri getSound(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setSound(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static AudioAttributes getAudioAttributes(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean shouldShowLights(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void enableLights(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.enableLights(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getLightColor(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setLightColor(NotificationChannel notificationChannel, int i) {
            notificationChannel.setLightColor(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean shouldVibrate(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void enableVibration(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.enableVibration(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static long[] getVibrationPattern(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setVibrationPattern(NotificationChannel notificationChannel, long[] jArr) {
            notificationChannel.setVibrationPattern(jArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean canBypassDnd(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getLockscreenVisibility(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }
    }

    static class Api29Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api29Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean canBubble(NotificationChannel notificationChannel) {
            return notificationChannel.canBubble();
        }
    }

    static class Api30Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api30Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getParentChannelId(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getConversationId(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setConversationId(NotificationChannel notificationChannel, String str, String str2) {
            notificationChannel.setConversationId(str, str2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isImportantConversation(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }
    }
}
