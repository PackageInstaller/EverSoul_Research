package com.kakaogame.p029ui.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.liapp.y;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotoSansButton.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/ui/font/NotoSansButton;", "Landroid/widget/Button;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class NotoSansButton extends Button {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotoSansButton(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        String str = y.ݮڮֲڭܩ(-628605804);
        Typeface createFromFile = new File(str).exists() ? Typeface.createFromFile(str) : null;
        if (createFromFile != null) {
            setTypeface(createFromFile);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotoSansButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(attributeSet, y.ݬֲ֮ܲت(1512069847));
        Typeface createFromFile = new File("/system/fonts/NotoSansCJK-Regular.ttc").exists() ? Typeface.createFromFile("/system/fonts/NotoSansCJK-Regular.ttc") : null;
        if (createFromFile != null) {
            setTypeface(createFromFile);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NotoSansButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(attributeSet, y.ݬֲ֮ܲت(1512069847));
        Typeface createFromFile = new File("/system/fonts/NotoSansCJK-Regular.ttc").exists() ? Typeface.createFromFile("/system/fonts/NotoSansCJK-Regular.ttc") : null;
        if (createFromFile != null) {
            setTypeface(createFromFile);
        }
    }
}
