package com.kakaogame.secondpw.viewdata;

import android.app.Activity;
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

/* compiled from: SetPasswordViewData.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/SetPasswordViewData;", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "activity", "Landroid/app/Activity;", "hasPassive", "", Base2ndPWViewData.KEY_PASSIVE, "", "path1", "keys1", "path2", "keys2", "keypadLimitTime", "", "(Landroid/app/Activity;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SetPasswordViewData extends Base2ndPWViewData {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SetPasswordViewData(final Activity activity, boolean z, final String str, String str2, String str3, String str4, String str5, int i) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        String str6 = y.دײܮڳܯ(2051086005);
        Intrinsics.checkNotNullParameter(str, str6);
        Intrinsics.checkNotNullParameter(str2, y.ٴسسݬߨ(1393058818));
        Intrinsics.checkNotNullParameter(str3, y.دײܮڳܯ(2051106533));
        Intrinsics.checkNotNullParameter(str4, y.ٲٴݴ״ٰ(1782414296));
        Intrinsics.checkNotNullParameter(str5, y.دײܮڳܯ(2051106677));
        put(y.ٲٴݴ״ٰ(1781623144), PasswordViewType.SET_PASSWORD.getValue());
        String value = ActionType.EXIT.getValue();
        String str7 = y.֬ڱܱײٮ(-1159583711);
        put(y.ٴسسݬߨ(1393043586), MapsKt.mapOf(TuplesKt.m846to(str7, value)));
        JSONArray styleText = StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.1
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.1.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_set_title_bar_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.1.1.2
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
        String str8 = y.ٲٴݴ״ٰ(1782384304);
        put(y.ݮڮֲڭܩ(-628349740), MapsKt.mapOf(TuplesKt.m846to(str8, styleText)));
        put(y.֬ڱܱײٮ(-1159182839), MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.2
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.2.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_set_input_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.2.1.2
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
        put(y.ݮڮֲڭܩ(-628347076), MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.3
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.3.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.3.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_set_confirm_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.3.1.2
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
        put(y.دײܮڳܯ(2051087269), MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.4
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.4.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.4.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_set_detail_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.4.1.2
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
        put(y.ݮڮֲڭܩ(-628347236), Boolean.valueOf(z));
        String str9 = y.֬ڱܱײٮ(-1159182287);
        if (z) {
            put(str9, MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.5
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
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.5.1
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
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.5.1.1
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
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.5.1.2
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
            put(str6, MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.6
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
                    final String str10 = str;
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.6.1
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
                            final String str11 = str10;
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.6.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return str11;
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.6.1.2
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
            put(str9, MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.7
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
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.7.1
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
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.7.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_set_no_benefit_text);
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.7.1.2
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
        put(y.٬ݯح׭٩(576442950), MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.8
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.8.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.8.1.1
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
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.8.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str7, ActionType.RESET_DIGIT_CODE_2.getValue())));
        put(y.֬ڱܱײٮ(-1158781631), MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.9
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.9.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.9.1.1
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
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.9.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str7, ActionType.EXIT.getValue())));
        put(Base2ndPWViewData.KEY_CONFIRM, MapsKt.mapOf(TuplesKt.m846to(str8, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.10
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.10.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.10.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_setting_complete_btn_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.SetPasswordViewData.10.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str7, ActionType.SET_PASSWORD.getValue())));
        JSONArray jSONArray = new JSONArray();
        String str10 = y.دײܮڳܯ(2051509965);
        jSONArray.add(MapsKt.mapOf(TuplesKt.m846to(str10, str2), TuplesKt.m846to("key", str3)));
        jSONArray.add(MapsKt.mapOf(TuplesKt.m846to(str10, str4), TuplesKt.m846to("key", str5)));
        put(Base2ndPWViewData.KEY_KEYPAD, jSONArray);
        put(Base2ndPWViewData.KEY_KEYPAD_LIMIT, MapsKt.mapOf(TuplesKt.m846to(Base2ndPWViewData.KEY_TIME, Integer.valueOf(i)), TuplesKt.m846to(str7, ActionType.KEYPAD_TIME_LIMIT_2.getValue())));
    }
}
