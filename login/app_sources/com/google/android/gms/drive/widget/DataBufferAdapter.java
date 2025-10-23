package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DataBufferAdapter<T> extends BaseAdapter {
    private static final GmsLogger zzbz = new GmsLogger("DataBufferAdapter", "");
    private final int fieldId;
    private final int resource;
    private final Context zzgw;
    private int zzmz;
    private final List<DataBuffer<T>> zzna;
    private final LayoutInflater zznb;
    private boolean zznc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DataBufferAdapter(Context context, int i, int i2, List<DataBuffer<T>> list) {
        this.zznc = true;
        this.zzgw = context;
        this.zzmz = i;
        this.resource = i;
        this.fieldId = i2;
        this.zzna = list;
        this.zznb = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DataBufferAdapter(Context context, int i, int i2) {
        this(context, i, i2, new ArrayList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DataBufferAdapter(Context context, int i, List<DataBuffer<T>> list) {
        this(context, i, 0, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DataBufferAdapter(Context context, int i) {
        this(context, i, 0, new ArrayList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DataBufferAdapter(Context context, int i, int i2, DataBuffer<T>... dataBufferArr) {
        this(context, i, i2, Arrays.asList(dataBufferArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DataBufferAdapter(Context context, int i, DataBuffer<T>... dataBufferArr) {
        this(context, i, 0, Arrays.asList(dataBufferArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void append(DataBuffer<T> dataBuffer) {
        this.zzna.add(dataBuffer);
        if (this.zznc) {
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        Iterator<DataBuffer<T>> it = this.zzna.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.zzna.clear();
        if (this.zznc) {
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zznc = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNotifyOnChange(boolean z) {
        this.zznc = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Context getContext() {
        return this.zzgw;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public int getCount() {
        Iterator<DataBuffer<T>> it = this.zzna.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().getCount();
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public T getItem(int i) throws CursorIndexOutOfBoundsException {
        int i2 = i;
        for (DataBuffer<T> dataBuffer : this.zzna) {
            int count = dataBuffer.getCount();
            if (count > i2) {
                try {
                    return dataBuffer.get(i2);
                } catch (CursorIndexOutOfBoundsException unused) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
            i2 -= count;
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final View zza(int i, View view, ViewGroup viewGroup, int i2) {
        TextView textView;
        if (view == null) {
            view = this.zznb.inflate(i2, viewGroup, false);
        }
        try {
            int i3 = this.fieldId;
            if (i3 == 0) {
                textView = (TextView) view;
            } else {
                textView = (TextView) view.findViewById(i3);
            }
            T item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return view;
        } catch (ClassCastException e) {
            zzbz.m146e("DataBufferAdapter", "You must supply a resource ID for a TextView", e);
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.resource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzmz);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDropDownViewResource(int i) {
        this.zzmz = i;
    }
}
