package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

/* loaded from: classes2.dex */
public final class AtProtobuf {
    private Protobuf.IntEncoding intEncoding = Protobuf.IntEncoding.DEFAULT;
    private int tag;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AtProtobuf tag(int i) {
        this.tag = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AtProtobuf intEncoding(Protobuf.IntEncoding intEncoding) {
        this.intEncoding = intEncoding;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AtProtobuf builder() {
        return new AtProtobuf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Protobuf build() {
        return new ProtobufImpl(this.tag, this.intEncoding);
    }

    private static final class ProtobufImpl implements Protobuf {
        private final Protobuf.IntEncoding intEncoding;
        private final int tag;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ProtobufImpl(int i, Protobuf.IntEncoding intEncoding) {
            this.tag = i;
            this.intEncoding = intEncoding;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.tag;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.intEncoding;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.tag == protobuf.tag() && this.intEncoding.equals(protobuf.intEncoding());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.tag) + (this.intEncoding.hashCode() ^ 2041407134);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.annotation.Annotation
        public String toString() {
            StringBuilder sb = new StringBuilder("@com.google.firebase.encoders.proto.Protobuf(tag=");
            sb.append(this.tag);
            sb.append("intEncoding=").append(this.intEncoding);
            sb.append(')');
            return sb.toString();
        }
    }
}
