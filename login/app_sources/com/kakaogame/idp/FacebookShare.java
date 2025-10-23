package com.kakaogame.idp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.util.MutexLock;
import com.liapp.y;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FacebookShare.kt */
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J*\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J*\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J2\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J8\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b0 2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J8\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b0 2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m839d2 = {"Lcom/kakaogame/idp/FacebookShare;", "", "()V", "TAG", "", "TYPE_IMAGE", "", "TYPE_LINK", "callbackManager", "Lcom/facebook/CallbackManager;", "autoLogin", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "getImageFileFromPath", "Landroid/graphics/Bitmap;", Base2ndPWViewData.KEY_PATH, FirebaseAnalytics.Event.LOGIN, "activity", "Landroid/app/Activity;", "shareImage", "imagePath", "hashTag", "shareLink", "link", "showShareDialog", "type", "content", "showShareImageDialog", "", "shareDialog", "Lcom/facebook/share/widget/ShareDialog;", "shareLock", "Lcom/kakaogame/util/MutexLock;", "showShareLinkialog", "idp_facebook_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class FacebookShare {
    private static final int TYPE_LINK = 0;
    public static final FacebookShare INSTANCE = new FacebookShare();
    private static final String TAG = y.ٲٴݴ״ٰ(1782290904);
    private static final int TYPE_IMAGE = 1;
    private static final CallbackManager callbackManager = CallbackManager.Factory.create();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FacebookShare() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> shareLink(Activity activity, String link, String hashTag) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(link, y.ݮڮֲڭܩ(-628442580));
        Intrinsics.checkNotNullParameter(hashTag, y.دײܮڳܯ(2051506885));
        Logger logger = Logger.INSTANCE;
        String str = TAG;
        logger.m699d(str, y.ۮڭڭܬި(862644331));
        try {
            FacebookSdk.sdkInitialize(activity);
            if (!ShareDialog.INSTANCE.canShow(ShareLinkContent.class)) {
                Logger.INSTANCE.m699d(str, "ShareDialog.canShow(ShareLinkContent.class) : FALSE");
                return KGResult.INSTANCE.getResult(KGResult.KGResultCode.FACEBOOK_NOT_INSTALLED);
            }
            KGResult<Void> autoLogin = AccessToken.INSTANCE.getCurrentAccessToken() != null ? INSTANCE.autoLogin() : null;
            if (autoLogin == null || autoLogin.isNotSuccess()) {
                autoLogin = INSTANCE.login(activity);
            }
            return autoLogin.isNotSuccess() ? autoLogin : INSTANCE.showShareDialog(activity, TYPE_LINK, link, hashTag);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> shareImage(Activity activity, String imagePath, String hashTag) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(imagePath, y.ۮڭڭܬި(862644587));
        Intrinsics.checkNotNullParameter(hashTag, y.دײܮڳܯ(2051506885));
        Logger logger = Logger.INSTANCE;
        String str = TAG;
        logger.m699d(str, y.ݮڮֲڭܩ(-628443988));
        try {
            FacebookSdk.sdkInitialize(activity);
            if (!ShareDialog.INSTANCE.canShow(SharePhotoContent.class)) {
                Logger.INSTANCE.m699d(str, "ShareDialog.canShow(SharePhotoContent.class) : FALSE");
                return KGResult.INSTANCE.getResult(KGResult.KGResultCode.FACEBOOK_NOT_INSTALLED);
            }
            KGResult<Void> autoLogin = AccessToken.INSTANCE.getCurrentAccessToken() != null ? INSTANCE.autoLogin() : null;
            if (autoLogin == null || autoLogin.isNotSuccess()) {
                autoLogin = INSTANCE.login(activity);
            }
            return autoLogin.isNotSuccess() ? autoLogin : INSTANCE.showShareDialog(activity, TYPE_IMAGE, imagePath, hashTag);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> login(Activity activity) {
        String str = y.ۮڭڭܬި(862511891);
        Logger logger = Logger.INSTANCE;
        String str2 = TAG;
        logger.m699d(str2, y.֬ڱܱײٮ(-1159504239));
        try {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            LoginManager.INSTANCE.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() { // from class: com.kakaogame.idp.FacebookShare$login$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.FacebookCallback
                public void onSuccess(LoginResult loginResult) {
                    String str3;
                    Intrinsics.checkNotNullParameter(loginResult, y.ݮڮֲڭܩ(-628575484));
                    Logger logger2 = Logger.INSTANCE;
                    str3 = FacebookShare.TAG;
                    logger2.m699d(str3, y.ݮڮֲڭܩ(-628441284) + loginResult);
                    createLock.setContent(KGResult.INSTANCE.getSuccessResult(loginResult));
                    createLock.unlock();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.FacebookCallback
                public void onCancel() {
                    String str3;
                    Logger logger2 = Logger.INSTANCE;
                    str3 = FacebookShare.TAG;
                    logger2.m699d(str3, y.دײܮڳܯ(2051508405));
                    createLock.setContent(KGResult.INSTANCE.getResult(9001));
                    createLock.unlock();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.FacebookCallback
                public void onError(FacebookException exception) {
                    String str3;
                    Intrinsics.checkNotNullParameter(exception, y.ۮڭڭܬި(862642723));
                    Logger logger2 = Logger.INSTANCE;
                    str3 = FacebookShare.TAG;
                    logger2.m701e(str3, y.ۮڭڭܬި(862342763) + exception);
                    KGResult.Companion companion = KGResult.INSTANCE;
                    String facebookException = exception.toString();
                    if (facebookException == null) {
                        facebookException = "";
                    }
                    createLock.setContent(companion.getResult(4010, facebookException));
                    createLock.unlock();
                }
            });
            long start$default = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.idp.FacebookShare$login$eventListener$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onDestroy() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityStart(Activity activity2) {
                    String str3;
                    Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("public_profile");
                        arrayList.add("email");
                        LoginManager.INSTANCE.getInstance().logInWithReadPermissions(activity2, arrayList);
                    } catch (Exception e) {
                        Logger logger2 = Logger.INSTANCE;
                        str3 = FacebookShare.TAG;
                        logger2.m701e(str3, y.ۮڭڭܬި(862342763) + e);
                        createLock.setContent(KGResult.INSTANCE.getResult(4010, e.toString()));
                        createLock.unlock();
                    }
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityResult(int requestCode, int resultCode, Intent data) {
                    String str3;
                    String str4;
                    CallbackManager callbackManager2;
                    Logger logger2 = Logger.INSTANCE;
                    str3 = FacebookShare.TAG;
                    StringBuilder append = new StringBuilder(y.٬ݯح׭٩(575803430)).append(requestCode);
                    String str5 = y.ݮڮֲڭܩ(-628756788);
                    logger2.m699d(str3, append.append(str5).append(resultCode).append(str5).append(data).toString());
                    try {
                        callbackManager2 = FacebookShare.callbackManager;
                        callbackManager2.onActivityResult(requestCode, resultCode, data);
                    } catch (Exception e) {
                        Logger logger3 = Logger.INSTANCE;
                        str4 = FacebookShare.TAG;
                        logger3.m702e(str4, e.toString(), e);
                    }
                }
            }, null, 4, null);
            MutexLock.lock$default(createLock, 0L, 1, null);
            AuthActivityManager.INSTANCE.getInstance().finishActivity(start$default);
            KGResult kGResult = (KGResult) createLock.getContent();
            Logger.INSTANCE.m699d(str2, str + kGResult);
            if (kGResult == null) {
                return KGResult.INSTANCE.getResult(9001, "activity is destroyed");
            }
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> autoLogin() {
        Logger.INSTANCE.m699d(TAG, y.ݮڮֲڭܩ(-628444396));
        try {
            if (AccessToken.INSTANCE.getCurrentAccessToken() == null) {
                return KGResult.INSTANCE.getResult(4010, "current access token is null");
            }
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            AccessToken.INSTANCE.refreshCurrentAccessTokenAsync(new AccessToken.AccessTokenRefreshCallback() { // from class: com.kakaogame.idp.FacebookShare$autoLogin$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
                public void OnTokenRefreshed(AccessToken accessToken) {
                    String str;
                    Logger logger = Logger.INSTANCE;
                    str = FacebookShare.TAG;
                    logger.m699d(str, y.٬ݯح׭٩(576540198) + accessToken);
                    createLock.setContent(true);
                    createLock.unlock();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
                public void OnTokenRefreshFailed(FacebookException exception) {
                    String str;
                    Logger logger = Logger.INSTANCE;
                    str = FacebookShare.TAG;
                    logger.m699d(str, y.֬ڱܱײٮ(-1158753247));
                    createLock.setContent(false);
                    createLock.unlock();
                }
            });
            createLock.lock(30000L);
            Object content = createLock.getContent();
            Intrinsics.checkNotNull(content);
            if (!((Boolean) content).booleanValue()) {
                return KGResult.INSTANCE.getResult(4010, "refresh AccessToken Failure.");
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showShareLinkialog(ShareDialog shareDialog, MutexLock<KGResult<Void>> shareLock, String link, String hashTag) {
        if (ShareDialog.INSTANCE.canShow(ShareLinkContent.class)) {
            Logger.INSTANCE.m699d(TAG, y.ٲٴݴ״ٰ(1782291648));
            ShareLinkContent.Builder contentUrl = new ShareLinkContent.Builder().setContentUrl(Uri.parse(link));
            String str = hashTag;
            if (!TextUtils.isEmpty(str)) {
                String str2 = y.دײܮڳܯ(2051964157);
                if (!StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null)) {
                    hashTag = str2 + hashTag;
                }
                contentUrl.setShareHashtag(new ShareHashtag.Builder().setHashtag(hashTag).build());
            }
            shareDialog.show(contentUrl.build());
            return;
        }
        Logger.INSTANCE.m699d(TAG, "ShareDialog.canShow(ShareLinkContent.class) : FALSE");
        shareLock.setContent(KGResult.INSTANCE.getResult(KGResult.KGResultCode.FACEBOOK_NOT_INSTALLED));
        shareLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Bitmap getImageFileFromPath(String path) {
        Bitmap decodeFile = BitmapFactory.decodeFile(path);
        if (decodeFile == null) {
            Logger.INSTANCE.m701e(TAG, y.ٴسسݬߨ(1393461186));
        }
        return decodeFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showShareImageDialog(ShareDialog shareDialog, MutexLock<KGResult<Void>> shareLock, String imagePath, String hashTag) {
        if (ShareDialog.INSTANCE.canShow(SharePhotoContent.class)) {
            Logger.INSTANCE.m699d(TAG, y.ٴسسݬߨ(1393459826));
            SharePhotoContent.Builder builder = new SharePhotoContent.Builder();
            Bitmap imageFileFromPath = getImageFileFromPath(imagePath);
            if (imageFileFromPath == null) {
                shareLock.setContent(KGResult.INSTANCE.getResult(4000));
                shareLock.unlock();
                return;
            }
            SharePhoto build = new SharePhoto.Builder().setBitmap(imageFileFromPath).build();
            String str = hashTag;
            if (!TextUtils.isEmpty(str)) {
                String str2 = y.دײܮڳܯ(2051964157);
                if (!StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null)) {
                    hashTag = str2 + hashTag;
                }
                builder.setShareHashtag(new ShareHashtag.Builder().setHashtag(hashTag).build());
            }
            shareDialog.show(builder.addPhoto(build).build());
            return;
        }
        Logger.INSTANCE.m699d(TAG, "ShareDialog.canShow(SharePhotoContent.class) : FALSE");
        shareLock.setContent(KGResult.INSTANCE.getResult(KGResult.KGResultCode.FACEBOOK_NOT_INSTALLED));
        shareLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showShareDialog(Activity activity, final int type, final String content, final String hashTag) {
        String str = y.ݮڮֲڭܩ(-628443676);
        try {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            KGAuthActivity.KGActivityEventListener kGActivityEventListener = new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.idp.FacebookShare$showShareDialog$eventListener$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onDestroy() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityStart(Activity activity2) {
                    String str2;
                    CallbackManager callbackManager2;
                    int i;
                    Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                    try {
                        ShareDialog shareDialog = new ShareDialog(activity2);
                        callbackManager2 = FacebookShare.callbackManager;
                        final MutexLock<KGResult<Void>> mutexLock = createLock;
                        shareDialog.registerCallback(callbackManager2, new FacebookCallback<Sharer.Result>() { // from class: com.kakaogame.idp.FacebookShare$showShareDialog$eventListener$1$onActivityStart$1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // com.facebook.FacebookCallback
                            public void onSuccess(Sharer.Result result) {
                                String str3;
                                Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
                                String postId = result.getPostId();
                                Logger logger = Logger.INSTANCE;
                                str3 = FacebookShare.TAG;
                                logger.m699d(str3, y.ٲٴݴ״ٰ(1782291432) + postId);
                                mutexLock.setContent(KGResult.INSTANCE.getSuccessResult());
                                mutexLock.unlock();
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // com.facebook.FacebookCallback
                            public void onCancel() {
                                String str3;
                                Logger logger = Logger.INSTANCE;
                                str3 = FacebookShare.TAG;
                                logger.m699d(str3, y.٬ݯح׭٩(576540646));
                                mutexLock.setContent(KGResult.INSTANCE.getResult(9001, y.٬ݯح׭٩(576536590)));
                                mutexLock.unlock();
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // com.facebook.FacebookCallback
                            public void onError(FacebookException exception) {
                                String str3;
                                Intrinsics.checkNotNullParameter(exception, y.ۮڭڭܬި(862642723));
                                Logger logger = Logger.INSTANCE;
                                str3 = FacebookShare.TAG;
                                logger.m699d(str3, y.ٲٴݴ״ٰ(1782291384));
                                KGResult.Companion companion = KGResult.INSTANCE;
                                String facebookException = exception.toString();
                                if (facebookException == null) {
                                    facebookException = "FacebookException";
                                }
                                mutexLock.setContent(companion.getResult(9999, facebookException));
                                mutexLock.unlock();
                            }
                        });
                        int i2 = type;
                        i = FacebookShare.TYPE_IMAGE;
                        if (i2 == i) {
                            FacebookShare.INSTANCE.showShareImageDialog(shareDialog, createLock, content, hashTag);
                        } else {
                            FacebookShare.INSTANCE.showShareLinkialog(shareDialog, createLock, content, hashTag);
                        }
                    } catch (Exception e) {
                        Logger logger = Logger.INSTANCE;
                        str2 = FacebookShare.TAG;
                        logger.m701e(str2, y.ۮڭڭܬި(862342763) + e);
                        createLock.setContent(KGResult.INSTANCE.getResult(4001));
                        createLock.unlock();
                    }
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityResult(int requestCode, int resultCode, Intent data) {
                    String str2;
                    String str3;
                    CallbackManager callbackManager2;
                    Logger logger = Logger.INSTANCE;
                    str2 = FacebookShare.TAG;
                    StringBuilder append = new StringBuilder(y.٬ݯح׭٩(576536990)).append(requestCode);
                    String str4 = y.ݮڮֲڭܩ(-628756788);
                    logger.m699d(str2, append.append(str4).append(resultCode).append(str4).append(data).toString());
                    try {
                        callbackManager2 = FacebookShare.callbackManager;
                        callbackManager2.onActivityResult(requestCode, resultCode, data);
                    } catch (Exception e) {
                        Logger logger2 = Logger.INSTANCE;
                        str3 = FacebookShare.TAG;
                        logger2.m702e(str3, e.toString(), e);
                    }
                }
            };
            long start$default = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, kGActivityEventListener, null, 4, null);
            MutexLock.lock$default(createLock, 0L, 1, null);
            AuthActivityManager.INSTANCE.getInstance().finishActivity(start$default);
            AuthActivityManager.INSTANCE.getInstance().removeResultListener(kGActivityEventListener);
            KGResult<Void> kGResult = (KGResult) createLock.getContent();
            Logger.INSTANCE.m699d(TAG, str + kGResult);
            return kGResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }
}
