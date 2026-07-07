package com.ispmanagement.app.data;

/**
 * Sesi login sederhana memakai SharedPreferences.
 * Sesi Pelanggan dan CS dibuat terpisah (mengikuti requirement "sesi terisolasi").
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tJ\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/ispmanagement/app/data/SessionManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getCsNama", "", "getPelangganId", "", "getPelangganNama", "isCsLoggedIn", "", "isPelangganLoggedIn", "loginCs", "", "csId", "nama", "loginPelanggan", "pelangganId", "logoutCs", "logoutPelanggan", "app_debug"})
public final class SessionManager {
    private final android.content.SharedPreferences prefs = null;
    
    public SessionManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void loginPelanggan(long pelangganId, @org.jetbrains.annotations.NotNull()
    java.lang.String nama) {
    }
    
    public final boolean isPelangganLoggedIn() {
        return false;
    }
    
    public final long getPelangganId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPelangganNama() {
        return null;
    }
    
    public final void logoutPelanggan() {
    }
    
    public final void loginCs(long csId, @org.jetbrains.annotations.NotNull()
    java.lang.String nama) {
    }
    
    public final boolean isCsLoggedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCsNama() {
        return null;
    }
    
    public final void logoutCs() {
    }
}