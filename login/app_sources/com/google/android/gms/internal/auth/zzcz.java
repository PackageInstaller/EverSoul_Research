package com.google.android.gms.internal.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public abstract class zzcz<T> {
    public static final /* synthetic */ int zzd = 0;

    @Nullable
    private static volatile zzcy zze;
    private static volatile boolean zzf;
    final zzcx zzb;
    final String zzc;
    private final T zzj;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzcz<?>>> zzg = new AtomicReference<>();
    private static final zzdb zzh = new zzdb(new Object() { // from class: com.google.android.gms.internal.auth.zzcr
    }, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzcz(zzcx zzcxVar, String str, Object obj, boolean z, zzct zzctVar) {
        if (zzcxVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzb = zzcxVar;
        this.zzc = str;
        this.zzj = obj;
        this.zzm = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zzd() {
        zzi.incrementAndGet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zze(final Context context) {
        if (zze == null) {
            Object obj = zza;
            synchronized (obj) {
                if (zze == null) {
                    synchronized (obj) {
                        zzcy zzcyVar = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzcyVar == null || zzcyVar.zza() != context) {
                            zzcg.zzd();
                            zzda.zzc();
                            zzcn.zze();
                            zze = new zzcd(context, zzdk.zza(new zzdg() { // from class: com.google.android.gms.internal.auth.zzcs
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // com.google.android.gms.internal.auth.zzdg
                                public final Object zza() {
                                    zzde zzc;
                                    zzde zzc2;
                                    Context context2 = context;
                                    int i = zzcz.zzd;
                                    String str = Build.TYPE;
                                    String str2 = Build.TAGS;
                                    if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
                                        return zzde.zzc();
                                    }
                                    if (zzcc.zza() && !context2.isDeviceProtectedStorage()) {
                                        context2 = context2.createDeviceProtectedStorageContext();
                                    }
                                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                                    try {
                                        StrictMode.allowThreadDiskWrites();
                                        try {
                                            File file = new File(context2.getDir("phenotype_hermetic", 0), "overrides.txt");
                                            zzc = file.exists() ? zzde.zzd(file) : zzde.zzc();
                                        } catch (RuntimeException e) {
                                            Log.e("HermeticFileOverrides", "no data dir", e);
                                            zzc = zzde.zzc();
                                        }
                                        if (zzc.zzb()) {
                                            File file2 = (File) zzc.zza();
                                            try {
                                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                                try {
                                                    HashMap hashMap = new HashMap();
                                                    HashMap hashMap2 = new HashMap();
                                                    while (true) {
                                                        String readLine = bufferedReader.readLine();
                                                        if (readLine == null) {
                                                            break;
                                                        }
                                                        String[] split = readLine.split(StringUtils.SPACE, 3);
                                                        if (split.length != 3) {
                                                            Log.e("HermeticFileOverrides", readLine.length() != 0 ? "Invalid: ".concat(readLine) : new String("Invalid: "));
                                                        } else {
                                                            String str3 = new String(split[0]);
                                                            String decode = Uri.decode(new String(split[1]));
                                                            String str4 = (String) hashMap2.get(split[2]);
                                                            if (str4 == null) {
                                                                String str5 = new String(split[2]);
                                                                str4 = Uri.decode(str5);
                                                                if (str4.length() < 1024 || str4 == str5) {
                                                                    hashMap2.put(str5, str4);
                                                                }
                                                            }
                                                            if (!hashMap.containsKey(str3)) {
                                                                hashMap.put(str3, new HashMap());
                                                            }
                                                            ((Map) hashMap.get(str3)).put(decode, str4);
                                                        }
                                                    }
                                                    String valueOf = String.valueOf(file2);
                                                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
                                                    sb.append("Parsed ");
                                                    sb.append(valueOf);
                                                    Log.i("HermeticFileOverrides", sb.toString());
                                                    zzco zzcoVar = new zzco(hashMap);
                                                    bufferedReader.close();
                                                    zzc2 = zzde.zzd(zzcoVar);
                                                } catch (Throwable th) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (Throwable th2) {
                                                        th.addSuppressed(th2);
                                                    }
                                                    throw th;
                                                }
                                            } catch (IOException e2) {
                                                throw new RuntimeException(e2);
                                            }
                                        } else {
                                            zzc2 = zzde.zzc();
                                        }
                                        return zzc2;
                                    } finally {
                                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                                    }
                                }
                            }));
                            zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    abstract T zza(Object obj);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa A[Catch: all -> 0x0124, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x003d, B:20:0x0049, B:22:0x0052, B:24:0x0064, B:25:0x006f, B:26:0x0069, B:30:0x00ea, B:32:0x00fa, B:34:0x0110, B:35:0x0113, B:36:0x0117, B:37:0x00be, B:39:0x00c4, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00d6, B:49:0x0074, B:51:0x007a, B:53:0x0088, B:55:0x00ad, B:57:0x00b7, B:59:0x009f, B:60:0x011c, B:61:0x0121, B:62:0x0122), top: B:11:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be A[Catch: all -> 0x0124, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x003d, B:20:0x0049, B:22:0x0052, B:24:0x0064, B:25:0x006f, B:26:0x0069, B:30:0x00ea, B:32:0x00fa, B:34:0x0110, B:35:0x0113, B:36:0x0117, B:37:0x00be, B:39:0x00c4, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00d6, B:49:0x0074, B:51:0x007a, B:53:0x0088, B:55:0x00ad, B:57:0x00b7, B:59:0x009f, B:60:0x011c, B:61:0x0121, B:62:0x0122), top: B:11:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e8 A[Catch: all -> 0x0124, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x003d, B:20:0x0049, B:22:0x0052, B:24:0x0064, B:25:0x006f, B:26:0x0069, B:30:0x00ea, B:32:0x00fa, B:34:0x0110, B:35:0x0113, B:36:0x0117, B:37:0x00be, B:39:0x00c4, B:42:0x00da, B:44:0x00e0, B:46:0x00e8, B:47:0x00d6, B:49:0x0074, B:51:0x007a, B:53:0x0088, B:55:0x00ad, B:57:0x00b7, B:59:0x009f, B:60:0x011c, B:61:0x0121, B:62:0x0122), top: B:11:0x001c }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T zzb() {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzcz.zzb():java.lang.Object");
    }
}
