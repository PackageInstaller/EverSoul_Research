package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;
import twitter4j.TwitterException;

/* loaded from: classes4.dex */
public interface TrendsResources {
    ResponseList<Location> getAvailableTrends() throws TwitterException;

    ResponseList<Location> getClosestTrends(GeoLocation geoLocation) throws TwitterException;

    Trends getPlaceTrends(int i) throws TwitterException;
}
