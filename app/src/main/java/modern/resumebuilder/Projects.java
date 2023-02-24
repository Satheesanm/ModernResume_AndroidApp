package modern.resumebuilder;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Projects extends AppCompatActivity {

    SQLiteDatabase db;
    EditText title,desc;
    Button insertProject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Intent intent = getIntent();

        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        title = (EditText) findViewById(R.id.et1);
        desc= (EditText) findViewById(R.id.et2);

        insertProject = (Button) findViewById(R.id.b1);

        insertProject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE PersonalDet7 SET PrjctTitle ='"+ title.getText()+"', PrjctDes='"+ desc.getText()+"' WHERE Name ='"+PersonalInfo.Username.getText().toString()+"'");
                    Toast.makeText(Projects.this, "Data saved sucessfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Projects.this, "Data not saved!", Toast.LENGTH_LONG).show();
                }


            }
        });

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
                startActivity(new Intent(Projects.this, CreateResumePage.class));
            }

            case R.id.logout:
            {
                startActivity(new Intent(Projects.this, Login.class));
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
