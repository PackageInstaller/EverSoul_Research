package com.kakaogame.promotion.share;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.kakaogame.C2382R;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGAnimationButton.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/promotion/share/KGAnimationButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scaleAnim", "Landroid/view/animation/Animation;", "scaleReverseAnim", "initialize", "", "activity", "Landroid/app/Activity;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGAnimationButton extends FrameLayout {
    private Animation scaleAnim;
    private Animation scaleReverseAnim;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGAnimationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize(Activity activity) {
        Activity activity2 = activity;
        Animation loadAnimation = AnimationUtils.loadAnimation(activity2, C2382R.anim.zinny_sdk_scale_anim);
        String str = y.֬ڱܱײٮ(-1159154583);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, str);
        this.scaleAnim = loadAnimation;
        Animation loadAnimation2 = AnimationUtils.loadAnimation(activity2, C2382R.anim.zinny_sdk_scale_reverse_anim);
        Intrinsics.checkNotNullExpressionValue(loadAnimation2, str);
        this.scaleReverseAnim = loadAnimation2;
        setOnTouchListener(new View.OnTouchListener() { // from class: com.kakaogame.promotion.share.KGAnimationButton$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean initialize$lambda$0;
                initialize$lambda$0 = KGAnimationButton.initialize$lambda$0(KGAnimationButton.this, view, motionEvent);
                return initialize$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean initialize$lambda$0(final KGAnimationButton this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        String str = y.دײܮڳܯ(2051140237);
        Animation animation = null;
        if (action == 0) {
            Log.d(str, "Touch down");
            Animation animation2 = this$0.scaleAnim;
            if (animation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scaleAnim");
                animation2 = null;
            }
            this$0.startAnimation(animation2);
            Animation animation3 = this$0.scaleAnim;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scaleAnim");
            } else {
                animation = animation3;
            }
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.kakaogame.promotion.share.KGAnimationButton$initialize$1$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation4) {
                    Intrinsics.checkNotNullParameter(animation4, y.ٲٴݴ״ٰ(1781734280));
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation4) {
                    Intrinsics.checkNotNullParameter(animation4, y.ٲٴݴ״ٰ(1781734280));
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation4) {
                    Intrinsics.checkNotNullParameter(animation4, y.ٲٴݴ״ٰ(1781734280));
                    KGAnimationButton.this.setScaleX(0.9f);
                    KGAnimationButton.this.setScaleY(0.9f);
                }
            });
            return false;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        Log.d(str, "Touch up");
        Animation animation4 = this$0.scaleReverseAnim;
        if (animation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaleReverseAnim");
            animation4 = null;
        }
        this$0.startAnimation(animation4);
        Animation animation5 = this$0.scaleReverseAnim;
        if (animation5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaleReverseAnim");
        } else {
            animation = animation5;
        }
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.kakaogame.promotion.share.KGAnimationButton$initialize$1$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation6) {
                Intrinsics.checkNotNullParameter(animation6, y.ٲٴݴ״ٰ(1781734280));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation6) {
                Intrinsics.checkNotNullParameter(animation6, y.ٲٴݴ״ٰ(1781734280));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation6) {
                Intrinsics.checkNotNullParameter(animation6, y.ٲٴݴ״ٰ(1781734280));
                KGAnimationButton.this.setScaleX(1.0f);
                KGAnimationButton.this.setScaleY(1.0f);
            }
        });
        return false;
    }
}
