package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MessageDigestHashFunction(String str, String str2) {
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        this.bytes = messageDigest.getDigestLength();
        this.toString = (String) Preconditions.checkNotNull(str2);
        this.supportsClone = supportsClone(messageDigest);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MessageDigestHashFunction(String str, int i, String str2) {
        this.toString = (String) Preconditions.checkNotNull(str2);
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        int digestLength = messageDigest.getDigestLength();
        Preconditions.checkArgument(i >= 4 && i <= digestLength, "bytes (%s) must be >= 4 and < %s", i, digestLength);
        this.bytes = i;
        this.supportsClone = supportsClone(messageDigest);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean supportsClone(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bytes * 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.toString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static MessageDigest getMessageDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.supportsClone) {
            try {
                return new MessageDigestHasher((MessageDigest) this.prototype.clone(), this.bytes);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes);
    }

    private static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SerializedForm(String str, int i, String str2) {
            this.algorithmName = str;
            this.bytes = i;
            this.toString = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }

    private static final class MessageDigestHasher extends AbstractByteHasher {
        private final int bytes;
        private final MessageDigest digest;
        private boolean done;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MessageDigestHasher(MessageDigest messageDigest, int i) {
            this.digest = messageDigest;
            this.bytes = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte b) {
            checkNotDone();
            this.digest.update(b);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] bArr, int i, int i2) {
            checkNotDone();
            this.digest.update(bArr, i, i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(ByteBuffer byteBuffer) {
            checkNotDone();
            this.digest.update(byteBuffer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            checkNotDone();
            this.done = true;
            if (this.bytes == this.digest.getDigestLength()) {
                return HashCode.fromBytesNoCopy(this.digest.digest());
            }
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.digest.digest(), this.bytes));
        }
    }
}
