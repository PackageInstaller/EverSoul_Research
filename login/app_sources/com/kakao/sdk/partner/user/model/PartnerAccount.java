package com.kakao.sdk.partner.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.user.Constants;
import com.kakao.sdk.user.model.AgeRange;
import com.kakao.sdk.user.model.Gender;
import com.kakao.sdk.user.model.Profile;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.server.ServerConstants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PartnerUser.kt */
@Metadata(m838d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\bU\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\n\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\n\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\n\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\n\u0012\b\u0010,\u001a\u0004\u0018\u00010-\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010/J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010[\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010]\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010_\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010a\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010d\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010g\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010j\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010l\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010n\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010q\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010s\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010w\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010-HÆ\u0003¢\u0006\u0002\u0010WJ\u0010\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010|\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103JØ\u0003\u0010\u0080\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0081\u0001J\u000b\u0010\u0082\u0001\u001a\u00030\u0083\u0001HÖ\u0001J\u0016\u0010\u0084\u0001\u001a\u00020\u00032\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001HÖ\u0003J\u000b\u0010\u0087\u0001\u001a\u00030\u0083\u0001HÖ\u0001J\n\u0010\u0088\u0001\u001a\u00020\nHÖ\u0001J\u001f\u0010\u0089\u0001\u001a\u00030\u008a\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u0083\u0001HÖ\u0001R\u0013\u0010+\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0015\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b7\u00103R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b8\u00101R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b9\u00103R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b<\u00103R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b=\u00101R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b@\u00103R\u0013\u0010'\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bA\u00101R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bB\u00101R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bC\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bF\u00103R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b\f\u00103R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b\r\u00103R\u0015\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b&\u00103R\u0015\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b)\u00103R\u0015\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b(\u00103R\u0013\u0010!\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bG\u00101R\u0015\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bH\u00103R\u0013\u0010#\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bI\u0010ER\u0015\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bJ\u00103R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bK\u00101R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bL\u00103R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bM\u00101R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bN\u00103R\u0013\u0010%\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bO\u00101R\u0015\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bP\u00103R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bS\u00103R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bT\u00103R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bU\u00103R\u0015\u0010,\u001a\u0004\u0018\u00010-¢\u0006\n\n\u0002\u0010X\u001a\u0004\bV\u0010WR\u0015\u0010.\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\bY\u00103¨\u0006\u008e\u0001"}, m839d2 = {"Lcom/kakao/sdk/partner/user/model/PartnerAccount;", "Landroid/os/Parcelable;", "profileNeedsAgreement", "", "profileNicknameNeedsAgreement", "profileImageNeedsAgreement", "profile", "Lcom/kakao/sdk/user/model/Profile;", "nameNeedsAgreement", "name", "", "emailNeedsAgreement", "isEmailValid", "isEmailVerified", "email", "ageRangeNeedsAgreement", "ageRange", "Lcom/kakao/sdk/user/model/AgeRange;", "birthyearNeedsAgreement", Constants.BIRTHYEAR, "birthdayNeedsAgreement", Constants.BIRTHDAY, "birthdayType", "genderNeedsAgreement", Constants.GENDER, "Lcom/kakao/sdk/user/model/Gender;", "ciNeedsAgreement", "ci", "ciAuthenticatedAt", "Ljava/util/Date;", "legalNameNeedsAgreement", "legalName", "legalBirthDateNeedsAgreement", "legalBirthDate", "legalGenderNeedsAgreement", "legalGender", "phoneNumberNeedsAgreement", ServerConstants.PHONE_NUMBER, "isKakaotalkUser", "displayId", "isKoreanNeedsAgreement", "isKorean", "accountCreationDateNeedsAgreement", "accountCreationDate", KGKakao2Auth.KEY_SERVICE_USER_ID, "", "unificationStatus", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Profile;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/AgeRange;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getAccountCreationDate", "()Ljava/lang/String;", "getAccountCreationDateNeedsAgreement", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAgeRange", "()Lcom/kakao/sdk/user/model/AgeRange;", "getAgeRangeNeedsAgreement", "getBirthday", "getBirthdayNeedsAgreement", "getBirthdayType", "getBirthyear", "getBirthyearNeedsAgreement", "getCi", "getCiAuthenticatedAt", "()Ljava/util/Date;", "getCiNeedsAgreement", "getDisplayId", "getEmail", "getEmailNeedsAgreement", "getGender", "()Lcom/kakao/sdk/user/model/Gender;", "getGenderNeedsAgreement", "getLegalBirthDate", "getLegalBirthDateNeedsAgreement", "getLegalGender", "getLegalGenderNeedsAgreement", "getLegalName", "getLegalNameNeedsAgreement", "getName", "getNameNeedsAgreement", "getPhoneNumber", "getPhoneNumberNeedsAgreement", "getProfile", "()Lcom/kakao/sdk/user/model/Profile;", "getProfileImageNeedsAgreement", "getProfileNeedsAgreement", "getProfileNicknameNeedsAgreement", "getServiceUserId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUnificationStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Profile;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/AgeRange;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/kakao/sdk/partner/user/model/PartnerAccount;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PartnerAccount implements Parcelable {
    public static final Parcelable.Creator<PartnerAccount> CREATOR = new Creator();
    private final String accountCreationDate;
    private final Boolean accountCreationDateNeedsAgreement;
    private final AgeRange ageRange;
    private final Boolean ageRangeNeedsAgreement;
    private final String birthday;
    private final Boolean birthdayNeedsAgreement;
    private final String birthdayType;
    private final String birthyear;
    private final Boolean birthyearNeedsAgreement;
    private final String ci;
    private final Date ciAuthenticatedAt;
    private final Boolean ciNeedsAgreement;
    private final String displayId;
    private final String email;
    private final Boolean emailNeedsAgreement;
    private final Gender gender;
    private final Boolean genderNeedsAgreement;
    private final Boolean isEmailValid;
    private final Boolean isEmailVerified;
    private final Boolean isKakaotalkUser;
    private final Boolean isKorean;
    private final Boolean isKoreanNeedsAgreement;
    private final String legalBirthDate;
    private final Boolean legalBirthDateNeedsAgreement;
    private final Gender legalGender;
    private final Boolean legalGenderNeedsAgreement;
    private final String legalName;
    private final Boolean legalNameNeedsAgreement;
    private final String name;
    private final Boolean nameNeedsAgreement;
    private final String phoneNumber;
    private final Boolean phoneNumberNeedsAgreement;
    private final Profile profile;
    private final Boolean profileImageNeedsAgreement;
    private final Boolean profileNeedsAgreement;
    private final Boolean profileNicknameNeedsAgreement;
    private final Long serviceUserId;
    private final Boolean unificationStatus;

    /* compiled from: PartnerUser.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<PartnerAccount> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerAccount createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            Boolean valueOf6;
            Boolean valueOf7;
            Boolean valueOf8;
            Boolean valueOf9;
            Boolean valueOf10;
            Boolean valueOf11;
            Boolean valueOf12;
            Boolean valueOf13;
            Boolean valueOf14;
            Boolean valueOf15;
            Boolean valueOf16;
            Boolean valueOf17;
            Boolean valueOf18;
            Boolean valueOf19;
            Boolean valueOf20;
            Boolean valueOf21;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            Profile profile = (Profile) parcel.readParcelable(PartnerAccount.class.getClassLoader());
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf5 = null;
            } else {
                valueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf6 = null;
            } else {
                valueOf6 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf7 = null;
            } else {
                valueOf7 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString2 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf8 = null;
            } else {
                valueOf8 = Boolean.valueOf(parcel.readInt() != 0);
            }
            AgeRange valueOf22 = parcel.readInt() == 0 ? null : AgeRange.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                valueOf9 = null;
            } else {
                valueOf9 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf10 = null;
            } else {
                valueOf10 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf11 = null;
            } else {
                valueOf11 = Boolean.valueOf(parcel.readInt() != 0);
            }
            Gender valueOf23 = parcel.readInt() == 0 ? null : Gender.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                valueOf12 = null;
            } else {
                valueOf12 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString6 = parcel.readString();
            Date date = (Date) parcel.readSerializable();
            if (parcel.readInt() == 0) {
                valueOf13 = null;
            } else {
                valueOf13 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString7 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf14 = null;
            } else {
                valueOf14 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString8 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf15 = null;
            } else {
                valueOf15 = Boolean.valueOf(parcel.readInt() != 0);
            }
            Gender valueOf24 = parcel.readInt() == 0 ? null : Gender.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                valueOf16 = null;
            } else {
                valueOf16 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString9 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf17 = null;
            } else {
                valueOf17 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString10 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf18 = null;
            } else {
                valueOf18 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf19 = null;
            } else {
                valueOf19 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf20 = null;
            } else {
                valueOf20 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString11 = parcel.readString();
            Long valueOf25 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() == 0) {
                valueOf21 = null;
            } else {
                valueOf21 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PartnerAccount(valueOf, valueOf2, valueOf3, profile, valueOf4, readString, valueOf5, valueOf6, valueOf7, readString2, valueOf8, valueOf22, valueOf9, readString3, valueOf10, readString4, readString5, valueOf11, valueOf23, valueOf12, readString6, date, valueOf13, readString7, valueOf14, readString8, valueOf15, valueOf24, valueOf16, readString9, valueOf17, readString10, valueOf18, valueOf19, valueOf20, readString11, valueOf25, valueOf21);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerAccount[] newArray(int i) {
            return new PartnerAccount[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component1() {
        return this.profileNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component10() {
        return this.email;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component11() {
        return this.ageRangeNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgeRange component12() {
        return this.ageRange;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component13() {
        return this.birthyearNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component14() {
        return this.birthyear;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component15() {
        return this.birthdayNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component16() {
        return this.birthday;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component17() {
        return this.birthdayType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component18() {
        return this.genderNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Gender component19() {
        return this.gender;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component2() {
        return this.profileNicknameNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component20() {
        return this.ciNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component21() {
        return this.ci;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component22() {
        return this.ciAuthenticatedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component23() {
        return this.legalNameNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component24() {
        return this.legalName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component25() {
        return this.legalBirthDateNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component26() {
        return this.legalBirthDate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component27() {
        return this.legalGenderNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Gender component28() {
        return this.legalGender;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component29() {
        return this.phoneNumberNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component3() {
        return this.profileImageNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component30() {
        return this.phoneNumber;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component31() {
        return this.isKakaotalkUser;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component32() {
        return this.displayId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component33() {
        return this.isKoreanNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component34() {
        return this.isKorean;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component35() {
        return this.accountCreationDateNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component36() {
        return this.accountCreationDate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component37() {
        return this.serviceUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component38() {
        return this.unificationStatus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Profile component4() {
        return this.profile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component5() {
        return this.nameNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component6() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component7() {
        return this.emailNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component8() {
        return this.isEmailValid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component9() {
        return this.isEmailVerified;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PartnerAccount copy(Boolean profileNeedsAgreement, Boolean profileNicknameNeedsAgreement, Boolean profileImageNeedsAgreement, Profile profile, Boolean nameNeedsAgreement, String name, Boolean emailNeedsAgreement, Boolean isEmailValid, Boolean isEmailVerified, String email, Boolean ageRangeNeedsAgreement, AgeRange ageRange, Boolean birthyearNeedsAgreement, String birthyear, Boolean birthdayNeedsAgreement, String birthday, String birthdayType, Boolean genderNeedsAgreement, Gender gender, Boolean ciNeedsAgreement, String ci, Date ciAuthenticatedAt, Boolean legalNameNeedsAgreement, String legalName, Boolean legalBirthDateNeedsAgreement, String legalBirthDate, Boolean legalGenderNeedsAgreement, Gender legalGender, Boolean phoneNumberNeedsAgreement, String phoneNumber, Boolean isKakaotalkUser, String displayId, Boolean isKoreanNeedsAgreement, Boolean isKorean, Boolean accountCreationDateNeedsAgreement, String accountCreationDate, Long serviceUserId, Boolean unificationStatus) {
        return new PartnerAccount(profileNeedsAgreement, profileNicknameNeedsAgreement, profileImageNeedsAgreement, profile, nameNeedsAgreement, name, emailNeedsAgreement, isEmailValid, isEmailVerified, email, ageRangeNeedsAgreement, ageRange, birthyearNeedsAgreement, birthyear, birthdayNeedsAgreement, birthday, birthdayType, genderNeedsAgreement, gender, ciNeedsAgreement, ci, ciAuthenticatedAt, legalNameNeedsAgreement, legalName, legalBirthDateNeedsAgreement, legalBirthDate, legalGenderNeedsAgreement, legalGender, phoneNumberNeedsAgreement, phoneNumber, isKakaotalkUser, displayId, isKoreanNeedsAgreement, isKorean, accountCreationDateNeedsAgreement, accountCreationDate, serviceUserId, unificationStatus);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PartnerAccount)) {
            return false;
        }
        PartnerAccount partnerAccount = (PartnerAccount) other;
        return Intrinsics.areEqual(this.profileNeedsAgreement, partnerAccount.profileNeedsAgreement) && Intrinsics.areEqual(this.profileNicknameNeedsAgreement, partnerAccount.profileNicknameNeedsAgreement) && Intrinsics.areEqual(this.profileImageNeedsAgreement, partnerAccount.profileImageNeedsAgreement) && Intrinsics.areEqual(this.profile, partnerAccount.profile) && Intrinsics.areEqual(this.nameNeedsAgreement, partnerAccount.nameNeedsAgreement) && Intrinsics.areEqual(this.name, partnerAccount.name) && Intrinsics.areEqual(this.emailNeedsAgreement, partnerAccount.emailNeedsAgreement) && Intrinsics.areEqual(this.isEmailValid, partnerAccount.isEmailValid) && Intrinsics.areEqual(this.isEmailVerified, partnerAccount.isEmailVerified) && Intrinsics.areEqual(this.email, partnerAccount.email) && Intrinsics.areEqual(this.ageRangeNeedsAgreement, partnerAccount.ageRangeNeedsAgreement) && this.ageRange == partnerAccount.ageRange && Intrinsics.areEqual(this.birthyearNeedsAgreement, partnerAccount.birthyearNeedsAgreement) && Intrinsics.areEqual(this.birthyear, partnerAccount.birthyear) && Intrinsics.areEqual(this.birthdayNeedsAgreement, partnerAccount.birthdayNeedsAgreement) && Intrinsics.areEqual(this.birthday, partnerAccount.birthday) && Intrinsics.areEqual(this.birthdayType, partnerAccount.birthdayType) && Intrinsics.areEqual(this.genderNeedsAgreement, partnerAccount.genderNeedsAgreement) && this.gender == partnerAccount.gender && Intrinsics.areEqual(this.ciNeedsAgreement, partnerAccount.ciNeedsAgreement) && Intrinsics.areEqual(this.ci, partnerAccount.ci) && Intrinsics.areEqual(this.ciAuthenticatedAt, partnerAccount.ciAuthenticatedAt) && Intrinsics.areEqual(this.legalNameNeedsAgreement, partnerAccount.legalNameNeedsAgreement) && Intrinsics.areEqual(this.legalName, partnerAccount.legalName) && Intrinsics.areEqual(this.legalBirthDateNeedsAgreement, partnerAccount.legalBirthDateNeedsAgreement) && Intrinsics.areEqual(this.legalBirthDate, partnerAccount.legalBirthDate) && Intrinsics.areEqual(this.legalGenderNeedsAgreement, partnerAccount.legalGenderNeedsAgreement) && this.legalGender == partnerAccount.legalGender && Intrinsics.areEqual(this.phoneNumberNeedsAgreement, partnerAccount.phoneNumberNeedsAgreement) && Intrinsics.areEqual(this.phoneNumber, partnerAccount.phoneNumber) && Intrinsics.areEqual(this.isKakaotalkUser, partnerAccount.isKakaotalkUser) && Intrinsics.areEqual(this.displayId, partnerAccount.displayId) && Intrinsics.areEqual(this.isKoreanNeedsAgreement, partnerAccount.isKoreanNeedsAgreement) && Intrinsics.areEqual(this.isKorean, partnerAccount.isKorean) && Intrinsics.areEqual(this.accountCreationDateNeedsAgreement, partnerAccount.accountCreationDateNeedsAgreement) && Intrinsics.areEqual(this.accountCreationDate, partnerAccount.accountCreationDate) && Intrinsics.areEqual(this.serviceUserId, partnerAccount.serviceUserId) && Intrinsics.areEqual(this.unificationStatus, partnerAccount.unificationStatus);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Boolean bool = this.profileNeedsAgreement;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.profileNicknameNeedsAgreement;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.profileImageNeedsAgreement;
        int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Profile profile = this.profile;
        int hashCode4 = (hashCode3 + (profile == null ? 0 : profile.hashCode())) * 31;
        Boolean bool4 = this.nameNeedsAgreement;
        int hashCode5 = (hashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str = this.name;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool5 = this.emailNeedsAgreement;
        int hashCode7 = (hashCode6 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.isEmailValid;
        int hashCode8 = (hashCode7 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.isEmailVerified;
        int hashCode9 = (hashCode8 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        String str2 = this.email;
        int hashCode10 = (hashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool8 = this.ageRangeNeedsAgreement;
        int hashCode11 = (hashCode10 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        AgeRange ageRange = this.ageRange;
        int hashCode12 = (hashCode11 + (ageRange == null ? 0 : ageRange.hashCode())) * 31;
        Boolean bool9 = this.birthyearNeedsAgreement;
        int hashCode13 = (hashCode12 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        String str3 = this.birthyear;
        int hashCode14 = (hashCode13 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool10 = this.birthdayNeedsAgreement;
        int hashCode15 = (hashCode14 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        String str4 = this.birthday;
        int hashCode16 = (hashCode15 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.birthdayType;
        int hashCode17 = (hashCode16 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool11 = this.genderNeedsAgreement;
        int hashCode18 = (hashCode17 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        Gender gender = this.gender;
        int hashCode19 = (hashCode18 + (gender == null ? 0 : gender.hashCode())) * 31;
        Boolean bool12 = this.ciNeedsAgreement;
        int hashCode20 = (hashCode19 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
        String str6 = this.ci;
        int hashCode21 = (hashCode20 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Date date = this.ciAuthenticatedAt;
        int hashCode22 = (hashCode21 + (date == null ? 0 : date.hashCode())) * 31;
        Boolean bool13 = this.legalNameNeedsAgreement;
        int hashCode23 = (hashCode22 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
        String str7 = this.legalName;
        int hashCode24 = (hashCode23 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool14 = this.legalBirthDateNeedsAgreement;
        int hashCode25 = (hashCode24 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
        String str8 = this.legalBirthDate;
        int hashCode26 = (hashCode25 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool15 = this.legalGenderNeedsAgreement;
        int hashCode27 = (hashCode26 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
        Gender gender2 = this.legalGender;
        int hashCode28 = (hashCode27 + (gender2 == null ? 0 : gender2.hashCode())) * 31;
        Boolean bool16 = this.phoneNumberNeedsAgreement;
        int hashCode29 = (hashCode28 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
        String str9 = this.phoneNumber;
        int hashCode30 = (hashCode29 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool17 = this.isKakaotalkUser;
        int hashCode31 = (hashCode30 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
        String str10 = this.displayId;
        int hashCode32 = (hashCode31 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Boolean bool18 = this.isKoreanNeedsAgreement;
        int hashCode33 = (hashCode32 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
        Boolean bool19 = this.isKorean;
        int hashCode34 = (hashCode33 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
        Boolean bool20 = this.accountCreationDateNeedsAgreement;
        int hashCode35 = (hashCode34 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
        String str11 = this.accountCreationDate;
        int hashCode36 = (hashCode35 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Long l = this.serviceUserId;
        int hashCode37 = (hashCode36 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool21 = this.unificationStatus;
        return hashCode37 + (bool21 != null ? bool21.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("PartnerAccount(profileNeedsAgreement=");
        sb.append(this.profileNeedsAgreement).append(", profileNicknameNeedsAgreement=").append(this.profileNicknameNeedsAgreement).append(", profileImageNeedsAgreement=").append(this.profileImageNeedsAgreement).append(", profile=").append(this.profile).append(", nameNeedsAgreement=").append(this.nameNeedsAgreement).append(", name=").append((Object) this.name).append(", emailNeedsAgreement=").append(this.emailNeedsAgreement).append(", isEmailValid=").append(this.isEmailValid).append(", isEmailVerified=").append(this.isEmailVerified).append(", email=").append((Object) this.email).append(", ageRangeNeedsAgreement=").append(this.ageRangeNeedsAgreement).append(", ageRange=");
        sb.append(this.ageRange).append(", birthyearNeedsAgreement=").append(this.birthyearNeedsAgreement).append(", birthyear=").append((Object) this.birthyear).append(", birthdayNeedsAgreement=").append(this.birthdayNeedsAgreement).append(", birthday=").append((Object) this.birthday).append(", birthdayType=").append((Object) this.birthdayType).append(", genderNeedsAgreement=").append(this.genderNeedsAgreement).append(", gender=").append(this.gender).append(", ciNeedsAgreement=").append(this.ciNeedsAgreement).append(", ci=").append((Object) this.ci).append(", ciAuthenticatedAt=").append(this.ciAuthenticatedAt).append(", legalNameNeedsAgreement=").append(this.legalNameNeedsAgreement);
        sb.append(", legalName=").append((Object) this.legalName).append(", legalBirthDateNeedsAgreement=").append(this.legalBirthDateNeedsAgreement).append(", legalBirthDate=").append((Object) this.legalBirthDate).append(", legalGenderNeedsAgreement=").append(this.legalGenderNeedsAgreement).append(", legalGender=").append(this.legalGender).append(", phoneNumberNeedsAgreement=").append(this.phoneNumberNeedsAgreement).append(", phoneNumber=").append((Object) this.phoneNumber).append(", isKakaotalkUser=").append(this.isKakaotalkUser).append(", displayId=").append((Object) this.displayId).append(", isKoreanNeedsAgreement=").append(this.isKoreanNeedsAgreement).append(", isKorean=").append(this.isKorean).append(", accountCreationDateNeedsAgreement=");
        sb.append(this.accountCreationDateNeedsAgreement).append(", accountCreationDate=").append((Object) this.accountCreationDate).append(", serviceUserId=").append(this.serviceUserId).append(", unificationStatus=").append(this.unificationStatus).append(')');
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Boolean bool = this.profileNeedsAgreement;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.profileNicknameNeedsAgreement;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.profileImageNeedsAgreement;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        parcel.writeParcelable(this.profile, flags);
        Boolean bool4 = this.nameNeedsAgreement;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.name);
        Boolean bool5 = this.emailNeedsAgreement;
        if (bool5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        Boolean bool6 = this.isEmailValid;
        if (bool6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        Boolean bool7 = this.isEmailVerified;
        if (bool7 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool7.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.email);
        Boolean bool8 = this.ageRangeNeedsAgreement;
        if (bool8 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool8.booleanValue() ? 1 : 0);
        }
        AgeRange ageRange = this.ageRange;
        if (ageRange == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(ageRange.name());
        }
        Boolean bool9 = this.birthyearNeedsAgreement;
        if (bool9 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool9.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.birthyear);
        Boolean bool10 = this.birthdayNeedsAgreement;
        if (bool10 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool10.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.birthday);
        parcel.writeString(this.birthdayType);
        Boolean bool11 = this.genderNeedsAgreement;
        if (bool11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool11.booleanValue() ? 1 : 0);
        }
        Gender gender = this.gender;
        if (gender == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(gender.name());
        }
        Boolean bool12 = this.ciNeedsAgreement;
        if (bool12 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool12.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.ci);
        parcel.writeSerializable(this.ciAuthenticatedAt);
        Boolean bool13 = this.legalNameNeedsAgreement;
        if (bool13 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool13.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.legalName);
        Boolean bool14 = this.legalBirthDateNeedsAgreement;
        if (bool14 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool14.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.legalBirthDate);
        Boolean bool15 = this.legalGenderNeedsAgreement;
        if (bool15 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool15.booleanValue() ? 1 : 0);
        }
        Gender gender2 = this.legalGender;
        if (gender2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(gender2.name());
        }
        Boolean bool16 = this.phoneNumberNeedsAgreement;
        if (bool16 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool16.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.phoneNumber);
        Boolean bool17 = this.isKakaotalkUser;
        if (bool17 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool17.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.displayId);
        Boolean bool18 = this.isKoreanNeedsAgreement;
        if (bool18 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool18.booleanValue() ? 1 : 0);
        }
        Boolean bool19 = this.isKorean;
        if (bool19 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool19.booleanValue() ? 1 : 0);
        }
        Boolean bool20 = this.accountCreationDateNeedsAgreement;
        if (bool20 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool20.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.accountCreationDate);
        Long l = this.serviceUserId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        Boolean bool21 = this.unificationStatus;
        if (bool21 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool21.booleanValue() ? 1 : 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PartnerAccount(Boolean bool, Boolean bool2, Boolean bool3, Profile profile, Boolean bool4, String str, Boolean bool5, Boolean bool6, Boolean bool7, String str2, Boolean bool8, AgeRange ageRange, Boolean bool9, String str3, Boolean bool10, String str4, String str5, Boolean bool11, Gender gender, Boolean bool12, String str6, Date date, Boolean bool13, String str7, Boolean bool14, String str8, Boolean bool15, Gender gender2, Boolean bool16, String str9, Boolean bool17, String str10, Boolean bool18, Boolean bool19, Boolean bool20, String str11, Long l, Boolean bool21) {
        this.profileNeedsAgreement = bool;
        this.profileNicknameNeedsAgreement = bool2;
        this.profileImageNeedsAgreement = bool3;
        this.profile = profile;
        this.nameNeedsAgreement = bool4;
        this.name = str;
        this.emailNeedsAgreement = bool5;
        this.isEmailValid = bool6;
        this.isEmailVerified = bool7;
        this.email = str2;
        this.ageRangeNeedsAgreement = bool8;
        this.ageRange = ageRange;
        this.birthyearNeedsAgreement = bool9;
        this.birthyear = str3;
        this.birthdayNeedsAgreement = bool10;
        this.birthday = str4;
        this.birthdayType = str5;
        this.genderNeedsAgreement = bool11;
        this.gender = gender;
        this.ciNeedsAgreement = bool12;
        this.ci = str6;
        this.ciAuthenticatedAt = date;
        this.legalNameNeedsAgreement = bool13;
        this.legalName = str7;
        this.legalBirthDateNeedsAgreement = bool14;
        this.legalBirthDate = str8;
        this.legalGenderNeedsAgreement = bool15;
        this.legalGender = gender2;
        this.phoneNumberNeedsAgreement = bool16;
        this.phoneNumber = str9;
        this.isKakaotalkUser = bool17;
        this.displayId = str10;
        this.isKoreanNeedsAgreement = bool18;
        this.isKorean = bool19;
        this.accountCreationDateNeedsAgreement = bool20;
        this.accountCreationDate = str11;
        this.serviceUserId = l;
        this.unificationStatus = bool21;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getProfileNeedsAgreement() {
        return this.profileNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getProfileNicknameNeedsAgreement() {
        return this.profileNicknameNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getProfileImageNeedsAgreement() {
        return this.profileImageNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Profile getProfile() {
        return this.profile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getNameNeedsAgreement() {
        return this.nameNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getEmailNeedsAgreement() {
        return this.emailNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isEmailValid() {
        return this.isEmailValid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isEmailVerified() {
        return this.isEmailVerified;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEmail() {
        return this.email;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getAgeRangeNeedsAgreement() {
        return this.ageRangeNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgeRange getAgeRange() {
        return this.ageRange;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getBirthyearNeedsAgreement() {
        return this.birthyearNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBirthyear() {
        return this.birthyear;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getBirthdayNeedsAgreement() {
        return this.birthdayNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBirthday() {
        return this.birthday;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBirthdayType() {
        return this.birthdayType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getGenderNeedsAgreement() {
        return this.genderNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Gender getGender() {
        return this.gender;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getCiNeedsAgreement() {
        return this.ciNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCi() {
        return this.ci;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getCiAuthenticatedAt() {
        return this.ciAuthenticatedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getLegalNameNeedsAgreement() {
        return this.legalNameNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLegalName() {
        return this.legalName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getLegalBirthDateNeedsAgreement() {
        return this.legalBirthDateNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLegalBirthDate() {
        return this.legalBirthDate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getLegalGenderNeedsAgreement() {
        return this.legalGenderNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Gender getLegalGender() {
        return this.legalGender;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getPhoneNumberNeedsAgreement() {
        return this.phoneNumberNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isKakaotalkUser() {
        return this.isKakaotalkUser;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDisplayId() {
        return this.displayId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isKoreanNeedsAgreement() {
        return this.isKoreanNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean isKorean() {
        return this.isKorean;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getAccountCreationDateNeedsAgreement() {
        return this.accountCreationDateNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAccountCreationDate() {
        return this.accountCreationDate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getServiceUserId() {
        return this.serviceUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getUnificationStatus() {
        return this.unificationStatus;
    }
}
