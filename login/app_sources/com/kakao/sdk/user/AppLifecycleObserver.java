package com.kakao.sdk.user;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.kakao.sdk.user.model.AccessTokenInfo;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppLifecycleObserver.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m839d2 = {"Lcom/kakao/sdk/user/AppLifecycleObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "()V", "prevTimeMillis", "", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "Companion", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AppLifecycleObserver implements LifecycleEventObserver {
    private static final int INTERVAL_HOUR = 6;
    private long prevTimeMillis;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<AppLifecycleObserver> instance$delegate = LazyKt.lazy(new Function0<AppLifecycleObserver>() { // from class: com.kakao.sdk.user.AppLifecycleObserver$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final AppLifecycleObserver invoke() {
            return new AppLifecycleObserver();
        }
    });

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final AppLifecycleObserver getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_START) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (TimeUnit.MILLISECONDS.toHours(currentTimeMillis - this.prevTimeMillis) < 6) {
            return;
        }
        this.prevTimeMillis = currentTimeMillis;
        UserApiClient.INSTANCE.getInstance().accessTokenInfo(new Function2<AccessTokenInfo, Throwable, Unit>() { // from class: com.kakao.sdk.user.AppLifecycleObserver$onStateChanged$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AccessTokenInfo accessTokenInfo, Throwable th) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(AccessTokenInfo accessTokenInfo, Throwable th) {
                invoke2(accessTokenInfo, th);
                return Unit.INSTANCE;
            }
        });
    }

    /* compiled from: AppLifecycleObserver.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, m839d2 = {"Lcom/kakao/sdk/user/AppLifecycleObserver$Companion;", "", "()V", "INTERVAL_HOUR", "", "instance", "Lcom/kakao/sdk/user/AppLifecycleObserver;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/user/AppLifecycleObserver;", "instance$delegate", "Lkotlin/Lazy;", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
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
        public final AppLifecycleObserver getInstance() {
            return (AppLifecycleObserver) AppLifecycleObserver.instance$delegate.getValue();
        }
    }
}
