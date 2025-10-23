package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.C0047R;

/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private static Configuration sEmptyConfig;
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextThemeWrapper() {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.mThemeResource = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.mResources != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.mOverrideConfiguration != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.mOverrideConfiguration = new Configuration(configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourcesInternal();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Resources getResourcesInternal() {
        if (this.mResources == null) {
            if (this.mOverrideConfiguration == null || (Build.VERSION.SDK_INT >= 26 && isEmptyConfiguration(this.mOverrideConfiguration))) {
                this.mResources = super.getResources();
            } else {
                this.mResources = Api17Impl.createConfigurationContext(this, this.mOverrideConfiguration).getResources();
            }
        }
        return this.mResources;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.mThemeResource != i) {
            this.mThemeResource = i;
            initializeTheme();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getThemeResId() {
        return this.mThemeResource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.mTheme;
        if (theme != null) {
            return theme;
        }
        if (this.mThemeResource == 0) {
            this.mThemeResource = C0047R.style.Theme_AppCompat_Light;
        }
        initializeTheme();
        return this.mTheme;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.mInflater;
        }
        return getBaseContext().getSystemService(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initializeTheme() {
        boolean z = this.mTheme == null;
        if (z) {
            this.mTheme = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        onApplyThemeResource(this.mTheme, this.mThemeResource, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isEmptyConfiguration(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (sEmptyConfig == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            sEmptyConfig = configuration2;
        }
        return configuration.equals(sEmptyConfig);
    }

    static class Api17Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api17Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Context createConfigurationContext(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            return contextThemeWrapper.createConfigurationContext(configuration);
        }
    }
}
