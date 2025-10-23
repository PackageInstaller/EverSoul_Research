package com.kakao.sdk.friend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.kakao.sdk.friend.C2110R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, m839d2 = {"Lcom/kakao/sdk/friend/view/EmptyView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "message", "", "setErrorMessage", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class EmptyView extends ConstraintLayout {

    /* renamed from: a */
    public ImageView f993a;

    /* renamed from: b */
    public TextView f994b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EmptyView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        m677a(context2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        m677a(context2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EmptyView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        m677a(context2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m677a(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        View inflate = ((LayoutInflater) systemService).inflate(C2110R.layout.kakao_sdk_empty_friend_view, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(C2110R.id.empty_friend_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.empty_friend_image)");
        this.f993a = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(C2110R.id.empty_friend_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.empty_friend_text)");
        this.f994b = (TextView) findViewById2;
        if (inflate.getResources().getConfiguration().orientation != 1) {
            ImageView imageView = this.f993a;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyImage");
                imageView = null;
            }
            imageView.setVisibility(8);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setErrorMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        TextView textView = this.f994b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyMessage");
            textView = null;
        }
        textView.setText(message);
    }
}
