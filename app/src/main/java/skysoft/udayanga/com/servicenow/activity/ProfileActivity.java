package skysoft.udayanga.com.servicenow.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import skysoft.udayanga.com.servicenow.R;

public class ProfileActivity extends AppCompatActivity {
    Calendar calendar = Calendar.getInstance();
    EditText profile_dob;
    final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DATE, date);
            updateDate();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_profile);


        profile_dob = findViewById(R.id.profile_edt_txt_dob);
        profile_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ProfileActivity.this, dateSetListener, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateDate() {
        String format = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        profile_dob = findViewById(R.id.profile_edt_txt_dob);
        profile_dob.setText(simpleDateFormat.format(calendar.getTime()));
    }
}
