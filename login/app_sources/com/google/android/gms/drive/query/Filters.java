package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.query.internal.zzn;
import com.google.android.gms.drive.query.internal.zzp;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzv;
import com.google.android.gms.drive.query.internal.zzx;
import com.google.android.gms.drive.query.internal.zzz;

/* loaded from: classes.dex */
public class Filters {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: eq */
    public static <T> Filter m165eq(SearchableMetadataField<T> searchableMetadataField, T t) {
        Preconditions.checkNotNull(searchableMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new com.google.android.gms.drive.query.internal.zzb(zzx.zzmq, searchableMetadataField, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new com.google.android.gms.drive.query.internal.zzb(zzx.zzmr, searchableOrderedMetadataField, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new com.google.android.gms.drive.query.internal.zzb(zzx.zzmt, searchableOrderedMetadataField, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new com.google.android.gms.drive.query.internal.zzb(zzx.zzms, searchableOrderedMetadataField, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> searchableOrderedMetadataField, T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new com.google.android.gms.drive.query.internal.zzb(zzx.zzmu, searchableOrderedMetadataField, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: in */
    public static <T> Filter m166in(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        Preconditions.checkNotNull(searchableCollectionMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzp(searchableCollectionMetadataField, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: eq */
    public static Filter m164eq(CustomPropertyKey customPropertyKey, String str) {
        Preconditions.checkNotNull(customPropertyKey, "Custom property key may not be null.");
        Preconditions.checkNotNull(str, "Custom property value may not be null.");
        return new zzn(SearchableField.zzlv, new AppVisibleCustomProperties.zza().zza(customPropertyKey, str).zzbb());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Filter contains(SearchableMetadataField<String> searchableMetadataField, String str) {
        Preconditions.checkNotNull(searchableMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(str, "Value may not be null.");
        return new com.google.android.gms.drive.query.internal.zzb(zzx.zzmy, searchableMetadataField, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Filter and(Filter filter, Filter... filterArr) {
        Preconditions.checkNotNull(filter, "Filter may not be null.");
        Preconditions.checkNotNull(filterArr, "Additional filters may not be null.");
        return new zzr(zzx.zzmv, filter, filterArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Filter and(Iterable<Filter> iterable) {
        Preconditions.checkNotNull(iterable, "Filters may not be null");
        return new zzr(zzx.zzmv, iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    public static Filter m167or(Filter filter, Filter... filterArr) {
        Preconditions.checkNotNull(filter, "Filter may not be null.");
        Preconditions.checkNotNull(filterArr, "Additional filters may not be null.");
        return new zzr(zzx.zzmw, filter, filterArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    public static Filter m168or(Iterable<Filter> iterable) {
        Preconditions.checkNotNull(iterable, "Filters may not be null");
        return new zzr(zzx.zzmw, iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Filter not(Filter filter) {
        Preconditions.checkNotNull(filter, "Filter may not be null");
        return new zzv(filter);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Filter sharedWithMe() {
        return new com.google.android.gms.drive.query.internal.zzd(SearchableField.zzlu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Filter openedByMe() {
        return new com.google.android.gms.drive.query.internal.zzd(SearchableField.LAST_VIEWED_BY_ME);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Filter ownedByMe() {
        return new zzz();
    }
}
