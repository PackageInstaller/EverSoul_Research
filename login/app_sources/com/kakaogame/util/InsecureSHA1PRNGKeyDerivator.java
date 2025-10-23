package com.kakaogame.util;

import androidx.core.view.ViewCompat;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InsecureSHA1PRNGKeyDerivator.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0004J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/util/InsecureSHA1PRNGKeyDerivator;", "", "()V", "copies", "", "counter", "", "nextBIndex", "", "nextBytes", "", "seed", "seedLength", "state", "", "bytes", "setSeed", "updateSeed", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InsecureSHA1PRNGKeyDerivator {
    private static final int BYTES_OFFSET = 81;
    private static final int COUNTER_BASE = 0;
    private static final int DIGEST_LENGTH = 20;
    private static final int EXTRAFRAME_OFFSET = 5;
    private static final int FRAME_LENGTH = 16;
    private static final int FRAME_OFFSET = 21;

    /* renamed from: H0 */
    private static final int f1129H0 = 1732584193;

    /* renamed from: H1 */
    private static final int f1130H1 = -271733879;

    /* renamed from: H2 */
    private static final int f1131H2 = -1732584194;

    /* renamed from: H3 */
    private static final int f1132H3 = 271733878;

    /* renamed from: H4 */
    private static final int f1133H4 = -1009589776;
    private static final int HASHBYTES_TO_USE = 20;
    private static final int HASHCOPY_OFFSET = 0;
    private static final int HASH_OFFSET = 82;
    private static final int MAX_BYTES = 48;
    private static final int NEXT_BYTES = 2;
    private static final int SET_SEED = 1;
    private static final int UNDEFINED = 0;
    private final transient int[] copies;
    private transient long counter;
    private transient int nextBIndex;
    private final transient byte[] nextBytes;
    private final transient int[] seed;
    private transient long seedLength;
    private transient int state;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] END_FLAGS = {Integer.MIN_VALUE, 8388608, 32768, 128};
    private static final int[] RIGHT1 = {0, 40, 48, 56};
    private static final int[] RIGHT2 = {0, 8, 16, 24};
    private static final int[] LEFT = {0, 24, 16, 8};
    private static final int[] MASK = {-1, ViewCompat.MEASURED_SIZE_MASK, 65535, 255};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ InsecureSHA1PRNGKeyDerivator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InsecureSHA1PRNGKeyDerivator() {
        int[] iArr = new int[87];
        this.seed = iArr;
        iArr[82] = f1129H0;
        iArr[83] = f1130H1;
        iArr[84] = f1131H2;
        iArr[85] = f1132H3;
        iArr[86] = f1133H4;
        this.seedLength = 0L;
        this.copies = new int[37];
        this.nextBytes = new byte[20];
        this.nextBIndex = 20;
        this.counter = 0L;
        this.state = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void updateSeed(byte[] bytes) {
        INSTANCE.updateHash(this.seed, bytes, 0, bytes.length - 1);
        this.seedLength += bytes.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setSeed(byte[] seed) {
        if (seed == null) {
            throw new NullPointerException(y.֬ڱܱײٮ(-1159010351));
        }
        if (this.state == 2) {
            System.arraycopy(this.copies, 0, this.seed, 82, 5);
        }
        this.state = 1;
        if (seed.length != 0) {
            updateSeed(seed);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final synchronized void nextBytes(byte[] bytes) {
        int i;
        int i2;
        long j;
        try {
            if (bytes == null) {
                throw new NullPointerException("bytes == null");
            }
            int[] iArr = this.seed;
            int i3 = iArr[81];
            int i4 = i3 == 0 ? 0 : (i3 + 7) >> 2;
            int i5 = this.state;
            if (!(i5 != 0)) {
                throw new IllegalStateException("No seed supplied!".toString());
            }
            if (i5 == 1) {
                System.arraycopy(iArr, 82, this.copies, 0, 5);
                for (int i6 = i4 + 3; i6 < 18; i6++) {
                    this.seed[i6] = 0;
                }
                long j2 = (this.seedLength << 3) + 64;
                int[] iArr2 = this.seed;
                if (iArr2[81] < 48) {
                    iArr2[14] = (int) (j2 >>> 32);
                    iArr2[15] = (int) (j2 & (-1));
                } else {
                    int[] iArr3 = this.copies;
                    iArr3[19] = (int) (j2 >>> 32);
                    iArr3[20] = (int) (j2 & (-1));
                }
                this.nextBIndex = 20;
            }
            this.state = 2;
            if (bytes.length == 0) {
                return;
            }
            int i7 = this.nextBIndex;
            int length = 20 - i7 < bytes.length - 0 ? 20 - i7 : bytes.length - 0;
            if (length > 0) {
                System.arraycopy(this.nextBytes, i7, bytes, 0, length);
                this.nextBIndex += length;
                i = length + 0;
            } else {
                i = 0;
            }
            if (i >= bytes.length) {
                return;
            }
            int i8 = this.seed[81] & 3;
            while (true) {
                if (i8 == 0) {
                    int[] iArr4 = this.seed;
                    long j3 = this.counter;
                    iArr4[i4] = (int) (j3 >>> 32);
                    iArr4[i4 + 1] = (int) (j3 & (-1));
                    iArr4[i4 + 2] = END_FLAGS[0];
                    i2 = i4;
                    j = -1;
                } else {
                    int[] iArr5 = this.seed;
                    int i9 = iArr5[i4];
                    long j4 = this.counter;
                    i2 = i4;
                    iArr5[i2] = ((int) (MASK[i8] & (j4 >>> RIGHT1[i8]))) | i9;
                    j = -1;
                    iArr5[i2 + 1] = (int) ((j4 >>> RIGHT2[i8]) & (-1));
                    iArr5[i2 + 2] = (int) ((j4 << LEFT[i8]) | END_FLAGS[i8]);
                }
                int[] iArr6 = this.seed;
                if (iArr6[81] > 48) {
                    int[] iArr7 = this.copies;
                    iArr7[5] = iArr6[16];
                    iArr7[6] = iArr6[17];
                }
                Companion companion = INSTANCE;
                companion.computeHash(iArr6);
                int[] iArr8 = this.seed;
                if (iArr8[81] > 48) {
                    System.arraycopy(iArr8, 0, this.copies, 21, 16);
                    System.arraycopy(this.copies, 5, this.seed, 0, 16);
                    companion.computeHash(this.seed);
                    System.arraycopy(this.copies, 21, this.seed, 0, 16);
                }
                this.counter++;
                int i10 = 0;
                for (int i11 = 0; i11 < 5; i11++) {
                    int i12 = this.seed[i11 + 82];
                    byte[] bArr = this.nextBytes;
                    bArr[i10] = (byte) (i12 >>> 24);
                    bArr[i10 + 1] = (byte) (i12 >>> 16);
                    bArr[i10 + 2] = (byte) (i12 >>> 8);
                    bArr[i10 + 3] = (byte) i12;
                    i10 += 4;
                }
                this.nextBIndex = 0;
                int length2 = 20 < bytes.length - i ? 20 : bytes.length - i;
                if (length2 > 0) {
                    System.arraycopy(this.nextBytes, 0, bytes, i, length2);
                    i += length2;
                    this.nextBIndex += length2;
                }
                if (i >= bytes.length) {
                    return;
                } else {
                    i4 = i2;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* compiled from: InsecureSHA1PRNGKeyDerivator.kt */
    @Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0018\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u0004J(\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, m839d2 = {"Lcom/kakaogame/util/InsecureSHA1PRNGKeyDerivator$Companion;", "", "()V", "BYTES_OFFSET", "", "COUNTER_BASE", "DIGEST_LENGTH", "END_FLAGS", "", "EXTRAFRAME_OFFSET", "FRAME_LENGTH", "FRAME_OFFSET", "H0", "H1", "H2", "H3", "H4", "HASHBYTES_TO_USE", "HASHCOPY_OFFSET", "HASH_OFFSET", "LEFT", "MASK", "MAX_BYTES", "NEXT_BYTES", "RIGHT1", "RIGHT2", "SET_SEED", "UNDEFINED", "computeHash", "", "arrW", "deriveInsecureKey", "", "seed", "keySizeInBytes", "updateHash", "intArray", "byteInput", "fromByte", "toByte", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final byte[] deriveInsecureKey(byte[] seed, int keySizeInBytes) {
            InsecureSHA1PRNGKeyDerivator insecureSHA1PRNGKeyDerivator = new InsecureSHA1PRNGKeyDerivator(null);
            insecureSHA1PRNGKeyDerivator.setSeed(seed);
            byte[] bArr = new byte[keySizeInBytes];
            insecureSHA1PRNGKeyDerivator.nextBytes(bArr);
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void computeHash(int[] arrW) {
            int i;
            int i2;
            int i3;
            int i4 = arrW[82];
            int i5 = arrW[83];
            int i6 = arrW[84];
            int i7 = arrW[85];
            int i8 = arrW[86];
            for (int i9 = 16; i9 < 80; i9++) {
                int i10 = ((arrW[i9 - 3] ^ arrW[i9 - 8]) ^ arrW[i9 - 14]) ^ arrW[i9 - 16];
                arrW[i9] = (i10 >>> 31) | (i10 << 1);
            }
            int i11 = 0;
            while (true) {
                i = 20;
                if (i11 >= 20) {
                    break;
                }
                int i12 = i8 + arrW[i11] + 1518500249 + ((i4 << 5) | (i4 >>> 27)) + ((i5 & i6) | ((~i5) & i7));
                int i13 = (i5 >>> 2) | (i5 << 30);
                i11++;
                i5 = i4;
                i4 = i12;
                i8 = i7;
                i7 = i6;
                i6 = i13;
            }
            while (true) {
                i2 = 40;
                if (i >= 40) {
                    break;
                }
                int i14 = i8 + arrW[i] + 1859775393 + ((i4 << 5) | (i4 >>> 27)) + ((i5 ^ i6) ^ i7);
                int i15 = (i5 >>> 2) | (i5 << 30);
                i++;
                i5 = i4;
                i4 = i14;
                i8 = i7;
                i7 = i6;
                i6 = i15;
            }
            while (true) {
                i3 = 60;
                if (i2 >= 60) {
                    break;
                }
                int i16 = ((i8 + arrW[i2]) - 1894007588) + ((i4 << 5) | (i4 >>> 27)) + ((i5 & i6) | (i5 & i7) | (i6 & i7));
                int i17 = (i5 >>> 2) | (i5 << 30);
                i2++;
                i5 = i4;
                i4 = i16;
                i8 = i7;
                i7 = i6;
                i6 = i17;
            }
            while (i3 < 80) {
                int i18 = ((i8 + arrW[i3]) - 899497514) + ((i4 << 5) | (i4 >>> 27)) + ((i5 ^ i6) ^ i7);
                int i19 = (i5 >>> 2) | (i5 << 30);
                i3++;
                i5 = i4;
                i4 = i18;
                i8 = i7;
                i7 = i6;
                i6 = i19;
            }
            arrW[82] = arrW[82] + i4;
            arrW[83] = arrW[83] + i5;
            arrW[84] = arrW[84] + i6;
            arrW[85] = arrW[85] + i7;
            arrW[86] = arrW[86] + i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void updateHash(int[] intArray, byte[] byteInput, int fromByte, int toByte) {
            int i = intArray[81];
            int i2 = i >> 2;
            int i3 = i & 3;
            intArray[81] = (((i + toByte) - fromByte) + 1) & 63;
            if (i3 != 0) {
                while (fromByte <= toByte && i3 < 4) {
                    intArray[i2] = intArray[i2] | ((byteInput[fromByte] & 255) << ((3 - i3) << 3));
                    i3++;
                    fromByte++;
                }
                if (i3 == 4 && (i2 = i2 + 1) == 16) {
                    computeHash(intArray);
                    i2 = 0;
                }
                if (fromByte > toByte) {
                    return;
                }
            }
            int i4 = ((toByte - fromByte) + 1) >> 2;
            for (int i5 = 0; i5 < i4; i5++) {
                intArray[i2] = ((byteInput[fromByte] & 255) << 24) | ((byteInput[fromByte + 1] & 255) << 16) | ((byteInput[fromByte + 2] & 255) << 8) | (byteInput[fromByte + 3] & 255);
                fromByte += 4;
                i2++;
                if (i2 >= 16) {
                    computeHash(intArray);
                    i2 = 0;
                }
            }
            int i6 = (toByte - fromByte) + 1;
            if (i6 != 0) {
                int i7 = (byteInput[fromByte] & 255) << 24;
                if (i6 != 1) {
                    i7 |= (byteInput[fromByte + 1] & 255) << 16;
                    if (i6 != 2) {
                        i7 |= (byteInput[fromByte + 2] & 255) << 8;
                    }
                }
                intArray[i2] = i7;
            }
        }
    }
}
