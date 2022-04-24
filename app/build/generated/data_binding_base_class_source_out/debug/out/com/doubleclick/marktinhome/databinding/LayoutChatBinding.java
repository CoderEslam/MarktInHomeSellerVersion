// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devlomi.record_view.RecordButton;
import com.devlomi.record_view.RecordView;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutChatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView attachFile;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ImageView emotion;

  @NonNull
  public final EditText etTextMessage;

  @NonNull
  public final ConstraintLayout layoutText;

  @NonNull
  public final RecordView recordView;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RecordButton sendRecord;

  @NonNull
  public final ImageView sendText;

  private LayoutChatBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView attachFile,
      @NonNull ConstraintLayout constraintLayout, @NonNull ImageView emotion,
      @NonNull EditText etTextMessage, @NonNull ConstraintLayout layoutText,
      @NonNull RecordView recordView, @NonNull RelativeLayout relativeLayout,
      @NonNull RecordButton sendRecord, @NonNull ImageView sendText) {
    this.rootView = rootView;
    this.attachFile = attachFile;
    this.constraintLayout = constraintLayout;
    this.emotion = emotion;
    this.etTextMessage = etTextMessage;
    this.layoutText = layoutText;
    this.recordView = recordView;
    this.relativeLayout = relativeLayout;
    this.sendRecord = sendRecord;
    this.sendText = sendText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.attach_file;
      ImageView attachFile = ViewBindings.findChildViewById(rootView, id);
      if (attachFile == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.emotion;
      ImageView emotion = ViewBindings.findChildViewById(rootView, id);
      if (emotion == null) {
        break missingId;
      }

      id = R.id.et_text_message;
      EditText etTextMessage = ViewBindings.findChildViewById(rootView, id);
      if (etTextMessage == null) {
        break missingId;
      }

      id = R.id.layout_text;
      ConstraintLayout layoutText = ViewBindings.findChildViewById(rootView, id);
      if (layoutText == null) {
        break missingId;
      }

      id = R.id.recordView;
      RecordView recordView = ViewBindings.findChildViewById(rootView, id);
      if (recordView == null) {
        break missingId;
      }

      id = R.id.relativeLayout;
      RelativeLayout relativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (relativeLayout == null) {
        break missingId;
      }

      id = R.id.sendRecord;
      RecordButton sendRecord = ViewBindings.findChildViewById(rootView, id);
      if (sendRecord == null) {
        break missingId;
      }

      id = R.id.sendText;
      ImageView sendText = ViewBindings.findChildViewById(rootView, id);
      if (sendText == null) {
        break missingId;
      }

      return new LayoutChatBinding((ConstraintLayout) rootView, attachFile, constraintLayout,
          emotion, etTextMessage, layoutText, recordView, relativeLayout, sendRecord, sendText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
