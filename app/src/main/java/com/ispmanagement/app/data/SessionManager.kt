package com.ispmanagement.app.data

import android.content.Context

/**
 * Sesi login sederhana memakai SharedPreferences.
 * Sesi Pelanggan dan CS dibuat terpisah (mengikuti requirement "sesi terisolasi").
 */
class SessionManager(context: Context) {

    private val prefs = context.getSharedPreferences("isp_session", Context.MODE_PRIVATE)

    // ----- Pelanggan session -----
    fun loginPelanggan(pelangganId: Long, nama: String) {
        prefs.edit()
            .putLong("pelanggan_id", pelangganId)
            .putString("pelanggan_nama", nama)
            .apply()
    }

    fun isPelangganLoggedIn(): Boolean = prefs.getLong("pelanggan_id", -1L) != -1L
    fun getPelangganId(): Long = prefs.getLong("pelanggan_id", -1L)
    fun getPelangganNama(): String = prefs.getString("pelanggan_nama", "") ?: ""

    fun logoutPelanggan() {
        prefs.edit().remove("pelanggan_id").remove("pelanggan_nama").apply()
    }

    // ----- CS session -----
    fun loginCs(csId: Long, nama: String) {
        prefs.edit()
            .putLong("cs_id", csId)
            .putString("cs_nama", nama)
            .apply()
    }

    fun isCsLoggedIn(): Boolean = prefs.getLong("cs_id", -1L) != -1L
    fun getCsNama(): String = prefs.getString("cs_nama", "") ?: ""

    fun logoutCs() {
        prefs.edit().remove("cs_id").remove("cs_nama").apply()
    }
}
