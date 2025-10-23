package twitter4j;

import java.io.Serializable;
import java.util.Map;
import twitter4j.MediaEntity;

/* loaded from: classes4.dex */
public interface TwitterAPIConfiguration extends TwitterResponse, Serializable {
    int getCharactersReservedPerMedia();

    int getDmTextCharacterLimit();

    int getMaxMediaPerUpload();

    String[] getNonUsernamePaths();

    int getPhotoSizeLimit();

    Map<Integer, MediaEntity.Size> getPhotoSizes();

    int getShortURLLength();

    int getShortURLLengthHttps();
}
