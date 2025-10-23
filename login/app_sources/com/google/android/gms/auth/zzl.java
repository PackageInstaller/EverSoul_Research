package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbw;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zzcz;
import com.google.android.gms.internal.auth.zzhj;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public class zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";
    public static final String[] zza = {"com.google", "com.google.work", "cn.google"};
    public static final String zzb = "androidPackageName";
    private static final ComponentName zzc = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final Logger zzd = zzd.zza("GoogleAuthUtil");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzj(context, 8400000);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        String str3 = zzb;
        if (!bundle.containsKey(str3)) {
            bundle.putString(str3, str2);
        }
        zzcz.zze(context);
        if (zzhj.zze() && zzm(context)) {
            com.google.android.gms.internal.auth.zzg zza2 = com.google.android.gms.internal.auth.zzh.zza(context);
            zzbw zzbwVar = new zzbw();
            zzbwVar.zza(str);
            try {
                zzh(zza2.zza(zzbwVar), "clear token");
                return;
            } catch (ApiException e) {
                zzk(e, "clear token");
            }
        }
        zzg(context, zzc, new zzh(str, bundle));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzj(context, 8400000);
        AccountChangeEventsRequest accountChangeEventsRequest = new AccountChangeEventsRequest();
        accountChangeEventsRequest.setAccountName(str);
        accountChangeEventsRequest.setEventIndex(i);
        zzcz.zze(context);
        if (zzhj.zzd() && zzm(context)) {
            try {
                AccountChangeEventsResponse accountChangeEventsResponse = (AccountChangeEventsResponse) zzh(com.google.android.gms.internal.auth.zzh.zza(context).zzb(accountChangeEventsRequest), "account change events retrieval");
                zzi(accountChangeEventsResponse);
                return accountChangeEventsResponse.getEvents();
            } catch (ApiException e) {
                zzk(e, "account change events retrieval");
            }
        }
        return (List) zzg(context, zzc, new zzi(accountChangeEventsRequest));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzj(context, 8400000);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bundle removeAccount(Context context, final Account account) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        zzl(account);
        zzj(context, 8400000);
        zzcz.zze(context);
        if (zzhj.zze() && zzm(context)) {
            try {
                Bundle bundle = (Bundle) zzh(com.google.android.gms.internal.auth.zzh.zza(context).zzd(account), "account removal");
                zzi(bundle);
                return bundle;
            } catch (ApiException e) {
                zzk(e, "account removal");
            }
        }
        return (Bundle) zzg(context, zzc, new zzk() { // from class: com.google.android.gms.auth.zzf
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.auth.zzk
            public final Object zza(IBinder iBinder) {
                Bundle zzf = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzf(account);
                if (zzf != null) {
                    return zzf;
                }
                throw new IOException("Service call returned null.");
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean requestGoogleAccountsAccess(Context context) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        zzj(context, 11400000);
        String str = context.getApplicationInfo().packageName;
        zzcz.zze(context);
        if (zzhj.zze() && zzm(context)) {
            try {
                Bundle bundle = (Bundle) zzh(com.google.android.gms.internal.auth.zzh.zza(context).zze(str), "google accounts access request");
                String string = bundle.getString("Error");
                Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                zzby zza2 = zzby.zza(string);
                if (zzby.SUCCESS.equals(zza2)) {
                    return true;
                }
                if (!zzby.zzb(zza2)) {
                    throw new GoogleAuthException(string);
                }
                Logger logger = zzd;
                String valueOf = String.valueOf(zza2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
                sb.append("isUserRecoverableError status: ");
                sb.append(valueOf);
                logger.m163w("GoogleAuthUtil", sb.toString());
                throw new UserRecoverableAuthException(string, intent);
            } catch (ApiException e) {
                zzk(e, "google accounts access request");
            }
        }
        return (Boolean) zzg(context, zzc, new zzj(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TokenData zza(Context context, final Account account, final String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        Preconditions.checkNotEmpty(str, "Scope cannot be empty or null.");
        zzl(account);
        zzj(context, 8400000);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        String str3 = zzb;
        if (TextUtils.isEmpty(bundle2.getString(str3))) {
            bundle2.putString(str3, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        zzcz.zze(context);
        if (zzhj.zze() && zzm(context)) {
            try {
                Bundle bundle3 = (Bundle) zzh(com.google.android.gms.internal.auth.zzh.zza(context).zzc(account, str, bundle2), "token retrieval");
                zzi(bundle3);
                return zzf(bundle3);
            } catch (ApiException e) {
                zzk(e, "token retrieval");
            }
        }
        return (TokenData) zzg(context, zzc, new zzk() { // from class: com.google.android.gms.auth.zzg
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.auth.zzk
            public final Object zza(IBinder iBinder) {
                return zzl.zzb(account, str, bundle2, iBinder);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ TokenData zzb(Account account, String str, Bundle bundle, IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zze = com.google.android.gms.internal.auth.zze.zzb(iBinder).zze(account, str, bundle);
        if (zze != null) {
            return zzf(zze);
        }
        throw new IOException("Service call returned null");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ Object zzd(Object obj) throws IOException {
        zzi(obj);
        return obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static TokenData zzf(Bundle bundle) throws GoogleAuthException, IOException {
        TokenData tokenData;
        Parcelable.Creator<TokenData> creator = TokenData.CREATOR;
        ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        Bundle bundle2 = bundle.getBundle("tokenDetails");
        if (bundle2 == null) {
            tokenData = null;
        } else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData) bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzby zza2 = zzby.zza(string);
        if (!zzby.zzb(zza2)) {
            if (zzby.NETWORK_ERROR.equals(zza2) || zzby.SERVICE_UNAVAILABLE.equals(zza2) || zzby.INTNERNAL_ERROR.equals(zza2) || zzby.AUTH_SECURITY_ERROR.equals(zza2)) {
                throw new IOException(string);
            }
            throw new GoogleAuthException(string);
        }
        Logger logger = zzd;
        String valueOf = String.valueOf(zza2);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
        sb.append("isUserRecoverableError status: ");
        sb.append(valueOf);
        logger.m163w("GoogleAuthUtil", sb.toString());
        throw new UserRecoverableAuthException(string, intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> T zzg(Context context, ComponentName componentName, zzk<T> zzkVar) throws IOException, GoogleAuthException {
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        try {
            try {
                if (!gmsClientSupervisor.bindService(componentName, blockingServiceConnection, "GoogleAuthUtil")) {
                    throw new IOException("Could not bind to service.");
                }
                try {
                    return zzkVar.zza(blockingServiceConnection.getService());
                } catch (RemoteException | InterruptedException e) {
                    Log.i("GoogleAuthUtil", "Error on service connection.", e);
                    throw new IOException("Error on service connection.", e);
                }
            } finally {
                gmsClientSupervisor.unbindService(componentName, blockingServiceConnection, "GoogleAuthUtil");
            }
        } catch (SecurityException e2) {
            Log.w("GoogleAuthUtil", String.format("SecurityException while bind to auth service: %s", e2.getMessage()));
            throw new IOException("SecurityException while binding to Auth service.", e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <ResultT> ResultT zzh(Task<ResultT> task, String str) throws IOException, ApiException {
        try {
            return (ResultT) Tasks.await(task);
        } catch (InterruptedException e) {
            String format = String.format("Interrupted while waiting for the task of %s to finish.", str);
            zzd.m163w(format, new Object[0]);
            throw new IOException(format, e);
        } catch (CancellationException e2) {
            String format2 = String.format("Canceled while waiting for the task of %s to finish.", str);
            zzd.m163w(format2, new Object[0]);
            throw new IOException(format2, e2);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof ApiException) {
                throw ((ApiException) cause);
            }
            String format3 = String.format("Unable to get a result for %s due to ExecutionException.", str);
            zzd.m163w(format3, new Object[0]);
            throw new IOException(format3, e3);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> T zzi(T t) throws IOException {
        if (t != null) {
            return t;
        }
        zzd.m163w("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zzj(Context context, int i) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (GooglePlayServicesIncorrectManifestValueException e) {
            e = e;
            throw new GoogleAuthException(e.getMessage(), e);
        } catch (GooglePlayServicesNotAvailableException e2) {
            e = e2;
            throw new GoogleAuthException(e.getMessage(), e);
        } catch (GooglePlayServicesRepairableException e3) {
            throw new GooglePlayServicesAvailabilityException(e3.getConnectionStatusCode(), e3.getMessage(), e3.getIntent());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zzk(ApiException apiException, String str) {
        zzd.m163w("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", str, Log.getStackTraceString(apiException));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzm(Context context) {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context, 17895000) != 0) {
            return false;
        }
        String str = context.getApplicationInfo().packageName;
        Iterator<String> it = zzhj.zzb().zzm().iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzl(account);
        return zza(context, account, str, bundle).zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void zze(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zzl(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (TextUtils.isEmpty(account.name)) {
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
        String[] strArr = zza;
        for (int i = 0; i < 3; i++) {
            if (strArr[i].equals(account.type)) {
                return;
            }
        }
        throw new IllegalArgumentException("Account type not supported");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }
}
