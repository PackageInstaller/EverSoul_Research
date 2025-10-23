package com.kakao.sdk.auth;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TokenManagerProvider.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\t"}, m839d2 = {"Lcom/kakao/sdk/auth/TokenManagerProvider;", "", "manager", "Lcom/kakao/sdk/auth/TokenManageable;", "(Lcom/kakao/sdk/auth/TokenManageable;)V", "getManager", "()Lcom/kakao/sdk/auth/TokenManageable;", "setManager", "Companion", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TokenManagerProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<TokenManagerProvider> instance$delegate = LazyKt.lazy(new Function0<TokenManagerProvider>() { // from class: com.kakao.sdk.auth.TokenManagerProvider$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final TokenManagerProvider invoke() {
            return new TokenManagerProvider(null, 1, 0 == true ? 1 : 0);
        }
    });
    private TokenManageable manager;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TokenManagerProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final TokenManagerProvider getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TokenManagerProvider(TokenManageable manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ TokenManagerProvider(TokenManager tokenManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TokenManager.INSTANCE.getInstance() : tokenManager);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TokenManageable getManager() {
        return this.manager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setManager(TokenManageable tokenManageable) {
        Intrinsics.checkNotNullParameter(tokenManageable, "<set-?>");
        this.manager = tokenManageable;
    }

    /* compiled from: TokenManagerProvider.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m839d2 = {"Lcom/kakao/sdk/auth/TokenManagerProvider$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/auth/TokenManagerProvider;", "instance$delegate", "Lkotlin/Lazy;", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
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
        public final TokenManagerProvider getInstance() {
            return (TokenManagerProvider) TokenManagerProvider.instance$delegate.getValue();
        }
    }
}
