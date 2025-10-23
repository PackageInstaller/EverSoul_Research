package org.apache.commons.lang3.text.translate;

import com.liapp.y;
import java.lang.reflect.Array;

@Deprecated
/* loaded from: classes2.dex */
public class EntityArrays {
    private static final String[][] APOS_ESCAPE;
    private static final String[][] APOS_UNESCAPE;
    private static final String[][] BASIC_ESCAPE;
    private static final String[][] BASIC_UNESCAPE;
    private static final String[][] HTML40_EXTENDED_ESCAPE;
    private static final String[][] HTML40_EXTENDED_UNESCAPE;
    private static final String[][] ISO8859_1_ESCAPE;
    private static final String[][] ISO8859_1_UNESCAPE;
    private static final String[][] JAVA_CTRL_CHARS_ESCAPE;
    private static final String[][] JAVA_CTRL_CHARS_UNESCAPE;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] ISO8859_1_ESCAPE() {
        return (String[][]) ISO8859_1_ESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String[][] strArr = {new String[]{" ", y.֬ڱܱײٮ(-1159704439)}, new String[]{"¡", y.ݮڮֲڭܩ(-628868700)}, new String[]{"¢", y.ٴسسݬߨ(1392512610)}, new String[]{"£", y.֬ڱܱײٮ(-1159703743)}, new String[]{"¤", y.ٴسسݬߨ(1392512666)}, new String[]{"¥", y.ݬֲ֮ܲت(1512645775)}, new String[]{"¦", y.ݮڮֲڭܩ(-628868324)}, new String[]{"§", y.ݮڮֲڭܩ(-628868148)}, new String[]{"¨", y.ۮڭڭܬި(862217963)}, new String[]{"©", y.ݬֲ֮ܲت(1512645519)}, new String[]{"ª", y.ٲٴݴ״ٰ(1781864256)}, new String[]{"«", y.ٲٴݴ״ٰ(1781864320)}, new String[]{"¬", y.دײܮڳܯ(2051607213)}, new String[]{"\u00ad", y.دײܮڳܯ(2051607397)}, new String[]{"®", y.ۮڭڭܬި(862216315)}, new String[]{"¯", y.ݬֲ֮ܲت(1512645151)}, new String[]{"°", y.֬ڱܱײٮ(-1159703303)}, new String[]{"±", y.٬ݯح׭٩(575917518)}, new String[]{"²", y.٬ݯح׭٩(575917694)}, new String[]{"³", y.ݮڮֲڭܩ(-628867364)}, new String[]{"´", y.ݬֲ֮ܲت(1512644951)}, new String[]{"µ", y.ۮڭڭܬި(862216739)}, new String[]{"¶", y.֬ڱܱײٮ(-1159702943)}, new String[]{"·", y.֬ڱܱײٮ(-1159702879)}, new String[]{"¸", y.ٲٴݴ״ٰ(1781863672)}, new String[]{"¹", y.٬ݯح׭٩(575913990)}, new String[]{"º", y.ٴسسݬߨ(1392509994)}, new String[]{"»", y.٬ݯح׭٩(575914118)}, new String[]{"¼", y.֬ڱܱײٮ(-1159702079)}, new String[]{"½", y.ݬֲ֮ܲت(1512648407)}, new String[]{"¾", y.֬ڱܱײٮ(-1159702367)}, new String[]{"¿", y.ٴسسݬߨ(1392510386)}, new String[]{"À", y.ݮڮֲڭܩ(-628870548)}, new String[]{"Á", y.ݮڮֲڭܩ(-628870436)}, new String[]{"Â", y.ۮڭڭܬި(862220267)}, new String[]{"Ã", y.٬ݯح׭٩(575914774)}, new String[]{"Ä", y.ۮڭڭܬި(862219843)}, new String[]{"Å", y.ݬֲ֮ܲت(1512647727)}, new String[]{"Æ", y.ٴسسݬߨ(1392510882)}, new String[]{"Ç", y.٬ݯح׭٩(575915126)}, new String[]{"È", y.٬ݯح׭٩(575915174)}, new String[]{"É", y.ٴسسݬߨ(1392509114)}, new String[]{"Ê", y.ݬֲ֮ܲت(1512647343)}, new String[]{"Ë", y.ۮڭڭܬި(862218315)}, new String[]{"Ì", y.ٲٴݴ״ٰ(1781866152)}, new String[]{"Í", y.ٴسسݬߨ(1392509522)}, new String[]{"Î", y.ٴسسݬߨ(1392509442)}, new String[]{"Ï", y.֬ڱܱײٮ(-1159700583)}, new String[]{"Ð", y.ٲٴݴ״ٰ(1781865968)}, new String[]{"Ñ", y.ٲٴݴ״ٰ(1781865480)}, new String[]{"Ò", y.دײܮڳܯ(2051604765)}, new String[]{"Ó", y.ݬֲ֮ܲت(1512646695)}, new String[]{"Ô", y.ݮڮֲڭܩ(-628873124)}, new String[]{"Õ", y.٬ݯح׭٩(575920230)}, new String[]{"Ö", y.ٲٴݴ״ٰ(1781859248)}, new String[]{"×", y.ݮڮֲڭܩ(-628873036)}, new String[]{"Ø", y.دײܮڳܯ(2051612509)}, new String[]{"Ù", y.ٴسسݬߨ(1392516386)}, new String[]{"Ú", y.ٴسسݬߨ(1392516498)}, new String[]{"Û", y.٬ݯح׭٩(575920686)}, new String[]{"Ü", y.ٴسسݬߨ(1392516666)}, new String[]{"Ý", y.ۮڭڭܬި(862222227)}, new String[]{"Þ", y.ٲٴݴ״ٰ(1781858784)}, new String[]{"ß", y.٬ݯح׭٩(575920910)}, new String[]{"à", y.ݬֲ֮ܲت(1512649759)}, new String[]{"á", y.ۮڭڭܬި(862222051)}, new String[]{"â", y.ݮڮֲڭܩ(-628872076)}, new String[]{"ã", y.ۮڭڭܬި(862220635)}, new String[]{"ä", y.ٴسسݬߨ(1392515298)}, new String[]{"å", y.٬ݯح׭٩(575921358)}, new String[]{"æ", y.֬ڱܱײٮ(-1159707527)}, new String[]{"ç", y.ٲٴݴ״ٰ(1781859992)}, new String[]{"è", y.ٲٴݴ״ٰ(1781860040)}, new String[]{"é", y.ٲٴݴ״ٰ(1781859640)}, new String[]{"ê", y.ۮڭڭܬި(862221131)}, new String[]{"ë", y.ٲٴݴ״ٰ(1781859792)}, new String[]{"ì", y.ٴسسݬߨ(1392515930)}, new String[]{"í", y.دײܮڳܯ(2051610917)}, new String[]{"î", y.֬ڱܱײٮ(-1159706983)}, new String[]{"ï", y.ٴسسݬߨ(1392516018)}, new String[]{"ð", y.٬ݯح׭٩(575918110)}, new String[]{"ñ", y.ݬֲ֮ܲت(1512652799)}, new String[]{"ò", y.֬ڱܱײٮ(-1159706231)}, new String[]{"ó", y.ٴسسݬߨ(1392514394)}, new String[]{"ô", y.دײܮڳܯ(2051610405)}, new String[]{"õ", y.֬ڱܱײٮ(-1159706463)}, new String[]{"ö", y.٬ݯح׭٩(575918558)}, new String[]{"÷", y.ٴسسݬߨ(1392514674)}, new String[]{"ø", y.ݮڮֲڭܩ(-628874708)}, new String[]{"ù", y.ٲٴݴ״ٰ(1781860824)}, new String[]{"ú", y.ٲٴݴ״ٰ(1781860360)}, new String[]{"û", y.٬ݯح׭٩(575918942)}, new String[]{"ü", y.ۮڭڭܬި(862224003)}, new String[]{"ý", y.ٲٴݴ״ٰ(1781860576)}, new String[]{"þ", y.ݮڮֲڭܩ(-628874220)}, new String[]{"ÿ", y.ۮڭڭܬި(862222779)}};
        ISO8859_1_ESCAPE = strArr;
        ISO8859_1_UNESCAPE = invert(strArr);
        String[][] strArr2 = {new String[]{"ƒ", y.ۮڭڭܬި(862222843)}, new String[]{"Α", y.ٲٴݴ״ٰ(1781861912)}, new String[]{"Β", y.٬ݯح׭٩(575919462)}, new String[]{"Γ", y.دײܮڳܯ(2051609573)}, new String[]{"Δ", y.٬ݯح׭٩(575919598)}, new String[]{"Ε", y.ݬֲ֮ܲت(1512651199)}, new String[]{"Ζ", y.دײܮڳܯ(2051608589)}, new String[]{"Η", y.٬ݯح׭٩(575919758)}, new String[]{"Θ", y.ٲٴݴ״ٰ(1781861856)}, new String[]{"Ι", y.ٲٴݴ״ٰ(1781861416)}, new String[]{"Κ", y.ݬֲ֮ܲت(1512650983)}, new String[]{"Λ", y.ٴسسݬߨ(1392513946)}, new String[]{"Μ", y.٬ݯح׭٩(575907878)}, new String[]{"Ν", y.ٲٴݴ״ٰ(1781887824)}, new String[]{"Ξ", y.دײܮڳܯ(2051632645)}, new String[]{"Ο", y.ݮڮֲڭܩ(-628860684)}, new String[]{"Π", y.ݬֲ֮ܲت(1512654695)}, new String[]{"Ρ", y.٬ݯح׭٩(575908126)}, new String[]{"Σ", y.٬ݯح׭٩(575908182)}, new String[]{"Τ", y.دײܮڳܯ(2051633117)}, new String[]{"Υ", y.ٲٴݴ״ٰ(1781887728)}, new String[]{"Φ", y.ݮڮֲڭܩ(-628860308)}, new String[]{"Χ", y.ݬֲ֮ܲت(1512654319)}, new String[]{"Ψ", y.ݮڮֲڭܩ(-628860164)}, new String[]{"Ω", y.ݮڮֲڭܩ(-628860236)}, new String[]{"α", y.ٲٴݴ״ٰ(1781887032)}, new String[]{"β", y.ٴسسݬߨ(1392537386)}, new String[]{"γ", y.ݬֲ֮ܲت(1512653871)}, new String[]{"δ", y.ٲٴݴ״ٰ(1781887208)}, new String[]{"ε", y.٬ݯح׭٩(575908982)}, new String[]{"ζ", y.ٴسسݬߨ(1392535746)}, new String[]{"η", y.ݮڮֲڭܩ(-628859764)}, new String[]{"θ", y.٬ݯح׭٩(575909158)}, new String[]{"ι", y.ٲٴݴ״ٰ(1781888584)}, new String[]{"κ", y.֬ڱܱײٮ(-1159711583)}, new String[]{"λ", y.ݮڮֲڭܩ(-628859468)}, new String[]{"μ", y.ٲٴݴ״ٰ(1781888288)}, new String[]{"ν", y.ݬֲ֮ܲت(1512653311)}, new String[]{"ξ", y.ٴسسݬߨ(1392536266)}, new String[]{"ο", y.ٲٴݴ״ٰ(1781888464)}, new String[]{"π", y.ݬֲ֮ܲت(1512652935)}, new String[]{"ρ", y.֬ڱܱײٮ(-1159711119)}, new String[]{"ς", y.ٴسسݬߨ(1392536538)}, new String[]{"σ", y.دײܮڳܯ(2051631525)}, new String[]{"τ", y.ٴسسݬߨ(1392534594)}, new String[]{"υ", y.ݬֲ֮ܲت(1512656847)}, new String[]{"φ", y.֬ڱܱײٮ(-1159710319)}, new String[]{"χ", y.֬ڱܱײٮ(-1159710247)}, new String[]{"ψ", y.٬ݯح׭٩(575906094)}, new String[]{"ω", y.ݬֲ֮ܲت(1512656591)}, new String[]{"ϑ", y.٬ݯح׭٩(575906222)}, new String[]{"ϒ", y.٬ݯح׭٩(575906254)}, new String[]{"ϖ", y.ۮڭڭܬި(862195571)}, new String[]{"•", y.٬ݯح׭٩(575906382)}, new String[]{"…", y.ٴسسݬߨ(1392535266)}, new String[]{"′", y.ݬֲ֮ܲت(1512656023)}, new String[]{"″", y.٬ݯح׭٩(575906662)}, new String[]{"‾", y.ݮڮֲڭܩ(-628862004)}, new String[]{"⁄", y.ݬֲ֮ܲت(1512655999)}, new String[]{"℘", y.٬ݯح׭٩(575906846)}, new String[]{"ℑ", y.ٴسسݬߨ(1392533538)}, new String[]{"ℜ", y.֬ڱܱײٮ(-1159709191)}, new String[]{"™", y.ٴسسݬߨ(1392533850)}, new String[]{"ℵ", y.ٲٴݴ״ٰ(1781890648)}, new String[]{"←", y.ٴسسݬߨ(1392534010)}, new String[]{"↑", y.ݮڮֲڭܩ(-628861516)}, new String[]{"→", y.ݮڮֲڭܩ(-628861324)}, new String[]{"↓", y.ٴسسݬߨ(1392534074)}, new String[]{"↔", y.ۮڭڭܬި(862194579)}, new String[]{"↵", y.٬ݯح׭٩(575907542)}, new String[]{"⇐", y.ٴسسݬߨ(1392534386)}, new String[]{"⇑", y.ٴسسݬߨ(1392534322)}, new String[]{"⇒", y.ٲٴݴ״ٰ(1781890232)}, new String[]{"⇓", y.ݮڮֲڭܩ(-628860996)}, new String[]{"⇔", y.ٲٴݴ״ٰ(1781883704)}, new String[]{"∀", y.ٴسسݬߨ(1392540722)}, new String[]{"∂", y.ݮڮֲڭܩ(-628864788)}, new String[]{"∃", y.֬ڱܱײٮ(-1159716415)}, new String[]{"∅", y.ۮڭڭܬި(862196851)}, new String[]{"∇", y.ٴسسݬߨ(1392541138)}, new String[]{"∈", y.֬ڱܱײٮ(-1159716631)}, new String[]{"∉", y.ٴسسݬߨ(1392541258)}, new String[]{"∋", y.ٲٴݴ״ٰ(1781883208)}, new String[]{"∏", y.ݮڮֲڭܩ(-628864292)}, new String[]{"∑", y.ٲٴݴ״ٰ(1781883352)}, new String[]{"−", y.ٴسسݬߨ(1392541530)}, new String[]{"∗", y.ݮڮֲڭܩ(-628864228)}, new String[]{"√", y.٬ݯح׭٩(575912878)}, new String[]{"∝", y.٬ݯح׭٩(575912918)}, new String[]{"∞", y.ۮڭڭܬި(862195987)}, new String[]{"∠", y.ݮڮֲڭܩ(-628863940)}, new String[]{"∧", y.ٲٴݴ״ٰ(1781884848)}, new String[]{"∨", y.ݮڮֲڭܩ(-628863860)}, new String[]{"∩", y.ݬֲ֮ܲت(1512657559)}, new String[]{"∪", y.ٲٴݴ״ٰ(1781884496)}, new String[]{"∫", y.٬ݯح׭٩(575913294)}, new String[]{"∴", y.ۮڭڭܬި(862195843)}, new String[]{"∼", y.ݮڮֲڭܩ(-628863404)}, new String[]{"≅", y.ٲٴݴ״ٰ(1781884200)}, new String[]{"≈", y.٬ݯح׭٩(575913550)}, new String[]{"≠", y.ٴسسݬߨ(1392540314)}, new String[]{"≡", y.ٴسسݬߨ(1392540330)}, new String[]{"≤", y.ٲٴݴ״ٰ(1781883944)}, new String[]{"≥", y.ٴسسݬߨ(1392540466)}, new String[]{"⊂", y.ݬֲ֮ܲت(1512656903)}, new String[]{"⊃", y.ٲٴݴ״ٰ(1781884096)}, new String[]{"⊄", y.ݮڮֲڭܩ(-628866980)}, new String[]{"⊆", y.ۮڭڭܬި(862199163)}, new String[]{"⊇", y.ٴسسݬߨ(1392538834)}, new String[]{"⊕", y.ٲٴݴ״ٰ(1781885912)}, new String[]{"⊗", y.دײܮڳܯ(2051635045)}, new String[]{"⊥", y.ۮڭڭܬި(862198867)}, new String[]{"⋅", y.ٴسسݬߨ(1392539130)}, new String[]{"⌈", y.دײܮڳܯ(2051635093)}, new String[]{"⌉", y.ݬֲ֮ܲت(1512660407)}, new String[]{"⌊", y.ٴسسݬߨ(1392539178)}, new String[]{"⌋", y.ݬֲ֮ܲت(1512660319)}, new String[]{"〈", y.ۮڭڭܬި(862199331)}, new String[]{"〉", y.ٲٴݴ״ٰ(1781884992)}, new String[]{"◊", y.دײܮڳܯ(2051634661)}, new String[]{"♠", y.٬ݯح׭٩(575910910)}, new String[]{"♣", y.ݮڮֲڭܩ(-628865972)}, new String[]{"♥", y.دײܮڳܯ(2051633685)}, new String[]{"♦", y.ۮڭڭܬި(862198147)}, new String[]{"Œ", y.ۮڭڭܬި(862198219)}, new String[]{"œ", y.دײܮڳܯ(2051633973)}, new String[]{"Š", y.֬ڱܱײٮ(-1159713615)}, new String[]{"š", y.٬ݯح׭٩(575911406)}, new String[]{"Ÿ", y.֬ڱܱײٮ(-1159713007)}, new String[]{"ˆ", y.ٴسسݬߨ(1392538162)}, new String[]{"˜", y.ݮڮֲڭܩ(-628865284)}, new String[]{"\u2002", y.ۮڭڭܬި(862198723)}, new String[]{"\u2003", y.ݮڮֲڭܩ(-628865180)}, new String[]{"\u2009", y.دײܮڳܯ(2051633413)}, new String[]{"\u200c", y.٬ݯح׭٩(575911926)}, new String[]{"\u200d", y.ۮڭڭܬި(862201139)}, new String[]{"\u200e", y.دײܮڳܯ(2051624525)}, new String[]{"\u200f", y.ٴسسݬߨ(1392528426)}, new String[]{"–", y.٬ݯح׭٩(575899806)}, new String[]{"—", y.ݬֲ֮ܲت(1512662895)}, new String[]{"‘", y.ٴسسݬߨ(1392528738)}, new String[]{"’", y.ۮڭڭܬި(862201011)}, new String[]{"‚", y.ٴسسݬߨ(1392528786)}, new String[]{"“", y.ݮڮֲڭܩ(-628852156)}, new String[]{"”", y.ٲٴݴ״ٰ(1781879112)}, new String[]{"„", y.ٴسسݬߨ(1392529146)}, new String[]{"†", y.٬ݯح׭٩(575900382)}, new String[]{"‡", y.ݬֲ֮ܲت(1512662183)}, new String[]{"‰", y.دײܮڳܯ(2051624445)}, new String[]{"‹", y.٬ݯح׭٩(575900654)}, new String[]{"›", y.ݮڮֲڭܩ(-628851588)}, new String[]{"€", y.ݮڮֲڭܩ(-628851668)}};
        HTML40_EXTENDED_ESCAPE = strArr2;
        HTML40_EXTENDED_UNESCAPE = invert(strArr2);
        String[][] strArr3 = {new String[]{y.دײܮڳܯ(2051949821), y.ۮڭڭܬި(862200203)}, new String[]{y.֬ڱܱײٮ(-1159719487), y.ݬֲ֮ܲت(1512661647)}, new String[]{y.ٴسسݬߨ(1392546330), y.٬ݯح׭٩(575901054)}, new String[]{y.دײܮڳܯ(2051641437), y.٬ݯح׭٩(575901006)}};
        BASIC_ESCAPE = strArr3;
        BASIC_UNESCAPE = invert(strArr3);
        String[][] strArr4 = {new String[]{y.دײܮڳܯ(2051806557), y.ٲٴݴ״ٰ(1781880504)}};
        APOS_ESCAPE = strArr4;
        APOS_UNESCAPE = invert(strArr4);
        String[][] strArr5 = {new String[]{"\b", y.دײܮڳܯ(2051623837)}, new String[]{y.ٲٴݴ״ٰ(1781641888), y.ݬֲ֮ܲت(1512661399)}, new String[]{y.ٴسسݬߨ(1392527986), y.֬ڱܱײٮ(-1159719047)}, new String[]{"\f", y.ۮڭڭܬި(862200659)}, new String[]{y.ݬֲ֮ܲت(1512661279), y.٬ݯح׭٩(575901358)}};
        JAVA_CTRL_CHARS_ESCAPE = strArr5;
        JAVA_CTRL_CHARS_UNESCAPE = invert(strArr5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] ISO8859_1_UNESCAPE() {
        return (String[][]) ISO8859_1_UNESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] HTML40_EXTENDED_ESCAPE() {
        return (String[][]) HTML40_EXTENDED_ESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] HTML40_EXTENDED_UNESCAPE() {
        return (String[][]) HTML40_EXTENDED_UNESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] BASIC_ESCAPE() {
        return (String[][]) BASIC_ESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] BASIC_UNESCAPE() {
        return (String[][]) BASIC_UNESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] APOS_ESCAPE() {
        return (String[][]) APOS_ESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] APOS_UNESCAPE() {
        return (String[][]) APOS_UNESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] JAVA_CTRL_CHARS_ESCAPE() {
        return (String[][]) JAVA_CTRL_CHARS_ESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] JAVA_CTRL_CHARS_UNESCAPE() {
        return (String[][]) JAVA_CTRL_CHARS_UNESCAPE.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[][] invert(String[][] strArr) {
        String[][] strArr2 = (String[][]) Array.newInstance((Class<?>) String.class, strArr.length, 2);
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i][0] = strArr[i][1];
            strArr2[i][1] = strArr[i][0];
        }
        return strArr2;
    }
}
