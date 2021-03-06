package me.aprizal.myalarmmanager;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    DialogTimeListener mliListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mliListener = (DialogTimeListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mliListener !=null){
            mliListener = null;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        boolean formatHour24 = true;
        return new TimePickerDialog(getActivity(), this, hour, minute, formatHour24);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mliListener.onDialogTime(getTag(), hourOfDay, minute);
    }

    public interface DialogTimeListener {
        void onDialogTime(String tag, int hourOfDay, int minute);
    }
}
