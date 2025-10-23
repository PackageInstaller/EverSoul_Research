package com.kakao.sdk.friend.p020i;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.i.c */
/* loaded from: classes3.dex */
public abstract class AbstractC2170c {

    /* renamed from: com.kakao.sdk.friend.i.c$a */
    public static final class a extends AbstractC2170c {

        /* renamed from: a */
        public static final a f790a = new a();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a() {
            super(null);
        }
    }

    /* renamed from: com.kakao.sdk.friend.i.c$b */
    public static final class b extends AbstractC2170c {

        /* renamed from: a */
        public static final b f791a = new b();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b() {
            super(null);
        }
    }

    /* renamed from: com.kakao.sdk.friend.i.c$c */
    public static final class c extends AbstractC2170c {

        /* renamed from: a */
        public final String f792a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public c(String title) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.f792a = title;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.f792a, ((c) obj).f792a);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.f792a.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "Header(title=" + this.f792a + ')';
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AbstractC2170c() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AbstractC2170c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
