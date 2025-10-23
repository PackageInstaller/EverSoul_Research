package com.kakao.sdk.auth;

import android.net.Uri;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ServerHosts;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UriUtility.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJÛ\u0001\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00102\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00102\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m839d2 = {"Lcom/kakao/sdk/auth/UriUtility;", "", "hosts", "Lcom/kakao/sdk/common/model/ServerHosts;", "(Lcom/kakao/sdk/common/model/ServerHosts;)V", "accountLoginAndAuthorize", "Landroid/net/Uri;", "authorizeUri", "accountParameters", "", "", "authorize", "clientId", Constants.AGT, "redirectUri", com.kakao.sdk.user.Constants.SCOPES, "", "kaHeader", "channelPublicIds", "serviceTerms", "prompts", "Lcom/kakao/sdk/auth/model/Prompt;", "loginHint", "nonce", "approvalType", "codeChallenge", "codeChallengeMethod", "accountsSkipIntro", "", "accountsTalkLoginVisible", "kauthTxId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Landroid/net/Uri;", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class UriUtility {
    private final ServerHosts hosts;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UriUtility() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UriUtility(ServerHosts hosts) {
        Intrinsics.checkNotNullParameter(hosts, "hosts");
        this.hosts = hosts;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ UriUtility(ServerHosts serverHosts, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getHosts() : serverHosts);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri authorize(String clientId, String agt, String redirectUri, List<String> scopes, String kaHeader, List<String> channelPublicIds, List<String> serviceTerms, List<? extends Prompt> prompts, String loginHint, String nonce, String approvalType, String codeChallenge, String codeChallengeMethod, Boolean accountsSkipIntro, Boolean accountsTalkLoginVisible, String kauthTxId) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority(this.hosts.getKauth()).path("oauth/authorize").appendQueryParameter("client_id", clientId).appendQueryParameter("redirect_uri", redirectUri).appendQueryParameter("response_type", "code");
        if (agt != null) {
            appendQueryParameter.appendQueryParameter(Constants.AGT, agt);
        }
        List<String> list = scopes;
        if (!(list == null || list.isEmpty())) {
            appendQueryParameter.appendQueryParameter("scope", CollectionsKt.joinToString$default(scopes, ",", null, null, 0, null, null, 62, null));
        }
        if (channelPublicIds != null) {
            appendQueryParameter.appendQueryParameter("channel_public_id", CollectionsKt.joinToString$default(channelPublicIds, ",", null, null, 0, null, null, 62, null));
        }
        if (serviceTerms != null) {
            appendQueryParameter.appendQueryParameter("service_terms", CollectionsKt.joinToString$default(serviceTerms, ",", null, null, 0, null, null, 62, null));
        }
        if (prompts != null) {
            appendQueryParameter.appendQueryParameter(Constants.PROMPT, CollectionsKt.joinToString$default(prompts, ",", null, null, 0, null, new Function1<Prompt, CharSequence>() { // from class: com.kakao.sdk.auth.UriUtility$authorize$1$4$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(Prompt prompt) {
                    Intrinsics.checkNotNullParameter(prompt, "prompt");
                    return prompt.getValue();
                }
            }, 30, null));
        }
        if (loginHint != null) {
            appendQueryParameter.appendQueryParameter(Constants.LOGIN_HINT, loginHint);
        }
        if (nonce != null) {
            appendQueryParameter.appendQueryParameter("nonce", nonce);
        }
        if (approvalType != null) {
            appendQueryParameter.appendQueryParameter(Constants.APPROVAL_TYPE, approvalType);
        }
        if (codeChallenge != null) {
            appendQueryParameter.appendQueryParameter("code_challenge", codeChallenge);
        }
        if (codeChallengeMethod != null) {
            appendQueryParameter.appendQueryParameter("code_challenge_method", codeChallengeMethod);
        }
        if (accountsSkipIntro != null) {
            appendQueryParameter.appendQueryParameter(Constants.ACCOUNTS_SKIP_INTRO, String.valueOf(accountsSkipIntro.booleanValue()));
        }
        if (accountsTalkLoginVisible != null) {
            appendQueryParameter.appendQueryParameter(Constants.ACCOUNTS_TALK_LOGIN_VISIBLE, String.valueOf(accountsTalkLoginVisible.booleanValue()));
        }
        if (kauthTxId != null) {
            appendQueryParameter.appendQueryParameter(Constants.KAUTH_TX_ID, kauthTxId);
        }
        if (KakaoSdk.INSTANCE.isAutomotive()) {
            appendQueryParameter.appendQueryParameter(Constants.DEVICE_TYPE, Constants.AUTOMOTIVE);
        }
        Uri build = appendQueryParameter.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .schem…       }\n        .build()");
        return build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Uri accountLoginAndAuthorize$default(UriUtility uriUtility, Uri uri, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return uriUtility.accountLoginAndAuthorize(uri, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri accountLoginAndAuthorize(Uri authorizeUri, Map<String, String> accountParameters) {
        Intrinsics.checkNotNullParameter(authorizeUri, "authorizeUri");
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority(this.hosts.getMobileAccount()).path(Constants.ACCOUNT_LOGIN_PATH).appendQueryParameter(Constants.ACCOUNT_LOGIN_PARAM_CONTINUE, authorizeUri.toString());
        if (accountParameters != null) {
            for (Map.Entry<String, String> entry : accountParameters.entrySet()) {
                appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        Uri build = appendQueryParameter.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .schem…      }\n        }.build()");
        return build;
    }
}
