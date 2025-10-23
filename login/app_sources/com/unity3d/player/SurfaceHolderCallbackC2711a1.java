package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.unity3d.player.p030a.InterfaceC2706c;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.time.DurationKt;

/* renamed from: com.unity3d.player.a1 */
/* loaded from: classes3.dex */
public final class SurfaceHolderCallbackC2711a1 extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {

    /* renamed from: A */
    public static final /* synthetic */ int f1310A = 0;

    /* renamed from: a */
    private final Context f1311a;

    /* renamed from: b */
    private final SurfaceView f1312b;

    /* renamed from: c */
    private final SurfaceHolder f1313c;

    /* renamed from: d */
    private final String f1314d;

    /* renamed from: e */
    private final int f1315e;

    /* renamed from: f */
    private final int f1316f;

    /* renamed from: g */
    private final boolean f1317g;

    /* renamed from: h */
    private final long f1318h;

    /* renamed from: i */
    private final long f1319i;

    /* renamed from: j */
    private final SurfaceHolderCallbackC2711a1 f1320j;

    /* renamed from: k */
    private int f1321k;

    /* renamed from: l */
    private int f1322l;

    /* renamed from: m */
    private int f1323m;

    /* renamed from: n */
    private int f1324n;

    /* renamed from: o */
    private MediaPlayer f1325o;

    /* renamed from: p */
    private MediaController f1326p;

    /* renamed from: q */
    private boolean f1327q;

    /* renamed from: r */
    private boolean f1328r;

    /* renamed from: s */
    private int f1329s;

    /* renamed from: t */
    private boolean f1330t;

    /* renamed from: u */
    private int f1331u;

    /* renamed from: v */
    private boolean f1332v;

    /* renamed from: w */
    private C2654C f1333w;

    /* renamed from: x */
    private InterfaceC2700Y0 f1334x;

    /* renamed from: y */
    private RunnableC2702Z0 f1335y;

    /* renamed from: z */
    private volatile int f1336z;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected SurfaceHolderCallbackC2711a1(Context context, UnityPlayer unityPlayer, String str, int i, int i2, int i3, boolean z, long j, long j2, InterfaceC2700Y0 interfaceC2700Y0) {
        super(context);
        this.f1327q = false;
        this.f1328r = false;
        this.f1329s = 0;
        this.f1330t = false;
        this.f1331u = 0;
        this.f1332v = false;
        this.f1333w = null;
        this.f1336z = 0;
        this.f1334x = interfaceC2700Y0;
        this.f1311a = context;
        this.f1320j = this;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f1312b = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.f1313c = holder;
        holder.addCallback(this);
        setBackgroundColor(i);
        addView(surfaceView);
        this.f1314d = str;
        this.f1315e = i2;
        this.f1316f = i3;
        this.f1317g = z;
        this.f1318h = j;
        this.f1319i = j2;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f1333w = C2656D.m731a(unityPlayer.getActivity(), DurationKt.NANOS_IN_MILLIS, new RunnableC2698X0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public void m777a(int i) {
        this.f1336z = i;
        InterfaceC2700Y0 interfaceC2700Y0 = this.f1334x;
        if (interfaceC2700Y0 != null) {
            ((C2717c1) interfaceC2700Y0).m781a(this.f1336z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    final boolean m778a() {
        return this.f1330t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancelOnPrepare() {
        m777a(2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void destroyPlayer() {
        if (!this.f1330t) {
            pause();
        }
        doCleanUp();
        C2654C c2654c = this.f1333w;
        if (c2654c != null) {
            c2654c.unregisterOnBackPressedCallback();
            this.f1333w = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void doCleanUp() {
        RunnableC2702Z0 runnableC2702Z0 = this.f1335y;
        if (runnableC2702Z0 != null) {
            runnableC2702Z0.f1302b = true;
            this.f1335y = null;
        }
        MediaPlayer mediaPlayer = this.f1325o;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f1325o.release();
            this.f1325o = null;
        }
        this.f1323m = 0;
        this.f1324n = 0;
        this.f1328r = false;
        this.f1327q = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean exitOnKeypress(int i, KeyEvent keyEvent) {
        Runnable runnable;
        if (i != 4 && (this.f1315e != 2 || i == 0 || keyEvent.isSystem())) {
            return false;
        }
        InterfaceC2706c interfaceC2706c = this.f1333w.f1150a;
        if ((interfaceC2706c != null) && (runnable = ((C2652B) interfaceC2706c).f1148a) != null) {
            runnable.run();
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        MediaPlayer mediaPlayer = this.f1325o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getAudioSessionId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f1317g) {
            return this.f1329s;
        }
        return 100;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f1325o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        MediaPlayer mediaPlayer = this.f1325o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        boolean z = this.f1328r && this.f1327q;
        MediaPlayer mediaPlayer = this.f1325o;
        return mediaPlayer == null ? !z : mediaPlayer.isPlaying() || !z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f1329s = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        destroyPlayer();
        m777a(3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        MediaController mediaController = this.f1326p;
        return mediaController != null ? mediaController.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (exitOnKeypress(i, keyEvent)) {
            return true;
        }
        MediaController mediaController = this.f1326p;
        return mediaController != null ? mediaController.onKeyUp(i, keyEvent) : super.onKeyUp(i, keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        RunnableC2702Z0 runnableC2702Z0 = this.f1335y;
        if (runnableC2702Z0 != null) {
            runnableC2702Z0.f1302b = true;
            this.f1335y = null;
        }
        int i = this.f1315e;
        if (i == 0 || i == 1) {
            MediaController mediaController = new MediaController(this.f1311a);
            this.f1326p = mediaController;
            mediaController.setMediaPlayer(this);
            this.f1326p.setAnchorView(this);
            this.f1326p.setEnabled(true);
            Context context = this.f1311a;
            if (context instanceof Activity) {
                this.f1326p.setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.f1326p.show();
        }
        this.f1328r = true;
        if (!this.f1327q || isPlaying()) {
            return;
        }
        m777a(1);
        updateVideoLayout();
        if (this.f1330t) {
            return;
        }
        start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f1315e != 2 || action != 0) {
            MediaController mediaController = this.f1326p;
            return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        destroyPlayer();
        m777a(3);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.f1327q = true;
        this.f1323m = i;
        this.f1324n = i2;
        if (!this.f1328r || isPlaying()) {
            return;
        }
        m777a(1);
        updateVideoLayout();
        if (this.f1330t) {
            return;
        }
        start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        MediaPlayer mediaPlayer = this.f1325o;
        if (mediaPlayer == null) {
            return;
        }
        if (this.f1332v) {
            this.f1331u = mediaPlayer.getCurrentPosition();
            this.f1325o.pause();
        }
        this.f1330t = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        MediaPlayer mediaPlayer = this.f1325o;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        MediaPlayer mediaPlayer = this.f1325o;
        if (mediaPlayer == null) {
            return;
        }
        if (this.f1332v) {
            int i = this.f1331u;
            if (i > 0) {
                mediaPlayer.seekTo(i);
            }
            this.f1325o.start();
            this.f1331u = 0;
        }
        this.f1330t = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f1321k == i2 && this.f1322l == i3) {
            return;
        }
        this.f1321k = i2;
        this.f1322l = i3;
        if (this.f1332v) {
            updateVideoLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        FileInputStream fileInputStream;
        this.f1332v = true;
        if (this.f1330t) {
            MediaPlayer mediaPlayer = this.f1325o;
            if (mediaPlayer == null || this.f1331u <= 0) {
                return;
            }
            mediaPlayer.setDisplay(this.f1313c);
            this.f1325o.seekTo(this.f1331u);
            return;
        }
        MediaPlayer mediaPlayer2 = this.f1325o;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setDisplay(this.f1313c);
            if (this.f1330t) {
                return;
            }
            int i = this.f1331u;
            if (i > 0) {
                this.f1325o.seekTo(i);
            }
            this.f1325o.start();
            this.f1331u = 0;
            return;
        }
        m777a(0);
        doCleanUp();
        try {
            MediaPlayer mediaPlayer3 = new MediaPlayer();
            this.f1325o = mediaPlayer3;
            if (this.f1317g) {
                mediaPlayer3.setDataSource(this.f1311a, Uri.parse(this.f1314d));
            } else {
                if (this.f1319i != 0) {
                    fileInputStream = new FileInputStream(this.f1314d);
                    this.f1325o.setDataSource(fileInputStream.getFD(), this.f1318h, this.f1319i);
                } else {
                    try {
                        AssetFileDescriptor openFd = getResources().getAssets().openFd(this.f1314d);
                        this.f1325o.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                    } catch (IOException unused) {
                        fileInputStream = new FileInputStream(this.f1314d);
                        this.f1325o.setDataSource(fileInputStream.getFD());
                    }
                }
                fileInputStream.close();
            }
            this.f1325o.setDisplay(this.f1313c);
            this.f1325o.setScreenOnWhilePlaying(true);
            this.f1325o.setOnBufferingUpdateListener(this);
            this.f1325o.setOnCompletionListener(this);
            this.f1325o.setOnPreparedListener(this);
            this.f1325o.setOnVideoSizeChangedListener(this);
            this.f1325o.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build());
            this.f1325o.prepareAsync();
            this.f1335y = new RunnableC2702Z0(this);
            new Thread(this.f1335y).start();
        } catch (Exception unused2) {
            m777a(2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f1332v = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r7 <= r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        r2 = (int) (r6 * r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        r4 = (int) (r5 / r3);
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r7 >= r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        if (r8 == 0) goto L27;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void updateVideoLayout() {
        /*
            r10 = this;
            android.media.MediaPlayer r0 = r10.f1325o
            if (r0 != 0) goto L5
            return
        L5:
            android.content.Context r0 = r10.f1311a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getMetrics(r1)
            int r0 = r1.widthPixels
            if (r0 <= 0) goto L27
            int r1 = r1.heightPixels
            if (r1 <= 0) goto L27
            r10.f1321k = r0
            r10.f1322l = r1
        L27:
            int r0 = r10.f1321k
            int r1 = r10.f1322l
            boolean r2 = r10.f1327q
            if (r2 == 0) goto L55
            int r2 = r10.f1323m
            float r3 = (float) r2
            int r4 = r10.f1324n
            float r5 = (float) r4
            float r3 = r3 / r5
            float r5 = (float) r0
            float r6 = (float) r1
            float r7 = r5 / r6
            int r8 = r10.f1316f
            r9 = 1
            if (r8 != r9) goto L44
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 > 0) goto L4f
            goto L4b
        L44:
            r9 = 2
            if (r8 != r9) goto L52
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 < 0) goto L4f
        L4b:
            float r5 = r5 / r3
            int r4 = (int) r5
            r2 = r0
            goto L57
        L4f:
            float r6 = r6 * r3
            int r2 = (int) r6
            goto L56
        L52:
            if (r8 != 0) goto L55
            goto L57
        L55:
            r2 = r0
        L56:
            r4 = r1
        L57:
            if (r0 != r2) goto L5b
            if (r1 == r4) goto L69
        L5b:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = 17
            r0.<init>(r2, r4, r1)
            com.unity3d.player.a1 r1 = r10.f1320j
            android.view.SurfaceView r2 = r10.f1312b
            r1.updateViewLayout(r2, r0)
        L69:
            return
            fill-array 0x006a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.SurfaceHolderCallbackC2711a1.updateVideoLayout():void");
    }
}
