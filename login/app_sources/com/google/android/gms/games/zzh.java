package com.google.android.gms.games;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzh extends zzj {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzh() {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final /* synthetic */ List getImpliedScopes(Object obj) {
        return Collections.singletonList(Games.zzf);
    }
}
