package androidx.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class Registry {
    private static final Registry sRegistry = new Registry();
    private HashMap<String, RegistryCallback> mCallbacks = new HashMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Registry getInstance() {
        return sRegistry;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void register(String str, RegistryCallback registryCallback) {
        this.mCallbacks.put(str, registryCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unregister(String str, RegistryCallback registryCallback) {
        this.mCallbacks.remove(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void updateContent(String str, String str2) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onNewMotionScene(str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void updateProgress(String str, float f) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onProgress(f);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String currentContent(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            return registryCallback.currentMotionScene();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String currentLayoutInformation(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            return registryCallback.currentLayoutInformation();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDrawDebug(String str, int i) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.setDrawDebug(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLayoutInformationMode(String str, int i) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.setLayoutInformationMode(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<String> getLayoutList() {
        return this.mCallbacks.keySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getLastModified(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            return registryCallback.getLastModified();
        }
        return Long.MAX_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void updateDimensions(String str, int i, int i2) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onDimensions(i, i2);
        }
    }
}
