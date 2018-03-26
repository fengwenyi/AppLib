package com.fengwenyi.app.applib.dialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.fengwenyi.app.applib.R;
import com.fengwenyi.app.applib.tool.Utils;

/**
 * @author Wenyi Feng
 */

public class DateTimePickerDialog extends Dialog {

    public DateTimePickerDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    class Builder {

        Context context;
        IDateTimeListener listener;
        TextView vDateValue, vTimeValue;
        Button btnCancel, btnConfim, btnDate, btnTime;

        int setYear = 0;
        int setMonth = 0;
        int setDay = 0;
        int setHour = 0;
        int setMinute = 0;

        public Builder (Context context, IDateTimeListener listener) {
            this.context = context;
            this.listener = listener;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public DateTimePickerDialog create () {

            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final DateTimePickerDialog dialog = new DateTimePickerDialog(context, R.style.DialogDateTime);

            View layout = inflater.inflate(R.layout.dialog_date_time_picker, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                    ActionBar.LayoutParams.WRAP_CONTENT));

            vDateValue = findViewById(R.id.dialogDateTimePickerTVDateValue);
            vTimeValue = findViewById(R.id.dialogDateTimePickerTVTimeValue);
            btnCancel = findViewById(R.id.dialogDateTimePickerBtnCancel);
            btnConfim = findViewById(R.id.dialogDateTimePickerBtnConfirm);

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            btnConfim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.getValue(setYear, setMonth, setDay, setHour, setMinute);
                    dialog.dismiss();
                }
            });

            Calendar calendar = Calendar.getInstance();
            final int currYear = calendar.get(Calendar.YEAR);
            final int currMonth = calendar.get(Calendar.MONTH);
            final int currDay = calendar.get(Calendar.DAY_OF_MONTH);
            final int currHour = calendar.get(Calendar.HOUR_OF_DAY);
            final int currMinute = calendar.get(Calendar.MINUTE);

            setDateValue(currYear, currMonth, currDay);
            setTimeValue(currHour, currMinute);

            btnDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new DatePickerDialog(context,
                            android.R.style.Theme_DeviceDefault_Light_Dialog_Alert,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                    setDateValue(year, month, day);

                                    setYear = year;
                                    setMonth = month + 1;
                                    setDay = day;
                                }
                            }, currYear, currMonth, currDay).show();
                }
            });

            btnTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new TimePickerDialog(context,
                            android.R.style.Theme_DeviceDefault_Light_Dialog_Alert,
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                    setTimeValue(hour, minute);

                                    setHour = hour;
                                    setMinute = minute;
                                }
                            }, currHour, currMinute, true).show();
                }
            });

            return dialog;
        }

        @SuppressLint("SetTextI18n")
        private void setDateValue (int year, int month, int day) {
            vDateValue.setText(year + "年 " +
                    Utils.repair0(month + 1) + "月 " +
                    Utils.repair0(day) + "日");
        }

        @SuppressLint("SetTextI18n")
        private void setTimeValue (int hour, int minute) {
            vTimeValue.setText(Utils.repair0(hour)
                    + " : " + Utils.repair0(minute));
        }

    }

    interface IDateTimeListener {
        void getValue (int year, int month, int day, int hour, int minute);
    }
}
