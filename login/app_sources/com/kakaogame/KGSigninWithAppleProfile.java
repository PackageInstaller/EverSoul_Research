package com.kakaogame;

import android.app.Activity;
import com.kakaogame.apple.SIWAManager;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGSigninWithAppleProfile.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t0\bH\u0016¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/KGSigninWithAppleProfile;", "Lcom/kakaogame/KGIdpProfile;", "content", "", "", "", "(Ljava/util/Map;)V", "loadFriendProfiles", "Lcom/kakaogame/KGResult;", "", "Companion", "idp_siwa_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGSigninWithAppleProfile extends KGIdpProfile {
    private static final String CLASS_NAME_KEY = "KGSigninWithAppleProfile";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -2875654182578894278L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initialize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void revokeToken(KGResultCallback<Void> kGResultCallback) {
        INSTANCE.revokeToken(kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGSigninWithAppleProfile(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGIdpProfile
    public KGResult<Map<String, KGIdpProfile>> loadFriendProfiles() {
        return KGResult.INSTANCE.getResult(5001);
    }

    /* compiled from: KGSigninWithAppleProfile.kt */
    @Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\n\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/KGSigninWithAppleProfile$Companion;", "", "()V", "CLASS_NAME_KEY", "", "serialVersionUID", "", "initInterfaceBroker", "", "initialize", "revokeToken", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "idp_siwa_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
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
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void revokeToken(KGResultCallback<Void> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSigninWithAppleProfile$Companion$revokeToken$1(callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862393875), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSigninWithAppleProfile$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGResult<Void> revokeToken = SIWAManager.INSTANCE.revokeToken();
                    FirebaseEvent.INSTANCE.sendEvent(y.ۮڭڭܬި(862393563), y.֬ڱܱײٮ(-1159519359), revokeToken);
                    if (revokeToken.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(revokeToken);
                    }
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
        }
    }
}
