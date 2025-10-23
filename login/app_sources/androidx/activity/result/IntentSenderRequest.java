package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() { // from class: androidx.activity.result.IntentSenderRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest[] newArray(int i) {
            return new IntentSenderRequest[i];
        }
    };
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    private final IntentSender mIntentSender;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    IntentSenderRequest(IntentSender intentSender, Intent intent, int i, int i2) {
        this.mIntentSender = intentSender;
        this.mFillInIntent = intent;
        this.mFlagsMask = i;
        this.mFlagsValues = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    IntentSenderRequest(Parcel parcel) {
        this.mIntentSender = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.mFillInIntent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.mFlagsMask = parcel.readInt();
        this.mFlagsValues = parcel.readInt();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mIntentSender, i);
        parcel.writeParcelable(this.mFillInIntent, i);
        parcel.writeInt(this.mFlagsMask);
        parcel.writeInt(this.mFlagsValues);
    }

    public static final class Builder {
        private Intent mFillInIntent;
        private int mFlagsMask;
        private int mFlagsValues;
        private IntentSender mIntentSender;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(IntentSender intentSender) {
            this.mIntentSender = intentSender;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(PendingIntent pendingIntent) {
            this(pendingIntent.getIntentSender());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setFillInIntent(Intent intent) {
            this.mFillInIntent = intent;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setFlags(int i, int i2) {
            this.mFlagsValues = i;
            this.mFlagsMask = i2;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
        }
    }
}
