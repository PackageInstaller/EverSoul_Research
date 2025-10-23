package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TileList(int i) {
        this.mTileSize = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T getItemAt(int i) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i)) {
            int indexOfKey = this.mTiles.indexOfKey(i - (i % this.mTileSize));
            if (indexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(indexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int size() {
        return this.mTiles.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        this.mTiles.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Tile<T> getAtIndex(int i) {
        return this.mTiles.valueAt(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
        this.mTiles.setValueAt(indexOfKey, tile);
        if (this.mLastAccessedTile == valueAt) {
            this.mLastAccessedTile = tile;
        }
        return valueAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Tile<T> removeAtPos(int i) {
        Tile<T> tile = this.mTiles.get(i);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i);
        return tile;
    }

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Tile(Class<T> cls, int i) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean containsPosition(int i) {
            int i2 = this.mStartPosition;
            return i2 <= i && i < i2 + this.mItemCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        T getByPosition(int i) {
            return this.mItems[i - this.mStartPosition];
        }
    }
}
