package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    private static Method sSetIsFromMockProviderMethod;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LocationCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getElapsedRealtimeNanos(Location location) {
        return Api17Impl.getElapsedRealtimeNanos(location);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getElapsedRealtimeMillis(Location location) {
        return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(location));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasVerticalAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasVerticalAccuracy(location);
        }
        return containsExtra(location, "verticalAccuracy");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float getVerticalAccuracyMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getVerticalAccuracyMeters(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat("verticalAccuracy", 0.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setVerticalAccuracyMeters(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setVerticalAccuracyMeters(location, f);
        } else {
            getOrCreateExtras(location).putFloat("verticalAccuracy", f);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasSpeedAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasSpeedAccuracy(location);
        }
        return containsExtra(location, EXTRA_SPEED_ACCURACY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float getSpeedAccuracyMetersPerSecond(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getSpeedAccuracyMetersPerSecond(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setSpeedAccuracyMetersPerSecond(location, f);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_SPEED_ACCURACY, f);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasBearingAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasBearingAccuracy(location);
        }
        return containsExtra(location, EXTRA_BEARING_ACCURACY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float getBearingAccuracyDegrees(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getBearingAccuracyDegrees(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setBearingAccuracyDegrees(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setBearingAccuracyDegrees(location, f);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_BEARING_ACCURACY, f);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double getMslAltitudeMeters(Location location) {
        Preconditions.checkState(hasMslAltitude(location), "The Mean Sea Level altitude of the location is not set.");
        return getOrCreateExtras(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMslAltitudeMeters(Location location, double d) {
        getOrCreateExtras(location).putDouble(EXTRA_MSL_ALTITUDE, d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasMslAltitude(Location location) {
        return containsExtra(location, EXTRA_MSL_ALTITUDE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void removeMslAltitude(Location location) {
        removeExtra(location, EXTRA_MSL_ALTITUDE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float getMslAltitudeAccuracyMeters(Location location) {
        Preconditions.checkState(hasMslAltitudeAccuracy(location), "The Mean Sea Level altitude accuracy of the location is not set.");
        return getOrCreateExtras(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMslAltitudeAccuracyMeters(Location location, float f) {
        getOrCreateExtras(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasMslAltitudeAccuracy(Location location) {
        return containsExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void removeMslAltitudeAccuracy(Location location) {
        removeExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isMock(Location location) {
        return Api18Impl.isMock(location);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMock(Location location, boolean z) {
        try {
            getSetIsFromMockProviderMethod().invoke(location, Boolean.valueOf(z));
        } catch (IllegalAccessException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        } catch (NoSuchMethodException e2) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e2);
            throw noSuchMethodError;
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static class Api26Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api26Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setVerticalAccuracyMeters(Location location, float f) {
            location.setVerticalAccuracyMeters(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
            location.setSpeedAccuracyMetersPerSecond(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setBearingAccuracyDegrees(Location location, float f) {
            location.setBearingAccuracyDegrees(f);
        }
    }

    private static class Api18Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api18Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isMock(Location location) {
            return location.isFromMockProvider();
        }
    }

    private static class Api17Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api17Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static long getElapsedRealtimeNanos(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Bundle getOrCreateExtras(Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        location.setExtras(new Bundle());
        return location.getExtras();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean containsExtra(Location location, String str) {
        Bundle extras = location.getExtras();
        return extras != null && extras.containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void removeExtra(Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras(null);
            }
        }
    }
}
