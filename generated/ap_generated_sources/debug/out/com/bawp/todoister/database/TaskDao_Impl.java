package com.bawp.todoister.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bawp.todoister.model.Priority;
import com.bawp.todoister.model.Task;
import com.bawp.todoister.utils.TypesConverter;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TaskDao_Impl implements TaskDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __deletionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __updateAdapterOfTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TaskDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tasks_table` (`task_id`,`task`,`end_date`,`priority`,`created_at`,`is_done`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        stmt.bindLong(1, value.id);
        if (value.task == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.task);
        }
        final Long _tmp;
        _tmp = TypesConverter.dateToTimestamp(value.endDate);
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = TypesConverter.priorityToString(value.priority);
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = TypesConverter.dateToTimestamp(value.createdAt);
        if (_tmp_2 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_2);
        }
        final int _tmp_3;
        _tmp_3 = value.isDone ? 1 : 0;
        stmt.bindLong(6, _tmp_3);
      }
    };
    this.__deletionAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tasks_table` WHERE `task_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tasks_table` SET `task_id` = ?,`task` = ?,`end_date` = ?,`priority` = ?,`created_at` = ?,`is_done` = ? WHERE `task_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        stmt.bindLong(1, value.id);
        if (value.task == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.task);
        }
        final Long _tmp;
        _tmp = TypesConverter.dateToTimestamp(value.endDate);
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = TypesConverter.priorityToString(value.priority);
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = TypesConverter.dateToTimestamp(value.createdAt);
        if (_tmp_2 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_2);
        }
        final int _tmp_3;
        _tmp_3 = value.isDone ? 1 : 0;
        stmt.bindLong(6, _tmp_3);
        stmt.bindLong(7, value.id);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tasks_table";
        return _query;
      }
    };
  }

  @Override
  public void insertTask(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTask.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTask(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTask.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSelectedTasks(final List<Task> tasks) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTask.handleMultiple(tasks);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTask(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTask.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Task>> getAllTasks() {
    final String _sql = "SELECT * FROM tasks_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tasks_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "task_id");
          final int _cursorIndexOfTask = CursorUtil.getColumnIndexOrThrow(_cursor, "task");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "end_date");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "is_done");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            final String _tmpTask;
            _tmpTask = _cursor.getString(_cursorIndexOfTask);
            final Date _tmpEndDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _tmpEndDate = TypesConverter.timestampToDate(_tmp);
            final Priority _tmpPriority;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfPriority);
            _tmpPriority = TypesConverter.stringToPriority(_tmp_1);
            final Date _tmpCreatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = TypesConverter.timestampToDate(_tmp_2);
            final boolean _tmpIsDone;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp_3 != 0;
            _item = new Task(_tmpTask,_tmpEndDate,_tmpPriority,_tmpCreatedAt,_tmpIsDone);
            _item.id = _cursor.getLong(_cursorIndexOfId);
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
  public LiveData<Task> getTask(final long id) {
    final String _sql = "SELECT * FROM tasks_table WHERE task_id == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tasks_table"}, false, new Callable<Task>() {
      @Override
      public Task call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "task_id");
          final int _cursorIndexOfTask = CursorUtil.getColumnIndexOrThrow(_cursor, "task");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "end_date");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfIsDone = CursorUtil.getColumnIndexOrThrow(_cursor, "is_done");
          final Task _result;
          if(_cursor.moveToFirst()) {
            final String _tmpTask;
            _tmpTask = _cursor.getString(_cursorIndexOfTask);
            final Date _tmpEndDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfEndDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfEndDate);
            }
            _tmpEndDate = TypesConverter.timestampToDate(_tmp);
            final Priority _tmpPriority;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfPriority);
            _tmpPriority = TypesConverter.stringToPriority(_tmp_1);
            final Date _tmpCreatedAt;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            _tmpCreatedAt = TypesConverter.timestampToDate(_tmp_2);
            final boolean _tmpIsDone;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsDone);
            _tmpIsDone = _tmp_3 != 0;
            _result = new Task(_tmpTask,_tmpEndDate,_tmpPriority,_tmpCreatedAt,_tmpIsDone);
            _result.id = _cursor.getLong(_cursorIndexOfId);
          } else {
            _result = null;
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
}
