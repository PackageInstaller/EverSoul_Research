package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import com.kakao.sdk.auth.Constants;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.annotation.CheckForNull;
import javax.crypto.spec.SecretKeySpec;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Hashing {
    static final int GOOD_FAST_HASH_SEED = (int) System.currentTimeMillis();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction goodFastHash(int i) {
        int checkPositiveAndMakeMultipleOf32 = checkPositiveAndMakeMultipleOf32(i);
        if (checkPositiveAndMakeMultipleOf32 == 32) {
            return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
        }
        if (checkPositiveAndMakeMultipleOf32 <= 128) {
            return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        }
        int i2 = (checkPositiveAndMakeMultipleOf32 + 127) / 128;
        HashFunction[] hashFunctionArr = new HashFunction[i2];
        hashFunctionArr[0] = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int i3 = GOOD_FAST_HASH_SEED;
        for (int i4 = 1; i4 < i2; i4++) {
            i3 += 1500450271;
            hashFunctionArr[i4] = murmur3_128(i3);
        }
        return new ConcatenatedHashFunction(hashFunctionArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static HashFunction murmur3_32(int i) {
        return new Murmur3_32HashFunction(i, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static HashFunction murmur3_32() {
        return Murmur3_32HashFunction.MURMUR3_32;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction murmur3_32_fixed(int i) {
        return new Murmur3_32HashFunction(i, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction murmur3_32_fixed() {
        return Murmur3_32HashFunction.MURMUR3_32_FIXED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction murmur3_128(int i) {
        return new Murmur3_128HashFunction(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction murmur3_128() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction sipHash24() {
        return SipHashFunction.SIP_HASH_24;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction sipHash24(long j, long j2) {
        return new SipHashFunction(2, 4, j, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static HashFunction md5() {
        return Md5Holder.MD5;
    }

    private static class Md5Holder {
        static final HashFunction MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Md5Holder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static HashFunction sha1() {
        return Sha1Holder.SHA_1;
    }

    private static class Sha1Holder {
        static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Sha1Holder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction sha256() {
        return Sha256Holder.SHA_256;
    }

    private static class Sha256Holder {
        static final HashFunction SHA_256 = new MessageDigestHashFunction(Constants.CODE_CHALLENGE_ALGORITHM, "Hashing.sha256()");

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Sha256Holder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction sha384() {
        return Sha384Holder.SHA_384;
    }

    private static class Sha384Holder {
        static final HashFunction SHA_384 = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Sha384Holder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction sha512() {
        return Sha512Holder.SHA_512;
    }

    private static class Sha512Holder {
        static final HashFunction SHA_512 = new MessageDigestHashFunction(Constants.CODE_VERIFIER_ALGORITHM, "Hashing.sha512()");

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Sha512Holder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction hmacMd5(Key key) {
        return new MacHashFunction("HmacMD5", key, hmacToString("hmacMd5", key));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction hmacMd5(byte[] bArr) {
        return hmacMd5(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacMD5"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction hmacSha1(Key key) {
        return new MacHashFunction("HmacSHA1", key, hmacToString("hmacSha1", key));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction hmacSha1(byte[] bArr) {
        return hmacSha1(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA1"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction hmacSha256(Key key) {
        return new MacHashFunction("HmacSHA256", key, hmacToString("hmacSha256", key));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction hmacSha256(byte[] bArr) {
        return hmacSha256(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA256"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction hmacSha512(Key key) {
        return new MacHashFunction("HmacSHA512", key, hmacToString("hmacSha512", key));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction hmacSha512(byte[] bArr) {
        return hmacSha512(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA512"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String hmacToString(String str, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", str, key.getAlgorithm(), key.getFormat());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction crc32c() {
        return Crc32cHashFunction.CRC_32_C;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction crc32() {
        return ChecksumType.CRC_32.hashFunction;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction adler32() {
        return ChecksumType.ADLER_32.hashFunction;
    }

    @Immutable
    enum ChecksumType implements ImmutableSupplier<Checksum> {
        CRC_32("Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Supplier
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Supplier
            public Checksum get() {
                return new Adler32();
            }
        };

        public final HashFunction hashFunction;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction farmHashFingerprint64() {
        return FarmHashFingerprint64.FARMHASH_FINGERPRINT_64;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction fingerprint2011() {
        return Fingerprint2011.FINGERPRINT_2011;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int consistentHash(HashCode hashCode, int i) {
        return consistentHash(hashCode.padToLong(), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int consistentHash(long j, int i) {
        int i2 = 0;
        Preconditions.checkArgument(i > 0, "buckets must be positive: %s", i);
        LinearCongruentialGenerator linearCongruentialGenerator = new LinearCongruentialGenerator(j);
        while (true) {
            int nextDouble = (int) ((i2 + 1) / linearCongruentialGenerator.nextDouble());
            if (nextDouble < 0 || nextDouble >= i) {
                break;
            }
            i2 = nextDouble;
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashCode combineOrdered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] asBytes = it2.next().asBytes();
            Preconditions.checkArgument(asBytes.length == bits, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes.length; i++) {
                bArr[i] = (byte) ((bArr[i] * 37) ^ asBytes[i]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashCode combineUnordered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        Iterator<HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] asBytes = it2.next().asBytes();
            Preconditions.checkArgument(asBytes.length == bits, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes.length; i++) {
                bArr[i] = (byte) (bArr[i] + asBytes[i]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int checkPositiveAndMakeMultipleOf32(int i) {
        Preconditions.checkArgument(i > 0, "Number of bits must be positive");
        return (i + 31) & (-32);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction concatenating(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        Collections.addAll(arrayList, hashFunctionArr);
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashFunction concatenating(Iterable<HashFunction> iterable) {
        Preconditions.checkNotNull(iterable);
        ArrayList arrayList = new ArrayList();
        Iterator<HashFunction> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Preconditions.checkArgument(!arrayList.isEmpty(), "number of hash functions (%s) must be > 0", arrayList.size());
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    private static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ConcatenatedHashFunction(HashFunction... hashFunctionArr) {
            super(hashFunctionArr);
            for (HashFunction hashFunction : hashFunctionArr) {
                Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), (Object) hashFunction);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.AbstractCompositeHashFunction
        HashCode makeHash(Hasher[] hasherArr) {
            byte[] bArr = new byte[bits() / 8];
            int i = 0;
            for (Hasher hasher : hasherArr) {
                HashCode hash = hasher.hash();
                i += hash.writeBytesTo(bArr, i, hash.bits() / 8);
            }
            return HashCode.fromBytesNoCopy(bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.HashFunction
        public int bits() {
            int i = 0;
            for (HashFunction hashFunction : this.functions) {
                i += hashFunction.bits();
            }
            return i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConcatenatedHashFunction) {
                return Arrays.equals(this.functions, ((ConcatenatedHashFunction) obj).functions);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Arrays.hashCode(this.functions);
        }
    }

    private static final class LinearCongruentialGenerator {
        private long state;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LinearCongruentialGenerator(long j) {
            this.state = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public double nextDouble() {
            this.state = (this.state * 2862933555777941757L) + 1;
            return (((int) (r2 >>> 33)) + 1) / 2.147483648E9d;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Hashing() {
    }
}
