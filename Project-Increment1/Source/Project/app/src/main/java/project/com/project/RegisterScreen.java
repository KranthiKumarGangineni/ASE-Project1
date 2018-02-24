package project.com.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Created by gangi on 2/23/2018.
 */

public class RegisterScreen extends AppCompatActivity {

    private EditText registerFirstName;
    private EditText registerLastName;
    private EditText registerEmail;
    private EditText registerPassword;
    private EditText registerConfirmPassword;
    private TextView displayText;

    private static final String EMAIL_PATTERN = "^(.+)@(.+)$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registerFirstName = findViewById(R.id.registerFirstName);
        registerLastName = findViewById(R.id.registerLastName);
        registerEmail = findViewById(R.id.registerEmailAddress);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmPassword = findViewById(R.id.registerConfirmPassword);
        displayText = findViewById(R.id.displayText);
    }

    // On SignUp Click
    public void registerUser(View view) {
        // Do Basic Validations.
        System.out.println(registerFirstName.getText().toString() + "," + registerLastName.getText().toString() + "," +
                registerEmail.getText().toString() + "," + registerPassword.getText().toString() + "," +
                registerConfirmPassword.getText().toString());
        if (!(returnValidationForField(registerFirstName)
                && returnValidationForField(registerLastName)
                && returnValidationForField(registerEmail)
                && returnValidationForField(registerPassword)
                && returnValidationForField(registerConfirmPassword))) {
            displayText.setText("Please fill all the fields,Fields cannot be empty");
            displayText.setVisibility(View.VISIBLE);
        } else if (!registerPassword.getText().toString().equals(registerConfirmPassword.getText().toString())) {
            displayText.setText("Password & Confirm passwords should match");
            displayText.setVisibility(View.VISIBLE);
        } else if (!Pattern.matches(EMAIL_PATTERN, registerEmail.getText().toString())) {
            displayText.setText("Please enter Valid Email,Ex: Kranthi@gmail.com");
            displayText.setVisibility(View.VISIBLE);
        } else {
            // Setting Successful Message
            displayText.setText("You '" + registerEmail.getText().toString() + "' have successfully signed up, LOGIN to continue");
            displayText.setVisibility(View.VISIBLE);
        }
    }

    // Common Method for Checking Not Null, StringUtils Empty
    private boolean returnValidationForField(EditText text) {
        if (text != null && StringUtils.isNotBlank(text.getText().toString())) {
            return true;
        }
        return false;
    }

    // OnLogin Click
    public void loginRedirect(View view) {
        Intent loginRedirect = new Intent(RegisterScreen.this, LoginScreen.class);
        startActivity(loginRedirect);
    }

    // Reset Button Click
    public void reset(View view){
        registerFirstName.setText("");
        registerLastName.setText("");
        registerEmail.setText("");
        registerPassword.setText("");
        registerConfirmPassword.setText("");
	displayText.setText("");
        displayText.setVisibility(View.INVISIBLE);
    }
}
