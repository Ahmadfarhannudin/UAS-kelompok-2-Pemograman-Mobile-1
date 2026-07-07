package com.ispmanagement.app.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile PelangganDao _pelangganDao;

  private volatile TagihanDao _tagihanDao;

  private volatile KonfirmasiPembayaranDao _konfirmasiPembayaranDao;

  private volatile TiketKomplainDao _tiketKomplainDao;

  private volatile OdpDao _odpDao;

  private volatile CsUserDao _csUserDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `pelanggan` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nomorLayanan` TEXT NOT NULL, `nama` TEXT NOT NULL, `alamat` TEXT NOT NULL, `noHp` TEXT NOT NULL, `paket` TEXT NOT NULL, `hargaPaket` INTEGER NOT NULL, `odp` TEXT NOT NULL, `tanggalDaftar` TEXT NOT NULL, `statusLayanan` TEXT NOT NULL, `username` TEXT NOT NULL, `password` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tagihan` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `pelangganId` INTEGER NOT NULL, `periode` TEXT NOT NULL, `jumlah` INTEGER NOT NULL, `jatuhTempo` TEXT NOT NULL, `status` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `konfirmasi_pembayaran` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tagihanId` INTEGER NOT NULL, `pelangganId` INTEGER NOT NULL, `tanggalBayar` TEXT NOT NULL, `caraBayar` TEXT NOT NULL, `fotoPath` TEXT NOT NULL, `status` TEXT NOT NULL, `catatanCS` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tiket_komplain` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nomorAntrean` TEXT NOT NULL, `pelangganId` INTEGER NOT NULL, `judul` TEXT NOT NULL, `deskripsi` TEXT NOT NULL, `status` TEXT NOT NULL, `balasanCS` TEXT NOT NULL, `tanggalDibuat` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `odp` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `namaOdp` TEXT NOT NULL, `alamat` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `totalPort` INTEGER NOT NULL, `portTerpakai` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `cs_user` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT NOT NULL, `password` TEXT NOT NULL, `nama` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8d501395380d90851ffcae7dd763a728')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `pelanggan`");
        db.execSQL("DROP TABLE IF EXISTS `tagihan`");
        db.execSQL("DROP TABLE IF EXISTS `konfirmasi_pembayaran`");
        db.execSQL("DROP TABLE IF EXISTS `tiket_komplain`");
        db.execSQL("DROP TABLE IF EXISTS `odp`");
        db.execSQL("DROP TABLE IF EXISTS `cs_user`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsPelanggan = new HashMap<String, TableInfo.Column>(12);
        _columnsPelanggan.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("nomorLayanan", new TableInfo.Column("nomorLayanan", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("nama", new TableInfo.Column("nama", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("alamat", new TableInfo.Column("alamat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("noHp", new TableInfo.Column("noHp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("paket", new TableInfo.Column("paket", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("hargaPaket", new TableInfo.Column("hargaPaket", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("odp", new TableInfo.Column("odp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("tanggalDaftar", new TableInfo.Column("tanggalDaftar", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("statusLayanan", new TableInfo.Column("statusLayanan", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPelanggan.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPelanggan = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPelanggan = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPelanggan = new TableInfo("pelanggan", _columnsPelanggan, _foreignKeysPelanggan, _indicesPelanggan);
        final TableInfo _existingPelanggan = TableInfo.read(db, "pelanggan");
        if (!_infoPelanggan.equals(_existingPelanggan)) {
          return new RoomOpenHelper.ValidationResult(false, "pelanggan(com.ispmanagement.app.data.Pelanggan).\n"
                  + " Expected:\n" + _infoPelanggan + "\n"
                  + " Found:\n" + _existingPelanggan);
        }
        final HashMap<String, TableInfo.Column> _columnsTagihan = new HashMap<String, TableInfo.Column>(6);
        _columnsTagihan.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTagihan.put("pelangganId", new TableInfo.Column("pelangganId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTagihan.put("periode", new TableInfo.Column("periode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTagihan.put("jumlah", new TableInfo.Column("jumlah", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTagihan.put("jatuhTempo", new TableInfo.Column("jatuhTempo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTagihan.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTagihan = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTagihan = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTagihan = new TableInfo("tagihan", _columnsTagihan, _foreignKeysTagihan, _indicesTagihan);
        final TableInfo _existingTagihan = TableInfo.read(db, "tagihan");
        if (!_infoTagihan.equals(_existingTagihan)) {
          return new RoomOpenHelper.ValidationResult(false, "tagihan(com.ispmanagement.app.data.Tagihan).\n"
                  + " Expected:\n" + _infoTagihan + "\n"
                  + " Found:\n" + _existingTagihan);
        }
        final HashMap<String, TableInfo.Column> _columnsKonfirmasiPembayaran = new HashMap<String, TableInfo.Column>(8);
        _columnsKonfirmasiPembayaran.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKonfirmasiPembayaran.put("tagihanId", new TableInfo.Column("tagihanId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKonfirmasiPembayaran.put("pelangganId", new TableInfo.Column("pelangganId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKonfirmasiPembayaran.put("tanggalBayar", new TableInfo.Column("tanggalBayar", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKonfirmasiPembayaran.put("caraBayar", new TableInfo.Column("caraBayar", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKonfirmasiPembayaran.put("fotoPath", new TableInfo.Column("fotoPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKonfirmasiPembayaran.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKonfirmasiPembayaran.put("catatanCS", new TableInfo.Column("catatanCS", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKonfirmasiPembayaran = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKonfirmasiPembayaran = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKonfirmasiPembayaran = new TableInfo("konfirmasi_pembayaran", _columnsKonfirmasiPembayaran, _foreignKeysKonfirmasiPembayaran, _indicesKonfirmasiPembayaran);
        final TableInfo _existingKonfirmasiPembayaran = TableInfo.read(db, "konfirmasi_pembayaran");
        if (!_infoKonfirmasiPembayaran.equals(_existingKonfirmasiPembayaran)) {
          return new RoomOpenHelper.ValidationResult(false, "konfirmasi_pembayaran(com.ispmanagement.app.data.KonfirmasiPembayaran).\n"
                  + " Expected:\n" + _infoKonfirmasiPembayaran + "\n"
                  + " Found:\n" + _existingKonfirmasiPembayaran);
        }
        final HashMap<String, TableInfo.Column> _columnsTiketKomplain = new HashMap<String, TableInfo.Column>(8);
        _columnsTiketKomplain.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiketKomplain.put("nomorAntrean", new TableInfo.Column("nomorAntrean", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiketKomplain.put("pelangganId", new TableInfo.Column("pelangganId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiketKomplain.put("judul", new TableInfo.Column("judul", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiketKomplain.put("deskripsi", new TableInfo.Column("deskripsi", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiketKomplain.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiketKomplain.put("balasanCS", new TableInfo.Column("balasanCS", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiketKomplain.put("tanggalDibuat", new TableInfo.Column("tanggalDibuat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTiketKomplain = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTiketKomplain = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTiketKomplain = new TableInfo("tiket_komplain", _columnsTiketKomplain, _foreignKeysTiketKomplain, _indicesTiketKomplain);
        final TableInfo _existingTiketKomplain = TableInfo.read(db, "tiket_komplain");
        if (!_infoTiketKomplain.equals(_existingTiketKomplain)) {
          return new RoomOpenHelper.ValidationResult(false, "tiket_komplain(com.ispmanagement.app.data.TiketKomplain).\n"
                  + " Expected:\n" + _infoTiketKomplain + "\n"
                  + " Found:\n" + _existingTiketKomplain);
        }
        final HashMap<String, TableInfo.Column> _columnsOdp = new HashMap<String, TableInfo.Column>(7);
        _columnsOdp.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOdp.put("namaOdp", new TableInfo.Column("namaOdp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOdp.put("alamat", new TableInfo.Column("alamat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOdp.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOdp.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOdp.put("totalPort", new TableInfo.Column("totalPort", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOdp.put("portTerpakai", new TableInfo.Column("portTerpakai", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOdp = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOdp = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOdp = new TableInfo("odp", _columnsOdp, _foreignKeysOdp, _indicesOdp);
        final TableInfo _existingOdp = TableInfo.read(db, "odp");
        if (!_infoOdp.equals(_existingOdp)) {
          return new RoomOpenHelper.ValidationResult(false, "odp(com.ispmanagement.app.data.Odp).\n"
                  + " Expected:\n" + _infoOdp + "\n"
                  + " Found:\n" + _existingOdp);
        }
        final HashMap<String, TableInfo.Column> _columnsCsUser = new HashMap<String, TableInfo.Column>(4);
        _columnsCsUser.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCsUser.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCsUser.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCsUser.put("nama", new TableInfo.Column("nama", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCsUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCsUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCsUser = new TableInfo("cs_user", _columnsCsUser, _foreignKeysCsUser, _indicesCsUser);
        final TableInfo _existingCsUser = TableInfo.read(db, "cs_user");
        if (!_infoCsUser.equals(_existingCsUser)) {
          return new RoomOpenHelper.ValidationResult(false, "cs_user(com.ispmanagement.app.data.CsUser).\n"
                  + " Expected:\n" + _infoCsUser + "\n"
                  + " Found:\n" + _existingCsUser);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8d501395380d90851ffcae7dd763a728", "e72b71203a66901d602a90f4b0e6fa5f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "pelanggan","tagihan","konfirmasi_pembayaran","tiket_komplain","odp","cs_user");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `pelanggan`");
      _db.execSQL("DELETE FROM `tagihan`");
      _db.execSQL("DELETE FROM `konfirmasi_pembayaran`");
      _db.execSQL("DELETE FROM `tiket_komplain`");
      _db.execSQL("DELETE FROM `odp`");
      _db.execSQL("DELETE FROM `cs_user`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PelangganDao.class, PelangganDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TagihanDao.class, TagihanDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(KonfirmasiPembayaranDao.class, KonfirmasiPembayaranDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TiketKomplainDao.class, TiketKomplainDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OdpDao.class, OdpDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CsUserDao.class, CsUserDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public PelangganDao pelangganDao() {
    if (_pelangganDao != null) {
      return _pelangganDao;
    } else {
      synchronized(this) {
        if(_pelangganDao == null) {
          _pelangganDao = new PelangganDao_Impl(this);
        }
        return _pelangganDao;
      }
    }
  }

  @Override
  public TagihanDao tagihanDao() {
    if (_tagihanDao != null) {
      return _tagihanDao;
    } else {
      synchronized(this) {
        if(_tagihanDao == null) {
          _tagihanDao = new TagihanDao_Impl(this);
        }
        return _tagihanDao;
      }
    }
  }

  @Override
  public KonfirmasiPembayaranDao konfirmasiDao() {
    if (_konfirmasiPembayaranDao != null) {
      return _konfirmasiPembayaranDao;
    } else {
      synchronized(this) {
        if(_konfirmasiPembayaranDao == null) {
          _konfirmasiPembayaranDao = new KonfirmasiPembayaranDao_Impl(this);
        }
        return _konfirmasiPembayaranDao;
      }
    }
  }

  @Override
  public TiketKomplainDao tiketDao() {
    if (_tiketKomplainDao != null) {
      return _tiketKomplainDao;
    } else {
      synchronized(this) {
        if(_tiketKomplainDao == null) {
          _tiketKomplainDao = new TiketKomplainDao_Impl(this);
        }
        return _tiketKomplainDao;
      }
    }
  }

  @Override
  public OdpDao odpDao() {
    if (_odpDao != null) {
      return _odpDao;
    } else {
      synchronized(this) {
        if(_odpDao == null) {
          _odpDao = new OdpDao_Impl(this);
        }
        return _odpDao;
      }
    }
  }

  @Override
  public CsUserDao csUserDao() {
    if (_csUserDao != null) {
      return _csUserDao;
    } else {
      synchronized(this) {
        if(_csUserDao == null) {
          _csUserDao = new CsUserDao_Impl(this);
        }
        return _csUserDao;
      }
    }
  }
}
