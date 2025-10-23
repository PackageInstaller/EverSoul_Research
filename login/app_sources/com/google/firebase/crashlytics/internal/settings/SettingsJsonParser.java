package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SettingsJsonParser {
    private final CurrentTimeProvider currentTimeProvider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.currentTimeProvider = currentTimeProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Settings parseSettingsJson(JSONObject jSONObject) throws JSONException {
        return getJsonTransformForVersion(jSONObject.getInt("settings_version")).buildFromJson(this.currentTimeProvider, jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static SettingsJsonTransform getJsonTransformForVersion(int i) {
        if (i == 3) {
            return new SettingsV3JsonTransform();
        }
        Logger.getLogger().m392e("Could not determine SettingsJsonTransform for settings version " + i + ". Using default settings values.");
        return new DefaultSettingsJsonTransform();
    }
}
