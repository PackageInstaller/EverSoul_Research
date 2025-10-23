package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes5.dex */
public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Scene getSceneForLayout(ViewGroup viewGroup, int i, Context context) {
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(C0632R.id.transition_scene_layoutid_cache);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(C0632R.id.transition_scene_layoutid_cache, sparseArray);
        }
        Scene scene = (Scene) sparseArray.get(i);
        if (scene != null) {
            return scene;
        }
        Scene scene2 = new Scene(viewGroup, i, context);
        sparseArray.put(i, scene2);
        return scene2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Scene(ViewGroup viewGroup) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Scene(ViewGroup viewGroup, int i, Context context) {
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Scene(ViewGroup viewGroup, View view) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
        this.mLayout = view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void exit() {
        Runnable runnable;
        if (getCurrentScene(this.mSceneRoot) != this || (runnable = this.mExitAction) == null) {
            return;
        }
        runnable.run();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void enter() {
        if (this.mLayoutId > 0 || this.mLayout != null) {
            getSceneRoot().removeAllViews();
            if (this.mLayoutId > 0) {
                LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
            } else {
                this.mSceneRoot.addView(this.mLayout);
            }
        }
        Runnable runnable = this.mEnterAction;
        if (runnable != null) {
            runnable.run();
        }
        setCurrentScene(this.mSceneRoot, this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void setCurrentScene(ViewGroup viewGroup, Scene scene) {
        viewGroup.setTag(C0632R.id.transition_current_scene, scene);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Scene getCurrentScene(ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(C0632R.id.transition_current_scene);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEnterAction(Runnable runnable) {
        this.mEnterAction = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setExitAction(Runnable runnable) {
        this.mExitAction = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isCreatedFromLayoutResource() {
        return this.mLayoutId > 0;
    }
}
