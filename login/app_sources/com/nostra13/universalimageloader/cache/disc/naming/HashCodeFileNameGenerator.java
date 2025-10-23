package com.nostra13.universalimageloader.cache.disc.naming;

/* loaded from: classes3.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
