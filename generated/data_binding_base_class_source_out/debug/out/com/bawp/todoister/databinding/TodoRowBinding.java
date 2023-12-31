// Generated by view binder compiler. Do not edit!
package com.bawp.todoister.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bawp.todoister.R;
import com.google.android.material.chip.Chip;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TodoRowBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RadioButton todoRadioButton;

  @NonNull
  public final RadioGroup todoRadioGroup;

  @NonNull
  public final Chip todoRowChip;

  @NonNull
  public final ConstraintLayout todoRowLayout;

  @NonNull
  public final TextView todoRowTodo;

  private TodoRowBinding(@NonNull ConstraintLayout rootView, @NonNull RadioButton todoRadioButton,
      @NonNull RadioGroup todoRadioGroup, @NonNull Chip todoRowChip,
      @NonNull ConstraintLayout todoRowLayout, @NonNull TextView todoRowTodo) {
    this.rootView = rootView;
    this.todoRadioButton = todoRadioButton;
    this.todoRadioGroup = todoRadioGroup;
    this.todoRowChip = todoRowChip;
    this.todoRowLayout = todoRowLayout;
    this.todoRowTodo = todoRowTodo;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TodoRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TodoRowBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.todo_row, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TodoRowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.todo_radio_button;
      RadioButton todoRadioButton = ViewBindings.findChildViewById(rootView, id);
      if (todoRadioButton == null) {
        break missingId;
      }

      id = R.id.todo_radio_group;
      RadioGroup todoRadioGroup = ViewBindings.findChildViewById(rootView, id);
      if (todoRadioGroup == null) {
        break missingId;
      }

      id = R.id.todo_row_chip;
      Chip todoRowChip = ViewBindings.findChildViewById(rootView, id);
      if (todoRowChip == null) {
        break missingId;
      }

      ConstraintLayout todoRowLayout = (ConstraintLayout) rootView;

      id = R.id.todo_row_todo;
      TextView todoRowTodo = ViewBindings.findChildViewById(rootView, id);
      if (todoRowTodo == null) {
        break missingId;
      }

      return new TodoRowBinding((ConstraintLayout) rootView, todoRadioButton, todoRadioGroup,
          todoRowChip, todoRowLayout, todoRowTodo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
