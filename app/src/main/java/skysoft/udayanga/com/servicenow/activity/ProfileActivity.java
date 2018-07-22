package skysoft.udayanga.com.servicenow.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import skysoft.udayanga.com.servicenow.Dao.FarmerDbHelp;
import skysoft.udayanga.com.servicenow.Dao.UnitBDbHelp;
import skysoft.udayanga.com.servicenow.Dao.UnitFDbHelp;
import skysoft.udayanga.com.servicenow.Dao.UnitSDbHelp;
import skysoft.udayanga.com.servicenow.R;

public class ProfileActivity extends AppCompatActivity {
    String TAG = "Profile Activity";


    Calendar calendar = Calendar.getInstance();
    EditText nameWithInitial, fullName, address, city, profile_dob, dob, email, userName, password, contactNumber;
    EditText latitude, longitude;
    RadioGroup radioSex;
    RadioButton radioMale, radioFemale;
    Button btnAdd;
    Spinner spinnerFid, spinnerBid;

    private View mLayout;
    private static final int PERMISSION_REQUEST_LOCATION = 0;
    String lat, lon;

    final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DATE, date);
            updateDate();
        }
    };
    ProgressDialog progressDialog;
    FarmerDbHelp helper = new FarmerDbHelp(this);
    UnitFDbHelp unitFDbHelp = new UnitFDbHelp(this);
    UnitBDbHelp unitBDbHelp = new UnitBDbHelp(this);
    UnitSDbHelp unitSDbHelp = new UnitSDbHelp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_profile);

        mLayout = findViewById(R.id.main_layout);

        //Set Progressbar
        progressDialog = new ProgressDialog(ProfileActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

//        setLocation();
        fillSpinnerCity();
        fillSpinnerUnitF();
        //Open datePicker dialog
        profile_dob = findViewById(R.id.profile_enrolled_date);
        profile_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ProfileActivity.this, dateSetListener, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Add button click listener
        btnAdd = findViewById(R.id.btn_add_profile);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                addButtonClick();
            }

        });
        spinnerFid = findViewById(R.id.profile_edt_txt_fid);
        spinnerFid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                unitFSpinnerClick(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerBid = findViewById(R.id.profile_edt_txt_bid);
        spinnerBid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                unitBSpinnerClick(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    protected void onResume() {

        super.onResume();
//        setLocation();
    }

    private void addButtonClick() {

//        latitude = findViewById(R.id.profile_edt_txt_lat);
//        longitude = findViewById(R.id.profile_edt_txt_lon);
//        while (latitude.length()>0){
//            progressDialog.setMessage("Searching for GPS Location");
//            progressDialog.show();
//        }

        radioSex = findViewById(R.id.radioSex);
        int selectedId = radioSex.getCheckedRadioButtonId();
//        RadioButton radioButton=findViewById(selectedId);
        Toast.makeText(ProfileActivity.this,
                String.valueOf(selectedId), Toast.LENGTH_SHORT).show();

    }

    private void updateDate() {
        String format = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        profile_dob = findViewById(R.id.profile_enrolled_date);
        profile_dob.setText(simpleDateFormat.format(calendar.getTime()));
    }


    private void setLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new MyLocationListener();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            progressDialog.setMessage("Relax! We are getting your Location");
            progressDialog.show();

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
//            locationManager.removeUpdates(locationListener);
        } else {
            requestLocationPermission();
        }

    }

    public void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            Snackbar.make(mLayout, "Permission Required",
                    Snackbar.LENGTH_INDEFINITE).setAction("Access OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(ProfileActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION);
                }
            }).show();
        } else {
            Snackbar.make(mLayout, "Permission Available",
                    Snackbar.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION);
        }
    }

    public class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
           /* Toast.makeText(getBaseContext()
                    ,
                    "Location changed: Lat: " + location.getLatitude() + " Lng: "
                            + location.getLongitude(), Toast.LENGTH_SHORT).show();*/
            progressDialog.dismiss();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {
        }

        @Override
        public void onProviderDisabled(String s) {

        }

    }

    public void fillSpinnerCity() {
        Spinner spinner = findViewById(R.id.citySpinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, helper.getCityIdList());
        spinner.setAdapter(dataAdapter);
    }

    public void fillSpinnerUnitF() {
        Spinner spinner = findViewById(R.id.profile_edt_txt_fid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, unitFDbHelp.getUnitFIds());
        spinner.setAdapter(arrayAdapter);
    }

    public void fillSpinnerUnitB(int fid) {
        Spinner spinner = findViewById(R.id.profile_edt_txt_bid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, unitBDbHelp.getUnitBIdsByFid(fid));
        spinner.setAdapter(arrayAdapter);
    }

    public void fillSpinnerUnitS(int fid, int bid) {
        Spinner spinner = findViewById(R.id.profile_edt_txt_sid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, unitSDbHelp.getUnitSIdsByFidByBid(fid, bid));
        spinner.setAdapter(arrayAdapter);
    }

    private void unitFSpinnerClick(int position) {
        System.out.println(position);
        fillSpinnerUnitB(position);
    }

    private void unitBSpinnerClick(int position) {
        System.out.println(position);
        spinnerFid = findViewById(R.id.profile_edt_txt_fid);
        int fid = Integer.parseInt(spinnerFid.getSelectedItem().toString());

        fillSpinnerUnitS(position, fid);
    }

}