package com.gamania.beanfunsdk.model;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class Result {

    /* renamed from: a */
    private int f206a;

    /* renamed from: b */
    private String f207b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Result(int i, String str) {
        this.f206a = i;
        this.f207b = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Result newInstance(JSONObject jSONObject) {
        return new Result(jSONObject.optInt("ResultCode"), jSONObject.optString("AccessToken"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAccessToken() {
        return this.f207b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getResultCode() {
        return this.f206a;
    }
}
