package kotlin.p031io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileTreeWalk.kt */
@Metadata(m838d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, m839d2 = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, m840k = 5, m841mv = {1, 8, 0}, m843xi = 49, m844xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ FileTreeWalk walk$default(File file, FileWalkDirection fileWalkDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return FilesKt.walk(file, fileWalkDirection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final FileTreeWalk walk(File file, FileWalkDirection direction) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new FileTreeWalk(file, direction);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final FileTreeWalk walkTopDown(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return FilesKt.walk(file, FileWalkDirection.TOP_DOWN);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final FileTreeWalk walkBottomUp(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return FilesKt.walk(file, FileWalkDirection.BOTTOM_UP);
    }
}
