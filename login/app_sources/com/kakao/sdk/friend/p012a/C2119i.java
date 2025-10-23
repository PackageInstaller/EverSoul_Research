package com.kakao.sdk.friend.p012a;

import android.content.Context;
import android.os.ResultReceiver;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.PickerChatFilter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;

/* renamed from: com.kakao.sdk.friend.a.i */
/* loaded from: classes3.dex */
public final class C2119i {

    /* renamed from: a */
    public static final C2119i f619a = new C2119i();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final List<PickerChatFilter> m475a(List<? extends PickerChatFilter> list) {
        return list == 0 || list.isEmpty() ? CollectionsKt.listOf(PickerChatFilter.REGULAR) : list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m474a(C2119i c2119i, Context context, boolean z, boolean z2, InternalTabParams internalTabParams, ResultReceiver resultReceiver, Function3 function3) {
        C2120j.f620a.m478b().mo493a(internalTabParams.getFriendsParams().getServiceTypeFilter(), internalTabParams.getFriendsParams().getFriendFilter(), internalTabParams.getFriendsParams().getCountryCodeFilters(), new C2112b(function3, internalTabParams, context, z, z2, resultReceiver));
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e4, code lost:
    
        throw new com.kakao.sdk.common.model.ClientError(com.kakao.sdk.common.model.ClientErrorCause.BadParameter, "'uuids' and 'message' must be set for 'CUSTOM' option.");
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m476a(android.os.Parcelable r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.p012a.C2119i.m476a(android.os.Parcelable, boolean):void");
    }
}
