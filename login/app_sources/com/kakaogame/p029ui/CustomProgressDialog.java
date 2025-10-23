package com.kakaogame.p029ui;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.kakaogame.C2382R;
import com.kakaogame.databinding.ZinnySdkProgressBinding;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CustomProgressDialog.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/ui/CustomProgressDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dialog", "Lcom/kakaogame/ui/CustomProgressDialog$CustomProgressDialogImpl;", "dismiss", "", "show", "CustomProgressDialogImpl", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CustomProgressDialog {
    private final Context context;
    private CustomProgressDialogImpl dialog;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomProgressDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        this.context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void show() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CustomProgressDialog$show$1(this, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void dismiss() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CustomProgressDialog$dismiss$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CustomProgressDialog.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/ui/CustomProgressDialog$CustomProgressDialogImpl;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    static final class CustomProgressDialogImpl extends Dialog {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CustomProgressDialogImpl(Context context) {
            super(context, R.style.Theme.Translucent.NoTitleBar.Fullscreen);
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            final ZinnySdkProgressBinding inflate = ZinnySdkProgressBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
            setContentView(inflate.getRoot());
            setCancelable(false);
            final Animation loadAnimation = AnimationUtils.loadAnimation(context, C2382R.anim.zinny_sdk_rotate);
            setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.kakaogame.ui.CustomProgressDialog$CustomProgressDialogImpl$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    CustomProgressDialog.CustomProgressDialogImpl._init_$lambda$0(ZinnySdkProgressBinding.this, loadAnimation, dialogInterface);
                }
            });
            setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.ui.CustomProgressDialog$CustomProgressDialogImpl$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CustomProgressDialog.CustomProgressDialogImpl._init_$lambda$1(ZinnySdkProgressBinding.this, dialogInterface);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void _init_$lambda$0(ZinnySdkProgressBinding mainViewBinding, Animation animation, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(mainViewBinding, "$mainViewBinding");
            mainViewBinding.zinnySdkProgressView.startAnimation(animation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void _init_$lambda$1(ZinnySdkProgressBinding mainViewBinding, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(mainViewBinding, "$mainViewBinding");
            mainViewBinding.zinnySdkProgressView.clearAnimation();
        }
    }
}
