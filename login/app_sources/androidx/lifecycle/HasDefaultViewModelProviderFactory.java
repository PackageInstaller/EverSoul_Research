package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

/* loaded from: classes.dex */
public interface HasDefaultViewModelProviderFactory {
    ViewModelProvider.Factory getDefaultViewModelProviderFactory();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }
}
