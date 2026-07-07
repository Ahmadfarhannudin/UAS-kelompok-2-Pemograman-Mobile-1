package com.ispmanagement.app.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/ispmanagement/app/data/KonfirmasiPembayaranDao;", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "Lcom/ispmanagement/app/data/KonfirmasiPembayaran;", "getAllKonfirmasiSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPending", "insert", "konfirmasi", "(Lcom/ispmanagement/app/data/KonfirmasiPembayaran;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "", "app_debug"})
@androidx.room.Dao()
public abstract interface KonfirmasiPembayaranDao {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.KonfirmasiPembayaran konfirmasi, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.KonfirmasiPembayaran konfirmasi, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM konfirmasi_pembayaran ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM konfirmasi_pembayaran")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllKonfirmasiSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM konfirmasi_pembayaran WHERE status = \'Pending\' ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.KonfirmasiPembayaran>> getPending();
    
    @androidx.room.Query(value = "SELECT * FROM konfirmasi_pembayaran WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.KonfirmasiPembayaran> $completion);
}