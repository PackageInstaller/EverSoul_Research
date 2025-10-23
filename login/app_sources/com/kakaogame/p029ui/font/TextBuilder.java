package com.kakaogame.p029ui.font;

import com.liapp.y;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StyleText.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\u0003\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\r0\fJ\u0014\u0010\u0007\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/ui/font/TextBuilder;", "", "()V", "styles", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "text", "build", "Lcom/kakaogame/ui/font/Text;", "", "lambda", "Lkotlin/Function0;", "", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TextBuilder {
    private String text = "";
    private final ArrayList<String> styles = new ArrayList<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void text(Function0<String> lambda) {
        Intrinsics.checkNotNullParameter(lambda, y.ݮڮֲڭܩ(-628275732));
        this.text = lambda.invoke();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean styles(Function0<String[]> lambda) {
        Intrinsics.checkNotNullParameter(lambda, y.ݮڮֲڭܩ(-628275732));
        return CollectionsKt.addAll(this.styles, lambda.invoke());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Text build() {
        return new Text(this.text, this.styles);
    }
}
