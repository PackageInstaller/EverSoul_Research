package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AppLink {
    private Uri sourceUrl;
    private List<Target> targets;
    private Uri webUrl;

    public static class Target {
        private final String appName;
        private final String className;
        private final String packageName;
        private final Uri url;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Target(String str, String str2, Uri uri, String str3) {
            this.packageName = str;
            this.className = str2;
            this.url = uri;
            this.appName = str3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Uri getUrl() {
            return this.url;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getAppName() {
            return this.appName;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getClassName() {
            return this.className;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getPackageName() {
            return this.packageName;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppLink(Uri uri, List<Target> list, Uri uri2) {
        this.sourceUrl = uri;
        this.targets = list == null ? Collections.emptyList() : list;
        this.webUrl = uri2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Uri getSourceUrl() {
        return this.sourceUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.targets);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Uri getWebUrl() {
        return this.webUrl;
    }
}
