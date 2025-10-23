package com.google.android.datatransport;

/* loaded from: classes.dex */
final class AutoValue_Event<T> extends Event<T> {
    private final Integer code;
    private final T payload;
    private final Priority priority;
    private final ProductData productData;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AutoValue_Event(Integer num, T t, Priority priority, ProductData productData) {
        this.code = num;
        if (t == null) {
            throw new NullPointerException("Null payload");
        }
        this.payload = t;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.priority = priority;
        this.productData = productData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.Event
    public Integer getCode() {
        return this.code;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.Event
    public T getPayload() {
        return this.payload;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.Event
    public Priority getPriority() {
        return this.priority;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.Event
    public ProductData getProductData() {
        return this.productData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Event{code=" + this.code + ", payload=" + this.payload + ", priority=" + this.priority + ", productData=" + this.productData + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.code;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.payload.equals(event.getPayload()) && this.priority.equals(event.getPriority())) {
                ProductData productData = this.productData;
                if (productData == null) {
                    if (event.getProductData() == null) {
                        return true;
                    }
                } else if (productData.equals(event.getProductData())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Integer num = this.code;
        int hashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode()) * 1000003;
        ProductData productData = this.productData;
        return hashCode ^ (productData != null ? productData.hashCode() : 0);
    }
}
