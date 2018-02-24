package project.com.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Kranthi on 2/22/2018.
 */

public class LoginScreen extends AppCompatActivity {

    private EditText loginEmail;
    private EditText loginPassword;
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.loginEmailAddress);
        loginPassword = findViewById(R.id.loginPassword);
        errorText = findViewById(R.id.loginError);
    }

    // OnClick of Register
    public void navigateToRegisterScreen(View view) {
        Intent redirect = new Intent(LoginScreen.this, RegisterScreen.class);
        startActivity(redirect);
    }

    // OnClick of Login
    public void login(View view) {
        // Basic Validations.
        if (!(returnValidationForField(loginEmail) && returnValidationForField(loginPassword))) {
            errorText.setText("Fields cannot be empty");
            errorText.setVisibility(View.VISIBLE);
        } else if (!(loginEmail.getText().toString().equalsIgnoreCase("Kranthi") && loginPassword.getText().toString().equals("krithika"))) {
            errorText.setText("Invalid Credentials, Please try with Valid Ones");
            errorText.setVisibility(View.VISIBLE);
        } else {
            Intent pageRedirect = new Intent(LoginScreen.this, ShoppingScreen.class);
            startActivity(pageRedirect);
        }
    }

    // Common Method for Checking Not Null, StringUtils Empty
    private boolean returnValidationForField(EditText text) {
        if (text != null && StringUtils.isNotBlank(text.getText().toString())) {
            return true;
        }
        return false;
    }

}