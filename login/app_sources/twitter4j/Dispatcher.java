package twitter4j;

/* loaded from: classes4.dex */
public interface Dispatcher {
    void invokeLater(Runnable runnable);

    void shutdown();
}
