package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ImageRequest.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\r¨\u0006\u001a"}, m839d2 = {"Lcom/facebook/internal/ImageRequest;", "", "context", "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "callback", "Lcom/facebook/internal/ImageRequest$Callback;", "allowCachedRedirects", "", "callerTag", "(Landroid/content/Context;Landroid/net/Uri;Lcom/facebook/internal/ImageRequest$Callback;ZLjava/lang/Object;)V", "getAllowCachedRedirects", "()Z", "getCallback", "()Lcom/facebook/internal/ImageRequest$Callback;", "getCallerTag", "()Ljava/lang/Object;", "getContext", "()Landroid/content/Context;", "getImageUri", "()Landroid/net/Uri;", "isCachedRedirectAllowed", "Builder", "Callback", "Companion", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class ImageRequest {
    private static final String ACCESS_TOKEN_PARAM = "access_token";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private final boolean allowCachedRedirects;
    private final Callback callback;
    private final Object callerTag;
    private final Context context;
    private final Uri imageUri;

    /* compiled from: ImageRequest.kt */
    @Metadata(m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m839d2 = {"Lcom/facebook/internal/ImageRequest$Callback;", "", "onCompleted", "", "response", "Lcom/facebook/internal/ImageResponse;", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public interface Callback {
        void onCompleted(ImageResponse response);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ImageRequest(Context context, Uri uri, Callback callback, boolean z, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, uri, callback, z, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Uri getProfilePictureUri(String str, int i, int i2) {
        return INSTANCE.getProfilePictureUri(str, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Uri getProfilePictureUri(String str, int i, int i2, String str2) {
        return INSTANCE.getProfilePictureUri(str, i, i2, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ImageRequest(Context context, Uri uri, Callback callback, boolean z, Object obj) {
        this.context = context;
        this.imageUri = uri;
        this.callback = callback;
        this.allowCachedRedirects = z;
        this.callerTag = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri getImageUri() {
        return this.imageUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Callback getCallback() {
        return this.callback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getAllowCachedRedirects() {
        return this.allowCachedRedirects;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object getCallerTag() {
        return this.callerTag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    /* compiled from: ImageRequest.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0007J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m839d2 = {"Lcom/facebook/internal/ImageRequest$Companion;", "", "()V", "ACCESS_TOKEN_PARAM", "", "HEIGHT_PARAM", "MIGRATION_PARAM", "MIGRATION_VALUE", "PATH", "UNSPECIFIED_DIMENSION", "", "WIDTH_PARAM", "getProfilePictureUri", "Landroid/net/Uri;", "userId", "width", "height", "accessToken", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final Uri getProfilePictureUri(String userId, int width, int height) {
            return getProfilePictureUri(userId, width, height, "");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final Uri getProfilePictureUri(String userId, int width, int height, String accessToken) {
            Validate validate = Validate.INSTANCE;
            Validate.notNullOrEmpty(userId, "userId");
            int max = Math.max(width, 0);
            int max2 = Math.max(height, 0);
            if (!((max == 0 && max2 == 0) ? false : true)) {
                throw new IllegalArgumentException("Either width or height must be greater than 0".toString());
            }
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            Uri.Builder buildUpon = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String format = String.format(locale, ImageRequest.PATH, Arrays.copyOf(new Object[]{FacebookSdk.getGraphApiVersion(), userId}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            Uri.Builder path = buildUpon.path(format);
            if (max2 != 0) {
                path.appendQueryParameter("height", String.valueOf(max2));
            }
            if (max != 0) {
                path.appendQueryParameter("width", String.valueOf(max));
            }
            path.appendQueryParameter(ImageRequest.MIGRATION_PARAM, ImageRequest.MIGRATION_VALUE);
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(accessToken)) {
                path.appendQueryParameter("access_token", accessToken);
            } else {
                Utility utility2 = Utility.INSTANCE;
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                if (!Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
                    Utility utility3 = Utility.INSTANCE;
                    FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                    if (!Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
                        StringBuilder sb = new StringBuilder();
                        FacebookSdk facebookSdk4 = FacebookSdk.INSTANCE;
                        StringBuilder append = sb.append(FacebookSdk.getApplicationId()).append('|');
                        FacebookSdk facebookSdk5 = FacebookSdk.INSTANCE;
                        path.appendQueryParameter("access_token", append.append(FacebookSdk.getClientToken()).toString());
                    }
                }
                Log.d("ImageRequest", "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned");
            }
            Uri build = path.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            return build;
        }
    }

    /* compiled from: ImageRequest.kt */
    @Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m839d2 = {"Lcom/facebook/internal/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "allowCachedRedirects", "", "callback", "Lcom/facebook/internal/ImageRequest$Callback;", "callerTag", "build", "Lcom/facebook/internal/ImageRequest;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "setAllowCachedRedirects", "setCallback", "setCallerTag", "toString", "", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final /* data */ class Builder {
        private boolean allowCachedRedirects;
        private Callback callback;
        private Object callerTag;
        private final Context context;
        private final Uri imageUri;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final Context component1() {
            return this.context;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final Uri component2() {
            return this.imageUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ Builder copy$default(Builder builder, Context context, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                context = builder.context;
            }
            if ((i & 2) != 0) {
                uri = builder.imageUri;
            }
            return builder.copy(context, uri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder copy(Context context, Uri imageUri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(imageUri, "imageUri");
            return new Builder(context, imageUri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.context, builder.context) && Intrinsics.areEqual(this.imageUri, builder.imageUri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return (this.context.hashCode() * 31) + this.imageUri.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "Builder(context=" + this.context + ", imageUri=" + this.imageUri + ')';
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(Context context, Uri imageUri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(imageUri, "imageUri");
            this.context = context;
            this.imageUri = imageUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setCallback(Callback callback) {
            this.callback = callback;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setCallerTag(Object callerTag) {
            this.callerTag = callerTag;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder setAllowCachedRedirects(boolean allowCachedRedirects) {
            this.allowCachedRedirects = allowCachedRedirects;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final ImageRequest build() {
            Context context = this.context;
            Uri uri = this.imageUri;
            Callback callback = this.callback;
            boolean z = this.allowCachedRedirects;
            Object obj = this.callerTag;
            if (obj == null) {
                obj = new Object();
            } else if (obj == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            return new ImageRequest(context, uri, callback, z, obj, null);
        }
    }
}
