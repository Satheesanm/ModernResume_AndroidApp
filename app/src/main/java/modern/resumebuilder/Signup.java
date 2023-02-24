package modern.resumebuilder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.text.TextUtils;

public class Signup extends AppCompatActivity {

    EditText edit_fname;
    EditText edit_lname;
    EditText edit_email;
    EditText edit_pass;
    EditText edit_pass_confo;
    ImageButton btn_Signup;
    TextView alreadysignInLink;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        SharedPreferences sharedPref = getSharedPreferences("myPrefe", MODE_PRIVATE);
        edit_fname = findViewById(R.id.editTextFirstName);
        edit_lname = findViewById(R.id.editTextLastName);
        edit_email = findViewById(R.id.editTextEmailAddress);
        edit_pass = findViewById(R.id.editTextPassword);
        btn_Signup = findViewById(R.id.registerBtn);
        edit_pass_confo = findViewById(R.id.editTextCofirmPassword);
        alreadysignInLink = findViewById(R.id.alreadysignInLink);

        btn_Signup.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            if (!edit_pass.getText().toString().equals(edit_pass_confo.getText().toString())) {
                Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(edit_fname.getText().toString()) ||
                    TextUtils.isEmpty(edit_lname.getText().toString()) ||
                    TextUtils.isEmpty(edit_email.getText().toString()) ||
                    TextUtils.isEmpty(edit_pass.getText().toString()) ||
                    TextUtils.isEmpty(edit_pass_confo.getText().toString())) {
                Toast.makeText(Signup.this, "All fields required!", Toast.LENGTH_SHORT).show();
            } else {
                editor.putString("fname", edit_fname.getText().toString());
                editor.putString("lname", edit_lname.getText().toString());
                editor.putString("email", edit_email.getText().toString());
                editor.putString("pass", edit_pass.getText().toString());
                editor.apply();
                Toast.makeText(Signup.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Signup.this, MainActivity.class));
            }
        });

        alreadysignInLink.setOnClickListener(v -> {
            startActivity(new Intent(Signup.this, Login.class));
        });
    }
}
