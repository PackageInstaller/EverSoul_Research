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
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResetGuideViewData.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/ResetGuideViewData;", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "activity", "Landroid/app/Activity;", "authType", "Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWAuthType;", "(Landroid/app/Activity;Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWAuthType;)V", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ResetGuideViewData extends Base2ndPWViewData {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResetGuideViewData(final Activity activity, final InfodeskHelper.SecondaryPWAuthType secondaryPWAuthType) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(secondaryPWAuthType, y.ۮڭڭܬި(862463915));
        put(y.ٲٴݴ״ٰ(1781623144), PasswordViewType.GUIDE_2_LINE.getValue());
        String value = ActionType.EXIT.getValue();
        String str = y.֬ڱܱײٮ(-1159583711);
        put(y.ٴسسݬߨ(1393043586), MapsKt.mapOf(TuplesKt.m846to(str, value)));
        JSONArray styleText = StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.1
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.1.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_reset_guide_title_bar_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.1.1.2
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
        String str2 = y.ٲٴݴ״ٰ(1782384304);
        put(y.ݮڮֲڭܩ(-628349740), MapsKt.mapOf(TuplesKt.m846to(str2, styleText)));
        put(y.ٲٴݴ״ٰ(1781623336), MapsKt.mapOf(TuplesKt.m846to(str2, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_reset_guide_title_text0);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
                final Activity activity3 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.2
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity4, C2558R.string.kg_2nd_pw_reset_guide_title_text1);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.2.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.٬ݯح׭٩(576694694)};
                            }
                        });
                    }
                });
                final Activity activity4 = activity;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.3
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity5, C2558R.string.kg_2nd_pw_reset_guide_title_text2);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.2.3.2
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
        if (secondaryPWAuthType == InfodeskHelper.SecondaryPWAuthType.SMS) {
            mapOf = MapsKt.mapOf(TuplesKt.m846to(str2, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.3
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
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.3.1
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
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.3.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_reset_guide_content_text);
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.3.1.2
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String[] invoke() {
                                    return new String[]{y.ۮڭڭܬި(862484995)};
                                }
                            });
                        }
                    });
                }
            })));
        } else {
            mapOf = MapsKt.mapOf(TuplesKt.m846to(str2, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.4
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
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.4.1
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
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.4.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_reset_guide_content_email_text);
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.4.1.2
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String[] invoke() {
                                    return new String[]{y.ۮڭڭܬި(862484995)};
                                }
                            });
                        }
                    });
                }
            })));
        }
        put(y.֬ڱܱײٮ(-1159406207), mapOf);
        put(y.֬ڱܱײٮ(-1158781631), MapsKt.mapOf(TuplesKt.m846to(str2, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.5
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.5.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.5.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_cancel_btn_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.5.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str, ActionType.SHOW_PUT_PASSWORD.getValue())));
        put(Base2ndPWViewData.KEY_CONFIRM, MapsKt.mapOf(TuplesKt.m846to(str2, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.6
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.6.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.6.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return InfodeskHelper.SecondaryPWAuthType.this == InfodeskHelper.SecondaryPWAuthType.EMAIL ? ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_confirm_btn_text) : ResourceUtil.getString(activity3, C2558R.string.kg_2nd_pw_send_message_btn_text);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.ResetGuideViewData.6.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })), TuplesKt.m846to(str, ActionType.RESET_REQUEST_CODE.getValue())));
    }
}
