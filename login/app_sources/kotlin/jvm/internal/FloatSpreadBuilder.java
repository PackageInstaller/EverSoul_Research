package kotlin.jvm.internal;

import com.kakao.sdk.talk.Constants;
import com.kakaogame.server.ServerConstants;
import kotlin.Metadata;

/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m839d2 = {"Lkotlin/jvm/internal/FloatSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", ServerConstants.SIZE, "", "(I)V", "values", Constants.TALK_CHANNEL_ADD_PATH_ADD, "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class FloatSpreadBuilder extends PrimitiveSpreadBuilder<float[]> {
    private final float[] values;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FloatSpreadBuilder(int i) {
        super(i);
        this.values = new float[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public int getSize(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void add(float value) {
        float[] fArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        fArr[position] = value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float[] toArray() {
        return toArray(this.values, new float[size()]);
    }
}
