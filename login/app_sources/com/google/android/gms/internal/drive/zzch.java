package com.google.android.gms.internal.drive;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OnChangeListener;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class zzch extends DriveResourceClient {
    private static final AtomicInteger zzfn = new AtomicInteger();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzch(Context context, Drive.zza zzaVar) {
        super(context, zzaVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzch(Activity activity, Drive.zza zzaVar) {
        super(activity, zzaVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFolder> getRootFolder() {
        return doRead(new zzck(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFolder> getAppFolder() {
        return doRead(new zzco(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<MetadataBuffer> query(Query query) {
        Preconditions.checkNotNull(query, "query cannot be null.");
        return doRead(new zzcz(this, query));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Metadata> getMetadata(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource, "DriveResource must not be null");
        Preconditions.checkNotNull(driveResource.getDriveId(), "Resource's DriveId must not be null");
        return doRead(new zzdc(this, driveResource, false));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Metadata> updateMetadata(DriveResource driveResource, MetadataChangeSet metadataChangeSet) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkNotNull(metadataChangeSet);
        return doWrite(new zzdd(this, metadataChangeSet, driveResource));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<MetadataBuffer> listParents(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        return doRead(new zzde(this, driveResource));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> setParents(DriveResource driveResource, Set<DriveId> set) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkNotNull(set);
        return doWrite(new zzdf(this, driveResource, new ArrayList(set)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> delete(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        return doWrite(new zzcl(this, driveResource));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> trash(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        return doWrite(new zzcm(this, driveResource));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> untrash(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        return doWrite(new zzcn(this, driveResource));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<ListenerToken> addChangeListener(DriveResource driveResource, OnChangeListener onChangeListener) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkNotNull(onChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        zzdi zzdiVar = new zzdi(this, onChangeListener, driveResource.getDriveId());
        final ListenerHolder<L> registerListener = registerListener(zzdiVar, new StringBuilder(27).append("OnChangeListener").append(zzfn.incrementAndGet()).toString());
        return doRegisterEventListener(new zzcp(this, registerListener, driveResource, zzdiVar), new zzcq(this, registerListener.getListenerKey(), driveResource, zzdiVar)).continueWith(new Continuation(registerListener) { // from class: com.google.android.gms.internal.drive.zzci
            private final ListenerHolder zzfo;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.zzfo = registerListener;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzch.zza(this.zzfo, task);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Boolean> removeChangeListener(ListenerToken listenerToken) {
        Preconditions.checkNotNull(listenerToken, "Token is required to unregister listener.");
        if (listenerToken instanceof zzg) {
            return doUnregisterEventListener(((zzg) listenerToken).zzad());
        }
        throw new IllegalStateException("Could not recover key from ListenerToken");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> addChangeSubscription(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(1, driveResource.getDriveId()));
        return doWrite(new zzcr(this, driveResource));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> removeChangeSubscription(DriveResource driveResource) {
        Preconditions.checkNotNull(driveResource.getDriveId());
        Preconditions.checkArgument(com.google.android.gms.drive.events.zzj.zza(1, driveResource.getDriveId()));
        return doWrite(new zzcs(this, driveResource));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveContents> openFile(DriveFile driveFile, int i) {
        zze(i);
        return doRead(new zzct(this, driveFile, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<ListenerToken> openFile(DriveFile driveFile, int i, OpenFileCallback openFileCallback) {
        zze(i);
        ListenerHolder<L> registerListener = registerListener(openFileCallback, new StringBuilder(27).append("OpenFileCallback").append(zzfn.incrementAndGet()).toString());
        ListenerHolder.ListenerKey listenerKey = registerListener.getListenerKey();
        final zzg zzgVar = new zzg(listenerKey);
        return doRegisterEventListener(new zzcu(this, registerListener, driveFile, i, zzgVar, registerListener), new zzcv(this, listenerKey, zzgVar)).continueWith(new Continuation(zzgVar) { // from class: com.google.android.gms.internal.drive.zzcj
            private final zzg zzfp;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.zzfp = zzgVar;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzch.zza(this.zzfp, task);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Boolean> cancelOpenFileCallback(ListenerToken listenerToken) {
        if (!(listenerToken instanceof zzg)) {
            throw new IllegalArgumentException("Unrecognized ListenerToken");
        }
        return doUnregisterEventListener(((zzg) listenerToken).zzad());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveContents> createContents() {
        Preconditions.checkArgument(true, "Contents can only be created in MODE_WRITE_ONLY or MODE_READ_WRITE.");
        return doWrite(new zzcw(this, DriveFile.MODE_WRITE_ONLY));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveContents> reopenContentsForWrite(DriveContents driveContents) {
        Preconditions.checkArgument(!driveContents.zzk(), "DriveContents is already closed");
        Preconditions.checkArgument(driveContents.getMode() == 268435456, "This method can only be called on contents that are currently opened in MODE_READ_ONLY.");
        driveContents.zzj();
        return doRead(new zzcx(this, driveContents));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> commitContents(DriveContents driveContents, MetadataChangeSet metadataChangeSet) {
        return commitContents(driveContents, metadataChangeSet, (com.google.android.gms.drive.zzn) new com.google.android.gms.drive.zzp().build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> commitContents(DriveContents driveContents, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        Preconditions.checkNotNull(executionOptions, "Execution options cannot be null.");
        Preconditions.checkArgument(!driveContents.zzk(), "DriveContents is already closed");
        Preconditions.checkArgument(driveContents.getMode() != 268435456, "Cannot commit contents opened in MODE_READ_ONLY.");
        Preconditions.checkNotNull(driveContents.getDriveId(), "Only DriveContents obtained through DriveFile.open can be committed.");
        com.google.android.gms.drive.zzn zza = com.google.android.gms.drive.zzn.zza(executionOptions);
        if (ExecutionOptions.zza(zza.zzn()) && !driveContents.zzi().zzb()) {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
        if (metadataChangeSet == null) {
            metadataChangeSet = MetadataChangeSet.zzax;
        }
        return doWrite(new zzcy(this, zza, driveContents, metadataChangeSet));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<Void> discardContents(DriveContents driveContents) {
        Preconditions.checkArgument(!driveContents.zzk(), "DriveContents is already closed");
        driveContents.zzj();
        return doWrite(new zzda(this, driveContents));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zze(int i) {
        if (i != 268435456 && i != 536870912 && i != 805306368) {
            throw new IllegalArgumentException("Invalid openMode provided");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<MetadataBuffer> listChildren(DriveFolder driveFolder) {
        Preconditions.checkNotNull(driveFolder, "folder cannot be null.");
        return query(zzbs.zza((Query) null, driveFolder.getDriveId()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<MetadataBuffer> queryChildren(DriveFolder driveFolder, Query query) {
        Preconditions.checkNotNull(driveFolder, "folder cannot be null.");
        Preconditions.checkNotNull(query, "query cannot be null.");
        return query(zzbs.zza(query, driveFolder.getDriveId()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFile> createFile(DriveFolder driveFolder, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        return createFile(driveFolder, metadataChangeSet, driveContents, new ExecutionOptions.Builder().build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFile> createFile(DriveFolder driveFolder, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        zzbs.zzb(metadataChangeSet);
        return doWrite(new zzdh(driveFolder, metadataChangeSet, driveContents, executionOptions, null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResourceClient
    public final Task<DriveFolder> createFolder(DriveFolder driveFolder, MetadataChangeSet metadataChangeSet) {
        Preconditions.checkNotNull(metadataChangeSet, "MetadataChangeSet must be provided.");
        if (metadataChangeSet.getMimeType() != null && !metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
        return doWrite(new zzdb(this, metadataChangeSet, driveFolder));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static final /* synthetic */ ListenerToken zza(zzg zzgVar, Task task) throws Exception {
        if (task.isSuccessful()) {
            return zzgVar;
        }
        throw task.getException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static final /* synthetic */ ListenerToken zza(ListenerHolder listenerHolder, Task task) throws Exception {
        if (task.isSuccessful()) {
            return new zzg(listenerHolder.getListenerKey());
        }
        throw task.getException();
    }
}
