package com.gamania.beanfunsdk.model;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class LoginResult {

    /* renamed from: a */
    private String f203a;

    /* renamed from: b */
    private String f204b;

    /* renamed from: c */
    private String f205c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LoginResult(String str, String str2, String str3) {
        this.f203a = str;
        this.f204b = str2;
        this.f205c = str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LoginResult newInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new LoginResult(jSONObject.optString("client_id"), jSONObject.optString("client_name"), jSONObject.optString("user_id"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getClientId() {
        return this.f203a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getClientName() {
        return this.f204b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getUserId() {
        return this.f205c;
    }
}
