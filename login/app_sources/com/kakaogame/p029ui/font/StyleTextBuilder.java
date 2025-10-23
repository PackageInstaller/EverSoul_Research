package com.kakaogame.p029ui.font;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kakaogame.util.json.JSONArray;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StyleText.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u001f\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/ui/font/StyleTextBuilder;", "", "()V", "textArray", "Lcom/kakaogame/util/json/JSONArray;", "build", TypedValues.Custom.S_STRING, "", "lambda", "Lkotlin/Function1;", "Lcom/kakaogame/ui/font/TextBuilder;", "", "Lkotlin/ExtensionFunctionType;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class StyleTextBuilder {
    private final JSONArray textArray = new JSONArray();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean string(Function1<? super TextBuilder, Unit> lambda) {
        Intrinsics.checkNotNullParameter(lambda, y.ݮڮֲڭܩ(-628275732));
        JSONArray jSONArray = this.textArray;
        TextBuilder textBuilder = new TextBuilder();
        lambda.invoke(textBuilder);
        return jSONArray.add(textBuilder.build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONArray build() {
        return this.textArray;
    }
}
