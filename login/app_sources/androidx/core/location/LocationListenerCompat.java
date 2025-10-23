package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes.dex */
public interface LocationListenerCompat extends LocationListener {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.location.LocationListener
    default void onFlushComplete(int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.location.LocationListener
    default void onProviderDisabled(String str) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.location.LocationListener
    default void onProviderEnabled(String str) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.location.LocationListener
    default void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.location.LocationListener
    default void onLocationChanged(List<Location> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            onLocationChanged(list.get(i));
        }
    }
}
