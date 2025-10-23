package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

/* loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppCompatDialogFragment() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppCompatDialogFragment(int i) {
        super(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog appCompatDialog = (AppCompatDialog) dialog;
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return;
                } else {
                    dialog.getWindow().addFlags(24);
                }
            }
            appCompatDialog.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
