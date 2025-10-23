package com.google.zxing.client.result;

/* loaded from: classes3.dex */
public final class GeoParsedResult extends ParsedResult {
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final String query;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GeoParsedResult(double d, double d2, double d3, String str) {
        super(ParsedResultType.GEO);
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.query = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getGeoURI() {
        StringBuilder sb = new StringBuilder("geo:");
        sb.append(this.latitude);
        sb.append(',');
        sb.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb.append(',');
            sb.append(this.altitude);
        }
        if (this.query != null) {
            sb.append('?');
            sb.append(this.query);
        }
        return sb.toString();
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
    public double getAltitude() {
        return this.altitude;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getQuery() {
        return this.query;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.latitude);
        sb.append(", ");
        sb.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb.append(", ");
            sb.append(this.altitude);
            sb.append('m');
        }
        if (this.query != null) {
            sb.append(" (");
            sb.append(this.query);
            sb.append(')');
        }
        return sb.toString();
    }
}
