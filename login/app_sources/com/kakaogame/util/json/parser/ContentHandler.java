package com.kakaogame.util.json.parser;

import java.io.IOException;
import kotlin.Metadata;

/* compiled from: ContentHandler.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/util/json/parser/ContentHandler;", "", "endArray", "", "endJSON", "", "endObject", "endObjectEntry", "primitive", "value", "startArray", "startJSON", "startObject", "startObjectEntry", "key", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface ContentHandler {
    boolean endArray() throws ParseException, IOException;

    void endJSON() throws ParseException, IOException;

    boolean endObject() throws ParseException, IOException;

    boolean endObjectEntry() throws ParseException, IOException;

    boolean primitive(Object value) throws ParseException, IOException;

    boolean startArray() throws ParseException, IOException;

    void startJSON() throws ParseException, IOException;

    boolean startObject() throws ParseException, IOException;

    boolean startObjectEntry(String key) throws ParseException, IOException;
}
