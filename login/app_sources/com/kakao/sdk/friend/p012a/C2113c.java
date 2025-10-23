package com.kakao.sdk.friend.p012a;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.kakao.sdk.friend.internal.InternalChatParams;
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

/* renamed from: com.kakao.sdk.friend.a.c */
/* loaded from: classes3.dex */
public final class C2113c extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ Function3<SelectedUsers, SelectedChat, Throwable, Unit> f599a;

    /* renamed from: b */
    public final /* synthetic */ boolean f600b;

    /* renamed from: c */
    public final /* synthetic */ Context f601c;

    /* renamed from: d */
    public final /* synthetic */ InternalChatParams f602d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2113c(Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> function3, boolean z, Context context, InternalChatParams internalChatParams) {
        super(1);
        this.f599a = function3;
        this.f600b = z;
        this.f601c = context;
        this.f602d = internalChatParams;
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
            this.f599a.invoke(null, null, th2);
        } else {
            if (C2171d.f794j == null) {
                C2171d.f794j = new C2171d();
            }
            C2171d c2171d2 = C2171d.f794j;
            Intrinsics.checkNotNull(c2171d2);
            boolean z = this.f600b;
            InternalChatParams internalChatParams = this.f602d;
            Function3<SelectedUsers, SelectedChat, Throwable, Unit> callback = this.f599a;
            c2171d2.f796b = z;
            c2171d2.f799e = internalChatParams;
            c2171d2.f797c = C2193i.m550a(internalChatParams);
            Intrinsics.checkNotNullParameter("Chat Picker", "message");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ResultReceiverC2117g resultReceiverC2117g = new ResultReceiverC2117g("Chat Picker");
            resultReceiverC2117g.setEmitter(callback);
            c2171d2.f802h = resultReceiverC2117g;
            Intent addFlags = new Intent(this.f601c, (Class<?>) (this.f600b ? PopupPickerActivity.class : FullPickerActivity.class)).addFlags(DriveFile.MODE_READ_ONLY);
            Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(context, activity…t.FLAG_ACTIVITY_NEW_TASK)");
            this.f601c.startActivity(addFlags);
        }
        return Unit.INSTANCE;
    }
}
