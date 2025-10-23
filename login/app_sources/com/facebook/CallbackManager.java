package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.kakaogame.server.ServerConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallbackManager.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0002\t\nJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\u000b"}, m839d2 = {"Lcom/facebook/CallbackManager;", "", "onActivityResult", "", "requestCode", "", ServerConstants.TRACE_RESULT_CODE, "data", "Landroid/content/Intent;", "ActivityResultParameters", "Factory", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public interface CallbackManager {
    boolean onActivityResult(int requestCode, int resultCode, Intent data);

    /* compiled from: CallbackManager.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, m839d2 = {"Lcom/facebook/CallbackManager$Factory;", "", "()V", "create", "Lcom/facebook/CallbackManager;", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final class Factory {
        public static final Factory INSTANCE = new Factory();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Factory() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static final CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }

    /* compiled from: CallbackManager.kt */
    @Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m839d2 = {"Lcom/facebook/CallbackManager$ActivityResultParameters;", "", "requestCode", "", ServerConstants.TRACE_RESULT_CODE, "data", "Landroid/content/Intent;", "(IILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "getRequestCode", "()I", "getResultCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public static final /* data */ class ActivityResultParameters {
        private final Intent data;
        private final int requestCode;
        private final int resultCode;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ ActivityResultParameters copy$default(ActivityResultParameters activityResultParameters, int i, int i2, Intent intent, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = activityResultParameters.requestCode;
            }
            if ((i3 & 2) != 0) {
                i2 = activityResultParameters.resultCode;
            }
            if ((i3 & 4) != 0) {
                intent = activityResultParameters.data;
            }
            return activityResultParameters.copy(i, i2, intent);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int component1() {
            return this.requestCode;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int component2() {
            return this.resultCode;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Intent component3() {
            return this.data;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final ActivityResultParameters copy(int requestCode, int resultCode, Intent data) {
            return new ActivityResultParameters(requestCode, resultCode, data);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActivityResultParameters)) {
                return false;
            }
            ActivityResultParameters activityResultParameters = (ActivityResultParameters) other;
            return this.requestCode == activityResultParameters.requestCode && this.resultCode == activityResultParameters.resultCode && Intrinsics.areEqual(this.data, activityResultParameters.data);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.requestCode) * 31) + Integer.hashCode(this.resultCode)) * 31;
            Intent intent = this.data;
            return hashCode + (intent == null ? 0 : intent.hashCode());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "ActivityResultParameters(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + ')';
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ActivityResultParameters(int i, int i2, Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.data = intent;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Intent getData() {
            return this.data;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getRequestCode() {
            return this.requestCode;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getResultCode() {
            return this.resultCode;
        }
    }
}
