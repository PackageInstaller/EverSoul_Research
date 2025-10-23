package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.google.android.gms.drive.DriveFile;
import com.kakao.sdk.user.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VideoUploader {
    private static final String ERROR_BAD_SERVER_RESPONSE = "Unexpected error in server response";
    private static final String ERROR_UPLOAD = "Video upload failed";
    private static final int MAX_RETRIES_PER_PHASE = 2;
    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_END_OFFSET = "end_offset";
    private static final String PARAM_FILE_SIZE = "file_size";
    private static final String PARAM_REF = "ref";
    private static final String PARAM_SESSION_ID = "upload_session_id";
    private static final String PARAM_START_OFFSET = "start_offset";
    private static final String PARAM_TITLE = "title";
    private static final String PARAM_UPLOAD_PHASE = "upload_phase";
    private static final String PARAM_VALUE_UPLOAD_FINISH_PHASE = "finish";
    private static final String PARAM_VALUE_UPLOAD_START_PHASE = "start";
    private static final String PARAM_VALUE_UPLOAD_TRANSFER_PHASE = "transfer";
    private static final String PARAM_VIDEO_FILE_CHUNK = "video_file_chunk";
    private static final String PARAM_VIDEO_ID = "video_id";
    private static final int RETRY_DELAY_BACK_OFF_FACTOR = 3;
    private static final int RETRY_DELAY_UNIT_MS = 5000;
    private static final String TAG = "VideoUploader";
    private static final int UPLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static AccessTokenTracker accessTokenTracker;
    private static Handler handler;
    private static boolean initialized;
    private static WorkQueue uploadQueue = new WorkQueue(8);
    private static Set<UploadContext> pendingUploads = new HashSet();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void uploadAsyncWithProgressCallback(ShareVideoContent videoContent, GraphRequest.OnProgressCallback callback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(videoContent, TournamentShareDialogURIBuilder.me, null, callback);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void uploadAsyncWithProgressCallback(ShareVideoContent videoContent, String graphNode, GraphRequest.OnProgressCallback callback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(videoContent, graphNode, null, callback);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void uploadAsync(ShareVideoContent videoContent, String graphNode, FacebookCallback<Sharer.Result> callback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(videoContent, graphNode, callback, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized void uploadAsync(ShareVideoContent videoContent, String graphNode, FacebookCallback<Sharer.Result> callback, GraphRequest.OnProgressCallback progressCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            if (!initialized) {
                registerAccessTokenTracker();
                initialized = true;
            }
            Validate.notNull(videoContent, "videoContent");
            Validate.notNull(graphNode, "graphNode");
            ShareVideo video = videoContent.getVideo();
            Validate.notNull(video, "videoContent.video");
            Validate.notNull(video.getLocalUrl(), "videoContent.video.localUrl");
            UploadContext uploadContext = new UploadContext(videoContent, graphNode, callback, progressCallback);
            uploadContext.initialize();
            pendingUploads.add(uploadContext);
            enqueueUploadStart(uploadContext, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void cancelAllRequests() {
        synchronized (VideoUploader.class) {
            Iterator<UploadContext> it = pendingUploads.iterator();
            while (it.hasNext()) {
                it.next().isCanceled = true;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized void removePendingUpload(UploadContext uploadContext) {
        synchronized (VideoUploader.class) {
            pendingUploads.remove(uploadContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (VideoUploader.class) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void issueResponse(final UploadContext uploadContext, final FacebookException error, final GraphResponse response, final String videoId) {
        removePendingUpload(uploadContext);
        Utility.closeQuietly(uploadContext.videoStream);
        if (uploadContext.callback != null) {
            if (error != null) {
                ShareInternalUtility.invokeOnErrorCallback(uploadContext.callback, error);
            } else if (uploadContext.isCanceled) {
                ShareInternalUtility.invokeOnCancelCallback(uploadContext.callback);
            } else {
                ShareInternalUtility.invokeOnSuccessCallback(uploadContext.callback, videoId);
            }
        }
        if (uploadContext.progressCallback != null) {
            if (response != null) {
                try {
                    if (response.getJSONObject() != null) {
                        response.getJSONObject().put(PARAM_VIDEO_ID, videoId);
                    }
                } catch (JSONException unused) {
                }
            }
            uploadContext.progressCallback.onCompleted(response);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void enqueueUploadStart(UploadContext uploadContext, int completedRetries) {
        enqueueRequest(uploadContext, new StartUploadWorkItem(uploadContext, completedRetries));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void enqueueUploadChunk(UploadContext uploadContext, String chunkStart, String chunkEnd, int completedRetries) {
        enqueueRequest(uploadContext, new TransferChunkWorkItem(uploadContext, chunkStart, chunkEnd, completedRetries));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void enqueueUploadFinish(UploadContext uploadContext, int completedRetries) {
        enqueueRequest(uploadContext, new FinishUploadWorkItem(uploadContext, completedRetries));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized void enqueueRequest(UploadContext uploadContext, Runnable workItem) {
        synchronized (VideoUploader.class) {
            uploadContext.workItem = uploadQueue.addActiveWorkItem(workItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] getChunk(UploadContext uploadContext, String chunkStart, String chunkEnd) throws IOException {
        int read;
        if (!Utility.areObjectsEqual(chunkStart, uploadContext.chunkStart)) {
            logError(null, "Error reading video chunk. Expected chunk '%s'. Requested chunk '%s'.", uploadContext.chunkStart, chunkStart);
            return null;
        }
        int parseLong = (int) (Long.parseLong(chunkEnd) - Long.parseLong(chunkStart));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Math.min(8192, parseLong)];
        do {
            read = uploadContext.videoStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
                parseLong -= read;
                if (parseLong == 0) {
                }
            }
            uploadContext.chunkStart = chunkEnd;
            return byteArrayOutputStream.toByteArray();
        } while (parseLong >= 0);
        logError(null, "Error reading video chunk. Expected buffer length - '%d'. Actual - '%d'.", Integer.valueOf(parseLong + read), Integer.valueOf(read));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void registerAccessTokenTracker() {
        accessTokenTracker = new AccessTokenTracker() { // from class: com.facebook.share.internal.VideoUploader.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.AccessTokenTracker
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if (oldAccessToken == null) {
                    return;
                }
                if (currentAccessToken == null || !Utility.areObjectsEqual(currentAccessToken.getUserId(), oldAccessToken.getUserId())) {
                    VideoUploader.cancelAllRequests();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logError(Exception e, String format, Object... args) {
        Log.e(TAG, String.format(Locale.ROOT, format, args), e);
    }

    private static class UploadContext {
        public final AccessToken accessToken;
        public final FacebookCallback<Sharer.Result> callback;
        public String chunkStart;
        public final String description;
        public final String graphNode;
        public boolean isCanceled;
        public Bundle params;
        public final GraphRequest.OnProgressCallback progressCallback;
        public final String ref;
        public String sessionId;
        public final String title;
        public String videoId;
        public long videoSize;
        public InputStream videoStream;
        public final Uri videoUri;
        public WorkQueue.WorkItem workItem;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private UploadContext(ShareVideoContent videoContent, String graphNode, FacebookCallback<Sharer.Result> callback, GraphRequest.OnProgressCallback progressCallback) {
            this.chunkStart = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.accessToken = AccessToken.getCurrentAccessToken();
            this.videoUri = videoContent.getVideo().getLocalUrl();
            this.title = videoContent.getContentTitle();
            this.description = videoContent.getContentDescription();
            this.ref = videoContent.getRef();
            this.graphNode = graphNode;
            this.callback = callback;
            this.progressCallback = progressCallback;
            this.params = videoContent.getVideo().getParameters();
            if (!Utility.isNullOrEmpty(videoContent.getPeopleIds())) {
                this.params.putString(Constants.TAGS, TextUtils.join(", ", videoContent.getPeopleIds()));
            }
            if (!Utility.isNullOrEmpty(videoContent.getPlaceId())) {
                this.params.putString("place", videoContent.getPlaceId());
            }
            if (Utility.isNullOrEmpty(videoContent.getRef())) {
                return;
            }
            this.params.putString(VideoUploader.PARAM_REF, videoContent.getRef());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void initialize() throws FileNotFoundException {
            try {
                if (Utility.isFileUri(this.videoUri)) {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(this.videoUri.getPath()), DriveFile.MODE_READ_ONLY);
                    this.videoSize = open.getStatSize();
                    this.videoStream = new ParcelFileDescriptor.AutoCloseInputStream(open);
                } else {
                    if (Utility.isContentUri(this.videoUri)) {
                        this.videoSize = Utility.getContentSize(this.videoUri);
                        this.videoStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(this.videoUri);
                        return;
                    }
                    throw new FacebookException("Uri must be a content:// or file:// uri");
                }
            } catch (FileNotFoundException e) {
                Utility.closeQuietly(this.videoStream);
                throw e;
            }
        }
    }

    private static class StartUploadWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader.StartUploadWorkItem.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                add(6000);
            }
        };

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StartUploadWorkItem(UploadContext uploadContext, int completedRetries) {
            super(uploadContext, completedRetries);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        public Bundle getParameters() {
            Bundle bundle = new Bundle();
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE);
            bundle.putLong(VideoUploader.PARAM_FILE_SIZE, this.uploadContext.videoSize);
            return bundle;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void handleSuccess(JSONObject jsonObject) throws JSONException {
            this.uploadContext.sessionId = jsonObject.getString(VideoUploader.PARAM_SESSION_ID);
            this.uploadContext.videoId = jsonObject.getString(VideoUploader.PARAM_VIDEO_ID);
            String string = jsonObject.getString(VideoUploader.PARAM_START_OFFSET);
            String string2 = jsonObject.getString(VideoUploader.PARAM_END_OFFSET);
            if (this.uploadContext.progressCallback != null) {
                this.uploadContext.progressCallback.onProgress(Long.parseLong(string), this.uploadContext.videoSize);
            }
            VideoUploader.enqueueUploadChunk(this.uploadContext, string, string2, 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void handleError(FacebookException error) {
            VideoUploader.logError(error, "Error starting video upload", new Object[0]);
            endUploadWithFailure(error);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void enqueueRetry(int retriesCompleted) {
            VideoUploader.enqueueUploadStart(this.uploadContext, retriesCompleted);
        }
    }

    private static class TransferChunkWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader.TransferChunkWorkItem.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                add(1363019);
                add(1363021);
                add(1363030);
                add(1363033);
                add(1363041);
            }
        };
        private String chunkEnd;
        private String chunkStart;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public TransferChunkWorkItem(UploadContext uploadContext, String chunkStart, String chunkEnd, int completedRetries) {
            super(uploadContext, completedRetries);
            this.chunkStart = chunkStart;
            this.chunkEnd = chunkEnd;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        public Bundle getParameters() throws IOException {
            Bundle bundle = new Bundle();
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_TRANSFER_PHASE);
            bundle.putString(VideoUploader.PARAM_SESSION_ID, this.uploadContext.sessionId);
            bundle.putString(VideoUploader.PARAM_START_OFFSET, this.chunkStart);
            byte[] chunk = VideoUploader.getChunk(this.uploadContext, this.chunkStart, this.chunkEnd);
            if (chunk != null) {
                bundle.putByteArray(VideoUploader.PARAM_VIDEO_FILE_CHUNK, chunk);
                return bundle;
            }
            throw new FacebookException("Error reading video");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void handleSuccess(JSONObject jsonObject) throws JSONException {
            String string = jsonObject.getString(VideoUploader.PARAM_START_OFFSET);
            String string2 = jsonObject.getString(VideoUploader.PARAM_END_OFFSET);
            if (this.uploadContext.progressCallback != null) {
                this.uploadContext.progressCallback.onProgress(Long.parseLong(string), this.uploadContext.videoSize);
            }
            if (Utility.areObjectsEqual(string, string2)) {
                VideoUploader.enqueueUploadFinish(this.uploadContext, 0);
            } else {
                VideoUploader.enqueueUploadChunk(this.uploadContext, string, string2, 0);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void handleError(FacebookException error) {
            VideoUploader.logError(error, "Error uploading video '%s'", this.uploadContext.videoId);
            endUploadWithFailure(error);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void enqueueRetry(int retriesCompleted) {
            VideoUploader.enqueueUploadChunk(this.uploadContext, this.chunkStart, this.chunkEnd, retriesCompleted);
        }
    }

    private static class FinishUploadWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader.FinishUploadWorkItem.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                add(1363011);
            }
        };

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FinishUploadWorkItem(UploadContext uploadContext, int completedRetries) {
            super(uploadContext, completedRetries);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        public Bundle getParameters() {
            Bundle bundle = new Bundle();
            if (this.uploadContext.params != null) {
                bundle.putAll(this.uploadContext.params);
            }
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_FINISH_PHASE);
            bundle.putString(VideoUploader.PARAM_SESSION_ID, this.uploadContext.sessionId);
            Utility.putNonEmptyString(bundle, "title", this.uploadContext.title);
            Utility.putNonEmptyString(bundle, "description", this.uploadContext.description);
            Utility.putNonEmptyString(bundle, VideoUploader.PARAM_REF, this.uploadContext.ref);
            return bundle;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void handleSuccess(JSONObject jsonObject) throws JSONException {
            if (jsonObject.getBoolean("success")) {
                issueResponseOnMainThread(null, this.uploadContext.videoId);
            } else {
                handleError(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void handleError(FacebookException error) {
            VideoUploader.logError(error, "Video '%s' failed to finish uploading", this.uploadContext.videoId);
            endUploadWithFailure(error);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.facebook.share.internal.VideoUploader.UploadWorkItemBase
        protected void enqueueRetry(int retriesCompleted) {
            VideoUploader.enqueueUploadFinish(this.uploadContext, retriesCompleted);
        }
    }

    private static abstract class UploadWorkItemBase implements Runnable {
        protected int completedRetries;
        protected GraphResponse response;
        protected UploadContext uploadContext;

        protected abstract void enqueueRetry(int retriesCompleted);

        protected abstract Bundle getParameters() throws Exception;

        protected abstract Set<Integer> getTransientErrorCodes();

        protected abstract void handleError(FacebookException error);

        protected abstract void handleSuccess(JSONObject jsonObject) throws JSONException;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected UploadWorkItemBase(UploadContext uploadContext, int completedRetries) {
            this.uploadContext = uploadContext;
            this.completedRetries = completedRetries;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (!this.uploadContext.isCanceled) {
                    try {
                        executeGraphRequestSynchronously(getParameters());
                        return;
                    } catch (FacebookException e) {
                        endUploadWithFailure(e);
                        return;
                    } catch (Exception e2) {
                        endUploadWithFailure(new FacebookException(VideoUploader.ERROR_UPLOAD, e2));
                        return;
                    }
                }
                endUploadWithFailure(null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void executeGraphRequestSynchronously(Bundle parameters) {
            GraphResponse executeAndWait = new GraphRequest(this.uploadContext.accessToken, String.format(Locale.ROOT, "%s/videos", this.uploadContext.graphNode), parameters, HttpMethod.POST, null).executeAndWait();
            this.response = executeAndWait;
            if (executeAndWait != null) {
                FacebookRequestError error = executeAndWait.getError();
                JSONObject jSONObject = this.response.getJSONObject();
                if (error != null) {
                    if (attemptRetry(error.getSubErrorCode())) {
                        return;
                    }
                    handleError(new FacebookGraphResponseException(this.response, VideoUploader.ERROR_UPLOAD));
                    return;
                } else {
                    if (jSONObject != null) {
                        try {
                            handleSuccess(jSONObject);
                            return;
                        } catch (JSONException e) {
                            endUploadWithFailure(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE, e));
                            return;
                        }
                    }
                    handleError(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
                    return;
                }
            }
            handleError(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean attemptRetry(int errorCode) {
            if (this.completedRetries >= 2 || !getTransientErrorCodes().contains(Integer.valueOf(errorCode))) {
                return false;
            }
            VideoUploader.getHandler().postDelayed(new Runnable() { // from class: com.facebook.share.internal.VideoUploader.UploadWorkItemBase.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        UploadWorkItemBase uploadWorkItemBase = UploadWorkItemBase.this;
                        uploadWorkItemBase.enqueueRetry(uploadWorkItemBase.completedRetries + 1);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }, ((int) Math.pow(3.0d, this.completedRetries)) * 5000);
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void endUploadWithFailure(FacebookException error) {
            issueResponseOnMainThread(error, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void issueResponseOnMainThread(final FacebookException error, final String videoId) {
            VideoUploader.getHandler().post(new Runnable() { // from class: com.facebook.share.internal.VideoUploader.UploadWorkItemBase.2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        VideoUploader.issueResponse(UploadWorkItemBase.this.uploadContext, error, UploadWorkItemBase.this.response, videoId);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        }
    }
}
