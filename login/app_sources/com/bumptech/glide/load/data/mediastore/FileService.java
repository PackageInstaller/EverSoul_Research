package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* loaded from: classes.dex */
class FileService {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FileService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean exists(File file) {
        return file.exists();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long length(File file) {
        return file.length();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public File get(String str) {
        return new File(str);
    }
}
