package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import com.facebook.FacebookCallback;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import java.util.List;

/* loaded from: classes.dex */
public class GamingGroupIntegration extends FacebookDialogBase<Void, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingGroupIntegration.toRequestCode();
    private static final String ERROR_KEY = "error";

    public static class Result {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<Void, Result>.ModeHandler> getOrderedModeHandlers() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GamingGroupIntegration(final Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GamingGroupIntegration(final Fragment fragment) {
        super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GamingGroupIntegration(final androidx.fragment.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void show() {
        showImpl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    public void show(final Void content) {
        showImpl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void showImpl() {
        startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("https://fb.gg/me/community/" + FacebookSdk.getApplicationId())), getRequestCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(final CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback) {
        callbackManager.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.GamingGroupIntegration.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int resultCode, Intent data) {
                if (data != null && data.hasExtra("error")) {
                    callback.onError(((FacebookRequestError) data.getParcelableExtra("error")).getException());
                    return true;
                }
                callback.onSuccess(new Result());
                return true;
            }
        });
    }
}
