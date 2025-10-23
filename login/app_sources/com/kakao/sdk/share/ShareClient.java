package com.kakao.sdk.share;

import android.content.Context;
import com.facebook.share.internal.ShareInternalUtility;
import com.kakao.sdk.network.ApiCallback;
import com.kakao.sdk.share.model.ImageUploadResult;
import com.kakao.sdk.share.model.SharingResult;
import com.kakao.sdk.share.model.ValidationResult;
import com.kakao.sdk.template.model.DefaultTemplate;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: ShareClient.kt */
@Metadata(m838d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJV\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000e0\u0013H\u0007J\u0084\u0001\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001e2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001e2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000e0\u0013H\u0007Jl\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001e2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000e0\u0013H\u0007J\u0095\u0001\u0010%\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001e2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001e2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000e0\u0013H\u0007¢\u0006\u0002\u0010'JV\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0011\u001a\u00020\n2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000e0\u0013H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, m839d2 = {"Lcom/kakao/sdk/share/ShareClient;", "", "shareApi", "Lcom/kakao/sdk/share/ShareApi;", "kakaotalkShareIntentClient", "Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "(Lcom/kakao/sdk/share/ShareApi;Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;)V", "getKakaotalkShareIntentClient", "()Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "isKakaoTalkSharingAvailable", "", "context", "Landroid/content/Context;", "scrapImage", "", "imageUrl", "", "secureResource", "callback", "Lkotlin/Function2;", "Lcom/kakao/sdk/share/model/ImageUploadResult;", "Lkotlin/ParameterName;", "name", "imageUploadResult", "", "error", "shareCustom", "templateId", "", "templateArgs", "", "serverCallbackArgs", "Lcom/kakao/sdk/share/model/SharingResult;", "sharingResult", "shareDefault", "defaultTemplate", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "shareScrap", "url", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "uploadImage", "image", "Ljava/io/File;", "Companion", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ShareClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<ShareClient> instance$delegate = LazyKt.lazy(new Function0<ShareClient>() { // from class: com.kakao.sdk.share.ShareClient$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final ShareClient invoke() {
            return new ShareClient(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
    });
    private final KakaoTalkShareIntentClient kakaotalkShareIntentClient;
    private final ShareApi shareApi;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShareClient() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final ShareClient getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void scrapImage(String imageUrl, Function2<? super ImageUploadResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        scrapImage$default(this, imageUrl, false, callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareCustom(Context context, long j, Map<String, String> map, Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        shareCustom$default(this, context, j, map, null, callback, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareCustom(Context context, long j, Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        shareCustom$default(this, context, j, null, null, callback, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareDefault(Context context, DefaultTemplate defaultTemplate, Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultTemplate, "defaultTemplate");
        Intrinsics.checkNotNullParameter(callback, "callback");
        shareDefault$default(this, context, defaultTemplate, null, callback, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareScrap(Context context, String url, Long l, Map<String, String> map, Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        shareScrap$default(this, context, url, l, map, null, callback, 16, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareScrap(Context context, String url, Long l, Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        shareScrap$default(this, context, url, l, null, null, callback, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareScrap(Context context, String url, Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        shareScrap$default(this, context, url, null, null, null, callback, 28, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void uploadImage(File image, Function2<? super ImageUploadResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(callback, "callback");
        uploadImage$default(this, image, false, callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShareClient(ShareApi shareApi, KakaoTalkShareIntentClient kakaotalkShareIntentClient) {
        Intrinsics.checkNotNullParameter(shareApi, "shareApi");
        Intrinsics.checkNotNullParameter(kakaotalkShareIntentClient, "kakaotalkShareIntentClient");
        this.shareApi = shareApi;
        this.kakaotalkShareIntentClient = kakaotalkShareIntentClient;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ShareClient(com.kakao.sdk.share.ShareApi r1, com.kakao.sdk.share.KakaoTalkShareIntentClient r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L17
            com.kakao.sdk.network.ApiFactory r1 = com.kakao.sdk.network.ApiFactory.INSTANCE
            retrofit2.Retrofit r1 = r1.getKapi()
            java.lang.Class<com.kakao.sdk.share.ShareApi> r4 = com.kakao.sdk.share.ShareApi.class
            java.lang.Object r1 = r1.create(r4)
            java.lang.String r4 = "ApiFactory.kapi.create(ShareApi::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            com.kakao.sdk.share.ShareApi r1 = (com.kakao.sdk.share.ShareApi) r1
        L17:
            r3 = r3 & 2
            if (r3 == 0) goto L21
            com.kakao.sdk.share.KakaoTalkShareIntentClient$Companion r2 = com.kakao.sdk.share.KakaoTalkShareIntentClient.INSTANCE
            com.kakao.sdk.share.KakaoTalkShareIntentClient r2 = r2.getInstance()
        L21:
            r0.<init>(r1, r2)
            return
            fill-array 0x0026: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.share.ShareClient.<init>(com.kakao.sdk.share.ShareApi, com.kakao.sdk.share.KakaoTalkShareIntentClient, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KakaoTalkShareIntentClient getKakaotalkShareIntentClient() {
        return this.kakaotalkShareIntentClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isKakaoTalkSharingAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.kakaotalkShareIntentClient.isKakaoTalkSharingAvailable(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void shareCustom$default(ShareClient shareClient, Context context, long j, Map map, Map map2, Function2 function2, int i, Object obj) {
        shareClient.shareCustom(context, j, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareCustom(final Context context, long templateId, Map<String, String> templateArgs, final Map<String, String> serverCallbackArgs, final Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.shareApi.validateCustom(templateId, templateArgs).enqueue(new ApiCallback<ValidationResult>() { // from class: com.kakao.sdk.share.ShareClient$shareCustom$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(ValidationResult model, Throwable error) {
                if (model != null) {
                    try {
                        callback.invoke(KakaoTalkShareIntentClient.sharingResultFromResponse$default(this.getKakaotalkShareIntentClient(), context, model, serverCallbackArgs, null, null, 24, null), null);
                        return;
                    } catch (Throwable th) {
                        callback.invoke(null, th);
                        return;
                    }
                }
                callback.invoke(null, error);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void shareDefault$default(ShareClient shareClient, Context context, DefaultTemplate defaultTemplate, Map map, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        shareClient.shareDefault(context, defaultTemplate, map, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareDefault(final Context context, DefaultTemplate defaultTemplate, final Map<String, String> serverCallbackArgs, final Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultTemplate, "defaultTemplate");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.shareApi.validateDefault(defaultTemplate).enqueue(new ApiCallback<ValidationResult>() { // from class: com.kakao.sdk.share.ShareClient$shareDefault$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(ValidationResult model, Throwable error) {
                if (model != null) {
                    try {
                        callback.invoke(KakaoTalkShareIntentClient.sharingResultFromResponse$default(this.getKakaotalkShareIntentClient(), context, model, serverCallbackArgs, null, null, 24, null), null);
                        return;
                    } catch (Throwable th) {
                        callback.invoke(null, th);
                        return;
                    }
                }
                callback.invoke(null, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void shareScrap$default(ShareClient shareClient, Context context, String str, Long l, Map map, Map map2, Function2 function2, int i, Object obj) {
        shareClient.shareScrap(context, str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : map2, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareScrap(final Context context, String url, Long templateId, Map<String, String> templateArgs, final Map<String, String> serverCallbackArgs, final Function2<? super SharingResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.shareApi.validateScrap(url, templateId, templateArgs).enqueue(new ApiCallback<ValidationResult>() { // from class: com.kakao.sdk.share.ShareClient$shareScrap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(ValidationResult model, Throwable error) {
                if (model != null) {
                    try {
                        callback.invoke(KakaoTalkShareIntentClient.sharingResultFromResponse$default(this.getKakaotalkShareIntentClient(), context, model, serverCallbackArgs, null, null, 24, null), null);
                        return;
                    } catch (Throwable th) {
                        callback.invoke(null, th);
                        return;
                    }
                }
                callback.invoke(null, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void uploadImage$default(ShareClient shareClient, File file, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        shareClient.uploadImage(file, z, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void uploadImage(File image, boolean secureResource, final Function2<? super ImageUploadResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.shareApi.uploadImage(MultipartBody.Part.INSTANCE.createFormData(ShareInternalUtility.STAGING_PARAM, image.getName(), RequestBody.INSTANCE.create(image, MediaType.INSTANCE.get("image/*"))), Boolean.valueOf(secureResource)).enqueue(new ApiCallback<ImageUploadResult>() { // from class: com.kakao.sdk.share.ShareClient$uploadImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(ImageUploadResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void scrapImage$default(ShareClient shareClient, String str, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        shareClient.scrapImage(str, z, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void scrapImage(String imageUrl, boolean secureResource, final Function2<? super ImageUploadResult, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.shareApi.scrapImage(imageUrl, Boolean.valueOf(secureResource)).enqueue(new ApiCallback<ImageUploadResult>() { // from class: com.kakao.sdk.share.ShareClient$scrapImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(ImageUploadResult model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* compiled from: ShareClient.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m839d2 = {"Lcom/kakao/sdk/share/ShareClient$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/share/ShareClient;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/share/ShareClient;", "instance$delegate", "Lkotlin/Lazy;", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final ShareClient getInstance() {
            return (ShareClient) ShareClient.instance$delegate.getValue();
        }
    }
}
