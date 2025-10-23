package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(str);
        this.mProviderPackage = (String) Preconditions.checkNotNull(str2);
        this.mQuery = (String) Preconditions.checkNotNull(str3);
        this.mCertificates = (List) Preconditions.checkNotNull(list);
        this.mCertificatesArray = 0;
        this.mIdentifier = createIdentifier(str, str2, str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FontRequest(String str, String str2, String str3, int i) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(str);
        this.mProviderPackage = (String) Preconditions.checkNotNull(str2);
        this.mQuery = (String) Preconditions.checkNotNull(str3);
        this.mCertificates = null;
        Preconditions.checkArgument(i != 0);
        this.mCertificatesArray = i;
        this.mIdentifier = createIdentifier(str, str2, str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String createIdentifier(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getQuery() {
        return this.mQuery;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public String getIdentifier() {
        return this.mIdentifier;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getId() {
        return this.mIdentifier;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        for (int i = 0; i < this.mCertificates.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }
}
