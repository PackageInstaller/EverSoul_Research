package com.facebook.unity;

import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.ContextCreateDialog;
import com.facebook.gamingservices.model.ContextCreateContent;

/* loaded from: classes.dex */
public class FBUnityCreateGamingContextActivity extends BaseActivity {
    private static String TAG = "com.facebook.unity.FBUnityCreateGamingContextActivity";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(BaseActivity.ACTIVITY_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnCreateGamingContextComplete");
        String string = bundleExtra.getString(Constants.CALLBACK_ID_KEY);
        Log.e(TAG, "callbackID: " + string);
        if (string != null) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, string);
        }
        String string2 = bundleExtra.getString("playerID");
        ContextCreateContent.Builder builder = new ContextCreateContent.Builder();
        builder.setSuggestedPlayerID(string2);
        ContextCreateContent build = builder.build();
        ContextCreateDialog contextCreateDialog = new ContextCreateDialog(this);
        contextCreateDialog.registerCallback(this.mCallbackManager, new FacebookCallback<ContextCreateDialog.Result>() { // from class: com.facebook.unity.FBUnityCreateGamingContextActivity.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onSuccess(ContextCreateDialog.Result result) {
                unityMessage.put("contextId", result.getContextID());
                unityMessage.send();
                FBUnityCreateGamingContextActivity.this.finish();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
                FBUnityCreateGamingContextActivity.this.finish();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                unityMessage.sendError(facebookException.getMessage());
                FBUnityCreateGamingContextActivity.this.finish();
            }
        });
        contextCreateDialog.show(build);
    }
}
