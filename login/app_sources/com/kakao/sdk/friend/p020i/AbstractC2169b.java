package com.kakao.sdk.friend.p020i;

import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.p023l.InterfaceC2186b;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.i.b */
/* loaded from: classes3.dex */
public abstract class AbstractC2169b extends AbstractC2170c {

    /* renamed from: com.kakao.sdk.friend.i.b$a */
    public static final class a extends AbstractC2169b implements InterfaceC2186b {

        /* renamed from: a */
        public final Long f781a;

        /* renamed from: b */
        public final String f782b;

        /* renamed from: c */
        public final String f783c;

        /* renamed from: d */
        public final String f784d;

        /* renamed from: e */
        public final List<DisableSelectOption> f785e;

        /* renamed from: f */
        public final Boolean f786f;

        /* renamed from: g */
        public boolean f787g;

        /* renamed from: h */
        public final boolean f788h;

        /* renamed from: i */
        public final Boolean f789i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a(Long l, String uuid, String str, String str2, List<DisableSelectOption> list, Boolean bool, boolean z, boolean z2, Boolean bool2) {
            super(null);
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            this.f781a = l;
            this.f782b = uuid;
            this.f783c = str;
            this.f784d = str2;
            this.f785e = list;
            this.f786f = bool;
            this.f787g = z;
            this.f788h = z2;
            this.f789i = bool2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ a(Long l, String str, String str2, String str3, List list, Boolean bool, boolean z, boolean z2, Boolean bool2, int i) {
            this(l, str, str2, str3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? false : z, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? Boolean.TRUE : bool2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakao.sdk.friend.p023l.InterfaceC2186b
        /* renamed from: a */
        public String mo521a() {
            String str = this.f783c;
            return str == null ? "" : str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            return obj instanceof a ? Intrinsics.areEqual(this.f782b, ((a) obj).f782b) : super.equals(obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return super.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "User(id=" + this.f781a + ", uuid=" + this.f782b + ", nickname=" + ((Object) this.f783c) + ", profileImageUrl=" + ((Object) this.f784d) + ", disableSelectOptions=" + this.f785e + ", favorite=" + this.f786f + ", isChecked=" + this.f787g + ", isStoryFriendOnly=" + this.f788h + ", appRegistered=" + this.f789i + ')';
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AbstractC2169b() {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AbstractC2169b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
