package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppPurchaseAutoLogger.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m839d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "()V", "BILLING_CLIENT_PURCHASE_NAME", "", "logPurchase", "", "startIapLogging", "context", "Landroid/content/Context;", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class InAppPurchaseAutoLogger {
    private static final String BILLING_CLIENT_PURCHASE_NAME = "com.android.billingclient.api.Purchase";
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InAppPurchaseAutoLogger() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void startIapLogging(Context context) {
        InAppPurchaseBillingClientWrapper orCreateInstance;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            if (InAppPurchaseUtils.getClass(BILLING_CLIENT_PURCHASE_NAME) == null || (orCreateInstance = InAppPurchaseBillingClientWrapper.INSTANCE.getOrCreateInstance(context)) == null || !InAppPurchaseBillingClientWrapper.INSTANCE.isServiceConnected().get()) {
                return;
            }
            InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
            if (InAppPurchaseLoggerManager.eligibleQueryPurchaseHistory()) {
                orCreateInstance.queryPurchaseHistory("inapp", new Runnable() { // from class: com.facebook.appevents.iap.InAppPurchaseAutoLogger$$ExternalSyntheticLambda0
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        InAppPurchaseAutoLogger.m1014startIapLogging$lambda0();
                    }
                });
            } else {
                orCreateInstance.queryPurchase("inapp", new Runnable() { // from class: com.facebook.appevents.iap.InAppPurchaseAutoLogger$$ExternalSyntheticLambda1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        InAppPurchaseAutoLogger.m1015startIapLogging$lambda1();
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: startIapLogging$lambda-0, reason: not valid java name */
    public static final void m1014startIapLogging$lambda0() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            INSTANCE.logPurchase();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: startIapLogging$lambda-1, reason: not valid java name */
    public static final void m1015startIapLogging$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            INSTANCE.logPurchase();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void logPurchase() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
            InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapper.INSTANCE.getPurchaseDetailsMap(), InAppPurchaseBillingClientWrapper.INSTANCE.getSkuDetailsMap());
            InAppPurchaseBillingClientWrapper.INSTANCE.getPurchaseDetailsMap().clear();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
