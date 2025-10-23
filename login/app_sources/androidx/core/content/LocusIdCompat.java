package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocusIdCompat(String str) {
        this.mId = (String) Preconditions.checkStringNotEmpty(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped = Api29Impl.create(str);
        } else {
            this.mWrapped = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getId() {
        return this.mId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.mId;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
        String str = this.mId;
        if (str == null) {
            return locusIdCompat.mId == null;
        }
        return str.equals(locusIdCompat.mId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocusId toLocusId() {
        return this.mWrapped;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocusIdCompat toLocusIdCompat(LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.getId(locusId), "id cannot be empty"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    private static class Api29Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api29Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static LocusId create(String str) {
            return new LocusId(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String getId(LocusId locusId) {
            return locusId.getId();
        }
    }
}
