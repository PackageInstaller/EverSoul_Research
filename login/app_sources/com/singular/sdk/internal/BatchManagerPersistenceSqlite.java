package com.singular.sdk.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class BatchManagerPersistenceSqlite implements BatchManagerPersistence {
    private static final SingularLog logger = SingularLog.getLogger("BatchManagerPersistenceSqlite");
    private Context context;
    private BatchManagerSQLiteHelper helper;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BatchManagerPersistenceSqlite(Context context) {
        this.helper = new BatchManagerSQLiteHelper(context);
        this.context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized boolean addEvent(String str, String str2) throws IOException {
        logger.debug("addEvent: key: " + str + " value: " + str2);
        return this.helper.insert(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized boolean updateEvent(String str, String str2) throws IOException {
        logger.debug("updateEvent: key: " + str + " value: " + str2);
        return this.helper.update(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized Set<Map.Entry<String, String>> getAllEvents() {
        Set<Map.Entry<String, String>> all;
        SingularLog singularLog = logger;
        singularLog.debug("getAllEvents");
        all = this.helper.getAll();
        singularLog.debug("getAllEvents: returning " + all.size() + " events");
        return all;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized boolean deleteEvent(String str) throws IOException {
        logger.debug("deleteEvent: key: " + str);
        return this.helper.delete(str);
    }

    private static class BatchManagerSQLiteHelper extends SQLiteOpenHelper {
        private static final String COLUMN_NAME_KEY = "eventKey";
        private static final String COLUMN_NAME_VALUE = "value";
        private static final String COMMA_SEP = ",";
        private static final String DATABASE_NAME = "singular-batch-managerx-1.db";
        private static final int DATABASE_VERSION = 1;
        private static final String SQL_CREATE_ENTRIES = "CREATE TABLE events (eventKey  TEXT PRIMARY KEY NOT NULL,value TEXT )";
        private static final String TABLE_NAME = "events";
        private static final String TEXT_TYPE = " TEXT";

        /* renamed from: db */
        private SQLiteDatabase f1141db;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public BatchManagerSQLiteHelper(Context context) {
            super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized boolean keyExists(String str) throws IOException {
            BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.keyExists: key: " + str);
            Cursor cursor = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    this.f1141db = writableDatabase;
                    Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM events WHERE eventKey= ?", new String[]{str});
                    if (rawQuery == null || rawQuery.getCount() == 0) {
                        BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.keyExists: returning false ");
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        SQLiteDatabase sQLiteDatabase = this.f1141db;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return false;
                    }
                    BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.keyExists: returning true ");
                    rawQuery.close();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    SQLiteDatabase sQLiteDatabase2 = this.f1141db;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    return true;
                } catch (SQLException unused) {
                    throw new IOException();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                SQLiteDatabase sQLiteDatabase3 = this.f1141db;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                }
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized boolean insert(String str, String str2) throws IOException {
            BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.insert key: " + str + " value: " + str2);
            if (keyExists(str)) {
                BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.insert key already exists - returning false ");
                return false;
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(COLUMN_NAME_KEY, str);
                        contentValues.put("value", str2);
                        if (writableDatabase.insert(TABLE_NAME, null, contentValues) != -1) {
                            BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.insert success ");
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                            return true;
                        }
                        BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.insert false ");
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        return false;
                    } catch (SQLException e) {
                        e = e;
                        sQLiteDatabase = writableDatabase;
                        throw new IOException(e);
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = writableDatabase;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
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
        public synchronized boolean update(String str, String str2) throws IOException {
            BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.update key: " + str + " value: " + str2);
            try {
                if (!keyExists(str)) {
                    BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.update: key does not exist - returning false ");
                    return false;
                }
                try {
                    this.f1141db = getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(COLUMN_NAME_KEY, str);
                    contentValues.put("value", str2);
                    if (this.f1141db.replace(TABLE_NAME, null, contentValues) != -1) {
                        BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.update - success");
                        SQLiteDatabase sQLiteDatabase = this.f1141db;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return true;
                    }
                    BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.update - failed");
                    return false;
                } catch (SQLException unused) {
                    throw new IOException();
                }
            } finally {
                SQLiteDatabase sQLiteDatabase2 = this.f1141db;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized boolean delete(String str) throws IOException {
            BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.delete key: " + str);
            try {
                if (!keyExists(str)) {
                    BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.delete key does not exist - returning false ");
                    return false;
                }
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    this.f1141db = writableDatabase;
                    if (writableDatabase.delete(TABLE_NAME, "eventKey =?", new String[]{str}) != 1) {
                        BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.delete failed ");
                        return false;
                    }
                    BatchManagerPersistenceSqlite.logger.debug("SQLiteHelper.delete - success ");
                    SQLiteDatabase sQLiteDatabase = this.f1141db;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                } catch (SQLException unused) {
                    throw new IOException();
                }
            } finally {
                SQLiteDatabase sQLiteDatabase2 = this.f1141db;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
        
            if (r1 != null) goto L16;
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized java.util.Set<java.util.Map.Entry<java.lang.String, java.lang.String>> getAll() {
            /*
                r6 = this;
                monitor-enter(r6)
                com.singular.sdk.internal.SingularLog r0 = com.singular.sdk.internal.BatchManagerPersistenceSqlite.access$000()     // Catch: java.lang.Throwable -> Lbe
                java.lang.String r1 = "SQLiteHelper.getAll"
                r0.debug(r1)     // Catch: java.lang.Throwable -> Lbe
                java.util.HashSet r0 = new java.util.HashSet     // Catch: java.lang.Throwable -> Lbe
                r0.<init>()     // Catch: java.lang.Throwable -> Lbe
                r1 = 0
                android.database.sqlite.SQLiteDatabase r2 = r6.getReadableDatabase()     // Catch: java.lang.Throwable -> L56
                r6.f1141db = r2     // Catch: java.lang.Throwable -> L56
                java.lang.String r3 = "SELECT * FROM events"
                android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> L56
                if (r1 == 0) goto L49
                int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L56
                if (r2 == 0) goto L49
                r1.moveToFirst()     // Catch: java.lang.Throwable -> L56
            L27:
                java.lang.String r2 = "eventKey"
                int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L56
                java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L56
                java.lang.String r3 = "value"
                int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L56
                java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L56
                java.util.AbstractMap$SimpleEntry r4 = new java.util.AbstractMap$SimpleEntry     // Catch: java.lang.Throwable -> L56
                r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L56
                r0.add(r4)     // Catch: java.lang.Throwable -> L56
                boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L56
                if (r2 != 0) goto L27
            L49:
                if (r1 == 0) goto L4e
                r1.close()     // Catch: java.lang.Throwable -> Lbe
            L4e:
                android.database.sqlite.SQLiteDatabase r1 = r6.f1141db     // Catch: java.lang.Throwable -> Lbe
                if (r1 == 0) goto L8a
            L52:
                r1.close()     // Catch: java.lang.Throwable -> Lbe
                goto L8a
            L56:
                r2 = move-exception
                com.singular.sdk.internal.SingularLog r3 = com.singular.sdk.internal.BatchManagerPersistenceSqlite.access$000()     // Catch: java.lang.Throwable -> Lb0
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb0
                r4.<init>()     // Catch: java.lang.Throwable -> Lb0
                java.lang.String r5 = "SQLiteHelper.getAll exception: "
                java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> Lb0
                java.lang.String r5 = r2.getMessage()     // Catch: java.lang.Throwable -> Lb0
                java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> Lb0
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lb0
                r3.error(r4)     // Catch: java.lang.Throwable -> Lb0
                com.singular.sdk.internal.SingularLog r3 = com.singular.sdk.internal.BatchManagerPersistenceSqlite.access$000()     // Catch: java.lang.Throwable -> Lb0
                java.lang.String r2 = com.singular.sdk.internal.Utils.formatException(r2)     // Catch: java.lang.Throwable -> Lb0
                r3.error(r2)     // Catch: java.lang.Throwable -> Lb0
                if (r1 == 0) goto L85
                r1.close()     // Catch: java.lang.Throwable -> Lbe
            L85:
                android.database.sqlite.SQLiteDatabase r1 = r6.f1141db     // Catch: java.lang.Throwable -> Lbe
                if (r1 == 0) goto L8a
                goto L52
            L8a:
                com.singular.sdk.internal.SingularLog r1 = com.singular.sdk.internal.BatchManagerPersistenceSqlite.access$000()     // Catch: java.lang.Throwable -> Lbe
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbe
                r2.<init>()     // Catch: java.lang.Throwable -> Lbe
                java.lang.String r3 = "SQLiteHelper.getAll returning: "
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbe
                int r3 = r0.size()     // Catch: java.lang.Throwable -> Lbe
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbe
                java.lang.String r3 = " entries"
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lbe
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lbe
                r1.debug(r2)     // Catch: java.lang.Throwable -> Lbe
                monitor-exit(r6)
                return r0
            Lb0:
                r0 = move-exception
                if (r1 == 0) goto Lb6
                r1.close()     // Catch: java.lang.Throwable -> Lbe
            Lb6:
                android.database.sqlite.SQLiteDatabase r1 = r6.f1141db     // Catch: java.lang.Throwable -> Lbe
                if (r1 == 0) goto Lbd
                r1.close()     // Catch: java.lang.Throwable -> Lbe
            Lbd:
                throw r0     // Catch: java.lang.Throwable -> Lbe
            Lbe:
                r0 = move-exception
                monitor-exit(r6)
                throw r0
                fill-array 0x00c2: FILL_ARRAY_DATA , data: ?
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.BatchManagerPersistenceSqlite.BatchManagerSQLiteHelper.getAll():java.util.Set");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized long getSendId() {
        return Utils.getBatchSendId(this.context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized long incSendId() {
        return Utils.incBatchSendId(this.context);
    }
}
