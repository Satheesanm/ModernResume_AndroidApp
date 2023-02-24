package modern.resumebuilder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText edit_email;
    EditText edit_password;
    ImageButton btn_loginscreen;
    TextView linkNewReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_email = findViewById(R.id.editLoginEmailAddress);
        edit_password = findViewById(R.id.editLoginTextPassword);
        btn_loginscreen = findViewById(R.id.loginImage);
        linkNewReq = findViewById(R.id.registerlink);

        SharedPreferences sharedPref = getSharedPreferences("myPrefe", MODE_PRIVATE);

        btn_loginscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String email = sharedPref.getString("email", null);
                    String pass = sharedPref.getString("pass", null);
                    if (email.equals(edit_email.getText().toString()) && pass.equals(edit_password.getText().toString())) {
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this, CreateResumePage.class);
                        i.putExtra("email", edit_email.getText().toString());
                        startActivity(i);
                    } else {
                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(Login.this, "No Records Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        linkNewReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Signup.class));
            }
        });
    }
}
