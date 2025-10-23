package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.C0211R;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int BOOLEAN_PROPERTY_HAS_REQUEST_INITIAL_ACCESSIBILITY_FOCUS = 32;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    private static final String MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;
    public int mParentVirtualDescendantId = -1;
    private int mVirtualDescendantId = -1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getActionSymbolicName(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void recycle() {
    }

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL;
        public static final AccessibilityActionCompat ACTION_DRAG_DROP;
        public static final AccessibilityActionCompat ACTION_DRAG_START;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
        public static final AccessibilityActionCompat ACTION_IME_ENTER;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN;
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT;
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;
        public static final AccessibilityActionCompat ACTION_PAGE_UP;
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, null);
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, null);
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, null);
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetTextArguments.class);
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
        public static final AccessibilityActionCompat ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            ACTION_PAGE_UP = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            ACTION_IME_ENTER = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            ACTION_DRAG_START = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            ACTION_DRAG_DROP = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AccessibilityActionCompat(int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i, charSequence, accessibilityViewCommand, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        AccessibilityActionCompat(Object obj) {
            this(obj, 0, null, null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AccessibilityActionCompat(int i, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this(null, i, charSequence, null, cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        AccessibilityActionCompat(Object obj, int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.mId = i;
            this.mCommand = accessibilityViewCommand;
            if (obj == null) {
                this.mAction = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.mAction = obj;
            }
            this.mViewCommandArgumentClass = cls;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean perform(View view, Bundle bundle) {
            if (this.mCommand == null) {
                return false;
            }
            Class<? extends AccessibilityViewCommand.CommandArguments> cls = this.mViewCommandArgumentClass;
            AccessibilityViewCommand.CommandArguments commandArguments = null;
            if (cls != null) {
                try {
                    AccessibilityViewCommand.CommandArguments newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        newInstance.setBundle(bundle);
                        commandArguments = newInstance;
                    } catch (Exception e) {
                        e = e;
                        commandArguments = newInstance;
                        Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = this.mViewCommandArgumentClass;
                        Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                        return this.mCommand.perform(view, commandArguments);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return this.mCommand.perform(view, commandArguments);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            Object obj = this.mAction;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.mAction;
            return obj2 == null ? accessibilityActionCompat.mAction == null : obj2.equals(accessibilityActionCompat.mAction);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
            String actionSymbolicName = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (actionSymbolicName.equals("ACTION_UNKNOWN") && getLabel() != null) {
                actionSymbolicName = getLabel().toString();
            }
            sb.append(actionSymbolicName);
            return sb.toString();
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CollectionInfoCompat obtain(int i, int i2, boolean z) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CollectionInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getColumnCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getRowCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isHierarchical() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getSelectionMode() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }
    }

    public static class CollectionItemInfoCompat {
        final Object mInfo;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CollectionItemInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getColumnIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getColumnSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getRowIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getRowSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public boolean isHeading() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isSelected() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static RangeInfoCompat obtain(int i, float f, float f2, float f3) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RangeInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }
    }

    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public TouchDelegateInfoCompat(Map<Region, View> map) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(map);
            } else {
                this.mInfo = null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.mInfo = touchDelegateInfo;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getRegionCount() {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.mInfo.getRegionCount();
            }
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Region getRegionAt(int i) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.mInfo.getRegionAt(i);
            }
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AccessibilityNodeInfoCompat getTargetForRegion(Region region) {
            AccessibilityNodeInfo targetForRegion;
            if (Build.VERSION.SDK_INT < 29 || (targetForRegion = this.mInfo.getTargetForRegion(region)) == null) {
                return null;
            }
            return AccessibilityNodeInfoCompat.wrap(targetForRegion);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.mInfo = (AccessibilityNodeInfo) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrap(AccessibilityNodeInfo.obtain(view));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccessibilityNodeInfoCompat obtain(View view, int i) {
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(view, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrap(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.mInfo));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSource(View view) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSource(View view, int i) {
        this.mVirtualDescendantId = i;
        this.mInfo.setSource(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat findFocus(int i) {
        return wrapNonNullInstance(this.mInfo.findFocus(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat focusSearch(int i) {
        return wrapNonNullInstance(this.mInfo.focusSearch(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat getChild(int i) {
        return wrapNonNullInstance(this.mInfo.getChild(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addChild(View view) {
        this.mInfo.addChild(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addChild(View view, int i) {
        this.mInfo.addChild(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean removeChild(View view) {
        return this.mInfo.removeChild(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean removeChild(View view, int i) {
        return this.mInfo.removeChild(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAction(int i) {
        this.mInfo.addAction(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private List<Integer> extrasIntList(String str) {
        ArrayList<Integer> integerArrayList = Api19Impl.getExtras(this.mInfo).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Api19Impl.getExtras(this.mInfo).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean performAction(int i) {
        return this.mInfo.performAction(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean performAction(int i, Bundle bundle) {
        return this.mInfo.performAction(i, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMovementGranularities(int i) {
        this.mInfo.setMovementGranularities(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.mInfo.findAccessibilityNodeInfosByText(str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(wrap(findAccessibilityNodeInfosByText.get(i)));
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setParent(View view) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setParent(View view, int i) {
        this.mParentVirtualDescendantId = i;
        this.mInfo.setParent(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void getBoundsInParent(Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setBoundsInParent(Rect rect) {
        this.mInfo.setBoundsInParent(rect);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getBoundsInScreen(Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBoundsInScreen(Rect rect) {
        this.mInfo.setBoundsInScreen(rect);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckable(boolean z) {
        this.mInfo.setCheckable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChecked(boolean z) {
        this.mInfo.setChecked(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFocusable(boolean z) {
        this.mInfo.setFocusable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFocused(boolean z) {
        this.mInfo.setFocused(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVisibleToUser(boolean z) {
        this.mInfo.setVisibleToUser(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAccessibilityFocused(boolean z) {
        this.mInfo.setAccessibilityFocused(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSelected(boolean z) {
        this.mInfo.setSelected(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setClickable(boolean z) {
        this.mInfo.setClickable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLongClickable(boolean z) {
        this.mInfo.setLongClickable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEnabled(boolean z) {
        this.mInfo.setEnabled(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPassword(boolean z) {
        this.mInfo.setPassword(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setScrollable(boolean z) {
        this.mInfo.setScrollable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.isTextSelectable(this.mInfo);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextSelectable(boolean z) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setTextSelectable(this.mInfo, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getMinDurationBetweenContentChangesMillis() {
        return Api19Impl.getExtras(this.mInfo).getLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMinDurationBetweenContentChangesMillis(long j) {
        Api19Impl.getExtras(this.mInfo).putLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isImportantForAccessibility() {
        return this.mInfo.isImportantForAccessibility();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setImportantForAccessibility(boolean z) {
        this.mInfo.setImportantForAccessibility(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPackageName(CharSequence charSequence) {
        this.mInfo.setPackageName(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setClassName(CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getText() {
        if (hasSpans()) {
            List<Integer> extrasIntList = extrasIntList(SPANS_START_KEY);
            List<Integer> extrasIntList2 = extrasIntList(SPANS_END_KEY);
            List<Integer> extrasIntList3 = extrasIntList(SPANS_FLAGS_KEY);
            List<Integer> extrasIntList4 = extrasIntList(SPANS_ID_KEY);
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
            for (int i = 0; i < extrasIntList.size(); i++) {
                spannableString.setSpan(new AccessibilityClickableSpanCompat(extrasIntList4.get(i).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), extrasIntList.get(i).intValue(), extrasIntList2.get(i).intValue(), extrasIntList3.get(i).intValue());
            }
            return spannableString;
        }
        return this.mInfo.getText();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setText(CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addSpansToExtras(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            clearExtrasSpans();
            removeCollectedSpans(view);
            ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
            if (clickableSpans == null || clickableSpans.length <= 0) {
                return;
            }
            getExtras().putInt(SPANS_ACTION_ID_KEY, C0211R.id.accessibility_action_clickable_span);
            SparseArray<WeakReference<ClickableSpan>> orCreateSpansFromViewTags = getOrCreateSpansFromViewTags(view);
            for (int i = 0; clickableSpans != null && i < clickableSpans.length; i++) {
                int idForClickableSpan = idForClickableSpan(clickableSpans[i], orCreateSpansFromViewTags);
                orCreateSpansFromViewTags.put(idForClickableSpan, new WeakReference<>(clickableSpans[i]));
                addSpanLocationToExtras(clickableSpans[i], (Spanned) charSequence, idForClickableSpan);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            return spansFromViewTags;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(C0211R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View view) {
        return (SparseArray) view.getTag(C0211R.id.tag_accessibility_clickable_spans);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int idForClickableSpan(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = sClickableSpanId;
        sClickableSpanId = i2 + 1;
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void clearExtrasSpans() {
        Api19Impl.getExtras(this.mInfo).remove(SPANS_START_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_END_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_FLAGS_KEY);
        Api19Impl.getExtras(this.mInfo).remove(SPANS_ID_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addSpanLocationToExtras(ClickableSpan clickableSpan, Spanned spanned, int i) {
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void removeCollectedSpans(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < spansFromViewTags.size(); i++) {
                if (spansFromViewTags.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spansFromViewTags.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getStateDescription() {
        if (BuildCompat.isAtLeastR()) {
            return this.mInfo.getStateDescription();
        }
        return Api19Impl.getExtras(this.mInfo).getCharSequence(STATE_DESCRIPTION_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContentDescription(CharSequence charSequence) {
        this.mInfo.setContentDescription(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStateDescription(CharSequence charSequence) {
        if (BuildCompat.isAtLeastR()) {
            this.mInfo.setStateDescription(charSequence);
        } else {
            Api19Impl.getExtras(this.mInfo).putCharSequence(STATE_DESCRIPTION_KEY, charSequence);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getUniqueId() {
        if (BuildCompat.isAtLeastT()) {
            return this.mInfo.getUniqueId();
        }
        return Api19Impl.getExtras(this.mInfo).getString(UNIQUE_ID_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUniqueId(String str) {
        if (BuildCompat.isAtLeastT()) {
            this.mInfo.setUniqueId(str);
        } else {
            Api19Impl.getExtras(this.mInfo).putString(UNIQUE_ID_KEY, str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setViewIdResourceName(String str) {
        this.mInfo.setViewIdResourceName(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLiveRegion(int i) {
        this.mInfo.setLiveRegion(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDrawingOrder() {
        return this.mInfo.getDrawingOrder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDrawingOrder(int i) {
        this.mInfo.setDrawingOrder(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.mInfo.getCollectionInfo();
        if (collectionInfo != null) {
            return new CollectionInfoCompat(collectionInfo);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCollectionInfo(Object obj) {
        this.mInfo.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCollectionItemInfo(Object obj) {
        this.mInfo.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.mInfo.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.mInfo.getRangeInfo();
        if (rangeInfo != null) {
            return new RangeInfoCompat(rangeInfo);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getExtraRenderingInfo(this.mInfo);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.mInfo.getActionList();
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new AccessibilityActionCompat(actionList.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContentInvalid(boolean z) {
        this.mInfo.setContentInvalid(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isContextClickable() {
        return this.mInfo.isContextClickable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContextClickable(boolean z) {
        this.mInfo.setContextClickable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getHintText() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.getHintText();
        }
        return Api19Impl.getExtras(this.mInfo).getCharSequence(HINT_TEXT_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHintText(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setHintText(charSequence);
        } else {
            Api19Impl.getExtras(this.mInfo).putCharSequence(HINT_TEXT_KEY, charSequence);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setError(CharSequence charSequence) {
        this.mInfo.setError(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getError() {
        return this.mInfo.getError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLabelFor(View view) {
        this.mInfo.setLabelFor(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLabelFor(View view, int i) {
        this.mInfo.setLabelFor(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLabeledBy(View view) {
        this.mInfo.setLabeledBy(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLabeledBy(View view, int i) {
        this.mInfo.setLabeledBy(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCanOpenPopup(boolean z) {
        this.mInfo.setCanOpenPopup(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.mInfo.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        Iterator<AccessibilityNodeInfo> it = findAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(wrap(it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle getExtras() {
        return Api19Impl.getExtras(this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getInputType() {
        return this.mInfo.getInputType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInputType(int i) {
        this.mInfo.setInputType(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<String> getAvailableExtraData() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.getAvailableExtraData();
        }
        return Collections.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAvailableExtraData(List<String> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setAvailableExtraData(list);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxTextLength(int i) {
        this.mInfo.setMaxTextLength(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextSelection(int i, int i2) {
        this.mInfo.setTextSelection(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTraversalBefore(View view) {
        this.mInfo.setTraversalBefore(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTraversalBefore(View view, int i) {
        this.mInfo.setTraversalBefore(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTraversalAfter(View view) {
        this.mInfo.setTraversalAfter(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTraversalAfter(View view, int i) {
        this.mInfo.setTraversalAfter(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDismissable(boolean z) {
        this.mInfo.setDismissable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEditable(boolean z) {
        this.mInfo.setEditable(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMultiLine(boolean z) {
        this.mInfo.setMultiLine(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getTooltipText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.getTooltipText();
        }
        return Api19Impl.getExtras(this.mInfo).getCharSequence(TOOLTIP_TEXT_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTooltipText(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setTooltipText(charSequence);
        } else {
            Api19Impl.getExtras(this.mInfo).putCharSequence(TOOLTIP_TEXT_KEY, charSequence);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPaneTitle(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setPaneTitle(charSequence);
        } else {
            Api19Impl.getExtras(this.mInfo).putCharSequence(PANE_TITLE_KEY, charSequence);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getPaneTitle() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.getPaneTitle();
        }
        return Api19Impl.getExtras(this.mInfo).getCharSequence(PANE_TITLE_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isScreenReaderFocusable() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.isScreenReaderFocusable();
        }
        return getBooleanProperty(1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setScreenReaderFocusable(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setScreenReaderFocusable(z);
        } else {
            setBooleanProperty(1, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isShowingHintText() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.isShowingHintText();
        }
        return getBooleanProperty(4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShowingHintText(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setShowingHintText(z);
        } else {
            setBooleanProperty(4, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isHeading() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.isHeading();
        }
        if (getBooleanProperty(2)) {
            return true;
        }
        CollectionItemInfoCompat collectionItemInfo = getCollectionItemInfo();
        return collectionItemInfo != null && collectionItemInfo.isHeading();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHeading(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setHeading(z);
        } else {
            setBooleanProperty(2, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isTextEntryKey() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mInfo.isTextEntryKey();
        }
        return getBooleanProperty(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextEntryKey(boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTextEntryKey(z);
        } else {
            setBooleanProperty(8, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasRequestInitialAccessibilityFocus() {
        return getBooleanProperty(32);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRequestInitialAccessibilityFocus(boolean z) {
        setBooleanProperty(32, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean refresh() {
        return this.mInfo.refresh();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getRoleDescription() {
        return Api19Impl.getExtras(this.mInfo).getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRoleDescription(CharSequence charSequence) {
        Api19Impl.getExtras(this.mInfo).putCharSequence(ROLE_DESCRIPTION_KEY, charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (Build.VERSION.SDK_INT < 29 || (touchDelegateInfo = this.mInfo.getTouchDelegateInfo()) == null) {
            return null;
        }
        return new TouchDelegateInfoCompat(touchDelegateInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTouchDelegateInfo(TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTouchDelegateInfo(touchDelegateInfoCompat.mInfo);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        return this.mVirtualDescendantId == accessibilityNodeInfoCompat.mVirtualDescendantId && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(getPackageName());
        sb.append("; className: ").append(getClassName());
        sb.append("; text: ").append(getText());
        sb.append("; contentDescription: ").append(getContentDescription());
        sb.append("; viewId: ").append(getViewIdResourceName());
        sb.append("; uniqueId: ").append(getUniqueId());
        sb.append("; checkable: ").append(isCheckable());
        sb.append("; checked: ").append(isChecked());
        sb.append("; focusable: ").append(isFocusable());
        sb.append("; focused: ").append(isFocused());
        sb.append("; selected: ").append(isSelected());
        sb.append("; clickable: ").append(isClickable());
        sb.append("; longClickable: ").append(isLongClickable());
        sb.append("; enabled: ").append(isEnabled());
        sb.append("; password: ").append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        List<AccessibilityActionCompat> actionList = getActionList();
        for (int i = 0; i < actionList.size(); i++) {
            AccessibilityActionCompat accessibilityActionCompat = actionList.get(i);
            String actionSymbolicName = getActionSymbolicName(accessibilityActionCompat.getId());
            if (actionSymbolicName.equals("ACTION_UNKNOWN") && accessibilityActionCompat.getLabel() != null) {
                actionSymbolicName = accessibilityActionCompat.getLabel().toString();
            }
            sb.append(actionSymbolicName);
            if (i != actionList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setBooleanProperty(int i, boolean z) {
        Bundle extras = getExtras();
        if (extras != null) {
            int i2 = extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~i);
            if (!z) {
                i = 0;
            }
            extras.putInt(BOOLEAN_PROPERTY_KEY, i | i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean getBooleanProperty(int i) {
        Bundle extras = getExtras();
        return extras != null && (extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & i) == i;
    }

    private static class Api33Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api33Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static boolean isTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setTextSelectable(z);
        }
    }

    private static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Bundle getExtras(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }
}
