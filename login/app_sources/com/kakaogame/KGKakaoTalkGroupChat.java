package com.kakaogame;

import android.app.Activity;
import com.kakao.sdk.partner.talk.model.Chat;
import com.kakao.sdk.partner.talk.model.Chats;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoTalkGroupChat;
import com.kakaogame.KGResult;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.kakao.KakaoGameAPI;
import com.kakaogame.kakao.KakaoManager;
import com.kakaogame.kakao.KakaoUtil;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoTalkGroupChat.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001f !B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0010\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006\""}, m839d2 = {"Lcom/kakaogame/KGKakaoTalkGroupChat;", "Lcom/kakaogame/KGObject;", "chatInfo", "Lcom/kakao/sdk/partner/talk/model/Chat;", "(Lcom/kakao/sdk/partner/talk/model/Chat;)V", "content", "", "", "", "(Ljava/util/Map;)V", KGKakaoTalkGroupChat.KEY_CHAT_ID, "", "getChatId", "()J", KGKakaoTalkGroupChat.KEY_CHAT_TYPE, "Lcom/kakaogame/KGKakaoTalkGroupChat$KGKakaoTalkGroupChatType;", "getChatType", "()Lcom/kakaogame/KGKakaoTalkGroupChat$KGKakaoTalkGroupChatType;", KGKakaoTalkGroupChat.KEY_MEMBER_COUNT, "", "getMemberCount", "()I", KGKakaoTalkGroupChat.KEY_MEMBER_THUMBNAIL_IMAGE_URLS, "", "getMemberThumbnailImageUrls", "()Ljava/util/List;", "thumbnailImageUrl", "getThumbnailImageUrl", "()Ljava/lang/String;", "title", "getTitle", "Companion", "KGKakaoTalkGroupChatType", "KGKakaoTalkGroupChatsResponse", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoTalkGroupChat extends KGObject {
    private static final String CLASS_NAME_KEY = "KGKakaoTalkGroupChat";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_CHAT_ID = "chatId";
    private static final String KEY_CHAT_TYPE = "chatType";
    private static final String KEY_MEMBER_COUNT = "memberCount";
    private static final String KEY_MEMBER_THUMBNAIL_IMAGE_URLS = "memberThumbnailImageUrls";
    private static final String KEY_THUMBNAIL_IMAGE_URL = "thumbnailImageUrl";
    private static final String KEY_TITLE = "title";
    private static final String TAG = "KGKakaoTalkGroupChat";
    private static final long serialVersionUID = 6267653037479105503L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadGroupChats(int i, int i2, KGResultCallback<KGKakaoTalkGroupChatsResponse> kGResultCallback) {
        INSTANCE.loadGroupChats(i, i2, kGResultCallback);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoTalkGroupChat(Chat chat) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(chat, y.ۮڭڭܬި(862340699));
        Logger.INSTANCE.m706v(y.֬ڱܱײٮ(-1159557263), y.ݮڮֲڭܩ(-628745236) + chat);
        put(y.ٲٴݴ״ٰ(1782003536), Long.valueOf(chat.getId()));
        put(y.ٲٴݴ״ٰ(1781623336), chat.getTitle());
        put(y.ݬֲ֮ܲت(1512826055), chat.getImageUrl());
        put(y.ٲٴݴ״ٰ(1782003600), chat.getMemberCount());
        put(y.ݮڮֲڭܩ(-628745028), chat.getDisplayMemberImages());
        put(y.ݮڮֲڭܩ(-628744724), chat.getChatType().toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoTalkGroupChat(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getChatId() {
        Object obj = get(y.ٲٴݴ״ٰ(1782003536));
        Intrinsics.checkNotNull(obj, y.دײܮڳܯ(2051781685));
        return ((Long) obj).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitle() {
        return (String) get(y.ٲٴݴ״ٰ(1781623336));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getThumbnailImageUrl() {
        return (String) get(y.ݬֲ֮ܲت(1512826055));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getMemberCount() {
        Object obj = get(y.ٲٴݴ״ٰ(1782003600));
        Intrinsics.checkNotNull(obj, y.ۮڭڭܬި(862379403));
        return ((Integer) obj).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getMemberThumbnailImageUrls() {
        return (List) get(y.ݮڮֲڭܩ(-628745028));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGKakaoTalkGroupChatType getChatType() {
        String str = (String) get(y.ݮڮֲڭܩ(-628744724));
        for (KGKakaoTalkGroupChatType kGKakaoTalkGroupChatType : KGKakaoTalkGroupChatType.values()) {
            if (StringsKt.equals(kGKakaoTalkGroupChatType.getValue(), str, true)) {
                return kGKakaoTalkGroupChatType;
            }
        }
        return KGKakaoTalkGroupChatType.Regular;
    }

    /* compiled from: KGKakaoTalkGroupChat.kt */
    @Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/KGKakaoTalkGroupChat$KGKakaoTalkGroupChatsResponse;", "", "totalCount", "", "(I)V", "response", "Lcom/kakao/sdk/partner/talk/model/Chats;", "(Lcom/kakao/sdk/partner/talk/model/Chats;)V", "groupChats", "", "Lcom/kakaogame/KGKakaoTalkGroupChat;", "getGroupChats", "()Ljava/util/List;", "kakaoChatInfoList", "", "getTotalCount", "()I", "Companion", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGKakaoTalkGroupChatsResponse {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<KGKakaoTalkGroupChat> kakaoChatInfoList;
        private final int totalCount;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ KGKakaoTalkGroupChatsResponse(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTotalCount() {
            return this.totalCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGKakaoTalkGroupChatsResponse(int i) {
            this.kakaoChatInfoList = new ArrayList();
            this.totalCount = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGKakaoTalkGroupChatsResponse(Chats chats) {
            Intrinsics.checkNotNullParameter(chats, y.٬ݯح׭٩(575793966));
            this.kakaoChatInfoList = new ArrayList();
            this.totalCount = chats.getTotalCount();
            List<Chat> elements = chats.getElements();
            if (elements != null) {
                Iterator<T> it = elements.iterator();
                while (it.hasNext()) {
                    this.kakaoChatInfoList.add(new KGKakaoTalkGroupChat((Chat) it.next()));
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<KGKakaoTalkGroupChat> getGroupChats() {
            return this.kakaoChatInfoList;
        }

        /* compiled from: KGKakaoTalkGroupChat.kt */
        @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGKakaoTalkGroupChat$KGKakaoTalkGroupChatsResponse$Companion;", "", "()V", "emptyResponse", "Lcom/kakaogame/KGKakaoTalkGroupChat$KGKakaoTalkGroupChatsResponse;", "getEmptyResponse", "()Lcom/kakaogame/KGKakaoTalkGroupChat$KGKakaoTalkGroupChatsResponse;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private final KGKakaoTalkGroupChatsResponse getEmptyResponse() {
                return new KGKakaoTalkGroupChatsResponse(0, null);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGKakaoTalkGroupChat.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/KGKakaoTalkGroupChat$KGKakaoTalkGroupChatType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Regular", "Open", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGKakaoTalkGroupChatType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGKakaoTalkGroupChatType[] $VALUES;
        private final String value;
        public static final KGKakaoTalkGroupChatType Regular = new KGKakaoTalkGroupChatType(y.ݮڮֲڭܩ(-628745484), 0, y.٬ݯح׭٩(575793774));
        public static final KGKakaoTalkGroupChatType Open = new KGKakaoTalkGroupChatType(y.֬ڱܱײٮ(-1159564335), 1, y.ٴسسݬߨ(1392546450));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGKakaoTalkGroupChatType[] $values() {
            return new KGKakaoTalkGroupChatType[]{Regular, Open};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGKakaoTalkGroupChatType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGKakaoTalkGroupChatType valueOf(String str) {
            return (KGKakaoTalkGroupChatType) Enum.valueOf(KGKakaoTalkGroupChatType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGKakaoTalkGroupChatType[] values() {
            return (KGKakaoTalkGroupChatType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGKakaoTalkGroupChatType(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGKakaoTalkGroupChatType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: KGKakaoTalkGroupChat.kt */
    @Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ \u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J*\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/KGKakaoTalkGroupChat$Companion;", "", "()V", "CLASS_NAME_KEY", "", "KEY_CHAT_ID", "KEY_CHAT_TYPE", "KEY_MEMBER_COUNT", "KEY_MEMBER_THUMBNAIL_IMAGE_URLS", "KEY_THUMBNAIL_IMAGE_URL", "KEY_TITLE", "TAG", "serialVersionUID", "", "initInterfaceBroker", "", "initialize", "loadGroupChats", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/KGKakaoTalkGroupChat$KGKakaoTalkGroupChatsResponse;", "offset", "", "limit", "callback", "Lcom/kakaogame/KGResultCallback;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void loadGroupChats(int offset, int limit, KGResultCallback<KGKakaoTalkGroupChatsResponse> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkGroupChat$Companion$loadGroupChats$1(offset, limit, callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<KGKakaoTalkGroupChatsResponse> loadGroupChats(int offset, int limit) {
            KGResult<KGKakaoTalkGroupChatsResponse> result;
            KGResult<KGKakaoTalkGroupChatsResponse> result2;
            String str = y.ٲٴݴ״ٰ(1782036808);
            Stopwatch start = Stopwatch.INSTANCE.start(y.دײܮڳܯ(2051747653));
            try {
                try {
                } catch (Exception e) {
                    Logger.INSTANCE.m702e("KGKakaoTalkGroupChat", e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                }
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    result2 = KGResult.INSTANCE.getResult(3002);
                } else {
                    KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                    Intrinsics.checkNotNull(currentPlayer);
                    KGIdpProfile idpProfile = currentPlayer.getIdpProfile();
                    Intrinsics.checkNotNull(idpProfile);
                    if (idpProfile.getIdpCode() != KGIdpProfile.KGIdpCode.Kakao) {
                        KGResult.Companion companion = KGResult.INSTANCE;
                        StringBuilder sb = new StringBuilder(str);
                        KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                        Intrinsics.checkNotNull(currentPlayer2);
                        KGIdpProfile idpProfile2 = currentPlayer2.getIdpProfile();
                        Intrinsics.checkNotNull(idpProfile2);
                        result2 = companion.getResult(5001, sb.append(idpProfile2.getIdpCode()).toString());
                    } else if (KakaoManager.isTalkUser()) {
                        if (CoreManager.INSTANCE.getInstance().isKakaoCacheMode()) {
                            CoreManager.INSTANCE.getInstance().tryKakaoReConnect();
                        }
                        KGResult<Chats> requestMultiChatList = KakaoGameAPI.requestMultiChatList(offset, limit);
                        if (!requestMultiChatList.isNotSuccess()) {
                            Chats content = requestMultiChatList.getContent();
                            Intrinsics.checkNotNull(content);
                            result = KGResult.INSTANCE.getSuccessResult(new KGKakaoTalkGroupChatsResponse(content));
                            start.stop();
                            KakaoUtil.convertResultCode(result);
                            KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
                            return result;
                        }
                        result2 = KGResult.INSTANCE.getResult(requestMultiChatList);
                    } else {
                        result2 = KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_KAKAOTALK_USER, "onNotKakaoTalkUser");
                    }
                }
                start.stop();
                KakaoUtil.convertResultCode(result2);
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            } catch (Throwable th) {
                start.stop();
                KakaoUtil.convertResultCode(null);
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159557407), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalkGroupChat$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> loadGroupChats;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Number number = (Number) request.getParameter("offset");
                    Intrinsics.checkNotNull(number);
                    int intValue = number.intValue();
                    Number number2 = (Number) request.getParameter(y.ݮڮֲڭܩ(-628790308));
                    Intrinsics.checkNotNull(number2);
                    loadGroupChats = KGKakaoTalkGroupChat.INSTANCE.loadGroupChats(intValue, number2.intValue());
                    FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159557263), y.֬ڱܱײٮ(-1159557183), loadGroupChats);
                    if (loadGroupChats.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(loadGroupChats);
                    }
                    KGKakaoTalkGroupChat.KGKakaoTalkGroupChatsResponse kGKakaoTalkGroupChatsResponse = (KGKakaoTalkGroupChat.KGKakaoTalkGroupChatsResponse) loadGroupChats.getContent();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Intrinsics.checkNotNull(kGKakaoTalkGroupChatsResponse);
                    linkedHashMap.put(y.ۮڭڭܬި(862269467), Integer.valueOf(kGKakaoTalkGroupChatsResponse.getTotalCount()));
                    linkedHashMap.put(y.ݮڮֲڭܩ(-628693204), kGKakaoTalkGroupChatsResponse.getGroupChats());
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
        }
    }
}
