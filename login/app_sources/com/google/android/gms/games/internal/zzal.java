package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.firebase.FirebaseError;
import com.kakaogame.KGResult;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public abstract class zzal extends com.google.android.gms.internal.games_v2.zzb implements zzam {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzal() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 6001) {
            parcel.readString();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i == 6002) {
            parcel.readString();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i == 12011) {
            DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
            zzd(dataHolder);
        } else if (i == 12012) {
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
            zzp(readInt, readString);
        } else if (i == 13001) {
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i == 13002) {
            parcel.readInt();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i == 19001) {
            parcel.readInt();
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        } else if (i != 19002) {
            switch (i) {
                case 5001:
                    parcel.readInt();
                    parcel.readString();
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    break;
                case KGResult.KGResultCode.DEVICE_NOTIFICATION_SETTING_OFF /* 5002 */:
                    DataHolder dataHolder2 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzc(dataHolder2);
                    break;
                case 5003:
                    int readInt2 = parcel.readInt();
                    String readString2 = parcel.readString();
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzb(readInt2, readString2);
                    break;
                case 5004:
                    DataHolder dataHolder3 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzg(dataHolder3);
                    break;
                case 5005:
                    DataHolder dataHolder4 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    DataHolder dataHolder5 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzf(dataHolder4, dataHolder5);
                    break;
                case 5006:
                    DataHolder dataHolder6 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzk(dataHolder6);
                    break;
                case 5007:
                    DataHolder dataHolder7 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zzj(dataHolder7);
                    break;
                case 5008:
                    DataHolder dataHolder8 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    zze(dataHolder8);
                    break;
                case 5009:
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    break;
                case 5010:
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    break;
                case 5011:
                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                    break;
                default:
                    switch (i) {
                        case 5016:
                            zzm();
                            break;
                        case 5017:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5018:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5019:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5020:
                            parcel.readInt();
                            parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5021:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5022:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5023:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5024:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5025:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5026:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5027:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5028:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5029:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5030:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5031:
                            parcel.createStringArray();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5032:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5033:
                            parcel.readInt();
                            parcel.readInt();
                            parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5034:
                            parcel.readInt();
                            parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzg(parcel);
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5035:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5036:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5037:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5038:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5039:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 5040:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 9001:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 11001:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 12001:
                            DataHolder dataHolder9 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            zzr(dataHolder9);
                            break;
                        case 14001:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 15001:
                            DataHolder dataHolder10 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            zzi(dataHolder10);
                            break;
                        case FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH /* 17002 */:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 19008:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 19009:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 19010:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20001:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20002:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20003:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20004:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20005:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20006:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20007:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20008:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20009:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20012:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20019:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 20020:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23001:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23002:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23003:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23004:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 23005:
                            parcel.readInt();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 24002:
                            com.google.android.gms.internal.games_v2.zzc.zzg(parcel);
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 25002:
                            parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        case 25003:
                            Status status = (Status) com.google.android.gms.internal.games_v2.zzc.zza(parcel, Status.CREATOR);
                            String readString3 = parcel.readString();
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            zzl(status, readString3);
                            break;
                        case 25004:
                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                            break;
                        default:
                            switch (i) {
                                case KGResult.KGResultCode.FACEBOOK_NOT_INSTALLED /* 8001 */:
                                    DataHolder dataHolder11 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    zzh(dataHolder11);
                                    break;
                                case KGResult.KGResultCode.GOOGLE_PLAY_SERVICE_NOT_AVAILABLE /* 8002 */:
                                    parcel.readInt();
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8003:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8004:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8005:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8006:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8007:
                                    parcel.readInt();
                                    parcel.readString();
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8008:
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8009:
                                    parcel.readString();
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                case 8010:
                                    parcel.readString();
                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                    break;
                                default:
                                    switch (i) {
                                        case 10001:
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /* 10002 */:
                                            parcel.readString();
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_LICENSE_FAILED /* 10003 */:
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /* 10004 */:
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case 10005:
                                            parcel.readInt();
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /* 10006 */:
                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                            break;
                                        default:
                                            switch (i) {
                                                case 12004:
                                                    DataHolder dataHolder12 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                                                    Contents contents = (Contents) com.google.android.gms.internal.games_v2.zzc.zza(parcel, Contents.CREATOR);
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    zzq(dataHolder12, contents);
                                                    break;
                                                case 12005:
                                                    DataHolder dataHolder13 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    zzn(dataHolder13);
                                                    break;
                                                case 12006:
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    break;
                                                case 12007:
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    break;
                                                case 12008:
                                                    com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 12014:
                                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                            break;
                                                        case 12015:
                                                            parcel.readInt();
                                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                            break;
                                                        case 12016:
                                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                            break;
                                                        case 12017:
                                                            DataHolder dataHolder14 = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(parcel, DataHolder.CREATOR);
                                                            String readString4 = parcel.readString();
                                                            Contents contents2 = (Contents) com.google.android.gms.internal.games_v2.zzc.zza(parcel, Contents.CREATOR);
                                                            Contents contents3 = (Contents) com.google.android.gms.internal.games_v2.zzc.zza(parcel, Contents.CREATOR);
                                                            Contents contents4 = (Contents) com.google.android.gms.internal.games_v2.zzc.zza(parcel, Contents.CREATOR);
                                                            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
                                                            zzo(dataHolder14, readString4, contents2, contents3, contents4);
                                                            break;
                                                        default:
                                                            return false;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            parcel.readInt();
            com.google.android.gms.internal.games_v2.zzc.zzg(parcel);
            com.google.android.gms.internal.games_v2.zzc.zzb(parcel);
        }
        parcel2.writeNoException();
        return true;
    }
}
