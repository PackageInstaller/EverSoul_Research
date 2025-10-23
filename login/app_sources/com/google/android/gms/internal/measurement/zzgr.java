package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.common.base.Optional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzgr {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzgp zza(Context context, File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                HashMap hashMap = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                        zzgk zzgkVar = new zzgk(simpleArrayMap);
                        bufferedReader.close();
                        return zzgkVar;
                    }
                    String[] split = readLine.split(StringUtils.SPACE, 3);
                    if (split.length != 3) {
                        Log.e("HermeticFileOverrides", "Invalid: " + readLine);
                    } else {
                        String zza2 = zza(split[0]);
                        String decode = Uri.decode(zza(split[1]));
                        String str = (String) hashMap.get(split[2]);
                        if (str == null) {
                            String zza3 = zza(split[2]);
                            str = Uri.decode(zza3);
                            if (str.length() < 1024 || str == zza3) {
                                hashMap.put(zza3, str);
                            }
                        }
                        if (!simpleArrayMap.containsKey(zza2)) {
                            simpleArrayMap.put(zza2, new SimpleArrayMap());
                        }
                        ((SimpleArrayMap) simpleArrayMap.get(zza2)).put(decode, str);
                    }
                }
            } finally {
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
    public static class zza {
        private static volatile Optional<zzgp> zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Optional<zzgp> zza(Context context) {
            Optional<zzgp> optional;
            Optional<zzgp> zza2;
            synchronized (zza.class) {
                optional = zza;
                if (optional == null) {
                    new zzgr();
                    if (zzgs.zza(Build.TYPE, Build.TAGS)) {
                        if (zzge.zza() && !context.isDeviceProtectedStorage()) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                        zza2 = zzgr.zza(context);
                    } else {
                        zza2 = Optional.absent();
                    }
                    optional = zza2;
                    zza = optional;
                }
            }
            return optional;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private zza() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Optional<File> zzb(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? Optional.m188of(file) : Optional.absent();
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            return Optional.absent();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Optional<zzgp> zza(Context context) {
        Optional<zzgp> absent;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            Optional<File> zzb = zzb(context);
            if (zzb.isPresent()) {
                absent = Optional.m188of(zza(context, zzb.get()));
            } else {
                absent = Optional.absent();
            }
            return absent;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final String zza(String str) {
        return new String(str);
    }
}
