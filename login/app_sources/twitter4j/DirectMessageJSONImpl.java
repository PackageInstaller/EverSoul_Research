package twitter4j;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.kakaogame.game.StringSet;
import com.liapp.y;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class DirectMessageJSONImpl extends TwitterResponseImpl implements DirectMessage, Serializable {
    private static final long serialVersionUID = 7092906238192790921L;
    private Date createdAt;
    private HashtagEntity[] hashtagEntities;

    /* renamed from: id */
    private long f1560id;
    private MediaEntity[] mediaEntities;
    private long recipientId;
    private long senderId;
    private SymbolEntity[] symbolEntities;
    private String text;
    private URLEntity[] urlEntities;
    private UserMentionEntity[] userMentionEntities;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DirectMessageJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObject = httpResponse.asJSONObject().getJSONObject(NotificationCompat.CATEGORY_EVENT);
            init(jSONObject);
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
                TwitterObjectFactory.registerJSONObject(this, jSONObject);
            }
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DirectMessageJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init(JSONObject jSONObject) throws TwitterException {
        String str = y.ۮڭڭܬި(862094195);
        String str2 = y.ݮڮֲڭܩ(-628200124);
        String str3 = y.ݮڮֲڭܩ(-628200156);
        String str4 = y.ۮڭڭܬި(862859507);
        try {
            this.f1560id = ParseUtil.getLong("id", jSONObject);
            boolean isNull = jSONObject.isNull(str4);
            String str5 = y.֬ڱܱײٮ(-1159067807);
            String str6 = y.دײܮڳܯ(2051233981);
            if (!isNull) {
                this.createdAt = new Date(jSONObject.getLong(str4));
                JSONObject jSONObject2 = jSONObject.getJSONObject("message_create");
                this.recipientId = ParseUtil.getLong(str5, jSONObject2.getJSONObject(TypedValues.AttributesType.S_TARGET));
                this.senderId = ParseUtil.getLong(str6, jSONObject2);
                jSONObject = jSONObject2.getJSONObject("message_data");
            } else {
                this.createdAt = ParseUtil.getDate(StringSet.created_at, jSONObject);
                this.senderId = ParseUtil.getLong(str6, jSONObject);
                this.recipientId = ParseUtil.getLong(str5, jSONObject);
            }
            if (!jSONObject.isNull(str3)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(str3);
                this.userMentionEntities = EntitiesParseUtil.getUserMentions(jSONObject3);
                this.urlEntities = EntitiesParseUtil.getUrls(jSONObject3);
                this.hashtagEntities = EntitiesParseUtil.getHashtags(jSONObject3);
                this.symbolEntities = EntitiesParseUtil.getSymbols(jSONObject3);
            }
            UserMentionEntity[] userMentionEntityArr = this.userMentionEntities;
            if (userMentionEntityArr == null) {
                userMentionEntityArr = new UserMentionEntity[0];
            }
            this.userMentionEntities = userMentionEntityArr;
            URLEntity[] uRLEntityArr = this.urlEntities;
            if (uRLEntityArr == null) {
                uRLEntityArr = new URLEntity[0];
            }
            this.urlEntities = uRLEntityArr;
            HashtagEntity[] hashtagEntityArr = this.hashtagEntities;
            if (hashtagEntityArr == null) {
                hashtagEntityArr = new HashtagEntity[0];
            }
            this.hashtagEntities = hashtagEntityArr;
            SymbolEntity[] symbolEntityArr = this.symbolEntities;
            if (symbolEntityArr == null) {
                symbolEntityArr = new SymbolEntity[0];
            }
            this.symbolEntities = symbolEntityArr;
            if (!jSONObject.isNull(str2)) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(str2);
                if (!jSONObject4.isNull(str)) {
                    this.mediaEntities = new MediaEntity[]{new MediaEntityJSONImpl(jSONObject4.getJSONObject(str))};
                }
            }
            MediaEntity[] mediaEntityArr = this.mediaEntities;
            if (mediaEntityArr == null) {
                mediaEntityArr = new MediaEntity[0];
            }
            this.mediaEntities = mediaEntityArr;
            this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static DirectMessageList createDirectMessageList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONArray asJSONArray;
        DirectMessageListImpl directMessageListImpl;
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            try {
                JSONObject asJSONObject = httpResponse.asJSONObject();
                asJSONArray = asJSONObject.getJSONArray("events");
                directMessageListImpl = new DirectMessageListImpl(asJSONArray.length(), asJSONObject, httpResponse);
            } catch (TwitterException e) {
                if (e.getCause() != null && (e.getCause() instanceof JSONException)) {
                    asJSONArray = httpResponse.asJSONArray();
                    directMessageListImpl = new DirectMessageListImpl(asJSONArray.length(), httpResponse);
                } else {
                    throw e;
                }
            }
            for (int i = 0; i < asJSONArray.length(); i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                DirectMessageJSONImpl directMessageJSONImpl = new DirectMessageJSONImpl(jSONObject);
                directMessageListImpl.add(directMessageJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(directMessageJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(directMessageListImpl, asJSONArray);
            }
            return directMessageListImpl;
        } catch (JSONException e2) {
            throw new TwitterException(e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public long getId() {
        return this.f1560id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public long getRecipientId() {
        return this.recipientId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public long getSenderId() {
        return this.senderId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public String getText() {
        return this.text;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public UserMentionEntity[] getUserMentionEntities() {
        return this.userMentionEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public URLEntity[] getURLEntities() {
        return this.urlEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public HashtagEntity[] getHashtagEntities() {
        return this.hashtagEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public MediaEntity[] getMediaEntities() {
        return this.mediaEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.EntitySupport
    public SymbolEntity[] getSymbolEntities() {
        return this.symbolEntities;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DirectMessageJSONImpl directMessageJSONImpl = (DirectMessageJSONImpl) obj;
        if (this.f1560id != directMessageJSONImpl.f1560id || this.senderId != directMessageJSONImpl.senderId || this.recipientId != directMessageJSONImpl.recipientId) {
            return false;
        }
        String str = this.text;
        if (str == null ? directMessageJSONImpl.text != null : !str.equals(directMessageJSONImpl.text)) {
            return false;
        }
        Date date = this.createdAt;
        if (date == null ? directMessageJSONImpl.createdAt != null : !date.equals(directMessageJSONImpl.createdAt)) {
            return false;
        }
        if (Arrays.equals(this.userMentionEntities, directMessageJSONImpl.userMentionEntities) && Arrays.equals(this.urlEntities, directMessageJSONImpl.urlEntities) && Arrays.equals(this.hashtagEntities, directMessageJSONImpl.hashtagEntities) && Arrays.equals(this.mediaEntities, directMessageJSONImpl.mediaEntities)) {
            return Arrays.equals(this.symbolEntities, directMessageJSONImpl.symbolEntities);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.f1560id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.text;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.senderId;
        int i2 = (((i + hashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.recipientId;
        int i3 = (i2 + ((int) ((j3 >>> 32) ^ j3))) * 31;
        Date date = this.createdAt;
        return ((((((((((i3 + (date != null ? date.hashCode() : 0)) * 31) + Arrays.hashCode(this.userMentionEntities)) * 31) + Arrays.hashCode(this.urlEntities)) * 31) + Arrays.hashCode(this.hashtagEntities)) * 31) + Arrays.hashCode(this.mediaEntities)) * 31) + Arrays.hashCode(this.symbolEntities);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628203100) + this.f1560id + y.٬ݯح׭٩(576295678) + this.text + y.ۮڭڭܬި(862862891) + this.senderId + y.ݬֲ֮ܲت(1512274967) + this.recipientId + y.ݮڮֲڭܩ(-628202404) + this.createdAt + y.ݬֲ֮ܲت(1512274919) + Arrays.toString(this.userMentionEntities) + y.ۮڭڭܬި(862861323) + Arrays.toString(this.urlEntities) + y.֬ڱܱײٮ(-1159066495) + Arrays.toString(this.hashtagEntities) + y.ݮڮֲڭܩ(-628201972) + Arrays.toString(this.mediaEntities) + y.دײܮڳܯ(2051231901) + Arrays.toString(this.symbolEntities) + '}';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public String getSenderScreenName() {
        throw new UnsupportedOperationException(y.ٲٴݴ״ٰ(1782531120));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public String getRecipientScreenName() {
        throw new UnsupportedOperationException(y.ٲٴݴ״ٰ(1782531120));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public User getSender() {
        throw new UnsupportedOperationException(y.ٲٴݴ״ٰ(1782531120));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.DirectMessage
    public User getRecipient() {
        throw new UnsupportedOperationException(y.ٲٴݴ״ٰ(1782531120));
    }
}
