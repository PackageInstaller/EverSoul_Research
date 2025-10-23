package org.apache.commons.lang3;

import com.liapp.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SerializationUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Serializable> T clone(T t) {
        if (t == null) {
            return null;
        }
        try {
            ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t)), t.getClass().getClassLoader());
            try {
                T t2 = (T) classLoaderAwareObjectInputStream.readObject();
                classLoaderAwareObjectInputStream.close();
                return t2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        classLoaderAwareObjectInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new SerializationException(y.ٲٴݴ״ٰ(1781682424), e);
        } catch (ClassNotFoundException e2) {
            throw new SerializationException(y.دײܮڳܯ(2051951557), e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Serializable> T roundtrip(T t) {
        return (T) deserialize(serialize(t));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void serialize(Serializable serializable, OutputStream outputStream) {
        Validate.isTrue(outputStream != null, y.ٴسسݬߨ(1392985386), new Object[0]);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T deserialize(InputStream inputStream) {
        Validate.isTrue(inputStream != null, y.ٲٴݴ״ٰ(1781683304), new Object[0]);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                T t = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t;
            } finally {
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T deserialize(byte[] bArr) {
        Validate.isTrue(bArr != null, y.دײܮڳܯ(2051950333), new Object[0]);
        return (T) deserialize(new ByteArrayInputStream(bArr));
    }

    static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes;
        private final ClassLoader classLoader;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            HashMap hashMap = new HashMap();
            primitiveTypes = hashMap;
            hashMap.put(y.٬ݯح׭٩(575984670), Byte.TYPE);
            hashMap.put(y.ۮڭڭܬި(862157243), Short.TYPE);
            hashMap.put(y.ۮڭڭܬި(862157299), Integer.TYPE);
            hashMap.put(y.֬ڱܱײٮ(-1159246383), Long.TYPE);
            hashMap.put(y.ݮڮֲڭܩ(-628939508), Float.TYPE);
            hashMap.put(y.ݮڮֲڭܩ(-628939444), Double.TYPE);
            hashMap.put(y.ٴسسݬߨ(1392973754), Boolean.TYPE);
            hashMap.put(y.٬ݯح׭٩(575984750), Character.TYPE);
            hashMap.put(y.٬ݯح׭٩(575985062), Void.TYPE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws IOException {
            super(inputStream);
            this.classLoader = classLoader;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, this.classLoader);
                } catch (ClassNotFoundException unused) {
                    return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
                }
            } catch (ClassNotFoundException e) {
                Class<?> cls = primitiveTypes.get(name);
                if (cls != null) {
                    return cls;
                }
                throw e;
            }
        }
    }
}
