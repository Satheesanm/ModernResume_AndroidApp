package modern.resumebuilder;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Objective extends AppCompatActivity implements View.OnClickListener{

    SQLiteDatabase db;
    EditText name,add,mail,phone,dob;
    Button insert,view;
    TextView tv3 ;
    TextView tv4 ;
    TextView tv5;
    TextView tv6;
    CharSequence myObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective);
        Intent intent = getIntent();

        db=openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);

        insert = (Button) findViewById(R.id.b1);
       //view = (Button) findViewById(R.id.b2);

        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        insert.setOnClickListener(this);
        //view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {

            case R.id.tv3:
                tv3.setVisibility(View.GONE);
                tv4.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.GONE);
                tv6.setVisibility(View.GONE);
                myObj = tv4.getText();
                break;

            case R.id.tv4:
                tv5.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.GONE);
                tv3.setVisibility(View.GONE);
                tv6.setVisibility(View.GONE);
                myObj = tv5.getText();
                break;

            case R.id.tv5:
                tv6.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.GONE);
                tv4.setVisibility(View.GONE);
                tv5.setVisibility(View.GONE);
                myObj = tv6.getText();
                break;

            case R.id.tv6:
                tv3.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.GONE);
                tv4.setVisibility(View.GONE);
                tv6.setVisibility(View.GONE);
                myObj = tv3.getText();
                break;

            case R.id.b1:
                Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE PersonalDet7 SET Obj ='"+ myObj.toString()+"' WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'");
                    Toast.makeText(Objective.this, "Data saved sucessfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Objective.this, "Data not saved!", Toast.LENGTH_LONG).show();
                }
                break;


        }
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
                startActivity(new Intent(Objective.this, CreateResumePage.class));
            }

            case R.id.logout:
            {
                startActivity(new Intent(Objective.this, Login.class));
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}





