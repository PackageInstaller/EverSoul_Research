package org.apache.commons.lang3.text;

import com.liapp.y;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

@Deprecated
/* loaded from: classes2.dex */
public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher(y.ۮڭڭܬި(862212667));
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher(y.ۮڭڭܬި(861939259));
    public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(y.ۮڭڭܬި(862212635));
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private boolean preserveEscapes;
    private StrMatcher suffixMatcher;
    private StrMatcher valueDelimiterMatcher;
    private StrLookup<?> variableResolver;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StrSubstitutor(map).replace(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return replace(obj, hashMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c, String str3) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c, str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c, String str3) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiter(str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c) {
        this(strLookup, strMatcher, strMatcher2, c, DEFAULT_VALUE_DELIMITER);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c, StrMatcher strMatcher3) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c);
        setValueDelimiterMatcher(strMatcher3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        return !substitute(strBuilder, 0, str.length()) ? str : strBuilder.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(str, i, i2);
        if (!substitute(append, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(cArr, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(charSequence, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(strBuilder, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean replaceIn(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        if (!substitute(append, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, append.toString());
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean replaceIn(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return replaceIn(sb, 0, sb.length());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean replaceIn(StringBuilder sb, int i, int i2) {
        if (sb == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(sb, i, i2);
        if (!substitute(append, 0, i2)) {
            return false;
        }
        sb.replace(i, i2 + i, append.toString());
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean replaceIn(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean substitute(StrBuilder strBuilder, int i, int i2) {
        return substitute(strBuilder, i, i2, null) > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int substitute(StrBuilder strBuilder, int i, int i2, List<String> list) {
        StrMatcher strMatcher;
        StrMatcher strMatcher2;
        char c;
        boolean z;
        String str;
        int isMatch;
        StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar = getEscapeChar();
        StrMatcher valueDelimiterMatcher = getValueDelimiterMatcher();
        boolean isEnableSubstitutionInVariables = isEnableSubstitutionInVariables();
        boolean z2 = list == null;
        int i3 = i;
        int i4 = i + i2;
        int i5 = 0;
        int i6 = 0;
        char[] cArr = strBuilder.buffer;
        List<String> list2 = list;
        while (i3 < i4) {
            int isMatch2 = variablePrefixMatcher.isMatch(cArr, i3, i, i4);
            if (isMatch2 != 0) {
                if (i3 > i) {
                    int i7 = i3 - 1;
                    if (cArr[i7] == escapeChar) {
                        if (this.preserveEscapes) {
                            i3++;
                        } else {
                            strBuilder.deleteCharAt(i7);
                            i5--;
                            i4--;
                            strMatcher = variablePrefixMatcher;
                            strMatcher2 = variableSuffixMatcher;
                            c = escapeChar;
                            cArr = strBuilder.buffer;
                            z = z2;
                            i6 = 1;
                        }
                    }
                }
                int i8 = i3 + isMatch2;
                int i9 = i8;
                int i10 = 0;
                while (true) {
                    if (i9 >= i4) {
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        c = escapeChar;
                        z = z2;
                        i3 = i9;
                        break;
                    }
                    if (!isEnableSubstitutionInVariables || (isMatch = variablePrefixMatcher.isMatch(cArr, i9, i, i4)) == 0) {
                        int isMatch3 = variableSuffixMatcher.isMatch(cArr, i9, i, i4);
                        if (isMatch3 == 0) {
                            i9++;
                        } else if (i10 == 0) {
                            strMatcher2 = variableSuffixMatcher;
                            c = escapeChar;
                            String str2 = new String(cArr, i8, (i9 - i3) - isMatch2);
                            if (isEnableSubstitutionInVariables) {
                                StrBuilder strBuilder2 = new StrBuilder(str2);
                                substitute(strBuilder2, 0, strBuilder2.length());
                                str2 = strBuilder2.toString();
                            }
                            int i11 = i9 + isMatch3;
                            if (valueDelimiterMatcher != null) {
                                char[] charArray = str2.toCharArray();
                                z = z2;
                                int i12 = 0;
                                while (i12 < charArray.length && (isEnableSubstitutionInVariables || variablePrefixMatcher.isMatch(charArray, i12, i12, charArray.length) == 0)) {
                                    int isMatch4 = valueDelimiterMatcher.isMatch(charArray, i12);
                                    if (isMatch4 != 0) {
                                        strMatcher = variablePrefixMatcher;
                                        String substring = str2.substring(0, i12);
                                        str = str2.substring(i12 + isMatch4);
                                        str2 = substring;
                                        break;
                                    }
                                    i12++;
                                    variablePrefixMatcher = variablePrefixMatcher;
                                }
                                strMatcher = variablePrefixMatcher;
                            } else {
                                strMatcher = variablePrefixMatcher;
                                z = z2;
                            }
                            str = null;
                            if (list2 == null) {
                                list2 = new ArrayList<>();
                                list2.add(new String(cArr, i, i2));
                            }
                            checkCyclicSubstitution(str2, list2);
                            list2.add(str2);
                            String resolveVariable = resolveVariable(str2, strBuilder, i3, i11);
                            if (resolveVariable != null) {
                                str = resolveVariable;
                            }
                            if (str != null) {
                                int length = str.length();
                                strBuilder.replace(i3, i11, str);
                                int substitute = (substitute(strBuilder, i3, length, list2) + length) - (i11 - i3);
                                i4 += substitute;
                                i5 += substitute;
                                cArr = strBuilder.buffer;
                                i3 = i11 + substitute;
                                i6 = 1;
                            } else {
                                i3 = i11;
                            }
                            list2.remove(list2.size() - 1);
                        } else {
                            i10--;
                            i9 += isMatch3;
                            escapeChar = escapeChar;
                            variablePrefixMatcher = variablePrefixMatcher;
                        }
                    } else {
                        i10++;
                        i9 += isMatch;
                    }
                }
            } else {
                i3++;
                strMatcher = variablePrefixMatcher;
                strMatcher2 = variableSuffixMatcher;
                c = escapeChar;
                z = z2;
            }
            variableSuffixMatcher = strMatcher2;
            escapeChar = c;
            z2 = z;
            variablePrefixMatcher = strMatcher;
        }
        return z2 ? i6 : i5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append(y.٬ݯح׭٩(575930238));
            strBuilder.append(list.remove(0));
            strBuilder.append(y.ݬֲ֮ܲت(1512932847));
            strBuilder.appendWithSeparators(list, y.ۮڭڭܬި(862215555));
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String resolveVariable(String str, StrBuilder strBuilder, int i, int i2) {
        StrLookup<?> variableResolver = getVariableResolver();
        if (variableResolver == null) {
            return null;
        }
        return variableResolver.lookup(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public char getEscapeChar() {
        return this.escapeChar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEscapeChar(char c) {
        this.escapeChar = c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051618717));
        }
        this.prefixMatcher = strMatcher;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setVariablePrefix(char c) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setVariablePrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159697943));
        }
        return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1392521218));
        }
        this.suffixMatcher = strMatcher;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setVariableSuffix(char c) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setVariableSuffix(String str) {
        if (str == null) {
            throw new IllegalArgumentException(y.ݮڮֲڭܩ(-628882668));
        }
        return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setValueDelimiterMatcher(StrMatcher strMatcher) {
        this.valueDelimiterMatcher = strMatcher;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setValueDelimiter(char c) {
        return setValueDelimiterMatcher(StrMatcher.charMatcher(c));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrSubstitutor setValueDelimiter(String str) {
        if (StringUtils.isEmpty(str)) {
            setValueDelimiterMatcher(null);
            return this;
        }
        return setValueDelimiterMatcher(StrMatcher.stringMatcher(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StrLookup<?> getVariableResolver() {
        return this.variableResolver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVariableResolver(StrLookup<?> strLookup) {
        this.variableResolver = strLookup;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEnableSubstitutionInVariables(boolean z) {
        this.enableSubstitutionInVariables = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPreserveEscapes() {
        return this.preserveEscapes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPreserveEscapes(boolean z) {
        this.preserveEscapes = z;
    }
}
