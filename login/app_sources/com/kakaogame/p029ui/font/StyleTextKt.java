package com.kakaogame.p029ui.font;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.view.ViewCompat;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StyleText.kt */
@Metadata(m838d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\n\u0010\n\u001a\u00020\b*\u00020\u0001¨\u0006\u000b"}, m839d2 = {"styleText", "Lcom/kakaogame/util/json/JSONArray;", "lambda", "Lkotlin/Function1;", "Lcom/kakaogame/ui/font/StyleTextBuilder;", "", "Lkotlin/ExtensionFunctionType;", "getBoldText", "Landroid/text/SpannableStringBuilder;", "", "getString", "common-kakaogames_release"}, m840k = 2, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class StyleTextKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final JSONArray styleText(Function1<? super StyleTextBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, y.ݮڮֲڭܩ(-628275732));
        StyleTextBuilder styleTextBuilder = new StyleTextBuilder();
        function1.invoke(styleTextBuilder);
        return styleTextBuilder.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final SpannableStringBuilder getBoldText(final String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(575694806));
        return getString(styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.ui.font.StyleTextKt$getBoldText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StyleTextBuilder styleTextBuilder) {
                invoke2(styleTextBuilder);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StyleTextBuilder styleTextBuilder) {
                Intrinsics.checkNotNullParameter(styleTextBuilder, y.ٴسسݬߨ(1393323090));
                final String str2 = str;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.ui.font.StyleTextKt$getBoldText$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextBuilder textBuilder) {
                        invoke2(textBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextBuilder textBuilder) {
                        Intrinsics.checkNotNullParameter(textBuilder, y.ݬֲ֮ܲت(1512388847));
                        final String str3 = str2;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.ui.font.StyleTextKt.getBoldText.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return str3;
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.ui.font.StyleTextKt.getBoldText.1.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.٬ݯح׭٩(576694694)};
                            }
                        });
                    }
                });
            }
        }));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final SpannableStringBuilder getString(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, y.٬ݯح׭٩(575694806));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Object obj : jSONArray) {
            Intrinsics.checkNotNull(obj, y.ݮڮֲڭܩ(-628332684));
            JSONObject jSONObject = (JSONObject) obj;
            String str = (String) jSONObject.get((Object) y.ٲٴݴ״ٰ(1782384304));
            if (str == null) {
                str = "";
            }
            String str2 = str;
            if (str2.length() > 0) {
                SpannableString spannableString = new SpannableString(str2);
                Object obj2 = jSONObject.get((Object) y.ٲٴݴ״ٰ(1782345448));
                Intrinsics.checkNotNull(obj2, y.֬ڱܱײٮ(-1158924303));
                for (Object obj3 : (JSONArray) obj2) {
                    if (Intrinsics.areEqual(obj3, y.֬ڱܱײٮ(-1158918439))) {
                        spannableString.setSpan(new ForegroundColorSpan(-112568), 0, spannableString.length(), 33);
                    } else if (Intrinsics.areEqual(obj3, y.ۮڭڭܬި(862788355))) {
                        spannableString.setSpan(new ForegroundColorSpan(-11103000), 0, spannableString.length(), 33);
                    } else if (Intrinsics.areEqual(obj3, y.دײܮڳܯ(2051597077))) {
                        spannableString.setSpan(new ForegroundColorSpan(ViewCompat.MEASURED_STATE_MASK), 0, spannableString.length(), 33);
                    } else if (Intrinsics.areEqual(obj3, y.٬ݯح׭٩(576694694))) {
                        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                    } else if (Intrinsics.areEqual(obj3, y.٬ݯح׭٩(576430542))) {
                        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
                    } else if (Intrinsics.areEqual(obj3, y.֬ڱܱײٮ(-1159186295))) {
                        spannableString.setSpan(new RelativeSizeSpan(1.2f), 0, spannableString.length(), 33);
                    }
                }
                spannableStringBuilder.append((CharSequence) spannableString);
            }
        }
        return spannableStringBuilder;
    }
}
