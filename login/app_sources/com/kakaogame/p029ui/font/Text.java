package com.kakaogame.p029ui.font;

import com.facebook.internal.AnalyticsEvents;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StyleText.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/ui/font/Text;", "Lcom/kakaogame/util/json/JSONObject;", "text", "", "styleList", "", "(Ljava/lang/String;Ljava/util/List;)V", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Text extends JSONObject {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Text(String str, List<String> list) {
        String str2 = y.ٲٴݴ״ٰ(1782384304);
        Intrinsics.checkNotNullParameter(str, str2);
        Intrinsics.checkNotNullParameter(list, y.دײܮڳܯ(2051043349));
        if (str.length() > 0) {
            put(str2, str);
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.add((String) it.next());
            }
            put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, jSONArray);
        }
    }
}
