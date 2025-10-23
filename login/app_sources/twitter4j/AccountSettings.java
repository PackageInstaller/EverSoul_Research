package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
public interface AccountSettings extends TwitterResponse, Serializable {
    String getAllowDmsFrom();

    String getLanguage();

    String getScreenName();

    String getSleepEndTime();

    String getSleepStartTime();

    TimeZone getTimeZone();

    Location[] getTrendLocations();

    boolean isAlwaysUseHttps();

    boolean isDiscoverableByEmail();

    boolean isGeoEnabled();

    boolean isSleepTimeEnabled();
}
