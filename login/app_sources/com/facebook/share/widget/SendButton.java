package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.C0830R;

/* loaded from: classes.dex */
public final class SendButton extends ShareButtonBase {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SendButton(final Context context) {
        super(context, null, 0, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SendButton(final Context context, final AttributeSet attrs) {
        super(context, attrs, 0, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SendButton(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr, AnalyticsEvents.EVENT_SEND_BUTTON_CREATE, AnalyticsEvents.EVENT_SEND_BUTTON_DID_TAP);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultStyleResource() {
        return C0830R.style.com_facebook_button_send;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.share.widget.ShareButtonBase
    protected ShareDialog getDialog() {
        MessageDialog messageDialog;
        if (getFragment() != null) {
            messageDialog = new MessageDialog(getFragment(), getRequestCode());
        } else if (getNativeFragment() != null) {
            messageDialog = new MessageDialog(getNativeFragment(), getRequestCode());
        } else {
            messageDialog = new MessageDialog(getActivity(), getRequestCode());
        }
        messageDialog.setCallbackManager(getCallbackManager());
        return messageDialog;
    }
}
