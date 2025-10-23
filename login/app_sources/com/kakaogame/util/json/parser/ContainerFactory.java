package com.kakaogame.util.json.parser;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ContainerFactory.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003H&J\u0018\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H&¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/util/json/parser/ContainerFactory;", "", "creatArrayContainer", "", "createObjectContainer", "", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface ContainerFactory {
    List<Object> creatArrayContainer();

    Map<String, Object> createObjectContainer();
}
