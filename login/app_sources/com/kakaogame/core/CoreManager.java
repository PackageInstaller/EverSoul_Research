package com.kakaogame.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.webkit.CookieManager;
import androidx.core.app.NotificationCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakao.sdk.partner.user.Constants;
import com.kakaogame.KGCustomUI;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGMarketRefundInfo;
import com.kakaogame.KGMessage;
import com.kakaogame.KGResult;
import com.kakaogame.KGSNSShare;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.auth.AuthImpl;
import com.kakaogame.auth.AuthService;
import com.kakaogame.auth.LoginData;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.idp.IdpAuthManager;
import com.kakaogame.infodesk.InfodeskData;
import com.kakaogame.infodesk.InfodeskDataCache;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.infodesk.InfodeskNoticeManager;
import com.kakaogame.infodesk.InfodeskService;
import com.kakaogame.invite.InviteDataManager;
import com.kakaogame.leaderboard.LeaderboardService;
import com.kakaogame.lifecycle.LifecycleService;
import com.kakaogame.log.APILogManager;
import com.kakaogame.log.ErrorLogManager;
import com.kakaogame.log.IFirebase;
import com.kakaogame.log.PlayerLogManager;
import com.kakaogame.log.SDKLogManager;
import com.kakaogame.log.service.BasicLogService;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.manager.SdkManager;
import com.kakaogame.p029ui.AppUpdateManager;
import com.kakaogame.p029ui.CustomUIManager;
import com.kakaogame.player.LocalPlayer;
import com.kakaogame.player.LocalPlayerService;
import com.kakaogame.player.PlayerService;
import com.kakaogame.promotion.PromotionService;
import com.kakaogame.promotion.SNSShareData;
import com.kakaogame.promotion.share.ScreenShotDialog;
import com.kakaogame.push.OnlinePushManager;
import com.kakaogame.push.PushService;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.PresenceService;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CoreManager.kt */
@Metadata(m838d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ã\u00012\u00020\u0001:\u0006ã\u0001ä\u0001å\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020)J\u0016\u0010o\u001a\u00020m2\u0006\u0010p\u001a\u0002062\u0006\u0010q\u001a\u00020\u0004J(\u0010r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0s2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010u\u001a\u00020@2\u0006\u0010v\u001a\u000206J(\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0s2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010x\u001a\u00020@2\u0006\u0010v\u001a\u000206J2\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0s2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010z\u001a\u00020@2\u0006\u0010x\u001a\u00020@2\u0006\u0010v\u001a\u000206H\u0002J\u000e\u0010{\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0sJ\b\u0010|\u001a\u00020mH\u0002J\u0006\u0010}\u001a\u00020mJ\u0006\u0010~\u001a\u00020mJ*\u0010\u007f\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010s2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010u\u001a\u00020@2\u0006\u0010v\u001a\u000206J\u0007\u0010\u0082\u0001\u001a\u00020cJ\u0007\u0010\u0083\u0001\u001a\u000206J\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010fJ+\u0010\u0086\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010s2\u0006\u0010\u0007\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u0001082\u0007\u0010\u0087\u0001\u001a\u00020@J\u0011\u0010\u0088\u0001\u001a\u00020@2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u001a\u0010\u008b\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010s2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0007\u0010\u008c\u0001\u001a\u00020mJ \u0010\u008d\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010s2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000f\u0010\u008e\u0001\u001a\u00020m2\u0006\u0010!\u001a\u00020\"J\t\u0010\u008f\u0001\u001a\u00020mH\u0002J\u0016\u0010\u0090\u0001\u001a\u00020@2\r\u0010\u0091\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010sJ\u0018\u0010\u0092\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080s2\u0007\u0010\u0087\u0001\u001a\u00020@J)\u0010\u0093\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0s2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010u\u001a\u00020@2\u0006\u0010v\u001a\u000206H\u0002J\u0010\u0010\u0094\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010sJ\u0007\u0010\u0095\u0001\u001a\u00020mJ\u0012\u0010\u0096\u0001\u001a\u00020m2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0004J%\u0010\u0098\u0001\u001a\u00020m2\b\u00109\u001a\u0004\u0018\u0001082\u0007\u0010\u0099\u0001\u001a\u00020@2\u0007\u0010\u0087\u0001\u001a\u00020@H\u0002J/\u0010\u009a\u0001\u001a\u00020m2\u0007\u0010\u009b\u0001\u001a\u00020Z2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010t2\u0006\u0010u\u001a\u00020@H\u0002J \u0010\u009d\u0001\u001a\u00020m2\u000b\u0010\u0091\u0001\u001a\u0006\u0012\u0002\b\u00030s2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u000f\u0010\u009e\u0001\u001a\u00020m2\u0006\u0010^\u001a\u00020\u0004J\u0011\u0010\u009f\u0001\u001a\u00020m2\u0006\u0010^\u001a\u00020\u0004H\u0002J\u0010\u0010 \u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010sJ\t\u0010¡\u0001\u001a\u00020mH\u0002J\u0011\u0010¢\u0001\u001a\u00020m2\b\u0010n\u001a\u0004\u0018\u000100J\u000f\u0010£\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0sJ\u001a\u0010¤\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010s2\b\b\u0002\u0010v\u001a\u000206J\u001f\u0010¥\u0001\u001a\u00020m2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001J\u000f\u0010¨\u0001\u001a\u00020m2\u0006\u0010n\u001a\u00020)J_\u0010©\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010+0s2\u0007\u0010ª\u0001\u001a\u00020\u00042\u0017\u0010«\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010+2\u0017\u0010¬\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010+2\u0007\u0010\u00ad\u0001\u001a\u00020cJ3\u0010®\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0s2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010z\u001a\u00020@2\u0006\u0010x\u001a\u00020@2\u0006\u0010v\u001a\u000206H\u0002J\t\u0010¯\u0001\u001a\u00020mH\u0002J\u0012\u0010°\u0001\u001a\u00020m2\t\u0010±\u0001\u001a\u0004\u0018\u00010\u0004J\u0010\u0010²\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010sJ\u0007\u0010³\u0001\u001a\u00020mJ\u000f\u0010x\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010sJ\u0007\u0010´\u0001\u001a\u00020mJ\u0010\u0010µ\u0001\u001a\u00020m2\u0007\u0010¶\u0001\u001a\u000206J\u0007\u0010·\u0001\u001a\u00020mJ&\u0010¸\u0001\u001a\u00020m2\u0007\u0010¹\u0001\u001a\u00020\u00042\u0007\u0010º\u0001\u001a\u00020\u00042\u000b\u0010»\u0001\u001a\u0006\u0012\u0002\b\u00030sJ\u0012\u0010¼\u0001\u001a\u00020m2\t\u0010½\u0001\u001a\u0004\u0018\u00010\u001aJ\t\u0010¾\u0001\u001a\u00020mH\u0002J\u0007\u0010¿\u0001\u001a\u00020mJ\u0010\u0010À\u0001\u001a\u00020m2\u0007\u0010Á\u0001\u001a\u000206J\t\u0010Â\u0001\u001a\u00020mH\u0002J\t\u0010Ã\u0001\u001a\u00020mH\u0002J\u0013\u0010Ä\u0001\u001a\u00020m2\n\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001J\u0010\u0010Ç\u0001\u001a\u00020m2\u0007\u0010È\u0001\u001a\u00020cJ\u001b\u0010É\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010Ê\u0001\u001a\u00030Ë\u0001J\u0010\u0010Ì\u0001\u001a\u0002062\u0007\u0010Í\u0001\u001a\u00020\u0004J%\u0010Î\u0001\u001a\u0002062\u0007\u0010Í\u0001\u001a\u00020\u00042\u0013\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040+J\t\u0010Ð\u0001\u001a\u00020mH\u0002J>\u0010Ñ\u0001\u001a\u00020m2\u0006\u0010\u0007\u001a\u00020\b2\u0007\u0010Ò\u0001\u001a\u00020\u00042\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Ô\u0001\u001a\u00020c2\u0007\u0010Õ\u0001\u001a\u00020c2\u0007\u0010Ö\u0001\u001a\u00020cJ\t\u0010×\u0001\u001a\u00020mH\u0002J\u0007\u0010Ø\u0001\u001a\u00020mJ\u001d\u0010Ù\u0001\u001a\u00020m2\u0006\u0010p\u001a\u0002062\f\u0010»\u0001\u001a\u0007\u0012\u0002\b\u00030Ú\u0001J$\u0010Û\u0001\u001a\u00020m2\u0006\u0010p\u001a\u0002062\u0013\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040+J\t\u0010Ü\u0001\u001a\u00020mH\u0002J\u0010\u0010Ý\u0001\u001a\u00020m2\u0007\u0010Ò\u0001\u001a\u00020\u0004J\t\u0010Þ\u0001\u001a\u00020mH\u0002J\u0010\u0010ß\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010sJ\u0010\u0010à\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010sJ\u001a\u0010à\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010s2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0011\u0010á\u0001\u001a\u00020m2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\t\u0010â\u0001\u001a\u00020mH\u0004R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00101\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b2\u0010\u0006R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00109\u001a\u0004\u0018\u0001082\b\u00107\u001a\u0004\u0018\u000108@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\b?\u0010AR\u0011\u0010B\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bB\u0010AR\u001a\u0010C\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010A\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020@2\u0006\u00107\u001a\u00020@@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010AR\u0011\u0010G\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bG\u0010AR\u001e\u0010H\u001a\u00020@2\u0006\u00107\u001a\u00020@@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010AR\u001e\u0010I\u001a\u00020@2\u0006\u00107\u001a\u00020@@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010AR\u001e\u0010J\u001a\u00020@2\u0006\u00107\u001a\u00020@@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010AR\u0010\u0010K\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010N\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\b\u0012\u0002\b\u0003\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010[\u001a\u0004\u0018\u00010Z2\b\u00107\u001a\u0004\u0018\u00010Z@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010^\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b_\u0010\u0006R\u0011\u0010`\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\ba\u0010\u0006R\u000e\u0010b\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010g\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bh\u0010AR\u000e\u0010i\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006æ\u0001"}, m839d2 = {"Lcom/kakaogame/core/CoreManager;", "", "()V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activityHolder", "Lkotlin/Function0;", "getActivityHolder", "()Lkotlin/jvm/functions/Function0;", "setActivityHolder", "(Lkotlin/jvm/functions/Function0;)V", "appId", "getAppId", "appSecret", "getAppSecret", "authData", "Lcom/kakaogame/idp/IdpAccount;", "getAuthData", "()Lcom/kakaogame/idp/IdpAccount;", "captureDialog", "Lcom/kakaogame/promotion/share/ScreenShotDialog;", "configuration", "Lcom/kakaogame/config/Configuration;", "getConfiguration", "()Lcom/kakaogame/config/Configuration;", "setConfiguration", "(Lcom/kakaogame/config/Configuration;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "coreState", "Lcom/kakaogame/core/CoreManager$CoreState;", "coreStateListeners", "", "Lcom/kakaogame/core/CoreManager$CoreStateListener;", "customResourceMap", "", "customUIManager", "Lcom/kakaogame/ui/CustomUIManager;", "eventListeners", "", "Lcom/kakaogame/KGSNSShare$KGEventListener;", "fCMToken", "getFCMToken", "firebaseInterface", "Lcom/kakaogame/log/IFirebase;", "googleGameVersion", "", "<set-?>", "Lcom/kakaogame/infodesk/InfodeskData;", "infodesk", "getInfodesk", "()Lcom/kakaogame/infodesk/InfodeskData;", "infodeskRefreshLock", "infodeskTimer", "Lcom/kakaogame/core/TimerManager;", "isAuthorized", "", "()Z", "isFirstLogin", "isGetFirstInfodesk", "setGetFirstInfodesk", "(Z)V", "isKakaoCacheMode", "isNotAuthorized", "isPaused", "isUnity", "isUnreal", "launchingReferrer", "logManager", "Lcom/kakaogame/log/SDKLogManager;", "marketRefundInfoList", "", "Lcom/kakaogame/KGMarketRefundInfo;", "getMarketRefundInfoList", "()Ljava/util/List;", "setMarketRefundInfoList", "(Ljava/util/List;)V", "onlineAlarmLock", "onlineAlarmTimer", "onlineNotificationId", "pauseTimer", "Ljava/util/concurrent/ScheduledFuture;", "Lcom/kakaogame/player/LocalPlayer;", "player", "getPlayer", "()Lcom/kakaogame/player/LocalPlayer;", "playerId", "getPlayerId", "preferenceKey", "getPreferenceKey", "refreshInterval", "", "serverTimeDiffer", "snsShareData", "Lcom/kakaogame/promotion/SNSShareData;", Configuration.KEY_USE_FIREBASE, "getUseFirebase", "useWaitCount", "waitCount", "warningTimer", "addCoreStateListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addTraceMetric", ServerConstants.HEADER_TRACE_ID, NotificationCompat.CATEGORY_EVENT, "authorize", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/auth/LoginData;", "saveAccount", "traceJobId", "autoLogin", "resume", "autoLoginInternal", "reconnect", "autoLoginInternalForZatRefresh", "cancelPauseTimer", "checkUnity", "checkUnreal", "connect", "Ljava/lang/Void;", "account", "currentTimeMillis", "getGoogleGameVersion", "getLaunchingReferrer", "getSnsShareData", "handleInfodesk", "isRefresh", "hasCustomAlertHandler", "type", "Lcom/kakaogame/KGCustomUI$KGCustomAlertType;", "idpLogout", "increaseWaitCount", "init", "initFirebase", "initModules", "isAuthError", "loginResult", "loadInfodesk", "loginInternal", "logout", "offKakaoCacheMode", "onCustomUICallback", "action", "onInfodesk", "isCache", "onLogin", "localPlayer", "loginData", "onLoginFailed", "onLogout", "onUnregister", "pause", "pauseInternal", "putEventListener", "reconnectAutoLogin", "refreshPlayer", "registerShowCustomAlertHandler", "handler", "Lcom/kakaogame/KGCustomUI$KGShowCustomAlertHandler;", "removeCoreStateListener", "request", "requestUri", KeyBaseResult.KEY_HEADER, SDKConstants.PARAM_A2U_BODY, "timeout", "requestAutoLogin", "requestInfodesk", "requestSnsShare", "imagePath", "requestUnregister", "resetWaitTime", "retryWaiting", "sendEvent", KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, "sendLogFilesImmediately", "sendLogFirebase", "cls", "function", "result", "setCaptureDialog", "dialog", "setCrashlyticsUserIdentifier", "setEngine", "setGoogleGameVersion", "version", "setIsUnity", "setIsUnreal", "setLaunchingReferrer", "bundle", "Landroid/os/Bundle;", "setServerTimeStamp", "timeStamp", "showCustomUI", "alert", "Lcom/kakaogame/KGCustomUI$KGCustomAlert;", "startFirebaseTrace", "name", "startFirebaseTraceOnUnity", "attr", "startInfodeskTimer", "startOnlineAlarmTimer", "notificationId", "message", "interval", "startTime", "endTime", "startPauseTimer", "startWarningSDKTimer", "stopFirebaseTrace", "Lcom/kakaogame/server/KeyBaseResult;", "stopFirebaseTraceOnUnity", "stopInfodeskTimer", "stopOnlineAlarmTimer", "stopWarningSDKTimer", "tryKakaoReConnect", "unregister", "updateIdpAccessToken", "updateRefreshSetting", "Companion", "CoreState", "CoreStateListener", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CoreManager {
    private static final String REFRESH_OFF_KEY = "stopAutoRefreshInfodesk";
    private static final String TAG = "CoreManager";
    public Function0<? extends Activity> activityHolder;
    private ScreenShotDialog captureDialog;
    public Configuration configuration;
    private CustomUIManager customUIManager;
    private IFirebase firebaseInterface;
    private InfodeskData infodesk;
    private TimerManager infodeskTimer;
    private boolean isKakaoCacheMode;
    private boolean isPaused;
    private boolean isUnity;
    private boolean isUnreal;
    private String launchingReferrer;
    private SDKLogManager logManager;
    private List<KGMarketRefundInfo> marketRefundInfoList;
    private TimerManager onlineAlarmTimer;
    private ScheduledFuture<?> pauseTimer;
    private LocalPlayer player;
    private long refreshInterval;
    private long serverTimeDiffer;
    private SNSShareData snsShareData;
    private long waitCount;
    private TimerManager warningTimer;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CoreManager instance = new CoreManager();
    public static int testKakaoErrorCode = 200;
    public static int testGoogleErrorCode = 200;
    private CoreState coreState = CoreState.NOT_INIT;
    private boolean isGetFirstInfodesk = true;
    private final Set<CoreStateListener> coreStateListeners = new LinkedHashSet();
    private final Object infodeskRefreshLock = new Object();
    private final Object onlineAlarmLock = new Object();
    private String onlineNotificationId = "";
    private boolean useWaitCount = true;
    private Map<String, String> customResourceMap = new HashMap();
    private final List<KGSNSShare.KGEventListener> eventListeners = new ArrayList();
    private int googleGameVersion = 1;

    /* compiled from: CoreManager.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/core/CoreManager$CoreStateListener;", "", "onConnect", "", "playerId", "", "onLogin", "onLogout", "onPause", "onUnregister", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface CoreStateListener {
        void onConnect(String playerId);

        void onLogin(String playerId);

        void onLogout(String playerId);

        void onPause();

        void onUnregister(String playerId);
    }

    /* compiled from: CoreManager.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[Configuration.KGDebugLevel.values().length];
            try {
                iArr[Configuration.KGDebugLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Configuration.KGDebugLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Configuration.KGDebugLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final CoreManager getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getResourceString(String str) {
        return INSTANCE.getResourceString(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CoreManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Configuration getConfiguration() {
        Configuration configuration = this.configuration;
        if (configuration != null) {
            return configuration;
        }
        Intrinsics.throwUninitializedPropertyAccessException(y.ٴسسݬߨ(1393326218));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setConfiguration(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, y.ٴسسݬߨ(1392633402));
        this.configuration = configuration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isGetFirstInfodesk() {
        return this.isGetFirstInfodesk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setGetFirstInfodesk(boolean z) {
        this.isGetFirstInfodesk = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InfodeskData getInfodesk() {
        return this.infodesk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final LocalPlayer getPlayer() {
        return this.player;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPaused() {
        return this.isPaused;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isUnity() {
        return this.isUnity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isUnreal() {
        return this.isUnreal;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<KGMarketRefundInfo> getMarketRefundInfoList() {
        return this.marketRefundInfoList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setMarketRefundInfoList(List<KGMarketRefundInfo> list) {
        this.marketRefundInfoList = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isKakaoCacheMode() {
        return this.isKakaoCacheMode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Function0<Activity> getActivityHolder() {
        Function0 function0 = this.activityHolder;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException(y.ٴسسݬߨ(1393360994));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setActivityHolder(Function0<? extends Activity> function0) {
        Intrinsics.checkNotNullParameter(function0, y.ٴسسݬߨ(1392633402));
        this.activityHolder = function0;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: CoreManager.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/core/CoreManager$CoreState;", "", "(Ljava/lang/String;I)V", "NOT_INIT", "INIT", "START", "LOGIN", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class CoreState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CoreState[] $VALUES;
        public static final CoreState NOT_INIT = new CoreState(y.ۮڭڭܬި(862540651), 0);
        public static final CoreState INIT = new CoreState(y.֬ڱܱײٮ(-1158846575), 1);
        public static final CoreState START = new CoreState(y.ٴسسݬߨ(1393375874), 2);
        public static final CoreState LOGIN = new CoreState(y.ۮڭڭܬި(862499747), 3);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ CoreState[] $values() {
            return new CoreState[]{NOT_INIT, INIT, START, LOGIN};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<CoreState> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CoreState valueOf(String str) {
            return (CoreState) Enum.valueOf(CoreState.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CoreState[] values() {
            return (CoreState[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CoreState(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            CoreState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Context getContext() {
        return getActivityHolder().invoke();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Activity getActivity() {
        return getActivityHolder().invoke();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void offKakaoCacheMode() {
        this.isKakaoCacheMode = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void resetWaitTime() {
        this.waitCount = 0L;
        this.useWaitCount = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendLogFilesImmediately() {
        SDKLogManager sDKLogManager = this.logManager;
        if (sDKLogManager != null) {
            sDKLogManager.uploadLogFilesImmediately(getContext());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setGoogleGameVersion(int version) {
        this.googleGameVersion = version;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getGoogleGameVersion() {
        return this.googleGameVersion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SNSShareData getSnsShareData() {
        Context context = getContext();
        String playerId = getPlayerId();
        String loadPlayerInvitationReferrer = InviteDataManager.loadPlayerInvitationReferrer(context, playerId);
        if (loadPlayerInvitationReferrer == null || loadPlayerInvitationReferrer.length() == 0) {
            KGResult<String> playerReferrer = PromotionService.getPlayerReferrer();
            if (playerReferrer.isSuccess()) {
                String content = playerReferrer.getContent();
                Intrinsics.checkNotNull(content);
                InviteDataManager.savePlayerInvitationReferrer(context, playerId, content);
            }
        }
        SNSShareData sNSShareData = this.snsShareData;
        if (sNSShareData != null && !sNSShareData.needRefresh()) {
            return sNSShareData;
        }
        SNSShareData loadData = SNSShareData.INSTANCE.loadData();
        if (loadData != null) {
            this.snsShareData = loadData;
        }
        return this.snsShareData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void registerShowCustomAlertHandler(KGCustomUI.KGCustomAlertType type, KGCustomUI.KGShowCustomAlertHandler handler) {
        if (type == null || handler == null) {
            return;
        }
        if (this.customUIManager == null) {
            this.customUIManager = new CustomUIManager();
        }
        CustomUIManager customUIManager = this.customUIManager;
        if (customUIManager != null) {
            customUIManager.registerShowCustomAlertHandler(type, handler);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String showCustomUI(Activity activity, KGCustomUI.KGCustomAlert alert) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(alert, y.٬ݯح׭٩(576642510));
        if (this.customUIManager == null) {
            this.customUIManager = new CustomUIManager();
        }
        CustomUIManager customUIManager = this.customUIManager;
        if (customUIManager != null) {
            return customUIManager.showCustomUI(activity, alert);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasCustomAlertHandler(KGCustomUI.KGCustomAlertType type) {
        Intrinsics.checkNotNullParameter(type, y.ٲٴݴ״ٰ(1781623144));
        CustomUIManager customUIManager = this.customUIManager;
        if (customUIManager == null) {
            return false;
        }
        Intrinsics.checkNotNull(customUIManager);
        return customUIManager.hasCustomAlertHandler(type);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onCustomUICallback(String action) {
        CustomUIManager customUIManager = this.customUIManager;
        if (customUIManager != null) {
            customUIManager.onCustomUICallbackOnUnity(action);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCaptureDialog(ScreenShotDialog dialog) {
        this.captureDialog = dialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void requestSnsShare(String imagePath) {
        ScreenShotDialog screenShotDialog = this.captureDialog;
        if (screenShotDialog != null) {
            Intrinsics.checkNotNull(screenShotDialog);
            screenShotDialog.showShareDialog(imagePath);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void putEventListener(KGSNSShare.KGEventListener listener) {
        if (listener != null) {
            this.eventListeners.add(listener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendEvent(int eventId) {
        if (this.eventListeners.size() > 0) {
            Iterator<KGSNSShare.KGEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onEvent(eventId);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void retryWaiting() {
        if (this.waitCount == 0) {
            return;
        }
        long maxRequestWaitingTime = InfodeskHelper.INSTANCE.getMaxRequestWaitingTime();
        long initialRequestWaitingTime = InfodeskHelper.INSTANCE.getInitialRequestWaitingTime();
        long nextValueToMultiply = InfodeskHelper.INSTANCE.getNextValueToMultiply();
        long nextValueToSum = InfodeskHelper.INSTANCE.getNextValueToSum();
        long j = initialRequestWaitingTime * nextValueToMultiply;
        long j2 = this.waitCount;
        long j3 = (j * j2) + (nextValueToSum * j2);
        if (j3 <= maxRequestWaitingTime) {
            maxRequestWaitingTime = j3;
        }
        if (maxRequestWaitingTime == 0) {
            return;
        }
        try {
            Thread.sleep(maxRequestWaitingTime);
        } catch (InterruptedException unused) {
        }
        this.useWaitCount = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void increaseWaitCount() {
        if (this.useWaitCount) {
            this.waitCount++;
            this.useWaitCount = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPreferenceKey() {
        String serverTypeString = getConfiguration().getServerTypeString();
        String appId = getConfiguration().getAppId();
        return !StringsKt.equals(Configuration.KGServerType.LIVE.getValue(), serverTypeString, true) ? appId + '_' + serverTypeString : appId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setLaunchingReferrer(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String str = y.٬ݯح׭٩(576642190);
        if (bundle.containsKey(str)) {
            String string = bundle.getString(str, null);
            Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.֬ڱܱײٮ(-1158855559) + string);
            if (string == null) {
                return;
            }
            this.launchingReferrer = string;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLaunchingReferrer() {
        String str = this.launchingReferrer;
        this.launchingReferrer = null;
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setEngine() {
        setIsUnity();
        setIsUnreal();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setIsUnity() {
        boolean z;
        String str = y.ݬֲ֮ܲت(1512313519);
        try {
            checkUnity();
            Logger.INSTANCE.m699d(str, "isUnity!!!");
            z = true;
        } catch (ClassNotFoundException unused) {
            Logger.INSTANCE.m699d(str, y.ݬֲ֮ܲت(1512317735));
            z = false;
        }
        this.isUnity = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void checkUnity() throws ClassNotFoundException {
        Class.forName(y.֬ڱܱײٮ(-1158850359), false, getClass().getClassLoader());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setIsUnreal() {
        boolean z;
        String str = y.ݬֲ֮ܲت(1512313519);
        try {
            checkUnreal();
            Logger.INSTANCE.m699d(str, "isUnreal!!!");
            z = true;
        } catch (ClassNotFoundException unused) {
            Logger.INSTANCE.m699d(str, y.دײܮڳܯ(2051279685));
            z = false;
        }
        this.isUnreal = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void checkUnreal() throws ClassNotFoundException {
        Class.forName(y.ٲٴݴ״ٰ(1782061536), false, getClass().getClassLoader());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> init(Activity activity, Configuration configuration) {
        String str = y.ݬֲ֮ܲت(1512313519);
        String str2 = y.ٴسسݬߨ(1393361410);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(configuration, y.ٴسسݬߨ(1393326218));
        try {
            Logger.INSTANCE.m704i(str, str2 + activity + " : " + configuration);
            setConfiguration(configuration);
            int i = WhenMappings.$EnumSwitchMapping$0[configuration.getDebugLevel().ordinal()];
            if (i == 1) {
                Logger.INSTANCE.setLoggingLevel(2);
            } else if (i == 2) {
                Logger.INSTANCE.setLoggingLevel(3);
            } else if (i == 3) {
                Logger.INSTANCE.setLoggingLevel(6);
            } else {
                Logger.INSTANCE.setLoggingLevel(7);
            }
            if (SdkManager.INSTANCE.isTestMode(activity)) {
                Logger.INSTANCE.setLoggingLevel(2);
            }
            initModules();
            if (this.coreState.ordinal() < CoreState.INIT.ordinal()) {
                this.coreState = CoreState.INIT;
            }
            if (AndroidManifestUtil.checkPermissions(activity, CollectionsKt.listOf((Object[]) new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}))) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            return KGResult.INSTANCE.getResult(3000);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initFirebase(Context context) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782062472);
        String str2 = y.ݬֲ֮ܲت(1512313519);
        logger.m699d(str2, str);
        IFirebase firebase2 = INSTANCE.getFirebase(y.دײܮڳܯ(2051277157));
        this.firebaseInterface = firebase2;
        if (firebase2 != null) {
            if (this.configuration != null && getConfiguration().useFirebase()) {
                Logger.INSTANCE.m699d(str2, y.ݮڮֲڭܩ(-628545532));
                firebase2.initialize(context);
                if (isAuthorized()) {
                    setCrashlyticsUserIdentifier();
                }
            } else {
                firebase2.initialize(context);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Logger.INSTANCE.m699d(str2, y.ٲٴݴ״ٰ(1782055544));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getUseFirebase() {
        return this.firebaseInterface != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getFCMToken() {
        String fCMToken;
        IFirebase iFirebase = this.firebaseInterface;
        return (iFirebase == null || (fCMToken = iFirebase.getFCMToken()) == null) ? "" : fCMToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setCrashlyticsUserIdentifier() {
        IFirebase iFirebase = this.firebaseInterface;
        if (iFirebase != null) {
            iFirebase.setCrashUserIdentifier(getPlayerId());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendLogFirebase(String cls, String function, KGResult<?> result) {
        String str = y.ݮڮֲڭܩ(-628797244);
        String str2 = y.ٲٴݴ״ٰ(1781642144);
        Intrinsics.checkNotNullParameter(cls, y.ݬֲ֮ܲت(1512322287));
        Intrinsics.checkNotNullParameter(function, y.ۮڭڭܬި(862549675));
        Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
        IFirebase iFirebase = this.firebaseInterface;
        if (iFirebase != null) {
            try {
                String str3 = result.isSuccess() ? "sdk_api_success" : "sdk_api_fail";
                StringBuilder sb = new StringBuilder();
                String lowerCase = cls.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, str);
                StringBuilder append = sb.append(lowerCase).append('_');
                String lowerCase2 = function.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, str);
                String sb2 = append.append(lowerCase2).toString();
                if (result.isNotSuccess()) {
                    sb2 = sb2 + '_' + result.getCode() + (result.getServerErrorCode() > 0 ? str2 + result.getServerErrorCode() : "");
                }
                iFirebase.logEvent(str3, MapsKt.mapOf(TuplesKt.m846to(Constants.API_TYPE, sb2)));
            } catch (Exception e) {
                Logger.INSTANCE.m699d(TAG, y.֬ڱܱײٮ(-1158855983) + e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int startFirebaseTrace(String name) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        IFirebase iFirebase = this.firebaseInterface;
        if (iFirebase == null) {
            return -1;
        }
        try {
            return iFirebase.traceStart(name, new HashMap());
        } catch (Exception e) {
            Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.دײܮڳܯ(2051283013) + e);
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addTraceMetric(int traceId, String event) {
        Intrinsics.checkNotNullParameter(event, y.ٲٴݴ״ٰ(1782060104));
        IFirebase iFirebase = this.firebaseInterface;
        if (iFirebase != null) {
            try {
                iFirebase.addTraceMetric(traceId, event);
            } catch (Exception e) {
                Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.ۮڭڭܬި(862544547) + e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void stopFirebaseTrace(int traceId, KeyBaseResult<?> result) {
        Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
        IFirebase iFirebase = this.firebaseInterface;
        if (iFirebase != null) {
            try {
                HashMap hashMap = new HashMap();
                boolean isSuccess = result.isSuccess();
                String str = y.ݬֲ֮ܲت(1512324855);
                if (isSuccess) {
                    hashMap.put(str, String.valueOf(result.getCode()));
                } else {
                    if (getPlayerId().length() == 0) {
                        hashMap.put(str, String.valueOf(result.getCode()));
                    } else {
                        hashMap.put(str, result.getCode() + '_' + getPlayerId());
                    }
                }
                iFirebase.traceStop(traceId, hashMap);
            } catch (Exception e) {
                Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.ݬֲ֮ܲت(1512324687) + e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int startFirebaseTraceOnUnity(String name, Map<String, String> attr) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(attr, y.ٲٴݴ״ٰ(1782055944));
        IFirebase iFirebase = this.firebaseInterface;
        if (iFirebase == null) {
            return -1;
        }
        try {
            return iFirebase.traceStart(name, attr);
        } catch (Exception e) {
            Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.دײܮڳܯ(2051283013) + e);
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void stopFirebaseTraceOnUnity(int traceId, Map<String, String> attr) {
        Intrinsics.checkNotNullParameter(attr, y.ٲٴݴ״ٰ(1782055944));
        IFirebase iFirebase = this.firebaseInterface;
        if (iFirebase != null) {
            try {
                iFirebase.traceStop(traceId, attr);
            } catch (Exception e) {
                Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.ݬֲ֮ܲت(1512324687) + e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized KGResult<LoginData> reconnectAutoLogin() {
        KGResult<LoginData> autoLoginInternal;
        PresenceService.setReconnect(true);
        autoLoginInternal = autoLoginInternal(getActivity(), true, true, -1);
        if (autoLoginInternal.isNotSuccess()) {
            PresenceService.setReconnect(false);
            AuthImpl.handleLoginResult(getActivity(), null, autoLoginInternal, false, -1);
            onLoginFailed(autoLoginInternal, getAuthData());
        }
        return autoLoginInternal;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<LoginData> autoLogin(Activity activity, boolean resume, int traceJobId) {
        String str = y.ݬֲ֮ܲت(1512320967);
        Logger logger = Logger.INSTANCE;
        String str2 = y.٬ݯح׭٩(576635102) + traceJobId;
        String str3 = y.ݬֲ֮ܲت(1512313519);
        logger.m704i(str3, str2);
        try {
            if (this.coreState.ordinal() < CoreState.INIT.ordinal()) {
                return KGResult.INSTANCE.getResult(3001, str + this.coreState);
            }
            cancelPauseTimer();
            KGResult<LoginData> autoLoginInternal = autoLoginInternal(activity, false, resume, traceJobId);
            if (!autoLoginInternal.isNotSuccess() || autoLoginInternal.getCode() == 3002) {
                return autoLoginInternal;
            }
            onLoginFailed(autoLoginInternal, getAuthData());
            return autoLoginInternal;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            KGResult<LoginData> result = KGResult.INSTANCE.getResult(4001, e.toString());
            onLoginFailed(result, getAuthData());
            return result;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<InfodeskData> loadInfodesk(boolean isRefresh) {
        String str = y.ݬֲ֮ܲت(1512313519);
        try {
            Logger.INSTANCE.m699d(str, "loadInfodesk");
            InfodeskData cachedData = InfodeskDataCache.getCachedData(getContext(), getConfiguration());
            if (cachedData != null) {
                Logger.INSTANCE.m699d(str, "Get cached infodesk data.");
                onInfodesk(cachedData, true, isRefresh);
                return KGResult.INSTANCE.getSuccessResult(cachedData);
            }
            if (!isRefresh) {
                retryWaiting();
            }
            KGResult<InfodeskData> loadInfodeskByHttp = InfodeskService.loadInfodeskByHttp(getActivity());
            if (loadInfodeskByHttp.isSuccess()) {
                resetWaitTime();
                InfodeskData content = loadInfodeskByHttp.getContent();
                Intrinsics.checkNotNull(content);
                InfodeskData infodeskData = content;
                infodeskData.setGettingDataTime();
                onInfodesk(infodeskData, false, isRefresh);
                return KGResult.INSTANCE.getSuccessResult(infodeskData);
            }
            if (!isRefresh && loadInfodeskByHttp.isNeedToWaitError()) {
                increaseWaitCount();
            }
            return KGResult.INSTANCE.getResult(loadInfodeskByHttp);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> logout() {
        String str = y.ݬֲ֮ܲت(1512313519);
        String str2 = y.ٲٴݴ״ٰ(1782161344);
        String str3 = y.ݬֲ֮ܲت(1512320967);
        try {
            Logger.INSTANCE.m704i(str, "logout");
            if (isNotAuthorized()) {
                return KGResult.INSTANCE.getResult(3002, str3 + this.coreState);
            }
            String playerId = getPlayerId();
            IdpAccount authData = getAuthData();
            if (authData != null) {
                KGResult<Void> logout = IdpAuthManager.logout(getActivity(), authData);
                if (logout.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(logout);
                }
            }
            Logger.INSTANCE.m699d(str, str2 + AuthService.logout());
            onLogout(playerId);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> idpLogout(IdpAccount authData) {
        String str = y.ݬֲ֮ܲت(1512313519);
        String str2 = y.ݬֲ֮ܲت(1512320967);
        try {
            Logger.INSTANCE.m704i(str, y.ٲٴݴ״ٰ(1782062816) + authData);
            if (this.coreState.ordinal() < CoreState.INIT.ordinal()) {
                return KGResult.INSTANCE.getResult(3001, str2 + this.coreState);
            }
            String playerId = getPlayerId();
            if (authData != null) {
                KGResult<Void> logout = IdpAuthManager.logout(getActivity(), authData);
                if (logout.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(logout);
                }
            }
            onLogout(playerId);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.kakaogame.KGResult<java.lang.Void>] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> unregister() {
        String str = y.ݬֲ֮ܲت(1512313519);
        try {
            Logger.INSTANCE.m704i(str, "unregister");
            int ordinal = this.coreState.ordinal();
            int ordinal2 = CoreState.START.ordinal();
            String str2 = y.ݬֲ֮ܲت(1512320967);
            if (ordinal < ordinal2) {
                str = KGResult.INSTANCE.getResult(3001, str2 + this.coreState);
            } else if (isNotAuthorized()) {
                str = KGResult.INSTANCE.getResult(3002, str2 + this.coreState);
            } else {
                str = unregister(getAuthData());
            }
            return str;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> unregister(IdpAccount authData) {
        String str = y.ݬֲ֮ܲت(1512313519);
        String str2 = y.ݬֲ֮ܲت(1512320967);
        try {
            Logger.INSTANCE.m704i(str, y.ٴسسݬߨ(1393335666) + authData);
            if (this.coreState.ordinal() < CoreState.START.ordinal()) {
                return KGResult.INSTANCE.getResult(3001, str2 + this.coreState);
            }
            String playerId = getPlayerId();
            if (authData != null) {
                KGResult<Void> unregister = IdpAuthManager.unregister(getActivity(), authData);
                if (unregister.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(unregister);
                }
            }
            onUnregister(playerId);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> requestUnregister() {
        String idpRefreshToken;
        String str = y.ݬֲ֮ܲت(1512313519);
        String str2 = y.ݮڮֲڭܩ(-628575740);
        String str3 = y.֬ڱܱײٮ(-1158884391);
        String str4 = y.ۮڭڭܬި(862549899);
        try {
            Logger.INSTANCE.m704i(str, "requestUnregister");
            int ordinal = this.coreState.ordinal();
            int ordinal2 = CoreState.START.ordinal();
            String str5 = y.ݬֲ֮ܲت(1512320967);
            if (ordinal < ordinal2) {
                return KGResult.INSTANCE.getResult(3001, str5 + this.coreState);
            }
            if (!isNotAuthorized() && getAuthData() != null) {
                IdpAccount authData = getAuthData();
                Intrinsics.checkNotNull(authData);
                KGResult<Void> waitForRemove = LocalPlayerService.waitForRemove();
                Logger.INSTANCE.m699d(str, str4 + waitForRemove);
                if (waitForRemove.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(waitForRemove);
                }
                if (Intrinsics.areEqual(authData.getIdpCode(), KGIdpProfile.KGIdpCode.SigninWithApple.getCode()) && (idpRefreshToken = authData.getIdpRefreshToken()) != null) {
                    Logger.INSTANCE.m699d(str, str2 + AuthService.INSTANCE.revokeSIWA(getPlayerId(), idpRefreshToken));
                }
                Logger.INSTANCE.m699d(str, str3 + idpLogout(authData));
                return KGResult.INSTANCE.getSuccessResult();
            }
            return KGResult.INSTANCE.getResult(3002, str5 + this.coreState);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<LoginData> authorize(IdpAccount authData, boolean saveAccount, int traceJobId) {
        String str = y.ݬֲ֮ܲت(1512313519);
        String str2 = y.ݬֲ֮ܲت(1512320967);
        try {
            Logger.INSTANCE.m704i(str, y.ٲٴݴ״ٰ(1782062000) + authData);
            if (this.coreState.ordinal() < CoreState.START.ordinal()) {
                return KGResult.INSTANCE.getResult(3001, str2 + this.coreState);
            }
            if (authData == null) {
                return KGResult.INSTANCE.getResult(4000, "authData is null");
            }
            cancelPauseTimer();
            retryWaiting();
            KGResult<LoginData> loginInternal = loginInternal(authData, saveAccount, traceJobId);
            if (loginInternal.isNotSuccess()) {
                if (loginInternal.isNeedToWaitError()) {
                    increaseWaitCount();
                }
                onLoginFailed(loginInternal, authData);
                return loginInternal;
            }
            resetWaitTime();
            return loginInternal;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            KGResult<LoginData> result = KGResult.INSTANCE.getResult(4001, e.toString());
            onLoginFailed(result, authData);
            return result;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> connect(IdpAccount account, boolean saveAccount, int traceJobId) {
        try {
            Logger.INSTANCE.m704i(TAG, y.ٲٴݴ״ٰ(1782174440) + account + " : " + saveAccount);
            cancelPauseTimer();
            KGResult<IdpAccount> connect = AuthService.connect(getContext(), getPlayerId(), account, traceJobId);
            if (connect.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(connect);
            }
            IdpAccount content = connect.getContent();
            Intrinsics.checkNotNull(content);
            IdpAccount idpAccount = content;
            LoginData loginData = AuthDataManager.getLoginData();
            Intrinsics.checkNotNull(loginData);
            if (Intrinsics.areEqual(idpAccount.getIdpCode(), IdpAccount.IdpCode.SigninWithApple)) {
                loginData.put(ServerConstants.STORED_SIWA_ACCESS_TOKEN, idpAccount.getIdpAccessToken());
                loginData.put(ServerConstants.STORED_SIWA_REFRESH_TOKEN, idpAccount.getIdpRefreshToken());
            }
            AuthDataManager.setAuthData(getContext(), loginData, idpAccount, saveAccount);
            synchronized (this.coreStateListeners) {
                Iterator<CoreStateListener> it = this.coreStateListeners.iterator();
                while (it.hasNext()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CoreManager$connect$1$1(it.next(), this, null), 3, null);
                }
                Unit unit = Unit.INSTANCE;
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> resume() {
        String str = y.ݬֲ֮ܲت(1512313519);
        try {
            Logger.INSTANCE.m699d(str, "resume");
            cancelPauseTimer();
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> pause() {
        String str = y.ݬֲ֮ܲت(1512313519);
        try {
            Logger.INSTANCE.m699d(str, "pause");
            startPauseTimer();
            stopInfodeskTimer();
            stopWarningSDKTimer();
            if (SDKVersion.isPublishing && isAuthorized()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CoreManager$pause$1(null), 3, null);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Map<String, Object>> request(String requestUri, Map<String, ? extends Object> header, Map<String, ? extends Object> body, long timeout) {
        String str = y.ݬֲ֮ܲت(1512313519);
        String str2 = y.ݮڮֲڭܩ(-628756788);
        String str3 = y.ݬֲ֮ܲت(1512320967);
        String str4 = y.ٴسسݬߨ(1393014090);
        Intrinsics.checkNotNullParameter(requestUri, y.دײܮڳܯ(2051368157));
        try {
            Logger.INSTANCE.m704i(str, str4 + requestUri + str2 + header + str2 + body + str2 + timeout);
            if (isNotAuthorized()) {
                return KGResult.INSTANCE.getResult(3002, str3 + this.coreState);
            }
            ServerRequest serverRequest = new ServerRequest(requestUri);
            if (header != null) {
                serverRequest.putAllHeader(header);
            }
            if (body != null) {
                serverRequest.putAllBody(body);
            }
            serverRequest.setTimeout(timeout);
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult refreshPlayer$default(CoreManager coreManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return coreManager.refreshPlayer(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> refreshPlayer(int traceJobId) {
        String str = y.ݬֲ֮ܲت(1512313519);
        try {
            Logger.INSTANCE.m699d(str, "refreshPlayer");
            KGResult<LocalPlayer> localPlayer = LocalPlayerService.getLocalPlayer(traceJobId);
            if (localPlayer.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(localPlayer);
            }
            this.player = localPlayer.getContent();
            SDKLogManager sDKLogManager = this.logManager;
            Intrinsics.checkNotNull(sDKLogManager);
            sDKLogManager.uploadLogFiles(getContext());
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAuthorized() {
        return this.coreState == CoreState.LOGIN;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNotAuthorized() {
        return !isAuthorized();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IdpAccount getAuthData() {
        return AuthDataManager.getAccount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAppId() {
        return getConfiguration().getAppId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAppSecret() {
        return getConfiguration().getAppSecret();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPlayerId() {
        String playerId;
        LocalPlayer localPlayer = this.player;
        if (localPlayer != null) {
            String playerId2 = localPlayer.getPlayerId();
            if (playerId2.length() > 0) {
                return playerId2;
            }
        }
        LoginData loginData = AuthDataManager.getLoginData();
        return (loginData == null || (playerId = loginData.getPlayerId()) == null) ? "" : playerId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isFirstLogin() {
        LoginData loginData = AuthDataManager.getLoginData();
        if (loginData != null) {
            return loginData.isFirstLogin();
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAccessToken() {
        LoginData loginData;
        LoginData.ZinnyAccessToken accessToken;
        return (!isAuthorized() || (loginData = AuthDataManager.getLoginData()) == null || (accessToken = loginData.getAccessToken()) == null || accessToken.isExpired()) ? "" : accessToken.getZat();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addCoreStateListener(CoreStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
        synchronized (this.coreStateListeners) {
            this.coreStateListeners.add(listener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removeCoreStateListener(CoreStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
        synchronized (this.coreStateListeners) {
            this.coreStateListeners.remove(listener);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long currentTimeMillis() {
        if (this.infodesk != null) {
            return SystemClock.uptimeMillis() - this.serverTimeDiffer;
        }
        return System.currentTimeMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> tryKakaoReConnect() {
        if (this.isKakaoCacheMode) {
            IdpAccount authData = getAuthData();
            Intrinsics.checkNotNull(authData);
            KGResult<IdpAccount> checkAuth = IdpAuthManager.checkAuth(getActivity(), authData, -1);
            if (checkAuth.isSuccess()) {
                offKakaoCacheMode();
            }
            return KGResult.INSTANCE.getResult(checkAuth);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void startOnlineAlarmTimer(final Activity activity, String notificationId, final String message, long interval, long startTime, final long endTime) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(notificationId, y.دײܮڳܯ(2051283261));
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.ٴسسݬߨ(1393367954) + notificationId + y.ݮڮֲڭܩ(-628756788) + message + y.ݬֲ֮ܲت(1512324879) + interval + y.دײܮڳܯ(2051282805) + endTime);
        synchronized (this.onlineAlarmLock) {
            if (this.onlineAlarmTimer != null) {
                if (StringsKt.equals(notificationId, this.onlineNotificationId, true)) {
                    Logger.INSTANCE.m699d(TAG, "startOnlineAlarmTimer: Already started.");
                    return;
                }
                stopOnlineAlarmTimer(this.onlineNotificationId);
            }
            this.onlineNotificationId = notificationId;
            Runnable runnable = new Runnable() { // from class: com.kakaogame.core.CoreManager$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    CoreManager.startOnlineAlarmTimer$lambda$24$lambda$23(CoreManager.this, endTime, activity, message);
                }
            };
            long currentTimeMillis = instance.currentTimeMillis();
            long j = startTime > currentTimeMillis ? startTime - currentTimeMillis : interval;
            if (startTime < currentTimeMillis) {
                OnlinePushManager.showToast(activity, message);
            }
            TimerManager timerManager = new TimerManager(runnable, j, interval);
            this.onlineAlarmTimer = timerManager;
            Intrinsics.checkNotNull(timerManager);
            timerManager.startTimer();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void startOnlineAlarmTimer$lambda$24$lambda$23(CoreManager coreManager, long j, Activity activity, String str) {
        Intrinsics.checkNotNullParameter(coreManager, y.ٴسسݬߨ(1393322442));
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        if (coreManager.currentTimeMillis() > j) {
            coreManager.stopOnlineAlarmTimer(coreManager.onlineNotificationId);
        } else {
            OnlinePushManager.showToast(activity, str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void stopOnlineAlarmTimer(String notificationId) {
        String str = y.֬ڱܱײٮ(-1158853751);
        Intrinsics.checkNotNullParameter(notificationId, y.دײܮڳܯ(2051283261));
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.٬ݯح׭٩(576640022) + notificationId);
        synchronized (this.onlineAlarmLock) {
            if (!StringsKt.equals(this.onlineNotificationId, notificationId, true)) {
                Logger.INSTANCE.m699d(TAG, str + notificationId + Typography.quote);
                return;
            }
            TimerManager timerManager = this.onlineAlarmTimer;
            if (timerManager != null) {
                Intrinsics.checkNotNull(timerManager);
                timerManager.stopTimer();
                this.onlineAlarmTimer = null;
            }
            this.onlineNotificationId = "";
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void startWarningSDKTimer() {
        if (this.warningTimer != null) {
            return;
        }
        TimerManager timerManager = new TimerManager(new Runnable() { // from class: com.kakaogame.core.CoreManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                CoreManager.startWarningSDKTimer$lambda$26();
            }
        }, 10000L, 10000L);
        this.warningTimer = timerManager;
        Intrinsics.checkNotNull(timerManager);
        timerManager.startTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void startWarningSDKTimer$lambda$26() {
        Logger.INSTANCE.m703he(y.ݬֲ֮ܲت(1512313519), y.ٴسسݬߨ(1393369154));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void stopWarningSDKTimer() {
        TimerManager timerManager = this.warningTimer;
        if (timerManager != null) {
            Intrinsics.checkNotNull(timerManager);
            timerManager.stopTimer();
            this.warningTimer = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void startInfodeskTimer() {
        String str = y.ݬֲ֮ܲت(1512317487);
        synchronized (this.infodeskRefreshLock) {
            if (this.infodeskTimer != null) {
                stopInfodeskTimer();
            }
            Logger.INSTANCE.m704i(TAG, str + this.refreshInterval);
            Runnable runnable = new Runnable() { // from class: com.kakaogame.core.CoreManager$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    CoreManager.startInfodeskTimer$lambda$28$lambda$27(CoreManager.this);
                }
            };
            long j = this.refreshInterval;
            TimerManager timerManager = new TimerManager(runnable, j, j);
            this.infodeskTimer = timerManager;
            Intrinsics.checkNotNull(timerManager);
            timerManager.startTimer();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void startInfodeskTimer$lambda$28$lambda$27(CoreManager coreManager) {
        Intrinsics.checkNotNullParameter(coreManager, y.ٴسسݬߨ(1393322442));
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.ٲٴݴ״ٰ(1782060288));
        coreManager.requestInfodesk();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void stopInfodeskTimer() {
        synchronized (this.infodeskRefreshLock) {
            TimerManager timerManager = this.infodeskTimer;
            if (timerManager != null) {
                Intrinsics.checkNotNull(timerManager);
                timerManager.stopTimer();
                this.infodeskTimer = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized KGResult<LoginData> autoLoginInternal(Activity activity, boolean reconnect, boolean resume, int traceJobId) {
        KGResult<LoginData> requestAutoLogin;
        retryWaiting();
        requestAutoLogin = requestAutoLogin(activity, reconnect, resume, traceJobId);
        if (!requestAutoLogin.isSuccess()) {
            if (requestAutoLogin.isNeedToWaitError()) {
                increaseWaitCount();
            }
        } else {
            resetWaitTime();
        }
        return requestAutoLogin;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void updateIdpAccessToken(String accessToken) {
        if (isAuthorized()) {
            LoginData loginData = AuthDataManager.getLoginData();
            IdpAccount authData = getAuthData();
            Intrinsics.checkNotNull(authData);
            authData.put(y.ݬֲ֮ܲت(1512323967), accessToken);
            AuthDataManager.setAuthData(getContext(), loginData, authData, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0167 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a6 A[Catch: all -> 0x0344, TryCatch #0 {, blocks: (B:4:0x0046, B:6:0x004e, B:10:0x005f, B:12:0x0067, B:14:0x006d, B:17:0x0079, B:19:0x007f, B:22:0x0087, B:24:0x0098, B:27:0x00b4, B:29:0x00c6, B:31:0x00cc, B:36:0x0161, B:39:0x0169, B:41:0x018c, B:44:0x019a, B:46:0x01a6, B:47:0x01c7, B:49:0x01cd, B:52:0x01d7, B:54:0x0200, B:56:0x0206, B:59:0x0210, B:61:0x0216, B:64:0x0220, B:66:0x023c, B:69:0x0244, B:71:0x0262, B:74:0x0283, B:76:0x02bd, B:81:0x02c9, B:83:0x02de, B:84:0x02f0, B:88:0x02fc, B:91:0x01b3, B:93:0x00df, B:95:0x0104, B:98:0x0111, B:100:0x011a, B:102:0x0124, B:105:0x012f, B:108:0x013d, B:110:0x0155, B:112:0x033a), top: B:3:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01cd A[Catch: all -> 0x0344, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0046, B:6:0x004e, B:10:0x005f, B:12:0x0067, B:14:0x006d, B:17:0x0079, B:19:0x007f, B:22:0x0087, B:24:0x0098, B:27:0x00b4, B:29:0x00c6, B:31:0x00cc, B:36:0x0161, B:39:0x0169, B:41:0x018c, B:44:0x019a, B:46:0x01a6, B:47:0x01c7, B:49:0x01cd, B:52:0x01d7, B:54:0x0200, B:56:0x0206, B:59:0x0210, B:61:0x0216, B:64:0x0220, B:66:0x023c, B:69:0x0244, B:71:0x0262, B:74:0x0283, B:76:0x02bd, B:81:0x02c9, B:83:0x02de, B:84:0x02f0, B:88:0x02fc, B:91:0x01b3, B:93:0x00df, B:95:0x0104, B:98:0x0111, B:100:0x011a, B:102:0x0124, B:105:0x012f, B:108:0x013d, B:110:0x0155, B:112:0x033a), top: B:3:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d7 A[Catch: all -> 0x0344, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0046, B:6:0x004e, B:10:0x005f, B:12:0x0067, B:14:0x006d, B:17:0x0079, B:19:0x007f, B:22:0x0087, B:24:0x0098, B:27:0x00b4, B:29:0x00c6, B:31:0x00cc, B:36:0x0161, B:39:0x0169, B:41:0x018c, B:44:0x019a, B:46:0x01a6, B:47:0x01c7, B:49:0x01cd, B:52:0x01d7, B:54:0x0200, B:56:0x0206, B:59:0x0210, B:61:0x0216, B:64:0x0220, B:66:0x023c, B:69:0x0244, B:71:0x0262, B:74:0x0283, B:76:0x02bd, B:81:0x02c9, B:83:0x02de, B:84:0x02f0, B:88:0x02fc, B:91:0x01b3, B:93:0x00df, B:95:0x0104, B:98:0x0111, B:100:0x011a, B:102:0x0124, B:105:0x012f, B:108:0x013d, B:110:0x0155, B:112:0x033a), top: B:3:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02c9 A[Catch: all -> 0x0344, TryCatch #0 {, blocks: (B:4:0x0046, B:6:0x004e, B:10:0x005f, B:12:0x0067, B:14:0x006d, B:17:0x0079, B:19:0x007f, B:22:0x0087, B:24:0x0098, B:27:0x00b4, B:29:0x00c6, B:31:0x00cc, B:36:0x0161, B:39:0x0169, B:41:0x018c, B:44:0x019a, B:46:0x01a6, B:47:0x01c7, B:49:0x01cd, B:52:0x01d7, B:54:0x0200, B:56:0x0206, B:59:0x0210, B:61:0x0216, B:64:0x0220, B:66:0x023c, B:69:0x0244, B:71:0x0262, B:74:0x0283, B:76:0x02bd, B:81:0x02c9, B:83:0x02de, B:84:0x02f0, B:88:0x02fc, B:91:0x01b3, B:93:0x00df, B:95:0x0104, B:98:0x0111, B:100:0x011a, B:102:0x0124, B:105:0x012f, B:108:0x013d, B:110:0x0155, B:112:0x033a), top: B:3:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b3 A[Catch: all -> 0x0344, TryCatch #0 {, blocks: (B:4:0x0046, B:6:0x004e, B:10:0x005f, B:12:0x0067, B:14:0x006d, B:17:0x0079, B:19:0x007f, B:22:0x0087, B:24:0x0098, B:27:0x00b4, B:29:0x00c6, B:31:0x00cc, B:36:0x0161, B:39:0x0169, B:41:0x018c, B:44:0x019a, B:46:0x01a6, B:47:0x01c7, B:49:0x01cd, B:52:0x01d7, B:54:0x0200, B:56:0x0206, B:59:0x0210, B:61:0x0216, B:64:0x0220, B:66:0x023c, B:69:0x0244, B:71:0x0262, B:74:0x0283, B:76:0x02bd, B:81:0x02c9, B:83:0x02de, B:84:0x02f0, B:88:0x02fc, B:91:0x01b3, B:93:0x00df, B:95:0x0104, B:98:0x0111, B:100:0x011a, B:102:0x0124, B:105:0x012f, B:108:0x013d, B:110:0x0155, B:112:0x033a), top: B:3:0x0046 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized com.kakaogame.KGResult<com.kakaogame.auth.LoginData> requestAutoLogin(android.app.Activity r27, boolean r28, boolean r29, int r30) {
        /*
            Method dump skipped, instructions count: 844
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.core.CoreManager.requestAutoLogin(android.app.Activity, boolean, boolean, int):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized KGResult<LoginData> autoLoginInternalForZatRefresh() {
        String str = y.ٴسسݬߨ(1393362186);
        String str2 = y.٬ݯح׭٩(576649078);
        String str3 = y.ݬֲ֮ܲت(1512318943);
        synchronized (this) {
            LoginData loginData = AuthDataManager.getLoginData();
            IdpAccount authData = getAuthData();
            if (loginData != null && authData != null) {
                KGResult<ServerRequest> iDPLoginRequest = AuthService.getIDPLoginRequest(getContext(), authData, AuthService.LoginType.AUTO, false, 0L);
                if (iDPLoginRequest.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(iDPLoginRequest);
                }
                ServerRequest content = iDPLoginRequest.getContent();
                Intrinsics.checkNotNull(content);
                ServerResult requestServer$default = ServerService.requestServer$default(content, 0, 2, null);
                Logger.INSTANCE.m699d(TAG, str3 + requestServer$default);
                KGResult<LoginData> handleLoginResult = AuthService.handleLoginResult(requestServer$default);
                Logger.INSTANCE.m699d(TAG, str2 + handleLoginResult);
                if (handleLoginResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(handleLoginResult);
                }
                LoginData content2 = handleLoginResult.getContent();
                Intrinsics.checkNotNull(content2);
                Map<String, Object> player = content2.getPlayer();
                Intrinsics.checkNotNull(player);
                String str4 = (String) player.get("idpId");
                Logger.INSTANCE.m699d(TAG, str + str4);
                String str5 = str4;
                if (!(str5 == null || str5.length() == 0)) {
                    authData.put("userId", str4);
                }
                AuthDataManager.setAuthData(getContext(), content2, authData, true);
                return KGResult.INSTANCE.getSuccessResult(content2);
            }
            Logger.INSTANCE.m701e(TAG, "autoLogin: login data is not exist");
            return KGResult.INSTANCE.getResult(3002);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized KGResult<LoginData> loginInternal(IdpAccount authData, boolean saveAccount, int traceJobId) {
        KGResult<ServerRequest> iDPLoginRequest;
        String str = y.ݮڮֲڭܩ(-628555460);
        String str2 = y.ݮڮֲڭܩ(-628555156);
        String str3 = y.دײܮڳܯ(2051290413);
        String str4 = y.֬ڱܱײٮ(-1158845119);
        synchronized (this) {
            KGResult<InfodeskData> loadInfodesk = loadInfodesk(false);
            if (!loadInfodesk.isSuccess()) {
                return KGResult.INSTANCE.getResult(loadInfodesk);
            }
            if (Intrinsics.areEqual(authData.getIdpCode(), IdpAccount.IdpCode.SigninWithApple) && authData.getIdpRefreshToken() != null) {
                iDPLoginRequest = AuthService.getIDPLoginRequest(getContext(), authData, AuthService.LoginType.AUTO, false, this.waitCount);
            } else {
                iDPLoginRequest = AuthService.getIDPLoginRequest(getContext(), authData, AuthService.LoginType.MANUAL, false, this.waitCount);
            }
            if (iDPLoginRequest.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(iDPLoginRequest);
            }
            ServerRequest content = iDPLoginRequest.getContent();
            Intrinsics.checkNotNull(content);
            KGResult<ServerResult> requestConnect = ServerService.requestConnect(content, "manual", traceJobId);
            Logger.INSTANCE.m699d(TAG, str4 + requestConnect);
            if (requestConnect.isNotSuccess() && requestConnect.getContent() == null) {
                return KGResult.INSTANCE.getResult(requestConnect);
            }
            ServerResult content2 = requestConnect.getContent();
            Logger.INSTANCE.m699d(TAG, str3 + content2);
            KGResult<LoginData> handleLoginResult = AuthService.handleLoginResult(content2);
            Logger.INSTANCE.m699d(TAG, str2 + handleLoginResult);
            if (handleLoginResult.isNotSuccess()) {
                if (Intrinsics.areEqual(authData.getIdpCode(), KGIdpProfile.KGIdpCode.SigninWithApple.getCode())) {
                    LoginData loginData = AuthDataManager.getLoginData();
                    authData.put("accessToken", loginData != null ? loginData.getSiwaAccessToken() : null);
                    LoginData loginData2 = AuthDataManager.getLoginData();
                    authData.put("refreshToken", loginData2 != null ? loginData2.getSiwaRefreshToken() : null);
                }
                ErrorLogManager.sendPlatformLoginError(handleLoginResult.getCode(), content, content2 != null ? content2.getResponse() : null, null, authData, null, null, false);
                return KGResult.INSTANCE.getResult(handleLoginResult);
            }
            LoginData content3 = handleLoginResult.getContent();
            Intrinsics.checkNotNull(content3);
            LocalPlayer localPlayer = new LocalPlayer(content3.getPlayer());
            Map<String, Object> player = content3.getPlayer();
            Intrinsics.checkNotNull(player);
            String str5 = (String) player.get("idpId");
            Logger.INSTANCE.m699d(TAG, str + localPlayer);
            String str6 = str5;
            if (!(str6 == null || str6.length() == 0)) {
                authData.put("userId", str5);
                if (Intrinsics.areEqual(authData.getIdpCode(), KGIdpProfile.KGIdpCode.SigninWithApple.getCode())) {
                    authData.put("accessToken", content3.getSiwaAccessToken());
                    authData.put("refreshToken", content3.getSiwaRefreshToken());
                }
            }
            onLogin(localPlayer, authData, content3, saveAccount);
            return KGResult.INSTANCE.getSuccessResult(content3);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void updateRefreshSetting() {
        boolean z = SDKVersion.isPublishing;
        String str = y.ݬֲ֮ܲت(1512313519);
        if (!z) {
            Logger.INSTANCE.m699d(str, y.ݬֲ֮ܲت(1512323799));
            stopInfodeskTimer();
            return;
        }
        if (InfodeskHelper.INSTANCE.containsKey(y.ٲٴݴ״ٰ(1782058464))) {
            Logger.INSTANCE.m699d(str, y.ٲٴݴ״ٰ(1782058152));
            stopInfodeskTimer();
            return;
        }
        long refreshInfodeskInterval = InfodeskHelper.INSTANCE.getRefreshInfodeskInterval();
        if (refreshInfodeskInterval > 0) {
            if (this.infodeskTimer == null || refreshInfodeskInterval != this.refreshInterval) {
                this.refreshInterval = refreshInfodeskInterval;
                Logger.INSTANCE.m706v(str, y.ٲٴݴ״ٰ(1782084320) + this.refreshInterval);
                startInfodeskTimer();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void onInfodesk(InfodeskData infodesk, boolean isCache, boolean isRefresh) {
        String str = y.ٲٴݴ״ٰ(1782066792);
        synchronized (this) {
            Logger.INSTANCE.m706v(TAG, str + infodesk);
            if (infodesk == null) {
                return;
            }
            this.infodesk = infodesk;
            if (this.coreState.ordinal() < CoreState.START.ordinal()) {
                this.coreState = CoreState.START;
            }
            if (!isCache && !SDKVersion.isPublishing) {
                InfodeskDataCache.savedCache(getContext(), getConfiguration(), infodesk);
            }
            ServerService.setSessionUrl();
            if (this.isGetFirstInfodesk) {
                this.isGetFirstInfodesk = false;
                Tracer.INSTANCE.setTarget(InfodeskHelper.INSTANCE.getTraceSampleRate());
            } else if (isRefresh) {
                Tracer.INSTANCE.onInfodesk();
            }
            PresenceService.setHeartbeatInterval(InfodeskHelper.INSTANCE.getHeartbeatInterval());
            APILogManager.setApiCallLogEnable(InfodeskHelper.INSTANCE.getPercentOfSendingAPICallLog());
            ErrorLogManager.setErrorLogEnable(InfodeskHelper.INSTANCE.getPercentOfSendingErrorLog());
            InfodeskHelper infodeskHelper = InfodeskHelper.INSTANCE;
            String languageCode = KGSystem.getLanguageCode();
            Intrinsics.checkNotNull(languageCode);
            this.customResourceMap = infodeskHelper.getStringSet(languageCode);
            SDKLogManager sDKLogManager = this.logManager;
            Intrinsics.checkNotNull(sDKLogManager);
            sDKLogManager.uploadLogFiles(getContext());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void requestInfodesk() {
        InfodeskData content = loadInfodesk(true).getContent();
        if (content == null) {
            Logger.INSTANCE.m701e(y.ݬֲ֮ܲت(1512313519), y.ݬֲ֮ܲت(1512318079));
        } else {
            ErrorLogManager.sendFailLogData();
            handleInfodesk(instance.getActivity(), content, true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> handleInfodesk(Activity activity, InfodeskData infodesk, boolean isRefresh) {
        boolean checkManifest;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576636046) + infodesk;
        String str2 = y.ݬֲ֮ܲت(1512313519);
        logger.m706v(str2, str);
        if (infodesk == null) {
            return KGResult.INSTANCE.getResult(9999);
        }
        if (InfodeskHelper.INSTANCE.getServerConnectionType() == InfodeskHelper.ServerConnectionType.https) {
            PresenceService.INSTANCE.setHeartbeatUri(InfodeskHelper.INSTANCE.isUseHttpHeartbeat());
        }
        updateRefreshSetting();
        InfodeskNoticeManager.showAlarms(activity, infodesk);
        if (isRefresh) {
            KGResult<Void> showTerminateNoticeOnRefreshInfodesk = InfodeskNoticeManager.showTerminateNoticeOnRefreshInfodesk(activity, infodesk);
            if (showTerminateNoticeOnRefreshInfodesk.isNotSuccess() && showTerminateNoticeOnRefreshInfodesk.getCode() == 9900) {
                AppUtil.terminateApp(activity);
            }
            return KGResult.INSTANCE.getResult(showTerminateNoticeOnRefreshInfodesk);
        }
        KGResult<Void> showNotices = InfodeskNoticeManager.showNotices(activity, infodesk);
        if (showNotices.isNotSuccess()) {
            if (showNotices.getCode() == 9900) {
                AppUtil.terminateApp(activity);
            }
            return KGResult.INSTANCE.getResult(showNotices);
        }
        KGResult<Void> checkUpdate = AppUpdateManager.checkUpdate(activity);
        if (checkUpdate.isNotSuccess()) {
            if (checkUpdate.getCode() == 9900) {
                AppUtil.terminateApp(activity);
            }
            return KGResult.INSTANCE.getResult(checkUpdate);
        }
        if (FeatureManager.INSTANCE.isSupportedFeature(FeatureManager.Feature.push) && !(checkManifest = PushService.checkManifest(activity))) {
            Logger.INSTANCE.m701e(str2, y.ۮڭڭܬި(862546043) + checkManifest);
            return KGResult.INSTANCE.getResult(3000);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setServerTimeStamp(long timeStamp) {
        if (timeStamp > 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - timeStamp;
            this.serverTimeDiffer = Math.abs(uptimeMillis) >= 20000 ? uptimeMillis : 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void onLogin(LocalPlayer localPlayer, IdpAccount authData, LoginData loginData, boolean saveAccount) {
        String str = y.دײܮڳܯ(2051290013);
        synchronized (this) {
            Logger.INSTANCE.m699d(TAG, str + saveAccount);
            this.player = localPlayer;
            this.coreState = CoreState.LOGIN;
            AuthDataManager.setAuthData(getContext(), loginData, authData, saveAccount);
            cancelPauseTimer();
            updateRefreshSetting();
            KGMessage.INSTANCE.clearCacheData();
            setCrashlyticsUserIdentifier();
            synchronized (this.coreStateListeners) {
                Iterator<CoreStateListener> it = this.coreStateListeners.iterator();
                while (it.hasNext()) {
                    it.next().onLogin(localPlayer.getPlayerId());
                }
                Unit unit = Unit.INSTANCE;
            }
            SDKLogManager sDKLogManager = this.logManager;
            Intrinsics.checkNotNull(sDKLogManager);
            sDKLogManager.uploadLogFiles(getContext());
            if (FeatureManager.INSTANCE.isSupportedFeature(FeatureManager.Feature.snsShare)) {
                getSnsShareData();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAuthError(KGResult<?> loginResult) {
        int code;
        return loginResult == null || (code = loginResult.getCode()) == 401 || code == 412 || code == 461 || code == 4010 || code == 4060;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void onLoginFailed(KGResult<?> loginResult, IdpAccount authData) {
        String str = y.ٲٴݴ״ٰ(1782161344);
        String str2 = y.ۮڭڭܬި(862542707);
        synchronized (this) {
            Logger.INSTANCE.m699d(TAG, str2 + loginResult.getCode());
            if (loginResult.getCode() == 3002) {
                return;
            }
            if (isAuthError(loginResult)) {
                Logger.INSTANCE.m699d(TAG, str + idpLogout(authData));
            }
            ServerService.disconnect();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void onLogout(String playerId) {
        Intrinsics.checkNotNullParameter(playerId, "playerId");
        Logger.INSTANCE.m699d(TAG, "onLogout");
        if (this.coreState.ordinal() >= CoreState.START.ordinal()) {
            this.coreState = CoreState.START;
        }
        this.player = null;
        AuthDataManager.clearAuthData(getContext());
        KGMessage.INSTANCE.clearCacheData();
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
        ServerService.disconnect();
        stopInfodeskTimer();
        synchronized (this.coreStateListeners) {
            Iterator<CoreStateListener> it = this.coreStateListeners.iterator();
            while (it.hasNext()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CoreManager$onLogout$1$1(it.next(), playerId, null), 3, null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized void onUnregister(String playerId) {
        Logger.INSTANCE.m699d(TAG, "onUnregister");
        if (this.coreState.ordinal() >= CoreState.START.ordinal()) {
            this.coreState = CoreState.START;
        }
        this.player = null;
        AuthDataManager.clearAuthData(getContext());
        KGMessage.INSTANCE.clearCacheData();
        ServerService.disconnect();
        stopInfodeskTimer();
        synchronized (this.coreStateListeners) {
            Iterator<CoreStateListener> it = this.coreStateListeners.iterator();
            while (it.hasNext()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CoreManager$onUnregister$1$1(it.next(), playerId, null), 3, null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void startPauseTimer() {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051279085);
        String str2 = y.ݬֲ֮ܲت(1512313519);
        logger.m699d(str2, str);
        try {
            cancelPauseTimer();
            this.isPaused = true;
            this.pauseTimer = new ScheduledThreadPoolExecutor(1).schedule(new Runnable() { // from class: com.kakaogame.core.CoreManager$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    CoreManager.startPauseTimer$lambda$34(CoreManager.this);
                }
            }, 20000L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            Logger.INSTANCE.m700d(str2, e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void startPauseTimer$lambda$34(CoreManager coreManager) {
        Intrinsics.checkNotNullParameter(coreManager, y.ٴسسݬߨ(1393322442));
        coreManager.pauseInternal();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void cancelPauseTimer() {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512312975);
        String str2 = y.ݬֲ֮ܲت(1512313519);
        logger.m699d(str2, str);
        this.isPaused = false;
        try {
            ScheduledFuture<?> scheduledFuture = this.pauseTimer;
            if (scheduledFuture != null) {
                Intrinsics.checkNotNull(scheduledFuture);
                scheduledFuture.cancel(false);
                this.pauseTimer = null;
            }
        } catch (Exception e) {
            Logger.INSTANCE.m700d(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void pauseInternal() {
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.ۮڭڭܬި(862542843));
        try {
            if (this.isPaused) {
                ServerService.disconnect();
                synchronized (this.coreStateListeners) {
                    Iterator<CoreStateListener> it = this.coreStateListeners.iterator();
                    while (it.hasNext()) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CoreManager$pauseInternal$1$1(it.next(), null), 3, null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        } catch (Exception e) {
            Logger.INSTANCE.m700d(y.ݬֲ֮ܲت(1512313519), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initModules() {
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512313519), y.دײܮڳܯ(2051291605));
        Context applicationContext = getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, y.ۮڭڭܬި(862543163));
        this.logManager = new SDKLogManager(applicationContext);
        AuthDataManager.initialize(getContext(), getConfiguration());
        SdkManager.INSTANCE.initialize(getContext());
        OpenApiService.INSTANCE.initialize(getConfiguration());
        InfodeskService.initialize(getConfiguration());
        ServerService.initialize(getConfiguration());
        AuthService.initialize(getConfiguration());
        PlayerService.initialize(getConfiguration());
        IdpAuthManager.initialize(getActivity());
        PresenceService.initialize();
        LocaleManager.initialize(getContext(), getConfiguration());
        ErrorLogManager.initialize();
        HttpService.initialize((String) getConfiguration().get(y.٬ݯح׭٩(576647390)));
        PushService.initialize();
        BasicLogService.initialize();
        PlayerLogManager.initialize();
        APILogManager.initialize();
        LeaderboardService.initialize();
        LifecycleService.initialize();
    }

    /* compiled from: CoreManager.kt */
    @Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/core/CoreManager$Companion;", "", "()V", "REFRESH_OFF_KEY", "", "TAG", "instance", "Lcom/kakaogame/core/CoreManager;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakaogame/core/CoreManager;", "testGoogleErrorCode", "", "testKakaoErrorCode", "getFirebase", "Lcom/kakaogame/log/IFirebase;", "className", "getResourceString", "name", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final CoreManager getInstance() {
            return CoreManager.instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final IFirebase getFirebase(String className) {
            Logger logger = Logger.INSTANCE;
            String str = y.ٴسسݬߨ(1393375458) + className;
            String str2 = y.ݬֲ֮ܲت(1512313519);
            logger.m699d(str2, str);
            try {
                Object newInstance = Class.forName(className).newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.kakaogame.log.IFirebase");
                return (IFirebase) newInstance;
            } catch (Throwable unused) {
                Logger.INSTANCE.m708w(str2, y.ۮڭڭܬި(862539947) + className);
                return null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final String getResourceString(String name) {
            Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
            if (getInstance().customResourceMap.containsKey(name)) {
                String str = (String) getInstance().customResourceMap.get(name);
                return str == null ? ResourceUtil.getString(getInstance().getContext(), name) : str;
            }
            return ResourceUtil.getString(getInstance().getContext(), name);
        }
    }
}
