package org.apache.commons.lang3.event;

import com.liapp.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class EventListenerSupport<L> implements Serializable {
    private static final long serialVersionUID = 3593265990380473632L;
    private List<L> listeners;
    private transient L[] prototypeArray;
    private transient L proxy;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> EventListenerSupport<T> create(Class<T> cls) {
        return new EventListenerSupport<>(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventListenerSupport(Class<L> cls) {
        this(cls, Thread.currentThread().getContextClassLoader());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventListenerSupport(Class<L> cls, ClassLoader classLoader) {
        this();
        Validate.notNull(cls, y.ݬֲ֮ܲت(1512688527), new Object[0]);
        Validate.notNull(classLoader, y.٬ݯح׭٩(575874310), new Object[0]);
        Validate.isTrue(cls.isInterface(), y.ٲٴݴ״ٰ(1781923080), cls.getName());
        initializeTransientFields(cls, classLoader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private EventListenerSupport() {
        this.listeners = new CopyOnWriteArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public L fire() {
        return this.proxy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addListener(L l) {
        addListener(l, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addListener(L l, boolean z) {
        Validate.notNull(l, y.ٲٴݴ״ٰ(1781922816), new Object[0]);
        if (z) {
            this.listeners.add(l);
        } else {
            if (this.listeners.contains(l)) {
                return;
            }
            this.listeners.add(l);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getListenerCount() {
        return this.listeners.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeListener(L l) {
        Validate.notNull(l, y.ٲٴݴ״ٰ(1781922816), new Object[0]);
        this.listeners.remove(l);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public L[] getListeners() {
        return (L[]) this.listeners.toArray(this.prototypeArray);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
        for (L l : this.listeners) {
            try {
                objectOutputStream2.writeObject(l);
                arrayList.add(l);
            } catch (IOException unused) {
                objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
            }
        }
        objectOutputStream.writeObject(arrayList.toArray(this.prototypeArray));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object[] objArr = (Object[]) objectInputStream.readObject();
        this.listeners = new CopyOnWriteArrayList(objArr);
        initializeTransientFields(objArr.getClass().getComponentType(), Thread.currentThread().getContextClassLoader());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initializeTransientFields(Class<L> cls, ClassLoader classLoader) {
        this.prototypeArray = (L[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
        createProxy(cls, classLoader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void createProxy(Class<L> cls, ClassLoader classLoader) {
        this.proxy = cls.cast(Proxy.newProxyInstance(classLoader, new Class[]{cls}, createInvocationHandler()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected InvocationHandler createInvocationHandler() {
        return new ProxyInvocationHandler();
    }

    protected class ProxyInvocationHandler implements InvocationHandler {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected ProxyInvocationHandler() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Iterator it = EventListenerSupport.this.listeners.iterator();
            while (it.hasNext()) {
                method.invoke(it.next(), objArr);
            }
            return null;
        }
    }
}
