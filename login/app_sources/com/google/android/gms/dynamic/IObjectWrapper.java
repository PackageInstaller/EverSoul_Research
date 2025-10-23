package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public interface IObjectWrapper extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IObjectWrapper {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Stub() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof IObjectWrapper ? (IObjectWrapper) queryLocalInterface : new zzb(iBinder);
        }
    }
}
