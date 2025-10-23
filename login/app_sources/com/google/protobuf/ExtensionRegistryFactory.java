package com.google.protobuf;

/* loaded from: classes3.dex */
final class ExtensionRegistryFactory {
    static final Class<?> EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
    static final String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExtensionRegistryFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Class<?> reflectExtensionRegistry() {
        try {
            return Class.forName(FULL_REGISTRY_CLASS_NAME);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ExtensionRegistryLite create() {
        ExtensionRegistryLite invokeSubclassFactory = invokeSubclassFactory("newInstance");
        return invokeSubclassFactory != null ? invokeSubclassFactory : new ExtensionRegistryLite();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ExtensionRegistryLite createEmpty() {
        ExtensionRegistryLite invokeSubclassFactory = invokeSubclassFactory("getEmptyRegistry");
        return invokeSubclassFactory != null ? invokeSubclassFactory : ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isFullRegistry(ExtensionRegistryLite extensionRegistryLite) {
        Class<?> cls = EXTENSION_REGISTRY_CLASS;
        return cls != null && cls.isAssignableFrom(extensionRegistryLite.getClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final ExtensionRegistryLite invokeSubclassFactory(String str) {
        Class<?> cls = EXTENSION_REGISTRY_CLASS;
        if (cls == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
