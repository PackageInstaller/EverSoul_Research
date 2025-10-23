package com.google.android.gms.games;

import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class Games {
    static final Api.ClientKey zza;
    public static final Scope zzb;
    public static final Scope zzc;
    public static final Scope zzd;

    @Deprecated
    public static final Api zze;
    public static final Scope zzf;
    public static final Api zzg;

    @Deprecated
    public static final GamesMetadata zzh;

    @Deprecated
    public static final Achievements zzi;

    @Deprecated
    public static final Events zzj;

    @Deprecated
    public static final Leaderboards zzk;

    @Deprecated
    public static final Players zzl;

    @Deprecated
    public static final Snapshots zzm;

    @Deprecated
    public static final Stats zzn;

    @Deprecated
    public static final Videos zzo;
    private static final Api.AbstractClientBuilder zzp;
    private static final Api.AbstractClientBuilder zzq;

    /* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzg zzgVar = new zzg();
        zzp = zzgVar;
        zzh zzhVar = new zzh();
        zzq = zzhVar;
        zzb = new Scope(Scopes.GAMES);
        zzc = new Scope(Scopes.GAMES_LITE);
        zzd = new Scope(Scopes.DRIVE_APPFOLDER);
        zze = new Api("Games.API", zzgVar, clientKey);
        zzf = new Scope(FirstPartyScopes.GAMES_1P);
        zzg = new Api("Games.API_1P", zzhVar, clientKey);
        zzh = new com.google.android.gms.internal.games_v2.zzg();
        zzi = new com.google.android.gms.internal.games_v2.zzd();
        zzj = new com.google.android.gms.internal.games_v2.zzf();
        zzk = new com.google.android.gms.internal.games_v2.zzh();
        zzl = new com.google.android.gms.internal.games_v2.zzi();
        zzm = new com.google.android.gms.internal.games_v2.zzj();
        zzn = new com.google.android.gms.internal.games_v2.zzk();
        zzo = new com.google.android.gms.internal.games_v2.zzl();
    }
}
