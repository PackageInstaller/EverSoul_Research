package com.kakaogame.util;

import com.liapp.y;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: XMLUtil.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/util/XMLUtil;", "", "()V", "TAG", "", "convertNodesFromXml", "", "xml", "createMap", "node", "Lorg/w3c/dom/Node;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class XMLUtil {
    public static final XMLUtil INSTANCE = new XMLUtil();
    private static final String TAG = "XMLUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private XMLUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> convertNodesFromXml(String xml) throws Exception {
        Intrinsics.checkNotNullParameter(xml, y.ۮڭڭܬި(862912179));
        byte[] bytes = xml.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, y.ٴسسݬߨ(1393128306));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        Element documentElement = newInstance.newDocumentBuilder().parse(byteArrayInputStream).getDocumentElement();
        Intrinsics.checkNotNullExpressionValue(documentElement, y.ۮڭڭܬި(862912155));
        return createMap(documentElement);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, String> createMap(Node node) {
        HashMap hashMap = new HashMap();
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            boolean hasAttributes = item.hasAttributes();
            String str = y.ۮڭڭܬި(862911619);
            if (hasAttributes) {
                int length2 = item.getAttributes().getLength();
                for (int i2 = 0; i2 < length2; i2++) {
                    Node item2 = item.getAttributes().item(i);
                    String nodeName = item2.getNodeName();
                    Intrinsics.checkNotNullExpressionValue(nodeName, y.ݮڮֲڭܩ(-628186612));
                    String textContent = item2.getTextContent();
                    Intrinsics.checkNotNullExpressionValue(textContent, str);
                    hashMap.put(nodeName, textContent);
                }
            }
            if (node.getFirstChild() != null && node.getFirstChild().getNodeType() == 1) {
                Intrinsics.checkNotNull(item);
                hashMap.putAll(createMap(item));
            } else {
                short nodeType = node.getFirstChild().getNodeType();
                String str2 = y.֬ڱܱײٮ(-1159017519);
                if (nodeType == 3) {
                    String localName = node.getLocalName();
                    Intrinsics.checkNotNullExpressionValue(localName, str2);
                    String textContent2 = node.getTextContent();
                    Intrinsics.checkNotNullExpressionValue(textContent2, str);
                    hashMap.put(localName, textContent2);
                } else if (node.getFirstChild().getNodeType() == 4) {
                    String localName2 = node.getLocalName();
                    Intrinsics.checkNotNullExpressionValue(localName2, str2);
                    String textContent3 = node.getTextContent();
                    Intrinsics.checkNotNullExpressionValue(textContent3, str);
                    hashMap.put(localName2, textContent3);
                }
            }
        }
        return hashMap;
    }
}
