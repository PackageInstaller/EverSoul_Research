package com.facebook.internal.instrument.anrreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.kakaogame.game.StringSet;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ANRHandler.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m839d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRHandler;", "", "()V", "MAX_ANR_REPORT_NUM", "", StringSet.enabled, "Ljava/util/concurrent/atomic/AtomicBoolean;", "enable", "", "sendANRReports", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class ANRHandler {
    private static final int MAX_ANR_REPORT_NUM = 5;
    public static final ANRHandler INSTANCE = new ANRHandler();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ANRHandler() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final synchronized void enable() {
        synchronized (ANRHandler.class) {
            if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
                return;
            }
            try {
                if (enabled.getAndSet(true)) {
                    return;
                }
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    sendANRReports();
                }
                ANRDetector aNRDetector = ANRDetector.INSTANCE;
                ANRDetector.start();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ANRHandler.class);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendANRReports() {
        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
            return;
        }
        try {
            Utility utility = Utility.INSTANCE;
            if (Utility.isDataProcessingRestricted()) {
                return;
            }
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            File[] listAnrReportFiles = InstrumentUtility.listAnrReportFiles();
            ArrayList arrayList = new ArrayList(listAnrReportFiles.length);
            for (File file : listAnrReportFiles) {
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                arrayList.add(InstrumentData.Builder.load(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((InstrumentData) obj).isValid()) {
                    arrayList2.add(obj);
                }
            }
            final List sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.facebook.internal.instrument.anrreport.ANRHandler$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    int m1115sendANRReports$lambda2;
                    m1115sendANRReports$lambda2 = ANRHandler.m1115sendANRReports$lambda2((InstrumentData) obj2, (InstrumentData) obj3);
                    return m1115sendANRReports$lambda2;
                }
            });
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = RangesKt.until(0, Math.min(sortedWith.size(), 5)).iterator();
            while (it.hasNext()) {
                jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
            }
            InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
            InstrumentUtility.sendReports("anr_reports", jSONArray, new GraphRequest.Callback() { // from class: com.facebook.internal.instrument.anrreport.ANRHandler$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    ANRHandler.m1116sendANRReports$lambda5(sortedWith, graphResponse);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRHandler.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: sendANRReports$lambda-2, reason: not valid java name */
    public static final int m1115sendANRReports$lambda2(InstrumentData instrumentData, InstrumentData o2) {
        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullExpressionValue(o2, "o2");
            return instrumentData.compareTo(o2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRHandler.class);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: sendANRReports$lambda-5, reason: not valid java name */
    public static final void m1116sendANRReports$lambda5(List validReports, GraphResponse response) {
        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(validReports, "$validReports");
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                if (response.getError() == null) {
                    JSONObject jsonObject = response.getJsonObject();
                    if (Intrinsics.areEqual((Object) (jsonObject == null ? null : Boolean.valueOf(jsonObject.getBoolean("success"))), (Object) true)) {
                        Iterator it = validReports.iterator();
                        while (it.hasNext()) {
                            ((InstrumentData) it.next()).clear();
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRHandler.class);
        }
    }
}
