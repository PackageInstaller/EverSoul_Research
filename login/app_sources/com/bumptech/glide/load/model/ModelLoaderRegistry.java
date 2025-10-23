package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ModelLoaderRegistry {
    private final ModelLoaderCache cache;
    private final MultiModelLoaderFactory multiModelLoaderFactory;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ModelLoaderRegistry(Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.cache = new ModelLoaderCache();
        this.multiModelLoaderFactory = multiModelLoaderFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <Model, Data> void append(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.multiModelLoaderFactory.append(cls, cls2, modelLoaderFactory);
        this.cache.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <Model, Data> void prepend(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.multiModelLoaderFactory.prepend(cls, cls2, modelLoaderFactory);
        this.cache.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <Model, Data> void remove(Class<Model> cls, Class<Data> cls2) {
        tearDown(this.multiModelLoaderFactory.remove(cls, cls2));
        this.cache.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <Model, Data> void replace(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        tearDown(this.multiModelLoaderFactory.replace(cls, cls2, modelLoaderFactory));
        this.cache.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <Model, Data> void tearDown(List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        Iterator<ModelLoaderFactory<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next().teardown();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <A> List<ModelLoader<A, ?>> getModelLoaders(A a2) {
        List<ModelLoader<A, ?>> modelLoadersForClass = getModelLoadersForClass(getClass(a2));
        int size = modelLoadersForClass.size();
        List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            ModelLoader<A, ?> modelLoader = modelLoadersForClass.get(i);
            if (modelLoader.handles(a2)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(modelLoader);
            }
        }
        return emptyList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized <Model, Data> ModelLoader<Model, Data> build(Class<Model> cls, Class<Data> cls2) {
        return this.multiModelLoaderFactory.build(cls, cls2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized List<Class<?>> getDataClasses(Class<?> cls) {
        return this.multiModelLoaderFactory.getDataClasses(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized <A> List<ModelLoader<A, ?>> getModelLoadersForClass(Class<A> cls) {
        List<ModelLoader<A, ?>> list;
        list = this.cache.get(cls);
        if (list == null) {
            list = Collections.unmodifiableList(this.multiModelLoaderFactory.build(cls));
            this.cache.put(cls, list);
        }
        return list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <A> Class<A> getClass(A a2) {
        return (Class<A>) a2.getClass();
    }

    private static class ModelLoaderCache {
        private final Map<Class<?>, Entry<?>> cachedModelLoaders = new HashMap();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ModelLoaderCache() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void clear() {
            this.cachedModelLoaders.clear();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public <Model> void put(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.cachedModelLoaders.put(cls, new Entry<>(list)) != null) {
                throw new IllegalStateException(y.ٲٴݴ״ٰ(1781730000) + cls);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public <Model> List<ModelLoader<Model, ?>> get(Class<Model> cls) {
            Entry<?> entry = this.cachedModelLoaders.get(cls);
            if (entry == null) {
                return null;
            }
            return (List<ModelLoader<Model, ?>>) entry.loaders;
        }

        private static class Entry<Model> {
            final List<ModelLoader<Model, ?>> loaders;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Entry(List<ModelLoader<Model, ?>> list) {
                this.loaders = list;
            }
        }
    }
}
