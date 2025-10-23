package com.kakaogame.session.websocket;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.kakaogame.Logger;
import com.kakaogame.game.StringSet;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

/* compiled from: HybiParser.kt */
@Metadata(m838d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\"\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\u000eJ\"\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\u0019J\"\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010 \u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010 \u001a\u00020(H\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000bH\u0002J\u000e\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m839d2 = {"Lcom/kakaogame/session/websocket/HybiParser;", "", "mClient", "Lcom/kakaogame/session/websocket/WebSocketClient;", "(Lcom/kakaogame/session/websocket/WebSocketClient;)V", "mBuffer", "Ljava/io/ByteArrayOutputStream;", "mClosed", "", "mFinal", "mLength", "", "mLengthSize", "mMask", "", "mMasked", "mMasking", "mMode", "mOpcode", "mPayload", "mStage", "close", "", "code", "reason", "", "decode", TypedValues.Custom.S_STRING, "emitFrame", "encode", "buffer", TypedValues.AttributesType.S_FRAME, "data", "opcode", "errorCode", "framePing", "getInteger", "bytes", "parseExtendedLength", "parseLength", "", "parseOpcode", Base2ndPWViewData.KEY_RESET, "slice", "array", "start", "stream", "Lcom/kakaogame/session/websocket/HybiParser$HappyDataInputStream;", "Companion", "HappyDataInputStream", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class HybiParser {
    private static final int BYTE = 255;
    private static final int FIN = 128;
    private static final int LENGTH = 127;
    private static final int MASK = 128;
    private static final int MODE_BINARY = 2;
    private static final int MODE_TEXT = 1;
    private static final int OPCODE = 15;
    private static final int OP_BINARY = 2;
    private static final int OP_CLOSE = 8;
    private static final int OP_CONTINUATION = 0;
    private static final int OP_PING = 9;
    private static final int OP_PONG = 10;
    private static final int OP_TEXT = 1;
    private static final int RSV1 = 64;
    private static final int RSV2 = 32;
    private static final int RSV3 = 16;
    private static final String TAG = "HybiParser";
    private final ByteArrayOutputStream mBuffer;
    private final WebSocketClient mClient;
    private boolean mClosed;
    private boolean mFinal;
    private int mLength;
    private int mLengthSize;
    private byte[] mMask;
    private boolean mMasked;
    private final boolean mMasking;
    private int mMode;
    private int mOpcode;
    private byte[] mPayload;
    private int mStage;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Integer> OPCODES = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2, 8, 9, 10});
    private static final List<Integer> FRAGMENTED_OPCODES = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2});

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HybiParser(WebSocketClient webSocketClient) {
        Intrinsics.checkNotNullParameter(webSocketClient, y.֬ڱܱײٮ(-1159104159));
        this.mClient = webSocketClient;
        this.mMasking = true;
        this.mMask = new byte[0];
        this.mPayload = new byte[0];
        this.mBuffer = new ByteArrayOutputStream();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void start(HappyDataInputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, y.دײܮڳܯ(2051030045));
        while (stream.available() != -1) {
            int i = this.mStage;
            if (i == 0) {
                parseOpcode(stream.readByte());
            } else if (i == 1) {
                parseLength(stream.readByte());
            } else if (i == 2) {
                parseExtendedLength(stream.readBytes(this.mLengthSize));
            } else if (i == 3) {
                this.mMask = stream.readBytes(4);
                this.mStage = 4;
            } else if (i == 4) {
                this.mPayload = stream.readBytes(this.mLength);
                emitFrame();
                this.mStage = 0;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void parseOpcode(byte data) throws ProtocolException {
        boolean z = (data & SignedBytes.MAX_POWER_OF_TWO) == 64;
        boolean z2 = (data & 32) == 32;
        boolean z3 = (data & Ascii.DLE) == 16;
        if (z || z2 || z3) {
            throw new ProtocolException(y.ٲٴݴ״ٰ(1782325928));
        }
        this.mFinal = (data & 128) == 128;
        int i = data & Ascii.f345SI;
        this.mOpcode = i;
        this.mMask = new byte[0];
        this.mPayload = new byte[0];
        if (!OPCODES.contains(Integer.valueOf(i))) {
            throw new ProtocolException(y.دײܮڳܯ(2051030829));
        }
        if (!FRAGMENTED_OPCODES.contains(Integer.valueOf(this.mOpcode)) && !this.mFinal) {
            throw new ProtocolException(y.ٴسسݬߨ(1393114330));
        }
        this.mStage = 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void parseLength(byte data) {
        boolean z = (data & 128) == 128;
        this.mMasked = z;
        int i = data & Byte.MAX_VALUE;
        this.mLength = i;
        if (i >= 0 && i <= 125) {
            this.mStage = z ? 3 : 4;
        } else {
            this.mLengthSize = i == 126 ? 2 : 8;
            this.mStage = 2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void parseExtendedLength(byte[] buffer) throws ProtocolException {
        this.mLength = getInteger(buffer);
        this.mStage = this.mMasked ? 3 : 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] frame(String data) {
        Intrinsics.checkNotNullParameter(data, y.دײܮڳܯ(2051550101));
        return frame(data, 1, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] frame(byte[] data) {
        Intrinsics.checkNotNullParameter(data, y.دײܮڳܯ(2051550101));
        return frame(data, 2, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] framePing() {
        return frame("", 9, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] frame(byte[] data, int opcode, int errorCode) {
        Intrinsics.checkNotNull(data, y.دײܮڳܯ(2051023093));
        return frame((Object) data, opcode, errorCode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] frame(String data, int opcode, int errorCode) {
        Intrinsics.checkNotNull(data, y.دײܮڳܯ(2051023093));
        return frame((Object) data, opcode, errorCode);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015f  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final byte[] frame(java.lang.Object r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.session.websocket.HybiParser.frame(java.lang.Object, int, int):byte[]");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void close(int code, String reason) {
        Intrinsics.checkNotNullParameter(reason, y.֬ڱܱײٮ(-1159109871));
        if (this.mClosed) {
            return;
        }
        this.mClient.send(frame(reason, 8, code));
        this.mClosed = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void emitFrame() throws IOException {
        byte[] mask = INSTANCE.mask(this.mPayload, this.mMask, 0);
        int i = this.mOpcode;
        if (i == 0) {
            if (this.mMode == 0) {
                throw new ProtocolException(y.ۮڭڭܬި(862801427));
            }
            this.mBuffer.write(mask);
            if (this.mFinal) {
                byte[] byteArray = this.mBuffer.toByteArray();
                if (this.mMode == 1) {
                    WebSocketClient webSocketClient = this.mClient;
                    Intrinsics.checkNotNull(byteArray);
                    webSocketClient.onMessage(encode(byteArray));
                } else {
                    this.mClient.onMessage(byteArray);
                }
                reset();
                return;
            }
            return;
        }
        if (i == 1) {
            if (this.mFinal) {
                this.mClient.onMessage(encode(mask));
                return;
            } else {
                this.mMode = 1;
                this.mBuffer.write(mask);
                return;
            }
        }
        if (i == 2) {
            if (this.mFinal) {
                this.mClient.onMessage(mask);
                return;
            } else {
                this.mMode = 2;
                this.mBuffer.write(mask);
                return;
            }
        }
        String str = y.ٴسسݬߨ(1393108218);
        switch (i) {
            case 8:
                Logger.INSTANCE.m699d(str, y.ݮڮֲڭܩ(-628288780) + (mask.length >= 2 ? (mask[0] * 256) + mask[1] : 0) + ' ' + (mask.length > 2 ? encode(slice(mask, 2)) : null));
                this.mClient.disconnect();
                return;
            case 9:
                if (mask.length > 125) {
                    throw new ProtocolException(y.ۮڭڭܬި(862801107));
                }
                Logger.INSTANCE.m699d(str, y.ٴسسݬߨ(1393108282));
                this.mClient.sendFrame(frame(mask, 10, -1));
                return;
            case 10:
                Logger.INSTANCE.m699d(str, y.ٲٴݴ״ٰ(1782331920) + encode(mask));
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void reset() {
        this.mMode = 0;
        this.mBuffer.reset();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String encode(byte[] buffer) {
        try {
            return new String(buffer, Charsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] decode(String string) {
        try {
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = string.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int getInteger(byte[] bytes) throws ProtocolException {
        long byteArrayToLong = INSTANCE.byteArrayToLong(bytes, 0, bytes.length);
        if (byteArrayToLong < 0 || byteArrayToLong > 2147483647L) {
            throw new ProtocolException(y.ݬֲ֮ܲت(1512052631) + byteArrayToLong);
        }
        return (int) byteArrayToLong;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] slice(byte[] array, int start) {
        return INSTANCE.copyOfRange(array, start, array.length);
    }

    /* compiled from: HybiParser.kt */
    @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/session/websocket/HybiParser$HappyDataInputStream;", "Ljava/io/DataInputStream;", "in", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readBytes", "", "length", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class HappyDataInputStream extends DataInputStream {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public HappyDataInputStream(InputStream inputStream) {
            super(inputStream);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final byte[] readBytes(int length) throws IOException {
            byte[] bArr = new byte[length];
            int i = 0;
            while (i < length) {
                int read = read(bArr, i, length - i);
                if (read == -1) {
                    break;
                }
                i += read;
            }
            if (i == length) {
                return bArr;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(y.٬ݯح׭٩(576384566), Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(length)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, y.٬ݯح׭٩(576384918));
            throw new IOException(format);
        }
    }

    /* compiled from: HybiParser.kt */
    @Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J \u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J \u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, m839d2 = {"Lcom/kakaogame/session/websocket/HybiParser$Companion;", "", "()V", "BYTE", "", "FIN", "FRAGMENTED_OPCODES", "", "LENGTH", "MASK", "MODE_BINARY", "MODE_TEXT", "OPCODE", "OPCODES", "OP_BINARY", "OP_CLOSE", "OP_CONTINUATION", "OP_PING", "OP_PONG", "OP_TEXT", "RSV1", "RSV2", "RSV3", "TAG", "", "byteArrayToLong", "", "b", "", "offset", "length", "copyOfRange", StringSet.original, "start", "end", "mask", "payload", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final byte[] mask(byte[] payload, byte[] mask, int offset) {
            if (mask.length == 0) {
                return payload;
            }
            int length = payload.length - offset;
            for (int i = 0; i < length; i++) {
                int i2 = offset + i;
                payload[i2] = (byte) (payload[i2] ^ mask[i % 4]);
            }
            return payload;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final byte[] copyOfRange(byte[] original, int start, int end) {
            if (!(start <= end)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int length = original.length;
            if (start < 0 || start > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i = end - start;
            int min = Math.min(i, length - start);
            byte[] bArr = new byte[i];
            System.arraycopy(original, start, bArr, 0, min);
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long byteArrayToLong(byte[] b, int offset, int length) {
            if (!(b.length >= length)) {
                throw new IllegalArgumentException("length must be less than or equal to b.length".toString());
            }
            long j = 0;
            for (int i = 0; i < length; i++) {
                j += (b[i + offset] & 255) << (((length - 1) - i) * 8);
            }
            return j;
        }
    }
}
