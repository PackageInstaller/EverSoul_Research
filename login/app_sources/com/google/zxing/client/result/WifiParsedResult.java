package com.google.zxing.client.result;

/* loaded from: classes3.dex */
public final class WifiParsedResult extends ParsedResult {
    private final String anonymousIdentity;
    private final String eapMethod;
    private final boolean hidden;
    private final String identity;
    private final String networkEncryption;
    private final String password;
    private final String phase2Method;
    private final String ssid;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WifiParsedResult(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WifiParsedResult(String str, String str2, String str3, boolean z) {
        this(str, str2, str3, z, null, null, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WifiParsedResult(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        super(ParsedResultType.WIFI);
        this.ssid = str2;
        this.networkEncryption = str;
        this.password = str3;
        this.hidden = z;
        this.identity = str4;
        this.anonymousIdentity = str5;
        this.eapMethod = str6;
        this.phase2Method = str7;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSsid() {
        return this.ssid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getNetworkEncryption() {
        return this.networkEncryption;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPassword() {
        return this.password;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isHidden() {
        return this.hidden;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getIdentity() {
        return this.identity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAnonymousIdentity() {
        return this.anonymousIdentity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getEapMethod() {
        return this.eapMethod;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPhase2Method() {
        return this.phase2Method;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(80);
        maybeAppend(this.ssid, sb);
        maybeAppend(this.networkEncryption, sb);
        maybeAppend(this.password, sb);
        maybeAppend(Boolean.toString(this.hidden), sb);
        return sb.toString();
    }
}
