package com.kakaogame.secondpw.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.kakaogame.security.databinding.KakaoGame2ndPwDisplayTextEditBinding;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordDisplayView.kt */
@Metadata(m838d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m839d2 = {"Lcom/kakaogame/secondpw/view/PasswordDisplayView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/kakaogame/security/databinding/KakaoGame2ndPwDisplayTextEditBinding;", "codelist", "", "", "displayCodeViews", "", "Lcom/kakaogame/secondpw/view/PasswordCodeDisplayView;", "getCode", "", "hasCode", "", "isFull", "removeAll", "", "removeCode", "setTitle", "title", "Landroid/text/SpannableStringBuilder;", "updateCode", "code", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PasswordDisplayView extends RelativeLayout {
    private final KakaoGame2ndPwDisplayTextEditBinding binding;
    private List<Character> codelist;
    private List<PasswordCodeDisplayView> displayCodeViews;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PasswordDisplayView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PasswordDisplayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PasswordDisplayView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PasswordDisplayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        KakaoGame2ndPwDisplayTextEditBinding inflate = KakaoGame2ndPwDisplayTextEditBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.codelist = new ArrayList();
        this.displayCodeViews = CollectionsKt.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTitle(SpannableStringBuilder title) {
        KakaoGame2ndPwDisplayTextEditBinding kakaoGame2ndPwDisplayTextEditBinding = this.binding;
        PasswordCodeDisplayView passwordCodeDisplayView = kakaoGame2ndPwDisplayTextEditBinding.displayCode1;
        Intrinsics.checkNotNullExpressionValue(passwordCodeDisplayView, y.ݬֲ֮ܲت(1512126367));
        PasswordCodeDisplayView passwordCodeDisplayView2 = kakaoGame2ndPwDisplayTextEditBinding.displayCode2;
        Intrinsics.checkNotNullExpressionValue(passwordCodeDisplayView2, y.֬ڱܱײٮ(-1159184055));
        PasswordCodeDisplayView passwordCodeDisplayView3 = kakaoGame2ndPwDisplayTextEditBinding.displayCode3;
        Intrinsics.checkNotNullExpressionValue(passwordCodeDisplayView3, y.ݬֲ֮ܲت(1512126335));
        PasswordCodeDisplayView passwordCodeDisplayView4 = kakaoGame2ndPwDisplayTextEditBinding.displayCode4;
        Intrinsics.checkNotNullExpressionValue(passwordCodeDisplayView4, y.ٲٴݴ״ٰ(1782383168));
        PasswordCodeDisplayView passwordCodeDisplayView5 = kakaoGame2ndPwDisplayTextEditBinding.displayCode5;
        Intrinsics.checkNotNullExpressionValue(passwordCodeDisplayView5, y.٬ݯح׭٩(576444918));
        PasswordCodeDisplayView passwordCodeDisplayView6 = kakaoGame2ndPwDisplayTextEditBinding.displayCode6;
        Intrinsics.checkNotNullExpressionValue(passwordCodeDisplayView6, y.ݬֲ֮ܲت(1512125871));
        this.displayCodeViews = CollectionsKt.listOf((Object[]) new PasswordCodeDisplayView[]{passwordCodeDisplayView, passwordCodeDisplayView2, passwordCodeDisplayView3, passwordCodeDisplayView4, passwordCodeDisplayView5, passwordCodeDisplayView6});
        if (title != null) {
            kakaoGame2ndPwDisplayTextEditBinding.pwInputTitle.setText(title);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasCode() {
        return this.codelist.size() > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isFull() {
        return this.codelist.size() == 6;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void updateCode(char code) {
        if (this.codelist.size() == 0) {
            this.binding.kakaoGame2ndPwCodeContentLine.setBackgroundColor(-335616);
        }
        if (this.codelist.size() < 6) {
            this.codelist.add(Character.valueOf(code));
            this.displayCodeViews.get(this.codelist.size() - 1).setCode(code);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removeCode() {
        if (this.codelist.size() > 0) {
            CollectionsKt.removeLast(this.codelist);
            this.displayCodeViews.get(this.codelist.size()).clear();
        }
        if (this.codelist.size() == 0) {
            this.binding.kakaoGame2ndPwCodeContentLine.setBackgroundColor(-1644826);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removeAll() {
        if (this.codelist.size() > 0) {
            this.codelist.clear();
            Iterator<T> it = this.displayCodeViews.iterator();
            while (it.hasNext()) {
                ((PasswordCodeDisplayView) it.next()).clear();
            }
        }
        this.binding.kakaoGame2ndPwCodeContentLine.setBackgroundColor(-1644826);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCode() {
        return new String(CollectionsKt.toCharArray(this.codelist));
    }
}
