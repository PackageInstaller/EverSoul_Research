package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f392c;

    /* renamed from: d */
    private final int f393d;

    /* renamed from: k0 */
    private final long f394k0;

    /* renamed from: k1 */
    private final long f395k1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SipHashFunction(int i, int i2, long j, long j2) {
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f392c = i;
        this.f393d = i2;
        this.f394k0 = j;
        this.f395k1 = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f392c, this.f393d, this.f394k0, this.f395k1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        int i = this.f392c;
        int i2 = this.f393d;
        long j = this.f394k0;
        return new StringBuilder(81).append("Hashing.sipHash").append(i).append(i2).append("(").append(j).append(", ").append(this.f395k1).append(")").toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.f392c == sipHashFunction.f392c && this.f393d == sipHashFunction.f393d && this.f394k0 == sipHashFunction.f394k0 && this.f395k1 == sipHashFunction.f395k1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (int) ((((getClass().hashCode() ^ this.f392c) ^ this.f393d) ^ this.f394k0) ^ this.f395k1);
    }

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b */
        private long f396b;

        /* renamed from: c */
        private final int f397c;

        /* renamed from: d */
        private final int f398d;
        private long finalM;

        /* renamed from: v0 */
        private long f399v0;

        /* renamed from: v1 */
        private long f400v1;

        /* renamed from: v2 */
        private long f401v2;

        /* renamed from: v3 */
        private long f402v3;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f396b = 0L;
            this.finalM = 0L;
            this.f397c = i;
            this.f398d = i2;
            this.f399v0 = 8317987319222330741L ^ j;
            this.f400v1 = 7237128888997146477L ^ j2;
            this.f401v2 = 7816392313619706465L ^ j;
            this.f402v3 = 8387220255154660723L ^ j2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            this.f396b += 8;
            processM(byteBuffer.getLong());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            this.f396b += byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (byteBuffer.get() & 255) << i;
                i += 8;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode makeHash() {
            long j = this.finalM ^ (this.f396b << 56);
            this.finalM = j;
            processM(j);
            this.f401v2 ^= 255;
            sipRound(this.f398d);
            return HashCode.fromLong(((this.f399v0 ^ this.f400v1) ^ this.f401v2) ^ this.f402v3);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void processM(long j) {
            this.f402v3 ^= j;
            sipRound(this.f397c);
            this.f399v0 = j ^ this.f399v0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f399v0;
                long j2 = this.f400v1;
                this.f399v0 = j + j2;
                this.f401v2 += this.f402v3;
                this.f400v1 = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.f402v3, 16);
                long j3 = this.f400v1;
                long j4 = this.f399v0;
                this.f400v1 = j3 ^ j4;
                this.f402v3 = rotateLeft ^ this.f401v2;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                long j5 = this.f401v2;
                long j6 = this.f400v1;
                this.f401v2 = j5 + j6;
                this.f399v0 = rotateLeft2 + this.f402v3;
                this.f400v1 = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.f402v3, 21);
                long j7 = this.f400v1;
                long j8 = this.f401v2;
                this.f400v1 = j7 ^ j8;
                this.f402v3 = rotateLeft3 ^ this.f399v0;
                this.f401v2 = Long.rotateLeft(j8, 32);
            }
        }
    }
}
