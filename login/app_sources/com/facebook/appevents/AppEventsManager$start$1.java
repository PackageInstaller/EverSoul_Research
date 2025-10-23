package com.facebook.appevents;

import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.p005ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import kotlin.Metadata;

/* compiled from: AppEventsManager.kt */
@Metadata(m838d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, m839d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class AppEventsManager$start$1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
    public void onError() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AppEventsManager$start$1() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
    public void onSuccess(FetchedAppSettings fetchedAppSettings) {
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                AppEventsManager$start$1.m980onSuccess$lambda0(z);
            }
        });
        FeatureManager featureManager2 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                AppEventsManager$start$1.m981onSuccess$lambda1(z);
            }
        });
        FeatureManager featureManager3 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                AppEventsManager$start$1.m982onSuccess$lambda2(z);
            }
        });
        FeatureManager featureManager4 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                AppEventsManager$start$1.m983onSuccess$lambda3(z);
            }
        });
        FeatureManager featureManager5 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                AppEventsManager$start$1.m984onSuccess$lambda4(z);
            }
        });
        FeatureManager featureManager6 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.ProtectedMode, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                AppEventsManager$start$1.m985onSuccess$lambda5(z);
            }
        });
        FeatureManager featureManager7 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.MACARuleMatching, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                AppEventsManager$start$1.m986onSuccess$lambda6(z);
            }
        });
        FeatureManager featureManager8 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                AppEventsManager$start$1.m987onSuccess$lambda7(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: onSuccess$lambda-0, reason: not valid java name */
    public static final void m980onSuccess$lambda0(boolean z) {
        if (z) {
            MetadataIndexer metadataIndexer = MetadataIndexer.INSTANCE;
            MetadataIndexer.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: onSuccess$lambda-1, reason: not valid java name */
    public static final void m981onSuccess$lambda1(boolean z) {
        if (z) {
            RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
            RestrictiveDataManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: onSuccess$lambda-2, reason: not valid java name */
    public static final void m982onSuccess$lambda2(boolean z) {
        if (z) {
            ModelManager modelManager = ModelManager.INSTANCE;
            ModelManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: onSuccess$lambda-3, reason: not valid java name */
    public static final void m983onSuccess$lambda3(boolean z) {
        if (z) {
            EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
            EventDeactivationManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: onSuccess$lambda-4, reason: not valid java name */
    public static final void m984onSuccess$lambda4(boolean z) {
        if (z) {
            InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
            InAppPurchaseManager.enableAutoLogging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: onSuccess$lambda-5, reason: not valid java name */
    public static final void m985onSuccess$lambda5(boolean z) {
        if (z) {
            ProtectedModeManager protectedModeManager = ProtectedModeManager.INSTANCE;
            ProtectedModeManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: onSuccess$lambda-6, reason: not valid java name */
    public static final void m986onSuccess$lambda6(boolean z) {
        if (z) {
            MACARuleMatchingManager mACARuleMatchingManager = MACARuleMatchingManager.INSTANCE;
            MACARuleMatchingManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: onSuccess$lambda-7, reason: not valid java name */
    public static final void m987onSuccess$lambda7(boolean z) {
        if (z) {
            AppEventsCAPIManager appEventsCAPIManager = AppEventsCAPIManager.INSTANCE;
            AppEventsCAPIManager.enable();
        }
    }
}
