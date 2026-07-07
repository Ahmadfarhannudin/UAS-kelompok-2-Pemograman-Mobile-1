package com.ispmanagement.app.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J\u001c\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00192\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J*\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\'2\u0006\u0010.\u001a\u00020\'2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0/J0\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\'2 \u00102\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0007\u0012\u0004\u0012\u00020$03J(\u00104\u001a\u00020$2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00072\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u001c\u00107\u001a\u00020$2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020$0/J$\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020:2\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020$0/J\u0018\u0010;\u001a\u0004\u0018\u00010\u00192\u0006\u00109\u001a\u00020:H\u0086@\u00a2\u0006\u0002\u0010<J\u001c\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J,\u0010?\u001a\u00020$2$\u00102\u001a \u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020$0@J\u000e\u0010B\u001a\u00020AH\u0086@\u00a2\u0006\u0002\u0010CJ<\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020:2\u0006\u0010G\u001a\u00020\'2\u0006\u0010H\u001a\u00020\'2\u0006\u0010I\u001a\u00020\'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J0\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020\'2\u0006\u0010L\u001a\u00020\'2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020$03J0\u0010N\u001a\u00020$2\u0006\u0010K\u001a\u00020\'2\u0006\u0010L\u001a\u00020\'2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020$03J\"\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020\u00132\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020$0/J\u001a\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u00062\u0006\u0010F\u001a\u00020:J\u001c\u0010R\u001a\u00020$2\u0006\u0010>\u001a\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J\u001c\u0010S\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J\u001c\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J\u001a\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00070\u00062\u0006\u0010F\u001a\u00020:J$\u0010W\u001a\u00020$2\u0006\u0010U\u001a\u00020\b2\u0006\u0010X\u001a\u00020\'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J\u001c\u0010Y\u001a\u00020$2\u0006\u0010>\u001a\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J$\u0010Z\u001a\u00020$2\u0006\u0010P\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*J\u001c\u0010[\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u0006\\"}, d2 = {"Lcom/ispmanagement/app/viewmodel/AppViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "konfirmasiPending", "Landroidx/lifecycle/LiveData;", "", "Lcom/ispmanagement/app/data/KonfirmasiPembayaran;", "getKonfirmasiPending", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/ispmanagement/app/data/Repository;", "semuaKonfirmasi", "getSemuaKonfirmasi", "semuaOdp", "Lcom/ispmanagement/app/data/Odp;", "getSemuaOdp", "semuaPelanggan", "Lcom/ispmanagement/app/data/Pelanggan;", "getSemuaPelanggan", "semuaTagihan", "Lcom/ispmanagement/app/data/Tagihan;", "getSemuaTagihan", "semuaTiket", "Lcom/ispmanagement/app/data/TiketKomplain;", "getSemuaTiket", "session", "Lcom/ispmanagement/app/data/SessionManager;", "getSession", "()Lcom/ispmanagement/app/data/SessionManager;", "tagihanLengkap", "Landroidx/lifecycle/MediatorLiveData;", "getTagihanLengkap", "()Landroidx/lifecycle/MediatorLiveData;", "balasTiket", "", "t", "balasan", "", "statusBaru", "onDone", "Lkotlin/Function0;", "buatTiket", "cekJatuhTempoBerkala", "todayStr", "batasStr", "Lkotlin/Function1;", "cekTagihan", "nomorLayanan", "onResult", "Lkotlin/Function2;", "gabungkanData", "listTagihan", "listKonfirmasi", "getLastPelanggan", "getPelangganById", "id", "", "getTiketByIdSuspend", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hapusOdp", "o", "hitungRingkasanDashboard", "Lkotlin/Function4;", "", "jumlahTiketSaatIni", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kirimKonfirmasi", "tagihanId", "pelangganId", "tanggalBayar", "caraBayar", "fotoPath", "loginCs", "username", "password", "", "loginPelanggan", "registrasiPelanggan", "p", "tagihanByPelanggan", "tambahOdp", "tambahTagihan", "terimaPembayaran", "k", "tiketByPelanggan", "tolakPembayaran", "catatan", "updateOdp", "updatePelangganStatus", "updateTagihan", "app_release"})
public final class AppViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.Repository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ispmanagement.app.data.SessionManager session = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Pelanggan>> semuaPelanggan = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> semuaKonfirmasi = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> semuaTagihan = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> konfirmasiPending = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.TiketKomplain>> semuaTiket = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Odp>> semuaOdp = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> tagihanLengkap = null;
    
    public AppViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ispmanagement.app.data.SessionManager getSession() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Pelanggan>> getSemuaPelanggan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> getSemuaKonfirmasi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> getSemuaTagihan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> getKonfirmasiPending() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.TiketKomplain>> getSemuaTiket() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Odp>> getSemuaOdp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> getTagihanLengkap() {
        return null;
    }
    
    private final void gabungkanData(java.util.List<com.ispmanagement.app.data.Tagihan> listTagihan, java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran> listKonfirmasi) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> tagihanByPelanggan(long pelangganId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.TiketKomplain>> tiketByPelanggan(long pelangganId) {
        return null;
    }
    
    public final void cekTagihan(@org.jetbrains.annotations.NotNull()
    java.lang.String nomorLayanan, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.ispmanagement.app.data.Pelanggan, ? super java.util.List<com.ispmanagement.app.data.Tagihan>, kotlin.Unit> onResult) {
    }
    
    public final void loginPelanggan(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> onResult) {
    }
    
    public final void loginCs(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> onResult) {
    }
    
    public final void kirimKonfirmasi(long tagihanId, long pelangganId, @org.jetbrains.annotations.NotNull()
    java.lang.String tanggalBayar, @org.jetbrains.annotations.NotNull()
    java.lang.String caraBayar, @org.jetbrains.annotations.NotNull()
    java.lang.String fotoPath, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void terimaPembayaran(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.KonfirmasiPembayaran k, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void tolakPembayaran(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.KonfirmasiPembayaran k, @org.jetbrains.annotations.NotNull()
    java.lang.String catatan, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void getLastPelanggan(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ispmanagement.app.data.Pelanggan, kotlin.Unit> onResult) {
    }
    
    public final void registrasiPelanggan(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Pelanggan p, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onDone) {
    }
    
    public final void tambahTagihan(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Tagihan t, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void updateTagihan(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Tagihan t, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void updatePelangganStatus(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Pelanggan p, @org.jetbrains.annotations.NotNull()
    java.lang.String statusBaru, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void cekJatuhTempoBerkala(@org.jetbrains.annotations.NotNull()
    java.lang.String todayStr, @org.jetbrains.annotations.NotNull()
    java.lang.String batasStr, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.Unit, kotlin.Unit> onDone) {
    }
    
    public final void buatTiket(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.TiketKomplain t, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void balasTiket(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.TiketKomplain t, @org.jetbrains.annotations.NotNull()
    java.lang.String balasan, @org.jetbrains.annotations.NotNull()
    java.lang.String statusBaru, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object jumlahTiketSaatIni(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTiketByIdSuspend(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.TiketKomplain> $completion) {
        return null;
    }
    
    public final void tambahOdp(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Odp o, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void hapusOdp(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Odp o, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void updateOdp(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Odp o, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    public final void getPelangganById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ispmanagement.app.data.Pelanggan, kotlin.Unit> onResult) {
    }
    
    public final void hitungRingkasanDashboard(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onResult) {
    }
}