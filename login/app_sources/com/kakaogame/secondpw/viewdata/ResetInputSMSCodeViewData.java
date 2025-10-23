package com.kakaogame.secondpw.viewdata;

import android.app.Activity;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.p029ui.font.StyleTextBuilder;
import com.kakaogame.p029ui.font.StyleTextKt;
import com.kakaogame.p029ui.font.TextBuilder;
import com.kakaogame.secondpw.ActionType;
import com.kakaogame.secondpw.PasswordViewType;
import com.kakaogame.security.C2558R;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.json.JSONArray;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResetInputSMSCodeViewData.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/ResetInputSMSCodeViewData;", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "activity", "Landroid/app/Activity;", "maskingNumber", "", "timeLimit", "", "isRemove", "", "authType", "Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWAuthType;", "(Landroid/app/Activity;Ljava/lang/String;IZLcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWAuthType;)V", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ResetInputSMSCodeViewData extends Base2ndPWViewData {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ResetInputSMSCodeViewData(Activity activity, String str, int i, boolean z, InfodeskHelper.SecondaryPWAuthType secondaryPWAuthType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, i, (i2 & 8) != 0 ? false : z, secondaryPWAuthType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResetInputSMSCodeViewData(final Activity activity, final String str, final int i, boolean z, final InfodeskHelper.SecondaryPWAuthType secondaryPWAuthType) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1393059170));
        Intrinsics.checkNotNullParameter(secondaryPWAuthType, y.ۮڭڭܬި(862463915));
        put(y.ٲٴݴ״ٰ(1781623144), PasswordViewType.INPUT_CODE.getValue());
        String value = ActionType.EXIT.getValue();
        String str2 = y.֬ڱܱײٮ(-1159583711);
        put(y.ٴسسݬߨ(1393043586), MapsKt.mapOf(TuplesKt.m846to(str2, value)));
        JSONArray styleText = StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.1
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
                final Activity activity2 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.1.1
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
                        final Activity activity3 = activity2;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_code_input_title_bar_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.1.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        });
        String str3 = y.ٲٴݴ״ٰ(1782384304);
        put(y.ݮڮֲڭܩ(-628349740), MapsKt.mapOf(TuplesKt.m846to(str3, styleText)));
        put(y.ٲٴݴ״ٰ(1781623336), MapsKt.mapOf(TuplesKt.m846to(str3, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2
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
                final Activity activity2 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.1
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
                        final Activity activity3 = activity2;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_code_input_title_text0);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
                final Activity activity3 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.2
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
                        final Activity activity4 = activity3;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity4, C2558R.string.kg_2nd_pw_code_input_title_text1);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.2.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.٬ݯح׭٩(576694694)};
                            }
                        });
                    }
                });
                final Activity activity4 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.3
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
                        final Activity activity5 = activity4;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity5, C2558R.string.kg_2nd_pw_code_input_title_text2);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.3.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
                final Activity activity5 = activity;
                final int i2 = i;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.4
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
                        final Activity activity6 = activity5;
                        final int i3 = i2;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity6, C2558R.string.kg_2nd_pw_code_input_title_text3, Integer.valueOf(i3));
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.4.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.֬ڱܱײٮ(-1158918439)};
                            }
                        });
                    }
                });
                final Activity activity6 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.5
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
                        final Activity activity7 = activity6;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity7, C2558R.string.kg_2nd_pw_code_input_title_text4);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.5.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
                final Activity activity7 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.6
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
                        final Activity activity8 = activity7;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.6.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity8, C2558R.string.kg_2nd_pw_code_input_title_text5);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.2.6.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.٬ݯح׭٩(576694694)};
                            }
                        });
                    }
                });
            }
        }))));
        put("content", MapsKt.mapOf(TuplesKt.m846to(str3, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.3
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
                final InfodeskHelper.SecondaryPWAuthType secondaryPWAuthType2 = InfodeskHelper.SecondaryPWAuthType.this;
                final Activity activity2 = activity;
                final String str4 = str;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.3.1
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
                        final InfodeskHelper.SecondaryPWAuthType secondaryPWAuthType3 = InfodeskHelper.SecondaryPWAuthType.this;
                        final Activity activity3 = activity2;
                        final String str5 = str4;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.3.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return InfodeskHelper.SecondaryPWAuthType.this == InfodeskHelper.SecondaryPWAuthType.SMS ? ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_code_input_content_sms_text, str5) : str5;
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.3.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        }))));
        put(Base2ndPWViewData.KEY_INPUT, MapsKt.mapOf(TuplesKt.m846to(str3, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.4
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
                final Activity activity2 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.4.1
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
                        final Activity activity3 = activity2;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.4.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_code_input_input_hint_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.4.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        }))));
        put(Base2ndPWViewData.KEY_CANCEL, MapsKt.mapOf(TuplesKt.m846to(str3, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.5
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
                final Activity activity2 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.5.1
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
                        final Activity activity3 = activity2;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.5.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_close_btn_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.5.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str2, ActionType.EXIT.getValue())));
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.m846to(str3, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.6
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
                final Activity activity2 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.6.1
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
                        final Activity activity3 = activity2;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.6.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_authentication_complete_btn_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData.6.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        }));
        pairArr[1] = TuplesKt.m846to(str2, (z ? ActionType.REMOVE_CODE : ActionType.RESET_CODE).getValue());
        put(Base2ndPWViewData.KEY_CONFIRM, MapsKt.mapOf(pairArr));
    }
}
