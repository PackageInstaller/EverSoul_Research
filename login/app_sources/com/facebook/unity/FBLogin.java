package com.facebook.unity;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class FBLogin {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void loginWithReadPermissions(String str, FBUnityLoginActivity fBUnityLoginActivity) {
        login(str, fBUnityLoginActivity, false, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void loginWithPublishPermissions(String str, FBUnityLoginActivity fBUnityLoginActivity) {
        login(str, fBUnityLoginActivity, true, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void loginForTVWithReadPermissions(String str, FBUnityLoginActivity fBUnityLoginActivity) {
        login(str, fBUnityLoginActivity, false, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void loginForTVWithPublishPermissions(String str, FBUnityLoginActivity fBUnityLoginActivity) {
        login(str, fBUnityLoginActivity, true, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void sendLoginSuccessMessage(AccessToken accessToken, AuthenticationToken authenticationToken, String str) {
        UnityMessage unityMessage = new UnityMessage("OnLoginComplete");
        addLoginParametersToMessage(unityMessage, accessToken, authenticationToken, str);
        unityMessage.send();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void addLoginParametersToMessage(UnityMessage unityMessage, AccessToken accessToken, AuthenticationToken authenticationToken, String str) {
        unityMessage.put("key_hash", C0848FB.getKeyHash());
        unityMessage.put("opened", true);
        unityMessage.put("access_token", accessToken.getToken());
        if (authenticationToken != null) {
            unityMessage.put("auth_token_string", authenticationToken.getToken());
            unityMessage.put("auth_nonce", authenticationToken.getExpectedNonce());
        }
        unityMessage.put("expiration_timestamp", Long.valueOf(accessToken.getExpires().getTime() / 1000).toString());
        unityMessage.put("user_id", accessToken.getUserId());
        unityMessage.put("permissions", TextUtils.join(",", accessToken.getPermissions()));
        unityMessage.put("declined_permissions", TextUtils.join(",", accessToken.getDeclinedPermissions()));
        unityMessage.put("graph_domain", accessToken.getGraphDomain() != null ? accessToken.getGraphDomain() : "facebook");
        if (accessToken.getLastRefresh() != null) {
            unityMessage.put("last_refresh", Long.valueOf(accessToken.getLastRefresh().getTime() / 1000).toString());
        }
        if (str == null || str.isEmpty()) {
            return;
        }
        unityMessage.put(Constants.CALLBACK_ID_KEY, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void login(String str, FBUnityLoginActivity fBUnityLoginActivity, boolean z, boolean z2) {
        LoginManager loginManager;
        if (!FacebookSdk.isInitialized()) {
            Log.w(C0848FB.TAG, "Facebook SDK not initialized. Call init() before calling login()");
            return;
        }
        final UnityMessage unityMessage = new UnityMessage("OnLoginComplete");
        unityMessage.put("key_hash", C0848FB.getKeyHash());
        UnityParams parse = UnityParams.parse(str, "couldn't parse login params: " + str);
        final String str2 = null;
        ArrayList arrayList = parse.hasString("scope").booleanValue() ? new ArrayList(Arrays.asList(parse.getString("scope").split(","))) : null;
        if (parse.has(Constants.CALLBACK_ID_KEY)) {
            str2 = parse.getString(Constants.CALLBACK_ID_KEY);
            unityMessage.put(Constants.CALLBACK_ID_KEY, str2);
        }
        LoginManager.getInstance().registerCallback(fBUnityLoginActivity.getCallbackManager(), new FacebookCallback<LoginResult>() { // from class: com.facebook.unity.FBLogin.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                FBLogin.sendLoginSuccessMessage(loginResult.getAccessToken(), loginResult.getAuthenticationToken(), str2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                Log.w(C0848FB.TAG, "Error occurred, ", facebookException);
                unityMessage.sendError(facebookException.getMessage());
            }
        });
        if (z2) {
            loginManager = DeviceLoginManager.getInstance();
        } else {
            loginManager = LoginManager.getInstance();
        }
        if (z) {
            loginManager.logInWithPublishPermissions(fBUnityLoginActivity, arrayList);
        } else {
            loginManager.logInWithReadPermissions(fBUnityLoginActivity, arrayList);
        }
    }
}
