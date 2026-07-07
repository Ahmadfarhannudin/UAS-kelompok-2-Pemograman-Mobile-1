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
public final class TagihanDao_Impl implements TagihanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Tagihan> __insertionAdapterOfTagihan;

  private final EntityDeletionOrUpdateAdapter<Tagihan> __updateAdapterOfTagihan;

  public TagihanDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTagihan = new EntityInsertionAdapter<Tagihan>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `tagihan` (`id`,`pelangganId`,`periode`,`jumlah`,`jatuhTempo`,`status`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Tagihan entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getPelangganId());
        if (entity.getPeriode() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPeriode());
        }
        statement.bindLong(4, entity.getJumlah());
        if (entity.getJatuhTempo() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getJatuhTempo());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
      }
    };
    this.__updateAdapterOfTagihan = new EntityDeletionOrUpdateAdapter<Tagihan>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tagihan` SET `id` = ?,`pelangganId` = ?,`periode` = ?,`jumlah` = ?,`jatuhTempo` = ?,`status` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Tagihan entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getPelangganId());
        if (entity.getPeriode() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPeriode());
        }
        statement.bindLong(4, entity.getJumlah());
        if (entity.getJatuhTempo() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getJatuhTempo());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Tagihan tagihan, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTagihan.insertAndReturnId(tagihan);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Tagihan tagihan, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTagihan.handle(tagihan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Tagihan>> getByPelanggan(final long pelangganId) {
    final String _sql = "SELECT * FROM tagihan WHERE pelangganId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pelangganId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"tagihan"}, false, new Callable<List<Tagihan>>() {
      @Override
      @Nullable
      public List<Tagihan> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfPeriode = CursorUtil.getColumnIndexOrThrow(_cursor, "periode");
          final int _cursorIndexOfJumlah = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah");
          final int _cursorIndexOfJatuhTempo = CursorUtil.getColumnIndexOrThrow(_cursor, "jatuhTempo");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<Tagihan> _result = new ArrayList<Tagihan>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Tagihan _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpPeriode;
            if (_cursor.isNull(_cursorIndexOfPeriode)) {
              _tmpPeriode = null;
            } else {
              _tmpPeriode = _cursor.getString(_cursorIndexOfPeriode);
            }
            final long _tmpJumlah;
            _tmpJumlah = _cursor.getLong(_cursorIndexOfJumlah);
            final String _tmpJatuhTempo;
            if (_cursor.isNull(_cursorIndexOfJatuhTempo)) {
              _tmpJatuhTempo = null;
            } else {
              _tmpJatuhTempo = _cursor.getString(_cursorIndexOfJatuhTempo);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item = new Tagihan(_tmpId,_tmpPelangganId,_tmpPeriode,_tmpJumlah,_tmpJatuhTempo,_tmpStatus);
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
  public Object getByPelangganSync(final long pelangganId,
      final Continuation<? super List<Tagihan>> $completion) {
    final String _sql = "SELECT * FROM tagihan WHERE pelangganId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pelangganId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Tagihan>>() {
      @Override
      @NonNull
      public List<Tagihan> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfPeriode = CursorUtil.getColumnIndexOrThrow(_cursor, "periode");
          final int _cursorIndexOfJumlah = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah");
          final int _cursorIndexOfJatuhTempo = CursorUtil.getColumnIndexOrThrow(_cursor, "jatuhTempo");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<Tagihan> _result = new ArrayList<Tagihan>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Tagihan _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpPeriode;
            if (_cursor.isNull(_cursorIndexOfPeriode)) {
              _tmpPeriode = null;
            } else {
              _tmpPeriode = _cursor.getString(_cursorIndexOfPeriode);
            }
            final long _tmpJumlah;
            _tmpJumlah = _cursor.getLong(_cursorIndexOfJumlah);
            final String _tmpJatuhTempo;
            if (_cursor.isNull(_cursorIndexOfJatuhTempo)) {
              _tmpJatuhTempo = null;
            } else {
              _tmpJatuhTempo = _cursor.getString(_cursorIndexOfJatuhTempo);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item = new Tagihan(_tmpId,_tmpPelangganId,_tmpPeriode,_tmpJumlah,_tmpJatuhTempo,_tmpStatus);
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
  public Object getById(final long id, final Continuation<? super Tagihan> $completion) {
    final String _sql = "SELECT * FROM tagihan WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Tagihan>() {
      @Override
      @Nullable
      public Tagihan call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfPeriode = CursorUtil.getColumnIndexOrThrow(_cursor, "periode");
          final int _cursorIndexOfJumlah = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah");
          final int _cursorIndexOfJatuhTempo = CursorUtil.getColumnIndexOrThrow(_cursor, "jatuhTempo");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final Tagihan _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpPeriode;
            if (_cursor.isNull(_cursorIndexOfPeriode)) {
              _tmpPeriode = null;
            } else {
              _tmpPeriode = _cursor.getString(_cursorIndexOfPeriode);
            }
            final long _tmpJumlah;
            _tmpJumlah = _cursor.getLong(_cursorIndexOfJumlah);
            final String _tmpJatuhTempo;
            if (_cursor.isNull(_cursorIndexOfJatuhTempo)) {
              _tmpJatuhTempo = null;
            } else {
              _tmpJatuhTempo = _cursor.getString(_cursorIndexOfJatuhTempo);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _result = new Tagihan(_tmpId,_tmpPelangganId,_tmpPeriode,_tmpJumlah,_tmpJatuhTempo,_tmpStatus);
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
  public Object getOverdue(final String today,
      final Continuation<? super List<Tagihan>> $completion) {
    final String _sql = "SELECT * FROM tagihan WHERE status = 'Belum Bayar' AND jatuhTempo < ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (today == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, today);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Tagihan>>() {
      @Override
      @NonNull
      public List<Tagihan> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfPeriode = CursorUtil.getColumnIndexOrThrow(_cursor, "periode");
          final int _cursorIndexOfJumlah = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah");
          final int _cursorIndexOfJatuhTempo = CursorUtil.getColumnIndexOrThrow(_cursor, "jatuhTempo");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<Tagihan> _result = new ArrayList<Tagihan>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Tagihan _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpPeriode;
            if (_cursor.isNull(_cursorIndexOfPeriode)) {
              _tmpPeriode = null;
            } else {
              _tmpPeriode = _cursor.getString(_cursorIndexOfPeriode);
            }
            final long _tmpJumlah;
            _tmpJumlah = _cursor.getLong(_cursorIndexOfJumlah);
            final String _tmpJatuhTempo;
            if (_cursor.isNull(_cursorIndexOfJatuhTempo)) {
              _tmpJatuhTempo = null;
            } else {
              _tmpJatuhTempo = _cursor.getString(_cursorIndexOfJatuhTempo);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item = new Tagihan(_tmpId,_tmpPelangganId,_tmpPeriode,_tmpJumlah,_tmpJatuhTempo,_tmpStatus);
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
  public Object countUnpaid(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM tagihan WHERE status = 'Belum Bayar'";
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
  public LiveData<List<Tagihan>> getAllTagihan() {
    final String _sql = "SELECT * FROM tagihan ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"tagihan"}, false, new Callable<List<Tagihan>>() {
      @Override
      @Nullable
      public List<Tagihan> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPelangganId = CursorUtil.getColumnIndexOrThrow(_cursor, "pelangganId");
          final int _cursorIndexOfPeriode = CursorUtil.getColumnIndexOrThrow(_cursor, "periode");
          final int _cursorIndexOfJumlah = CursorUtil.getColumnIndexOrThrow(_cursor, "jumlah");
          final int _cursorIndexOfJatuhTempo = CursorUtil.getColumnIndexOrThrow(_cursor, "jatuhTempo");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<Tagihan> _result = new ArrayList<Tagihan>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Tagihan _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpPelangganId;
            _tmpPelangganId = _cursor.getLong(_cursorIndexOfPelangganId);
            final String _tmpPeriode;
            if (_cursor.isNull(_cursorIndexOfPeriode)) {
              _tmpPeriode = null;
            } else {
              _tmpPeriode = _cursor.getString(_cursorIndexOfPeriode);
            }
            final long _tmpJumlah;
            _tmpJumlah = _cursor.getLong(_cursorIndexOfJumlah);
            final String _tmpJatuhTempo;
            if (_cursor.isNull(_cursorIndexOfJatuhTempo)) {
              _tmpJatuhTempo = null;
            } else {
              _tmpJatuhTempo = _cursor.getString(_cursorIndexOfJatuhTempo);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item = new Tagihan(_tmpId,_tmpPelangganId,_tmpPeriode,_tmpJumlah,_tmpJatuhTempo,_tmpStatus);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
