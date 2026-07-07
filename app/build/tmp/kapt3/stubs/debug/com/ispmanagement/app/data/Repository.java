package com.ispmanagement.app.data;

/**
 * Repository tunggal yang menjadi satu pintu akses ke seluruh tabel database.
 * Membuat penggunaan database "mudah" dari sisi UI/ViewModel karena semua
 * operasi CRUD dikumpulkan di satu tempat.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0086@\u00a2\u0006\u0002\u0010\'J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0$0#J\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$0#J\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0$0#J\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160$0#J\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#J\u0010\u0010/\u001a\u0004\u0018\u00010\u001fH\u0086@\u00a2\u0006\u0002\u0010\'J\u0018\u00100\u001a\u0004\u0018\u00010\u001f2\u0006\u00101\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u00102J\u0018\u00103\u001a\u0004\u0018\u00010,2\u0006\u00101\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u00102J\u001a\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0$0#2\u0006\u00105\u001a\u00020\u0014J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020,0$2\u0006\u00105\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u00102J\u0018\u00107\u001a\u0004\u0018\u00010\u00162\u0006\u00101\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u00102J\u001a\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160$0#2\u0006\u00105\u001a\u00020\u0014J\u0016\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010;J\u000e\u0010<\u001a\u00020=H\u0086@\u00a2\u0006\u0002\u0010\'J\u0016\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020%H\u0086@\u00a2\u0006\u0002\u0010@J \u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001dJ \u0010E\u001a\u0004\u0018\u00010\u001f2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020\u00142\u0006\u0010:\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010;J\u0016\u0010J\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020,H\u0086@\u00a2\u0006\u0002\u0010KJ\u0016\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020%H\u0086@\u00a2\u0006\u0002\u0010@J\u001e\u0010N\u001a\u00020\u00192\u0006\u0010M\u001a\u00020%2\u0006\u0010O\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010PJ\u0016\u0010Q\u001a\u00020\u00192\u0006\u0010:\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010;J\u0016\u0010R\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010HJ\u0016\u0010S\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020,H\u0086@\u00a2\u0006\u0002\u0010KJ\u0016\u0010T\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/ispmanagement/app/data/Repository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "csUserDao", "Lcom/ispmanagement/app/data/CsUserDao;", "db", "Lcom/ispmanagement/app/data/AppDatabase;", "konfirmasiDao", "Lcom/ispmanagement/app/data/KonfirmasiPembayaranDao;", "odpDao", "Lcom/ispmanagement/app/data/OdpDao;", "pelangganDao", "Lcom/ispmanagement/app/data/PelangganDao;", "tagihanDao", "Lcom/ispmanagement/app/data/TagihanDao;", "tiketDao", "Lcom/ispmanagement/app/data/TiketKomplainDao;", "buatTiket", "", "t", "Lcom/ispmanagement/app/data/TiketKomplain;", "(Lcom/ispmanagement/app/data/TiketKomplain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cekDanUpdateIsolir", "", "todayStr", "", "batasHariString", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cekTagihanByNomorLayanan", "Lcom/ispmanagement/app/data/Pelanggan;", "nomor", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllKonfirmasi", "Landroidx/lifecycle/LiveData;", "", "Lcom/ispmanagement/app/data/KonfirmasiPembayaran;", "getAllKonfirmasiSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOdp", "Lcom/ispmanagement/app/data/Odp;", "getAllPelanggan", "getAllTagihan", "Lcom/ispmanagement/app/data/Tagihan;", "getAllTiket", "getKonfirmasiPending", "getLastPelanggan", "getPelangganById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTagihanById", "getTagihanByPelanggan", "pelangganId", "getTagihanByPelangganSync", "getTiketById", "getTiketByPelanggan", "hapusOdp", "o", "(Lcom/ispmanagement/app/data/Odp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jumlahTiket", "", "kirimKonfirmasiPembayaran", "k", "(Lcom/ispmanagement/app/data/KonfirmasiPembayaran;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginCs", "Lcom/ispmanagement/app/data/CsUser;", "username", "password", "loginPelanggan", "registrasiPelanggan", "p", "(Lcom/ispmanagement/app/data/Pelanggan;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tambahOdp", "tambahTagihan", "(Lcom/ispmanagement/app/data/Tagihan;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terimaPembayaran", "konfirmasi", "tolakPembayaran", "catatan", "(Lcom/ispmanagement/app/data/KonfirmasiPembayaran;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOdp", "updatePelanggan", "updateTagihan", "updateTiket", "app_debug"})
public final class Repository {
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.AppDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.PelangganDao pelangganDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.TagihanDao tagihanDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.KonfirmasiPembayaranDao konfirmasiDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.TiketKomplainDao tiketDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.OdpDao odpDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.CsUserDao csUserDao = null;
    
    public Repository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object registrasiPelanggan(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Pelanggan p, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePelanggan(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Pelanggan p, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cekTagihanByNomorLayanan(@org.jetbrains.annotations.NotNull()
    java.lang.String nomor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.Pelanggan> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loginPelanggan(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.Pelanggan> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPelangganById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.Pelanggan> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Pelanggan>> getAllPelanggan() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLastPelanggan(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.Pelanggan> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object tambahTagihan(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Tagihan t, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateTagihan(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Tagihan t, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> getTagihanByPelanggan(long pelangganId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTagihanByPelangganSync(long pelangganId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ispmanagement.app.data.Tagihan>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTagihanById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.Tagihan> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> getAllTagihan() {
        return null;
    }
    
    /**
     * Cek jatuh tempo lebih dari 30 hari -> ubah status pelanggan jadi Terisolir (manajemen status manual).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cekDanUpdateIsolir(@org.jetbrains.annotations.NotNull()
    java.lang.String todayStr, @org.jetbrains.annotations.NotNull()
    java.lang.String batasHariString, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object kirimKonfirmasiPembayaran(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.KonfirmasiPembayaran k, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> getAllKonfirmasi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> getKonfirmasiPending() {
        return null;
    }
    
    /**
     * CS menerima pembayaran -> update status konfirmasi & tagihan menjadi Paid.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object terimaPembayaran(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.KonfirmasiPembayaran konfirmasi, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object tolakPembayaran(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.KonfirmasiPembayaran konfirmasi, @org.jetbrains.annotations.NotNull()
    java.lang.String catatan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object buatTiket(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.TiketKomplain t, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateTiket(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.TiketKomplain t, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.TiketKomplain>> getAllTiket() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.TiketKomplain>> getTiketByPelanggan(long pelangganId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTiketById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.TiketKomplain> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object jumlahTiket(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object tambahOdp(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Odp o, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateOdp(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Odp o, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object hapusOdp(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Odp o, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Odp>> getAllOdp() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllKonfirmasiSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loginCs(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.CsUser> $completion) {
        return null;
    }
}