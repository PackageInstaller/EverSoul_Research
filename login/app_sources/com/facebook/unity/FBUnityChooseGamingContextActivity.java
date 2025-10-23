package com.facebook.unity;

import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.ContextChooseDialog;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.model.ContextChooseContent;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FBUnityChooseGamingContextActivity extends BaseActivity {
    private static String TAG = "com.facebook.unity.FBUnityChooseGamingContextActivity";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(BaseActivity.ACTIVITY_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnChooseGamingContextComplete");
        String string = bundleExtra.getString(Constants.CALLBACK_ID_KEY);
        Log.e(TAG, "callbackID: " + string);
        if (string != null) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, string);
        }
        ContextChooseContent.Builder builder = new ContextChooseContent.Builder();
        Log.v(TAG, "ChooseGamingContext(" + bundleExtra + ")");
        try {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("filters");
            Log.v(TAG, "ChooseGamingContext filters: " + stringArrayList + "");
            String string2 = bundleExtra.getString(SDKConstants.PARAM_CONTEXT_MIN_SIZE);
            Integer valueOf = !string2.isEmpty() ? Integer.valueOf(Integer.parseInt(string2)) : null;
            String string3 = bundleExtra.getString(SDKConstants.PARAM_CONTEXT_MAX_SIZE);
            Integer valueOf2 = string3.isEmpty() ? null : Integer.valueOf(Integer.parseInt(string3));
            ContextChooseContent build = builder.build();
            if (stringArrayList != null) {
                builder.setFilters(stringArrayList);
            }
            if (valueOf != null) {
                builder.setMinSize(valueOf);
            }
            if (valueOf2 != null) {
                builder.setMaxSize(valueOf2);
            }
            ContextChooseDialog contextChooseDialog = new ContextChooseDialog(this);
            contextChooseDialog.registerCallback(this.mCallbackManager, new FacebookCallback<ContextChooseDialog.Result>() { // from class: com.facebook.unity.FBUnityChooseGamingContextActivity.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.FacebookCallback
                public void onSuccess(ContextChooseDialog.Result result) {
                    unityMessage.put("contextId", result.getContextID());
                    unityMessage.send();
                    FBUnityChooseGamingContextActivity.this.finish();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    unityMessage.putCancelled();
                    unityMessage.send();
                    FBUnityChooseGamingContextActivity.this.finish();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException facebookException) {
                    unityMessage.sendError(facebookException.getMessage());
                    FBUnityChooseGamingContextActivity.this.finish();
                }
            });
            contextChooseDialog.show(build);
        } catch (Exception e) {
            unityMessage.sendError(String.format("Invalid params: %s", e.getMessage()));
        }
    }
}
