package com.kakaogame.util.json;

import com.liapp.y;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* compiled from: JSONArray.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\nB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/util/json/JSONArray;", "Ljava/util/ArrayList;", "", "Lcom/kakaogame/util/json/JSONAware;", "Lcom/kakaogame/util/json/JSONStreamAware;", "()V", "toJSONString", "", "toString", "writeJSONString", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class JSONArray extends ArrayList<Object> implements JSONAware, JSONStreamAware {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = 3957988303675231981L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String toJSONString(Object[] objArr) {
        return INSTANCE.toJSONString(objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ int getSize() {
        return super.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return removeAt(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Object removeAt(int i) {
        return super.remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.util.json.JSONStreamAware
    public String writeJSONString() throws IOException {
        return INSTANCE.writeJSONString(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.util.json.JSONAware
    public String toJSONString() {
        return INSTANCE.toJSONString(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection
    public String toString() {
        return toJSONString();
    }

    /* compiled from: JSONArray.kt */
    @Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0018\n\u0002\u0010\u0012\n\u0002\u0010\u0019\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013J\u001d\u0010\u0014\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0014\u001a\u00020\u00062\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/util/json/JSONArray$Companion;", "", "()V", "serialVersionUID", "", "toJSONString", "", "array", "", "([Ljava/lang/Object;)Ljava/lang/String;", "", "", "", "", "", "", "", "", "collection", "", "writeJSONString", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(Collection<? extends Object> collection) throws IOException {
            StringWriter stringWriter = new StringWriter();
            String str = y.ٲٴݴ״ٰ(1781855688);
            String str2 = y.ݮڮֲڭܩ(-628841308);
            if (collection == null) {
                stringWriter.write(str2);
                String stringWriter2 = stringWriter.toString();
                Intrinsics.checkNotNullExpressionValue(stringWriter2, str);
                return stringWriter2;
            }
            stringWriter.write(91);
            boolean z = true;
            for (Object obj : collection) {
                if (z) {
                    z = false;
                } else {
                    stringWriter.write(44);
                }
                if (obj == null) {
                    stringWriter.write(str2);
                } else {
                    stringWriter.write(JSONValue.writeJSONString(obj));
                }
            }
            stringWriter.write(93);
            String stringWriter3 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter3, str);
            return stringWriter3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(Collection<? extends Object> collection) {
            try {
                return writeJSONString(collection);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(byte[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٴسسݬߨ(1392956562));
                    stringWriter.write(String.valueOf((int) array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ٲٴݴ״ٰ(1781559176));
                        stringWriter.write(String.valueOf((int) array[i]));
                    }
                    stringWriter.write("]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(byte[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(short[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٴسسݬߨ(1392956562));
                    stringWriter.write(String.valueOf((int) array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ٲٴݴ״ٰ(1781559176));
                        stringWriter.write(String.valueOf((int) array[i]));
                    }
                    stringWriter.write("]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(short[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(int[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٴسسݬߨ(1392956562));
                    stringWriter.write(String.valueOf(array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ٲٴݴ״ٰ(1781559176));
                        stringWriter.write(String.valueOf(array[i]));
                    }
                    stringWriter.write("]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(int[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(long[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٴسسݬߨ(1392956562));
                    stringWriter.write(String.valueOf(array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ٲٴݴ״ٰ(1781559176));
                        stringWriter.write(String.valueOf(array[i]));
                    }
                    stringWriter.write("]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(long[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(float[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٴسسݬߨ(1392956562));
                    stringWriter.write(String.valueOf(array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ٲٴݴ״ٰ(1781559176));
                        stringWriter.write(String.valueOf(array[i]));
                    }
                    stringWriter.write("]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(float[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(double[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٴسسݬߨ(1392956562));
                    stringWriter.write(String.valueOf(array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ٲٴݴ״ٰ(1781559176));
                        stringWriter.write(String.valueOf(array[i]));
                    }
                    stringWriter.write("]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(double[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(boolean[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٴسسݬߨ(1392956562));
                    stringWriter.write(String.valueOf(array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ٲٴݴ״ٰ(1781559176));
                        stringWriter.write(String.valueOf(array[i]));
                    }
                    stringWriter.write("]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(boolean[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(char[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٲٴݴ״ٰ(1782550368));
                    stringWriter.write(String.valueOf(array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ۮڭڭܬި(862910883));
                        stringWriter.write(String.valueOf(array[i]));
                    }
                    stringWriter.write("\"]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toJSONString(char[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(Object[] array) throws IOException {
            StringWriter stringWriter = new StringWriter();
            if (array == null) {
                stringWriter.write("null");
            } else {
                if (array.length == 0) {
                    stringWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                } else {
                    stringWriter.write(y.ٴسسݬߨ(1392956562));
                    stringWriter.write(JSONValue.writeJSONString(array[0]));
                    int length = array.length;
                    for (int i = 1; i < length; i++) {
                        stringWriter.write(y.ٲٴݴ״ٰ(1781559176));
                        stringWriter.write(JSONValue.writeJSONString(array[i]));
                    }
                    stringWriter.write("]");
                }
            }
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, y.ٲٴݴ״ٰ(1781855688));
            return stringWriter2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final String toJSONString(Object[] array) {
            try {
                return writeJSONString(array);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
