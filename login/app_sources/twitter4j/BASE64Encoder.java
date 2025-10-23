package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
public final class BASE64Encoder {
    private static final char last2byte = (char) Integer.parseInt(y.ٲٴݴ״ٰ(1782530672), 2);
    private static final char last4byte = (char) Integer.parseInt(y.֬ڱܱײٮ(-1159069559), 2);
    private static final char last6byte = (char) Integer.parseInt(y.دײܮڳܯ(2051234933), 2);
    private static final char lead6byte = (char) Integer.parseInt(y.ݬֲ֮ܲت(1512273359), 2);
    private static final char lead4byte = (char) Integer.parseInt(y.֬ڱܱײٮ(-1159068775), 2);
    private static final char lead2byte = (char) Integer.parseInt(y.ٴسسݬߨ(1393188522), 2);
    private static final char[] encodeTable = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BASE64Encoder() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encode(byte[] bArr) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder(((int) (bArr.length * 1.34d)) + 3);
        int i3 = 0;
        char c = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i3 %= 8;
            while (i3 < 8) {
                if (i3 == 0) {
                    i = ((char) (bArr[i4] & lead6byte)) >>> 2;
                } else if (i3 == 2) {
                    i = bArr[i4] & last6byte;
                } else if (i3 == 4) {
                    c = (char) (((char) (bArr[i4] & last4byte)) << 2);
                    int i5 = i4 + 1;
                    if (i5 < bArr.length) {
                        i2 = (bArr[i5] & lead2byte) >>> 6;
                        i = c | i2;
                    } else {
                        sb.append(encodeTable[c]);
                        i3 += 6;
                    }
                } else {
                    if (i3 == 6) {
                        c = (char) (((char) (bArr[i4] & last2byte)) << 4);
                        int i6 = i4 + 1;
                        if (i6 < bArr.length) {
                            i2 = (bArr[i6] & lead4byte) >>> 4;
                            i = c | i2;
                        }
                    }
                    sb.append(encodeTable[c]);
                    i3 += 6;
                }
                c = (char) i;
                sb.append(encodeTable[c]);
                i3 += 6;
            }
        }
        if (sb.length() % 4 != 0) {
            for (int length = 4 - (sb.length() % 4); length > 0; length--) {
                sb.append("=");
            }
        }
        return sb.toString();
    }
}
