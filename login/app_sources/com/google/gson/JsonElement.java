package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class JsonElement {
    public abstract JsonElement deepCopy();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonObject getAsJsonObject() {
        if (isJsonObject()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArray getAsJsonArray() {
        if (isJsonArray()) {
            return (JsonArray) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonPrimitive getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonNull getAsJsonNull() {
        if (isJsonNull()) {
            return (JsonNull) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Number getAsNumber() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getAsFloat() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte getAsByte() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public char getAsCharacter() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getAsShort() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            Streams.write(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
