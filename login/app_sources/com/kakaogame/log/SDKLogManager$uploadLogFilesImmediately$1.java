package com.kakaogame.log;

import android.content.Context;
import android.util.Log;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.util.DeviceUtil;
import com.liapp.y;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SDKLogManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.log.SDKLogManager$uploadLogFilesImmediately$1", m855f = "SDKLogManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class SDKLogManager$uploadLogFilesImmediately$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ SDKLogManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SDKLogManager$uploadLogFilesImmediately$1(SDKLogManager sDKLogManager, Context context, Continuation<? super SDKLogManager$uploadLogFilesImmediately$1> continuation) {
        super(2, continuation);
        this.this$0 = sDKLogManager;
        this.$context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SDKLogManager$uploadLogFilesImmediately$1(this.this$0, this.$context, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SDKLogManager$uploadLogFilesImmediately$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int uploadFile;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        try {
            this.this$0.setIsUpload(true);
            File file = new File(this.$context.getFilesDir().getAbsolutePath() + File.separator + "KGLog");
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                Arrays.sort(listFiles);
                Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
                StringBuilder sb = new StringBuilder();
                String upperCase = configuration.getServerTypeValue().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String sb2 = sb.append(upperCase).append('-').append(configuration.getAppId()).append(File.separator).append(CoreManager.INSTANCE.getInstance().getPlayerId()).append(File.separator).append(DeviceUtil.getDeviceId(this.$context)).toString();
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    String name = listFiles[i].getName();
                    SDKLogManager sDKLogManager = this.this$0;
                    Context context = this.$context;
                    Intrinsics.checkNotNull(name);
                    uploadFile = sDKLogManager.uploadFile(context, sb2, name);
                    if (uploadFile == 200) {
                        listFiles[i].delete();
                    }
                }
                this.this$0.setNewFileName();
                this.this$0.completeSendFilesImmediately();
            }
        } catch (Exception e) {
            Log.e(y.֬ڱܱײٮ(-1158702039), y.֬ڱܱײٮ(-1158701903) + e);
        }
        this.this$0.setIsUpload(false);
        return Unit.INSTANCE;
    }
}
