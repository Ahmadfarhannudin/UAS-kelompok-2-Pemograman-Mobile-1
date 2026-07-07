package com.ispmanagement.app.data;

import android.database.Cursor;
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
public final class OdpDao_Impl implements OdpDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Odp> __insertionAdapterOfOdp;

  private final EntityDeletionOrUpdateAdapter<Odp> __deletionAdapterOfOdp;

  private final EntityDeletionOrUpdateAdapter<Odp> __updateAdapterOfOdp;

  public OdpDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOdp = new EntityInsertionAdapter<Odp>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `odp` (`id`,`namaOdp`,`alamat`,`latitude`,`longitude`,`totalPort`,`portTerpakai`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Odp entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNamaOdp() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNamaOdp());
        }
        if (entity.getAlamat() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAlamat());
        }
        statement.bindDouble(4, entity.getLatitude());
        statement.bindDouble(5, entity.getLongitude());
        statement.bindLong(6, entity.getTotalPort());
        statement.bindLong(7, entity.getPortTerpakai());
      }
    };
    this.__deletionAdapterOfOdp = new EntityDeletionOrUpdateAdapter<Odp>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `odp` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Odp entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfOdp = new EntityDeletionOrUpdateAdapter<Odp>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `odp` SET `id` = ?,`namaOdp` = ?,`alamat` = ?,`latitude` = ?,`longitude` = ?,`totalPort` = ?,`portTerpakai` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Odp entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNamaOdp() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNamaOdp());
        }
        if (entity.getAlamat() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAlamat());
        }
        statement.bindDouble(4, entity.getLatitude());
        statement.bindDouble(5, entity.getLongitude());
        statement.bindLong(6, entity.getTotalPort());
        statement.bindLong(7, entity.getPortTerpakai());
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Odp odp, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfOdp.insertAndReturnId(odp);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Odp odp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfOdp.handle(odp);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Odp odp, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfOdp.handle(odp);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Odp>> getAll() {
    final String _sql = "SELECT * FROM odp ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"odp"}, false, new Callable<List<Odp>>() {
      @Override
      @Nullable
      public List<Odp> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNamaOdp = CursorUtil.getColumnIndexOrThrow(_cursor, "namaOdp");
          final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfTotalPort = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPort");
          final int _cursorIndexOfPortTerpakai = CursorUtil.getColumnIndexOrThrow(_cursor, "portTerpakai");
          final List<Odp> _result = new ArrayList<Odp>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Odp _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNamaOdp;
            if (_cursor.isNull(_cursorIndexOfNamaOdp)) {
              _tmpNamaOdp = null;
            } else {
              _tmpNamaOdp = _cursor.getString(_cursorIndexOfNamaOdp);
            }
            final String _tmpAlamat;
            if (_cursor.isNull(_cursorIndexOfAlamat)) {
              _tmpAlamat = null;
            } else {
              _tmpAlamat = _cursor.getString(_cursorIndexOfAlamat);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final int _tmpTotalPort;
            _tmpTotalPort = _cursor.getInt(_cursorIndexOfTotalPort);
            final int _tmpPortTerpakai;
            _tmpPortTerpakai = _cursor.getInt(_cursorIndexOfPortTerpakai);
            _item = new Odp(_tmpId,_tmpNamaOdp,_tmpAlamat,_tmpLatitude,_tmpLongitude,_tmpTotalPort,_tmpPortTerpakai);
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
