package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.singular.sdk.internal.Constants;
import kotlin.Metadata;

/* compiled from: SessionEvent.kt */
@Metadata(m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/google/firebase/sessions/EventType;", "", "Lcom/google/firebase/encoders/json/NumberedEnum;", Base2ndPWViewData.KEY_NUMBER, "", "(Ljava/lang/String;II)V", "getNumber", "()I", "EVENT_TYPE_UNKNOWN", Constants.API_TYPE_SESSION_START, "com.google.firebase-firebase-sessions"}, m840k = 1, m841mv = {1, 7, 1}, m843xi = 48)
/* loaded from: classes2.dex */
public enum EventType implements NumberedEnum {
    EVENT_TYPE_UNKNOWN(0),
    SESSION_START(1);

    private final int number;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EventType(int i) {
        this.number = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int getNumber() {
        return this.number;
    }
}
