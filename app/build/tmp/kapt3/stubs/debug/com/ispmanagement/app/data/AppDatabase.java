package com.ispmanagement.app.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lcom/ispmanagement/app/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "csUserDao", "Lcom/ispmanagement/app/data/CsUserDao;", "konfirmasiDao", "Lcom/ispmanagement/app/data/KonfirmasiPembayaranDao;", "odpDao", "Lcom/ispmanagement/app/data/OdpDao;", "pelangganDao", "Lcom/ispmanagement/app/data/PelangganDao;", "tagihanDao", "Lcom/ispmanagement/app/data/TagihanDao;", "tiketDao", "Lcom/ispmanagement/app/data/TiketKomplainDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.ispmanagement.app.data.Pelanggan.class, com.ispmanagement.app.data.Tagihan.class, com.ispmanagement.app.data.KonfirmasiPembayaran.class, com.ispmanagement.app.data.TiketKomplain.class, com.ispmanagement.app.data.Odp.class, com.ispmanagement.app.data.CsUser.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.ispmanagement.app.data.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ispmanagement.app.data.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ispmanagement.app.data.PelangganDao pelangganDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ispmanagement.app.data.TagihanDao tagihanDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ispmanagement.app.data.KonfirmasiPembayaranDao konfirmasiDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ispmanagement.app.data.TiketKomplainDao tiketDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ispmanagement.app.data.OdpDao odpDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ispmanagement.app.data.CsUserDao csUserDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/ispmanagement/app/data/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/ispmanagement/app/data/AppDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getInstance", "context", "Landroid/content/Context;", "seedIfEmpty", "", "db", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ispmanagement.app.data.AppDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        /**
         * Mengisi data awal (akun CS default + contoh pelanggan) agar aplikasi langsung bisa dicoba.
         */
        private final void seedIfEmpty(com.ispmanagement.app.data.AppDatabase db) {
        }
    }
}