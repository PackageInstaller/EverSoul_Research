package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class GlobalLibraryVersionRegistrar {
    private static volatile GlobalLibraryVersionRegistrar INSTANCE;
    private final Set<LibraryVersion> infos = new HashSet();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GlobalLibraryVersionRegistrar() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerVersion(String str, String str2) {
        synchronized (this.infos) {
            this.infos.add(LibraryVersion.create(str, str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Set<LibraryVersion> getRegisteredVersions() {
        Set<LibraryVersion> unmodifiableSet;
        synchronized (this.infos) {
            unmodifiableSet = Collections.unmodifiableSet(this.infos);
        }
        return unmodifiableSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlobalLibraryVersionRegistrar getInstance() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = INSTANCE;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = INSTANCE;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    INSTANCE = globalLibraryVersionRegistrar;
                }
            }
        }
        return globalLibraryVersionRegistrar;
    }
}
