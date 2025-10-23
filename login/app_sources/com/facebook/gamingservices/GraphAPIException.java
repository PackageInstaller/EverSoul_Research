package com.facebook.gamingservices;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TournamentFetcher.kt */
@Metadata(m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/facebook/gamingservices/GraphAPIException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "facebook-gamingservices_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class GraphAPIException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GraphAPIException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
