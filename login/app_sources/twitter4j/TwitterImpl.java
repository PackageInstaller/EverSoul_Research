package twitter4j;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.kakaogame.addon.KGService;
import com.liapp.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.HelpResources;
import twitter4j.api.ListsResources;
import twitter4j.api.PlacesGeoResources;
import twitter4j.api.SavedSearchesResources;
import twitter4j.api.SearchResource;
import twitter4j.api.SpamReportingResource;
import twitter4j.api.SuggestedUsersResources;
import twitter4j.api.TimelinesResources;
import twitter4j.api.TrendsResources;
import twitter4j.api.TweetsResources;
import twitter4j.api.UsersResources;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
class TwitterImpl extends TwitterBaseImpl implements Twitter {
    private static final long serialVersionUID = 9170943084096085770L;
    private final String CHUNKED_APPEND;
    private final String CHUNKED_FINALIZE;
    private final String CHUNKED_INIT;
    private final String CHUNKED_STATUS;
    private final int CHUNK_SIZE;
    private final HttpParameter[] IMPLICIT_PARAMS;
    private final String IMPLICIT_PARAMS_STR;
    private final HttpParameter INCLUDE_MY_RETWEET;
    private final int MAX_VIDEO_SIZE;

    /* renamed from: MB */
    private final int f1574MB;
    private long myId;
    private static final Logger logger = Logger.getLogger(TwitterBaseImpl.class);
    private static final ConcurrentHashMap<Configuration, HttpParameter[]> implicitParamsMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Configuration, String> implicitParamsStrMap = new ConcurrentHashMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public DirectMessagesResources directMessages() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public FavoritesResources favorites() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public FriendsFollowersResources friendsFollowers() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public HelpResources help() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public ListsResources list() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public PlacesGeoResources placesGeo() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public SavedSearchesResources savedSearches() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public SearchResource search() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public SpamReportingResource spamReporting() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public SuggestedUsersResources suggestedUsers() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public TimelinesResources timelines() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public TrendsResources trends() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public TweetsResources tweets() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Twitter
    public UsersResources users() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TwitterImpl(Configuration configuration, Authorization authorization) {
        super(configuration, authorization);
        this.CHUNKED_INIT = "INIT";
        this.CHUNKED_APPEND = "APPEND";
        this.CHUNKED_FINALIZE = "FINALIZE";
        this.CHUNKED_STATUS = "STATUS";
        this.f1574MB = 1048576;
        this.MAX_VIDEO_SIZE = DriveFile.MODE_WRITE_ONLY;
        this.CHUNK_SIZE = 2097152;
        this.myId = -1L;
        this.INCLUDE_MY_RETWEET = new HttpParameter(y.٬ݯح׭٩(575138718), configuration.isIncludeMyRetweetEnabled());
        ConcurrentHashMap<Configuration, HttpParameter[]> concurrentHashMap = implicitParamsMap;
        if (concurrentHashMap.containsKey(configuration)) {
            this.IMPLICIT_PARAMS = concurrentHashMap.get(configuration);
            this.IMPLICIT_PARAMS_STR = implicitParamsStrMap.get(configuration);
            return;
        }
        String str = configuration.isIncludeEntitiesEnabled() ? y.ٴسسݬߨ(1393829906) : "";
        boolean z = configuration.getContributingTo() != -1;
        String str2 = y.֬ڱܱײٮ(-1159719487);
        if (z) {
            str = ("".equals(str) ? str : str.concat(str2)) + y.دײܮڳܯ(2052926325) + configuration.getContributingTo();
        }
        if (configuration.isTweetModeExtended()) {
            str = ("".equals(str) ? str : str + str2) + y.ݬֲ֮ܲت(1513947671);
        }
        ArrayList arrayList = new ArrayList(3);
        boolean isIncludeEntitiesEnabled = configuration.isIncludeEntitiesEnabled();
        String str3 = y.دײܮڳܯ(2051939573);
        if (isIncludeEntitiesEnabled) {
            arrayList.add(new HttpParameter(y.ٲٴݴ״ٰ(1780561184), str3));
        }
        if (z) {
            arrayList.add(new HttpParameter(y.ۮڭڭܬި(862995443), configuration.getContributingTo()));
        }
        if (configuration.isTrimUserEnabled()) {
            arrayList.add(new HttpParameter(y.ݮڮֲڭܩ(-628089068), y.ۮڭڭܬި(862235827)));
        }
        if (configuration.isIncludeExtAltTextEnabled()) {
            arrayList.add(new HttpParameter(y.٬ݯح׭٩(575139758), str3));
        }
        if (configuration.isTweetModeExtended()) {
            arrayList.add(new HttpParameter(y.ٴسسݬߨ(1393828882), y.֬ڱܱײٮ(-1158383215)));
        }
        HttpParameter[] httpParameterArr = (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
        implicitParamsStrMap.putIfAbsent(configuration, str);
        concurrentHashMap.putIfAbsent(configuration, httpParameterArr);
        this.IMPLICIT_PARAMS = httpParameterArr;
        this.IMPLICIT_PARAMS_STR = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getMentionsTimeline() throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780576264)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getMentionsTimeline(Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780576264), paging.asPostParameterArray()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(862979395), this.INCLUDE_MY_RETWEET));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getHomeTimeline(Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(862979395), mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{this.INCLUDE_MY_RETWEET})));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513966207)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513966207), paging.asPostParameterArray()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getUserTimeline(String str, Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393850842), mergeParameters(new HttpParameter[]{new HttpParameter(y.٬ݯح׭٩(576238206), str), this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getUserTimeline(long j, Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393850842), mergeParameters(new HttpParameter[]{new HttpParameter(y.ݬֲ֮ܲت(1512773759), j), this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getUserTimeline(String str) throws TwitterException {
        return getUserTimeline(str, new Paging());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getUserTimeline(long j) throws TwitterException {
        return getUserTimeline(j, new Paging());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getUserTimeline() throws TwitterException {
        return getUserTimeline(new Paging());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TimelinesResources
    public ResponseList<Status> getUserTimeline(Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393850842), mergeParameters(new HttpParameter[]{this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public ResponseList<Status> getRetweets(long j) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575120758) + j + ".json?count=100"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public IDs getRetweeterIds(long j, long j2) throws TwitterException {
        return getRetweeterIds(j, 100, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public IDs getRetweeterIds(long j, int i, long j2) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052940357) + j + "&cursor=" + j2 + "&count=" + i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public Status showStatus(long j) throws TwitterException {
        return this.factory.createStatus(get(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628065276) + j + ".json", this.INCLUDE_MY_RETWEET));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public Status destroyStatus(long j) throws TwitterException {
        return this.factory.createStatus(post(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158391383) + j + ".json"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public Status updateStatus(String str) throws TwitterException {
        return this.factory.createStatus(post(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780565152), new HttpParameter(y.ݮڮֲڭܩ(-628237012), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public Status updateStatus(StatusUpdate statusUpdate) throws TwitterException {
        return this.factory.createStatus(post(this.conf.getRestBaseURL() + (statusUpdate.isForUpdateWithMedia() ? y.ۮڭڭܬި(862993747) : y.ٲٴݴ״ٰ(1780565152)), statusUpdate.asHttpParameterArray()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public Status retweetStatus(long j) throws TwitterException {
        return this.factory.createStatus(post(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393848482) + j + ".json"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public Status unRetweetStatus(long j) throws TwitterException {
        return this.factory.createStatus(post(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158406503) + j + ".json"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public OEmbed getOEmbed(OEmbedRequest oEmbedRequest) throws TwitterException {
        return this.factory.createOEmbed(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780577288), oEmbedRequest.asHttpParameterArray()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public ResponseList<Status> lookup(long... jArr) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158404271) + StringUtil.join(jArr)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public UploadedMedia uploadMedia(File file) throws TwitterException {
        checkFileValidity(file);
        return new UploadedMedia(post(this.conf.getUploadBaseURL() + y.ٴسسݬߨ(1393829466), new HttpParameter(y.ۮڭڭܬި(862094195), file)).asJSONObject());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public UploadedMedia uploadMedia(String str, InputStream inputStream) throws TwitterException {
        return new UploadedMedia(post(this.conf.getUploadBaseURL() + y.ٴسسݬߨ(1393829466), new HttpParameter(y.ۮڭڭܬި(862094195), str, inputStream)).asJSONObject());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TweetsResources
    public UploadedMedia uploadMediaChunked(String str, InputStream inputStream) throws TwitterException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(262144);
            byte[] bArr = new byte[32768];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length > 536870912) {
                throw new TwitterException(String.format(Locale.US, "video file can't be longer than: %d MBytes", 512));
            }
            try {
                UploadedMedia uploadMediaChunkedInit = uploadMediaChunkedInit(byteArray.length);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                byte[] bArr2 = new byte[2097152];
                int i = 0;
                int i2 = 0;
                while (true) {
                    int read2 = byteArrayInputStream.read(bArr2);
                    if (read2 > 0) {
                        i += read2;
                        logger.debug("Chunked appened, segment index:" + i2 + " bytes:" + i + RemoteSettings.FORWARD_SLASH_STRING + byteArray.length);
                        uploadMediaChunkedAppend(str, new ByteArrayInputStream(bArr2, 0, read2), i2, uploadMediaChunkedInit.getMediaId());
                        bArr2 = new byte[2097152];
                        i2++;
                    } else {
                        return uploadMediaChunkedFinalize(uploadMediaChunkedInit.getMediaId());
                    }
                }
            } catch (Exception e) {
                throw new TwitterException(e);
            }
        } catch (IOException e2) {
            throw new TwitterException(y.دײܮڳܯ(2052937501), e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UploadedMedia uploadMediaChunkedInit(long j) throws TwitterException {
        return new UploadedMedia(post(this.conf.getUploadBaseURL() + y.ٴسسݬߨ(1393829466), new HttpParameter(y.ٲٴݴ״ٰ(1780562312), y.֬ڱܱײٮ(-1158846575)), new HttpParameter(y.دײܮڳܯ(2052930621), y.٬ݯح׭٩(575142558)), new HttpParameter(y.٬ݯح׭٩(575142710), y.٬ݯح׭٩(575142838)), new HttpParameter(y.ݬֲ֮ܲت(1513952375), j)).asJSONObject());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void uploadMediaChunkedAppend(String str, InputStream inputStream, int i, long j) throws TwitterException {
        post(this.conf.getUploadBaseURL() + y.ٴسسݬߨ(1393829466), new HttpParameter(y.ٲٴݴ״ٰ(1780562312), y.ٴسسݬߨ(1393829562)), new HttpParameter(y.ݮڮֲڭܩ(-628092044), j), new HttpParameter("segment_index", i), new HttpParameter(ShareConstants.WEB_DIALOG_PARAM_MEDIA, str, inputStream));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UploadedMedia uploadMediaChunkedFinalize(long j) throws TwitterException {
        int progressPercent;
        UploadedMedia uploadMediaChunkedFinalize0 = uploadMediaChunkedFinalize0(j);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < 20) {
            if (i2 == i3) {
                i++;
            }
            String processingState = uploadMediaChunkedFinalize0.getProcessingState();
            boolean equals = processingState.equals(y.ݮڮֲڭܩ(-629105980));
            String str = y.ۮڭڭܬި(862998083);
            if (equals) {
                throw new TwitterException(str);
            }
            if (processingState.equals(y.ۮڭڭܬި(862996875)) || processingState.equals(y.دײܮڳܯ(2052924277))) {
                progressPercent = uploadMediaChunkedFinalize0.getProgressPercent();
                logger.debug(y.ݮڮֲڭܩ(-628091588) + Math.max(uploadMediaChunkedFinalize0.getProcessingCheckAfterSecs(), 1) + y.ٴسسݬߨ(1393828362));
                try {
                    Thread.sleep(r6 * 1000);
                } catch (InterruptedException e) {
                    throw new TwitterException(str, e);
                }
            } else {
                progressPercent = i3;
            }
            if (processingState.equals(y.دײܮڳܯ(2052923637))) {
                return uploadMediaChunkedFinalize0;
            }
            uploadMediaChunkedFinalize0 = uploadMediaChunkedStatus(j);
            i2 = i3;
            i3 = progressPercent;
        }
        throw new TwitterException(y.ٴسسݬߨ(1393828482) + i + y.ۮڭڭܬި(862999611));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UploadedMedia uploadMediaChunkedFinalize0(long j) throws TwitterException {
        JSONObject asJSONObject = post(this.conf.getUploadBaseURL() + y.ٴسسݬߨ(1393829466), new HttpParameter(y.ٲٴݴ״ٰ(1780562312), y.ݮڮֲڭܩ(-628094708)), new HttpParameter(y.ݮڮֲڭܩ(-628092044), j)).asJSONObject();
        logger.debug(y.ݮڮֲڭܩ(-628094468) + asJSONObject);
        return new UploadedMedia(asJSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UploadedMedia uploadMediaChunkedStatus(long j) throws TwitterException {
        JSONObject asJSONObject = get(this.conf.getUploadBaseURL() + y.ٴسسݬߨ(1393829466), new HttpParameter(y.ٲٴݴ״ٰ(1780562312), y.دײܮڳܯ(2051202461)), new HttpParameter(y.ݮڮֲڭܩ(-628092044), j)).asJSONObject();
        logger.debug(y.دײܮڳܯ(2052930085) + asJSONObject);
        return new UploadedMedia(asJSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SearchResource
    public QueryResult search(Query query) throws TwitterException {
        String nextPage = query.nextPage();
        String str = y.ݮڮֲڭܩ(-628079164);
        if (nextPage != null) {
            return this.factory.createQueryResult(get(this.conf.getRestBaseURL() + str + query.nextPage()), query);
        }
        return this.factory.createQueryResult(get(this.conf.getRestBaseURL() + str, query.asHttpParameterArray()), query);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
        return removeDMsNotSentToMe(getDirectMessages(100));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException {
        return removeDMsNotSentToMe(getDirectMessages(paging.getCount()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public DirectMessageList getDirectMessages(int i) throws TwitterException {
        return this.factory.createDirectMessageList(get(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628085492), new HttpParameter(y.٬ݯح׭٩(575838374), i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public DirectMessageList getDirectMessages(int i, String str) throws TwitterException {
        return this.factory.createDirectMessageList(get(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628085492), new HttpParameter(y.٬ݯح׭٩(575838374), i), new HttpParameter(y.ݮڮֲڭܩ(-628085188), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
        return removeDMsNotSentByMe(getDirectMessages(100));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException {
        return removeDMsNotSentByMe(getDirectMessages(paging.getCount()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DirectMessageList removeDMsNotSentToMe(DirectMessageList directMessageList) throws TwitterException {
        if (this.myId == -1) {
            this.myId = verifyCredentials().getId();
        }
        for (int size = directMessageList.size() - 1; size >= 0; size--) {
            if (((DirectMessage) directMessageList.get(size)).getRecipientId() != this.myId) {
                directMessageList.remove(size);
            }
        }
        return directMessageList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DirectMessageList removeDMsNotSentByMe(DirectMessageList directMessageList) throws TwitterException {
        if (this.myId == -1) {
            this.myId = verifyCredentials().getId();
        }
        for (int size = directMessageList.size() - 1; size >= 0; size--) {
            if (((DirectMessage) directMessageList.get(size)).getSenderId() != this.myId) {
                directMessageList.remove(size);
            }
        }
        return directMessageList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public DirectMessage showDirectMessage(long j) throws TwitterException {
        return this.factory.createDirectMessage(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575113238) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public DirectMessage destroyDirectMessage(long j) throws TwitterException {
        ensureAuthorizationEnabled();
        this.http.delete(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780552384) + j, null, this.auth, null);
        return new DirectMessage() { // from class: twitter4j.TwitterImpl.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public long getId() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public String getText() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public long getSenderId() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public long getRecipientId() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public Date getCreatedAt() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public String getSenderScreenName() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public String getRecipientScreenName() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public User getSender() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.DirectMessage
            public User getRecipient() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.EntitySupport
            public UserMentionEntity[] getUserMentionEntities() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.EntitySupport
            public URLEntity[] getURLEntities() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.EntitySupport
            public HashtagEntity[] getHashtagEntities() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.EntitySupport
            public MediaEntity[] getMediaEntities() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.EntitySupport
            public SymbolEntity[] getSymbolEntities() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.TwitterResponse
            public RateLimitStatus getRateLimitStatus() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.TwitterResponse
            public int getAccessLevel() {
                throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1158377839));
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public DirectMessage sendDirectMessage(long j, String str, long j2) throws TwitterException {
        String str2 = y.ۮڭڭܬި(862984851);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", str2);
            jSONObject2.put(str2, createMessageCreateJsonObject(j, str, j2));
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, jSONObject2);
            return this.factory.createDirectMessage(post(this.conf.getRestBaseURL() + "direct_messages/events/new.json", jSONObject));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static JSONObject createMessageCreateJsonObject(long j, String str, long j2) throws JSONException {
        String str2 = y.ۮڭڭܬި(862094195);
        String str3 = j2 == -1 ? null : str2;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(y.֬ڱܱײٮ(-1159067807), j);
        jSONObject.put(TypedValues.AttributesType.S_TARGET, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("text", str);
        if (str3 != null && j2 != -1) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", str3);
            if (str3.equals(str2)) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(y.ٲٴݴ״ٰ(1781792816), j2);
                jSONObject4.put(str2, jSONObject5);
            }
            jSONObject3.put("attachment", jSONObject4);
        }
        jSONObject.put("message_data", jSONObject3);
        return jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public DirectMessage sendDirectMessage(long j, String str) throws TwitterException {
        return sendDirectMessage(j, str, -1L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public DirectMessage sendDirectMessage(String str, String str2) throws TwitterException {
        return sendDirectMessage(showUser(str).getId(), str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.DirectMessagesResources
    public InputStream getDMImageAsStream(String str) throws TwitterException {
        return get(str).asStream();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getNoRetweetsFriendships() throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158400207)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFriendsIDs(long j) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780551504) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFriendsIDs(long j, long j2) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575132966) + j + "&cursor=" + j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFriendsIDs(long j, long j2, int i) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575132966) + j + "&cursor=" + j2 + "&count=" + i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFriendsIDs(String str, long j) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513962103), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFriendsIDs(String str, long j, int i) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513962103), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j), new HttpParameter(KGService.COUNT, i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFollowersIDs(long j) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052920885) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFollowersIDs(long j, long j2) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052921173) + j + "&cursor=" + j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFollowersIDs(long j, long j2, int i) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052921173) + j + "&cursor=" + j2 + "&count=" + i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFollowersIDs(String str, long j) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513962903), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getFollowersIDs(String str, long j, int i) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513962903), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j), new HttpParameter(KGService.COUNT, i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public ResponseList<Friendship> lookupFriendships(long... jArr) throws TwitterException {
        return this.factory.createFriendshipList(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575127310) + StringUtil.join(jArr)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public ResponseList<Friendship> lookupFriendships(String... strArr) throws TwitterException {
        return this.factory.createFriendshipList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780575064) + StringUtil.join(strArr)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getIncomingFriendships(long j) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158401951) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public IDs getOutgoingFriendships(long j) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575123454) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public User createFriendship(long j) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158388103) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public User createFriendship(String str) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780558656), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public User createFriendship(long j, boolean z) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158388103) + j + "&follow=" + z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public User createFriendship(String str, boolean z) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780558656), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ٲٴݴ״ٰ(1780558344), z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public User destroyFriendship(long j) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ۮڭڭܬި(863004363) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public User destroyFriendship(String str) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393822026), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public Relationship updateFriendship(long j, boolean z, boolean z2) throws TwitterException {
        return this.factory.createRelationship(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513977167), new HttpParameter(y.ݬֲ֮ܲت(1512773759), j), new HttpParameter("device", z), new HttpParameter("retweets", z2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public Relationship updateFriendship(String str, boolean z, boolean z2) throws TwitterException {
        return this.factory.createRelationship(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513977167), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628479692), z), new HttpParameter("retweets", z2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public Relationship showFriendship(long j, long j2) throws TwitterException {
        return this.factory.createRelationship(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513973455), new HttpParameter(y.ٴسسݬߨ(1393839698), j), new HttpParameter("target_id", j2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public Relationship showFriendship(String str, String str2) throws TwitterException {
        return this.factory.createRelationship(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513973455), HttpParameter.getParameterArray(y.دײܮڳܯ(2052934677), str, y.ݮڮֲڭܩ(-628065452), str2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFriendsList(long j, long j2) throws TwitterException {
        return getFriendsList(j, j2, 20);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFriendsList(long j, long j2, int i) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628087252) + j + "&cursor=" + j2 + "&count=" + i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFriendsList(String str, long j) throws TwitterException {
        return getFriendsList(str, j, 20);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFriendsList(String str, long j, int i) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575133550), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j), new HttpParameter(KGService.COUNT, i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFriendsList(long j, long j2, int i, boolean z, boolean z2) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628087252) + j + "&cursor=" + j2 + "&count=" + i + "&skip_status=" + z + "&include_user_entities=" + z2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFriendsList(String str, long j, int i, boolean z, boolean z2) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575133550), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j), new HttpParameter(KGService.COUNT, i), new HttpParameter("skip_status", z), new HttpParameter("include_user_entities", z2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFollowersList(long j, long j2) throws TwitterException {
        return getFollowersList(j, j2, 20);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFollowersList(String str, long j) throws TwitterException {
        return getFollowersList(str, j, 20);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFollowersList(long j, long j2, int i) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(863010715) + j + "&cursor=" + j2 + "&count=" + i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFollowersList(String str, long j, int i) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052920813), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j), new HttpParameter(KGService.COUNT, i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFollowersList(long j, long j2, int i, boolean z, boolean z2) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(863010715) + j + "&cursor=" + j2 + "&count=" + i + "&skip_status=" + z + "&include_user_entities=" + z2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FriendsFollowersResources
    public PagableResponseList<User> getFollowersList(String str, long j, int i, boolean z, boolean z2) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052920813), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j), new HttpParameter(KGService.COUNT, i), new HttpParameter("skip_status", z), new HttpParameter("include_user_entities", z2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public AccountSettings getAccountSettings() throws TwitterException {
        return this.factory.createAccountSettings(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780555360)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User verifyCredentials() throws TwitterException {
        return super.fillInIDAndScreenName(new HttpParameter[]{new HttpParameter(y.ݬֲ֮ܲت(1513979335), this.conf.isIncludeEmailEnabled())});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public AccountSettings updateAccountSettings(Integer num, Boolean bool, String str, String str2, String str3, String str4) throws TwitterException {
        ArrayList arrayList = new ArrayList(6);
        if (num != null) {
            arrayList.add(new HttpParameter(y.ۮڭڭܬި(862991739), num.intValue()));
        }
        if (bool != null) {
            arrayList.add(new HttpParameter(y.دײܮڳܯ(2052939405), bool.toString()));
        }
        if (str != null) {
            arrayList.add(new HttpParameter("start_sleep_time", str));
        }
        if (str2 != null) {
            arrayList.add(new HttpParameter("end_sleep_time", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("time_zone", str3));
        }
        if (str4 != null) {
            arrayList.add(new HttpParameter("lang", str4));
        }
        return this.factory.createAccountSettings(post(this.conf.getRestBaseURL() + "account/settings.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public AccountSettings updateAllowDmsFrom(String str) throws TwitterException {
        return this.factory.createAccountSettings(post(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575117742) + str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User updateProfile(String str, String str2, String str3, String str4) throws TwitterException {
        ArrayList arrayList = new ArrayList(4);
        addParameterToList(arrayList, y.ٲٴݴ״ٰ(1781623392), str);
        addParameterToList(arrayList, "url", str2);
        addParameterToList(arrayList, "location", str3);
        addParameterToList(arrayList, "description", str4);
        return this.factory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User updateProfileBackgroundImage(File file, boolean z) throws TwitterException {
        checkFileValidity(file);
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052939245), new HttpParameter(y.֬ڱܱײٮ(-1159562919), file), new HttpParameter(y.ٲٴݴ״ٰ(1780565528), z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User updateProfileBackgroundImage(InputStream inputStream, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        String str = this.conf.getRestBaseURL() + y.دײܮڳܯ(2052939245);
        String str2 = y.֬ڱܱײٮ(-1159562919);
        return objectFactory.createUser(post(str, new HttpParameter(str2, str2, inputStream), new HttpParameter(y.ٲٴݴ״ٰ(1780565528), z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User updateProfileColors(String str, String str2, String str3, String str4, String str5) throws TwitterException {
        throw new UnsupportedOperationException("this API is no longer supported. https://twittercommunity.com/t/deprecation-of-account-update-profile-colors/28692");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addParameterToList(List<HttpParameter> list, String str, String str2) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User updateProfileImage(File file) throws TwitterException {
        checkFileValidity(file);
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513976071), new HttpParameter(y.֬ڱܱײٮ(-1159562919), file)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User updateProfileImage(InputStream inputStream) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        String str = this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513976071);
        String str2 = y.֬ڱܱײٮ(-1159562919);
        return objectFactory.createUser(post(str, new HttpParameter(str2, str2, inputStream)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkFileValidity(File file) throws TwitterException {
        if (!file.exists()) {
            throw new TwitterException(new FileNotFoundException(file + y.ݬֲ֮ܲت(1513950751)));
        }
        if (!file.isFile()) {
            throw new TwitterException(new IOException(file + y.ٲٴݴ״ٰ(1780562920)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public PagableResponseList<User> getBlocksList() throws TwitterException {
        return getBlocksList(-1L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public PagableResponseList<User> getBlocksList(long j) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158397687) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public IDs getBlocksIDs() throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052915349)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public IDs getBlocksIDs(long j) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158390191) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User createBlock(long j) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780557808) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User createBlock(String str) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628093540), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User destroyBlock(long j) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513957287) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User destroyBlock(String str) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575129886), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public PagableResponseList<User> getMutesList(long j) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052942693) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public IDs getMutesIDs(long j) throws TwitterException {
        return this.factory.createIDs(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(862978323) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User createMute(long j) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513955015) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User createMute(String str) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393833522), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User destroyMute(long j) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628081228) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User destroyMute(String str) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513955687), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public ResponseList<User> lookupUsers(long... jArr) throws TwitterException {
        return this.factory.createUserList(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575123790), new HttpParameter(y.ݬֲ֮ܲت(1512773759), StringUtil.join(jArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public ResponseList<User> lookupUsers(String... strArr) throws TwitterException {
        return this.factory.createUserList(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575123790), new HttpParameter(y.٬ݯح׭٩(576238206), StringUtil.join(strArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User showUser(long j) throws TwitterException {
        return this.factory.createUser(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052934309) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public User showUser(String str) throws TwitterException {
        return this.factory.createUser(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(862986387), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public ResponseList<User> searchUsers(String str, int i) throws TwitterException {
        return this.factory.createUserList(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513969959), new HttpParameter(y.ٴسسݬߨ(1393256146), str), new HttpParameter(y.دײܮڳܯ(2052944165), 20), new HttpParameter(y.ٲٴݴ״ٰ(1782449768), i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public ResponseList<User> getContributees(long j) throws TwitterException {
        return this.factory.createUserList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780548280) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public ResponseList<User> getContributees(String str) throws TwitterException {
        return this.factory.createUserList(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(863008651), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public ResponseList<User> getContributors(long j) throws TwitterException {
        return this.factory.createUserList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780547728) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public ResponseList<User> getContributors(String str) throws TwitterException {
        return this.factory.createUserList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780549504), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public void removeProfileBanner() throws TwitterException {
        post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628080060));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public void updateProfileBanner(File file) throws TwitterException {
        checkFileValidity(file);
        post(this.conf.getRestBaseURL() + y.ۮڭڭܬި(862990347), new HttpParameter(y.ٲٴݴ״ٰ(1780565320), file));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.UsersResources
    public void updateProfileBanner(InputStream inputStream) throws TwitterException {
        String str = this.conf.getRestBaseURL() + y.ۮڭڭܬި(862990347);
        String str2 = y.ٲٴݴ״ٰ(1780565320);
        post(str, new HttpParameter(str2, str2, inputStream));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SuggestedUsersResources
    public ResponseList<User> getUserSuggestions(String str) throws TwitterException {
        try {
            return this.factory.createUserListFromJSONArray_Users(get(this.conf.getRestBaseURL() + "users/suggestions/" + URLEncoder.encode(str, "UTF-8") + ".json"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SuggestedUsersResources
    public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
        return this.factory.createCategoryList(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(862980755)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SuggestedUsersResources
    public ResponseList<User> getMemberSuggestions(String str) throws TwitterException {
        try {
            return this.factory.createUserListFromJSONArray(get(this.conf.getRestBaseURL() + "users/suggestions/" + URLEncoder.encode(str, "UTF-8") + "/members.json"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FavoritesResources
    public ResponseList<Status> getFavorites() throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158396015)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FavoritesResources
    public ResponseList<Status> getFavorites(long j) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780548672) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FavoritesResources
    public ResponseList<Status> getFavorites(String str) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158396015), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FavoritesResources
    public ResponseList<Status> getFavorites(Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158396015), paging.asPostParameterArray()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FavoritesResources
    public ResponseList<Status> getFavorites(long j, Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158396015), mergeParameters(new HttpParameter[]{new HttpParameter(y.ݬֲ֮ܲت(1512773759), j)}, paging.asPostParameterArray())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FavoritesResources
    public ResponseList<Status> getFavorites(String str, Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158396015), mergeParameters(new HttpParameter[]{new HttpParameter(y.٬ݯح׭٩(576238206), str)}, paging.asPostParameterArray())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FavoritesResources
    public Status destroyFavorite(long j) throws TwitterException {
        return this.factory.createStatus(post(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158393311) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.FavoritesResources
    public Status createFavorite(long j) throws TwitterException {
        return this.factory.createStatus(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628093380) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public ResponseList<UserList> getUserLists(String str) throws TwitterException {
        return getUserLists(str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public ResponseList<UserList> getUserLists(String str, boolean z) throws TwitterException {
        return this.factory.createUserListList(get(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628077652), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.ٴسسݬߨ(1393850586), z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public ResponseList<UserList> getUserLists(long j) throws TwitterException {
        return getUserLists(j, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public ResponseList<UserList> getUserLists(long j, boolean z) throws TwitterException {
        return this.factory.createUserListList(get(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628077652), new HttpParameter(y.ݬֲ֮ܲت(1512773759), j), new HttpParameter("reverse", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public ResponseList<Status> getUserListStatuses(long j, Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780572880), mergeParameters(paging.asPostParameterArray(Paging.SMCP, y.٬ݯح׭٩(575838374)), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public ResponseList<Status> getUserListStatuses(long j, String str, Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780572880), mergeParameters(paging.asPostParameterArray(Paging.SMCP, y.٬ݯح׭٩(575838374)), new HttpParameter[]{new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str)})));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public ResponseList<Status> getUserListStatuses(String str, String str2, Paging paging) throws TwitterException {
        return this.factory.createStatusList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780572880), mergeParameters(paging.asPostParameterArray(Paging.SMCP, y.٬ݯح׭٩(575838374)), new HttpParameter[]{new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2)})));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListMember(long j, long j2) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628084324), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j), new HttpParameter("user_id", j2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListMember(long j, String str, long j2) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628084324), new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str), new HttpParameter("user_id", j2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListMember(long j, String str) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628084324), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j), new HttpParameter(FirebaseAnalytics.Param.SCREEN_NAME, str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListMember(String str, String str2, long j) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628084324), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2), new HttpParameter("user_id", j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListMembers(long j, String[] strArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513958711), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j), new HttpParameter(FirebaseAnalytics.Param.SCREEN_NAME, StringUtil.join(strArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListMembers(long j, long[] jArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513958711), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListMembers(String str, String str2, String[] strArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513958711), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2), new HttpParameter(FirebaseAnalytics.Param.SCREEN_NAME, StringUtil.join(strArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(long j) throws TwitterException {
        return getUserListMemberships(20, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(int i, long j) throws TwitterException {
        return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393851738), new HttpParameter(y.ݮڮֲڭܩ(-628085188), j), new HttpParameter(KGService.COUNT, i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(String str, long j) throws TwitterException {
        return getUserListMemberships(str, j, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(String str, int i, long j) throws TwitterException {
        return getUserListMemberships(str, i, j, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(String str, long j, boolean z) throws TwitterException {
        return getUserListMemberships(str, 20, j, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(String str, int i, long j, boolean z) throws TwitterException {
        return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393851738), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.٬ݯح׭٩(575838374), i), new HttpParameter("cursor", j), new HttpParameter("filter_to_owned_lists", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(long j, long j2) throws TwitterException {
        return getUserListMemberships(j, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(long j, int i, long j2) throws TwitterException {
        return getUserListMemberships(j, i, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(long j, long j2, boolean z) throws TwitterException {
        return getUserListMemberships(j, 20, j2, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListMemberships(long j, int i, long j2, boolean z) throws TwitterException {
        return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393851738), new HttpParameter(y.ݬֲ֮ܲت(1512773759), j), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j2), new HttpParameter("filter_to_owned_lists", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(long j, long j2) throws TwitterException {
        return getUserListSubscribers(j, 20, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(long j, int i, long j2) throws TwitterException {
        return getUserListSubscribers(j, i, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(long j, int i, long j2, boolean z) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052946973), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(long j, String str, long j2) throws TwitterException {
        return getUserListSubscribers(j, str, 20, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(long j, String str, int i, long j2) throws TwitterException {
        return getUserListSubscribers(j, str, i, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(long j, String str, int i, long j2, boolean z) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052946973), new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(String str, String str2, long j) throws TwitterException {
        return getUserListSubscribers(str, str2, 20, j, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(String str, String str2, int i, long j) throws TwitterException {
        return getUserListSubscribers(str, str2, i, j, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListSubscribers(String str, String str2, int i, long j, boolean z) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052946973), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j), new HttpParameter("skip_status", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListSubscription(long j) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095212), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListSubscription(long j, String str) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095212), new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListSubscription(String str, String str2) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095212), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public User showUserListSubscription(long j, long j2) throws TwitterException {
        return this.factory.createUser(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052932925) + j + "&user_id=" + j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public User showUserListSubscription(long j, String str, long j2) throws TwitterException {
        return this.factory.createUser(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(862988619) + j + "&slug=" + str + "&user_id=" + j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public User showUserListSubscription(String str, String str2, long j) throws TwitterException {
        return this.factory.createUser(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393836522), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2), new HttpParameter("user_id", j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListSubscription(long j) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628083716), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListSubscription(long j, String str) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628083716), new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserListSubscription(String str, String str2) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628083716), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMembers(long j, long... jArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095668), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMembers(long j, String str, long... jArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095668), new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMembers(String str, String str2, long... jArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095668), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2), new HttpParameter("user_id", StringUtil.join(jArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMembers(long j, String... strArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095668), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j), new HttpParameter(FirebaseAnalytics.Param.SCREEN_NAME, StringUtil.join(strArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMembers(long j, String str, String... strArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095668), new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str), new HttpParameter(FirebaseAnalytics.Param.SCREEN_NAME, StringUtil.join(strArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMembers(String str, String str2, String... strArr) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628095668), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2), new HttpParameter(FirebaseAnalytics.Param.SCREEN_NAME, StringUtil.join(strArr))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public User showUserListMembership(long j, long j2) throws TwitterException {
        return this.factory.createUser(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393837058) + j + "&user_id=" + j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public User showUserListMembership(long j, String str, long j2) throws TwitterException {
        return this.factory.createUser(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158408111) + j + "&slug=" + str + "&user_id=" + j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public User showUserListMembership(String str, String str2, long j) throws TwitterException {
        return this.factory.createUser(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780570512), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2), new HttpParameter("user_id", j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(long j, long j2) throws TwitterException {
        return getUserListMembers(j, 20, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(long j, int i, long j2) throws TwitterException {
        return getUserListMembers(j, i, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(long j, int i, long j2, boolean z) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780573040), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(long j, String str, long j2) throws TwitterException {
        return getUserListMembers(j, str, 20, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(long j, String str, int i, long j2) throws TwitterException {
        return getUserListMembers(j, str, i, j2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(long j, String str, int i, long j2, boolean z) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780573040), new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j2), new HttpParameter("skip_status", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(String str, String str2, long j) throws TwitterException {
        return getUserListMembers(str, str2, 20, j, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(String str, String str2, int i, long j) throws TwitterException {
        return getUserListMembers(str, str2, i, j, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<User> getUserListMembers(String str, String str2, int i, long j, boolean z) throws TwitterException {
        return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780573040), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j), new HttpParameter("skip_status", z)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMember(long j, long j2) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158386311), new HttpParameter(y.ݬֲ֮ܲت(1512773759), j2), new HttpParameter("list_id", j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMember(long j, String str, long j2) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158386311), new HttpParameter(y.ݬֲ֮ܲت(1512773759), j2), new HttpParameter("owner_id", j), new HttpParameter("slug", str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserListMember(String str, String str2, long j) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158386311), new HttpParameter(y.ݬֲ֮ܲت(1512773759), j), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserList(long j) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052917085), new HttpParameter(y.ݮڮֲڭܩ(-628095436), j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserList(long j, String str) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052917085), new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList destroyUserList(String str, String str2) throws TwitterException {
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052917085), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList updateUserList(long j, String str, boolean z, String str2) throws TwitterException {
        return updateUserList(str, z, str2, new HttpParameter(y.ݮڮֲڭܩ(-628095436), j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList updateUserList(long j, String str, String str2, boolean z, String str3) throws TwitterException {
        return updateUserList(str2, z, str3, new HttpParameter(y.ٲٴݴ״ٰ(1780559104), j), new HttpParameter("slug", str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList updateUserList(String str, String str2, String str3, boolean z, String str4) throws TwitterException {
        return updateUserList(str3, z, str4, new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UserList updateUserList(String str, boolean z, String str2, HttpParameter... httpParameterArr) throws TwitterException {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, httpParameterArr);
        if (str != null) {
            arrayList.add(new HttpParameter(y.ٲٴݴ״ٰ(1781623392), str));
        }
        arrayList.add(new HttpParameter("mode", z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/update.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList createUserList(String str, boolean z, String str2) throws TwitterException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpParameter(y.ٲٴݴ״ٰ(1781623392), str));
        arrayList.add(new HttpParameter(y.ٲٴݴ״ٰ(1780559616), z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/create.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList showUserList(long j) throws TwitterException {
        return this.factory.createAUserList(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052933725) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList showUserList(long j, String str) throws TwitterException {
        return this.factory.createAUserList(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513972071) + j + "&slug=" + str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public UserList showUserList(String str, String str2) throws TwitterException {
        return this.factory.createAUserList(get(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628064380), new HttpParameter(y.֬ڱܱײٮ(-1158385775), str), new HttpParameter(y.ۮڭڭܬި(862860915), str2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListSubscriptions(String str, long j) throws TwitterException {
        return getUserListSubscriptions(str, 20, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListSubscriptions(String str, int i, long j) throws TwitterException {
        return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158405615), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.٬ݯح׭٩(575838374), i), new HttpParameter("cursor", j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListSubscriptions(long j, long j2) throws TwitterException {
        return getUserListSubscriptions(j, 20, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListSubscriptions(long j, int i, long j2) throws TwitterException {
        return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158405615), new HttpParameter(y.ݬֲ֮ܲت(1512773759), j), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListsOwnerships(String str, long j) throws TwitterException {
        return getUserListsOwnerships(str, 20, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListsOwnerships(String str, int i, long j) throws TwitterException {
        return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393850514), new HttpParameter(y.٬ݯح׭٩(576238206), str), new HttpParameter(y.٬ݯح׭٩(575838374), i), new HttpParameter("cursor", j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListsOwnerships(long j, long j2) throws TwitterException {
        return getUserListsOwnerships(j, 20, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.ListsResources
    public PagableResponseList<UserList> getUserListsOwnerships(long j, int i, long j2) throws TwitterException {
        return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393850514), new HttpParameter(y.ݬֲ֮ܲت(1512773759), j), new HttpParameter(KGService.COUNT, i), new HttpParameter("cursor", j2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SavedSearchesResources
    public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
        return this.factory.createSavedSearchList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158397975)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SavedSearchesResources
    public SavedSearch showSavedSearch(long j) throws TwitterException {
        return this.factory.createSavedSearch(get(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780568240) + j + ".json"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SavedSearchesResources
    public SavedSearch createSavedSearch(String str) throws TwitterException {
        return this.factory.createSavedSearch(post(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393833834), new HttpParameter(y.ݮڮֲڭܩ(-628121724), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SavedSearchesResources
    public SavedSearch destroySavedSearch(long j) throws TwitterException {
        return this.factory.createSavedSearch(post(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575131646) + j + ".json"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.PlacesGeoResources
    public Place getGeoDetails(String str) throws TwitterException {
        return this.factory.createPlace(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052919685) + str + y.٬ݯح׭٩(575121422)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.PlacesGeoResources
    public ResponseList<Place> reverseGeoCode(GeoQuery geoQuery) throws TwitterException {
        try {
            return this.factory.createPlaceList(get(this.conf.getRestBaseURL() + "geo/reverse_geocode.json", geoQuery.asHttpParameterArray()));
        } catch (TwitterException e) {
            if (e.getStatusCode() == 404) {
                return this.factory.createEmptyResponseList();
            }
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.PlacesGeoResources
    public ResponseList<Place> searchPlaces(GeoQuery geoQuery) throws TwitterException {
        return this.factory.createPlaceList(get(this.conf.getRestBaseURL() + y.ۮڭڭܬި(862984963), geoQuery.asHttpParameterArray()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.PlacesGeoResources
    public ResponseList<Place> getSimilarPlaces(GeoLocation geoLocation, String str, String str2, String str3) throws TwitterException {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new HttpParameter(y.֬ڱܱײٮ(-1158941183), geoLocation.getLatitude()));
        arrayList.add(new HttpParameter(y.֬ڱܱײٮ(-1159246383), geoLocation.getLongitude()));
        arrayList.add(new HttpParameter(y.ٲٴݴ״ٰ(1781623392), str));
        if (str2 != null) {
            arrayList.add(new HttpParameter("contained_within", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("attribute:street_address", str3));
        }
        return this.factory.createPlaceList(get(this.conf.getRestBaseURL() + "geo/similar_places.json", (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TrendsResources
    public Trends getPlaceTrends(int i) throws TwitterException {
        return this.factory.createTrends(get(this.conf.getRestBaseURL() + y.ٴسسݬߨ(1393845434) + i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TrendsResources
    public ResponseList<Location> getAvailableTrends() throws TwitterException {
        return this.factory.createLocationList(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158389999)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.TrendsResources
    public ResponseList<Location> getClosestTrends(GeoLocation geoLocation) throws TwitterException {
        return this.factory.createLocationList(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575134006), new HttpParameter(y.֬ڱܱײٮ(-1158941183), geoLocation.getLatitude()), new HttpParameter(y.֬ڱܱײٮ(-1159246383), geoLocation.getLongitude())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SpamReportingResource
    public User reportSpam(long j) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ݮڮֲڭܩ(-628079772) + j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.SpamReportingResource
    public User reportSpam(String str) throws TwitterException {
        return this.factory.createUser(post(this.conf.getRestBaseURL() + y.ٲٴݴ״ٰ(1780576040), new HttpParameter(y.٬ݯح׭٩(576238206), str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources
    public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
        return this.factory.createTwitterAPIConfiguration(get(this.conf.getRestBaseURL() + y.֬ڱܱײٮ(-1158390383)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources
    public ResponseList<HelpResources.Language> getLanguages() throws TwitterException {
        return this.factory.createLanguageList(get(this.conf.getRestBaseURL() + y.دײܮڳܯ(2052942853)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources
    public String getPrivacyPolicy() throws TwitterException {
        try {
            return get(this.conf.getRestBaseURL() + "help/privacy.json").asJSONObject().getString(ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources
    public String getTermsOfService() throws TwitterException {
        try {
            return get(this.conf.getRestBaseURL() + "help/tos.json").asJSONObject().getString("tos");
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources
    public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
        return this.factory.createRateLimitStatuses(get(this.conf.getRestBaseURL() + y.٬ݯح׭٩(575119790)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.api.HelpResources
    public Map<String, RateLimitStatus> getRateLimitStatus(String... strArr) throws TwitterException {
        return this.factory.createRateLimitStatuses(get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513966887) + StringUtil.join(strArr)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpResponse get(String str) throws TwitterException {
        ensureAuthorizationEnabled();
        if (this.IMPLICIT_PARAMS_STR.length() > 0) {
            String str2 = y.ٴسسݬߨ(1393197818);
            if (str.contains(str2)) {
                str = str + y.֬ڱܱײٮ(-1159719487) + this.IMPLICIT_PARAMS_STR;
            } else {
                str = str + str2 + this.IMPLICIT_PARAMS_STR;
            }
        }
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, null, this.auth, this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponse = this.http.get(str, null, this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
            return httpResponse;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(null));
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpResponse get(String str, HttpParameter... httpParameterArr) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, mergeImplicitParams(httpParameterArr), this.auth, this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse httpResponse = this.http.get(str, mergeImplicitParams(httpParameterArr), this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
            return httpResponse;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(null));
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpResponse post(String str) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, this.IMPLICIT_PARAMS, this.auth, this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse post = this.http.post(str, this.IMPLICIT_PARAMS, this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(post));
            return post;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(null));
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpResponse post(String str, HttpParameter... httpParameterArr) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, mergeImplicitParams(httpParameterArr), this.auth, this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse post = this.http.post(str, mergeImplicitParams(httpParameterArr), this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(post));
            return post;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(null));
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpResponse post(String str, JSONObject jSONObject) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, new HttpParameter[]{new HttpParameter(jSONObject)}, this.auth, this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse post = this.http.post(str, new HttpParameter[]{new HttpParameter(jSONObject)}, this.auth, this);
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(post));
            return post;
        } catch (Throwable th) {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(null));
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter[] httpParameterArr2) {
        if (httpParameterArr == null || httpParameterArr2 == null) {
            return (httpParameterArr == null && httpParameterArr2 == null) ? new HttpParameter[0] : httpParameterArr != null ? httpParameterArr : httpParameterArr2;
        }
        HttpParameter[] httpParameterArr3 = new HttpParameter[httpParameterArr.length + httpParameterArr2.length];
        System.arraycopy(httpParameterArr, 0, httpParameterArr3, 0, httpParameterArr.length);
        System.arraycopy(httpParameterArr2, 0, httpParameterArr3, httpParameterArr.length, httpParameterArr2.length);
        return httpParameterArr3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter httpParameter) {
        if (httpParameterArr == null || httpParameter == null) {
            return (httpParameterArr == null && httpParameter == null) ? new HttpParameter[0] : httpParameterArr != null ? httpParameterArr : new HttpParameter[]{httpParameter};
        }
        int length = httpParameterArr.length + 1;
        HttpParameter[] httpParameterArr2 = new HttpParameter[length];
        System.arraycopy(httpParameterArr, 0, httpParameterArr2, 0, httpParameterArr.length);
        httpParameterArr2[length - 1] = httpParameter;
        return httpParameterArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpParameter[] mergeImplicitParams(HttpParameter... httpParameterArr) {
        return mergeParameters(httpParameterArr, this.IMPLICIT_PARAMS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isOk(HttpResponse httpResponse) {
        return httpResponse != null && httpResponse.getStatusCode() < 300;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterBaseImpl
    public String toString() {
        return y.٬ݯح׭٩(575112878) + this.INCLUDE_MY_RETWEET + '}';
    }
}
