package com.liapp;

import javax.security.auth.x500.X500Principal;

/* compiled from: ٳܴۮݱ߭.java */
/* renamed from: com.liapp.l */
/* loaded from: classes4.dex */
public final class C2569l {

    /* renamed from: ֬֬֬ڴܰ, reason: not valid java name and contains not printable characters */
    private int f1613;

    /* renamed from: ֮ڲ֮۬ݨ, reason: not valid java name and contains not printable characters */
    private int f1614;

    /* renamed from: ִٱۮܴް, reason: not valid java name and contains not printable characters */
    private int f1615;

    /* renamed from: ײڬݯسگ, reason: contains not printable characters */
    private int f1616;

    /* renamed from: ״ܴڱ۲ݮ, reason: not valid java name and contains not printable characters */
    private char[] f1617;

    /* renamed from: حݱݱֲخ, reason: contains not printable characters */
    private final String f1618;

    /* renamed from: ٳܮزڮܪ, reason: contains not printable characters */
    private final int f1619;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2569l(X500Principal x500Principal) {
        String name = x500Principal.getName(C2571p.m1300("zoh\u001a\u001e\u001c\\"));
        this.f1618 = name;
        this.f1619 = name.length();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ֲܯحױ٭, reason: not valid java name and contains not printable characters */
    private /* synthetic */ String m1290() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        while (true) {
            i = this.f1613;
            i2 = this.f1619;
            if (i >= i2 || this.f1617[i] != ' ') {
                break;
            }
            this.f1613 = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.f1616 = i;
        this.f1613 = i + 1;
        while (true) {
            i3 = this.f1613;
            i4 = this.f1619;
            if (i3 >= i4) {
                break;
            }
            char[] cArr = this.f1617;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f1613 = i3 + 1;
        }
        if (i3 >= i4) {
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("{AHVZJJZCK\u0005KLK\u0001AX\u000fy`\u0000O"));
            insert.append(this.f1618);
            throw new IllegalStateException(insert.toString());
        }
        this.f1615 = i3;
        if (this.f1617[i3] == ' ') {
            while (true) {
                i5 = this.f1613;
                i6 = this.f1619;
                if (i5 >= i6) {
                    break;
                }
                char[] cArr2 = this.f1617;
                if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                    break;
                }
                this.f1613 = i5 + 1;
            }
            if (this.f1617[i5] != '=' || i5 == i6) {
                StringBuilder insert2 = new StringBuilder().insert(0, C2571p.m1300("{AHVZJJZCK\u0005KLK\u0001AX\u000fy`\u0000O"));
                insert2.append(this.f1618);
                throw new IllegalStateException(insert2.toString());
            }
        }
        this.f1613++;
        while (true) {
            int i7 = this.f1613;
            if (i7 >= this.f1619 || this.f1617[i7] != ' ') {
                break;
            }
            this.f1613 = i7 + 1;
        }
        int i8 = this.f1615;
        int i9 = this.f1616;
        if (i8 - i9 > 4) {
            char[] cArr3 = this.f1617;
            if (cArr3[i9 + 3] == '.' && ((cArr3[i9] == 'O' || cArr3[i9] == 'o') && ((cArr3[i9 + 1] == 'I' || cArr3[i9 + 1] == 'i') && (cArr3[i9 + 2] == 'D' || cArr3[i9 + 2] == 'd')))) {
                this.f1616 = i9 + 4;
            }
        }
        char[] cArr4 = this.f1617;
        int i10 = this.f1616;
        return new String(cArr4, i10, this.f1615 - i10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    private /* synthetic */ String m1295() {
        int i = this.f1613 + 1;
        this.f1613 = i;
        this.f1616 = i;
        this.f1615 = i;
        while (true) {
            int i2 = this.f1613;
            if (i2 == this.f1619) {
                StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("{AHVZJJZCK\u0005KLK\u0001AX\u000fy`\u0000O"));
                insert.append(this.f1618);
                throw new IllegalStateException(insert.toString());
            }
            char[] cArr = this.f1617;
            if (cArr[i2] == '\"') {
                this.f1613 = i2 + 1;
                while (true) {
                    int i3 = this.f1613;
                    if (i3 >= this.f1619 || this.f1617[i3] != ' ') {
                        break;
                    }
                    this.f1613 = i3 + 1;
                }
                char[] cArr2 = this.f1617;
                int i4 = this.f1616;
                return new String(cArr2, i4, this.f1615 - i4);
            }
            if (cArr[i2] == '\\') {
                cArr[this.f1615] = m1294();
            } else {
                cArr[this.f1615] = cArr[i2];
            }
            this.f1613++;
            this.f1615++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ֱح۳ۯݫ, reason: not valid java name and contains not printable characters */
    private /* synthetic */ String m1289() {
        int i;
        int i2 = this.f1613;
        if (i2 + 4 >= this.f1619) {
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("{AHVZJJZCK\u0005KLK\u0001AX\u000fy`\u0000O"));
            insert.append(this.f1618);
            throw new IllegalStateException(insert.toString());
        }
        this.f1616 = i2;
        this.f1613 = i2 + 1;
        while (true) {
            i = this.f1613;
            if (i == this.f1619) {
                break;
            }
            char[] cArr = this.f1617;
            if (cArr[i] == '+' || cArr[i] == ',' || cArr[i] == ';') {
                break;
            }
            if (cArr[i] == ' ') {
                this.f1615 = i;
                this.f1613 = i + 1;
                while (true) {
                    int i3 = this.f1613;
                    if (i3 >= this.f1619 || this.f1617[i3] != ' ') {
                        break;
                    }
                    this.f1613 = i3 + 1;
                }
            } else {
                if (cArr[i] >= 'A' && cArr[i] <= 'F') {
                    cArr[i] = (char) (cArr[i] + ' ');
                }
                this.f1613 = i + 1;
            }
        }
        this.f1615 = i;
        int i4 = this.f1615;
        int i5 = this.f1616;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            StringBuilder insert2 = new StringBuilder().insert(0, C2571p.m1300("{AHVZJJZCK\u0005KLK\u0001AX\u000fy`\u0000O"));
            insert2.append(this.f1618);
            throw new IllegalStateException(insert2.toString());
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            byte m1292 = (byte) m1292(i8);
            i8 += 2;
            bArr[i9] = m1292;
        }
        return new String(this.f1617, this.f1616, i6);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private /* synthetic */ String m1293() {
        int i;
        int i2;
        int i3 = this.f1613;
        this.f1616 = i3;
        this.f1615 = i3;
        while (true) {
            int i4 = this.f1613;
            if (i4 >= this.f1619) {
                char[] cArr = this.f1617;
                int i5 = this.f1616;
                return new String(cArr, i5, this.f1615 - i5);
            }
            char[] cArr2 = this.f1617;
            switch (cArr2[i4]) {
                case ' ':
                    int i6 = this.f1615;
                    this.f1614 = i6;
                    this.f1613 = i4 + 1;
                    this.f1615 = i6 + 1;
                    cArr2[i6] = ' ';
                    while (true) {
                        i = this.f1613;
                        i2 = this.f1619;
                        if (i < i2) {
                            char[] cArr3 = this.f1617;
                            if (cArr3[i] == ' ') {
                                int i7 = this.f1615;
                                this.f1615 = i7 + 1;
                                cArr3[i7] = ' ';
                                this.f1613 = i + 1;
                            }
                        }
                    }
                    if (i == i2) {
                        break;
                    } else {
                        char[] cArr4 = this.f1617;
                        if (cArr4[i] != ',' && cArr4[i] != '+' && cArr4[i] != ';') {
                            break;
                        }
                    }
                    break;
                case '+':
                case ',':
                case ';':
                    char[] cArr5 = this.f1617;
                    int i8 = this.f1616;
                    return new String(cArr5, i8, this.f1615 - i8);
                case '\\':
                    int i9 = this.f1615;
                    this.f1615 = i9 + 1;
                    cArr2[i9] = m1294();
                    this.f1613++;
                    break;
                default:
                    int i10 = this.f1615;
                    this.f1615 = i10 + 1;
                    cArr2[i10] = cArr2[i4];
                    this.f1613 = i4 + 1;
                    break;
            }
        }
        char[] cArr6 = this.f1617;
        int i11 = this.f1616;
        return new String(cArr6, i11, this.f1614 - i11);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ۯڲׯ֬ب, reason: contains not printable characters */
    private /* synthetic */ char m1294() {
        int i = this.f1613 + 1;
        this.f1613 = i;
        if (i == this.f1619) {
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("{AHVZJJZCK\u0005KLK\u0001AX\u000fy`\u0000O"));
            insert.append(this.f1618);
            throw new IllegalStateException(insert.toString());
        }
        char[] cArr = this.f1617;
        switch (cArr[i]) {
            case ' ':
            case '\"':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return cArr[i];
            default:
                return m1291();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private /* synthetic */ char m1291() {
        int i;
        int i2;
        int m1292 = m1292(this.f1613);
        this.f1613++;
        if (m1292 < 128) {
            return (char) m1292;
        }
        if (m1292 < 192 || m1292 > 247) {
            return '?';
        }
        if (m1292 <= 223) {
            i2 = m1292 & 31;
            i = 1;
        } else if (m1292 <= 239) {
            i = 2;
            i2 = m1292 & 15;
        } else {
            i = 3;
            i2 = m1292 & 7;
        }
        int i3 = 0;
        while (i3 < i) {
            int i4 = this.f1613 + 1;
            this.f1613 = i4;
            if (i4 == this.f1619 || this.f1617[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f1613 = i5;
            int m12922 = m1292(i5);
            this.f1613++;
            if ((m12922 & 192) != 128) {
                return '?';
            }
            i3++;
            i2 = (i2 << 6) + (m12922 & 63);
        }
        return (char) i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    private /* synthetic */ int m1292(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.f1619) {
            StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("cNAHE]DKB\u000fa`\u0018O"));
            insert.append(this.f1618);
            throw new IllegalStateException(insert.toString());
        }
        char[] cArr = this.f1617;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else if (c >= 'A' && c <= 'F') {
            i2 = c - '7';
        } else {
            StringBuilder insert2 = new StringBuilder().insert(0, C2571p.m1300("cNAHE]DKB\u000fa`\u0018O"));
            insert2.append(this.f1618);
            throw new IllegalStateException(insert2.toString());
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else if (c2 >= 'A' && c2 <= 'F') {
            i3 = c2 - '7';
        } else {
            StringBuilder insert3 = new StringBuilder().insert(0, C2571p.m1300("cNAHE]DKB\u000fa`\u0018O"));
            insert3.append(this.f1618);
            throw new IllegalStateException(insert3.toString());
        }
        return (i2 << 4) + i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ڱܴ֭ٲۮ, reason: contains not printable characters */
    public String m1296(String str) {
        String m1295;
        this.f1613 = 0;
        this.f1616 = 0;
        this.f1615 = 0;
        this.f1614 = 0;
        this.f1617 = this.f1618.toCharArray();
        String m1290 = m1290();
        if (m1290 == null) {
            return null;
        }
        do {
            int i = this.f1613;
            if (i == this.f1619) {
                return null;
            }
            switch (this.f1617[i]) {
                case '\"':
                    m1295 = m1295();
                    break;
                case '#':
                    m1295 = m1289();
                    break;
                case '+':
                case ',':
                case ';':
                    m1295 = "";
                    break;
                default:
                    m1295 = m1293();
                    break;
            }
            if (str.equalsIgnoreCase(m1290)) {
                return m1295;
            }
            int i2 = this.f1613;
            if (i2 >= this.f1619) {
                return null;
            }
            char[] cArr = this.f1617;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                StringBuilder insert = new StringBuilder().insert(0, C2571p.m1300("cNAHE]DKB\u000fa`\u0018O"));
                insert.append(this.f1618);
                throw new IllegalStateException(insert.toString());
            }
            this.f1613 = i2 + 1;
            m1290 = m1290();
        } while (m1290 != null);
        StringBuilder insert2 = new StringBuilder().insert(0, C2571p.m1300("cNAHE]DKB\u000fa`\u0018O"));
        insert2.append(this.f1618);
        throw new IllegalStateException(insert2.toString());
    }
}
