package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class TextFormatEscaper {

    private interface ByteSequence {
        byte byteAt(int i);

        int size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TextFormatEscaper() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String escapeBytes(ByteSequence byteSequence) {
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i = 0; i < byteSequence.size(); i++) {
            byte byteAt = byteSequence.byteAt(i);
            if (byteAt == 34) {
                sb.append("\\\"");
            } else if (byteAt == 39) {
                sb.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (byteAt >= 32 && byteAt <= 126) {
                            sb.append((char) byteAt);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((byteAt >>> 3) & 7) + 48));
                            sb.append((char) ((byteAt & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String escapeBytes(final ByteString byteString) {
        return escapeBytes(new ByteSequence() { // from class: androidx.datastore.preferences.protobuf.TextFormatEscaper.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return ByteString.this.size();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int i) {
                return ByteString.this.byteAt(i);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String escapeBytes(final byte[] bArr) {
        return escapeBytes(new ByteSequence() { // from class: androidx.datastore.preferences.protobuf.TextFormatEscaper.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return bArr.length;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.datastore.preferences.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int i) {
                return bArr[i];
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String escapeDoubleQuotesAndBackslashes(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
