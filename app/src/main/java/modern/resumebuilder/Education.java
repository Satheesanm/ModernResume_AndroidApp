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
import android.widget.Toast;

public class Education extends AppCompatActivity {

    SQLiteDatabase db;
    EditText nameDegree,institute,score,yop;
    Button insertEdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        Intent intent = getIntent();

        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        nameDegree = (EditText) findViewById(R.id.et1);
        institute = (EditText) findViewById(R.id.et2);
        score = (EditText) findViewById(R.id.et3);
        yop = (EditText) findViewById(R.id.et4);

        insertEdu = (Button) findViewById(R.id.b1);

        insertEdu.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View view) {
                String username = PersonalInfo.Username.getText().toString();
                try (Cursor c = db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name = ?", new String[]{username})) {
                    if (c.moveToFirst()) {
                        db.execSQL("UPDATE PersonalDet7 SET Course = ?, Institute = ?, Score = ?, Yop = ? WHERE Name = ?", new String[]{nameDegree.getText().toString(), institute.getText().toString(), score.getText().toString(), yop.getText().toString(), username});
                        Toast.makeText(Education.this, "Data saved successfully!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Education.this, "Data not saved!", Toast.LENGTH_LONG).show();
                    }
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
                startActivity(new Intent(Education.this, CreateResumePage.class));
            }

            case R.id.logout:
            {
                startActivity(new Intent(Education.this, Login.class));
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
