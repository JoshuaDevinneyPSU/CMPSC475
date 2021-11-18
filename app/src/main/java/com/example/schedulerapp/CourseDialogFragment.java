package com.example.schedulerapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class CourseDialogFragment extends DialogFragment {
    public interface OnCourseEnteredListener {
        void onCourseEntered(String course, String prof, String start, String end, String loc);
    }

    private OnCourseEnteredListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final EditText courseEditText = new EditText(requireActivity());
        final EditText profEditText = new EditText(requireActivity());
        final EditText startEditText = new EditText(requireActivity());
        final EditText endEditText = new EditText(requireActivity());
        final EditText locEditText = new EditText(requireActivity());

        courseEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        courseEditText.setMaxLines(1);
        courseEditText.setHint("Course Name");

        profEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        profEditText.setMaxLines(1);
        profEditText.setHint("Professor Name");

        startEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        startEditText.setHint("Start Time");
        endEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        endEditText.setHint("End Time");

        locEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        locEditText.setHint("Location");

        LinearLayout layout = new LinearLayout(getContext());

        layout.setOrientation(LinearLayout.VERTICAL);


        layout.addView(courseEditText);
        layout.addView(profEditText);
        layout.addView(startEditText);
        layout.addView(endEditText);
        layout.addView(locEditText);

        return new AlertDialog.Builder(requireActivity())
                .setTitle(R.string.course)
                .setView(layout)
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String course = courseEditText.getText().toString();
                        String prof = profEditText.getText().toString();
                        String start = startEditText.getText().toString();
                        String end = endEditText.getText().toString();
                        String loc = locEditText.getText().toString();

                        mListener.onCourseEntered(course.trim(), prof.trim(), start.trim(), end.trim(), loc.trim());
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (OnCourseEnteredListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
