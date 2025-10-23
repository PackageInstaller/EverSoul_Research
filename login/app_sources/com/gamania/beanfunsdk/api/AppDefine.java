package com.gamania.beanfunsdk.api;

/* loaded from: classes.dex */
public class AppDefine {
    public static final String AES_IV = "1111111111111111";
    public static final String BEANFUN = "beanfun";
    public static final String BUNDLE_KEY_OPNEID_REQUEST_DATA = "openid_request_data";
    public static final String BUNDLE_KEY_OPNEID_RESULT_DATA = "openid_result_data";
    public static String CHECK_ACCESS_TOKEN = null;
    public static String DEBUG_SCHEME_URL = "beanfunapp://gameLogin";
    public static String DEBUG_SERVER_DOMAIN = "https://stage-openid.beanfun.com";
    public static String GET_OPEN_ID_ACCESS_TOKEN = null;
    public static final int INT_OPENID_RESULT_DATA_ERROR = 0;
    public static final int INT_OPENID_RESULT_OK = 1;
    public static final int INT_OPENID_RESULT_SERVER_ERROR = -1;
    public static final int INT_OPENID_RESULT_TIMEOUT_ERROR = -2;
    public static String LOGOUT_ACCESS_TOKEN = null;
    public static final int OPEN_ID_APP_REQUEST_CODE = 22;
    public static final int OPEN_ID_WEB_REQUEST_CODE = 11;
    public static String RELEASE_SCHEME_URL = "beanfunapp://gameLogin";
    public static String RELEASE_SERVER_DOMAIN = "https://openid.beanfun.com";
    public static String SCHEME_URL = null;
    public static final String SHAREDPREFERENCES_NAME = "beanfunData";
    public static final String STR_OPENID_RESULT_REQUEST_DATA_ERROR = "RequestDataError";
    public static final String STR_OPENID_RESULT_SERVER_ERROR = "ServerError";
    public static final String STR_OPENID_RESULT_TIMEOUT = "TimeOut";
    public static final String STR_RESULT_TOKEN_ERROR = "TokenError";
    public static final String STR_RESULT_TOKEN_REVOKED = "TokenRevoked";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setDomainUrl(boolean z) {
        SCHEME_URL = z ? DEBUG_SCHEME_URL : RELEASE_SCHEME_URL;
        GET_OPEN_ID_ACCESS_TOKEN = (z ? DEBUG_SERVER_DOMAIN : RELEASE_SERVER_DOMAIN) + "/GotoRegister/?clientId=";
        LOGOUT_ACCESS_TOKEN = (z ? DEBUG_SERVER_DOMAIN : RELEASE_SERVER_DOMAIN) + "/api/Logout/?Token=";
        CHECK_ACCESS_TOKEN = (z ? DEBUG_SERVER_DOMAIN : RELEASE_SERVER_DOMAIN) + "/api/CheckToken/?Token=";
    }
}
