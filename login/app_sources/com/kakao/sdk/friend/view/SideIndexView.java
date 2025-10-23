package com.kakao.sdk.friend.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p023l.C2188d;
import com.kakao.sdk.friend.p023l.C2194j;
import com.kakao.sdk.friend.p023l.C2197m;
import com.kakao.sdk.friend.p023l.InterfaceC2186b;
import com.kakao.sdk.friend.p024m.AbstractRunnableC2219v;
import com.kakao.sdk.friend.view.SideIndexView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(m837bv = {}, m838d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%B\u001b\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b$\u0010(B#\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b$\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010!\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006.²\u0006\u0012\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00180,8\nX\u008a\u0084\u0002"}, m839d2 = {"Lcom/kakao/sdk/friend/view/SideIndexView;", "Landroid/view/View;", "", "orientation", "", "setIternalIndexItems", "visibility", "setVisibility", "Landroidx/recyclerview/widget/RecyclerView;", "A", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "", "B", "Z", "isEnabledSideIndex", "()Z", "setEnabledSideIndex", "(Z)V", "Ljava/util/Comparator;", "", "D", "Lkotlin/Lazy;", "getSideIndexerOldComparator", "()Ljava/util/Comparator;", "sideIndexerOldComparator", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getOnScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "Ljava/util/TreeSet;", "alphabetIndexSet", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class SideIndexView extends View {

    /* renamed from: A, reason: from kotlin metadata */
    public RecyclerView recyclerView;

    /* renamed from: B, reason: from kotlin metadata */
    public boolean isEnabledSideIndex;

    /* renamed from: C */
    public final Comparator<String> f1000C;

    /* renamed from: D, reason: from kotlin metadata */
    public final Lazy sideIndexerOldComparator;

    /* renamed from: E */
    public final C2238d f1002E;

    /* renamed from: a */
    public final ArrayList<String> f1003a;

    /* renamed from: b */
    public String[] f1004b;

    /* renamed from: c */
    public String[] f1005c;

    /* renamed from: d */
    public int f1006d;

    /* renamed from: e */
    public float f1007e;

    /* renamed from: f */
    public final Paint f1008f;

    /* renamed from: g */
    public int f1009g;

    /* renamed from: h */
    public float f1010h;

    /* renamed from: i */
    public float f1011i;

    /* renamed from: j */
    public float f1012j;

    /* renamed from: k */
    public float f1013k;

    /* renamed from: l */
    public float f1014l;

    /* renamed from: m */
    public float f1015m;

    /* renamed from: n */
    public Drawable f1016n;

    /* renamed from: o */
    public boolean f1017o;

    /* renamed from: p */
    public TreeMap<String, Integer> f1018p;

    /* renamed from: q */
    public int f1019q;

    /* renamed from: r */
    public int f1020r;

    /* renamed from: s */
    public int f1021s;

    /* renamed from: t */
    public int f1022t;

    /* renamed from: u */
    public boolean f1023u;

    /* renamed from: v */
    public boolean f1024v;

    /* renamed from: w */
    public boolean f1025w;

    /* renamed from: x */
    public final C2235a f1026x;

    /* renamed from: y */
    public TextView f1027y;

    /* renamed from: z */
    public ImageView f1028z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SideIndexView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SideIndexView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SideIndexView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1003a = new ArrayList<>();
        this.f1006d = -1;
        this.f1007e = -1.0f;
        Paint paint = new Paint();
        this.f1008f = paint;
        this.f1009g = -7829368;
        this.f1019q = -1;
        this.f1020r = -1;
        this.f1026x = new C2235a(this);
        this.isEnabledSideIndex = true;
        this.f1000C = new Comparator() { // from class: com.kakao.sdk.friend.view.SideIndexView$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SideIndexView.m679a((String) obj, (String) obj2);
            }
        };
        this.sideIndexerOldComparator = LazyKt.lazy(C2237c.f1032a);
        this.f1002E = new C2238d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2110R.styleable.SideIndexView);
        this.f1009g = obtainStyledAttributes.getColor(C2110R.styleable.SideIndexView_sideindex_text_color, -7829368);
        this.f1010h = obtainStyledAttributes.getDimension(C2110R.styleable.SideIndexView_sideindex_text_size, m680a(context, 2, 12.0f));
        obtainStyledAttributes.recycle();
        paint.setAntiAlias(true);
        paint.setColor(this.f1009g);
        paint.setTextSize(this.f1010h);
        paint.setTextAlign(Paint.Align.CENTER);
        try {
            paint.setTypeface(Typeface.SANS_SERIF);
        } catch (Exception unused) {
        }
        Resources resources = getResources();
        String[] stringArray = resources.getStringArray(C2110R.array.side_indexer_landscape);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(R.array.side_indexer_landscape)");
        this.f1005c = stringArray;
        String[] stringArray2 = resources.getStringArray(C2110R.array.side_indexer);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(R.array.side_indexer)");
        this.f1004b = stringArray2;
        Drawable drawable = ContextCompat.getDrawable(context, C2110R.drawable.kakao_sdk_list_index_ico_favorite);
        if (drawable == null) {
            drawable = null;
        } else {
            m681a(drawable, ContextCompat.getColor(context, C2110R.color.daynight_gray600s));
        }
        this.f1016n = drawable;
        setIternalIndexItems(resources.getConfiguration().orientation);
        AbstractRunnableC2219v.m594a(this.f1002E, context, C2110R.layout.kakao_sdk_side_index_single_toast_layout, 0, 0, 12, null);
        this.f1027y = (TextView) this.f1002E.m595a(C2110R.id.toast_tv);
        this.f1028z = (ImageView) this.f1002E.m595a(C2110R.id.toast_iv);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Comparator<String> getSideIndexerOldComparator() {
        return (Comparator) this.sideIndexerOldComparator.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setIternalIndexItems(int orientation) {
        this.f1003a.clear();
        if (this.f1019q != -1) {
            this.f1003a.add("!");
        }
        int i = 0;
        if (orientation == 1) {
            String[] strArr = this.f1004b;
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                i++;
                this.f1003a.add(str);
            }
            return;
        }
        String[] strArr2 = this.f1005c;
        int length2 = strArr2.length;
        while (i < length2) {
            String str2 = strArr2[i];
            i++;
            this.f1003a.add(str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final int m680a(Context context, int i, float f) {
        return (int) TypedValue.applyDimension(i, f, context.getResources().getDisplayMetrics());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Drawable m681a(Drawable drawable, int i) {
        Drawable wrapped = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrapped.mutate(), i);
        Intrinsics.checkNotNullExpressionValue(wrapped, "wrapped");
        return wrapped;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m683a(int i, int i2) {
        String[] stringArray = getContext().getResources().getStringArray(i);
        Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources.getStringArray(sideIndexRes)");
        this.f1004b = stringArray;
        String[] stringArray2 = getContext().getResources().getStringArray(i2);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "context.resources.getStr…ay(sideLandscapeIndexRes)");
        this.f1005c = stringArray2;
        setIternalIndexItems(getContext().getResources().getConfiguration().orientation);
        requestLayout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m684a(List<? extends AbstractC2169b> friendList, int i, int i2, int i3) {
        TreeMap<String, Integer> m682a;
        Intrinsics.checkNotNullParameter(friendList, "friendList");
        this.f1022t = friendList.size();
        this.f1021s = i;
        this.f1019q = i2;
        this.f1020r = i3;
        try {
            m682a = m682a(friendList, this.f1000C);
        } catch (Exception unused) {
            m682a = m682a(friendList, getSideIndexerOldComparator());
        }
        this.f1018p = m682a;
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final boolean m685a() {
        RecyclerView recyclerView = this.recyclerView;
        return recyclerView != null && recyclerView.computeVerticalScrollExtent() < recyclerView.computeVerticalScrollRange();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final RecyclerView.OnScrollListener getOnScrollListener() {
        return this.f1026x;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Paint.FontMetrics fontMetrics = this.f1008f.getFontMetrics();
        float paddingTop = (size - getPaddingTop()) - getPaddingBottom();
        this.f1011i = paddingTop;
        this.f1013k = paddingTop / this.f1003a.size();
        Iterator<String> it = this.f1003a.iterator();
        while (it.hasNext()) {
            this.f1012j = Math.max(this.f1012j, this.f1008f.measureText(it.next()));
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (this.f1012j + getPaddingLeft() + getPaddingRight()), 1073741824), i2);
        float f = size - this.f1011i;
        float f2 = 2;
        float f3 = this.f1013k / f2;
        float f4 = fontMetrics.descent;
        float f5 = fontMetrics.ascent;
        this.f1014l = ((f / f2) + (f3 - ((f4 - f5) / f2))) - f5;
        this.f1015m = getPaddingTop() + ((this.f1013k / f2) - ((fontMetrics.descent - fontMetrics.ascent) / f2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setEnabledSideIndex(boolean z) {
        this.isEnabledSideIndex = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    /* renamed from: com.kakao.sdk.friend.view.SideIndexView$a */
    public final class C2235a extends RecyclerView.OnScrollListener {

        /* renamed from: a */
        public int f1029a;

        /* renamed from: b */
        public final /* synthetic */ SideIndexView f1030b;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public C2235a(SideIndexView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f1030b = this$0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: a */
        public static final void m686a(SideIndexView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.f1025w) {
                return;
            }
            this$0.f1024v = false;
            if (this$0.getVisibility() >= 4) {
                return;
            }
            this$0.setVisibility(4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            SideIndexView sideIndexView = this.f1030b;
            if (!sideIndexView.isEnabledSideIndex || sideIndexView.m685a() || this.f1030b.f1024v) {
                if (i == 0) {
                    final SideIndexView sideIndexView2 = this.f1030b;
                    if (sideIndexView2.f1024v && !sideIndexView2.f1025w) {
                        sideIndexView2.postDelayed(new Runnable() { // from class: com.kakao.sdk.friend.view.SideIndexView$a$$ExternalSyntheticLambda0
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                SideIndexView.C2235a.m686a(SideIndexView.this);
                            }
                        }, 1000L);
                    }
                } else if (i == 1 || i == 2) {
                    SideIndexView sideIndexView3 = this.f1030b;
                    if (!sideIndexView3.f1024v && this.f1029a != i && sideIndexView3.f1022t > 0) {
                        sideIndexView3.f1024v = true;
                        sideIndexView3.setVisibility(0);
                    }
                }
                this.f1029a = i;
            }
        }
    }

    /* renamed from: com.kakao.sdk.friend.view.SideIndexView$b */
    public static final class C2236b extends Lambda implements Function0<TreeSet<String>> {

        /* renamed from: a */
        public final /* synthetic */ Comparator<String> f1031a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public C2236b(Comparator<String> comparator) {
            super(0);
            this.f1031a = comparator;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public TreeSet<String> invoke() {
            TreeSet<String> treeSet = new TreeSet<>(this.f1031a);
            for (char c = 'a'; c < '{'; c = (char) (c + 1)) {
                treeSet.add(String.valueOf(c));
            }
            return treeSet;
        }
    }

    /* renamed from: com.kakao.sdk.friend.view.SideIndexView$c */
    public static final class C2237c extends Lambda implements Function0<Comparator<String>> {

        /* renamed from: a */
        public static final C2237c f1032a = new C2237c();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public C2237c() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Comparator<String> invoke() {
            return new Comparator() { // from class: com.kakao.sdk.friend.view.SideIndexView$c$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SideIndexView.C2237c.m687a((String) obj, (String) obj2);
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: a */
        public static final int m687a(String str, String str2) {
            C2188d c2188d = C2188d.f843a;
            return C2188d.f845c.m547a(str, str2);
        }
    }

    /* renamed from: com.kakao.sdk.friend.view.SideIndexView$d */
    public static final class C2238d extends AbstractRunnableC2219v {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public C2238d() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakao.sdk.friend.p024m.AbstractRunnableC2219v
        /* renamed from: a */
        public void mo596a() {
            SideIndexView sideIndexView = SideIndexView.this;
            if (sideIndexView.f1023u) {
                sideIndexView.f1023u = false;
                sideIndexView.f1025w = false;
                m597b(4);
                SideIndexView sideIndexView2 = SideIndexView.this;
                C2235a c2235a = sideIndexView2.f1026x;
                RecyclerView recyclerView = sideIndexView2.getRecyclerView();
                Intrinsics.checkNotNull(recyclerView);
                c2235a.onScrollStateChanged(recyclerView, 0);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final TreeMap<String, Integer> m682a(List<? extends AbstractC2169b> list, Comparator<String> comparator) {
        char c;
        String upperCase;
        Lazy lazy = LazyKt.lazy(new C2236b(comparator));
        TreeMap<String, Integer> treeMap = new TreeMap<>(comparator);
        int size = list.size();
        int i = 0;
        char c2 = 0;
        while (i < size) {
            int i2 = i + 1;
            Object obj = (AbstractC2169b) list.get(i);
            if (obj instanceof InterfaceC2186b) {
                String mo521a = ((InterfaceC2186b) obj).mo521a();
                Intrinsics.checkNotNullParameter(mo521a, "<this>");
                char[] cArr = C2197m.f859a;
                c = C2194j.m552a(StringsKt.trim(mo521a, Arrays.copyOf(cArr, cArr.length)));
            } else {
                c = c2;
            }
            if (c2 != c) {
                String valueOf = String.valueOf(c);
                if (valueOf.length() <= 1) {
                    int m561e = C2194j.f850a.m561e(c);
                    if (m561e != 3) {
                        if (m561e == 9) {
                            upperCase = "#";
                        }
                        C2188d c2188d = C2188d.f843a;
                        upperCase = valueOf.toUpperCase(C2188d.f844b.f834a.mo542b());
                        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    } else {
                        try {
                            Object floor = ((TreeSet) lazy.getValue()).floor(String.valueOf(c));
                            Intrinsics.checkNotNullExpressionValue(floor, "alphabetIndexSet.floor(curChar.toString())");
                            Locale ENGLISH = Locale.ENGLISH;
                            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                            upperCase = ((String) floor).toUpperCase(ENGLISH);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                        } catch (Exception unused) {
                        }
                    }
                    if (!treeMap.containsKey(upperCase)) {
                        treeMap.put(upperCase, Integer.valueOf(i));
                    }
                    i = i2;
                    c2 = c;
                }
            }
            i = i2;
        }
        return treeMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C2238d c2238d = this.f1002E;
        c2238d.getClass();
        try {
            WindowManager windowManager = c2238d.f908b;
            Intrinsics.checkNotNull(windowManager);
            View view = c2238d.f909c;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogPosition");
                view = null;
            }
            windowManager.removeViewImmediate(view);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int size = this.f1003a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                Paint paint = this.f1008f;
                paint.setAlpha(255);
                paint.setTextSize(this.f1010h);
                return;
            }
            int i2 = i + 1;
            float f = this.f1014l;
            float f2 = this.f1013k;
            float f3 = i;
            float f4 = f2 * f3;
            float f5 = f + f4;
            float f6 = 0.0f;
            if (this.f1006d != -1) {
                float abs = Math.abs(this.f1007e - (f4 + (f2 / 2))) / this.f1013k;
                f6 = Math.max(1 - ((abs * abs) / 16), 0.0f);
            }
            Paint paint2 = this.f1008f;
            paint2.setAlpha(i != this.f1006d ? (int) (255 * (1 - f6)) : 255);
            float f7 = this.f1010h;
            paint2.setTextSize(f7 + (f6 * f7 * 0.5f));
            float paddingLeft = getPaddingLeft() + (this.f1012j / 2);
            if (Intrinsics.areEqual(this.f1003a.get(i), "!")) {
                Drawable drawable = this.f1016n;
                if (drawable != null) {
                    int i3 = (int) (this.f1015m + (this.f1013k * f3));
                    int paddingLeft2 = getPaddingLeft();
                    int paddingLeft3 = getPaddingLeft();
                    int i4 = (int) this.f1012j;
                    drawable.setBounds(paddingLeft2, i3, paddingLeft3 + i4, i4 + i3);
                    drawable.draw(canvas);
                }
            } else {
                canvas.drawText(this.f1003a.get(i), paddingLeft, f5, this.f1008f);
            }
            i = i2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:68:0x00a7
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cd  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.view.SideIndexView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setVisibility(int r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L12
            r0 = 4
            if (r3 == r0) goto Lb
            r0 = 8
            if (r3 == r0) goto Lb
            r0 = 0
            goto L1c
        Lb:
            android.content.Context r0 = r2.getContext()
            int r1 = com.kakao.sdk.friend.C2110R.anim.kakao_sdk_fade_out_short
            goto L18
        L12:
            android.content.Context r0 = r2.getContext()
            int r1 = com.kakao.sdk.friend.C2110R.anim.kakao_sdk_fade_in_short
        L18:
            android.view.animation.Animation r0 = android.view.animation.AnimationUtils.loadAnimation(r0, r1)
        L1c:
            r2.setAnimation(r0)
            r2.startAnimation(r0)
            if (r3 == 0) goto L27
            r0 = -1
            r2.f1006d = r0
        L27:
            super.setVisibility(r3)
            return
            fill-array 0x002c: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.view.SideIndexView.setVisibility(int):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final int m679a(String lhs, String rhs) {
        C2188d c2188d = C2188d.f843a;
        Intrinsics.checkNotNullExpressionValue(lhs, "lhs");
        Intrinsics.checkNotNullParameter(lhs, "<this>");
        char[] cArr = C2197m.f859a;
        String trim = StringsKt.trim(lhs, Arrays.copyOf(cArr, cArr.length));
        Intrinsics.checkNotNullExpressionValue(rhs, "rhs");
        Intrinsics.checkNotNullParameter(rhs, "<this>");
        char[] cArr2 = C2197m.f859a;
        return C2188d.f844b.m538a(trim, StringsKt.trim(rhs, Arrays.copyOf(cArr2, cArr2.length)));
    }
}
