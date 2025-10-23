package androidx.core.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.mRecord = (AccessibilityRecord) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Object getImpl() {
        return this.mRecord;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.mRecord));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setSource(View view) {
        this.mRecord.setSource(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setSource(View view, int i) {
        setSource(this.mRecord, view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setSource(AccessibilityRecord accessibilityRecord, View view, int i) {
        Api16Impl.setSource(accessibilityRecord, view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setChecked(boolean z) {
        this.mRecord.setChecked(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setEnabled(boolean z) {
        this.mRecord.setEnabled(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setPassword(boolean z) {
        this.mRecord.setPassword(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setFullScreen(boolean z) {
        this.mRecord.setFullScreen(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setScrollable(boolean z) {
        this.mRecord.setScrollable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setItemCount(int i) {
        this.mRecord.setItemCount(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setCurrentItemIndex(int i) {
        this.mRecord.setCurrentItemIndex(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setFromIndex(int i) {
        this.mRecord.setFromIndex(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setToIndex(int i) {
        this.mRecord.setToIndex(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setScrollX(int i) {
        this.mRecord.setScrollX(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setScrollY(int i) {
        this.mRecord.setScrollY(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.mRecord);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
        return Api15Impl.getMaxScrollX(accessibilityRecord);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setMaxScrollX(int i) {
        setMaxScrollX(this.mRecord, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i) {
        Api15Impl.setMaxScrollX(accessibilityRecord, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.mRecord);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
        return Api15Impl.getMaxScrollY(accessibilityRecord);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setMaxScrollY(int i) {
        setMaxScrollY(this.mRecord, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i) {
        Api15Impl.setMaxScrollY(accessibilityRecord, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setAddedCount(int i) {
        this.mRecord.setAddedCount(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setRemovedCount(int i) {
        this.mRecord.setRemovedCount(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setClassName(CharSequence charSequence) {
        this.mRecord.setClassName(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public List<CharSequence> getText() {
        return this.mRecord.getText();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        this.mRecord.setBeforeText(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        this.mRecord.setContentDescription(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        this.mRecord.setParcelableData(parcelable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void recycle() {
        this.mRecord.recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.mRecord;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.mRecord;
        if (accessibilityRecord == null) {
            return accessibilityRecordCompat.mRecord == null;
        }
        return accessibilityRecord.equals(accessibilityRecordCompat.mRecord);
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setSource(AccessibilityRecord accessibilityRecord, View view, int i) {
            accessibilityRecord.setSource(view, i);
        }
    }

    static class Api15Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api15Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollX(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }
}
