package com.kakao.sdk.friend.p020i;

import com.kakao.sdk.friend.model.PickerChatType;
import com.kakao.sdk.friend.p023l.InterfaceC2186b;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* renamed from: com.kakao.sdk.friend.i.a */
/* loaded from: classes3.dex */
public abstract class AbstractC2168a extends AbstractC2170c {

    /* renamed from: com.kakao.sdk.friend.i.a$a */
    public static final class a extends AbstractC2168a implements InterfaceC2186b {

        /* renamed from: a */
        public final long f772a;

        /* renamed from: b */
        public final String f773b;

        /* renamed from: c */
        public final String f774c;

        /* renamed from: d */
        public final String f775d;

        /* renamed from: e */
        public final Integer f776e;

        /* renamed from: f */
        public final List<String> f777f;

        /* renamed from: g */
        public PickerChatType f778g;

        /* renamed from: h */
        public boolean f779h;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a(long j, String str, String str2, String str3, Integer num, List<String> list, PickerChatType pickerChatType, boolean z) {
            super(null);
            this.f772a = j;
            this.f773b = str;
            this.f774c = str2;
            this.f775d = str3;
            this.f776e = num;
            this.f777f = list;
            this.f778g = pickerChatType;
            this.f779h = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakao.sdk.friend.p023l.InterfaceC2186b
        /* renamed from: a */
        public String mo521a() {
            String str = this.f773b;
            return str == null ? "" : str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            return obj instanceof a ? this.f772a == ((a) obj).f772a : super.equals(obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return super.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "Chat(id=" + this.f772a + ", title=" + ((Object) this.f773b) + ", titleSource=" + ((Object) this.f774c) + ", imageUrl=" + ((Object) this.f775d) + ", memberCount=" + this.f776e + ", displayMemberImages=" + this.f777f + ", chatType=" + this.f778g + ", isChecked=" + this.f779h + ')';
        }
    }

    /* renamed from: com.kakao.sdk.friend.i.a$b */
    public static final class b extends AbstractC2168a {

        /* renamed from: a */
        public boolean f780a;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b() {
            this(false, 1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b(boolean z) {
            super(null);
            this.f780a = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ b(boolean z, int i) {
            this((i & 1) != 0 ? false : z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f780a == ((b) obj).f780a;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            boolean z = this.f780a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "SelectAll(isChecked=" + this.f780a + ')';
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AbstractC2168a() {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AbstractC2168a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
