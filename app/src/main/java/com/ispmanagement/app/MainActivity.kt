package com.ispmanagement.app

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ispmanagement.app.data.SessionManager
import com.ispmanagement.app.databinding.ActivityMainBinding
import com.ispmanagement.app.viewmodel.AppViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var session: SessionManager
    lateinit var viewModel: AppViewModel
        private set

    private val topLevelDestinations = setOf(
        R.id.roleSelectionFragment,
        R.id.cekTagihanFragment,
        R.id.csDashboardFragment,
        R.id.komplainListFragment,
        R.id.kelolaKomplainFragment,
        R.id.kelolaPembayaranFragment,
        R.id.kelolaPelangganFragment,
        R.id.kelolaOdpFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 👇 CARA MODERN MENANGANI TOMBOL BACK (TIDAK DEPRECATED)
        onBackPressedDispatcher.addCallback(this, object : androidx.activity.OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })

        session = SessionManager(this)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        // Setup toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // Setup NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Listener item menu sidebar
        binding.navView.setNavigationItemSelectedListener { item ->
            handleMenuClick(item)
        }

        // Saat destinasi berubah: update ikon toolbar, judul, dan AKTIFKAN MENU YANG SESUAI
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            supportActionBar?.title = destination.label

            val isTopLevel = topLevelDestinations.contains(destination.id)
            if (isTopLevel) {
                // Tampilkan ikon hamburger ☰
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
            } else {
                // Tampilkan ikon panah back ←
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            }
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            refreshDrawerState()
            syncMenuSelection(destination.id, arguments)
        }

        refreshDrawerState()
    }

    // Klik ikon di toolbar (hamburger ATAU back arrow)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            val currentId = navController.currentDestination?.id
            val isTopLevel = topLevelDestinations.contains(currentId)

            return if (isTopLevel) {
                // Buka/tutup drawer
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    binding.drawerLayout.openDrawer(GravityCompat.START)
                }
                true
            } else {
                // Kembali ke halaman sebelumnya
                navController.navigateUp()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun closeDrawer() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    fun refreshDrawerState() {
        val menu   = binding.navView.menu
        val header = binding.navView.getHeaderView(0)
        val tvName = header.findViewById<android.widget.TextView>(R.id.tvNavHeaderName)
        val tvRole = header.findViewById<android.widget.TextView>(R.id.tvNavHeaderRole)

        val csLoggedIn       = session.isCsLoggedIn()
        val pelangganLoggedIn = session.isPelangganLoggedIn()

        // 1. Atur visibilitas grup menu utama
        menu.setGroupVisible(R.id.group_guest,    !csLoggedIn)
        menu.setGroupVisible(R.id.group_customer, !csLoggedIn)
        menu.setGroupVisible(R.id.group_cs,        csLoggedIn)

        // 2. KONTROL KHUSUS UNTUK TOMBOL KELUAR (DIPERKETAT SESUAI ROLE)
        val menuLogoutPelanggan = menu.findItem(R.id.menu_logout_pelanggan)
        val menuLogoutCs = menu.findItem(R.id.menu_logout_cs)

        // Tombol keluar Pelanggan HANYA muncul jika Pelanggan login DAN sedang TIDAK di akun CS
        menuLogoutPelanggan?.isVisible = pelangganLoggedIn && !csLoggedIn

        // Tombol keluar CS HANYA muncul jika CS login
        menuLogoutCs?.isVisible = csLoggedIn

        // 3. Update teks Header Sidebar
        when {
            csLoggedIn -> {
                tvName.text = session.getCsNama()
                tvRole.text = "Customer Service"
            }
            pelangganLoggedIn -> {
                tvName.text = session.getPelangganNama()
                tvRole.text = "Pelanggan"
            }
            else -> {
                tvName.text = "Selamat Datang"
                tvRole.text = "Sistem Manajemen ISP"
            }
        }
    }

    // FUNGSI UNTUK MENGATUR MENU AKTIF
    private fun syncMenuSelection(destinationId: Int, arguments: Bundle?) {
        val menu = binding.navView.menu

        // 1. Hapus warna aktif dari semua menu terlebih dahulu (Reset)
        val allMenuIds = listOf(
            R.id.menu_pilih_role, R.id.menu_cek_tagihan, R.id.menu_konfirmasi_pembayaran,
            R.id.menu_komplain_pelanggan, R.id.menu_cs_dashboard, R.id.menu_kelola_pembayaran,
            R.id.menu_kelola_pelanggan, R.id.menu_kelola_komplain, R.id.menu_kelola_odp
        )
        for (id in allMenuIds) {
            menu.findItem(id)?.isChecked = false
        }

        // 2. Beri warna aktif (Checked = true) hanya pada halaman yang sedang terbuka
        when (destinationId) {
            R.id.roleSelectionFragment -> menu.findItem(R.id.menu_pilih_role)?.isChecked = true
            R.id.csDashboardFragment -> menu.findItem(R.id.menu_cs_dashboard)?.isChecked = true
            R.id.kelolaPembayaranFragment -> menu.findItem(R.id.menu_kelola_pembayaran)?.isChecked = true
            R.id.kelolaPelangganFragment -> menu.findItem(R.id.menu_kelola_pelanggan)?.isChecked = true
            R.id.kelolaKomplainFragment -> menu.findItem(R.id.menu_kelola_komplain)?.isChecked = true
            R.id.kelolaOdpFragment -> menu.findItem(R.id.menu_kelola_odp)?.isChecked = true
            R.id.komplainListFragment -> menu.findItem(R.id.menu_komplain_pelanggan)?.isChecked = true

            // Khusus Cek Tagihan dan Konfirmasi Pembayaran yang halamannya sama (CekTagihanFragment),
            // Kita bedakan menggunakan argumen "mode"
            R.id.cekTagihanFragment -> {
                val mode = arguments?.getString("mode")
                if (mode == "konfirmasi") {
                    menu.findItem(R.id.menu_konfirmasi_pembayaran)?.isChecked = true
                } else {
                    menu.findItem(R.id.menu_cek_tagihan)?.isChecked = true
                }
            }
        }
    }

    private fun handleMenuClick(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_pilih_role ->
                navController.navigate(R.id.roleSelectionFragment)

            R.id.menu_cek_tagihan ->
                navController.navigate(
                    R.id.cekTagihanFragment,
                    Bundle().apply { putString("mode", "cek") }
                )

            R.id.menu_konfirmasi_pembayaran ->
                navController.navigate(
                    R.id.cekTagihanFragment,
                    Bundle().apply { putString("mode", "konfirmasi") }
                )

            R.id.menu_komplain_pelanggan -> {
                if (session.isPelangganLoggedIn()) {
                    navController.navigate(R.id.komplainListFragment)
                } else {
                    navController.navigate(R.id.loginPelangganFragment)
                }
            }

            R.id.menu_logout_pelanggan -> {
                session.logoutPelanggan()
                session.logoutCs()
                Toast.makeText(this, "Berhasil keluar dari akun Pelanggan", Toast.LENGTH_SHORT).show()
                navController.popBackStack(R.id.roleSelectionFragment, false)
                if (navController.currentDestination?.id != R.id.roleSelectionFragment) {
                    navController.navigate(R.id.roleSelectionFragment)
                }
            }

            R.id.menu_cs_dashboard ->
                navController.navigate(R.id.csDashboardFragment)

            R.id.menu_kelola_pembayaran ->
                navController.navigate(R.id.kelolaPembayaranFragment)

            R.id.menu_kelola_pelanggan ->
                navController.navigate(R.id.kelolaPelangganFragment)

            R.id.menu_kelola_komplain ->
                navController.navigate(R.id.kelolaKomplainFragment)

            R.id.menu_kelola_odp ->
                navController.navigate(R.id.kelolaOdpFragment)

            R.id.menu_logout_cs -> {
                session.logoutCs()
                session.logoutPelanggan()
                Toast.makeText(this, "Berhasil keluar dari akun Customer Service", Toast.LENGTH_SHORT).show()
                navController.popBackStack(R.id.roleSelectionFragment, false)
                if (navController.currentDestination?.id != R.id.roleSelectionFragment) {
                    navController.navigate(R.id.roleSelectionFragment)
                }
            }
        }
        closeDrawer()
        refreshDrawerState()
        return true
    }
}