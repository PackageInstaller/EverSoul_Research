package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import com.unity3d.player.p030a.InterfaceC2705b;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.w */
/* loaded from: classes3.dex */
public final class C2762w {

    /* renamed from: B */
    private static CameraManager f1456B;

    /* renamed from: C */
    private static String[] f1457C;

    /* renamed from: D */
    private static Semaphore f1458D = new Semaphore(1);

    /* renamed from: a */
    private InterfaceC2705b f1460a;

    /* renamed from: b */
    private CameraDevice f1461b;

    /* renamed from: c */
    private HandlerThread f1462c;

    /* renamed from: d */
    private Handler f1463d;

    /* renamed from: e */
    private Rect f1464e;

    /* renamed from: f */
    private Rect f1465f;

    /* renamed from: g */
    private int f1466g;

    /* renamed from: h */
    private int f1467h;

    /* renamed from: k */
    private int f1470k;

    /* renamed from: l */
    private int f1471l;

    /* renamed from: n */
    private Range f1473n;

    /* renamed from: p */
    private Image f1475p;

    /* renamed from: q */
    private CaptureRequest.Builder f1476q;

    /* renamed from: t */
    private int f1479t;

    /* renamed from: u */
    private SurfaceTexture f1480u;

    /* renamed from: i */
    private float f1468i = -1.0f;

    /* renamed from: j */
    private float f1469j = -1.0f;

    /* renamed from: m */
    private boolean f1472m = false;

    /* renamed from: o */
    private ImageReader f1474o = null;

    /* renamed from: r */
    private CameraCaptureSession f1477r = null;

    /* renamed from: s */
    private Object f1478s = new Object();

    /* renamed from: v */
    private Surface f1481v = null;

    /* renamed from: A */
    private int f1459A = 3;

    /* renamed from: w */
    private CameraCaptureSession.CaptureCallback f1482w = new C2752r(this);

    /* renamed from: x */
    private final CameraDevice.StateCallback f1483x = new C2756t(this);

    /* renamed from: y */
    private final ImageReader.OnImageAvailableListener f1484y = new C2758u(this);

    /* renamed from: z */
    private final SurfaceTexture.OnFrameAvailableListener f1485z = new C2760v(this);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected C2762w(InterfaceC2705b interfaceC2705b) {
        this.f1460a = null;
        this.f1460a = interfaceC2705b;
        m824e();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static int m814a(Context context) {
        return m820b(context).length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static int m815a(Context context, int i) {
        try {
            CameraCharacteristics cameraCharacteristics = m822c(context).getCameraCharacteristics(m820b(context)[i]);
            float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
            SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if (fArr.length > 0) {
                return (int) ((fArr[0] * 36.0f) / sizeF.getWidth());
            }
        } catch (CameraAccessException e) {
            AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public void m816a(CameraDevice cameraDevice) {
        synchronized (this.f1478s) {
            this.f1477r = null;
        }
        cameraDevice.close();
        this.f1461b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public void m817a(Object obj) {
        if (obj != "Focus") {
            if (obj == "Cancel focus") {
                synchronized (this.f1478s) {
                    if (this.f1477r != null) {
                        m827g();
                    }
                }
                return;
            }
            return;
        }
        this.f1472m = false;
        synchronized (this.f1478s) {
            if (this.f1477r != null) {
                try {
                    this.f1476q.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                    this.f1476q.setTag("Regular");
                    this.f1477r.setRepeatingRequest(this.f1476q.build(), this.f1482w, this.f1463d);
                } catch (CameraAccessException e) {
                    AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    private void m818b() {
        try {
            Semaphore semaphore = f1458D;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!semaphore.tryAcquire(4L, timeUnit)) {
                AbstractC2768z.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.f1461b.close();
            try {
                if (!f1458D.tryAcquire(4L, timeUnit)) {
                    AbstractC2768z.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e) {
                AbstractC2768z.Log(6, "Camera2: Interrupted while waiting to close camera " + e);
            }
            this.f1461b = null;
            f1458D.release();
        } catch (InterruptedException e2) {
            AbstractC2768z.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        if (r3.length != 0) goto L13;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] m819b(android.content.Context r3, int r4) {
        /*
            r0 = 6
            r1 = 0
            android.hardware.camera2.CameraManager r2 = m822c(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            java.lang.String[] r3 = m820b(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            r3 = r3[r4]     // Catch: android.hardware.camera2.CameraAccessException -> L51
            android.hardware.camera2.CameraCharacteristics r3 = r2.getCameraCharacteristics(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
            java.lang.Object r3 = r3.get(r4)
            android.hardware.camera2.params.StreamConfigurationMap r3 = (android.hardware.camera2.params.StreamConfigurationMap) r3
            if (r3 != 0) goto L21
            java.lang.String r3 = "Camera2: configuration map is not available."
            com.unity3d.player.AbstractC2768z.Log(r0, r3)
        L1f:
            r3 = r1
            goto L2d
        L21:
            r4 = 35
            android.util.Size[] r3 = r3.getOutputSizes(r4)
            if (r3 == 0) goto L1f
            int r4 = r3.length
            if (r4 != 0) goto L2d
            goto L1f
        L2d:
            if (r3 == 0) goto L50
            int r4 = r3.length
            int r4 = r4 * 2
            int[] r4 = new int[r4]
            r0 = 0
        L35:
            int r1 = r3.length
            if (r0 >= r1) goto L4f
            int r1 = r0 * 2
            r2 = r3[r0]
            int r2 = r2.getWidth()
            r4[r1] = r2
            int r1 = r1 + 1
            r2 = r3[r0]
            int r2 = r2.getHeight()
            r4[r1] = r2
            int r0 = r0 + 1
            goto L35
        L4f:
            return r4
        L50:
            return r1
        L51:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r2 = "Camera2: CameraAccessException "
            r4.<init>(r2)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r3 = r3.toString()
            com.unity3d.player.AbstractC2768z.Log(r0, r3)
            return r1
            fill-array 0x0066: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C2762w.m819b(android.content.Context, int):int[]");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    private static String[] m820b(Context context) {
        if (f1457C == null) {
            try {
                f1457C = m822c(context).getCameraIdList();
            } catch (CameraAccessException e) {
                AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
                f1457C = new String[0];
            }
        }
        return f1457C;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public static int m821c(Context context, int i) {
        try {
            return ((Integer) m822c(context).getCameraCharacteristics(m820b(context)[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e) {
            AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    private static CameraManager m822c(Context context) {
        if (f1456B == null) {
            f1456B = (CameraManager) context.getSystemService("camera");
        }
        return f1456B;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public static boolean m823d(Context context, int i) {
        try {
            return ((Integer) m822c(context).getCameraCharacteristics(m820b(context)[i]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e) {
            AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    private void m824e() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.f1462c = handlerThread;
        handlerThread.start();
        this.f1463d = new Handler(this.f1462c.getLooper());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public static boolean m825e(Context context, int i) {
        try {
            return ((Integer) m822c(context).getCameraCharacteristics(m820b(context)[i]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e) {
            AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: f */
    private void m826f() {
        try {
            CameraCaptureSession cameraCaptureSession = this.f1477r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
                this.f1476q.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.f1476q.set(CaptureRequest.CONTROL_AF_MODE, 0);
                this.f1476q.setTag("Cancel focus");
                this.f1477r.capture(this.f1476q.build(), this.f1482w, this.f1463d);
            }
        } catch (CameraAccessException e) {
            AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: g */
    public void m827g() {
        try {
            if (this.f1467h != 0) {
                float f = this.f1468i;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.f1469j;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        this.f1472m = true;
                        int width = this.f1465f.width();
                        int i = (int) (((width - (r2 * 2)) * this.f1468i) + this.f1470k);
                        int height = this.f1465f.height();
                        int i2 = (int) (((1.0d - this.f1469j) * (height - (r3 * 2))) + this.f1471l);
                        int max = Math.max(this.f1466g + 1, Math.min(i, (this.f1465f.width() - this.f1466g) - 1));
                        int max2 = Math.max(this.f1466g + 1, Math.min(i2, (this.f1465f.height() - this.f1466g) - 1));
                        CaptureRequest.Builder builder = this.f1476q;
                        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
                        int i3 = this.f1466g;
                        int i4 = i3 * 2;
                        builder.set(key, new MeteringRectangle[]{new MeteringRectangle(max - i3, max2 - i3, i4, i4, 999)});
                        this.f1476q.set(CaptureRequest.CONTROL_AF_MODE, 1);
                        this.f1476q.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                        this.f1476q.setTag("Focus");
                        this.f1477r.capture(this.f1476q.build(), this.f1482w, this.f1463d);
                    }
                }
            }
            this.f1476q.set(CaptureRequest.CONTROL_AF_MODE, 4);
            this.f1476q.setTag("Regular");
            CameraCaptureSession cameraCaptureSession = this.f1477r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.setRepeatingRequest(this.f1476q.build(), this.f1482w, this.f1463d);
            }
        } catch (CameraAccessException e) {
            AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m828a() {
        if (this.f1461b != null) {
            m834i();
            m818b();
            this.f1482w = null;
            this.f1481v = null;
            this.f1480u = null;
            Image image = this.f1475p;
            if (image != null) {
                image.close();
                this.f1475p = null;
            }
            ImageReader imageReader = this.f1474o;
            if (imageReader != null) {
                imageReader.close();
                this.f1474o = null;
            }
        }
        this.f1462c.quit();
        try {
            this.f1462c.join(4000L);
            this.f1462c = null;
            this.f1463d = null;
        } catch (InterruptedException e) {
            this.f1462c.interrupt();
            AbstractC2768z.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final boolean m829a(float f, float f2) {
        if (this.f1467h <= 0) {
            return false;
        }
        if (this.f1472m) {
            AbstractC2768z.Log(5, "Camera2: Setting manual focus point already started.");
            return false;
        }
        this.f1468i = f;
        this.f1469j = f2;
        synchronized (this.f1478s) {
            if (this.f1477r != null && this.f1459A != 2) {
                m826f();
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final boolean m830a(Context context, int i, int i2, int i3, int i4, int i5, Surface surface) {
        int i6 = i4;
        try {
            CameraCharacteristics cameraCharacteristics = f1456B.getCameraCharacteristics(m820b(context)[i]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                AbstractC2768z.Log(5, "Camera2: only LEGACY hardware level is supported.");
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            Size[] sizeArr = null;
            if (streamConfigurationMap == null) {
                AbstractC2768z.Log(6, "Camera2: configuration map is not available.");
            } else {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (outputSizes != null && outputSizes.length != 0) {
                    sizeArr = outputSizes;
                }
            }
            if (sizeArr == null || sizeArr.length == 0) {
                return false;
            }
            double d = i2;
            double d2 = i3;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            double d3 = Double.MAX_VALUE;
            while (i7 < sizeArr.length) {
                int width = sizeArr[i7].getWidth();
                int height = sizeArr[i7].getHeight();
                CameraCharacteristics cameraCharacteristics2 = cameraCharacteristics;
                double d4 = d;
                double abs = Math.abs(Math.log(d2 / height)) + Math.abs(Math.log(d / width));
                if (abs < d3) {
                    i8 = height;
                    d3 = abs;
                    i9 = width;
                }
                i7++;
                cameraCharacteristics = cameraCharacteristics2;
                d = d4;
            }
            CameraCharacteristics cameraCharacteristics3 = cameraCharacteristics;
            this.f1464e = new Rect(0, 0, i9, i8);
            Range[] rangeArr = (Range[]) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (rangeArr == null || rangeArr.length == 0) {
                AbstractC2768z.Log(6, "Camera2: target FPS ranges are not avialable.");
                return false;
            }
            int i10 = -1;
            int i11 = 0;
            double d5 = Double.MAX_VALUE;
            while (true) {
                if (i11 < rangeArr.length) {
                    int intValue = ((Integer) rangeArr[i11].getLower()).intValue();
                    int intValue2 = ((Integer) rangeArr[i11].getUpper()).intValue();
                    float f = i6;
                    if (f + 0.1f > intValue && f - 0.1f < intValue2) {
                        break;
                    }
                    if (r7 < d5) {
                        i10 = i11;
                        d5 = r7;
                    }
                    i11++;
                } else {
                    i6 = ((Integer) (i6 > ((Integer) rangeArr[i10].getUpper()).intValue() ? rangeArr[i10].getUpper() : rangeArr[i10].getLower())).intValue();
                }
            }
            this.f1473n = new Range(Integer.valueOf(i6), Integer.valueOf(i6));
            try {
                Semaphore semaphore = f1458D;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (!semaphore.tryAcquire(4L, timeUnit)) {
                    AbstractC2768z.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                    return false;
                }
                try {
                    f1456B.openCamera(m820b(context)[i], this.f1483x, this.f1463d);
                    try {
                    } catch (InterruptedException e) {
                        AbstractC2768z.Log(6, "Camera2: Interrupted while waiting to open camera " + e);
                    }
                    if (!f1458D.tryAcquire(4L, timeUnit)) {
                        AbstractC2768z.Log(5, "Camera2: Timeout waiting to open camera.");
                        return false;
                    }
                    f1458D.release();
                    this.f1479t = i5;
                    this.f1481v = surface;
                    int intValue3 = ((Integer) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
                    this.f1467h = intValue3;
                    if (intValue3 > 0) {
                        this.f1465f = (Rect) cameraCharacteristics3.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        float width2 = this.f1464e.width() / this.f1464e.height();
                        if (width2 > r0.width() / this.f1465f.height()) {
                            this.f1470k = 0;
                            this.f1471l = (int) ((this.f1465f.height() - (this.f1465f.width() / width2)) / 2.0f);
                        } else {
                            this.f1471l = 0;
                            this.f1470k = (int) ((this.f1465f.width() - (this.f1465f.height() * width2)) / 2.0f);
                        }
                        this.f1466g = Math.min(this.f1465f.width(), this.f1465f.height()) / 20;
                    }
                    return this.f1461b != null;
                } catch (CameraAccessException e2) {
                    AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e2);
                    f1458D.release();
                    return false;
                }
            } catch (InterruptedException e3) {
                AbstractC2768z.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e3);
                return false;
            }
        } catch (CameraAccessException e4) {
            AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e4);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final Rect m831c() {
        return this.f1464e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final void m832d() {
        synchronized (this.f1478s) {
            CameraCaptureSession cameraCaptureSession = this.f1477r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.stopRepeating();
                    this.f1459A = 2;
                } catch (CameraAccessException e) {
                    AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: h */
    public void m833h() {
        Surface surface;
        if (this.f1479t != 0) {
            if (this.f1481v == null) {
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.f1479t);
                this.f1480u = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(this.f1464e.width(), this.f1464e.height());
                this.f1480u.setOnFrameAvailableListener(this.f1485z, this.f1463d);
                surface = new Surface(this.f1480u);
                this.f1481v = surface;
            }
        } else if (this.f1481v == null && this.f1474o == null) {
            ImageReader newInstance = ImageReader.newInstance(this.f1464e.width(), this.f1464e.height(), 35, 2);
            this.f1474o = newInstance;
            newInstance.setOnImageAvailableListener(this.f1484y, this.f1463d);
            this.f1475p = null;
            surface = this.f1474o.getSurface();
            this.f1481v = surface;
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.f1477r;
            if (cameraCaptureSession == null) {
                this.f1461b.createCaptureSession(Arrays.asList(this.f1481v), new C2754s(this), this.f1463d);
            } else if (this.f1459A == 2) {
                cameraCaptureSession.setRepeatingRequest(this.f1476q.build(), this.f1482w, this.f1463d);
            }
            this.f1459A = 1;
        } catch (CameraAccessException e) {
            AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public final void m834i() {
        synchronized (this.f1478s) {
            CameraCaptureSession cameraCaptureSession = this.f1477r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.abortCaptures();
                } catch (CameraAccessException e) {
                    AbstractC2768z.Log(6, "Camera2: CameraAccessException " + e);
                }
                this.f1477r.close();
                this.f1477r = null;
                this.f1459A = 3;
            }
        }
    }
}
