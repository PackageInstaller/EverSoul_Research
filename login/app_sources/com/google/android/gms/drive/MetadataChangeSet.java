package com.google.android.gms.drive;

import android.graphics.Bitmap;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzif;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzax = new MetadataChangeSet(MetadataBundle.zzbe());
    private final MetadataBundle zzay;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MetadataChangeSet(MetadataBundle metadataBundle) {
        this.zzay = metadataBundle.zzbf();
    }

    public static class Builder {
        private final MetadataBundle zzay = MetadataBundle.zzbe();
        private AppVisibleCustomProperties.zza zzaz;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final AppVisibleCustomProperties.zza zzr() {
            if (this.zzaz == null) {
                this.zzaz = new AppVisibleCustomProperties.zza();
            }
            return this.zzaz;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static int zzb(String str) {
            if (str == null) {
                return 0;
            }
            return str.getBytes().length;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static void zza(String str, int i, int i2) {
            Preconditions.checkArgument(i2 <= i, String.format(Locale.US, "%s must be no more than %d bytes, but is %d bytes.", str, Integer.valueOf(i), Integer.valueOf(i2)));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setCustomProperty(CustomPropertyKey customPropertyKey, String str) {
            Preconditions.checkNotNull(customPropertyKey, "key");
            Preconditions.checkNotNull(str, "value");
            zza("The total size of key string and value string of a custom property", 124, zzb(customPropertyKey.getKey()) + zzb(str));
            zzr().zza(customPropertyKey, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder deleteCustomProperty(CustomPropertyKey customPropertyKey) {
            Preconditions.checkNotNull(customPropertyKey, "key");
            zzr().zza(customPropertyKey, null);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setDescription(String str) {
            this.zzay.zzb(zzhs.zzjo, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIndexableText(String str) {
            zza("Indexable text size", 131072, zzb(str));
            this.zzay.zzb(zzhs.zzju, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLastViewedByMeDate(Date date) {
            this.zzay.zzb(zzif.zzle, date);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMimeType(String str) {
            Preconditions.checkNotNull(str);
            this.zzay.zzb(zzhs.zzki, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPinned(boolean z) {
            this.zzay.zzb(zzhs.zzka, Boolean.valueOf(z));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setStarred(boolean z) {
            this.zzay.zzb(zzhs.zzkp, Boolean.valueOf(z));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTitle(String str) {
            Preconditions.checkNotNull(str, "Title cannot be null.");
            this.zzay.zzb(zzhs.zzkr, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder setViewed(boolean z) {
            if (z) {
                this.zzay.zzb(zzhs.zzkh, true);
            } else if (this.zzay.zzd(zzhs.zzkh)) {
                this.zzay.zzc(zzhs.zzkh);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setViewed() {
            this.zzay.zzb(zzhs.zzkh, true);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public MetadataChangeSet build() {
            if (this.zzaz != null) {
                this.zzay.zzb(zzhs.zzjn, this.zzaz.zzbb());
            }
            return new MetadataChangeSet(this.zzay);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzay.zza(zzhs.zzjn);
        if (appVisibleCustomProperties == null) {
            return Collections.emptyMap();
        }
        return appVisibleCustomProperties.zzba();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDescription() {
        return (String) this.zzay.zza(zzhs.zzjo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIndexableText() {
        return (String) this.zzay.zza(zzhs.zzju);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getLastViewedByMeDate() {
        return (Date) this.zzay.zza(zzif.zzle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMimeType() {
        return (String) this.zzay.zza(zzhs.zzki);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bitmap getThumbnail() {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) this.zzay.zza(zzhs.zzkq);
        if (bitmapTeleporter == null) {
            return null;
        }
        return bitmapTeleporter.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitle() {
        return (String) this.zzay.zza(zzhs.zzkr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isPinned() {
        return (Boolean) this.zzay.zza(zzhs.zzka);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isStarred() {
        return (Boolean) this.zzay.zza(zzhs.zzkp);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isViewed() {
        return (Boolean) this.zzay.zza(zzhs.zzkh);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final MetadataBundle zzq() {
        return this.zzay;
    }
}
