package twitter4j;

import com.liapp.y;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class GeoLocation implements Serializable {
    private static final long serialVersionUID = 6353721071298376949L;
    private double latitude;
    private double longitude;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GeoLocation(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GeoLocation() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double getLatitude() {
        return this.latitude;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double getLongitude() {
        return this.longitude;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeoLocation)) {
            return false;
        }
        GeoLocation geoLocation = (GeoLocation) obj;
        return Double.compare(geoLocation.getLatitude(), this.latitude) == 0 && Double.compare(geoLocation.getLongitude(), this.longitude) == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.دײܮڳܯ(2051188837) + this.latitude + y.ۮڭڭܬި(862962683) + this.longitude + '}';
    }
}
