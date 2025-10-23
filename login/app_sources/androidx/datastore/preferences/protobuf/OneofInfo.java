package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* renamed from: id */
    private final int f106id;
    private final java.lang.reflect.Field valueField;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OneofInfo(int i, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.f106id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getId() {
        return this.f106id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
