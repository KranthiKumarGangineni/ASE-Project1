package project.com.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by gangi on 2/23/2018.
 */

public class ShoppingScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
    }

    // OnLogout Click
    public void logout(View v) {
        // Redirecting to Login Screen on logout
        Intent loginRedirect = new Intent(ShoppingScreen.this, LoginScreen.class);
        startActivity(loginRedirect);
    }
}
