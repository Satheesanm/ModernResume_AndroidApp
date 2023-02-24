package modern.resumebuilder;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalInfo extends AppCompatActivity {

    SQLiteDatabase db;
    EditText name,add,mail,phone,dob;
    Button insert;
    boolean validation = false;
    static EditText Username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        Intent intent = getIntent();

        db=openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS PersonalDet7(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR,Address VARCHAR,Email VARCHAR,PhoneNo INT,Dob VARCHAR,Obj VARCHAR,TechSkills VARCHAR,Course VARCHAR,Institute VARCHAR,Score VARCHAR,Yop VARCHAR,Interests VARCHAR, PrjctTitle VARCHAR,PrjctDes VARCHAR,Achievement VARCHAR,Award VARCHAR,RefName VARCHAR,RefOrg VARCHAR, RefContact VARCHAR);");

        name = (EditText) findViewById(R.id.et1);
        Username = (EditText) findViewById(R.id.et1);
        add = (EditText) findViewById(R.id.et2);
        mail = (EditText) findViewById(R.id.et3);
        phone = (EditText) findViewById(R.id.et4);
        dob = (EditText) findViewById(R.id.et5);

        insert = (Button) findViewById(R.id.b1);

        final String validEmail = mail.getText().toString();
        final String validPhone = phone.getText().toString();


        insert.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view) {
                           if (name.getText().toString().trim().length() == 0 || add.getText().toString().trim().length() == 0 || mail.getText().toString().trim().length() == 0 || phone.getText().toString().trim().length() == 0 || dob.getText().toString().trim().length() == 0) {
                               Toast.makeText(PersonalInfo.this, "Please enter all the values", Toast.LENGTH_LONG).show();
                               return;
                           }
                           db.execSQL("INSERT INTO PersonalDet7(Name,Address,Email,PhoneNo,Dob)VALUES('" + name.getText() + "','" + add.getText() + "','" + mail.getText() + "','" + phone.getText() + "','" + dob.getText() + "');");
                           Toast.makeText(PersonalInfo.this, "Data saved sucessfully!", Toast.LENGTH_LONG).show();


            }
        });


    }

    private boolean ValidEmail(String checkEmail) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(checkEmail);
        return matcher.matches();
    }

    private boolean ValidPhoneLength (String checkPhone) {

        if (checkPhone.length() == 10) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
            {
                startActivity(new Intent(PersonalInfo.this, CreateResumePage.class));
            }

            case R.id.logout:
            {
                startActivity(new Intent(PersonalInfo.this, Login.class));
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
