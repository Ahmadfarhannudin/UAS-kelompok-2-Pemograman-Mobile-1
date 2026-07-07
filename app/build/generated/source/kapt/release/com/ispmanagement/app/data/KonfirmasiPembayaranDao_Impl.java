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
public final class KonfirmasiPembayaranDao_Impl implements KonfirmasiPembayaranDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<KonfirmasiPembayaran> __insertionAdapterOfKonfirmasiPembayaran;

  private final EntityDeletionOrUpdateAdapter<KonfirmasiPembayaran> __updateAdapterOfKonfirmasiPembayaran;

  public KonfirmasiPembayaranDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKonfirmasiPembayaran = new EntityInsertionAdapter<KonfirmasiPembayaran>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `konfirmasi_pembayaran` (`id`,`tagihanId`,`pelangganId`,`tanggalBayar`,`caraBayar`,`fotoPath`,`status`,`catatanCS`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KonfirmasiPembayaran entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTagihanId());
        statement.bindLong(3, entity.getPelangganId());
        if (entity.getTanggalBayar() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTanggalBayar());
        }
        if (entity.getCaraBayar() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCaraBayar());
        }
        if (entity.getFotoPath() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getFotoPath());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getStatus());
        }
        if (entity.getCatatanCS() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCatatanCS());
        }
      }
    };
    this.__updateAdapterOfKonfirmasiPembayaran = new EntityDeletionOrUpdateAdapter<KonfirmasiPembayaran>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `konfirmasi_pembayaran` SET `id` = ?,`tagihanId` = ?,`pelangganId` = ?,`tanggalBayar` = ?,`caraBayar` = ?,`fotoPath` = ?,`status` = ?,`catatanCS` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final KonfirmasiPembayaran entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTagihanId());
        statement.bindLong(3, entity.getPelangganId());
        if (entity.getTanggalBayar() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTanggalBayar());
        }
        if (entity.getCaraBayar() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCaraBayar());
        }
        if (entity.getFotoPath() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getFotoPath());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getStatus());
        }
        if (entity.getCatatanCS() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getCatatanCS());
        }
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final KonfirmasiPembayaran konfirmasi,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfKonfirmasiPembayaran.insertAndReturnId(konfirmasi);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final KonfirmasiPembayaran konfirmasi,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfKonfirmasiPembayaran.handle(konfirmasi);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<KonfirmasiPembayaran>> getAll() {
    final String _sql = "SELECT * FROM konfirmasi_pembayaran ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"konfirmasi_pembayaran"}, false, new Callable<List<KonfirmasiPembayaran>>() {
      @Override
      @Nullable
      public List<KonfirmasiPembayaran> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTagihanId = CursorUtil.getColumnIndexOrThrow(_cursor, "tagihanId");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfTanggalBayar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalBayar");
          final int _cursorIndexOfCaraBayar = CursorUtil.getColumnIndexOrThrow(_cursor, "caraBayar");
          final int _cursorIndexOfFotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoPath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCatatanCS = CursorUtil.getColumnIndexOrThrow(_cursor, "catatanCS");
          final List<KonfirmasiPembayaran> _result = new ArrayList<KonfirmasiPembayaran>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KonfirmasiPembayaran _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTagihanId;
            _tmpTagihanId = _cursor.getLong(_cursorIndexOfTagihanId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpTanggalBayar;
            if (_cursor.isNull(_cursorIndexOfTanggalBayar)) {
              _tmpTanggalBayar = null;
            } else {
              _tmpTanggalBayar = _cursor.getString(_cursorIndexOfTanggalBayar);
            }
            final String _tmpCaraBayar;
            if (_cursor.isNull(_cursorIndexOfCaraBayar)) {
              _tmpCaraBayar = null;
            } else {
              _tmpCaraBayar = _cursor.getString(_cursorIndexOfCaraBayar);
            }
            final String _tmpFotoPath;
            if (_cursor.isNull(_cursorIndexOfFotoPath)) {
              _tmpFotoPath = null;
            } else {
              _tmpFotoPath = _cursor.getString(_cursorIndexOfFotoPath);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpCatatanCS;
            if (_cursor.isNull(_cursorIndexOfCatatanCS)) {
              _tmpCatatanCS = null;
            } else {
              _tmpCatatanCS = _cursor.getString(_cursorIndexOfCatatanCS);
            }
            _item = new KonfirmasiPembayaran(_tmpId,_tmpTagihanId,_tmpPelangganId,_tmpTanggalBayar,_tmpCaraBayar,_tmpFotoPath,_tmpStatus,_tmpCatatanCS);
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
  public Object getAllKonfirmasiSync(
      final Continuation<? super List<KonfirmasiPembayaran>> $completion) {
    final String _sql = "SELECT * FROM konfirmasi_pembayaran";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<KonfirmasiPembayaran>>() {
      @Override
      @NonNull
      public List<KonfirmasiPembayaran> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTagihanId = CursorUtil.getColumnIndexOrThrow(_cursor, "tagihanId");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfTanggalBayar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalBayar");
          final int _cursorIndexOfCaraBayar = CursorUtil.getColumnIndexOrThrow(_cursor, "caraBayar");
          final int _cursorIndexOfFotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoPath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCatatanCS = CursorUtil.getColumnIndexOrThrow(_cursor, "catatanCS");
          final List<KonfirmasiPembayaran> _result = new ArrayList<KonfirmasiPembayaran>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KonfirmasiPembayaran _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTagihanId;
            _tmpTagihanId = _cursor.getLong(_cursorIndexOfTagihanId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpTanggalBayar;
            if (_cursor.isNull(_cursorIndexOfTanggalBayar)) {
              _tmpTanggalBayar = null;
            } else {
              _tmpTanggalBayar = _cursor.getString(_cursorIndexOfTanggalBayar);
            }
            final String _tmpCaraBayar;
            if (_cursor.isNull(_cursorIndexOfCaraBayar)) {
              _tmpCaraBayar = null;
            } else {
              _tmpCaraBayar = _cursor.getString(_cursorIndexOfCaraBayar);
            }
            final String _tmpFotoPath;
            if (_cursor.isNull(_cursorIndexOfFotoPath)) {
              _tmpFotoPath = null;
            } else {
              _tmpFotoPath = _cursor.getString(_cursorIndexOfFotoPath);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpCatatanCS;
            if (_cursor.isNull(_cursorIndexOfCatatanCS)) {
              _tmpCatatanCS = null;
            } else {
              _tmpCatatanCS = _cursor.getString(_cursorIndexOfCatatanCS);
            }
            _item = new KonfirmasiPembayaran(_tmpId,_tmpTagihanId,_tmpPelangganId,_tmpTanggalBayar,_tmpCaraBayar,_tmpFotoPath,_tmpStatus,_tmpCatatanCS);
            _result.add(_item);
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
  public LiveData<List<KonfirmasiPembayaran>> getPending() {
    final String _sql = "SELECT * FROM konfirmasi_pembayaran WHERE status = 'Pending' ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"konfirmasi_pembayaran"}, false, new Callable<List<KonfirmasiPembayaran>>() {
      @Override
      @Nullable
      public List<KonfirmasiPembayaran> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTagihanId = CursorUtil.getColumnIndexOrThrow(_cursor, "tagihanId");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfTanggalBayar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalBayar");
          final int _cursorIndexOfCaraBayar = CursorUtil.getColumnIndexOrThrow(_cursor, "caraBayar");
          final int _cursorIndexOfFotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoPath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCatatanCS = CursorUtil.getColumnIndexOrThrow(_cursor, "catatanCS");
          final List<KonfirmasiPembayaran> _result = new ArrayList<KonfirmasiPembayaran>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final KonfirmasiPembayaran _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTagihanId;
            _tmpTagihanId = _cursor.getLong(_cursorIndexOfTagihanId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpTanggalBayar;
            if (_cursor.isNull(_cursorIndexOfTanggalBayar)) {
              _tmpTanggalBayar = null;
            } else {
              _tmpTanggalBayar = _cursor.getString(_cursorIndexOfTanggalBayar);
            }
            final String _tmpCaraBayar;
            if (_cursor.isNull(_cursorIndexOfCaraBayar)) {
              _tmpCaraBayar = null;
            } else {
              _tmpCaraBayar = _cursor.getString(_cursorIndexOfCaraBayar);
            }
            final String _tmpFotoPath;
            if (_cursor.isNull(_cursorIndexOfFotoPath)) {
              _tmpFotoPath = null;
            } else {
              _tmpFotoPath = _cursor.getString(_cursorIndexOfFotoPath);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpCatatanCS;
            if (_cursor.isNull(_cursorIndexOfCatatanCS)) {
              _tmpCatatanCS = null;
            } else {
              _tmpCatatanCS = _cursor.getString(_cursorIndexOfCatatanCS);
            }
            _item = new KonfirmasiPembayaran(_tmpId,_tmpTagihanId,_tmpPelangganId,_tmpTanggalBayar,_tmpCaraBayar,_tmpFotoPath,_tmpStatus,_tmpCatatanCS);
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
  public Object getById(final long id,
      final Continuation<? super KonfirmasiPembayaran> $completion) {
    final String _sql = "SELECT * FROM konfirmasi_pembayaran WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<KonfirmasiPembayaran>() {
      @Override
      @Nullable
      public KonfirmasiPembayaran call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTagihanId = CursorUtil.getColumnIndexOrThrow(_cursor, "tagihanId");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfTanggalBayar = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalBayar");
          final int _cursorIndexOfCaraBayar = CursorUtil.getColumnIndexOrThrow(_cursor, "caraBayar");
          final int _cursorIndexOfFotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoPath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCatatanCS = CursorUtil.getColumnIndexOrThrow(_cursor, "catatanCS");
          final KonfirmasiPembayaran _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTagihanId;
            _tmpTagihanId = _cursor.getLong(_cursorIndexOfTagihanId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpTanggalBayar;
            if (_cursor.isNull(_cursorIndexOfTanggalBayar)) {
              _tmpTanggalBayar = null;
            } else {
              _tmpTanggalBayar = _cursor.getString(_cursorIndexOfTanggalBayar);
            }
            final String _tmpCaraBayar;
            if (_cursor.isNull(_cursorIndexOfCaraBayar)) {
              _tmpCaraBayar = null;
            } else {
              _tmpCaraBayar = _cursor.getString(_cursorIndexOfCaraBayar);
            }
            final String _tmpFotoPath;
            if (_cursor.isNull(_cursorIndexOfFotoPath)) {
              _tmpFotoPath = null;
            } else {
              _tmpFotoPath = _cursor.getString(_cursorIndexOfFotoPath);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpCatatanCS;
            if (_cursor.isNull(_cursorIndexOfCatatanCS)) {
              _tmpCatatanCS = null;
            } else {
              _tmpCatatanCS = _cursor.getString(_cursorIndexOfCatatanCS);
            }
            _result = new KonfirmasiPembayaran(_tmpId,_tmpTagihanId,_tmpPelangganId,_tmpTanggalBayar,_tmpCaraBayar,_tmpFotoPath,_tmpStatus,_tmpCatatanCS);
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
