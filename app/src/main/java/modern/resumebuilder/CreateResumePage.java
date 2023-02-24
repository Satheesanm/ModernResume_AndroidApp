package modern.resumebuilder;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CreateResumePage extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_resume_page);
        Intent intent = getIntent();

        setupButton(R.id.b1, PersonalInfo.class);
        setupButton(R.id.b2, Education.class);
        setupButton(R.id.b3, TechnicalSkills.class);
        setupButton(R.id.b4, Interests.class);
        setupButton(R.id.b5, Projects.class);
        setupButton(R.id.b6, Achievements.class);
        setupButton(R.id.b7, Objective.class);
        setupButton(R.id.b8, References.class);
        setupButton(R.id.b9, GenerateResumePage.class);
    }

    private void setupButton(int buttonId, final Class<?> cls) { Button button = findViewById(buttonId);setActivityOnClick(button, cls);}


    private void setActivityOnClick(Button button, Class<?> cls) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), cls);
            startActivity(intent);
        });
    }

}
