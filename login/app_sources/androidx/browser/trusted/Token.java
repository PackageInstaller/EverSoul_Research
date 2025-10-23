package androidx.browser.trusted;

import android.content.pm.PackageManager;
import android.util.Log;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class Token {
    private static final String TAG = "Token";
    private final TokenContents mContents;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Token create(String str, PackageManager packageManager) {
        List<byte[]> fingerprintsForPackage = PackageIdentityUtils.getFingerprintsForPackage(str, packageManager);
        if (fingerprintsForPackage == null) {
            return null;
        }
        try {
            return new Token(TokenContents.create(str, fingerprintsForPackage));
        } catch (IOException e) {
            Log.e(TAG, "Exception when creating token.", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Token deserialize(byte[] bArr) {
        return new Token(TokenContents.deserialize(bArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Token(TokenContents tokenContents) {
        this.mContents = tokenContents;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] serialize() {
        return this.mContents.serialize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean matches(String str, PackageManager packageManager) {
        return PackageIdentityUtils.packageMatchesToken(str, packageManager, this.mContents);
    }
}
