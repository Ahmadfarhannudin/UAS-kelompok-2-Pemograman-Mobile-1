package com.ispmanagement.app.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J\u0018\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\'J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/ispmanagement/app/data/TagihanDao;", "", "countUnpaid", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTagihan", "Landroidx/lifecycle/LiveData;", "", "Lcom/ispmanagement/app/data/Tagihan;", "getById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByPelanggan", "pelangganId", "getByPelangganSync", "getOverdue", "today", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "tagihan", "(Lcom/ispmanagement/app/data/Tagihan;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "", "app_debug"})
@androidx.room.Dao()
public abstract interface TagihanDao {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Tagihan tagihan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.ispmanagement.app.data.Tagihan tagihan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tagihan WHERE pelangganId = :pelangganId ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> getByPelanggan(long pelangganId);
    
    @androidx.room.Query(value = "SELECT * FROM tagihan WHERE pelangganId = :pelangganId ORDER BY id DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByPelangganSync(long pelangganId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ispmanagement.app.data.Tagihan>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tagihan WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ispmanagement.app.data.Tagihan> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tagihan WHERE status = \'Belum Bayar\' AND jatuhTempo < :today")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOverdue(@org.jetbrains.annotations.NotNull()
    java.lang.String today, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ispmanagement.app.data.Tagihan>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM tagihan WHERE status = \'Belum Bayar\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countUnpaid(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tagihan ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ispmanagement.app.data.Tagihan>> getAllTagihan();
}