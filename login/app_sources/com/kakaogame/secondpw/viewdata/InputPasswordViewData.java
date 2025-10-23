package com.kakaogame.secondpw.viewdata;

import android.app.Activity;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputPasswordViewData.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/InputPasswordViewData;", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "activity", "Landroid/app/Activity;", "hasPassive", "", Base2ndPWViewData.KEY_PASSIVE, "", Base2ndPWViewData.KEY_PATH, UserMetadata.KEYDATA_FILENAME, "timeLimit", "", "countLimit", "keypadLimitTime", "(Landroid/app/Activity;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InputPasswordViewData extends Base2ndPWViewData {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputPasswordViewData(final Activity activity, boolean z, final String str, String str2, String str3, final int i, final int i2, int i3) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        String str4 = y.دײܮڳܯ(2051086005);
        Intrinsics.checkNotNullParameter(str, str4);
        String str5 = y.دײܮڳܯ(2051509965);
        Intrinsics.checkNotNullParameter(str2, str5);
        Intrinsics.checkNotNullParameter(str3, y.ٲٴݴ״ٰ(1782258616));
        put(y.ٲٴݴ״ٰ(1781623144), PasswordViewType.INPUT_PASSWORD.getValue());
        String value = ActionType.EXIT.getValue();
        String str6 = y.֬ڱܱײٮ(-1159583711);
        put(y.ٴسسݬߨ(1393043586), MapsKt.mapOf(TuplesKt.m846to(str6, value)));
        JSONArray styleText = StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.1
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.1.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_enter_title_bar_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.1.1.2
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
        String str7 = y.ٲٴݴ״ٰ(1782384304);
        put(y.ݮڮֲڭܩ(-628349740), MapsKt.mapOf(TuplesKt.m846to(str7, styleText)));
        put(y.֬ڱܱײٮ(-1159182839), MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.2
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.2.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_enter_input_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.2.1.2
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
        put(Base2ndPWViewData.KEY_DETAIL, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_enter_detail_text1);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
                final Activity activity3 = activity;
                final int i4 = i2;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.2
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
                        final int i5 = i4;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity4, C2558R.string.kg_2nd_pw_enter_detail_text2, Integer.valueOf(i5));
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.2.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.֬ڱܱײٮ(-1158918439)};
                            }
                        });
                    }
                });
                final Activity activity4 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.3
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity5, C2558R.string.kg_2nd_pw_enter_detail_text3);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.3.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
                final Activity activity5 = activity;
                final int i5 = i;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.4
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
                        final int i6 = i5;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity6, C2558R.string.kg_2nd_pw_enter_detail_text4, Integer.valueOf(i6));
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.4.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.֬ڱܱײٮ(-1158918439)};
                            }
                        });
                    }
                });
                final Activity activity6 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.5
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity7, C2558R.string.kg_2nd_pw_enter_detail_text5);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.3.5.2
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
        put(Base2ndPWViewData.KEY_HAS_PASSIVE, Boolean.valueOf(z));
        if (z) {
            put(Base2ndPWViewData.KEY_PASSIVE_DESC, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.4
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
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.4.1
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
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.4.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_set_has_benefit_text);
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.4.1.2
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
            put(str4, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.5
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
                    final String str8 = str;
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.5.1
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
                            final String str9 = str8;
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.5.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return str9;
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.5.1.2
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
        } else {
            put(Base2ndPWViewData.KEY_PASSIVE_DESC, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.6
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
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.6.1
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
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.6.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_enter_no_benefit_text);
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.6.1.2
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
        }
        put(Base2ndPWViewData.KEY_PASSWORD_RESET, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.7
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.7.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.7.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_enter_reset_pw_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.7.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str6, ActionType.REQUEST_RESET.getValue())));
        put(Base2ndPWViewData.KEY_PASSWORD_REMOVE, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.8
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.8.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.8.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_enter_cancel_pw_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.8.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str6, ActionType.REQUEST_REMOVE.getValue())));
        put(Base2ndPWViewData.KEY_RESET, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.9
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.9.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.9.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_reset_btn_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.9.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str6, ActionType.RESET_DIGIT_CODE_1.getValue())));
        put(Base2ndPWViewData.KEY_CANCEL, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.10
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.10.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.10.1.1
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
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.10.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str6, ActionType.EXIT.getValue())));
        put(Base2ndPWViewData.KEY_CONFIRM, MapsKt.mapOf(TuplesKt.m846to(str7, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.11
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.11.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.11.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_confirm_btn_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.InputPasswordViewData.11.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str6, ActionType.PUT_PASSWORD.getValue())));
        JSONArray jSONArray = new JSONArray();
        jSONArray.add(MapsKt.mapOf(TuplesKt.m846to(str5, str2), TuplesKt.m846to("key", str3)));
        put(Base2ndPWViewData.KEY_KEYPAD, jSONArray);
        put(Base2ndPWViewData.KEY_KEYPAD_LIMIT, MapsKt.mapOf(TuplesKt.m846to(Base2ndPWViewData.KEY_TIME, Integer.valueOf(i3)), TuplesKt.m846to(str6, ActionType.KEYPAD_TIME_LIMIT.getValue())));
    }
}
