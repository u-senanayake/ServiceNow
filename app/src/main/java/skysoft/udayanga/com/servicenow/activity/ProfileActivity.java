package skysoft.udayanga.com.servicenow.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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

import skysoft.udayanga.com.servicenow.Dao.CreateDbHelp;
import skysoft.udayanga.com.servicenow.Dao.FarmerDbHelp;
import skysoft.udayanga.com.servicenow.Dao.UnitBDbHelp;
import skysoft.udayanga.com.servicenow.Dao.UnitFDbHelp;
import skysoft.udayanga.com.servicenow.Dao.UnitSDbHelp;
import skysoft.udayanga.com.servicenow.R;
import skysoft.udayanga.com.servicenow.model.Farmer;

public class ProfileActivity extends AppCompatActivity {
    String TAG = "Profile Activity";
    private static final String keyFarmerId = "farmer_ID",
            keyFarmerCode = "famer_code",
            keyNameWithIni = "name_wt_initials",
            keyFullName = "full_name",
            keyFullNameLan1 = "full_name_lan1",
            keyAddress = "address",
            keyAddressLan1 = "address_lan1",
            keyCityId = "cityID",
            keyGender = "gender",
            keyEnrolledDate = "enrolled_date",
            keyNicOrPassport = "nic_or_passport_no",
            keyPhoneHome = "phone_home",
            keyPhoneMobile = "phone_mobile",
            keyRiskStatus = "risk_status",
            keyActive = "active",
            keyPerchaseActive = "perchaseActive",
            keyUser = "user",
            keyImage = "image",
            keyFid = "fid",
            keyBid = "bid",
            keySid = "sid",
            keyFairtradeStatus = "fairtrade_status",
            keyRemark = "Remrks",
            keySanctioned = "sanctioned",
            keySanctionedType = "sanctioned_type",
            keySanctionedRemarks = "sanctioned_remarks",
            keySanctionedDate = "sanctioned_date",
            keySanctionedBy = "sanctioned_by",
            keySanctionedAudit = "sanctioned_Audit",
            keyLock = "lock";

    Calendar calendar = Calendar.getInstance();
    EditText editNameWithInitial, editFullName, editFullNameLan, editAddress, editAddressLan1, editEnrolledDate, editNicOrPassport,
            editContactHome, editContactMobile, editRemark;
    RadioGroup radioSex, fairtradeStatus;
    RadioButton radioMale, radioFemale;
    Button btnAdd;
    Spinner spinnerFid, spinnerBid, spinnerSid, spinnerCityId, spinnerRiskStatus;

    private View mLayout;
    private static final int PERMISSION_REQUEST_LOCATION = 0;

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
    CreateDbHelp helper = new CreateDbHelp(this);
    UnitFDbHelp unitFDbHelp = new UnitFDbHelp(this);
    UnitBDbHelp unitBDbHelp = new UnitBDbHelp(this);
    UnitSDbHelp unitSDbHelp = new UnitSDbHelp(this);
    FarmerDbHelp farmerDbHelp = new FarmerDbHelp(this);


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
        fillVallues();
        //Open datePicker dialog
        editEnrolledDate = findViewById(R.id.profile_enrolled_date);
        editEnrolledDate.setOnClickListener(new View.OnClickListener() {
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

        String imgUrl, nameWithIni, fullName, nameLang1, address, addresLan1, gender,
                enrolledDate, nicNum, contactNum1, contactNum2, risck, fairetradeStatus, remark;
        double farmerId;
        String farmerCode, userName, sanType, sanRemark, sanDate, sanBy, sanAudit;
        int active, purchaseActive, sanctioned, lock, city, fidCode, sidCode, bidCode;

        editNameWithInitial = findViewById(R.id.profile_edt_txt_name_ini);
        editFullName = findViewById(R.id.profile_edt_txt_name);
        editFullNameLan = findViewById(R.id.profile_full_name_lan1);
        editAddress = findViewById(R.id.profile_edt_txt_address);
        editAddressLan1 = findViewById(R.id.profile_edt_address_lan1);
        spinnerCityId = findViewById(R.id.citySpinner);
        editEnrolledDate = findViewById(R.id.profile_enrolled_date);
        editNicOrPassport = findViewById(R.id.profile_nic_passport);
        editContactHome = findViewById(R.id.profile_edt_txt_contact_home);
        editContactMobile = findViewById(R.id.profile_edt_txt_contact_mobile);
        spinnerRiskStatus = findViewById(R.id.profile_edit_risk_status);
        spinnerFid = findViewById(R.id.profile_edt_txt_fid);
        spinnerBid = findViewById(R.id.profile_edt_txt_bid);
        spinnerSid = findViewById(R.id.profile_edt_txt_sid);
        editRemark = findViewById(R.id.profile_edt_txt_remark);


        nameWithIni = editNameWithInitial.getText().toString();
        fullName = editFullName.getText().toString();
        nameLang1 = editFullNameLan.getText().toString();
        address = editAddress.getText().toString();
        addresLan1 = editAddressLan1.getText().toString();
        city = Integer.parseInt(spinnerCityId.getSelectedItem().toString());
        gender = "m";
        enrolledDate = editEnrolledDate.getText().toString();
        nicNum = editNicOrPassport.getText().toString();
        contactNum1 = editContactHome.getText().toString();
        contactNum2 = editContactMobile.getText().toString();
        risck = "test";
//                spinnerRiskStatus.getSelectedItem().toString();
        userName = "Udayanga";
        imgUrl = "Image";
        fidCode = Integer.parseInt(spinnerFid.getSelectedItem().toString());
        bidCode = Integer.parseInt(spinnerBid.getSelectedItem().toString());
        sidCode = Integer.parseInt(spinnerSid.getSelectedItem().toString());
        fairetradeStatus = "null";
        remark = editRemark.getText().toString();

        farmerDbHelp.addFarmer(new Farmer(nameWithIni, fullName, nameLang1, address, addresLan1, city, gender,
                enrolledDate, nicNum, contactNum1, contactNum2, risck, userName, imgUrl, fidCode, bidCode, sidCode, fairetradeStatus, remark));
        progressDialog.dismiss();
        Toast.makeText(this, "Farmer Adding Success", Toast.LENGTH_LONG).show();
    }

    private void updateDate() {
        String format = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        editEnrolledDate = findViewById(R.id.profile_enrolled_date);
        editEnrolledDate.setText(simpleDateFormat.format(calendar.getTime()));
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
        spinnerCityId = findViewById(R.id.citySpinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, helper.getCityIdList());
        spinnerCityId.setAdapter(dataAdapter);
    }

    public void fillSpinnerUnitF() {
        spinnerFid = findViewById(R.id.profile_edt_txt_fid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, unitFDbHelp.getUnitFIds());
        spinnerFid.setAdapter(arrayAdapter);
    }

    public void fillSpinnerUnitB(int fid) {
        spinnerBid = findViewById(R.id.profile_edt_txt_bid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, unitBDbHelp.getUnitBIdsByFid(fid));
        spinnerBid.setAdapter(arrayAdapter);
    }

    public void fillSpinnerUnitS(int fid, int bid) {
        spinnerSid = findViewById(R.id.profile_edt_txt_sid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, unitSDbHelp.getUnitSIdsByFidByBid(fid, bid));
        spinnerSid.setAdapter(arrayAdapter);
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

    private void fillVallues() {
        Intent intent = getIntent();
        editNameWithInitial = findViewById(R.id.profile_edt_txt_name_ini);
        editFullName = findViewById(R.id.profile_edt_txt_name);
        editFullNameLan = findViewById(R.id.profile_full_name_lan1);
        editAddress = findViewById(R.id.profile_edt_txt_address);
        editAddressLan1 = findViewById(R.id.profile_edt_address_lan1);

        spinnerCityId = findViewById(R.id.citySpinner);

        radioSex = findViewById(R.id.radioSex);

        editEnrolledDate = findViewById(R.id.profile_enrolled_date);
        editNicOrPassport = findViewById(R.id.profile_nic_passport);
        editContactHome = findViewById(R.id.profile_edt_txt_contact_home);
        editContactMobile = findViewById(R.id.profile_edt_txt_contact_mobile);

        spinnerRiskStatus = findViewById(R.id.profile_edit_risk_status);
        spinnerFid = findViewById(R.id.profile_edt_txt_fid);
        spinnerSid = findViewById(R.id.profile_edt_txt_sid);
        spinnerBid = findViewById(R.id.profile_edt_txt_bid);

        fairtradeStatus = findViewById(R.id.fairtrade_status);

        editRemark = findViewById(R.id.profile_edt_txt_remark);
////////////////////////////////////////////////////////////////////////
        editNameWithInitial.setText(intent.getStringExtra(keyNameWithIni));
        editFullName.setText(intent.getStringExtra(keyFullName));
        editFullNameLan.setText(intent.getStringExtra(keyFullNameLan1));
        editAddress.setText(intent.getStringExtra(keyAddress));
        editAddressLan1.setText(intent.getStringExtra(keyAddressLan1));

        spinnerCityId.setSelection(intent.getIntExtra(keyCityId, 0));
        if (intent.getStringExtra(keyGender).equals("f")) {
            radioSex.check(R.id.radioFemale);
        } else if (intent.getStringExtra(keyGender).equals("m")) {
            radioSex.check(R.id.radioMale);
        }
        editEnrolledDate.setText(intent.getStringExtra(keyEnrolledDate));
        editNicOrPassport.setText(intent.getStringExtra(keyNicOrPassport));
        editContactHome.setText(intent.getStringExtra(keyPhoneHome));
        editContactMobile.setText(intent.getStringExtra(keyPhoneMobile));
//        editFullName.setText(intent.getStringExtra(keyFullName));//todo risk status
        spinnerFid.setSelection(intent.getIntExtra(keyFid, 0));
        spinnerBid.setSelection(intent.getIntExtra(keyBid, 0));
        spinnerSid.setSelection(intent.getIntExtra(keySid, 0));
//        editFullName.setText(intent.getStringExtra(keyFullName));//todo fairetrade status
        editRemark.setText(intent.getStringExtra(keyRemark));

    }
}