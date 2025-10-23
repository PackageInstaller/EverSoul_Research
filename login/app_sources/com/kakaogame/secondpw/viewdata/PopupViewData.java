package com.kakaogame.secondpw.viewdata;

import android.app.Activity;
import com.kakaogame.p029ui.font.StyleTextBuilder;
import com.kakaogame.p029ui.font.StyleTextKt;
import com.kakaogame.p029ui.font.TextBuilder;
import com.kakaogame.secondpw.ActionType;
import com.kakaogame.secondpw.PasswordViewType;
import com.kakaogame.security.C2558R;
import com.kakaogame.util.ResourceUtil;
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

/* compiled from: PopupViewData.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/secondpw/viewdata/PopupViewData;", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "activity", "Landroid/app/Activity;", "type", "Lcom/kakaogame/secondpw/viewdata/PopupType;", "keypadNum", "", "failCount", "limitCount", "(Landroid/app/Activity;Lcom/kakaogame/secondpw/viewdata/PopupType;III)V", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PopupViewData extends Base2ndPWViewData {

    /* compiled from: PopupViewData.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[PopupType.values().length];
            try {
                iArr[PopupType.REMOVE_PASSWORD_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PopupType.SET_PASSWORD_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PopupType.RESET_PASSWORD_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PopupType.AUTH_CODE_TIME_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PopupType.EXIT_PROCESS_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PopupType.AUTH_CODE_LIMIT_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PopupType.KEYPAD_TIME_LIMIT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PopupViewData(final Activity activity, final PopupType popupType, int i, final int i2, final int i3) {
        String value;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        String str = y.ٲٴݴ״ٰ(1781623144);
        Intrinsics.checkNotNullParameter(popupType, str);
        put(str, PasswordViewType.POPUP.getValue());
        PopupType popupType2 = PopupType.INPUT_PASSWORD_NOT_MATCHED;
        String str2 = y.֬ڱܱײٮ(-1159406207);
        String str3 = y.ٲٴݴ״ٰ(1782384304);
        if (popupType == popupType2) {
            put(str2, MapsKt.mapOf(TuplesKt.m846to(str3, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.1
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
                    final PopupType popupType3 = popupType;
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.1.1
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
                            final PopupType popupType4 = popupType3;
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return ResourceUtil.getString(activity3, popupType4.getValue());
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.1.1.2
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
                    final int i5 = i3;
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.1.2
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
                            final int i6 = i4;
                            final int i7 = i5;
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return ResourceUtil.getString(activity4, C2558R.string.kg_2nd_pw_enter_no_match_error_count, Integer.valueOf(i6), Integer.valueOf(i7));
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.1.2.2
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String[] invoke() {
                                    return new String[]{y.֬ڱܱײٮ(-1158918439)};
                                }
                            });
                        }
                    });
                }
            }))));
        } else {
            put(str2, MapsKt.mapOf(TuplesKt.m846to(str3, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.2
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
                    final PopupType popupType3 = popupType;
                    styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.2.1
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
                            final PopupType popupType4 = popupType3;
                            textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.2.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return ResourceUtil.getString(activity3, popupType4.getValue());
                                }
                            });
                            textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.2.1.2
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
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.m846to(str3, StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.3
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
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.3.1
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
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.3.1.1
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
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.secondpw.viewdata.PopupViewData.3.1.2
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
        switch (WhenMappings.$EnumSwitchMapping$0[popupType.ordinal()]) {
            case 1:
                value = ActionType.REMOVE_COMPLETE.getValue();
                break;
            case 2:
                value = ActionType.SET_COMPLETE.getValue();
                break;
            case 3:
                value = ActionType.RESET_COMPLETE.getValue();
                break;
            case 4:
                value = ActionType.EXIT.getValue();
                break;
            case 5:
                value = ActionType.EXIT.getValue();
                break;
            case 6:
                value = ActionType.EXIT.getValue();
                break;
            case 7:
                if (i == 0) {
                    value = ActionType.EXIT.getValue();
                    break;
                } else if (i == 1) {
                    value = ActionType.RESET_DIGIT_CODE_1.getValue();
                    break;
                } else {
                    value = ActionType.RESET_DIGIT_CODE_2.getValue();
                    break;
                }
            default:
                value = ActionType.CLOSE_POPUP.getValue();
                break;
        }
        pairArr[1] = TuplesKt.m846to("action", value);
        put(Base2ndPWViewData.KEY_CONFIRM, MapsKt.mapOf(pairArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PopupViewData(Activity activity, PopupType popupType, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, popupType, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 1 : i2, (i4 & 16) != 0 ? 1 : i3);
    }
}
