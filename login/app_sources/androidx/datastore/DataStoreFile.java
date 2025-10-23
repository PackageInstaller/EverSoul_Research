package androidx.datastore;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataStoreFile.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m839d2 = {"dataStoreFile", "Ljava/io/File;", "Landroid/content/Context;", "fileName", "", "datastore_release"}, m840k = 2, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class DataStoreFile {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final File dataStoreFile(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), Intrinsics.stringPlus("datastore/", fileName));
    }
}
