package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class FragmentWrapper extends IFragmentWrapper.Stub {
    private final Fragment zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FragmentWrapper(Fragment fragment) {
        this.zza = fragment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzA() {
        return this.zza.isVisible();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzb() {
        return this.zza.getId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzc() {
        return this.zza.getTargetRequestCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle zzd() {
        return this.zza.getArguments();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zze() {
        return wrap(this.zza.getParentFragment());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzf() {
        return wrap(this.zza.getTargetFragment());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.zza.getActivity());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza.getResources());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzi() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String zzj() {
        return this.zza.getTag();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzk(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Preconditions.checkNotNull(view);
        this.zza.registerForContextMenu(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzl(boolean z) {
        this.zza.setHasOptionsMenu(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzm(boolean z) {
        this.zza.setMenuVisibility(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzn(boolean z) {
        this.zza.setRetainInstance(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzo(boolean z) {
        this.zza.setUserVisibleHint(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzp(Intent intent) {
        this.zza.startActivity(intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzq(Intent intent, int i) {
        this.zza.startActivityForResult(intent, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzr(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Preconditions.checkNotNull(view);
        this.zza.unregisterForContextMenu(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzs() {
        return this.zza.getRetainInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzt() {
        return this.zza.getUserVisibleHint();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzu() {
        return this.zza.isAdded();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzv() {
        return this.zza.isDetached();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzw() {
        return this.zza.isHidden();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzx() {
        return this.zza.isInLayout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzy() {
        return this.zza.isRemoving();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzz() {
        return this.zza.isResumed();
    }
}
