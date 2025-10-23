package com.facebook.unity;

import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.ContextSwitchDialog;
import com.facebook.gamingservices.model.ContextSwitchContent;

/* loaded from: classes.dex */
public class FBUnitySwitchGamingContextActivity extends BaseActivity {
    private static String TAG = "com.facebook.unity.FBUnitySwitchGamingContextActivity";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(BaseActivity.ACTIVITY_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnSwitchGamingContextComplete");
        String string = bundleExtra.getString(Constants.CALLBACK_ID_KEY);
        Log.e(TAG, "callbackID: " + string);
        if (string != null) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, string);
        }
        String string2 = bundleExtra.getString("gamingContextID");
        ContextSwitchContent.Builder builder = new ContextSwitchContent.Builder();
        builder.setContextID(string2);
        ContextSwitchContent build = builder.build();
        ContextSwitchDialog contextSwitchDialog = new ContextSwitchDialog(this);
        contextSwitchDialog.registerCallback(this.mCallbackManager, new FacebookCallback<ContextSwitchDialog.Result>() { // from class: com.facebook.unity.FBUnitySwitchGamingContextActivity.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onSuccess(ContextSwitchDialog.Result result) {
                unityMessage.put("contextId", result.getContextID());
                unityMessage.send();
                FBUnitySwitchGamingContextActivity.this.finish();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
                FBUnitySwitchGamingContextActivity.this.finish();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                unityMessage.sendError(facebookException.getMessage());
                FBUnitySwitchGamingContextActivity.this.finish();
            }
        });
        contextSwitchDialog.show(build);
    }
}
