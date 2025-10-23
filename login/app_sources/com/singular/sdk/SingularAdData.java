package com.singular.sdk;

import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SingularAdData extends JSONObject {
    private static final SingularLog logger = SingularLog.getLogger("SingularAdData");
    private final String[] RequiredParams = {"ad_platform", Constants.ADMON_CURRENCY, Constants.ADMON_REVENUE};

    public final class AdPlatforms {
        public static final String MOPUB = "mopub";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AdPlatforms() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData(String str, String str2, double d) {
        try {
            put("ad_platform", str);
            put(Constants.ADMON_CURRENCY, str2);
            put(Constants.ADMON_REVENUE, d);
            put(Constants.REVENUE_AMOUNT_KEY, d);
            put(Constants.REVENUE_CURRENCY_KEY, str2);
            put(Constants.ADMON_IS_ADMON_REVENUE, true);
            put(Constants.IS_REVENUE_EVENT_KEY, true);
            put(Constants.ADMON_NETWORK_NAME, str);
        } catch (JSONException e) {
            logger.error("Error in constructing ad data", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withNetworkName(String str) {
        try {
            put(Constants.ADMON_NETWORK_NAME, str);
        } catch (JSONException e) {
            logger.error("Error in setting network name", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withAdType(String str) {
        try {
            put("ad_type", str);
        } catch (JSONException e) {
            logger.error("Error in setting ad type", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withAdGroupType(String str) {
        try {
            put(Constants.ADMON_AD_GROUP_TYPE, str);
        } catch (JSONException e) {
            logger.error("Error in setting ad group Type", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withImpressionId(String str) {
        try {
            put(Constants.ADMON_IMPRESSION_ID, str);
        } catch (JSONException e) {
            logger.error("Error in setting impression id", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withAdPlacementName(String str) {
        try {
            put(Constants.ADMON_AD_PLACEMENT_NAME, str);
        } catch (JSONException e) {
            logger.error("Error in setting ad placement name id", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withAdUnitId(String str) {
        try {
            put(Constants.ADMON_AD_UNIT_ID, str);
        } catch (JSONException e) {
            logger.error("Error in setting ad unit id", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withAdUnitName(String str) {
        try {
            put("ad_unit_name", str);
        } catch (JSONException e) {
            logger.error("Error in setting ad unit name", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withAdGroupId(String str) {
        try {
            put(Constants.ADMON_AD_GROUP_ID, str);
        } catch (JSONException e) {
            logger.error("Error in setting ad group id", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withAdGroupName(String str) {
        try {
            put(Constants.ADMON_AD_GROUP_NAME, str);
        } catch (JSONException e) {
            logger.error("Error in setting ad group name", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withAdGroupPriority(String str) {
        try {
            put(Constants.ADMON_AD_GROUP_PRIORITY, str);
        } catch (JSONException e) {
            logger.error("Error in setting ad group priority", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withPrecision(String str) {
        try {
            put(Constants.ADMON_PRECISION, str);
        } catch (JSONException e) {
            logger.error("Error in setting precision", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularAdData withPlacementId(String str) {
        try {
            put(Constants.ADMON_PLACEMENT_ID, str);
        } catch (JSONException e) {
            logger.error("Error in setting placement id", e);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean hasRequiredParams() {
        int i;
        for (String str : this.RequiredParams) {
            try {
                i = (has(str) && !Utils.isEmptyOrNull(get(str).toString())) ? i + 1 : 0;
            } catch (JSONException unused) {
            }
            return false;
        }
        return true;
    }
}
