package androidx.core.content.p002pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled = true;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ShortcutInfoCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon(this.mContext));
        }
        if (!TextUtils.isEmpty(this.mLongLabel)) {
            intents.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty(this.mDisabledMessage)) {
            intents.setDisabledMessage(this.mDisabledMessage);
        }
        ComponentName componentName = this.mActivity;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.mCategories;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.mRank);
        PersistableBundle persistableBundle = this.mExtras;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.mPersons;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i = 0; i < length; i++) {
                    personArr2[i] = this.mPersons[i].toAndroidPerson();
                }
                intents.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.mLocusId;
            if (locusIdCompat != null) {
                intents.setLocusId(locusIdCompat.toLocusId());
            }
            intents.setLongLived(this.mIsLongLived);
        } else {
            intents.setExtras(buildLegacyExtrasBundle());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setExcludedFromSurfaces(intents, this.mExcludedSurfaces);
        }
        return intents.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras == null) {
            this.mExtras = new PersistableBundle();
        }
        Person[] personArr = this.mPersons;
        if (personArr != null && personArr.length > 0) {
            this.mExtras.putInt(EXTRA_PERSON_COUNT, personArr.length);
            int i = 0;
            while (i < this.mPersons.length) {
                int i2 = i + 1;
                this.mExtras.putPersistableBundle(EXTRA_PERSON_ + i2, this.mPersons[i].toPersistableBundle());
                i = i2;
            }
        }
        LocusIdCompat locusIdCompat = this.mLocusId;
        if (locusIdCompat != null) {
            this.mExtras.putString(EXTRA_LOCUS_ID, locusIdCompat.getId());
        }
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Intent addToIntent(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon != null) {
            Drawable drawable = null;
            if (this.mIsAlwaysBadged) {
                PackageManager packageManager = this.mContext.getPackageManager();
                ComponentName componentName = this.mActivity;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.mContext.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.mIcon.addToShortcutIntent(intent, drawable, this.mContext);
        }
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getId() {
        return this.mId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPackage() {
        return this.mPackageName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ComponentName getActivity() {
        return this.mActivity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Intent getIntent() {
        return this.mIntents[r0.length - 1];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Intent[] getIntents() {
        Intent[] intentArr = this.mIntents;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<String> getCategories() {
        return this.mCategories;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getRank() {
        return this.mRank;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IconCompat getIcon() {
        return this.mIcon;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Person[] getPersonsFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            return null;
        }
        int i = persistableBundle.getInt(EXTRA_PERSON_COUNT);
        Person[] personArr = new Person[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            personArr[i2] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(EXTRA_PERSON_ + i3));
            i2 = i3;
        }
        return personArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean getLongLivedFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_LONG_LIVED)) {
            return false;
        }
        return persistableBundle.getBoolean(EXTRA_LONG_LIVED);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static List<ShortcutInfoCompat> fromShortcuts(Context context, List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ShortcutInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Builder(context, it.next()).build());
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserHandle getUserHandle() {
        return this.mUser;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCached() {
        return this.mIsCached;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPinned() {
        return this.mIsPinned;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static LocusIdCompat getLocusId(ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (shortcutInfo.getLocusId() == null) {
                return null;
            }
            return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
        }
        return getLocusIdFromExtra(shortcutInfo.getExtras());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isExcludedFromSurfaces(int i) {
        return (i & this.mExcludedSurfaces) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString(EXTRA_LOCUS_ID)) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(Context context, String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat2;
            shortcutInfoCompat2.mContext = shortcutInfoCompat.mContext;
            shortcutInfoCompat2.mId = shortcutInfoCompat.mId;
            shortcutInfoCompat2.mPackageName = shortcutInfoCompat.mPackageName;
            shortcutInfoCompat2.mIntents = (Intent[]) Arrays.copyOf(shortcutInfoCompat.mIntents, shortcutInfoCompat.mIntents.length);
            shortcutInfoCompat2.mActivity = shortcutInfoCompat.mActivity;
            shortcutInfoCompat2.mLabel = shortcutInfoCompat.mLabel;
            shortcutInfoCompat2.mLongLabel = shortcutInfoCompat.mLongLabel;
            shortcutInfoCompat2.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
            shortcutInfoCompat2.mDisabledReason = shortcutInfoCompat.mDisabledReason;
            shortcutInfoCompat2.mIcon = shortcutInfoCompat.mIcon;
            shortcutInfoCompat2.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
            shortcutInfoCompat2.mUser = shortcutInfoCompat.mUser;
            shortcutInfoCompat2.mLastChangedTimestamp = shortcutInfoCompat.mLastChangedTimestamp;
            shortcutInfoCompat2.mIsCached = shortcutInfoCompat.mIsCached;
            shortcutInfoCompat2.mIsDynamic = shortcutInfoCompat.mIsDynamic;
            shortcutInfoCompat2.mIsPinned = shortcutInfoCompat.mIsPinned;
            shortcutInfoCompat2.mIsDeclaredInManifest = shortcutInfoCompat.mIsDeclaredInManifest;
            shortcutInfoCompat2.mIsImmutable = shortcutInfoCompat.mIsImmutable;
            shortcutInfoCompat2.mIsEnabled = shortcutInfoCompat.mIsEnabled;
            shortcutInfoCompat2.mLocusId = shortcutInfoCompat.mLocusId;
            shortcutInfoCompat2.mIsLongLived = shortcutInfoCompat.mIsLongLived;
            shortcutInfoCompat2.mHasKeyFieldsOnly = shortcutInfoCompat.mHasKeyFieldsOnly;
            shortcutInfoCompat2.mRank = shortcutInfoCompat.mRank;
            if (shortcutInfoCompat.mPersons != null) {
                shortcutInfoCompat2.mPersons = (Person[]) Arrays.copyOf(shortcutInfoCompat.mPersons, shortcutInfoCompat.mPersons.length);
            }
            if (shortcutInfoCompat.mCategories != null) {
                shortcutInfoCompat2.mCategories = new HashSet(shortcutInfoCompat.mCategories);
            }
            if (shortcutInfoCompat.mExtras != null) {
                shortcutInfoCompat2.mExtras = shortcutInfoCompat.mExtras;
            }
            shortcutInfoCompat2.mExcludedSurfaces = shortcutInfoCompat.mExcludedSurfaces;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(Context context, ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = shortcutInfo.getId();
            shortcutInfoCompat.mPackageName = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            shortcutInfoCompat.mIntents = (Intent[]) Arrays.copyOf(intents, intents.length);
            shortcutInfoCompat.mActivity = shortcutInfo.getActivity();
            shortcutInfoCompat.mLabel = shortcutInfo.getShortLabel();
            shortcutInfoCompat.mLongLabel = shortcutInfo.getLongLabel();
            shortcutInfoCompat.mDisabledMessage = shortcutInfo.getDisabledMessage();
            if (Build.VERSION.SDK_INT >= 28) {
                shortcutInfoCompat.mDisabledReason = shortcutInfo.getDisabledReason();
            } else {
                shortcutInfoCompat.mDisabledReason = shortcutInfo.isEnabled() ? 0 : 3;
            }
            shortcutInfoCompat.mCategories = shortcutInfo.getCategories();
            shortcutInfoCompat.mPersons = ShortcutInfoCompat.getPersonsFromExtra(shortcutInfo.getExtras());
            shortcutInfoCompat.mUser = shortcutInfo.getUserHandle();
            shortcutInfoCompat.mLastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            if (Build.VERSION.SDK_INT >= 30) {
                shortcutInfoCompat.mIsCached = shortcutInfo.isCached();
            }
            shortcutInfoCompat.mIsDynamic = shortcutInfo.isDynamic();
            shortcutInfoCompat.mIsPinned = shortcutInfo.isPinned();
            shortcutInfoCompat.mIsDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.mIsImmutable = shortcutInfo.isImmutable();
            shortcutInfoCompat.mIsEnabled = shortcutInfo.isEnabled();
            shortcutInfoCompat.mHasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.mLocusId = ShortcutInfoCompat.getLocusId(shortcutInfo);
            shortcutInfoCompat.mRank = shortcutInfo.getRank();
            shortcutInfoCompat.mExtras = shortcutInfo.getExtras();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setShortLabel(CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLongLabel(CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDisabledMessage(CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIntent(Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIntents(Intent[] intentArr) {
            this.mInfo.mIntents = intentArr;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLocusId(LocusIdCompat locusIdCompat) {
            this.mInfo.mLocusId = locusIdCompat;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setActivity(ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPerson(Person person) {
            return setPersons(new Person[]{person});
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPersons(Person[] personArr) {
            this.mInfo.mPersons = personArr;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setCategories(Set<String> set) {
            this.mInfo.mCategories = set;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLongLived(boolean z) {
            this.mInfo.mIsLongLived = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setExcludedFromSurfaces(int i) {
            this.mInfo.mExcludedSurfaces = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRank(int i) {
            this.mInfo.mRank = i;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setExtras(PersistableBundle persistableBundle) {
            this.mInfo.mExtras = persistableBundle;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTransientExtras(Bundle bundle) {
            this.mInfo.mTransientExtras = (Bundle) Preconditions.checkNotNull(bundle);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addCapabilityBinding(String str) {
            if (this.mCapabilityBindings == null) {
                this.mCapabilityBindings = new HashSet();
            }
            this.mCapabilityBindings.add(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addCapabilityBinding(String str, String str2, List<String> list) {
            addCapabilityBinding(str);
            if (!list.isEmpty()) {
                if (this.mCapabilityBindingParams == null) {
                    this.mCapabilityBindingParams = new HashMap();
                }
                if (this.mCapabilityBindingParams.get(str) == null) {
                    this.mCapabilityBindingParams.put(str, new HashMap());
                }
                this.mCapabilityBindingParams.get(str).put(str2, list);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSliceUri(Uri uri) {
            this.mSliceUri = uri;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            if (this.mInfo.mIntents == null || this.mInfo.mIntents.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.mIsConversation) {
                if (this.mInfo.mLocusId == null) {
                    this.mInfo.mLocusId = new LocusIdCompat(this.mInfo.mId);
                }
                this.mInfo.mIsLongLived = true;
            }
            if (this.mCapabilityBindings != null) {
                if (this.mInfo.mCategories == null) {
                    this.mInfo.mCategories = new HashSet();
                }
                this.mInfo.mCategories.addAll(this.mCapabilityBindings);
            }
            if (this.mCapabilityBindingParams != null) {
                if (this.mInfo.mExtras == null) {
                    this.mInfo.mExtras = new PersistableBundle();
                }
                for (String str : this.mCapabilityBindingParams.keySet()) {
                    Map<String, List<String>> map = this.mCapabilityBindingParams.get(str);
                    this.mInfo.mExtras.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                    for (String str2 : map.keySet()) {
                        List<String> list = map.get(str2);
                        this.mInfo.mExtras.putStringArray(str + RemoteSettings.FORWARD_SLASH_STRING + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                    }
                }
            }
            if (this.mSliceUri != null) {
                if (this.mInfo.mExtras == null) {
                    this.mInfo.mExtras = new PersistableBundle();
                }
                this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
            }
            return this.mInfo;
        }
    }

    private static class Api33Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api33Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setExcludedFromSurfaces(ShortcutInfo.Builder builder, int i) {
            builder.setExcludedFromSurfaces(i);
        }
    }
}
