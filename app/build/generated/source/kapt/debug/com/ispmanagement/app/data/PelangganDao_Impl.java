package com.ispmanagement.app.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PelangganDao_Impl implements PelangganDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Pelanggan> __insertionAdapterOfPelanggan;

  private final EntityDeletionOrUpdateAdapter<Pelanggan> __updateAdapterOfPelanggan;

  public PelangganDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPelanggan = new EntityInsertionAdapter<Pelanggan>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `pelanggan` (`id`,`nomorLayanan`,`nama`,`alamat`,`noHp`,`paket`,`hargaPaket`,`odp`,`tanggalDaftar`,`statusLayanan`,`username`,`password`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Pelanggan entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNomorLayanan() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomorLayanan());
        }
        if (entity.getNama() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNama());
        }
        if (entity.getAlamat() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAlamat());
        }
        if (entity.getNoHp() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getNoHp());
        }
        if (entity.getPaket() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPaket());
        }
        statement.bindLong(7, entity.getHargaPaket());
        if (entity.getOdp() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getOdp());
        }
        if (entity.getTanggalDaftar() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getTanggalDaftar());
        }
        if (entity.getStatusLayanan() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getStatusLayanan());
        }
        if (entity.getUsername() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getUsername());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getPassword());
        }
      }
    };
    this.__updateAdapterOfPelanggan = new EntityDeletionOrUpdateAdapter<Pelanggan>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `pelanggan` SET `id` = ?,`nomorLayanan` = ?,`nama` = ?,`alamat` = ?,`noHp` = ?,`paket` = ?,`hargaPaket` = ?,`odp` = ?,`tanggalDaftar` = ?,`statusLayanan` = ?,`username` = ?,`password` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Pelanggan entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNomorLayanan() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomorLayanan());
        }
        if (entity.getNama() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNama());
        }
        if (entity.getAlamat() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getAlamat());
        }
        if (entity.getNoHp() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getNoHp());
        }
        if (entity.getPaket() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPaket());
        }
        statement.bindLong(7, entity.getHargaPaket());
        if (entity.getOdp() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getOdp());
        }
        if (entity.getTanggalDaftar() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getTanggalDaftar());
        }
        if (entity.getStatusLayanan() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getStatusLayanan());
        }
        if (entity.getUsername() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getUsername());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getPassword());
        }
        statement.bindLong(13, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Pelanggan pelanggan, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPelanggan.insertAndReturnId(pelanggan);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Pelanggan pelanggan, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPelanggan.handle(pelanggan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getByNomorLayanan(final String nomorLayanan,
      final Continuation<? super Pelanggan> $completion) {
    final String _sql = "SELECT * FROM pelanggan WHERE nomorLayanan = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nomorLayanan == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nomorLayanan);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Pelanggan>() {
      @Override
      @Nullable
      public Pelanggan call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNomorLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorLayanan");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
          final int _cursorIndexOfNoHp = CursorUtil.getColumnIndexOrThrow(_cursor, "noHp");
          final int _cursorIndexOfPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "paket");
          final int _cursorIndexOfHargaPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "hargaPaket");
          final int _cursorIndexOfOdp = CursorUtil.getColumnIndexOrThrow(_cursor, "odp");
          final int _cursorIndexOfTanggalDaftar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalDaftar");
          final int _cursorIndexOfStatusLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "statusLayanan");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final Pelanggan _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNomorLayanan;
            if (_cursor.isNull(_cursorIndexOfNomorLayanan)) {
              _tmpNomorLayanan = null;
            } else {
              _tmpNomorLayanan = _cursor.getString(_cursorIndexOfNomorLayanan);
            }
            final String _tmpNama;
            if (_cursor.isNull(_cursorIndexOfNama)) {
              _tmpNama = null;
            } else {
              _tmpNama = _cursor.getString(_cursorIndexOfNama);
            }
            final String _tmpAlamat;
            if (_cursor.isNull(_cursorIndexOfAlamat)) {
              _tmpAlamat = null;
            } else {
              _tmpAlamat = _cursor.getString(_cursorIndexOfAlamat);
            }
            final String _tmpNoHp;
            if (_cursor.isNull(_cursorIndexOfNoHp)) {
              _tmpNoHp = null;
            } else {
              _tmpNoHp = _cursor.getString(_cursorIndexOfNoHp);
            }
            final String _tmpPaket;
            if (_cursor.isNull(_cursorIndexOfPaket)) {
              _tmpPaket = null;
            } else {
              _tmpPaket = _cursor.getString(_cursorIndexOfPaket);
            }
            final long _tmpHargaPaket;
            _tmpHargaPaket = _cursor.getLong(_cursorIndexOfHargaPaket);
            final String _tmpOdp;
            if (_cursor.isNull(_cursorIndexOfOdp)) {
              _tmpOdp = null;
            } else {
              _tmpOdp = _cursor.getString(_cursorIndexOfOdp);
            }
            final String _tmpTanggalDaftar;
            if (_cursor.isNull(_cursorIndexOfTanggalDaftar)) {
              _tmpTanggalDaftar = null;
            } else {
              _tmpTanggalDaftar = _cursor.getString(_cursorIndexOfTanggalDaftar);
            }
            final String _tmpStatusLayanan;
            if (_cursor.isNull(_cursorIndexOfStatusLayanan)) {
              _tmpStatusLayanan = null;
            } else {
              _tmpStatusLayanan = _cursor.getString(_cursorIndexOfStatusLayanan);
            }
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _result = new Pelanggan(_tmpId,_tmpNomorLayanan,_tmpNama,_tmpAlamat,_tmpNoHp,_tmpPaket,_tmpHargaPaket,_tmpOdp,_tmpTanggalDaftar,_tmpStatusLayanan,_tmpUsername,_tmpPassword);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object login(final String username, final String password,
      final Continuation<? super Pelanggan> $completion) {
    final String _sql = "SELECT * FROM pelanggan WHERE username = ? AND password = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Pelanggan>() {
      @Override
      @Nullable
      public Pelanggan call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNomorLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorLayanan");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
          final int _cursorIndexOfNoHp = CursorUtil.getColumnIndexOrThrow(_cursor, "noHp");
          final int _cursorIndexOfPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "paket");
          final int _cursorIndexOfHargaPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "hargaPaket");
          final int _cursorIndexOfOdp = CursorUtil.getColumnIndexOrThrow(_cursor, "odp");
          final int _cursorIndexOfTanggalDaftar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalDaftar");
          final int _cursorIndexOfStatusLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "statusLayanan");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final Pelanggan _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNomorLayanan;
            if (_cursor.isNull(_cursorIndexOfNomorLayanan)) {
              _tmpNomorLayanan = null;
            } else {
              _tmpNomorLayanan = _cursor.getString(_cursorIndexOfNomorLayanan);
            }
            final String _tmpNama;
            if (_cursor.isNull(_cursorIndexOfNama)) {
              _tmpNama = null;
            } else {
              _tmpNama = _cursor.getString(_cursorIndexOfNama);
            }
            final String _tmpAlamat;
            if (_cursor.isNull(_cursorIndexOfAlamat)) {
              _tmpAlamat = null;
            } else {
              _tmpAlamat = _cursor.getString(_cursorIndexOfAlamat);
            }
            final String _tmpNoHp;
            if (_cursor.isNull(_cursorIndexOfNoHp)) {
              _tmpNoHp = null;
            } else {
              _tmpNoHp = _cursor.getString(_cursorIndexOfNoHp);
            }
            final String _tmpPaket;
            if (_cursor.isNull(_cursorIndexOfPaket)) {
              _tmpPaket = null;
            } else {
              _tmpPaket = _cursor.getString(_cursorIndexOfPaket);
            }
            final long _tmpHargaPaket;
            _tmpHargaPaket = _cursor.getLong(_cursorIndexOfHargaPaket);
            final String _tmpOdp;
            if (_cursor.isNull(_cursorIndexOfOdp)) {
              _tmpOdp = null;
            } else {
              _tmpOdp = _cursor.getString(_cursorIndexOfOdp);
            }
            final String _tmpTanggalDaftar;
            if (_cursor.isNull(_cursorIndexOfTanggalDaftar)) {
              _tmpTanggalDaftar = null;
            } else {
              _tmpTanggalDaftar = _cursor.getString(_cursorIndexOfTanggalDaftar);
            }
            final String _tmpStatusLayanan;
            if (_cursor.isNull(_cursorIndexOfStatusLayanan)) {
              _tmpStatusLayanan = null;
            } else {
              _tmpStatusLayanan = _cursor.getString(_cursorIndexOfStatusLayanan);
            }
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _result = new Pelanggan(_tmpId,_tmpNomorLayanan,_tmpNama,_tmpAlamat,_tmpNoHp,_tmpPaket,_tmpHargaPaket,_tmpOdp,_tmpTanggalDaftar,_tmpStatusLayanan,_tmpUsername,_tmpPassword);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getById(final long id, final Continuation<? super Pelanggan> $completion) {
    final String _sql = "SELECT * FROM pelanggan WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Pelanggan>() {
      @Override
      @Nullable
      public Pelanggan call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNomorLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorLayanan");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
          final int _cursorIndexOfNoHp = CursorUtil.getColumnIndexOrThrow(_cursor, "noHp");
          final int _cursorIndexOfPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "paket");
          final int _cursorIndexOfHargaPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "hargaPaket");
          final int _cursorIndexOfOdp = CursorUtil.getColumnIndexOrThrow(_cursor, "odp");
          final int _cursorIndexOfTanggalDaftar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalDaftar");
          final int _cursorIndexOfStatusLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "statusLayanan");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final Pelanggan _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNomorLayanan;
            if (_cursor.isNull(_cursorIndexOfNomorLayanan)) {
              _tmpNomorLayanan = null;
            } else {
              _tmpNomorLayanan = _cursor.getString(_cursorIndexOfNomorLayanan);
            }
            final String _tmpNama;
            if (_cursor.isNull(_cursorIndexOfNama)) {
              _tmpNama = null;
            } else {
              _tmpNama = _cursor.getString(_cursorIndexOfNama);
            }
            final String _tmpAlamat;
            if (_cursor.isNull(_cursorIndexOfAlamat)) {
              _tmpAlamat = null;
            } else {
              _tmpAlamat = _cursor.getString(_cursorIndexOfAlamat);
            }
            final String _tmpNoHp;
            if (_cursor.isNull(_cursorIndexOfNoHp)) {
              _tmpNoHp = null;
            } else {
              _tmpNoHp = _cursor.getString(_cursorIndexOfNoHp);
            }
            final String _tmpPaket;
            if (_cursor.isNull(_cursorIndexOfPaket)) {
              _tmpPaket = null;
            } else {
              _tmpPaket = _cursor.getString(_cursorIndexOfPaket);
            }
            final long _tmpHargaPaket;
            _tmpHargaPaket = _cursor.getLong(_cursorIndexOfHargaPaket);
            final String _tmpOdp;
            if (_cursor.isNull(_cursorIndexOfOdp)) {
              _tmpOdp = null;
            } else {
              _tmpOdp = _cursor.getString(_cursorIndexOfOdp);
            }
            final String _tmpTanggalDaftar;
            if (_cursor.isNull(_cursorIndexOfTanggalDaftar)) {
              _tmpTanggalDaftar = null;
            } else {
              _tmpTanggalDaftar = _cursor.getString(_cursorIndexOfTanggalDaftar);
            }
            final String _tmpStatusLayanan;
            if (_cursor.isNull(_cursorIndexOfStatusLayanan)) {
              _tmpStatusLayanan = null;
            } else {
              _tmpStatusLayanan = _cursor.getString(_cursorIndexOfStatusLayanan);
            }
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _result = new Pelanggan(_tmpId,_tmpNomorLayanan,_tmpNama,_tmpAlamat,_tmpNoHp,_tmpPaket,_tmpHargaPaket,_tmpOdp,_tmpTanggalDaftar,_tmpStatusLayanan,_tmpUsername,_tmpPassword);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Pelanggan>> getAll() {
    final String _sql = "SELECT * FROM pelanggan ORDER BY nama ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"pelanggan"}, false, new Callable<List<Pelanggan>>() {
      @Override
      @Nullable
      public List<Pelanggan> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNomorLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorLayanan");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
          final int _cursorIndexOfNoHp = CursorUtil.getColumnIndexOrThrow(_cursor, "noHp");
          final int _cursorIndexOfPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "paket");
          final int _cursorIndexOfHargaPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "hargaPaket");
          final int _cursorIndexOfOdp = CursorUtil.getColumnIndexOrThrow(_cursor, "odp");
          final int _cursorIndexOfTanggalDaftar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalDaftar");
          final int _cursorIndexOfStatusLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "statusLayanan");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final List<Pelanggan> _result = new ArrayList<Pelanggan>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Pelanggan _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNomorLayanan;
            if (_cursor.isNull(_cursorIndexOfNomorLayanan)) {
              _tmpNomorLayanan = null;
            } else {
              _tmpNomorLayanan = _cursor.getString(_cursorIndexOfNomorLayanan);
            }
            final String _tmpNama;
            if (_cursor.isNull(_cursorIndexOfNama)) {
              _tmpNama = null;
            } else {
              _tmpNama = _cursor.getString(_cursorIndexOfNama);
            }
            final String _tmpAlamat;
            if (_cursor.isNull(_cursorIndexOfAlamat)) {
              _tmpAlamat = null;
            } else {
              _tmpAlamat = _cursor.getString(_cursorIndexOfAlamat);
            }
            final String _tmpNoHp;
            if (_cursor.isNull(_cursorIndexOfNoHp)) {
              _tmpNoHp = null;
            } else {
              _tmpNoHp = _cursor.getString(_cursorIndexOfNoHp);
            }
            final String _tmpPaket;
            if (_cursor.isNull(_cursorIndexOfPaket)) {
              _tmpPaket = null;
            } else {
              _tmpPaket = _cursor.getString(_cursorIndexOfPaket);
            }
            final long _tmpHargaPaket;
            _tmpHargaPaket = _cursor.getLong(_cursorIndexOfHargaPaket);
            final String _tmpOdp;
            if (_cursor.isNull(_cursorIndexOfOdp)) {
              _tmpOdp = null;
            } else {
              _tmpOdp = _cursor.getString(_cursorIndexOfOdp);
            }
            final String _tmpTanggalDaftar;
            if (_cursor.isNull(_cursorIndexOfTanggalDaftar)) {
              _tmpTanggalDaftar = null;
            } else {
              _tmpTanggalDaftar = _cursor.getString(_cursorIndexOfTanggalDaftar);
            }
            final String _tmpStatusLayanan;
            if (_cursor.isNull(_cursorIndexOfStatusLayanan)) {
              _tmpStatusLayanan = null;
            } else {
              _tmpStatusLayanan = _cursor.getString(_cursorIndexOfStatusLayanan);
            }
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _item = new Pelanggan(_tmpId,_tmpNomorLayanan,_tmpNama,_tmpAlamat,_tmpNoHp,_tmpPaket,_tmpHargaPaket,_tmpOdp,_tmpTanggalDaftar,_tmpStatusLayanan,_tmpUsername,_tmpPassword);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object count(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM pelanggan";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getLastPelanggan(final Continuation<? super Pelanggan> $completion) {
    final String _sql = "SELECT * FROM pelanggan ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Pelanggan>() {
      @Override
      @Nullable
      public Pelanggan call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNomorLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorLayanan");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
          final int _cursorIndexOfNoHp = CursorUtil.getColumnIndexOrThrow(_cursor, "noHp");
          final int _cursorIndexOfPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "paket");
          final int _cursorIndexOfHargaPaket = CursorUtil.getColumnIndexOrThrow(_cursor, "hargaPaket");
          final int _cursorIndexOfOdp = CursorUtil.getColumnIndexOrThrow(_cursor, "odp");
          final int _cursorIndexOfTanggalDaftar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalDaftar");
          final int _cursorIndexOfStatusLayanan = CursorUtil.getColumnIndexOrThrow(_cursor, "statusLayanan");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final Pelanggan _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNomorLayanan;
            if (_cursor.isNull(_cursorIndexOfNomorLayanan)) {
              _tmpNomorLayanan = null;
            } else {
              _tmpNomorLayanan = _cursor.getString(_cursorIndexOfNomorLayanan);
            }
            final String _tmpNama;
            if (_cursor.isNull(_cursorIndexOfNama)) {
              _tmpNama = null;
            } else {
              _tmpNama = _cursor.getString(_cursorIndexOfNama);
            }
            final String _tmpAlamat;
            if (_cursor.isNull(_cursorIndexOfAlamat)) {
              _tmpAlamat = null;
            } else {
              _tmpAlamat = _cursor.getString(_cursorIndexOfAlamat);
            }
            final String _tmpNoHp;
            if (_cursor.isNull(_cursorIndexOfNoHp)) {
              _tmpNoHp = null;
            } else {
              _tmpNoHp = _cursor.getString(_cursorIndexOfNoHp);
            }
            final String _tmpPaket;
            if (_cursor.isNull(_cursorIndexOfPaket)) {
              _tmpPaket = null;
            } else {
              _tmpPaket = _cursor.getString(_cursorIndexOfPaket);
            }
            final long _tmpHargaPaket;
            _tmpHargaPaket = _cursor.getLong(_cursorIndexOfHargaPaket);
            final String _tmpOdp;
            if (_cursor.isNull(_cursorIndexOfOdp)) {
              _tmpOdp = null;
            } else {
              _tmpOdp = _cursor.getString(_cursorIndexOfOdp);
            }
            final String _tmpTanggalDaftar;
            if (_cursor.isNull(_cursorIndexOfTanggalDaftar)) {
              _tmpTanggalDaftar = null;
            } else {
              _tmpTanggalDaftar = _cursor.getString(_cursorIndexOfTanggalDaftar);
            }
            final String _tmpStatusLayanan;
            if (_cursor.isNull(_cursorIndexOfStatusLayanan)) {
              _tmpStatusLayanan = null;
            } else {
              _tmpStatusLayanan = _cursor.getString(_cursorIndexOfStatusLayanan);
            }
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _result = new Pelanggan(_tmpId,_tmpNomorLayanan,_tmpNama,_tmpAlamat,_tmpNoHp,_tmpPaket,_tmpHargaPaket,_tmpOdp,_tmpTanggalDaftar,_tmpStatusLayanan,_tmpUsername,_tmpPassword);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
