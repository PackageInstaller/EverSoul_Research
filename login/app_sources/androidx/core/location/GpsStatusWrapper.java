package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* loaded from: classes.dex */
class GpsStatusWrapper extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;
    private Iterator<GpsSatellite> mCachedIterator;
    private int mCachedIteratorPosition;
    private GpsSatellite mCachedSatellite;
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getConstellationFromPrn(int i) {
        if (i > 0 && i <= 32) {
            return 1;
        }
        if (i >= 33 && i <= 64) {
            return 2;
        }
        if (i > 64 && i <= 88) {
            return 3;
        }
        if (i <= 200 || i > 235) {
            return (i < QZSS_SVID_MIN || i > 200) ? 0 : 4;
        }
        return 5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.mWrapped = gpsStatus2;
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = gpsStatus2.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        int i;
        synchronized (this.mWrapped) {
            if (this.mCachedSatelliteCount == -1) {
                for (GpsSatellite gpsSatellite : this.mWrapped.getSatellites()) {
                    this.mCachedSatelliteCount++;
                }
                this.mCachedSatelliteCount++;
            }
            i = this.mCachedSatelliteCount;
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i) {
        return getConstellationFromPrn(getSatellite(i).getPrn());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i) {
        return getSvidFromPrn(getSatellite(i).getPrn());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i) {
        return getSatellite(i).getSnr();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i) {
        return getSatellite(i).getElevation();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i) {
        return getSatellite(i).getAzimuth();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i) {
        return getSatellite(i).hasEphemeris();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i) {
        return getSatellite(i).hasAlmanac();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i) {
        return getSatellite(i).usedInFix();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GpsSatellite getSatellite(int i) {
        GpsSatellite gpsSatellite;
        synchronized (this.mWrapped) {
            if (i < this.mCachedIteratorPosition) {
                this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                this.mCachedIteratorPosition = -1;
            }
            while (true) {
                int i2 = this.mCachedIteratorPosition;
                if (i2 >= i) {
                    break;
                }
                this.mCachedIteratorPosition = i2 + 1;
                if (!this.mCachedIterator.hasNext()) {
                    this.mCachedSatellite = null;
                    break;
                }
                this.mCachedSatellite = this.mCachedIterator.next();
            }
            gpsSatellite = this.mCachedSatellite;
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GpsStatusWrapper) {
            return this.mWrapped.equals(((GpsStatusWrapper) obj).mWrapped);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getSvidFromPrn(int i) {
        int constellationFromPrn = getConstellationFromPrn(i);
        return constellationFromPrn != 2 ? constellationFromPrn != 3 ? constellationFromPrn != 5 ? i : i - 200 : i - 64 : i + 87;
    }
}
