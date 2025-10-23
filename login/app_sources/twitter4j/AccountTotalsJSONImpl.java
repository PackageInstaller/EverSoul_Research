package twitter4j;

import com.facebook.internal.NativeProtocol;
import com.liapp.y;
import java.io.Serializable;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
class AccountTotalsJSONImpl extends TwitterResponseImpl implements AccountTotals, Serializable {
    private static final long serialVersionUID = 4199733699237229892L;
    private final int favorites;
    private final int followers;
    private final int friends;
    private final int updates;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AccountTotalsJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) {
        super(httpResponse);
        this.updates = ParseUtil.getInt("updates", jSONObject);
        this.followers = ParseUtil.getInt("followers", jSONObject);
        this.favorites = ParseUtil.getInt("favorites", jSONObject);
        this.friends = ParseUtil.getInt(NativeProtocol.AUDIENCE_FRIENDS, jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AccountTotalsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AccountTotalsJSONImpl(JSONObject jSONObject) throws TwitterException {
        this((HttpResponse) null, jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountTotals
    public int getUpdates() {
        return this.updates;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountTotals
    public int getFollowers() {
        return this.followers;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountTotals
    public int getFavorites() {
        return this.favorites;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.AccountTotals
    public int getFriends() {
        return this.friends;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccountTotalsJSONImpl accountTotalsJSONImpl = (AccountTotalsJSONImpl) obj;
        return this.favorites == accountTotalsJSONImpl.favorites && this.followers == accountTotalsJSONImpl.followers && this.friends == accountTotalsJSONImpl.friends && this.updates == accountTotalsJSONImpl.updates;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((((this.updates * 31) + this.followers) * 31) + this.favorites) * 31) + this.friends;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.دײܮڳܯ(2051227989) + this.updates + y.ݬֲ֮ܲت(1512273855) + this.followers + y.ݬֲ֮ܲت(1512273679) + this.favorites + y.ۮڭڭܬި(862860339) + this.friends + '}';
    }
}
