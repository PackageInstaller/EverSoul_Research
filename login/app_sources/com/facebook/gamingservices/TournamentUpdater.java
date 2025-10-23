package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.ServerProtocol;
import com.kakaogame.KGMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TournamentUpdater.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t¨\u0006\f"}, m839d2 = {"Lcom/facebook/gamingservices/TournamentUpdater;", "", "()V", "update", "Lcom/facebook/bolts/TaskCompletionSource;", "", KGMessage.SENDER_ID_TOURNAMENT, "Lcom/facebook/gamingservices/Tournament;", "score", "", "identifier", "", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class TournamentUpdater {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TaskCompletionSource<Boolean> update(Tournament tournament, Number score) {
        Intrinsics.checkNotNullParameter(tournament, "tournament");
        Intrinsics.checkNotNullParameter(score, "score");
        return update(tournament.identifier, score);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TaskCompletionSource<Boolean> update(String identifier, Number score) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(score, "score");
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to fetch tournament with an invalid access token");
        }
        if (!(currentAccessToken.getGraphDomain() != null && Intrinsics.areEqual(FacebookSdk.GAMING, currentAccessToken.getGraphDomain()))) {
            throw new FacebookException("User is not using gaming login");
        }
        final TaskCompletionSource<Boolean> taskCompletionSource = new TaskCompletionSource<>();
        String stringPlus = Intrinsics.stringPlus(identifier, "/update_score");
        Bundle bundle = new Bundle();
        bundle.putInt("score", score.intValue());
        new GraphRequest(currentAccessToken, stringPlus, bundle, HttpMethod.POST, new GraphRequest.Callback() { // from class: com.facebook.gamingservices.TournamentUpdater$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                TournamentUpdater.m1069update$lambda0(TaskCompletionSource.this, graphResponse);
            }
        }, null, 32, null).executeAsync();
        return taskCompletionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: update$lambda-0, reason: not valid java name */
    public static final void m1069update$lambda0(TaskCompletionSource task, GraphResponse response) {
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getError() != null) {
            FacebookRequestError error = response.getError();
            if ((error == null ? null : error.getException()) != null) {
                FacebookRequestError error2 = response.getError();
                task.setError(error2 != null ? error2.getException() : null);
                return;
            } else {
                task.setError(new GraphAPIException("Graph API Error"));
                return;
            }
        }
        JSONObject jSONObject = response.getJSONObject();
        String optString = jSONObject != null ? jSONObject.optString("success") : null;
        if (optString != null) {
            if (!(optString.length() == 0)) {
                task.setResult(Boolean.valueOf(optString.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)));
                return;
            }
        }
        task.setError(new GraphAPIException("Graph API Error"));
    }
}
