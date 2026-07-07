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
public final class TiketKomplainDao_Impl implements TiketKomplainDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TiketKomplain> __insertionAdapterOfTiketKomplain;

  private final EntityDeletionOrUpdateAdapter<TiketKomplain> __updateAdapterOfTiketKomplain;

  public TiketKomplainDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTiketKomplain = new EntityInsertionAdapter<TiketKomplain>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `tiket_komplain` (`id`,`nomorAntrean`,`pelangganId`,`judul`,`deskripsi`,`status`,`balasanCS`,`tanggalDibuat`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TiketKomplain entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNomorAntrean() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomorAntrean());
        }
        statement.bindLong(3, entity.getPelangganId());
        if (entity.getJudul() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getJudul());
        }
        if (entity.getDeskripsi() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDeskripsi());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
        if (entity.getBalasanCS() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBalasanCS());
        }
        if (entity.getTanggalDibuat() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTanggalDibuat());
        }
      }
    };
    this.__updateAdapterOfTiketKomplain = new EntityDeletionOrUpdateAdapter<TiketKomplain>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tiket_komplain` SET `id` = ?,`nomorAntrean` = ?,`pelangganId` = ?,`judul` = ?,`deskripsi` = ?,`status` = ?,`balasanCS` = ?,`tanggalDibuat` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TiketKomplain entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNomorAntrean() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomorAntrean());
        }
        statement.bindLong(3, entity.getPelangganId());
        if (entity.getJudul() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getJudul());
        }
        if (entity.getDeskripsi() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDeskripsi());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
        if (entity.getBalasanCS() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBalasanCS());
        }
        if (entity.getTanggalDibuat() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTanggalDibuat());
        }
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final TiketKomplain tiket, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTiketKomplain.insertAndReturnId(tiket);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final TiketKomplain tiket, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTiketKomplain.handle(tiket);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<TiketKomplain>> getAll() {
    final String _sql = "SELECT * FROM tiket_komplain ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"tiket_komplain"}, false, new Callable<List<TiketKomplain>>() {
      @Override
      @Nullable
      public List<TiketKomplain> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNomorAntrean = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorAntrean");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfJudul = CursorUtil.getColumnIndexOrThrow(_cursor, "judul");
          final int _cursorIndexOfDeskripsi = CursorUtil.getColumnIndexOrThrow(_cursor, "deskripsi");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfBalasanCS = CursorUtil.getColumnIndexOrThrow(_cursor, "balasanCS");
          final int _cursorIndexOfTanggalDibuat = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalDibuat");
          final List<TiketKomplain> _result = new ArrayList<TiketKomplain>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TiketKomplain _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNomorAntrean;
            if (_cursor.isNull(_cursorIndexOfNomorAntrean)) {
              _tmpNomorAntrean = null;
            } else {
              _tmpNomorAntrean = _cursor.getString(_cursorIndexOfNomorAntrean);
            }
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpJudul;
            if (_cursor.isNull(_cursorIndexOfJudul)) {
              _tmpJudul = null;
            } else {
              _tmpJudul = _cursor.getString(_cursorIndexOfJudul);
            }
            final String _tmpDeskripsi;
            if (_cursor.isNull(_cursorIndexOfDeskripsi)) {
              _tmpDeskripsi = null;
            } else {
              _tmpDeskripsi = _cursor.getString(_cursorIndexOfDeskripsi);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpBalasanCS;
            if (_cursor.isNull(_cursorIndexOfBalasanCS)) {
              _tmpBalasanCS = null;
            } else {
              _tmpBalasanCS = _cursor.getString(_cursorIndexOfBalasanCS);
            }
            final String _tmpTanggalDibuat;
            if (_cursor.isNull(_cursorIndexOfTanggalDibuat)) {
              _tmpTanggalDibuat = null;
            } else {
              _tmpTanggalDibuat = _cursor.getString(_cursorIndexOfTanggalDibuat);
            }
            _item = new TiketKomplain(_tmpId,_tmpNomorAntrean,_tmpPelangganId,_tmpJudul,_tmpDeskripsi,_tmpStatus,_tmpBalasanCS,_tmpTanggalDibuat);
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
  public LiveData<List<TiketKomplain>> getByPelanggan(final long pelangganId) {
    final String _sql = "SELECT * FROM tiket_komplain WHERE pelangganId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pelangganId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"tiket_komplain"}, false, new Callable<List<TiketKomplain>>() {
      @Override
      @Nullable
      public List<TiketKomplain> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNomorAntrean = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorAntrean");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfJudul = CursorUtil.getColumnIndexOrThrow(_cursor, "judul");
          final int _cursorIndexOfDeskripsi = CursorUtil.getColumnIndexOrThrow(_cursor, "deskripsi");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfBalasanCS = CursorUtil.getColumnIndexOrThrow(_cursor, "balasanCS");
          final int _cursorIndexOfTanggalDibuat = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalDibuat");
          final List<TiketKomplain> _result = new ArrayList<TiketKomplain>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TiketKomplain _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNomorAntrean;
            if (_cursor.isNull(_cursorIndexOfNomorAntrean)) {
              _tmpNomorAntrean = null;
            } else {
              _tmpNomorAntrean = _cursor.getString(_cursorIndexOfNomorAntrean);
            }
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpJudul;
            if (_cursor.isNull(_cursorIndexOfJudul)) {
              _tmpJudul = null;
            } else {
              _tmpJudul = _cursor.getString(_cursorIndexOfJudul);
            }
            final String _tmpDeskripsi;
            if (_cursor.isNull(_cursorIndexOfDeskripsi)) {
              _tmpDeskripsi = null;
            } else {
              _tmpDeskripsi = _cursor.getString(_cursorIndexOfDeskripsi);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpBalasanCS;
            if (_cursor.isNull(_cursorIndexOfBalasanCS)) {
              _tmpBalasanCS = null;
            } else {
              _tmpBalasanCS = _cursor.getString(_cursorIndexOfBalasanCS);
            }
            final String _tmpTanggalDibuat;
            if (_cursor.isNull(_cursorIndexOfTanggalDibuat)) {
              _tmpTanggalDibuat = null;
            } else {
              _tmpTanggalDibuat = _cursor.getString(_cursorIndexOfTanggalDibuat);
            }
            _item = new TiketKomplain(_tmpId,_tmpNomorAntrean,_tmpPelangganId,_tmpJudul,_tmpDeskripsi,_tmpStatus,_tmpBalasanCS,_tmpTanggalDibuat);
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
  public Object getById(final long id, final Continuation<? super TiketKomplain> $completion) {
    final String _sql = "SELECT * FROM tiket_komplain WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TiketKomplain>() {
      @Override
      @Nullable
      public TiketKomplain call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNomorAntrean = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorAntrean");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfJudul = CursorUtil.getColumnIndexOrThrow(_cursor, "judul");
          final int _cursorIndexOfDeskripsi = CursorUtil.getColumnIndexOrThrow(_cursor, "deskripsi");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfBalasanCS = CursorUtil.getColumnIndexOrThrow(_cursor, "balasanCS");
          final int _cursorIndexOfTanggalDibuat = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggalDibuat");
          final TiketKomplain _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNomorAntrean;
            if (_cursor.isNull(_cursorIndexOfNomorAntrean)) {
              _tmpNomorAntrean = null;
            } else {
              _tmpNomorAntrean = _cursor.getString(_cursorIndexOfNomorAntrean);
            }
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpJudul;
            if (_cursor.isNull(_cursorIndexOfJudul)) {
              _tmpJudul = null;
            } else {
              _tmpJudul = _cursor.getString(_cursorIndexOfJudul);
            }
            final String _tmpDeskripsi;
            if (_cursor.isNull(_cursorIndexOfDeskripsi)) {
              _tmpDeskripsi = null;
            } else {
              _tmpDeskripsi = _cursor.getString(_cursorIndexOfDeskripsi);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpBalasanCS;
            if (_cursor.isNull(_cursorIndexOfBalasanCS)) {
              _tmpBalasanCS = null;
            } else {
              _tmpBalasanCS = _cursor.getString(_cursorIndexOfBalasanCS);
            }
            final String _tmpTanggalDibuat;
            if (_cursor.isNull(_cursorIndexOfTanggalDibuat)) {
              _tmpTanggalDibuat = null;
            } else {
              _tmpTanggalDibuat = _cursor.getString(_cursorIndexOfTanggalDibuat);
            }
            _result = new TiketKomplain(_tmpId,_tmpNomorAntrean,_tmpPelangganId,_tmpJudul,_tmpDeskripsi,_tmpStatus,_tmpBalasanCS,_tmpTanggalDibuat);
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
  public Object count(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM tiket_komplain";
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
