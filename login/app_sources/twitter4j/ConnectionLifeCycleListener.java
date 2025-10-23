package twitter4j;

/* loaded from: classes4.dex */
public interface ConnectionLifeCycleListener {
    void onCleanUp();

    void onConnect();

    void onDisconnect();
}
