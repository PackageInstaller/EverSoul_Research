package com.kakaogame.auth.view;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kakaogame.C2382R;
import com.kakaogame.KGActivityManager;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.Logger;
import com.kakaogame.auth.view.LoginUIManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.databinding.KakaoGameSdkLoginBinding;
import com.kakaogame.databinding.KakaoGameSdkLoginItemBinding;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginIDPListDialog.kt */
@Metadata(m838d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0002\u0010\u0010J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u000fH\u0014J\b\u0010!\u001a\u00020\u000fH\u0002J \u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m839d2 = {"Lcom/kakaogame/auth/view/LoginIDPListDialog;", "Landroid/app/AlertDialog;", "Lcom/kakaogame/KGActivityManager$ConfigChangeListener;", "activity", "Landroid/app/Activity;", "idpCodes", "", "", "requestType", "Lcom/kakaogame/auth/view/LoginUIManager$RequestType;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "idpCode", "", "(Landroid/app/Activity;Ljava/util/List;Lcom/kakaogame/auth/view/LoginUIManager$RequestType;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/kakaogame/databinding/KakaoGameSdkLoginBinding;", "preOrientation", "", "calculateViewSize", "createLoginItem", "Landroid/view/View;", "dismiss", "initView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setDialogDim", "setIdpItemView", "idpList1View", "Landroid/view/ViewGroup;", "idpList2View", "idpListView", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LoginIDPListDialog extends AlertDialog implements KGActivityManager.ConfigChangeListener {
    private static final String TAG = "LoginIDPListDialog";
    private KakaoGameSdkLoginBinding binding;
    private final Function1<String, Unit> callback;
    private final List<String> idpCodes;
    private int preOrientation;
    private final LoginUIManager.RequestType requestType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LoginIDPListDialog(Activity activity, List<String> list, LoginUIManager.RequestType requestType, Function1<? super String, Unit> function1) {
        super(activity, R.style.Theme.DeviceDefault.Dialog);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(requestType, y.ۮڭڭܬި(862479371));
        Intrinsics.checkNotNullParameter(function1, y.֬ڱܱײٮ(-1159472767));
        this.idpCodes = list;
        this.requestType = requestType;
        this.callback = function1;
        this.preOrientation = -1;
        setOwnerActivity(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.ݬֲ֮ܲت(1512384319));
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        DisplayUtil.checkSystemFontSize(ownerActivity);
        setCanceledOnTouchOutside(false);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.auth.view.LoginIDPListDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreate$lambda$0;
                onCreate$lambda$0 = LoginIDPListDialog.onCreate$lambda$0(LoginIDPListDialog.this, dialogInterface, i, keyEvent);
                return onCreate$lambda$0;
            }
        });
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        KakaoGameSdkLoginBinding inflate = KakaoGameSdkLoginBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
        this.binding = inflate;
        initView();
        calculateViewSize();
        KakaoGameSdkLoginBinding kakaoGameSdkLoginBinding = this.binding;
        if (kakaoGameSdkLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kakaoGameSdkLoginBinding = null;
        }
        setContentView(kakaoGameSdkLoginBinding.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean onCreate$lambda$0(LoginIDPListDialog this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        this$0.callback.invoke(null);
        this$0.dismiss();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initView() {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.֬ڱܱײٮ(-1158912503));
        KakaoGameSdkLoginBinding kakaoGameSdkLoginBinding = this.binding;
        if (kakaoGameSdkLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(y.֬ڱܱײٮ(-1158912015));
            kakaoGameSdkLoginBinding = null;
        }
        String str = y.ݮڮֲڭܩ(-628605804);
        if (new File(str).exists()) {
            kakaoGameSdkLoginBinding.kakaoGameLoginTitle.setTypeface(Typeface.createFromFile(str));
            kakaoGameSdkLoginBinding.kakaoGameLoginTitle.setIncludeFontPadding(false);
        }
        if (this.requestType == LoginUIManager.RequestType.CONNECT) {
            kakaoGameSdkLoginBinding.kakaoGameLoginTitle.setText(C2382R.string.kakao_game_sdk_connect_title);
        } else {
            kakaoGameSdkLoginBinding.kakaoGameLoginTitle.setText(CoreManager.INSTANCE.getResourceString(y.دײܮڳܯ(2051345293)));
        }
        if (this.idpCodes == null) {
            this.callback.invoke(null);
            dismiss();
            return;
        }
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        boolean isScreenPortrait = DisplayUtil.isScreenPortrait(ownerActivity);
        String str2 = y.ݮڮֲڭܩ(-628605300);
        if (isScreenPortrait) {
            LinearLayout linearLayout = kakaoGameSdkLoginBinding.kakaoGameLoginIdpList;
            Intrinsics.checkNotNullExpressionValue(linearLayout, str2);
            setIdpItemView(linearLayout, this.requestType);
        } else if (this.idpCodes.size() > 3) {
            kakaoGameSdkLoginBinding.kakaoGameLoginIdpList.setVisibility(8);
            LinearLayout linearLayout2 = kakaoGameSdkLoginBinding.kakaoGameLoginIdpList1;
            String str3 = y.ݮڮֲڭܩ(-628604988);
            Intrinsics.checkNotNull(linearLayout2, str3);
            LinearLayout linearLayout3 = kakaoGameSdkLoginBinding.kakaoGameLoginIdpList2;
            Intrinsics.checkNotNull(linearLayout3, str3);
            setIdpItemView(linearLayout2, linearLayout3, this.requestType);
        } else {
            LinearLayout linearLayout4 = kakaoGameSdkLoginBinding.kakaoGameLoginIdpListMulti;
            Intrinsics.checkNotNull(linearLayout4);
            linearLayout4.setVisibility(8);
            LinearLayout linearLayout5 = kakaoGameSdkLoginBinding.kakaoGameLoginIdpList;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, str2);
            setIdpItemView(linearLayout5, this.requestType);
        }
        kakaoGameSdkLoginBinding.kakaoGameLoginClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.LoginIDPListDialog$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginIDPListDialog.initView$lambda$2$lambda$1(LoginIDPListDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initView$lambda$2$lambda$1(LoginIDPListDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callback.invoke(null);
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setIdpItemView(ViewGroup idpList1View, ViewGroup idpList2View, LoginUIManager.RequestType requestType) {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.دײܮڳܯ(2051344285));
        List<String> list = this.idpCodes;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            final String str = this.idpCodes.get(i);
            View createLoginItem = createLoginItem(str, requestType);
            ViewGroup viewGroup = i % 2 == 0 ? idpList1View : idpList2View;
            viewGroup.addView(createLoginItem);
            createLoginItem.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.LoginIDPListDialog$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginIDPListDialog.setIdpItemView$lambda$3(LoginIDPListDialog.this, str, view);
                }
            });
            viewGroup.addView(ResourceUtil.getLayout(getOwnerActivity(), C2382R.layout.kakao_game_sdk_login_item_space));
        }
        if (this.idpCodes.size() % 2 == 1) {
            idpList2View.addView(ResourceUtil.getLayout(getOwnerActivity(), C2382R.layout.kakao_game_sdk_login_item));
            idpList2View.addView(ResourceUtil.getLayout(getOwnerActivity(), C2382R.layout.kakao_game_sdk_login_item_space));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void setIdpItemView$lambda$3(LoginIDPListDialog this$0, String idpCode, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(idpCode, "$idpCode");
        this$0.callback.invoke(idpCode);
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setIdpItemView(ViewGroup idpListView, LoginUIManager.RequestType requestType) {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.دײܮڳܯ(2051344285));
        List<String> list = this.idpCodes;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            final String str = this.idpCodes.get(i);
            View createLoginItem = createLoginItem(str, requestType);
            idpListView.addView(createLoginItem);
            createLoginItem.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.LoginIDPListDialog$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginIDPListDialog.setIdpItemView$lambda$4(LoginIDPListDialog.this, str, view);
                }
            });
            idpListView.addView(ResourceUtil.getLayout(getOwnerActivity(), C2382R.layout.kakao_game_sdk_login_item_space));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void setIdpItemView$lambda$4(LoginIDPListDialog this$0, String idpCode, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(idpCode, "$idpCode");
        this$0.callback.invoke(idpCode);
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final View createLoginItem(String idpCode, LoginUIManager.RequestType requestType) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.ݬֲ֮ܲت(1512383719) + idpCode + y.ݬֲ֮ܲت(1513068719) + requestType);
        KakaoGameSdkLoginItemBinding inflate = KakaoGameSdkLoginItemBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
        String string8 = ResourceUtil.getString(getOwnerActivity(), y.٬ݯح׭٩(576703534) + idpCode);
        String str = y.ݮڮֲڭܩ(-628605804);
        if (new File(str).exists()) {
            inflate.kakaoGameLoginIdpItemName.setTypeface(Typeface.createFromFile(str));
            inflate.kakaoGameLoginIdpItemName.setIncludeFontPadding(false);
        }
        if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Kakao.getCode())) {
            inflate.kakaoGameLoginIdpItem.setBackgroundResource(C2382R.drawable.zinny_sdk_popup_item_yellow);
            inflate.kakaoGameLoginIdpItemIcon.setImageResource(C2382R.drawable.login_ico_talk_black);
            TextView textView = inflate.kakaoGameLoginIdpItemName;
            if (requestType == LoginUIManager.RequestType.CONNECT) {
                string7 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_connect_idp, string8);
            } else {
                string7 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_login_idp_kakao);
            }
            textView.setText(string7);
        } else if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Facebook.getCode())) {
            inflate.kakaoGameLoginIdpItem.setBackgroundResource(C2382R.drawable.zinny_sdk_popup_item_white);
            inflate.kakaoGameLoginIdpItemIcon.setImageResource(C2382R.drawable.login_ico_fb);
            TextView textView2 = inflate.kakaoGameLoginIdpItemName;
            if (requestType == LoginUIManager.RequestType.CONNECT) {
                string6 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_connect_idp, string8);
            } else {
                string6 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_login_idp, string8);
            }
            textView2.setText(string6);
        } else if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Google.getCode())) {
            inflate.kakaoGameLoginIdpItem.setBackgroundResource(C2382R.drawable.zinny_sdk_popup_item_white);
            inflate.kakaoGameLoginIdpItemIcon.setImageResource(C2382R.drawable.login_ico_google);
            TextView textView3 = inflate.kakaoGameLoginIdpItemName;
            if (requestType == LoginUIManager.RequestType.CONNECT) {
                string5 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_connect_idp, string8);
            } else {
                string5 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_login_idp, string8);
            }
            textView3.setText(string5);
        } else if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.SigninWithApple.getCode())) {
            inflate.kakaoGameLoginIdpItem.setBackgroundResource(C2382R.drawable.zinny_sdk_popup_item_white);
            inflate.kakaoGameLoginIdpItemIcon.setImageResource(C2382R.drawable.login_ico_siwa);
            TextView textView4 = inflate.kakaoGameLoginIdpItemName;
            if (requestType == LoginUIManager.RequestType.CONNECT) {
                string4 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_connect_idp, string8);
            } else {
                string4 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_login_idp_siwa);
            }
            textView4.setText(string4);
        } else if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Gamania.getCode())) {
            inflate.kakaoGameLoginIdpItem.setBackgroundResource(C2382R.drawable.zinny_sdk_popup_item_white);
            inflate.kakaoGameLoginIdpItemIcon.setImageResource(C2382R.drawable.login_ico_guest2);
            TextView textView5 = inflate.kakaoGameLoginIdpItemName;
            if (requestType == LoginUIManager.RequestType.CONNECT) {
                string3 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_connect_idp, string8);
            } else {
                string3 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_login_idp, string8);
            }
            textView5.setText(string3);
        } else if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Twitter.getCode())) {
            inflate.kakaoGameLoginIdpItem.setBackgroundResource(C2382R.drawable.zinny_sdk_popup_item_white);
            inflate.kakaoGameLoginIdpItemIcon.setImageResource(C2382R.drawable.login_ico_twitter);
            TextView textView6 = inflate.kakaoGameLoginIdpItemName;
            if (requestType == LoginUIManager.RequestType.CONNECT) {
                string2 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_connect_idp, string8);
            } else {
                string2 = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_login_idp_twitter);
            }
            textView6.setText(string2);
        } else if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Guest.getCode())) {
            inflate.kakaoGameLoginIdpItem.setBackgroundResource(C2382R.drawable.zinny_sdk_popup_item_grey);
            inflate.kakaoGameLoginIdpItemIcon.setImageResource(C2382R.drawable.login_ico_guest2);
            TextView textView7 = inflate.kakaoGameLoginIdpItemName;
            if (requestType == LoginUIManager.RequestType.CONNECT) {
                string = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_connect_idp, string8);
            } else {
                string = ResourceUtil.getString(getOwnerActivity(), C2382R.string.kakao_game_sdk_login_idp_guest);
            }
            textView7.setText(string);
        }
        if (inflate.kakaoGameLoginIdpItem.getParent() != null) {
            ViewParent parent = inflate.kakaoGameLoginIdpItem.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(inflate.kakaoGameLoginIdpItem);
        }
        RelativeLayout kakaoGameLoginIdpItem = inflate.kakaoGameLoginIdpItem;
        Intrinsics.checkNotNullExpressionValue(kakaoGameLoginIdpItem, "kakaoGameLoginIdpItem");
        return kakaoGameLoginIdpItem;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void calculateViewSize() {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.ݮڮֲڭܩ(-628606444));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, y.ٴسسݬߨ(1393299074));
        WindowManager.LayoutParams layoutParams = attributes;
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        ((ViewGroup.LayoutParams) layoutParams).width = DisplayUtil.getDisplayWidth(ownerActivity);
        Activity ownerActivity2 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity2);
        ((ViewGroup.LayoutParams) layoutParams).height = DisplayUtil.getDisplayHeight(ownerActivity2);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setDialogDim() {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.ٲٴݴ״ٰ(1782127208));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.88f;
        attributes.flags |= 2;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.ݬֲ֮ܲت(1512384367));
        setDialogDim();
        KGActivityManager.INSTANCE.addConfigChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.ݬֲ֮ܲت(1512380623));
        KGActivityManager.INSTANCE.removeConfigChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGActivityManager.ConfigChangeListener
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, y.ݬֲ֮ܲت(1512614831));
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862479507), y.ٲٴݴ״ٰ(1782131848) + newConfig.orientation + y.ݮڮֲڭܩ(-628606940) + this.preOrientation);
        if (this.preOrientation < 0 || newConfig.orientation != this.preOrientation) {
            KakaoGameSdkLoginBinding inflate = KakaoGameSdkLoginBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.֬ڱܱײٮ(-1158912015));
                inflate = null;
            }
            setContentView(inflate.getRoot());
            initView();
            calculateViewSize();
        }
        this.preOrientation = newConfig.orientation;
    }
}
