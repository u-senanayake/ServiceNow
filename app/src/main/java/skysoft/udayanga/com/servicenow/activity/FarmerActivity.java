package skysoft.udayanga.com.servicenow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import skysoft.udayanga.com.servicenow.Dao.FarmerDbHelp;
import skysoft.udayanga.com.servicenow.R;
import skysoft.udayanga.com.servicenow.model.Farmer;

public class FarmerActivity extends AppCompatActivity {
    String status;
    Button farmer_add;
    Spinner spinnerFarmerList;
    EditText farmerCode;

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

    FarmerDbHelp farmerDbHelp = new FarmerDbHelp(this);
    Farmer farmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        status = bundle.getString("status");
        if (status.equals("add")) {
            ifAddNewFarmer();
        } else if (status.equals("update")) {
            ifUpdateFarmer();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fillFarmerSpinner();

        farmer_add = findViewById(R.id.farmer_btn_detail);
        farmer_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status.equals("add")) {
                    startActivity(new Intent(FarmerActivity.this, ProfileActivity.class));
                } else if (status.equals("update")) {
                    Intent intent = setExtras();
                    startActivity(intent);
                }
            }
        });
    }

    private void fillFarmerSpinner() {
        spinnerFarmerList = findViewById(R.id.spinnerFarmerList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, farmerDbHelp.gteFarmerIds());
        spinnerFarmerList.setAdapter(arrayAdapter);
    }

    private void ifAddNewFarmer() {
        spinnerFarmerList = findViewById(R.id.spinnerFarmerList);
        farmerCode = findViewById(R.id.farmer_code);
        spinnerFarmerList.setEnabled(false);
        farmerCode.setEnabled(false);
    }

    private void ifUpdateFarmer() {
        spinnerFarmerList = findViewById(R.id.spinnerFarmerList);
        spinnerFarmerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getFarmerDataById(i + 1); //TODO change ID
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void getFarmerDataById(int id) {
        farmer = farmerDbHelp.getById(id);
        farmerCode = findViewById(R.id.farmer_code);
        farmerCode.setText(farmer.getFarmerCode());
    }

    private Intent setExtras() {
        Intent intent = new Intent(FarmerActivity.this, ProfileActivity.class);
        intent.putExtra(keyFarmerCode, farmer.getFarmerCode());
        intent.putExtra(keyNameWithIni, farmer.getNameInitial());
        intent.putExtra(keyFullName, farmer.getFullName());
        intent.putExtra(keyFullNameLan1, farmer.getFullNameLan1());
        intent.putExtra(keyAddress, farmer.getAddress());
        intent.putExtra(keyCityId, farmer.getCity());
        intent.putExtra(keyGender, farmer.getGender());
        intent.putExtra(keyEnrolledDate, farmer.getEnrolledDate());
        intent.putExtra(keyNicOrPassport, farmer.getNicOrPassportNo());
        intent.putExtra(keyPhoneHome, farmer.getPhoneHome());
        intent.putExtra(keyPhoneMobile, farmer.getPhoneMobile());
        intent.putExtra(keyRiskStatus, farmer.getRiskStatus());
        intent.putExtra(keyActive, farmer.isActive());
        intent.putExtra(keyPerchaseActive, farmer.isPerchaseActive());
        intent.putExtra(keyUser, farmer.getUser());
        intent.putExtra(keyImage, farmer.getImgUrl());
        intent.putExtra(keyFid, farmer.getFid());
        intent.putExtra(keyBid, farmer.getBid());
        intent.putExtra(keySid, farmer.getSid());
        intent.putExtra(keyFairtradeStatus, farmer.isFairtradeStatus());
        intent.putExtra(keyRemark, farmer.getRemark());
        intent.putExtra(keySanctioned, farmer.isSectioned());
        intent.putExtra(keySanctionedType, farmer.getSectionedType());
        intent.putExtra(keySanctionedRemarks, farmer.getSectionedRemark());
        intent.putExtra(keySanctionedDate, farmer.getSectionedDate());
        intent.putExtra(keySanctionedAudit, farmer.getSectionedAudit());
        intent.putExtra(keyLock, farmer.isLocked());

        return intent;
    }
}
