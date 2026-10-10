package com.instagram.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText emailInput;
    private TextInputEditText passwordInput;
    private Button loginButton;
    private Button facebookLoginButton;
    private TextView forgotPassword;
    private TextView signUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        facebookLoginButton = findViewById(R.id.facebookLoginButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        signUpText = findViewById(R.id.signUpText);

        loginButton.setEnabled(false);
        loginButton.setAlpha(0.5f);

        addTextWatchers();
        setClickListeners();
    }

    private void addTextWatchers() {
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateLoginButtonState();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        emailInput.addTextChangedListener(watcher);
        passwordInput.addTextChangedListener(watcher);
    }

    private void updateLoginButtonState() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        boolean validEmail = !email.isEmpty();
        boolean validPassword = password.length() >= 6;

        if (validEmail && validPassword) {
            loginButton.setEnabled(true);
            loginButton.setAlpha(1.0f);
        } else {
            loginButton.setEnabled(false);
            loginButton.setAlpha(0.5f);
        }
    }

    private void setClickListeners() {
        loginButton.setOnClickListener(v -> handleLogin());
        facebookLoginButton.setOnClickListener(v -> Toast.makeText(this, "Login with Facebook clicked", Toast.LENGTH_SHORT).show());
        forgotPassword.setOnClickListener(v -> Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show());
        signUpText.setOnClickListener(v -> Toast.makeText(this, "Sign up clicked", Toast.LENGTH_SHORT).show());
    }

    private void handleLogin() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter email or username", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Login attempt: " + email, Toast.LENGTH_SHORT).show();
    }
}
