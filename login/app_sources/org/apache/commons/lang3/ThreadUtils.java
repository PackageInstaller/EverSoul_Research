package org.apache.commons.lang3;

import com.liapp.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ThreadUtils {
    public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate();

    public interface ThreadGroupPredicate {
        boolean test(ThreadGroup threadGroup);
    }

    public interface ThreadPredicate {
        boolean test(Thread thread);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Thread findThreadById(long j, ThreadGroup threadGroup) {
        Validate.isTrue(threadGroup != null, y.ۮڭڭܬި(862246499), new Object[0]);
        Thread findThreadById = findThreadById(j);
        if (findThreadById == null || !threadGroup.equals(findThreadById.getThreadGroup())) {
            return null;
        }
        return findThreadById;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Thread findThreadById(long j, String str) {
        Validate.isTrue(str != null, y.ٴسسݬߨ(1392557642), new Object[0]);
        Thread findThreadById = findThreadById(j);
        if (findThreadById == null || findThreadById.getThreadGroup() == null || !findThreadById.getThreadGroup().getName().equals(str)) {
            return null;
        }
        return findThreadById;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<Thread> findThreadsByName(String str, ThreadGroup threadGroup) {
        return findThreads(threadGroup, false, new NamePredicate(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<Thread> findThreadsByName(String str, String str2) {
        Validate.isTrue(str != null, y.ٲٴݴ״ٰ(1781900632), new Object[0]);
        Validate.isTrue(str2 != null, y.ٴسسݬߨ(1392557642), new Object[0]);
        Collection<ThreadGroup> findThreadGroups = findThreadGroups(new NamePredicate(str2));
        if (findThreadGroups.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        NamePredicate namePredicate = new NamePredicate(str);
        Iterator<ThreadGroup> it = findThreadGroups.iterator();
        while (it.hasNext()) {
            arrayList.addAll(findThreads(it.next(), false, namePredicate));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<ThreadGroup> findThreadGroupsByName(String str) {
        return findThreadGroups(new NamePredicate(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<ThreadGroup> getAllThreadGroups() {
        return findThreadGroups(ALWAYS_TRUE_PREDICATE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ThreadGroup getSystemThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<Thread> getAllThreads() {
        return findThreads(ALWAYS_TRUE_PREDICATE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<Thread> findThreadsByName(String str) {
        return findThreads(new NamePredicate(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Thread findThreadById(long j) {
        Collection<Thread> findThreads = findThreads(new ThreadIdPredicate(j));
        if (findThreads.isEmpty()) {
            return null;
        }
        return findThreads.iterator().next();
    }

    private static final class AlwaysTruePredicate implements ThreadPredicate, ThreadGroupPredicate {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AlwaysTruePredicate() {
        }
    }

    public static class NamePredicate implements ThreadPredicate, ThreadGroupPredicate {
        private final String name;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NamePredicate(String str) {
            Validate.isTrue(str != null, y.ۮڭڭܬި(862245899), new Object[0]);
            this.name = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            return threadGroup != null && threadGroup.getName().equals(this.name);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return thread != null && thread.getName().equals(this.name);
        }
    }

    public static class ThreadIdPredicate implements ThreadPredicate {
        private final long threadId;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ThreadIdPredicate(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("The thread id must be greater than zero");
            }
            this.threadId = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return thread != null && thread.getId() == this.threadId;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<Thread> findThreads(ThreadPredicate threadPredicate) {
        return findThreads(getSystemThreadGroup(), true, threadPredicate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<ThreadGroup> findThreadGroups(ThreadGroupPredicate threadGroupPredicate) {
        return findThreadGroups(getSystemThreadGroup(), true, threadGroupPredicate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<Thread> findThreads(ThreadGroup threadGroup, boolean z, ThreadPredicate threadPredicate) {
        Thread[] threadArr;
        int enumerate;
        Validate.isTrue(threadGroup != null, y.ٲٴݴ״ٰ(1781901176), new Object[0]);
        Validate.isTrue(threadPredicate != null, y.ٴسسݬߨ(1392556306), new Object[0]);
        int activeCount = threadGroup.activeCount();
        while (true) {
            int i = activeCount + (activeCount / 2) + 1;
            threadArr = new Thread[i];
            enumerate = threadGroup.enumerate(threadArr, z);
            if (enumerate < i) {
                break;
            }
            activeCount = enumerate;
        }
        ArrayList arrayList = new ArrayList(enumerate);
        for (int i2 = 0; i2 < enumerate; i2++) {
            if (threadPredicate.test(threadArr[i2])) {
                arrayList.add(threadArr[i2]);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<ThreadGroup> findThreadGroups(ThreadGroup threadGroup, boolean z, ThreadGroupPredicate threadGroupPredicate) {
        ThreadGroup[] threadGroupArr;
        int enumerate;
        Validate.isTrue(threadGroup != null, y.ٲٴݴ״ٰ(1781901176), new Object[0]);
        Validate.isTrue(threadGroupPredicate != null, y.ٴسسݬߨ(1392556306), new Object[0]);
        int activeGroupCount = threadGroup.activeGroupCount();
        while (true) {
            int i = activeGroupCount + (activeGroupCount / 2) + 1;
            threadGroupArr = new ThreadGroup[i];
            enumerate = threadGroup.enumerate(threadGroupArr, z);
            if (enumerate < i) {
                break;
            }
            activeGroupCount = enumerate;
        }
        ArrayList arrayList = new ArrayList(enumerate);
        for (int i2 = 0; i2 < enumerate; i2++) {
            if (threadGroupPredicate.test(threadGroupArr[i2])) {
                arrayList.add(threadGroupArr[i2]);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }
}
