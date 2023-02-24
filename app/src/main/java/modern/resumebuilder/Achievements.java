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

public class Achievements extends AppCompatActivity {

    SQLiteDatabase db;
    EditText achievements,awards;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        Intent intent = getIntent();

        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        achievements = findViewById(R.id.et1);
        awards = findViewById(R.id.et2);

        insert = findViewById(R.id.b1);

        insert.setOnClickListener(view -> {
            Cursor c = db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='" + PersonalInfo.Username.getText().toString() + "'", null);
            String message;
            if (c.moveToFirst()) {
                db.execSQL("UPDATE PersonalDet7 SET Achievement ='" + achievements.getText() + "', Award='" + awards.getText() + "' WHERE Name ='" + PersonalInfo.Username.getText().toString() + "'");
                message = "Data saved sucessfully!";
            } else {
                message = "Data not saved!";
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
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
                startActivity(new Intent(Achievements.this, CreateResumePage.class));
                return true;
            }

            case R.id.logout:
            {
                startActivity(new Intent(Achievements.this, Login.class));
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
