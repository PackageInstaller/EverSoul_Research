package com.kakao.sdk.friend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m839d2 = {"Lcom/kakao/sdk/friend/view/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "child", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class NestedScrollableHost extends FrameLayout {

    /* renamed from: a */
    public int f995a;

    /* renamed from: b */
    public float f996b;

    /* renamed from: c */
    public float f997c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NestedScrollableHost(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f995a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f995a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        r0 = (android.view.View) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if ((r0 instanceof androidx.viewpager2.widget.ViewPager2) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        return (androidx.viewpager2.widget.ViewPager2) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x000b, code lost:
    
        r0 = (android.view.View) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0007, code lost:
    
        if ((r0 instanceof android.view.View) != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if ((r0 instanceof androidx.viewpager2.widget.ViewPager2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
    
        r0 = r0.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if ((r0 instanceof android.view.View) == false) goto L18;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0017 -> B:3:0x000a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.viewpager2.widget.ViewPager2 getParentViewPager() {
        /*
            r3 = this;
            android.view.ViewParent r0 = r3.getParent()
            boolean r1 = r0 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto La
            goto L19
        La:
            r0 = r2
        Lb:
            if (r0 == 0) goto L1c
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 != 0) goto L1c
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto La
        L19:
            android.view.View r0 = (android.view.View) r0
            goto Lb
        L1c:
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L23
            r2 = r0
            androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
        L23:
            return r2
            fill-array 0x0024: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.view.NestedScrollableHost.getParentViewPager():androidx.viewpager2.widget.ViewPager2");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final boolean m678a(int i, float f) {
        int i2 = -((int) Math.signum(f));
        if (i == 0) {
            View child = getChild();
            if (child != null) {
                return child.canScrollHorizontally(i2);
            }
        } else {
            if (i != 1) {
                throw new IllegalArgumentException();
            }
            View child2 = getChild();
            if (child2 != null) {
                return child2.canScrollVertically(i2);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        if (m678a(r0, r1) != false) goto L16;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            androidx.viewpager2.widget.ViewPager2 r0 = r10.getParentViewPager()
            if (r0 != 0) goto Ld
            r0 = 0
            goto L15
        Ld:
            int r0 = r0.getOrientation()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L15:
            if (r0 != 0) goto L19
            goto La2
        L19:
            int r0 = r0.intValue()
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            boolean r1 = r10.m678a(r0, r1)
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 != 0) goto L2f
            boolean r1 = r10.m678a(r0, r2)
            if (r1 != 0) goto L2f
            goto La2
        L2f:
            int r1 = r11.getAction()
            r3 = 1
            if (r1 != 0) goto L4b
            float r0 = r11.getX()
            r10.f996b = r0
            float r0 = r11.getY()
            r10.f997c = r0
        L42:
            android.view.ViewParent r0 = r10.getParent()
            r0.requestDisallowInterceptTouchEvent(r3)
            goto La2
        L4b:
            int r1 = r11.getAction()
            r4 = 2
            if (r1 != r4) goto La2
            float r1 = r11.getX()
            float r4 = r10.f996b
            float r1 = r1 - r4
            float r4 = r11.getY()
            float r5 = r10.f997c
            float r4 = r4 - r5
            r5 = 0
            if (r0 != 0) goto L65
            r6 = r3
            goto L66
        L65:
            r6 = r5
        L66:
            float r7 = java.lang.Math.abs(r1)
            r8 = 1056964608(0x3f000000, float:0.5)
            if (r6 == 0) goto L70
            r9 = r8
            goto L71
        L70:
            r9 = r2
        L71:
            float r7 = r7 * r9
            float r9 = java.lang.Math.abs(r4)
            if (r6 == 0) goto L79
            goto L7a
        L79:
            r2 = r8
        L7a:
            float r9 = r9 * r2
            int r2 = r10.f995a
            float r2 = (float) r2
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 > 0) goto L86
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 <= 0) goto La2
        L86:
            int r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r2 <= 0) goto L8c
            r2 = r3
            goto L8d
        L8c:
            r2 = r5
        L8d:
            if (r6 != r2) goto L90
            goto L9b
        L90:
            if (r6 == 0) goto L93
            goto L94
        L93:
            r1 = r4
        L94:
            boolean r0 = r10.m678a(r0, r1)
            if (r0 == 0) goto L9b
            goto L42
        L9b:
            android.view.ViewParent r0 = r10.getParent()
            r0.requestDisallowInterceptTouchEvent(r5)
        La2:
            boolean r11 = super.onInterceptTouchEvent(r11)
            return r11
            fill-array 0x00a8: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.view.NestedScrollableHost.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
