package twitter4j.api;

import java.io.InputStream;
import twitter4j.DirectMessage;
import twitter4j.DirectMessageList;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.TwitterException;

/* loaded from: classes4.dex */
public interface DirectMessagesResources {
    DirectMessage destroyDirectMessage(long j) throws TwitterException;

    InputStream getDMImageAsStream(String str) throws TwitterException;

    DirectMessageList getDirectMessages(int i) throws TwitterException;

    DirectMessageList getDirectMessages(int i, String str) throws TwitterException;

    ResponseList<DirectMessage> getDirectMessages() throws TwitterException;

    ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException;

    ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException;

    ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException;

    DirectMessage sendDirectMessage(long j, String str) throws TwitterException;

    DirectMessage sendDirectMessage(long j, String str, long j2) throws TwitterException;

    DirectMessage sendDirectMessage(String str, String str2) throws TwitterException;

    DirectMessage showDirectMessage(long j) throws TwitterException;
}
