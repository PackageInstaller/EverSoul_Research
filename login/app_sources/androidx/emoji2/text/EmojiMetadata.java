package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class EmojiMetadata {
    public static final int HAS_GLYPH_ABSENT = 1;
    public static final int HAS_GLYPH_EXISTS = 2;
    public static final int HAS_GLYPH_UNKNOWN = 0;
    private static final ThreadLocal<MetadataItem> sMetadataItem = new ThreadLocal<>();
    private volatile int mHasGlyph = 0;
    private final int mIndex;
    private final MetadataRepo mMetadataRepo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EmojiMetadata(MetadataRepo metadataRepo, int i) {
        this.mMetadataRepo = metadataRepo;
        this.mIndex = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void draw(Canvas canvas, float f, float f2, Paint paint) {
        Typeface typeface = this.mMetadataRepo.getTypeface();
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(this.mMetadataRepo.getEmojiCharArray(), this.mIndex * 2, 2, f, f2, paint);
        paint.setTypeface(typeface2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> threadLocal = sMetadataItem;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.mMetadataRepo.getMetadataList().list(metadataItem, this.mIndex);
        return metadataItem;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getId() {
        return getMetadataItem().m56id();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getWidth() {
        return getMetadataItem().width();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getHeight() {
        return getMetadataItem().height();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getCompatAdded() {
        return getMetadataItem().compatAdded();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getHasGlyph() {
        return this.mHasGlyph;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resetHasGlyphCache() {
        this.mHasGlyph = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHasGlyph(boolean z) {
        this.mHasGlyph = z ? 2 : 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCodepointAt(int i) {
        return getMetadataItem().codepoints(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(getId()));
        sb.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int i = 0; i < codepointsLength; i++) {
            sb.append(Integer.toHexString(getCodepointAt(i)));
            sb.append(StringUtils.SPACE);
        }
        return sb.toString();
    }
}
