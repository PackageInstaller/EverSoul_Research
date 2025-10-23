package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzif;
import com.google.android.gms.internal.drive.zzin;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    public abstract <T> T zza(MetadataField<T> metadataField);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAlternateLink() {
        return (String) zza(zzhs.zzjm);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getContentAvailability() {
        Integer num = (Integer) zza(zzin.zzlk);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Date getCreatedDate() {
        return (Date) zza(zzif.zzld);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<CustomPropertyKey, String> getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) zza(zzhs.zzjn);
        if (appVisibleCustomProperties == null) {
            return Collections.emptyMap();
        }
        return appVisibleCustomProperties.zzba();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDescription() {
        return (String) zza(zzhs.zzjo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DriveId getDriveId() {
        return (DriveId) zza(zzhs.zzjl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getEmbedLink() {
        return (String) zza(zzhs.zzjp);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getFileExtension() {
        return (String) zza(zzhs.zzjq);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getFileSize() {
        return ((Long) zza(zzhs.zzjr)).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Date getLastViewedByMeDate() {
        return (Date) zza(zzif.zzle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getMimeType() {
        return (String) zza(zzhs.zzki);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Date getModifiedByMeDate() {
        return (Date) zza(zzif.zzlg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Date getModifiedDate() {
        return (Date) zza(zzif.zzlf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getOriginalFilename() {
        return (String) zza(zzhs.zzkj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPinnable() {
        Boolean bool = (Boolean) zza(zzin.zzll);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPinned() {
        Boolean bool = (Boolean) zza(zzhs.zzka);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getQuotaBytesUsed() {
        return ((Long) zza(zzhs.zzko)).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Date getSharedWithMeDate() {
        return (Date) zza(zzif.zzlh);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getTitle() {
        return (String) zza(zzhs.zzkr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getWebContentLink() {
        return (String) zza(zzhs.zzkt);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getWebViewLink() {
        return (String) zza(zzhs.zzku);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isInAppFolder() {
        Boolean bool = (Boolean) zza(zzhs.zzjv);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEditable() {
        Boolean bool = (Boolean) zza(zzhs.zzjx);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isRestricted() {
        Boolean bool = (Boolean) zza(zzhs.zzkc);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isShared() {
        Boolean bool = (Boolean) zza(zzhs.zzkd);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isStarred() {
        Boolean bool = (Boolean) zza(zzhs.zzkp);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isTrashed() {
        Boolean bool = (Boolean) zza(zzhs.zzks);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isTrashable() {
        Boolean bool = (Boolean) zza(zzhs.zzkg);
        return bool == null || bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isExplicitlyTrashed() {
        Boolean bool = (Boolean) zza(zzhs.zzjy);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isViewed() {
        Boolean bool = (Boolean) zza(zzhs.zzkh);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
