package androidx.lifecycle;

import androidx.arch.core.util.Function;

/* loaded from: classes.dex */
public class Transformations {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Transformations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <X, Y> LiveData<Y> map(LiveData<X> liveData, final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                MediatorLiveData.this.setValue(function.apply(x));
            }
        });
        return mediatorLiveData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final Function<X, LiveData<Y>> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2
            LiveData<Y> mSource;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                LiveData<Y> liveData2 = (LiveData) Function.this.apply(x);
                Object obj = this.mSource;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    mediatorLiveData.removeSource(obj);
                }
                this.mSource = liveData2;
                if (liveData2 != 0) {
                    mediatorLiveData.addSource(liveData2, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // androidx.lifecycle.Observer
                        public void onChanged(Y y) {
                            mediatorLiveData.setValue(y);
                        }
                    });
                }
            }
        });
        return mediatorLiveData;
    }
}
