package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.mStringConversionColumn = -1;
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.mStringConversionColumn = -1;
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.mViewBinder;
        int[] iArr = this.mTo;
        int length = iArr.length;
        int[] iArr2 = this.mFrom;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr[i]);
            if (findViewById != null) {
                if (viewBinder != null ? viewBinder.setViewValue(findViewById, cursor, iArr2[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        setViewImage((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStringConversionColumn(int i) {
        this.mStringConversionColumn = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.mCursorToStringConverter = cursorToStringConverter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.mCursorToStringConverter;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i = this.mStringConversionColumn;
        if (i > -1) {
            return cursor.getString(i);
        }
        return super.convertToString(cursor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void findColumns(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.mFrom;
            if (iArr == null || iArr.length != length) {
                this.mFrom = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.mFrom[i] = cursor.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.mFrom = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        findColumns(cursor, this.mOriginalFrom);
        return super.swapCursor(cursor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        this.mOriginalFrom = strArr;
        this.mTo = iArr;
        findColumns(cursor, strArr);
        super.changeCursor(cursor);
    }
}
