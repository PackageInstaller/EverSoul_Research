package com.singular.sdk.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import java.io.IOException;

/* loaded from: classes3.dex */
public class SQLitePersistentQueue implements Queue {
    private static final SingularLog logger = SingularLog.getLogger("SQLitePersistentQueue");
    private SQLiteManager sqlite;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SQLitePersistentQueue(Context context) {
        this.sqlite = new SQLiteManager(new SQLiteHelper(context.getApplicationContext()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Queue
    public synchronized void add(String str) throws IOException {
        if (this.sqlite.insert(str) == -1) {
            throw new IOException("Failed to add element = " + str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Queue
    public synchronized String peek() throws IOException {
        return this.sqlite.getHead();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Queue
    public synchronized void remove() throws IOException {
        this.sqlite.removeHead();
    }

    private static class SQLiteManager {
        private final SQLiteHelper helper;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SQLiteManager(SQLiteHelper sQLiteHelper) {
            this.helper = sQLiteHelper;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        long insert(java.lang.String r8) throws java.io.IOException {
            /*
                r7 = this;
                java.lang.String r0 = "insert() row = "
                android.content.ContentValues r1 = new android.content.ContentValues
                r1.<init>()
                java.lang.String r2 = "value"
                r1.put(r2, r8)
                r8 = 0
                com.singular.sdk.internal.SQLitePersistentQueue$SQLiteHelper r2 = r7.helper     // Catch: java.lang.Throwable -> L5e android.database.SQLException -> L62
                android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L5e android.database.SQLException -> L62
                java.lang.String r3 = "events"
                long r3 = r2.insert(r3, r8, r1)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                com.singular.sdk.internal.SingularLog r8 = com.singular.sdk.internal.SQLitePersistentQueue.access$000()     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                r1.<init>(r0)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                java.lang.StringBuilder r0 = r1.append(r3)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                java.lang.String r0 = r0.toString()     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                r8.debug(r0)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                long r0 = r7.getCount(r2)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                r5 = 10000(0x2710, double:4.9407E-320)
                int r8 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r8 <= 0) goto L56
                com.singular.sdk.internal.SingularLog r8 = com.singular.sdk.internal.SQLitePersistentQueue.access$000()     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                java.lang.String r5 = "Pruning Queue; current size = %d; max size = %d"
                r6 = 2
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                r1 = 0
                r6[r1] = r0     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                r0 = 10000(0x2710, float:1.4013E-41)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                r1 = 1
                r6[r1] = r0     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                r8.debug(r5, r6)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
                r7.removeHead(r2)     // Catch: android.database.SQLException -> L5c java.lang.Throwable -> L6b
            L56:
                if (r2 == 0) goto L5b
                r2.close()
            L5b:
                return r3
            L5c:
                r8 = move-exception
                goto L65
            L5e:
                r0 = move-exception
                r2 = r8
                r8 = r0
                goto L6c
            L62:
                r0 = move-exception
                r2 = r8
                r8 = r0
            L65:
                java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L6b
                r0.<init>(r8)     // Catch: java.lang.Throwable -> L6b
                throw r0     // Catch: java.lang.Throwable -> L6b
            L6b:
                r8 = move-exception
            L6c:
                if (r2 == 0) goto L71
                r2.close()
            L71:
                throw r8
                fill-array 0x0072: FILL_ARRAY_DATA , data: ?
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.SQLitePersistentQueue.SQLiteManager.insert(java.lang.String):long");
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.String getHead() throws java.io.IOException {
            /*
                r15 = this;
                r0 = 0
                com.singular.sdk.internal.SQLitePersistentQueue$SQLiteHelper r1 = r15.helper     // Catch: java.lang.Throwable -> L60 android.database.SQLException -> L65
                android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L60 android.database.SQLException -> L65
                long r10 = r15.getMinId(r1)     // Catch: java.lang.Throwable -> L56 android.database.SQLException -> L5b
                java.lang.String r2 = "value"
                java.lang.String[] r4 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L56 android.database.SQLException -> L5b
                java.lang.String r5 = "_id = ?"
                r12 = 1
                java.lang.String[] r6 = new java.lang.String[r12]     // Catch: java.lang.Throwable -> L56 android.database.SQLException -> L5b
                java.lang.String r2 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L56 android.database.SQLException -> L5b
                r13 = 0
                r6[r13] = r2     // Catch: java.lang.Throwable -> L56 android.database.SQLException -> L5b
                java.lang.String r3 = "events"
                r7 = 0
                r8 = 0
                r9 = 0
                r2 = r1
                android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L56 android.database.SQLException -> L5b
                r2.moveToFirst()     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
                int r3 = r2.getCount()     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
                if (r3 != 0) goto L31
                goto L35
            L31:
                java.lang.String r0 = r2.getString(r13)     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
            L35:
                com.singular.sdk.internal.SingularLog r3 = com.singular.sdk.internal.SQLitePersistentQueue.access$000()     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
                java.lang.String r4 = "getHead() _id = %d, value = %s"
                r5 = 2
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
                java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
                r5[r13] = r6     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
                r5[r12] = r0     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
                r3.debug(r4, r5)     // Catch: android.database.SQLException -> L54 java.lang.Throwable -> L6f
                if (r2 == 0) goto L4e
                r2.close()
            L4e:
                if (r1 == 0) goto L53
                r1.close()
            L53:
                return r0
            L54:
                r0 = move-exception
                goto L69
            L56:
                r2 = move-exception
                r14 = r2
                r2 = r0
                r0 = r14
                goto L70
            L5b:
                r2 = move-exception
                r14 = r2
                r2 = r0
                r0 = r14
                goto L69
            L60:
                r1 = move-exception
                r2 = r0
                r0 = r1
                r1 = r2
                goto L70
            L65:
                r1 = move-exception
                r2 = r0
                r0 = r1
                r1 = r2
            L69:
                java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L6f
                r3.<init>(r0)     // Catch: java.lang.Throwable -> L6f
                throw r3     // Catch: java.lang.Throwable -> L6f
            L6f:
                r0 = move-exception
            L70:
                if (r2 == 0) goto L75
                r2.close()
            L75:
                if (r1 == 0) goto L7a
                r1.close()
            L7a:
                throw r0
                fill-array 0x007c: FILL_ARRAY_DATA , data: ?
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.SQLitePersistentQueue.SQLiteManager.getHead():java.lang.String");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        String removeHead() throws IOException {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = this.helper.getWritableDatabase();
                return removeHead(sQLiteDatabase);
            } finally {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private String removeHead(SQLiteDatabase sQLiteDatabase) throws IOException {
            Cursor cursor = null;
            try {
                try {
                    long minId = getMinId(sQLiteDatabase);
                    String[] strArr = {String.valueOf(minId)};
                    Cursor query = sQLiteDatabase.query("events", new String[]{"value"}, "_id = ?", strArr, null, null, null);
                    try {
                        query.moveToFirst();
                        if (query.getCount() == 0) {
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        }
                        String string = query.getString(query.getColumnIndex("value"));
                        sQLiteDatabase.delete("events", "_id = ?", strArr);
                        SQLitePersistentQueue.logger.debug("removeHead() _id = %d", Long.valueOf(minId));
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    } catch (SQLException e) {
                        e = e;
                        cursor = query;
                        throw new IOException(e);
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLException e2) {
                e = e2;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private long getMinId(SQLiteDatabase sQLiteDatabase) throws IOException {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT MIN(_id) FROM events", null);
                    cursor.moveToFirst();
                    long j = cursor.getLong(0);
                    SQLitePersistentQueue.logger.debug("getMinId() id = %d", Long.valueOf(j));
                    return j;
                } catch (SQLException e) {
                    throw new IOException(e);
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private long getCount(SQLiteDatabase sQLiteDatabase) throws IOException {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT COUNT(_id) FROM events", null);
                    cursor.moveToFirst();
                    long j = cursor.getLong(0);
                    SQLitePersistentQueue.logger.debug("getCount() = %d", Long.valueOf(j));
                    return j;
                } catch (SQLException e) {
                    throw new IOException(e);
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private static class SQLiteHelper extends SQLiteOpenHelper implements BaseColumns {
        private static final String COLUMN_NAME_VALUE = "value";
        private static final String COMMA_SEP = ",";
        private static final String DATABASE_NAME = "singular-1.db";
        private static final int DATABASE_VERSION = 1;
        private static final String SQL_CREATE_ENTRIES = "CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,value TEXT )";
        private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS events";
        private static final String TABLE_NAME = "events";
        private static final String TEXT_TYPE = " TEXT";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SQLiteHelper(Context context) {
            super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        }
    }
}
