package com.kakaogame.infodesk;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.kakaogame.BuildConfig;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.ServerInfo;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;

/* compiled from: InfodeskHelper.kt */
@Metadata(m838d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b0\bÆ\u0002\u0018\u00002\u00020\u0001:\u000eô\u0001õ\u0001ö\u0001÷\u0001ø\u0001ù\u0001ú\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0007\u0010Å\u0001\u001a\u00020)J'\u0010Æ\u0001\u001a\u00020W2\u0018\u0010Ç\u0001\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040È\u0001\"\u0004\u0018\u00010\u0004¢\u0006\u0003\u0010É\u0001J$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00172\n\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0002J\u001b\u0010Ì\u0001\u001a\u00020W2\u0007\u0010Í\u0001\u001a\u00020\u00042\u0007\u0010Î\u0001\u001a\u00020WH\u0002J\"\u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00020\t0®\u00012\u0007\u0010Í\u0001\u001a\u00020\u00042\u0007\u0010Ð\u0001\u001a\u00020\u0004H\u0002J\u0013\u0010Ñ\u0001\u001a\u00020)2\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ë\u0001J\u0013\u0010Ó\u0001\u001a\u00020)2\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ë\u0001J\u001b\u0010Ô\u0001\u001a\u00020\t2\u0007\u0010Í\u0001\u001a\u00020\u00042\u0007\u0010Î\u0001\u001a\u00020\tH\u0002J-\u0010Õ\u0001\u001a\u00020)2\u0007\u0010Í\u0001\u001a\u00020\u00042\u0007\u0010Î\u0001\u001a\u00020)2\u0007\u0010Ö\u0001\u001a\u00020)2\u0007\u0010×\u0001\u001a\u00020)H\u0002JF\u0010Õ\u0001\u001a\u00020)2\u0017\u0010Ê\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00172\u0007\u0010Í\u0001\u001a\u00020\u00042\u0007\u0010Î\u0001\u001a\u00020)2\u0007\u0010Ö\u0001\u001a\u00020)2\u0007\u0010×\u0001\u001a\u00020)H\u0002J\u0019\u0010Ø\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040®\u00012\u0007\u0010Í\u0001\u001a\u00020\u0004H\u0002J'\u0010Ù\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00172\u0007\u0010Í\u0001\u001a\u00020\u00042\u0007\u0010Ú\u0001\u001a\u00020\u0004H\u0002J\u001f\u0010Û\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Í\u0001\u001a\u00020\u00042\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010Ü\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040®\u00012\u0007\u0010Í\u0001\u001a\u00020\u00042\u0007\u0010Ý\u0001\u001a\u00020\u0004H\u0002J\u001c\u0010Þ\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00172\u0007\u0010Ú\u0001\u001a\u00020\u0004J\u001d\u0010ß\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Í\u0001\u001a\u00020\u00042\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u0004J\"\u0010à\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020)\u0018\u00010\u00172\u0007\u0010Í\u0001\u001a\u00020\u0004H\u0002J\u0010\u0010á\u0001\u001a\u00020W2\u0007\u0010â\u0001\u001a\u00020\u0004J\u0007\u0010ã\u0001\u001a\u00020WJ\u0007\u0010ä\u0001\u001a\u00020WJ\u0007\u0010å\u0001\u001a\u00020WJ\u0007\u0010æ\u0001\u001a\u00020WJ\u0019\u0010ç\u0001\u001a\u00020W2\u0007\u0010Ð\u0001\u001a\u00020\u00042\u0007\u0010è\u0001\u001a\u00020\tJ\u0007\u0010é\u0001\u001a\u00020WJ\u0007\u0010ê\u0001\u001a\u00020WJ\u0007\u0010ë\u0001\u001a\u00020WJ\u0007\u0010ì\u0001\u001a\u00020WJ\u0007\u0010í\u0001\u001a\u00020WJ\u000e\u0010î\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040®\u0001J\u0007\u0010ï\u0001\u001a\u00020WJ\u0007\u0010ð\u0001\u001a\u00020WJ\u0007\u0010ñ\u0001\u001a\u00020WJ\u0007\u0010ò\u0001\u001a\u00020\tJ\u0007\u0010ó\u0001\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R!\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010\u000bR\u0011\u0010$\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b%\u0010\u0007R\u0013\u0010&\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b-\u0010\u0007R\u0013\u0010.\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b/\u0010\u0007R\u0013\u00100\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b1\u0010\u0007R\u0013\u00102\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b3\u0010\u0007R\u0016\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b=\u0010\u0007R\u0013\u0010>\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b?\u0010\u0007R\u0013\u0010@\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bA\u0010\u0007R\u0013\u0010B\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bC\u0010\u0007R\u0013\u0010D\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bE\u0010\u0007R\u0013\u0010F\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bG\u0010\u0007R\u0013\u0010H\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bK\u0010+R\u0013\u0010L\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bM\u0010\u0007R\u0013\u0010N\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bO\u0010\u0007R\u0016\u0010P\u001a\u0004\u0018\u0001058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u00107R\u0011\u0010R\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bS\u0010+R\u0011\u0010T\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bU\u0010+R\u0011\u0010V\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\bV\u0010XR\u0011\u0010Y\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\bY\u0010XR\u0011\u0010Z\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\bZ\u0010XR\u0011\u0010[\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\b[\u0010XR\u0011\u0010\\\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\b\\\u0010XR\u0011\u0010]\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b^\u0010\u000bR\u0011\u0010_\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b`\u0010+R\u0011\u0010a\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bb\u0010+R\u0011\u0010c\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bd\u0010+R\u0013\u0010e\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bf\u0010\u0007R\u0013\u0010g\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bh\u0010\u0007R\u0011\u0010i\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bj\u0010+R\u0011\u0010k\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bl\u0010+R\u0011\u0010m\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bn\u0010+R\u0011\u0010o\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bp\u0010+R\u0013\u0010q\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\br\u0010\u0007R\u0013\u0010s\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bt\u0010\u0007R\u0011\u0010u\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\bv\u0010XR\u0011\u0010w\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bx\u0010\u000bR\u0011\u0010y\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bz\u0010\u000bR\u0011\u0010{\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b|\u0010\u000bR\u0011\u0010}\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b~\u0010\u000bR\u0014\u0010\u007f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0007R\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u0007R\u0015\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0007R\u0015\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\u0007R\u0013\u0010\u0087\u0001\u001a\u00020)8F¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010+R\u0015\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010\u0007R\u0013\u0010\u008b\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u000bR\u0013\u0010\u008d\u0001\u001a\u00020W8F¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010XR\u0013\u0010\u008f\u0001\u001a\u00020)8F¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010+R\u0015\u0010\u0091\u0001\u001a\u00030\u0092\u00018F¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0015\u0010\u0095\u0001\u001a\u00030\u0096\u00018F¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00018F¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0013\u0010\u009d\u0001\u001a\u00020)8F¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010+R\u0015\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b \u0001\u0010\u0007R\u0013\u0010¡\u0001\u001a\u00020W8F¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010XR\u0015\u0010£\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010\u0007R\u0015\u0010¥\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010\u0007R\u0015\u0010§\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010\u0007R\u0015\u0010©\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\bª\u0001\u0010\u0007R\u0013\u0010«\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b¬\u0001\u0010\u000bR\u001b\u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040®\u00018F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0015\u0010±\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b²\u0001\u0010\u0007R\u0015\u0010³\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b´\u0001\u0010\u0007R\u0015\u0010µ\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010\u0007R\u0015\u0010·\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010\u0007R\u0013\u0010¹\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\bº\u0001\u0010\u000bR\u0015\u0010»\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010\u0007R\u0013\u0010½\u0001\u001a\u00020W8F¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010XR\u0015\u0010¿\u0001\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0007\u001a\u0005\bÀ\u0001\u0010\u0007R\u0013\u0010Á\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\bÂ\u0001\u0010\u000bR\u0013\u0010Ã\u0001\u001a\u00020)8F¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010+¨\u0006û\u0001"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskHelper;", "", "()V", "TAG", "", "ageAuthLevel", "getAgeAuthLevel", "()Ljava/lang/String;", "ageAuthLimit", "", "getAgeAuthLimit", "()I", "ageAuthValidDays", "getAgeAuthValidDays", "agreementType", "Lcom/kakaogame/infodesk/InfodeskHelper$AgreementType;", "getAgreementType", "()Lcom/kakaogame/infodesk/InfodeskHelper$AgreementType;", "agreementUrl", "getAgreementUrl", "appLatestVersion", "getAppLatestVersion", "appOption", "", "getAppOption", "()Ljava/util/Map;", "appServiceStatus", "Lcom/kakaogame/infodesk/InfodeskHelper$InfodeskAppServiceStatus;", "getAppServiceStatus", "()Lcom/kakaogame/infodesk/InfodeskHelper$InfodeskAppServiceStatus;", "appUpdateStatus", "Lcom/kakaogame/infodesk/InfodeskHelper$InfodeskAppUpdateStatus;", "getAppUpdateStatus", "()Lcom/kakaogame/infodesk/InfodeskHelper$InfodeskAppUpdateStatus;", "authCodeValidTime", "getAuthCodeValidTime", "benefitString", "getBenefitString", "cSEmail", "getCSEmail", "cachedRequestTerm", "", "getCachedRequestTerm", "()J", "communityUrl", "getCommunityUrl", "customerServiceUrl", "getCustomerServiceUrl", "daumCafeLoginUrl", "getDaumCafeLoginUrl", "daumCafeUrl", "getDaumCafeUrl", "deviceSecurityOption", "Lcom/kakaogame/util/json/JSONObject;", "getDeviceSecurityOption", "()Lcom/kakaogame/util/json/JSONObject;", "deviceSecurityOptionType", "Lcom/kakaogame/infodesk/InfodeskHelper$DeviceSecuritySettingType;", "getDeviceSecurityOptionType", "()Lcom/kakaogame/infodesk/InfodeskHelper$DeviceSecuritySettingType;", "deviceVerifyEncryptKey", "getDeviceVerifyEncryptKey", "emailPublicKey", "getEmailPublicKey", "encryptIV", "getEncryptIV", "encryptKey", "getEncryptKey", "eventProgressWallUrl", "getEventProgressWallUrl", "eventWallUrl", "getEventWallUrl", "eventWinnerUrl", "getEventWinnerUrl", "firstLoginBaseTime", "getFirstLoginBaseTime", "gachaOddsUrl", "getGachaOddsUrl", "getKBSHostUrl", "getGetKBSHostUrl", "getSecondaryPwOption", "getGetSecondaryPwOption", "heartbeatInterval", "getHeartbeatInterval", "initialRequestWaitingTime", "getInitialRequestWaitingTime", "isCheckNewUser", "", "()Z", "isEnable2ndPWSecurity", "isEnableDeviceSecurity", "isReachBoardGame", "isShowInvitationRewardNoReferrer", "keypadValidTime", "getKeypadValidTime", "logFileCount", "getLogFileCount", "logFileSize", "getLogFileSize", "logInterval", "getLogInterval", "logKey", "getLogKey", "marketUrl", "getMarketUrl", "maxRequestWaitingTime", "getMaxRequestWaitingTime", "messageCountCacheSec", "getMessageCountCacheSec", "nextValueToMultiply", "getNextValueToMultiply", "nextValueToSum", "getNextValueToSum", "noticeOnlyUrl", "getNoticeOnlyUrl", "noticeUrl", "getNoticeUrl", "offTermsAgreementPopup", "getOffTermsAgreementPopup", "percentOfSendingAPICallLog", "getPercentOfSendingAPICallLog", "percentOfSendingErrorLog", "getPercentOfSendingErrorLog", "pinFailBlockTime", "getPinFailBlockTime", "pinFailLimitCount", "getPinFailLimitCount", "policyVersion", "getPolicyVersion", "privacySummaryUrl", "getPrivacySummaryUrl", "privacyUrl", "getPrivacyUrl", "publisherId", "getPublisherId", "refreshInfodeskInterval", "getRefreshInfodeskInterval", "registerDeviceUrl", "getRegisterDeviceUrl", "rttSampleRate", "getRttSampleRate", "sdkTraceStopNow", "getSdkTraceStopNow", "sdkTracingMin", "getSdkTracingMin", "secondaryPasswordAuthType", "Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWAuthType;", "getSecondaryPasswordAuthType", "()Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWAuthType;", "secondaryPasswordOptionType", "Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWSettingType;", "getSecondaryPasswordOptionType", "()Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWSettingType;", "serverConnectionType", "Lcom/kakaogame/infodesk/InfodeskHelper$ServerConnectionType;", "getServerConnectionType", "()Lcom/kakaogame/infodesk/InfodeskHelper$ServerConnectionType;", "sesseionTimeout", "getSesseionTimeout", ServerInfo.KEY_SESSION_URL, "getSessionUrl", "skip2ndPassword", "getSkip2ndPassword", "snsInvitationShareGuestUrl", "getSnsInvitationShareGuestUrl", "snsInvitationShareHostUrl", "getSnsInvitationShareHostUrl", "snsInvitationShareUrl", "getSnsInvitationShareUrl", "socialPushMessage", "getSocialPushMessage", "socialPushReceiverCount", "getSocialPushReceiverCount", "supportedIdpCodes", "", "getSupportedIdpCodes", "()Ljava/util/List;", "termsOfServiceUrl", "getTermsOfServiceUrl", "termsOfServiceVer", "getTermsOfServiceVer", "termsSummaryUrl", "getTermsSummaryUrl", "termsUrl", "getTermsUrl", "traceSampleRate", "getTraceSampleRate", "unregisterAgreementUrl", "getUnregisterAgreementUrl", "useCustomMarketRefundUIGooglePlay", "getUseCustomMarketRefundUIGooglePlay", "useKakaoAuthType", "getUseKakaoAuthType", "userAgeCheck", "getUserAgeCheck", "zatRefreshInterval", "getZatRefreshInterval", "checkWarningSDK", "containsKey", UserMetadata.KEYDATA_FILENAME, "", "([Ljava/lang/String;)Z", "infodeskData", "Lcom/kakaogame/infodesk/InfodeskData;", "getBoolean", "key", "defaultValue", "getErrorList", "idpCode", "getInfodeskCacheHour", "data", "getInfodeskDataTime", "getInt", "getLong", "minValue", "maxValue", "getModelList", "getResourceMapData", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "getString", "getStringList", "valueKey", "getStringSet", "getValue", "getVersionMapData", "isCustomDialogDevice", "modelName", "isKakaoGame", "isPlayerOnline", "isUseHttpHeartbeat", "isWhitelist", "isZrtError", "errorCode", "offPromotion3", "offPushAgreementPopup", "offWebViewPopupUI", "offWebviewTopBarYellow", "offWriteLogToFile", "rttCheckUrls", "sendLogFile", "useDaumCafeOldUI", "useGoogleGame", "webviewTitleBgColor", "webviewTitleTextColor", "AgreementType", "DeviceSecuritySettingType", "InfodeskAppServiceStatus", "InfodeskAppUpdateStatus", "SecondaryPWAuthType", "SecondaryPWSettingType", "ServerConnectionType", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InfodeskHelper {
    public static final InfodeskHelper INSTANCE = new InfodeskHelper();
    private static final String TAG = "InfodeskHelper";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InfodeskHelper() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean containsKey(String... keys) {
        Intrinsics.checkNotNullParameter(keys, y.ٲٴݴ״ٰ(1782258616));
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk == null) {
            return false;
        }
        for (String str : infodesk.keySet()) {
            for (String str2 : keys) {
                if (StringsKt.equals(str, str2, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getValue(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        return getString(key, defaultValue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> getAppOption() {
        return getAppOption(CoreManager.INSTANCE.getInstance().getInfodesk());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, Object> getAppOption(InfodeskData infodeskData) {
        if (infodeskData != null) {
            String str = y.֬ڱܱײٮ(-1158780823);
            if (infodeskData.containsKey((Object) str)) {
                return (JSONObject) infodeskData.get((Object) str);
            }
        }
        return new LinkedHashMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isKakaoGame() {
        try {
            String publisherId = getPublisherId();
            if (publisherId != null) {
                return StringsKt.equals(publisherId, "kakao", true);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean useGoogleGame() {
        return StringsKt.equals(y.دײܮڳܯ(2051939573), getString(y.دײܮڳܯ(2051493573), y.ٲٴݴ״ٰ(1781635312)), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getSupportedIdpCodes() {
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList();
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk != null && (jSONArray = (JSONArray) infodesk.get((Object) y.ݮڮֲڭܩ(-628471684))) != null) {
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                Object obj = jSONArray.get(i);
                Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
                arrayList.add((String) obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DeviceSecuritySettingType getDeviceSecurityOptionType() {
        JSONObject jSONObject;
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk != null && (jSONObject = (JSONObject) infodesk.get((Object) y.֬ڱܱײٮ(-1158786015))) != null) {
            String str = (String) jSONObject.get((Object) y.٬ݯح׭٩(576575678));
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return DeviceSecuritySettingType.OPTIONAL;
            }
            if (StringsKt.equals(str, y.دײܮڳܯ(2051477245), true)) {
                return DeviceSecuritySettingType.MANDATORY;
            }
            return DeviceSecuritySettingType.OPTIONAL;
        }
        return DeviceSecuritySettingType.OPTIONAL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isCheckNewUser() {
        Object obj;
        JSONObject deviceSecurityOption = getDeviceSecurityOption();
        if (deviceSecurityOption == null || (obj = deviceSecurityOption.get((Object) y.ݮڮֲڭܩ(-628470084))) == null) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getFirstLoginBaseTime() {
        Number number;
        JSONObject deviceSecurityOption = getDeviceSecurityOption();
        if (deviceSecurityOption == null || (number = (Number) deviceSecurityOption.get((Object) y.ݬֲ֮ܲت(1512517943))) == null) {
            return -1L;
        }
        return number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDeviceVerifyEncryptKey() {
        JSONObject jSONObject;
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk == null || (jSONObject = (JSONObject) infodesk.get((Object) y.֬ڱܱײٮ(-1158790711))) == null) {
            return null;
        }
        return (String) jSONObject.get((Object) y.ݮڮֲڭܩ(-628479692));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isEnable2ndPWSecurity() {
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        return (getSecondaryPwOption == null || getSecondaryPwOption.isEmpty()) ? false : true;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InfodeskHelper.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWAuthType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EMAIL", "SMS", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class SecondaryPWAuthType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SecondaryPWAuthType[] $VALUES;
        public static final SecondaryPWAuthType EMAIL;
        public static final SecondaryPWAuthType SMS;
        private final String value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ SecondaryPWAuthType[] $values() {
            return new SecondaryPWAuthType[]{EMAIL, SMS};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<SecondaryPWAuthType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SecondaryPWAuthType valueOf(String str) {
            return (SecondaryPWAuthType) Enum.valueOf(SecondaryPWAuthType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SecondaryPWAuthType[] values() {
            return (SecondaryPWAuthType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SecondaryPWAuthType(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            String str = y.֬ڱܱײٮ(-1158918911);
            EMAIL = new SecondaryPWAuthType(str, 0, str);
            String str2 = y.ۮڭڭܬި(862609915);
            SMS = new SecondaryPWAuthType(str2, 1, str2);
            SecondaryPWAuthType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InfodeskHelper.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskHelper$SecondaryPWSettingType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MANDATORY", "OPTIONAL", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class SecondaryPWSettingType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SecondaryPWSettingType[] $VALUES;
        public static final SecondaryPWSettingType MANDATORY;
        public static final SecondaryPWSettingType OPTIONAL;
        private final String value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ SecondaryPWSettingType[] $values() {
            return new SecondaryPWSettingType[]{MANDATORY, OPTIONAL};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<SecondaryPWSettingType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SecondaryPWSettingType valueOf(String str) {
            return (SecondaryPWSettingType) Enum.valueOf(SecondaryPWSettingType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SecondaryPWSettingType[] values() {
            return (SecondaryPWSettingType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SecondaryPWSettingType(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            String str = y.دײܮڳܯ(2051477245);
            MANDATORY = new SecondaryPWSettingType(str, 0, str);
            String str2 = y.ۮڭڭܬި(862610899);
            OPTIONAL = new SecondaryPWSettingType(str2, 1, str2);
            SecondaryPWSettingType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final JSONObject getGetSecondaryPwOption() {
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk == null) {
            return null;
        }
        return (JSONObject) infodesk.get((Object) y.ٴسسݬߨ(1393429130));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SecondaryPWSettingType getSecondaryPasswordOptionType() {
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        if (getSecondaryPwOption == null) {
            return SecondaryPWSettingType.OPTIONAL;
        }
        String str = (String) getSecondaryPwOption.get((Object) y.٬ݯح׭٩(576575678));
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return SecondaryPWSettingType.OPTIONAL;
        }
        if (StringsKt.equals(str, SecondaryPWSettingType.MANDATORY.getValue(), true)) {
            return SecondaryPWSettingType.MANDATORY;
        }
        return SecondaryPWSettingType.OPTIONAL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SecondaryPWAuthType getSecondaryPasswordAuthType() {
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        if (getSecondaryPwOption == null) {
            return SecondaryPWAuthType.SMS;
        }
        String str = (String) getSecondaryPwOption.get((Object) y.ۮڭڭܬި(862463915));
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return SecondaryPWAuthType.SMS;
        }
        if (StringsKt.equals(str, SecondaryPWAuthType.EMAIL.getValue(), true)) {
            return SecondaryPWAuthType.EMAIL;
        }
        return SecondaryPWAuthType.SMS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getKeypadValidTime() {
        Number number;
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        if (getSecondaryPwOption == null || (number = (Number) getSecondaryPwOption.get((Object) y.֬ڱܱײٮ(-1158788303))) == null) {
            return -1;
        }
        return number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPinFailBlockTime() {
        Number number;
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        if (getSecondaryPwOption == null || (number = (Number) getSecondaryPwOption.get((Object) y.ٲٴݴ״ٰ(1782281816))) == null) {
            return -1;
        }
        return number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPinFailLimitCount() {
        Number number;
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        if (getSecondaryPwOption == null || (number = (Number) getSecondaryPwOption.get((Object) y.ٲٴݴ״ٰ(1782281944))) == null) {
            return -1;
        }
        return number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getAuthCodeValidTime() {
        Number number;
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        if (getSecondaryPwOption == null || (number = (Number) getSecondaryPwOption.get((Object) y.ݬֲ֮ܲت(1512516599))) == null) {
            return -1;
        }
        return number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBenefitString() {
        String str;
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        return (getSecondaryPwOption == null || (str = (String) getSecondaryPwOption.get((Object) y.ۮڭڭܬި(862611515))) == null) ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getSkip2ndPassword() {
        JSONObject getSecondaryPwOption = getGetSecondaryPwOption();
        if (getSecondaryPwOption == null) {
            return true;
        }
        Object obj = getSecondaryPwOption.get((Object) y.٬ݯح׭٩(576562358));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgreementType getAgreementType() {
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk == null) {
            return null;
        }
        String str = (String) infodesk.get((Object) y.ۮڭڭܬި(862613275));
        for (AgreementType agreementType : AgreementType.values()) {
            if (StringsKt.equals(agreementType.name(), str, true)) {
                return agreementType;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerConnectionType getServerConnectionType() {
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk == null) {
            return null;
        }
        String str = (String) infodesk.get((Object) y.ݮڮֲڭܩ(-628468900));
        for (ServerConnectionType serverConnectionType : ServerConnectionType.values()) {
            if (StringsKt.equals(serverConnectionType.name(), str, true)) {
                return serverConnectionType;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InfodeskAppUpdateStatus getAppUpdateStatus() {
        String string = getString(y.ݮڮֲڭܩ(-628477012), y.٬ݯح׭٩(576571886));
        for (InfodeskAppUpdateStatus infodeskAppUpdateStatus : InfodeskAppUpdateStatus.values()) {
            if (StringsKt.equals(infodeskAppUpdateStatus.getValue(), string, true)) {
                return infodeskAppUpdateStatus;
            }
        }
        return InfodeskAppUpdateStatus.LATEST;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InfodeskAppServiceStatus getAppServiceStatus() {
        String string = getString(y.دײܮڳܯ(2051474901), y.ۮڭڭܬި(862610435));
        for (InfodeskAppServiceStatus infodeskAppServiceStatus : InfodeskAppServiceStatus.values()) {
            if (StringsKt.equals(infodeskAppServiceStatus.getValue(), string, true)) {
                return infodeskAppServiceStatus;
            }
        }
        return InfodeskAppServiceStatus.READY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final JSONObject getDeviceSecurityOption() {
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk == null) {
            return null;
        }
        return (JSONObject) infodesk.get((Object) y.֬ڱܱײٮ(-1158786015));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isEnableDeviceSecurity() {
        if (getDeviceSecurityOption() != null) {
            return !r0.isEmpty();
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRegisterDeviceUrl() {
        return getString(y.ݮڮֲڭܩ(-628469588), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEmailPublicKey() {
        return getString(y.ݮڮֲڭܩ(-628479500), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTraceSampleRate() {
        return getInt(y.ٲٴݴ״ٰ(1782276568), 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRttSampleRate() {
        return getInt(y.٬ݯح׭٩(576561574), 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getSdkTraceStopNow() {
        return containsKey(y.ۮڭڭܬި(862588731));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getSdkTracingMin() {
        return getLong(y.ٲٴݴ״ٰ(1782282624), 180L, 1L, 4320L) * 60 * 1000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMarketUrl() {
        String string = getString(y.٬ݯح׭٩(575819902), null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return StringsKt.equals(y.ݬֲ֮ܲت(1512519967), CoreManager.INSTANCE.getInstance().getConfiguration().getMarket(), true) ? y.٬ݯح׭٩(576575190) + AndroidManifestUtil.getPackageName(CoreManager.INSTANCE.getInstance().getContext()) : string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPlayerOnline() {
        return containsKey(y.ݮڮֲڭܩ(-628473796));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isShowInvitationRewardNoReferrer() {
        return containsKey(y.ݬֲ֮ܲت(1512529343));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isUseHttpHeartbeat() {
        return containsKey(y.ݮڮֲڭܩ(-628473212));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isWhitelist() {
        return getBoolean(y.֬ڱܱײٮ(-1158929071), false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCSEmail() {
        return getString(y.ݬֲ֮ܲت(1512516327), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAppLatestVersion() {
        return getString(y.ٴسسݬߨ(1393428298), y.٬ݯح׭٩(576570206));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSessionUrl() {
        return getString(y.ۮڭڭܬި(862587147), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSnsInvitationShareUrl() {
        return getString(y.دײܮڳܯ(2051498109), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSnsInvitationShareHostUrl() {
        return getString(y.ٲٴݴ״ٰ(1782283920), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSnsInvitationShareGuestUrl() {
        return getString(y.ٴسسݬߨ(1393451178), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getSesseionTimeout() {
        return getLong(y.ݮڮֲڭܩ(-628468756), 20000L, 5000L, 20000L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getHeartbeatInterval() {
        return getLong(y.٬ݯح׭٩(576573494), 120000L, 120000L, DateUtils.MILLIS_PER_HOUR);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getCachedRequestTerm() {
        return getLong(y.ٴسسݬߨ(1393426842), 3000L, 3000L, 120000L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPercentOfSendingAPICallLog() {
        return getInt(y.ۮڭڭܬި(862586539), 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getPercentOfSendingErrorLog() {
        return getInt(y.ٴسسݬߨ(1393453090), 100);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getLogInterval() {
        return getLong(y.ݬֲ֮ܲت(1512520719), 30000L, 30000L, 30000L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getUserAgeCheck() {
        return getInt(y.ٲٴݴ״ٰ(1782277800) + CoreManager.INSTANCE.getInstance().getConfiguration().getMarket(), -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isReachBoardGame() {
        return StringsKt.equals(y.ٲٴݴ״ٰ(1782278784), getString(y.֬ڱܱײٮ(-1158796855), y.֬ڱܱײٮ(-1158797215)), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getAgeAuthLimit() {
        return getInt(y.دײܮڳܯ(2051475261), 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAgeAuthLevel() {
        return getString(y.٬ݯح׭٩(576569582), y.ۮڭڭܬި(862123667));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getAgeAuthValidDays() {
        return getInt(y.ݬֲ֮ܲت(1512517127), 365);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPublisherId() {
        return getString(y.ݬֲ֮ܲت(1512521775), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTermsUrl() {
        return getString(y.ݬֲ֮ܲت(1512527335), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTermsSummaryUrl() {
        return getString(y.ٲٴݴ״ٰ(1782276832), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPrivacyUrl() {
        return getString(y.ٲٴݴ״ٰ(1782281280), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPrivacySummaryUrl() {
        return getString(y.٬ݯح׭٩(576564878), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPolicyVersion() {
        return getString(y.֬ڱܱײٮ(-1158793383), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCustomerServiceUrl() {
        return getString(y.٬ݯح׭٩(576571174), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNoticeUrl() {
        return getString(y.٬ݯح׭٩(576563894), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNoticeOnlyUrl() {
        return getString(y.ٴسسݬߨ(1393454714), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEventWallUrl() {
        return getString(y.ٲٴݴ״ٰ(1782253224), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEventProgressWallUrl() {
        return getString(y.دײܮڳܯ(2051480413), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getGachaOddsUrl() {
        return getString(y.ݮڮֲڭܩ(-628478180), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDaumCafeLoginUrl() {
        return getString(y.ٲٴݴ״ٰ(1782258848), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDaumCafeUrl() {
        return getString(y.ٴسسݬߨ(1393433722), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEventWinnerUrl() {
        return getString(y.ۮڭڭܬި(862614299), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getRefreshInfodeskInterval() {
        return getLong(y.ݬֲ֮ܲت(1512525703), 5L, 1L, 60L) * 60 * 1000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getMessageCountCacheSec() {
        return getLong(y.֬ڱܱײٮ(-1158794895), 0L, 0L, 600L) * 1000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getInfodeskCacheHour(InfodeskData data) {
        String str = y.֬ڱܱײٮ(-1158788703);
        Map<String, Object> appOption = getAppOption(data);
        Intrinsics.checkNotNull(appOption);
        if (!appOption.containsKey(str)) {
            long j = 60;
            return 24 * j * j * 1000;
        }
        long j2 = getLong(getAppOption(data), str, 24L, 0L, 8760L);
        long j3 = 60;
        return j2 * j3 * j3 * 1000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getInfodeskDataTime(InfodeskData data) {
        return getLong(data, y.ٴسسݬߨ(1393438954), 0L, 0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTermsOfServiceVer() {
        return getString(y.٬ݯح׭٩(576567662), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTermsOfServiceUrl() {
        return getString(y.֬ڱܱײٮ(-1158798855), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAgreementUrl() {
        return getString(y.ݮڮֲڭܩ(-628477196), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUnregisterAgreementUrl() {
        return getString(y.٬ݯح׭٩(576568166), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCommunityUrl() {
        return getString(y.دײܮڳܯ(2051473453), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSocialPushMessage() {
        return getString(y.٬ݯح׭٩(576562758), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getSocialPushReceiverCount() {
        return getInt(y.֬ڱܱײٮ(-1158791631), -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getZatRefreshInterval() {
        return getLong(y.ۮڭڭܬި(862589699), 360L, 120L, 660L) * 60 * 1000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long checkWarningSDK() {
        Map<String, Long> versionMapData = getVersionMapData(y.ۮڭڭܬި(862612859));
        if (versionMapData == null) {
            return -1L;
        }
        String str = y.ݮڮֲڭܩ(-628603604);
        if (!versionMapData.containsKey(str)) {
            return -1L;
        }
        Long l = versionMapData.get(str);
        Intrinsics.checkNotNull(l);
        return l.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUseKakaoAuthType() {
        return getString(y.ۮڭڭܬި(862588955), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getUseCustomMarketRefundUIGooglePlay() {
        return containsKey(y.ۮڭڭܬި(862589219));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getMaxRequestWaitingTime() {
        return getLong(y.ٲٴݴ״ٰ(1782254720), 60L, 10L, 600L) * 1000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getInitialRequestWaitingTime() {
        return getLong(y.ۮڭڭܬި(862616579), 1L, 1L, 10L) * 1000;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getNextValueToMultiply() {
        return getLong(y.ۮڭڭܬި(862586315), 2L, 1L, 100L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getNextValueToSum() {
        return getLong(y.٬ݯح׭٩(576563606), 0L, 0L, 100L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getLogFileSize() {
        return getLong(y.دײܮڳܯ(2051478877), 1L, 1L, 5L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getLogFileCount() {
        return getLong(y.٬ݯح׭٩(576574094), 5L, 5L, 20L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean sendLogFile() {
        return StringsKt.equals(y.دײܮڳܯ(2051939573), getString(y.֬ڱܱײٮ(-1158795711), y.ٲٴݴ״ٰ(1781635312)), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean offWebViewPopupUI() {
        return containsKey(y.ۮڭڭܬި(862591435));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean useDaumCafeOldUI() {
        return StringsKt.equals(y.دײܮڳܯ(2051493629), getString(y.ݮڮֲڭܩ(-628471884), y.ݮڮֲڭܩ(-628459468)), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean offPromotion3() {
        return containsKey(y.ݮڮֲڭܩ(-628472932));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean offPushAgreementPopup() {
        return containsKey(y.ٲٴݴ״ٰ(1782280016));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean offWebviewTopBarYellow() {
        return containsKey(y.ٴسسݬߨ(1393455578));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int webviewTitleBgColor() {
        return getInt(y.ٴسسݬߨ(1393446258), -12698050);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int webviewTitleTextColor() {
        return getInt(y.دײܮڳܯ(2051493797), -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean offWriteLogToFile() {
        return StringsKt.equals(y.دײܮڳܯ(2051939573), getString(y.ۮڭڭܬި(862591859), y.ٲٴݴ״ٰ(1781635312)), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getStringSet(String languageCode) {
        Intrinsics.checkNotNullParameter(languageCode, y.ݬֲ֮ܲت(1512397151));
        return getResourceMapData(y.ݮڮֲڭܩ(-628467836), languageCode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isCustomDialogDevice(String modelName) {
        Intrinsics.checkNotNullParameter(modelName, y.ٴسسݬߨ(1393457962));
        List<String> modelList = getModelList(y.ٴسسݬߨ(1393458066));
        if (modelList.isEmpty()) {
            return false;
        }
        return modelList.contains(modelName);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isZrtError(String idpCode, int errorCode) {
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        List<Integer> errorList = getErrorList(y.ٲٴݴ״ٰ(1782278256), idpCode);
        if (errorList.isEmpty()) {
            return false;
        }
        return errorList.contains(Integer.valueOf(errorCode));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> rttCheckUrls() {
        return getStringList(y.ۮڭڭܬި(862591979), y.ݬֲ֮ܲت(1512528087));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getString(String key, String defaultValue) {
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk != null) {
            for (String str : infodesk.keySet()) {
                if (StringsKt.equals(str, key, true)) {
                    return (String) infodesk.get((Object) str);
                }
            }
        }
        return defaultValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean getBoolean(String key, boolean defaultValue) {
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk != null) {
            for (String str : infodesk.keySet()) {
                if (StringsKt.equals(str, key, true)) {
                    Object obj = infodesk.get((Object) str);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    return ((Boolean) obj).booleanValue();
                }
            }
        }
        return defaultValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int getInt(String key, int defaultValue) {
        String str = y.٬ݯح׭٩(576592158);
        String str2 = y.دײܮڳܯ(2051829341);
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk == null) {
            return defaultValue;
        }
        for (String str3 : infodesk.keySet()) {
            if (StringsKt.equals(str3, key, true)) {
                Object obj = infodesk.get((Object) str3);
                if (obj instanceof Number) {
                    return ((Number) obj).intValue();
                }
                if (!(obj instanceof String)) {
                    return defaultValue;
                }
                try {
                    if (StringsKt.startsWith$default((String) obj, str2, false, 2, (Object) null)) {
                        String replaceFirst = new Regex(str2).replaceFirst((CharSequence) obj, "");
                        if (replaceFirst.length() > 8) {
                            return defaultValue;
                        }
                        if (replaceFirst.length() == 8) {
                            String substring = replaceFirst.substring(0, 2);
                            Intrinsics.checkNotNullExpressionValue(substring, str);
                            String substring2 = replaceFirst.substring(2);
                            Intrinsics.checkNotNullExpressionValue(substring2, str);
                            return (Integer.parseInt(substring, CharsKt.checkRadix(16)) << 24) + Integer.parseInt(substring2, CharsKt.checkRadix(16));
                        }
                        return Integer.parseInt(replaceFirst, CharsKt.checkRadix(16));
                    }
                    return Integer.parseInt((String) obj);
                } catch (NumberFormatException unused) {
                    return defaultValue;
                }
            }
        }
        return defaultValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final long getLong(String key, long defaultValue, long minValue, long maxValue) {
        return getLong(CoreManager.INSTANCE.getInstance().getInfodesk(), key, defaultValue, minValue, maxValue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final long getLong(Map<String, ? extends Object> infodeskData, String key, long defaultValue, long minValue, long maxValue) {
        if (infodeskData != null) {
            for (String str : infodeskData.keySet()) {
                if (StringsKt.equals(str, key, true)) {
                    Object obj = infodeskData.get(str);
                    if (obj instanceof Number) {
                        defaultValue = ((Number) obj).longValue();
                    } else if (obj instanceof String) {
                        try {
                            defaultValue = Long.parseLong((String) obj);
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return defaultValue < minValue ? minValue : defaultValue > maxValue ? maxValue : defaultValue;
                }
            }
        }
        return defaultValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, Long> getVersionMapData(String key) {
        long j;
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk != null) {
            Iterator<String> it = infodesk.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (StringsKt.equals(next, key, true)) {
                    Object obj = infodesk.get((Object) next);
                    if (obj instanceof JSONArray) {
                        HashMap hashMap = new HashMap();
                        Iterator<Object> it2 = ((JSONArray) obj).iterator();
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            if (next2 instanceof JSONObject) {
                                JSONObject jSONObject = (JSONObject) next2;
                                String str = (String) jSONObject.get((Object) y.ٴسسݬߨ(1393427546));
                                String str2 = y.ݮڮֲڭܩ(-628641140);
                                if (jSONObject.containsKey((Object) str2)) {
                                    Long l = (Long) jSONObject.get((Object) str2);
                                    Intrinsics.checkNotNull(l);
                                    j = l.longValue();
                                } else {
                                    j = 0;
                                }
                                hashMap.put(str, Long.valueOf(j));
                            }
                        }
                        return hashMap;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, String> getResourceMapData(String key, String languageCode) {
        String str = y.ٴسسݬߨ(1392813258);
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        HashMap hashMap = new HashMap();
        if (infodesk == null) {
            return hashMap;
        }
        loop0: for (String str2 : infodesk.keySet()) {
            if (StringsKt.equals(str2, key, true)) {
                String str3 = (String) infodesk.get((Object) str2);
                Intrinsics.checkNotNull(str3);
                String replace = new Regex(y.ۮڭڭܬި(862200203)).replace(str3, y.دײܮڳܯ(2051949821));
                Logger logger = Logger.INSTANCE;
                String str4 = y.ۮڭڭܬި(862610011) + replace;
                String str5 = y.٬ݯح׭٩(576573030);
                logger.m699d(str5, str4);
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(replace);
                    if (!jSONObject.has(str)) {
                        break;
                    }
                    Object obj = jSONObject.get(str);
                    org.json.JSONObject jSONObject2 = obj instanceof org.json.JSONObject ? (org.json.JSONObject) obj : null;
                    if (jSONObject2 == null || !jSONObject2.has(languageCode)) {
                        break;
                    }
                    Object obj2 = jSONObject2.get(languageCode);
                    org.json.JSONObject jSONObject3 = obj2 instanceof org.json.JSONObject ? (org.json.JSONObject) obj2 : null;
                    if (jSONObject3 != null) {
                        Iterator<String> keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            Intrinsics.checkNotNull(next);
                            Object obj3 = jSONObject3.get(next);
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                            hashMap.put(next, (String) obj3);
                        }
                        break loop0;
                    }
                    break;
                } catch (JSONException e) {
                    Logger.INSTANCE.m701e(str5, y.ۮڭڭܬި(862609659) + e);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final List<String> getModelList(String key) {
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        ArrayList arrayList = new ArrayList();
        if (infodesk != null) {
            Iterator<String> it = infodesk.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (StringsKt.equals(it.next(), key, true)) {
                    Object obj = infodesk.get((Object) key);
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int size = jSONArray.size();
                        for (int i = 0; i < size; i++) {
                            Object obj2 = jSONArray.get(i);
                            Intrinsics.checkNotNull(obj2, y.ݬֲ֮ܲت(1512814407));
                            arrayList.add((String) obj2);
                        }
                    } else if (obj instanceof String) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final List<Integer> getErrorList(String key, String idpCode) {
        String string = getString(key, "");
        ArrayList arrayList = new ArrayList();
        String str = string;
        if (str == null || str.length() == 0) {
            return arrayList;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(string);
            if (jSONObject.has(idpCode)) {
                Object obj = jSONObject.get(idpCode);
                org.json.JSONArray jSONArray = obj instanceof org.json.JSONArray ? (org.json.JSONArray) obj : null;
                if (jSONArray == null) {
                    return arrayList;
                }
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    Object obj2 = jSONArray.get(i);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Number");
                    arrayList.add(Integer.valueOf(((Number) obj2).intValue()));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.INSTANCE.m701e(y.٬ݯح׭٩(576573030), y.ۮڭڭܬި(862609659) + e);
            return arrayList;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final List<String> getStringList(String key, String valueKey) {
        String string = getString(key, "");
        ArrayList arrayList = new ArrayList();
        String str = string;
        if (str == null || str.length() == 0) {
            return arrayList;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(string);
            if (jSONObject.has(valueKey)) {
                Object obj = jSONObject.get(valueKey);
                org.json.JSONArray jSONArray = obj instanceof org.json.JSONArray ? (org.json.JSONArray) obj : null;
                if (jSONArray == null) {
                    return arrayList;
                }
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    Object obj2 = jSONArray.get(i);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    arrayList.add((String) obj2);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.INSTANCE.m701e(y.٬ݯح׭٩(576573030), y.ۮڭڭܬި(862609659) + e);
            return arrayList;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEncryptKey() {
        return getString(y.٬ݯح׭٩(576576414), y.ٲٴݴ״ٰ(1782253360));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEncryptIV() {
        return getString(y.دײܮڳܯ(2051480645), y.ݬֲ֮ܲت(1512518975));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLogKey() {
        return getString(y.ۮڭڭܬި(862615811), y.֬ڱܱײٮ(-1158787767));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getOffTermsAgreementPopup() {
        return containsKey(y.ݮڮֲڭܩ(-628467060));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getGetKBSHostUrl() {
        return getString(y.ݮڮֲڭܩ(-628477972), "");
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InfodeskHelper.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskHelper$AgreementType;", "", "(Ljava/lang/String;I)V", BuildConfig.SDK_BUILD_TYPE, "channeling", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class AgreementType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AgreementType[] $VALUES;
        public static final AgreementType publishing = new AgreementType(y.ٴسسݬߨ(1393439634), 0);
        public static final AgreementType channeling = new AgreementType(y.֬ڱܱײٮ(-1158786799), 1);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ AgreementType[] $values() {
            return new AgreementType[]{publishing, channeling};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<AgreementType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static AgreementType valueOf(String str) {
            return (AgreementType) Enum.valueOf(AgreementType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static AgreementType[] values() {
            return (AgreementType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AgreementType(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            AgreementType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InfodeskHelper.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskHelper$ServerConnectionType;", "", "(Ljava/lang/String;I)V", "wss", "https", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class ServerConnectionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ServerConnectionType[] $VALUES;
        public static final ServerConnectionType wss = new ServerConnectionType(y.ٴسسݬߨ(1393428650), 0);
        public static final ServerConnectionType https = new ServerConnectionType(y.٬ݯح׭٩(576050958), 1);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ ServerConnectionType[] $values() {
            return new ServerConnectionType[]{wss, https};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<ServerConnectionType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServerConnectionType valueOf(String str) {
            return (ServerConnectionType) Enum.valueOf(ServerConnectionType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ServerConnectionType[] values() {
            return (ServerConnectionType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ServerConnectionType(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            ServerConnectionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InfodeskHelper.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskHelper$InfodeskAppUpdateStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LATEST", "UPDATE_RECOMMEND", "UPDATE_REQUIRED", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class InfodeskAppUpdateStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InfodeskAppUpdateStatus[] $VALUES;
        public static final InfodeskAppUpdateStatus LATEST = new InfodeskAppUpdateStatus(y.دײܮڳܯ(2051476525), 0, y.٬ݯح׭٩(576571886));
        public static final InfodeskAppUpdateStatus UPDATE_RECOMMEND = new InfodeskAppUpdateStatus(y.֬ڱܱײٮ(-1158786551), 1, y.ٲٴݴ״ٰ(1782256008));
        public static final InfodeskAppUpdateStatus UPDATE_REQUIRED = new InfodeskAppUpdateStatus(y.٬ݯح׭٩(576572534), 2, y.ٴسسݬߨ(1393430426));
        private final String value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ InfodeskAppUpdateStatus[] $values() {
            return new InfodeskAppUpdateStatus[]{LATEST, UPDATE_RECOMMEND, UPDATE_REQUIRED};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<InfodeskAppUpdateStatus> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static InfodeskAppUpdateStatus valueOf(String str) {
            return (InfodeskAppUpdateStatus) Enum.valueOf(InfodeskAppUpdateStatus.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static InfodeskAppUpdateStatus[] values() {
            return (InfodeskAppUpdateStatus[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InfodeskAppUpdateStatus(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            InfodeskAppUpdateStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InfodeskHelper.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskHelper$InfodeskAppServiceStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "READY", "OPEN", "CLOSE", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class InfodeskAppServiceStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InfodeskAppServiceStatus[] $VALUES;
        private final String value;
        public static final InfodeskAppServiceStatus READY = new InfodeskAppServiceStatus(y.ٴسسݬߨ(1393429810), 0, y.ۮڭڭܬި(862610435));
        public static final InfodeskAppServiceStatus OPEN = new InfodeskAppServiceStatus(y.֬ڱܱײٮ(-1159671903), 1, y.ٴسسݬߨ(1392546450));
        public static final InfodeskAppServiceStatus CLOSE = new InfodeskAppServiceStatus(y.ۮڭڭܬި(862485451), 2, y.ݬֲ֮ܲت(1512515135));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ InfodeskAppServiceStatus[] $values() {
            return new InfodeskAppServiceStatus[]{READY, OPEN, CLOSE};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<InfodeskAppServiceStatus> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static InfodeskAppServiceStatus valueOf(String str) {
            return (InfodeskAppServiceStatus) Enum.valueOf(InfodeskAppServiceStatus.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static InfodeskAppServiceStatus[] values() {
            return (InfodeskAppServiceStatus[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InfodeskAppServiceStatus(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            InfodeskAppServiceStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InfodeskHelper.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskHelper$DeviceSecuritySettingType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MANDATORY", "OPTIONAL", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class DeviceSecuritySettingType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DeviceSecuritySettingType[] $VALUES;
        public static final DeviceSecuritySettingType MANDATORY;
        public static final DeviceSecuritySettingType OPTIONAL;
        private final String value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ DeviceSecuritySettingType[] $values() {
            return new DeviceSecuritySettingType[]{MANDATORY, OPTIONAL};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<DeviceSecuritySettingType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DeviceSecuritySettingType valueOf(String str) {
            return (DeviceSecuritySettingType) Enum.valueOf(DeviceSecuritySettingType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static DeviceSecuritySettingType[] values() {
            return (DeviceSecuritySettingType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DeviceSecuritySettingType(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            String str = y.دײܮڳܯ(2051477245);
            MANDATORY = new DeviceSecuritySettingType(str, 0, str);
            String str2 = y.ۮڭڭܬި(862610899);
            OPTIONAL = new DeviceSecuritySettingType(str2, 1, str2);
            DeviceSecuritySettingType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
