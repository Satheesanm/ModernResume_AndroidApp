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
import android.widget.TextView;
import android.widget.Toast;



public class TechnicalSkills extends AppCompatActivity {

    SQLiteDatabase db;

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    String techSkills = "";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_skills);
        Intent intent = getIntent();

        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();

            }
        });

        b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });
        b9 = (Button) findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });
        b10 = (Button) findViewById(R.id.b10);
        b10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });
        b11 = (Button) findViewById(R.id.b11);
        b11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });
        b12 = (Button) findViewById(R.id.b12);
        b12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

    }

    public void insertSkills() {

        if(count == 4) {
            Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE PersonalDet7 SET TechSkills ='"+ techSkills +"' WHERE Name ='"+PersonalInfo.Username.getText().toString()+"'");
                Toast.makeText(TechnicalSkills.this, "Your skill set is saved successfully!", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(TechnicalSkills.this, "You can add only 4 skills! Please try again incase you want to change your skill set!", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(TechnicalSkills.this, "Selected skill added succesfully!", Toast.LENGTH_LONG).show();
        }

        if(count > 4) {
            Toast.makeText(TechnicalSkills.this, "You can add only 4 skills! Please try again incase you want to change your skill set!", Toast.LENGTH_LONG).show();
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
                startActivity(new Intent(TechnicalSkills.this, CreateResumePage.class));
            }

            case R.id.logout:
            {
                startActivity(new Intent(TechnicalSkills.this, Login.class));
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
