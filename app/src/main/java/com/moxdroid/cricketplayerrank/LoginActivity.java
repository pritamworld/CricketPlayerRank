package com.moxdroid.cricketplayerrank;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity
{
    private static final String TAG = LoginActivity.class.getName();

    private EditText _emailText;
    private EditText _passwordText;
    private Button _loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _emailText = (EditText) findViewById(R.id.input_email);
        _passwordText = (EditText) findViewById(R.id.input_password);
        _loginButton = (Button) findViewById(R.id.btn_login);


        _loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                login();
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        // disable going back to the ListPlayerActivity
        moveTaskToBack(true);
    }

    private void login()
    {
        Log.d(TAG, "Login");

        if (!validate())
        {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable()
                {
                    public void run()
                    {
                        if (email.equals("pritesh@gmail.com") && password.equals("pritesh"))
                        {
                            progressDialog.hide();
                            onLoginSuccess();
                        }

                    }
                }, 3000);
    }

    private void onLoginSuccess()
    {
        _loginButton.setEnabled(true);
        Intent mIntent = new Intent(LoginActivity.this, ListPlayerActivity.class);
        startActivity(mIntent);
        finish();
    }

    private void onLoginFailed()
    {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    private boolean validate()
    {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            _emailText.setError("Enter a valid email address");
            valid = false;
        } else
        {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10)
        {
            _passwordText.setError("Between 4 and 10 alphanumeric characters");
            valid = false;
        } else
        {
            _passwordText.setError(null);
        }

        return valid;
    }
}
