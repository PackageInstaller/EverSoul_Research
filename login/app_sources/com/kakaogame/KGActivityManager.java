package com.kakaogame;

import android.content.res.Configuration;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.liapp.y;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGActivityManager.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/KGActivityManager;", "", "()V", "Companion", "ConfigChangeListener", "LifecycleListener", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGActivityManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<ConfigChangeListener> configChangeListeners = new LinkedHashSet();
    private static final Set<LifecycleListener> lifecycleListeners = new LinkedHashSet();

    /* compiled from: KGActivityManager.kt */
    @Metadata(m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/KGActivityManager$ConfigChangeListener;", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface ConfigChangeListener {
        void onConfigurationChanged(Configuration newConfig);
    }

    /* compiled from: KGActivityManager.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/KGActivityManager$LifecycleListener;", "", "onPause", "", "onResume", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface LifecycleListener {
        void onPause();

        void onResume();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void dispatchConfigurationChanged(Configuration configuration) {
        INSTANCE.dispatchConfigurationChanged(configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void dispatchPause() {
        INSTANCE.dispatchPause();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void dispatchResume() {
        INSTANCE.dispatchResume();
    }

    /* compiled from: KGActivityManager.kt */
    @Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\tH\u0007J\b\u0010\u0010\u001a\u00020\tH\u0007J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/KGActivityManager$Companion;", "", "()V", "configChangeListeners", "", "Lcom/kakaogame/KGActivityManager$ConfigChangeListener;", "lifecycleListeners", "Lcom/kakaogame/KGActivityManager$LifecycleListener;", "addConfigChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addLifecycleListener", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchPause", "dispatchResume", "removeConfigChangeListener", "removeLifecycleListener", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void addConfigChangeListener(ConfigChangeListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            synchronized (KGActivityManager.configChangeListeners) {
                KGActivityManager.configChangeListeners.add(listener);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void removeConfigChangeListener(ConfigChangeListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            synchronized (KGActivityManager.configChangeListeners) {
                KGActivityManager.configChangeListeners.remove(listener);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void addLifecycleListener(LifecycleListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            synchronized (KGActivityManager.lifecycleListeners) {
                KGActivityManager.lifecycleListeners.add(listener);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void removeLifecycleListener(LifecycleListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            synchronized (KGActivityManager.lifecycleListeners) {
                KGActivityManager.lifecycleListeners.remove(listener);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void dispatchConfigurationChanged(Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, y.ݬֲ֮ܲت(1512614831));
            synchronized (KGActivityManager.configChangeListeners) {
                Iterator it = KGActivityManager.configChangeListeners.iterator();
                while (it.hasNext()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGActivityManager$Companion$dispatchConfigurationChanged$1$1((ConfigChangeListener) it.next(), newConfig, null), 3, null);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void dispatchResume() {
            synchronized (KGActivityManager.lifecycleListeners) {
                Iterator it = KGActivityManager.lifecycleListeners.iterator();
                while (it.hasNext()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGActivityManager$Companion$dispatchResume$1$1((LifecycleListener) it.next(), null), 3, null);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void dispatchPause() {
            synchronized (KGActivityManager.lifecycleListeners) {
                Iterator it = KGActivityManager.lifecycleListeners.iterator();
                while (it.hasNext()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGActivityManager$Companion$dispatchPause$1$1((LifecycleListener) it.next(), null), 3, null);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
