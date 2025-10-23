package twitter4j;

/* loaded from: classes4.dex */
public class ScopesImpl implements Scopes {
    private static final long serialVersionUID = -6301829625595514787L;
    private final String[] placeIds;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ScopesImpl() {
        this.placeIds = new String[0];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ScopesImpl(String[] strArr) {
        this.placeIds = strArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Scopes
    public String[] getPlaceIds() {
        return this.placeIds;
    }
}
