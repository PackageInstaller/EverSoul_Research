package com.kakaogame.auth.view;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import androidx.appcompat.C0047R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.C2382R;
import com.kakaogame.KGActivityManager;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.databinding.KakaoGameSdkCoppaBinding;
import com.kakaogame.infodesk.InfodeskData;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatePickerDialog.kt */
@Metadata(m838d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002()B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001aH\u0014J\b\u0010&\u001a\u00020\u001eH\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m839d2 = {"Lcom/kakaogame/auth/view/DatePickerDialog;", "Landroid/app/Dialog;", "Lcom/kakaogame/KGActivityManager$ConfigChangeListener;", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/kakaogame/auth/view/DatePickerDialog$DatePickerListener;", "age", "", "(Landroid/app/Activity;Lcom/kakaogame/auth/view/DatePickerDialog$DatePickerListener;I)V", "title", "", "subTitle", "(Landroid/app/Activity;Lcom/kakaogame/auth/view/DatePickerDialog$DatePickerListener;Ljava/lang/String;Ljava/lang/String;)V", "callbackListener", "(Landroid/app/Activity;Lcom/kakaogame/auth/view/DatePickerDialog$DatePickerListener;)V", "binding", "Lcom/kakaogame/databinding/KakaoGameSdkCoppaBinding;", "date", "getDate", "()Ljava/lang/String;", "dateOnlyView", "", "limitAge", "preOrientation", "dismiss", "", "initView", "loadDate", "savedDate", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "saveDate", "showSelectedDate", "Companion", "DatePickerListener", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DatePickerDialog extends Dialog implements KGActivityManager.ConfigChangeListener {
    private static final String TAG = "DatePickerDialog";
    private KakaoGameSdkCoppaBinding binding;
    private final DatePickerListener callbackListener;
    private boolean dateOnlyView;
    private int limitAge;
    private int preOrientation;
    private String subTitle;
    private String title;

    /* compiled from: DatePickerDialog.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/auth/view/DatePickerDialog$DatePickerListener;", "", "onDatePick", "", "year", "", "month", "day", "onUserCanceled", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface DatePickerListener {
        void onDatePick(int year, int month, int day);

        void onUserCanceled();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DatePickerDialog(Activity activity, DatePickerListener datePickerListener) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        this.callbackListener = datePickerListener;
        this.preOrientation = -1;
        setOwnerActivity(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getDate() {
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding = this.binding;
        String str = y.֬ڱܱײٮ(-1158912015);
        if (kakaoGameSdkCoppaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            kakaoGameSdkCoppaBinding = null;
        }
        int year = kakaoGameSdkCoppaBinding.kakaoGameCoppaDatePicker.getYear();
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding2 = this.binding;
        if (kakaoGameSdkCoppaBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            kakaoGameSdkCoppaBinding2 = null;
        }
        int month = kakaoGameSdkCoppaBinding2.kakaoGameCoppaDatePicker.getMonth() + 1;
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding3 = this.binding;
        if (kakaoGameSdkCoppaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            kakaoGameSdkCoppaBinding3 = null;
        }
        int dayOfMonth = kakaoGameSdkCoppaBinding3.kakaoGameCoppaDatePicker.getDayOfMonth();
        String sb = new StringBuilder().append(year).append('-').append(month).append('-').append(dayOfMonth).toString();
        if (Intrinsics.areEqual(KGSystem.getLanguageCode(), y.٬ݯح׭٩(576716582))) {
            return year + "년 " + month + "월 " + dayOfMonth + (char) 51068;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            Date parse = simpleDateFormat2.parse(sb);
            String format = parse != null ? simpleDateFormat.format(parse) : null;
            if (format == null) {
                format = new StringBuilder().append(month).append('-').append(dayOfMonth).append('-').append(year).toString();
            }
            return format;
        } catch (Exception unused) {
            return new StringBuilder().append(month).append('-').append(dayOfMonth).append('-').append(year).toString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DatePickerDialog(Activity activity, DatePickerListener datePickerListener, int i) {
        this(activity, datePickerListener);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        this.limitAge = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DatePickerDialog(Activity activity, DatePickerListener datePickerListener, String str, String str2) {
        this(activity, datePickerListener);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        this.dateOnlyView = true;
        this.title = str;
        this.subTitle = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393310682), y.ݬֲ֮ܲت(1512384319));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.getAttributes().windowAnimations = R.style.Animation.Dialog;
        setCanceledOnTouchOutside(false);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.auth.view.DatePickerDialog$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreate$lambda$1;
                onCreate$lambda$1 = DatePickerDialog.onCreate$lambda$1(DatePickerDialog.this, dialogInterface, i, keyEvent);
                return onCreate$lambda$1;
            }
        });
        initView();
        DisplayUtil displayUtil = DisplayUtil.INSTANCE;
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        displayUtil.setFullScreenView(ownerActivity, window3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean onCreate$lambda$1(DatePickerDialog this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        DatePickerListener datePickerListener = this$0.callbackListener;
        if (datePickerListener != null) {
            datePickerListener.onUserCanceled();
        }
        this$0.dismiss();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initView() {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1158912503);
        String str2 = y.ٴسسݬߨ(1393310682);
        logger.m699d(str2, str);
        final KakaoGameSdkCoppaBinding inflate = KakaoGameSdkCoppaBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
        this.binding = inflate;
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding = null;
        String str3 = y.֬ڱܱײٮ(-1158912015);
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
            inflate = null;
        }
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        Intrinsics.checkNotNull(infodesk);
        Calendar serverCalendarOnPST = infodesk.getServerCalendarOnPST();
        int i = serverCalendarOnPST.get(1);
        int i2 = serverCalendarOnPST.get(2);
        int i3 = serverCalendarOnPST.get(5);
        inflate.kakaoGameCoppaDatePicker.setMaxDate(CoreManager.INSTANCE.getInstance().currentTimeMillis());
        inflate.kakaoGameCoppaDatePicker.updateDate(i, i2, i3);
        Logger.INSTANCE.m699d(str2, y.ݬֲ֮ܲت(1512382239) + i + y.ٴسسݬߨ(1393308826) + i2 + y.دײܮڳܯ(2051356517) + i3);
        if (this.dateOnlyView) {
            if (!TextUtils.isEmpty(this.title)) {
                inflate.kakaoGameCoppaTitle.setText(this.title);
            }
            if (!TextUtils.isEmpty(this.subTitle)) {
                inflate.kakaoGameCoppaDesc.setText(this.subTitle);
            } else {
                inflate.kakaoGameCoppaDesc.setText(ResourceUtil.getString(getOwnerActivity(), y.ٲٴݴ״ٰ(1782131264)));
            }
            inflate.kakaoGameCoppaButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.DatePickerDialog$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DatePickerDialog.initView$lambda$4$lambda$2(DatePickerDialog.this, inflate, view);
                }
            });
        } else {
            inflate.kakaoGameCoppaDesc.setText(ResourceUtil.getString(getOwnerActivity(), y.ݮڮֲڭܩ(-628620788), Integer.valueOf(this.limitAge)));
            inflate.kakaoGameCoppaButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.DatePickerDialog$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DatePickerDialog.initView$lambda$4$lambda$3(DatePickerDialog.this, view);
                }
            });
        }
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding2 = this.binding;
        if (kakaoGameSdkCoppaBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
        } else {
            kakaoGameSdkCoppaBinding = kakaoGameSdkCoppaBinding2;
        }
        setContentView(kakaoGameSdkCoppaBinding.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initView$lambda$4$lambda$2(DatePickerDialog this$0, KakaoGameSdkCoppaBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (this$0.callbackListener != null) {
            this$0.callbackListener.onDatePick(this_apply.kakaoGameCoppaDatePicker.getYear(), this_apply.kakaoGameCoppaDatePicker.getMonth() + 1, this_apply.kakaoGameCoppaDatePicker.getDayOfMonth());
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initView$lambda$4$lambda$3(DatePickerDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showSelectedDate(this$0.getDate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showSelectedDate(String date) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576713766);
        String str2 = y.ٴسسݬߨ(1393310682);
        logger.m699d(str2, str);
        try {
            AlertDialog create = DialogManager.createAlertDialogBuilder(getOwnerActivity()).setTitle(ResourceUtil.getString(getOwnerActivity(), y.ٲٴݴ״ٰ(1782132656))).setMessage(ResourceUtil.getString(getOwnerActivity(), y.ٲٴݴ״ٰ(1782132448)) + ' ' + date).setPositiveButton(C2382R.string.kakao_game_sdk_yes, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.DatePickerDialog$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DatePickerDialog.showSelectedDate$lambda$6(DatePickerDialog.this, dialogInterface, i);
                }
            }).setNegativeButton(C2382R.string.kakao_game_sdk_no, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.DatePickerDialog$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create();
            create.setCanceledOnTouchOutside(false);
            y.٬خݮ۳ݯ(create);
            Window window = create.getWindow();
            Intrinsics.checkNotNull(window);
            window.getAttributes().windowAnimations = R.style.Animation.Dialog;
            y.٬خݮ۳ݯ(create);
            create.show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showSelectedDate$lambda$6(DatePickerDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.callbackListener != null) {
            KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding = this$0.binding;
            if (kakaoGameSdkCoppaBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                kakaoGameSdkCoppaBinding = null;
            }
            DatePicker datePicker = kakaoGameSdkCoppaBinding.kakaoGameCoppaDatePicker;
            this$0.callbackListener.onDatePick(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        }
        dialogInterface.dismiss();
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393310682), y.ݬֲ֮ܲت(1512384367));
        KGActivityManager.INSTANCE.addConfigChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393310682), y.ݬֲ֮ܲت(1512380623));
        KGActivityManager.INSTANCE.removeConfigChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGActivityManager.ConfigChangeListener
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, y.ݬֲ֮ܲت(1512614831));
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393310682), y.ٲٴݴ״ٰ(1782131848) + newConfig.orientation + y.ݮڮֲڭܩ(-628606940) + this.preOrientation);
        int[] saveDate = saveDate();
        if (this.preOrientation < 0 || newConfig.orientation != this.preOrientation) {
            KakaoGameSdkCoppaBinding inflate = KakaoGameSdkCoppaBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.֬ڱܱײٮ(-1158912015));
                inflate = null;
            }
            setContentView(inflate.getRoot());
            initView();
            loadDate(saveDate);
        }
        this.preOrientation = newConfig.orientation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void loadDate(int[] savedDate) {
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393310682), y.دײܮڳܯ(2051355949) + savedDate);
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding = this.binding;
        if (kakaoGameSdkCoppaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(y.֬ڱܱײٮ(-1158912015));
            kakaoGameSdkCoppaBinding = null;
        }
        kakaoGameSdkCoppaBinding.kakaoGameCoppaDatePicker.updateDate(savedDate[0], savedDate[1], savedDate[2]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int[] saveDate() {
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393310682), y.ٲٴݴ״ٰ(1782130896));
        int[] iArr = new int[3];
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding = this.binding;
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding2 = null;
        String str = y.֬ڱܱײٮ(-1158912015);
        if (kakaoGameSdkCoppaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            kakaoGameSdkCoppaBinding = null;
        }
        iArr[0] = kakaoGameSdkCoppaBinding.kakaoGameCoppaDatePicker.getYear();
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding3 = this.binding;
        if (kakaoGameSdkCoppaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            kakaoGameSdkCoppaBinding3 = null;
        }
        iArr[1] = kakaoGameSdkCoppaBinding3.kakaoGameCoppaDatePicker.getMonth();
        KakaoGameSdkCoppaBinding kakaoGameSdkCoppaBinding4 = this.binding;
        if (kakaoGameSdkCoppaBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            kakaoGameSdkCoppaBinding2 = kakaoGameSdkCoppaBinding4;
        }
        iArr[2] = kakaoGameSdkCoppaBinding2.kakaoGameCoppaDatePicker.getDayOfMonth();
        return iArr;
    }
}
