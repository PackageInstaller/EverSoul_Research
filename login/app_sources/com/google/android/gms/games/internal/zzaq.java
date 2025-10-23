package com.google.android.gms.games.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.games_v2.zzez;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzaq implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, zzd {
    private final zzak zza;
    private final com.google.android.gms.internal.games_v2.zzam zzb;
    private WeakReference zzc;
    private boolean zzd = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzaq(zzak zzakVar, int i) {
        this.zza = zzakVar;
        this.zzb = new com.google.android.gms.internal.games_v2.zzam(i, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzaq zzd(zzak zzakVar, int i) {
        return new zzaq(zzakVar, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzh(View view) {
        Display display;
        int i = -1;
        if (PlatformVersion.isAtLeastJellyBeanMR1() && (display = view.getDisplay()) != null) {
            i = display.getDisplayId();
        }
        IBinder windowToken = view.getWindowToken();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        com.google.android.gms.internal.games_v2.zzam zzamVar = this.zzb;
        zzamVar.zzc = i;
        zzamVar.zza = windowToken;
        int i2 = iArr[0];
        zzamVar.zzd = i2;
        int i3 = iArr[1];
        zzamVar.zze = i3;
        zzamVar.zzf = i2 + width;
        zzamVar.zzg = i3 + height;
        if (this.zzd) {
            zzg();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        zzh(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        zzh(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zza.zzs();
        view.removeOnAttachStateChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.zzd
    public final void zza(Activity activity) {
        View view;
        try {
            view = activity.findViewById(R.id.content);
        } catch (IllegalStateException unused) {
            view = null;
        }
        if (view == null && (view = activity.getWindow().getDecorView()) == null) {
            String valueOf = String.valueOf(activity);
            String.valueOf(valueOf).length();
            zzez.zzg("PopupManager", "Failed to bind to: ".concat(String.valueOf(valueOf)));
        } else {
            String valueOf2 = String.valueOf(activity);
            String.valueOf(valueOf2).length();
            zzez.zzf("PopupManager", "Binding to: ".concat(String.valueOf(valueOf2)));
            zzf(view);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zzb() {
        return this.zzb.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IBinder zzc() {
        return this.zzb.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final com.google.android.gms.internal.games_v2.zzam zze() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzf(View view) {
        this.zza.zzs();
        WeakReference weakReference = this.zzc;
        if (weakReference != null) {
            View view2 = (View) weakReference.get();
            Context context = this.zza.getContext();
            if (view2 == null && (context instanceof Activity)) {
                view2 = ((Activity) context).getWindow().getDecorView();
            }
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (PlatformVersion.isAtLeastJellyBean()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
        this.zzc = null;
        Context context2 = this.zza.getContext();
        if (view == null && (context2 instanceof Activity)) {
            Activity activity = (Activity) context2;
            try {
                view = activity.findViewById(R.id.content);
            } catch (IllegalStateException unused) {
            }
            if (view == null) {
                view = activity.getWindow().getDecorView();
            }
            zzez.zzg("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if (view == null) {
            zzez.zzc("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
            return;
        }
        zzh(view);
        this.zzc = new WeakReference(view);
        view.addOnAttachStateChangeListener(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzg() {
        boolean z;
        com.google.android.gms.internal.games_v2.zzam zzamVar = this.zzb;
        IBinder iBinder = zzamVar.zza;
        if (iBinder != null) {
            this.zza.zzQ(iBinder, zzamVar.zza());
            z = false;
        } else {
            z = true;
        }
        this.zzd = z;
    }
}
