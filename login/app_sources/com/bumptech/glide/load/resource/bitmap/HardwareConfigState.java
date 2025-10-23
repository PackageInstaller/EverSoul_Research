package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.liapp.y;
import java.io.File;

/* loaded from: classes.dex */
public final class HardwareConfigState {
    public static final int DEFAULT_MAXIMUM_FDS_FOR_HARDWARE_CONFIGS = 700;
    public static final int DEFAULT_MIN_HARDWARE_DIMENSION = 128;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    private static volatile HardwareConfigState instance;
    private int decodesSinceLastFdCheck;
    private boolean isFdSizeBelowHardwareLimit = true;
    private final boolean isHardwareConfigAllowedByDeviceModel = isHardwareConfigAllowedByDeviceModel();
    private static final File FD_SIZE_LIST = new File(y.ٴسسݬߨ(1393011306));
    private static volatile int fdSizeLimit = 700;
    private static volatile int minHardwareDimension = 128;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                if (instance == null) {
                    instance = new HardwareConfigState();
                }
            }
        }
        return instance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HardwareConfigState() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        return z && this.isHardwareConfigAllowedByDeviceModel && Build.VERSION.SDK_INT >= 26 && !z2 && i >= minHardwareDimension && i2 >= minHardwareDimension && isFdSizeBelowHardwareLimit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean setHardwareConfigIfAllowed(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean isHardwareConfigAllowed = isHardwareConfigAllowed(i, i2, z, z2);
        if (isHardwareConfigAllowed) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return isHardwareConfigAllowed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isHardwareConfigAllowedByDeviceModel() {
        if (Build.MODEL == null || Build.MODEL.length() < 7) {
            return true;
        }
        String substring = Build.MODEL.substring(0, 7);
        substring.hashCode();
        char c = 65535;
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals(y.ݬֲ֮ܲت(1513000183))) {
                    c = 0;
                    break;
                }
                break;
            case -1398431166:
                if (substring.equals(y.ۮڭڭܬި(862178835))) {
                    c = 1;
                    break;
                }
                break;
            case -1398431161:
                if (substring.equals(y.دײܮڳܯ(2051974317))) {
                    c = 2;
                    break;
                }
                break;
            case -1398431073:
                if (substring.equals(y.ݬֲ֮ܲت(1513000207))) {
                    c = 3;
                    break;
                }
                break;
            case -1398431068:
                if (substring.equals(y.ٴسسݬߨ(1393010194))) {
                    c = 4;
                    break;
                }
                break;
            case -1398343746:
                if (substring.equals(y.ٴسسݬߨ(1393010266))) {
                    c = 5;
                    break;
                }
                break;
            case -1398222624:
                if (substring.equals(y.دײܮڳܯ(2051975117))) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return Build.VERSION.SDK_INT != 26;
            default:
                return true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean isFdSizeBelowHardwareLimit() {
        boolean z;
        String str = y.ٴسسݬߨ(1393011442);
        synchronized (this) {
            boolean z2 = true;
            int i = this.decodesSinceLastFdCheck + 1;
            this.decodesSinceLastFdCheck = i;
            if (i >= 50) {
                this.decodesSinceLastFdCheck = 0;
                int length = FD_SIZE_LIST.list().length;
                if (length >= fdSizeLimit) {
                    z2 = false;
                }
                this.isFdSizeBelowHardwareLimit = z2;
                if (!z2 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", str + length + ", limit " + fdSizeLimit);
                }
            }
            z = this.isFdSizeBelowHardwareLimit;
        }
        return z;
    }
}
