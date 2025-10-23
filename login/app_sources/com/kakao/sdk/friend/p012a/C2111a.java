package com.kakao.sdk.friend.p012a;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import com.google.android.gms.drive.DriveFile;
import com.kakao.sdk.friend.internal.InternalChatParams;
import com.kakao.sdk.friend.internal.InternalFriendsParams;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.SelectedChat;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p023l.C2193i;
import com.kakao.sdk.friend.view.FullPickerActivity;
import com.kakao.sdk.friend.view.PopupPickerActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.a.a */
/* loaded from: classes3.dex */
public final class C2111a extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ Function3<SelectedUsers, SelectedChat, Throwable, Unit> f587a;

    /* renamed from: b */
    public final /* synthetic */ Context f588b;

    /* renamed from: c */
    public final /* synthetic */ boolean f589c;

    /* renamed from: d */
    public final /* synthetic */ boolean f590d;

    /* renamed from: e */
    public final /* synthetic */ InternalTabParams f591e;

    /* renamed from: f */
    public final /* synthetic */ ResultReceiver f592f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2111a(Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> function3, Context context, boolean z, boolean z2, InternalTabParams internalTabParams, ResultReceiver resultReceiver) {
        super(1);
        this.f587a = function3;
        this.f588b = context;
        this.f589c = z;
        this.f590d = z2;
        this.f591e = internalTabParams;
        this.f592f = resultReceiver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        if (th2 != null) {
            C2120j.f621b = null;
            if (C2171d.f794j == null) {
                C2171d.f794j = new C2171d();
            }
            C2171d c2171d = C2171d.f794j;
            Intrinsics.checkNotNull(c2171d);
            c2171d.getClass();
            C2171d.f794j = null;
            this.f587a.invoke(null, null, th2);
        } else {
            Context context = this.f588b;
            boolean z = this.f589c;
            boolean z2 = this.f590d;
            InternalTabParams internalTabParams = this.f591e;
            ResultReceiver resultReceiver = this.f592f;
            if (C2171d.f794j == null) {
                C2171d.f794j = new C2171d();
            }
            C2171d c2171d2 = C2171d.f794j;
            Intrinsics.checkNotNull(c2171d2);
            c2171d2.f795a = z;
            c2171d2.f796b = z2;
            c2171d2.f801g = internalTabParams;
            Intrinsics.checkNotNullParameter(internalTabParams, "<this>");
            c2171d2.f798d = new InternalFriendsParams(internalTabParams.getTitle(), internalTabParams.getFriendsParams().getServiceTypeFilter(), internalTabParams.getFriendsParams().getFriendFilter(), internalTabParams.getFriendsParams().getCountryCodeFilters(), internalTabParams.getFriendsParams().getUsingOsFilter(), internalTabParams.getViewAppearance(), internalTabParams.getOrientation(), internalTabParams.getEnableSearch(), internalTabParams.getFriendsParams().getEnableIndex(), internalTabParams.getFriendsParams().getShowMyProfile(), internalTabParams.getFriendsParams().getShowFavorite(), internalTabParams.getDisableSelectOptions(), internalTabParams.getDisplayAllProfile(), internalTabParams.getFriendsParams().getShowPickedFriend(), internalTabParams.getMaxPickableCount(), internalTabParams.getMinPickableCount());
            Intrinsics.checkNotNullParameter(internalTabParams, "<this>");
            c2171d2.f799e = new InternalChatParams(internalTabParams.getChatParams().getSelectionType(), internalTabParams.getTitle(), internalTabParams.getChatParams().getChatFilters(), internalTabParams.getViewAppearance(), internalTabParams.getOrientation(), internalTabParams.getEnableSearch(), internalTabParams.getDisableSelectOptions(), internalTabParams.getDisplayAllProfile(), internalTabParams.getMaxPickableCount(), internalTabParams.getMinPickableCount());
            c2171d2.f797c = C2193i.m550a(internalTabParams);
            c2171d2.f802h = resultReceiver;
            Intent addFlags = new Intent(context, (Class<?>) (z2 ? PopupPickerActivity.class : FullPickerActivity.class)).addFlags(DriveFile.MODE_READ_ONLY);
            Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(context, activity…t.FLAG_ACTIVITY_NEW_TASK)");
            context.startActivity(addFlags);
        }
        return Unit.INSTANCE;
    }
}
