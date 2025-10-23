package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Map;

/* renamed from: com.unity3d.player.m */
/* loaded from: classes3.dex */
final class C2742m implements OnCompleteListener {

    /* renamed from: a */
    private IAssetPackManagerStatusQueryCallback f1403a;

    /* renamed from: b */
    private Looper f1404b = Looper.myLooper();

    /* renamed from: c */
    private String[] f1405c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2742m(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.f1403a = iAssetPackManagerStatusQueryCallback;
        this.f1405c = strArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        if (this.f1403a == null) {
            return;
        }
        int i = 0;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map packStates = assetPackStates.packStates();
            int size = packStates.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (AssetPackState assetPackState : packStates.values()) {
                strArr[i] = assetPackState.name();
                iArr[i] = assetPackState.status();
                iArr2[i] = assetPackState.errorCode();
                i++;
            }
            new Handler(this.f1404b).post(new RunnableC2740l(this.f1403a, assetPackStates.totalBytes(), strArr, iArr, iArr2));
        } catch (RuntimeExecutionException e) {
            e = e;
            String message = e.getMessage();
            String[] strArr2 = this.f1405c;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                int i3 = -100;
                if (i2 >= length) {
                    String[] strArr3 = this.f1405c;
                    int[] iArr3 = new int[strArr3.length];
                    int[] iArr4 = new int[strArr3.length];
                    for (int i4 = 0; i4 < this.f1405c.length; i4++) {
                        iArr3[i4] = 0;
                        AssetPackException assetPackException = e;
                        while (true) {
                            if (assetPackException instanceof AssetPackException) {
                                errorCode = assetPackException.getErrorCode();
                                break;
                            }
                            assetPackException = assetPackException.getCause();
                            if (assetPackException == null) {
                                errorCode = -100;
                                break;
                            }
                        }
                        iArr4[i4] = errorCode;
                    }
                    new Handler(this.f1404b).post(new RunnableC2740l(this.f1403a, 0L, this.f1405c, iArr3, iArr4));
                    return;
                }
                String str = strArr2[i2];
                if (message.contains(str)) {
                    Handler handler = new Handler(this.f1404b);
                    IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback = this.f1403a;
                    String[] strArr4 = {str};
                    int[] iArr5 = {0};
                    int[] iArr6 = new int[1];
                    while (true) {
                        if (!(e instanceof AssetPackException)) {
                            e = e.getCause();
                            if (e == null) {
                                break;
                            }
                        } else {
                            i3 = e.getErrorCode();
                            break;
                        }
                    }
                    iArr6[0] = i3;
                    handler.post(new RunnableC2740l(iAssetPackManagerStatusQueryCallback, 0L, strArr4, iArr5, iArr6));
                    return;
                }
                i2++;
            }
        }
    }
}
