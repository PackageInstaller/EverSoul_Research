package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Validate;
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GameRequestDialog extends FacebookDialogBase<GameRequestContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();
    private static final String GAME_REQUEST_DIALOG = "apprequests";
    private FacebookCallback mCallback;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean canShow() {
        return true;
    }

    public static final class Result {
        String requestId;

        /* renamed from: to */
        List<String> f181to;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Result(Bundle results) {
            this.requestId = results.getString("request");
            this.f181to = new ArrayList();
            while (results.containsKey(String.format(ShareConstants.WEB_DIALOG_RESULT_PARAM_TO_ARRAY_MEMBER, Integer.valueOf(this.f181to.size())))) {
                List<String> list = this.f181to;
                list.add(results.getString(String.format(ShareConstants.WEB_DIALOG_RESULT_PARAM_TO_ARRAY_MEMBER, Integer.valueOf(list.size()))));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Result(GraphResponse response) {
            try {
                JSONObject jSONObject = response.getJSONObject();
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                jSONObject = optJSONObject != null ? optJSONObject : jSONObject;
                this.requestId = jSONObject.getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                this.f181to = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("to");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f181to.add(jSONArray.getString(i));
                }
            } catch (JSONException unused) {
                this.requestId = null;
                this.f181to = new ArrayList();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getRequestId() {
            return this.requestId;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<String> getRequestRecipients() {
            return this.f181to;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void show(final Activity activity, final GameRequestContent gameRequestContent) {
        new GameRequestDialog(activity).show(gameRequestContent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void show(final Fragment fragment, final GameRequestContent gameRequestContent) {
        show(new FragmentWrapper(fragment), gameRequestContent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void show(final android.app.Fragment fragment, final GameRequestContent gameRequestContent) {
        show(new FragmentWrapper(fragment), gameRequestContent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void show(final FragmentWrapper fragmentWrapper, final GameRequestContent gameRequestContent) {
        new GameRequestDialog(fragmentWrapper).show(gameRequestContent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GameRequestDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GameRequestDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GameRequestDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GameRequestDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(final CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback) {
        this.mCallback = callback;
        final ResultProcessor resultProcessor = callback == null ? null : new ResultProcessor(callback) { // from class: com.facebook.gamingservices.GameRequestDialog.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle results) {
                if (results != null) {
                    callback.onSuccess(new Result(results));
                } else {
                    onCancel(appCall);
                }
            }
        };
        callbackManager.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.GameRequestDialog.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int resultCode, Intent data) {
                return ShareInternalUtility.handleActivityResult(GameRequestDialog.this.getRequestCode(), resultCode, data, resultProcessor);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<GameRequestContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler());
        arrayList.add(new ChromeCustomTabHandler());
        arrayList.add(new WebHandler());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(final GameRequestContent content, final Object mode) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(content, mode);
        } else {
            super.showImpl((GameRequestDialog) content, mode);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void showForCloud(final GameRequestContent content, final Object mode) {
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open GameRequestDialog with an invalid access token");
        }
        DaemonRequest.Callback callback = new DaemonRequest.Callback() { // from class: com.facebook.gamingservices.GameRequestDialog.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
            public void onCompleted(GraphResponse response) {
                if (GameRequestDialog.this.mCallback != null) {
                    if (response.getError() != null) {
                        GameRequestDialog.this.mCallback.onError(new FacebookException(response.getError().getErrorMessage()));
                    } else {
                        GameRequestDialog.this.mCallback.onSuccess(new Result(response));
                    }
                }
            }
        };
        String applicationId = currentAccessToken.getApplicationId();
        String name = content.getActionType() != null ? content.getActionType().name() : null;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put(SDKConstants.PARAM_APP_ID, applicationId);
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, name);
            jSONObject.put("message", content.getMessage());
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_CTA, content.getCta());
            jSONObject.put("title", content.getTitle());
            jSONObject.put("data", content.getData());
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, content.getFilters());
            if (content.getRecipients() != null) {
                Iterator<String> it = content.getRecipients().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            jSONObject.put("to", jSONArray);
            DaemonRequest.executeAsync(activityContext, jSONObject, callback, SDKMessageEnum.OPEN_GAME_REQUESTS_DIALOG);
        } catch (JSONException unused) {
            FacebookCallback facebookCallback = this.mCallback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Couldn't prepare Game Request Dialog"));
            }
        }
    }

    private class ChromeCustomTabHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ChromeCustomTabHandler() {
            super(GameRequestDialog.this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(final GameRequestContent content, boolean isBestEffort) {
            return CustomTabUtils.getChromePackage() != null && Validate.hasCustomTabRedirectActivity(GameRequestDialog.this.getActivityContext(), CustomTabUtils.getDefaultRedirectURI());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final GameRequestContent content) {
            GameRequestValidation.validate(content);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            Bundle create = WebDialogParameters.create(content);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                create.putString("app_id", currentAccessToken.getApplicationId());
            } else {
                create.putString("app_id", FacebookSdk.getApplicationId());
            }
            create.putString("redirect_uri", CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(createBaseAppCall, GameRequestDialog.GAME_REQUEST_DIALOG, create);
            return createBaseAppCall;
        }
    }

    private class WebHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(final GameRequestContent content, boolean isBestEffort) {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private WebHandler() {
            super(GameRequestDialog.this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final GameRequestContent content) {
            GameRequestValidation.validate(content);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, GameRequestDialog.GAME_REQUEST_DIALOG, WebDialogParameters.create(content));
            return createBaseAppCall;
        }
    }

    private class FacebookAppHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FacebookAppHandler() {
            super(GameRequestDialog.this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(final GameRequestContent content, boolean isBestEffort) {
            PackageManager packageManager = GameRequestDialog.this.getActivityContext().getPackageManager();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            boolean z = intent.resolveActivity(packageManager) != null;
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            return z && (currentAccessToken != null && currentAccessToken.getGraphDomain() != null && FacebookSdk.GAMING.equals(currentAccessToken.getGraphDomain()));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final GameRequestContent content) {
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "GAME_REQUESTS");
            if (currentAccessToken != null) {
                bundle.putString("app_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("app_id", FacebookSdk.getApplicationId());
            }
            bundle.putString(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, content.getActionType() != null ? content.getActionType().name() : null);
            bundle.putString("message", content.getMessage());
            bundle.putString("title", content.getTitle());
            bundle.putString("data", content.getData());
            bundle.putString(SDKConstants.PARAM_GAME_REQUESTS_CTA, content.getCta());
            content.getRecipients();
            JSONArray jSONArray = new JSONArray();
            if (content.getRecipients() != null) {
                Iterator<String> it = content.getRecipients().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            bundle.putString("to", jSONArray.toString());
            NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            createBaseAppCall.setRequestIntent(intent);
            return createBaseAppCall;
        }
    }
}
