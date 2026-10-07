package com.instagram.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText emailInput, passwordInput;
    private Button loginButton, facebookLoginButton;
    private TextView forgotPassword, signUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        facebookLoginButton = findViewById(R.id.facebookLoginButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        signUpText = findViewById(R.id.signUpText);

        // Disable login button initially
        loginButton.setEnabled(false);
        loginButton.setAlpha(0.5f);

        // Add text watchers to enable/disable login button
        addTextWatchers();

        // Set click listeners
        setClickListeners();
    }

    private void addTextWatchers() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateLoginButtonState();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        emailInput.addTextChangedListener(textWatcher);
        passwordInput.addTextChangedListener(textWatcher);
    }

    private void updateLoginButtonState() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        boolean isEmailValid = !email.isEmpty();
        boolean isPasswordValid = password.length() >= 6;

        if (isEmailValid && isPasswordValid) {
            loginButton.setEnabled(true);
            loginButton.setAlpha(1.0f);
        } else {
            loginButton.setEnabled(false);
            loginButton.setAlpha(0.5f);
        }
    }

    private void setClickListeners() {
        loginButton.setOnClickListener(v -> handleLogin());
        facebookLoginButton.setOnClickListener(v -> handleFacebookLogin());
        forgotPassword.setOnClickListener(v -> handleForgotPassword());
        signUpText.setOnClickListener(v -> handleSignUp());
    }

    private void handleLogin() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (validateInput(email, password)) {
            Toast.makeText(this, "Login attempt: " + email, Toast.LENGTH_SHORT).show();
            // Here you can add actual login logic
        }
    }

    private void handleFacebookLogin() {
        Toast.makeText(this, "Facebook login clicked", Toast.LENGTH_SHORT).show();
        // Here you can add Facebook login logic
    }

    private void handleForgotPassword() {
        Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
        // Here you can navigate to forgot password screen
    }

    private void handleSignUp() {
        Toast.makeText(this, "Sign up clicked", Toast.LENGTH_SHORT).show();
        // Here you can navigate to sign up screen
    }

    private boolean validateInput(String email, String password) {
        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter email or username", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
