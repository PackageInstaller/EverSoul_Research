package com.kakaogame.p029ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.C0047R;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.C2382R;
import com.kakaogame.databinding.KakaoGameSdkAlertDialogBinding;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.VersionUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogManager.kt */
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002%&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J;\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00100\u0019J0\u0010\u001e\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007J \u0010\"\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u001aJ\b\u0010$\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, m839d2 = {"Lcom/kakaogame/ui/DialogManager;", "", "()V", "ACTION_CLOSE", "", "ACTION_OK", "ACTION_TERMINATE", "TAG", "createAlertDialogBuilder", "Landroid/app/AlertDialog$Builder;", "activity", "Landroid/app/Activity;", "requestedActivityOrientation", "", "requestedActivityOrientation$gamesdk_release", "showAlertDialog", "", "settings", "Lcom/kakaogame/ui/DialogManager$Settings;", "showAlertDialogBuilder", "builder", "showCustomAlertDialogBuilder", "showDialog", "message", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "showErrorDialog", "isFinish", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/DialogInterface$OnDismissListener;", "showProcessKillDialog", "cancelable", "useDefaultDialog", "CustomAlertDialog", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DialogManager {
    public static final String ACTION_CLOSE = "customUI_close";
    public static final String ACTION_OK = "customUI_ok";
    public static final String ACTION_TERMINATE = "customUI_terminate";
    public static final DialogManager INSTANCE = new DialogManager();
    private static final String TAG = "DialogManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showErrorDialog(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        showErrorDialog$default(this, activity, str, false, null, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showErrorDialog(Activity activity, String str, boolean z) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        showErrorDialog$default(this, activity, str, z, null, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DialogManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean useDefaultDialog() {
        return !InfodeskHelper.INSTANCE.isCustomDialogDevice(DeviceUtil.getDeviceModel()) || VersionUtil.INSTANCE.getAPIVersion() <= 30;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showAlertDialog(Activity activity, Settings settings) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        if (useDefaultDialog()) {
            AlertDialog.Builder createAlertDialogBuilder = createAlertDialogBuilder(activity);
            if (settings.getTitle() != null) {
                createAlertDialogBuilder.setTitle(settings.getTitle());
            } else if (settings.getTitleId() != null) {
                createAlertDialogBuilder.setTitle(settings.getTitleId().intValue());
            }
            if (settings.getMessage() != null) {
                createAlertDialogBuilder.setMessage(settings.getMessage());
            } else if (settings.getMessageId() != null) {
                createAlertDialogBuilder.setMessage(settings.getMessageId().intValue());
            }
            if (settings.getPositiveButtonTitle() != null) {
                createAlertDialogBuilder.setPositiveButton(settings.getPositiveButtonTitle(), settings.getPositiveListener());
            } else if (settings.getPositiveButtonTitleId() != null) {
                Integer positiveButtonTitleId = settings.getPositiveButtonTitleId();
                Intrinsics.checkNotNull(positiveButtonTitleId);
                createAlertDialogBuilder.setPositiveButton(positiveButtonTitleId.intValue(), settings.getPositiveListener());
            }
            if (settings.getNegativeButtonTitle() != null) {
                createAlertDialogBuilder.setNegativeButton(settings.getNegativeButtonTitle(), settings.getNegativeListener());
            } else if (settings.getNegativeButtonTitleId() != null) {
                Integer negativeButtonTitleId = settings.getNegativeButtonTitleId();
                Intrinsics.checkNotNull(negativeButtonTitleId);
                createAlertDialogBuilder.setNegativeButton(negativeButtonTitleId.intValue(), settings.getNegativeListener());
            }
            createAlertDialogBuilder.setCancelable(settings.isCancelable());
            if (settings.isCancelable()) {
                createAlertDialogBuilder.setOnCancelListener(settings.getCancelListener());
            }
            showAlertDialogBuilder(activity, createAlertDialogBuilder);
            return;
        }
        showCustomAlertDialogBuilder(activity, settings);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showAlertDialogBuilder(Activity activity, final AlertDialog.Builder builder) {
        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.ui.DialogManager$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                DialogManager.showAlertDialogBuilder$lambda$0(builder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAlertDialogBuilder$lambda$0(AlertDialog.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, y.ۮڭڭܬި(862783083));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        y.٬خݮ۳ݯ(create);
        Window window = create.getWindow();
        Intrinsics.checkNotNull(window);
        window.setGravity(17);
        y.٬خݮ۳ݯ(create);
        Window window2 = create.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.getAttributes().windowAnimations = R.style.Animation.Dialog;
        y.٬خݮ۳ݯ(create);
        create.show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showCustomAlertDialogBuilder(final Activity activity, final Settings settings) {
        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.ui.DialogManager$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                DialogManager.showCustomAlertDialogBuilder$lambda$1(activity, settings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCustomAlertDialogBuilder$lambda$1(Activity activity, Settings settings) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Intrinsics.checkNotNullParameter(settings, y.ݬֲ֮ܲت(1512064055));
        CustomAlertDialog customAlertDialog = new CustomAlertDialog(activity, settings);
        customAlertDialog.setCanceledOnTouchOutside(false);
        Window window = customAlertDialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setGravity(17);
        Window window2 = customAlertDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.getAttributes().windowAnimations = R.style.Animation.Dialog;
        customAlertDialog.show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void showErrorDialog$default(DialogManager dialogManager, Activity activity, String str, boolean z, DialogInterface.OnDismissListener onDismissListener, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            onDismissListener = null;
        }
        dialogManager.showErrorDialog(activity, str, z, onDismissListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showErrorDialog(final Activity activity, String message, final boolean isFinish, final DialogInterface.OnDismissListener listener) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Settings settings = new Settings(null, null, message, null, null, null, null, null, false, null, null, null, null, 8187, null);
        settings.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.DialogManager$$ExternalSyntheticLambda5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogManager.showErrorDialog$lambda$2(isFinish, activity, listener, dialogInterface, i);
            }
        });
        showAlertDialog(activity, settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showErrorDialog$lambda$2(boolean z, Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        dialogInterface.dismiss();
        if (z) {
            AppUtil.terminateApp(activity);
        } else if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final AlertDialog.Builder createAlertDialogBuilder(Activity activity) {
        return new AlertDialog.Builder(activity, R.style.Theme.DeviceDefault.Dialog.Alert);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showDialog(Activity activity, String message, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
        Settings settings = new Settings(null, null, message, null, null, null, null, null, true, null, null, null, null, 7931, null);
        settings.setCancelable(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.ui.DialogManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DialogManager.showDialog$lambda$3(Function1.this, dialogInterface);
            }
        });
        settings.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.DialogManager$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogManager.showDialog$lambda$4(Function1.this, dialogInterface, i);
            }
        });
        showAlertDialog(activity, settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showDialog$lambda$3(Function1 callback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showDialog$lambda$4(Function1 callback, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        dialogInterface.dismiss();
        callback.invoke(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showProcessKillDialog(Activity activity, String message, boolean cancelable) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Settings settings = new Settings(null, null, message, null, null, null, null, null, cancelable, null, null, null, null, 7931, null);
        settings.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.DialogManager$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogManager.showProcessKillDialog$lambda$5(dialogInterface, i);
            }
        });
        showAlertDialog(activity, settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showProcessKillDialog$lambda$5(DialogInterface dialogInterface, int i) {
        Process.killProcess(Process.myPid());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int requestedActivityOrientation$gamesdk_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        int requestedOrientation = activity.getRequestedOrientation();
        activity.setRequestedOrientation(DisplayUtil.isScreenPortrait(activity) ? 7 : 6);
        return requestedOrientation;
    }

    /* compiled from: DialogManager.kt */
    @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/ui/DialogManager$CustomAlertDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "settings", "Lcom/kakaogame/ui/DialogManager$Settings;", "(Landroid/content/Context;Lcom/kakaogame/ui/DialogManager$Settings;)V", "dismissDialog", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class CustomAlertDialog extends Dialog {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CustomAlertDialog(Context context, final Settings settings) {
            super(context, C0047R.style.AlertDialog_AppCompat);
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
            KakaoGameSdkAlertDialogBinding inflate = KakaoGameSdkAlertDialogBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
            if (settings.getTitle() != null) {
                inflate.alertDialogTitle.setText(settings.getTitle());
            } else if (settings.getTitleId() != null) {
                inflate.alertDialogTitle.setText(ResourceUtil.getString(context, settings.getTitleId().intValue()));
            } else {
                inflate.alertDialogTitle.setVisibility(8);
            }
            if (settings.getMessage() != null) {
                inflate.alertDialogMessage.setText(settings.getMessage());
            } else if (settings.getMessageId() != null) {
                inflate.alertDialogMessage.setText(ResourceUtil.getString(context, settings.getMessageId().intValue()));
            }
            int i = context.getResources().getConfiguration().uiMode & 48;
            Integer textColor = settings.getTextColor();
            if (textColor != null) {
                Integer num = textColor;
                int intValue = num.intValue();
                inflate.alertDialogTitle.setTextColor(intValue);
                inflate.alertDialogMessage.setTextColor(intValue);
                inflate.alertDialogOk.setTextColor(intValue);
                inflate.alertDialogCancel.setTextColor(intValue);
                num.intValue();
            } else if (i == 0 || i == 16) {
                inflate.alertDialog.setBackground(ContextCompat.getDrawable(context, C2382R.drawable.kakao_game_sdk_alert_dialog_bg_white));
                inflate.alertDialogTitle.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                inflate.alertDialogMessage.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                inflate.alertDialogOk.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                inflate.alertDialogCancel.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                inflate.actionDivider.setBackgroundColor(-12303292);
            } else if (i == 32) {
                inflate.alertDialog.setBackground(ContextCompat.getDrawable(context, C2382R.drawable.kakao_game_sdk_alert_dialog_bg_dark));
                inflate.alertDialogTitle.setTextColor(-1);
                inflate.alertDialogMessage.setTextColor(-1);
                inflate.alertDialogOk.setTextColor(-1);
                inflate.alertDialogCancel.setTextColor(-1);
                inflate.actionDivider.setBackgroundColor(-12303292);
            }
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (i == 0 || i == 16) {
                attributes.dimAmount = 0.33f;
                attributes.flags |= 2;
                window.setAttributes(attributes);
            } else if (i == 32) {
                attributes.dimAmount = 0.55f;
                attributes.flags |= 2;
                window.setAttributes(attributes);
            }
            if (settings.getNegativeButtonTitle() == null && settings.getNegativeButtonTitleId() == null) {
                inflate.alertDialogCancel.setVisibility(8);
                inflate.actionDivider.setVisibility(8);
            }
            if (settings.getPositiveButtonTitle() != null) {
                inflate.alertDialogOk.setText(settings.getPositiveButtonTitle());
            } else if (settings.getPositiveButtonTitleId() != null) {
                TextView textView = inflate.alertDialogOk;
                Integer positiveButtonTitleId = settings.getPositiveButtonTitleId();
                Intrinsics.checkNotNull(positiveButtonTitleId);
                textView.setText(ResourceUtil.getString(context, positiveButtonTitleId.intValue()));
            }
            inflate.alertDialogOk.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.ui.DialogManager$CustomAlertDialog$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogManager.CustomAlertDialog._init_$lambda$3(DialogManager.CustomAlertDialog.this, settings, view);
                }
            });
            if (settings.getNegativeButtonTitle() != null || settings.getNegativeButtonTitleId() != null) {
                if (settings.getNegativeButtonTitle() != null) {
                    inflate.alertDialogCancel.setText(settings.getNegativeButtonTitle());
                } else if (settings.getNegativeButtonTitleId() != null) {
                    TextView textView2 = inflate.alertDialogCancel;
                    Integer negativeButtonTitleId = settings.getNegativeButtonTitleId();
                    Intrinsics.checkNotNull(negativeButtonTitleId);
                    textView2.setText(ResourceUtil.getString(context, negativeButtonTitleId.intValue()));
                }
                inflate.alertDialogCancel.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.ui.DialogManager$CustomAlertDialog$$ExternalSyntheticLambda1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogManager.CustomAlertDialog._init_$lambda$4(DialogManager.CustomAlertDialog.this, settings, view);
                    }
                });
            }
            setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.ui.DialogManager$CustomAlertDialog$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    boolean _init_$lambda$5;
                    _init_$lambda$5 = DialogManager.CustomAlertDialog._init_$lambda$5(DialogManager.Settings.this, this, dialogInterface, i2, keyEvent);
                    return _init_$lambda$5;
                }
            });
            setCanceledOnTouchOutside(false);
            setContentView(inflate.getRoot());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void _init_$lambda$3(CustomAlertDialog this$0, Settings settings, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(settings, "$settings");
            this$0.dismissDialog();
            DialogInterface.OnClickListener positiveListener = settings.getPositiveListener();
            Intrinsics.checkNotNull(positiveListener);
            positiveListener.onClick(this$0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void _init_$lambda$4(CustomAlertDialog this$0, Settings settings, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(settings, "$settings");
            this$0.dismissDialog();
            DialogInterface.OnClickListener negativeListener = settings.getNegativeListener();
            Intrinsics.checkNotNull(negativeListener);
            negativeListener.onClick(this$0, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final boolean _init_$lambda$5(Settings settings, CustomAlertDialog this$0, DialogInterface dialogInterface, int i, KeyEvent event) {
            Intrinsics.checkNotNullParameter(settings, "$settings");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() != 1 || i != 4) {
                return false;
            }
            if (settings.isCancelable()) {
                this$0.dismissDialog();
                if (settings.getCancelListener() != null) {
                    DialogInterface.OnCancelListener cancelListener = settings.getCancelListener();
                    Intrinsics.checkNotNull(cancelListener);
                    cancelListener.onCancel(this$0);
                }
            }
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void dismissDialog() {
            dismiss();
        }
    }

    /* compiled from: DialogManager.kt */
    @Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001a\u001a\u0002042\u0006\u00105\u001a\u00020\u0012J\u0016\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000fJ\u0016\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u000fJ\u0016\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000fJ\u0016\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010#R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010&R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b1\u0010\u001fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b3\u0010\u001f¨\u0006:"}, m839d2 = {"Lcom/kakaogame/ui/DialogManager$Settings;", "", "title", "", "titleId", "", "message", "messageId", "positiveButtonTitle", "positiveButtonTitleId", "negativeButtonTitle", "negativeButtonTitleId", "isCancelable", "", "positiveListener", "Landroid/content/DialogInterface$OnClickListener;", "negativeListener", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "textColor", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;Ljava/lang/Integer;)V", "getCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "()Z", "setCancelable", "(Z)V", "getMessage", "()Ljava/lang/String;", "getMessageId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNegativeButtonTitle", "setNegativeButtonTitle", "(Ljava/lang/String;)V", "getNegativeButtonTitleId", "setNegativeButtonTitleId", "(Ljava/lang/Integer;)V", "getNegativeListener", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "getPositiveButtonTitle", "setPositiveButtonTitle", "getPositiveButtonTitleId", "setPositiveButtonTitleId", "getPositiveListener", "setPositiveListener", "getTextColor", "getTitle", "getTitleId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setNegativeButton", Base2ndPWViewData.KEY_CANCEL, "setPositiveButton", "ok", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        private DialogInterface.OnCancelListener cancelListener;
        private boolean isCancelable;
        private final String message;
        private final Integer messageId;
        private String negativeButtonTitle;
        private Integer negativeButtonTitleId;
        private DialogInterface.OnClickListener negativeListener;
        private String positiveButtonTitle;
        private Integer positiveButtonTitleId;
        private DialogInterface.OnClickListener positiveListener;
        private final Integer textColor;
        private final String title;
        private final Integer titleId;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Settings() {
            this(null, null, null, null, null, null, null, null, false, null, null, null, null, 8191, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Settings(String str, Integer num, String str2, Integer num2, String str3, Integer num3, String str4, Integer num4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener, Integer num5) {
            this.title = str;
            this.titleId = num;
            this.message = str2;
            this.messageId = num2;
            this.positiveButtonTitle = str3;
            this.positiveButtonTitleId = num3;
            this.negativeButtonTitle = str4;
            this.negativeButtonTitleId = num4;
            this.isCancelable = z;
            this.positiveListener = onClickListener;
            this.negativeListener = onClickListener2;
            this.cancelListener = onCancelListener;
            this.textColor = num5;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Settings(String str, Integer num, String str2, Integer num2, String str3, Integer num3, String str4, Integer num4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : num4, (i & 256) != 0 ? false : z, (i & 512) != 0 ? null : onClickListener, (i & 1024) != 0 ? null : onClickListener2, (i & 2048) != 0 ? null : onCancelListener, (i & 4096) == 0 ? num5 : null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getTitle() {
            return this.title;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Integer getTitleId() {
            return this.titleId;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getMessage() {
            return this.message;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Integer getMessageId() {
            return this.messageId;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getPositiveButtonTitle() {
            return this.positiveButtonTitle;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPositiveButtonTitle(String str) {
            this.positiveButtonTitle = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Integer getPositiveButtonTitleId() {
            return this.positiveButtonTitleId;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPositiveButtonTitleId(Integer num) {
            this.positiveButtonTitleId = num;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getNegativeButtonTitle() {
            return this.negativeButtonTitle;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setNegativeButtonTitle(String str) {
            this.negativeButtonTitle = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Integer getNegativeButtonTitleId() {
            return this.negativeButtonTitleId;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setNegativeButtonTitleId(Integer num) {
            this.negativeButtonTitleId = num;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isCancelable() {
            return this.isCancelable;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCancelable(boolean z) {
            this.isCancelable = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final DialogInterface.OnClickListener getPositiveListener() {
            return this.positiveListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPositiveListener(DialogInterface.OnClickListener onClickListener) {
            this.positiveListener = onClickListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final DialogInterface.OnClickListener getNegativeListener() {
            return this.negativeListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setNegativeListener(DialogInterface.OnClickListener onClickListener) {
            this.negativeListener = onClickListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final DialogInterface.OnCancelListener getCancelListener() {
            return this.cancelListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.cancelListener = onCancelListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Integer getTextColor() {
            return this.textColor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPositiveButton(String ok, DialogInterface.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(ok, y.֬ڱܱײٮ(-1159122431));
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            this.positiveButtonTitle = ok;
            this.positiveListener = listener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setNegativeButton(String cancel, DialogInterface.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(cancel, y.֬ڱܱײٮ(-1158781631));
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            this.negativeButtonTitle = cancel;
            this.negativeListener = listener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPositiveButton(int ok, DialogInterface.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            this.positiveButtonTitleId = Integer.valueOf(ok);
            this.positiveListener = listener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setNegativeButton(int cancel, DialogInterface.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            this.negativeButtonTitleId = Integer.valueOf(cancel);
            this.negativeListener = listener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCancelable(DialogInterface.OnCancelListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            this.isCancelable = true;
            this.cancelListener = listener;
        }
    }
}
