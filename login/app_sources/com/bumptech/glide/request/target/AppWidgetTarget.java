package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public class AppWidgetTarget extends CustomTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, int... iArr) {
        super(i, i2);
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.context = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.widgetIds = (int[]) Preconditions.checkNotNull(iArr, "WidgetIds can not be null!");
        this.viewId = i3;
        this.componentName = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, iArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, ComponentName componentName) {
        super(i, i2);
        this.context = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.componentName = (ComponentName) Preconditions.checkNotNull(componentName, "ComponentName can not be null!");
        this.viewId = i3;
        this.widgetIds = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, componentName);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
        ComponentName componentName = this.componentName;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        setBitmap(bitmap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        setBitmap(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setBitmap(Bitmap bitmap) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }
}
