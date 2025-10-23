package com.unity3d.player;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.unity3d.player.S */
/* loaded from: classes3.dex */
abstract class AbstractC2687S implements TextWatcher {

    /* renamed from: a */
    protected Context f1254a;

    /* renamed from: b */
    protected UnityPlayer f1255b;

    /* renamed from: c */
    protected EditText f1256c = createEditText(this);

    /* renamed from: d */
    protected boolean f1257d;

    /* renamed from: e */
    protected boolean f1258e;

    /* renamed from: f */
    protected InterfaceC2660F f1259f;

    /* renamed from: g */
    protected InterfaceC2662G f1260g;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AbstractC2687S(Context context, UnityPlayer unityPlayer) {
        this.f1254a = context;
        this.f1255b = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final String m746a() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.f1254a.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return null;
        }
        String m836a = AbstractC2766y.m836a(currentInputMethodSubtype);
        if (m836a != null && !m836a.equals("")) {
            return m836a;
        }
        return currentInputMethodSubtype.getMode() + StringUtils.SPACE + currentInputMethodSubtype.getExtraValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public void mo747a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        this.f1258e = z6;
        setupTextInput(str, i, z, z2, z3, z4, str2, i2);
        mo749a(z5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m748a(String str, boolean z) {
        this.f1256c.setSelection(0, 0);
        this.f1255b.reportSoftInputStr(str, 1, z);
    }

    /* renamed from: a */
    public abstract void mo749a(boolean z);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f1255b.reportSoftInputStr(editable.toString(), 0, false);
        int selectionStart = this.f1256c.getSelectionStart();
        this.f1255b.reportSoftInputSelection(selectionStart, this.f1256c.getSelectionEnd() - selectionStart);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final String m750b() {
        EditText editText = this.f1256c;
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* renamed from: c */
    public abstract void mo751c();

    protected abstract EditText createEditText(AbstractC2687S abstractC2687S);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public boolean mo752d() {
        return this.f1258e;
    }

    /* renamed from: e */
    public abstract void mo753e();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: f */
    public final void m754f() {
        ((InputMethodManager) this.f1254a.getSystemService("input_method")).showSoftInput(this.f1256c, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void invokeOnClose() {
        InterfaceC2662G interfaceC2662G = this.f1260g;
        if (interfaceC2662G != null) {
            ((C2749p0) interfaceC2662G).m811a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setupTextInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2) {
        this.f1256c.setOnEditorActionListener(new C2683Q(this));
        this.f1256c.setBackgroundColor(-1);
        this.f1256c.setImeOptions(6);
        this.f1256c.setText(str);
        this.f1256c.setHint(str2);
        this.f1256c.setHintTextColor(1627389952);
        EditText editText = this.f1256c;
        int i3 = (z ? 32768 : 524288) | (z2 ? 131072 : 0) | (z3 ? 128 : 0);
        if (i >= 0 && i <= 11) {
            int i4 = new int[]{1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194}[i];
            if ((i4 & 2) != 0) {
                i3 = (z3 ? 16 : 0) | i4;
            } else {
                i3 |= i4;
            }
        }
        editText.setInputType(i3);
        this.f1256c.setImeOptions(33554432);
        if (i2 > 0) {
            this.f1256c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
        this.f1256c.addTextChangedListener(this);
        EditText editText2 = this.f1256c;
        editText2.setSelection(editText2.getText().length());
        this.f1256c.setClickable(true);
    }
}
