package com.kakao.sdk.friend.p012a;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.kakao.sdk.friend.internal.InternalFriendsParams;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p023l.C2193i;
import com.kakao.sdk.friend.view.FullPickerActivity;
import com.kakao.sdk.friend.view.PopupPickerActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.a.d */
/* loaded from: classes3.dex */
public final class C2114d extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ Function2<SelectedUsers, Throwable, Unit> f603a;

    /* renamed from: b */
    public final /* synthetic */ boolean f604b;

    /* renamed from: c */
    public final /* synthetic */ Context f605c;

    /* renamed from: d */
    public final /* synthetic */ boolean f606d;

    /* renamed from: e */
    public final /* synthetic */ InternalFriendsParams f607e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2114d(Function2<? super SelectedUsers, ? super Throwable, Unit> function2, boolean z, Context context, boolean z2, InternalFriendsParams internalFriendsParams) {
        super(1);
        this.f603a = function2;
        this.f604b = z;
        this.f605c = context;
        this.f606d = z2;
        this.f607e = internalFriendsParams;
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
            this.f603a.invoke(null, th2);
        } else {
            if (C2171d.f794j == null) {
                C2171d.f794j = new C2171d();
            }
            C2171d c2171d2 = C2171d.f794j;
            Intrinsics.checkNotNull(c2171d2);
            boolean z = this.f606d;
            boolean z2 = this.f604b;
            InternalFriendsParams internalFriendsParams = this.f607e;
            Function2<SelectedUsers, Throwable, Unit> callback = this.f603a;
            c2171d2.f795a = z;
            c2171d2.f796b = z2;
            c2171d2.f798d = internalFriendsParams;
            c2171d2.f797c = C2193i.m550a(internalFriendsParams);
            Intrinsics.checkNotNullParameter("Friend Picker", "message");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ResultReceiverC2118h resultReceiverC2118h = new ResultReceiverC2118h("Friend Picker");
            resultReceiverC2118h.setEmitter(callback);
            c2171d2.f802h = resultReceiverC2118h;
            Intent addFlags = new Intent(this.f605c, (Class<?>) (this.f604b ? PopupPickerActivity.class : FullPickerActivity.class)).addFlags(DriveFile.MODE_READ_ONLY);
            Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(context, activity…t.FLAG_ACTIVITY_NEW_TASK)");
            this.f605c.startActivity(addFlags);
        }
        return Unit.INSTANCE;
    }
}
