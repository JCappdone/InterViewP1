package com.example.shriji.interviewp1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amitshekhar.DebugDB;
import com.example.shriji.interviewp1.database.DBOperations;
import com.example.shriji.interviewp1.models.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    public static final String MY_GLOBAL_PREF = "userpref";
    @BindView(R.id.edtName)
    EditText mEdtName;
    @BindView(R.id.edtEmail)
    EditText mEdtEmail;
    @BindView(R.id.edtPassword)
    EditText mEdtPassword;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;
    @BindView(R.id.btnLogout)
    Button mBtnLogout;
    @BindView(R.id.btnRegister)
    Button mBtnRegister;
    private UserModel mModel;
    private DBOperations mDbOperations;
    private String name, email, password;
    private SharedPreferences mPreferences;
    private boolean mIsOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if (getIntent().hasExtra("MODEL")) {
            mModel = getIntent().getExtras().getParcelable("MODEL");
            mEdtName.setText(mModel.getName());
            mEdtEmail.setText(mModel.getEmail());
            mEdtPassword.setText(mModel.getPassword());
        }

        mDbOperations = new DBOperations(this);
        mDbOperations.openDB();

        mPreferences = getSharedPreferences(MY_GLOBAL_PREF, MODE_PRIVATE);

        mIsOnline = mPreferences.getBoolean("isOnline", false);
        if (mIsOnline) {
            openMainActvity();
        }


    }

    private void openMainActvity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick({R.id.btnLogin, R.id.btnLogout, R.id.btnRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                getData();

                break;
            case R.id.btnLogout:
                break;
            case R.id.btnRegister:
                Intent register = new Intent(this, RegisterActivity.class);
                startActivity(register);
                finish();
                break;
        }
    }

    private void getData() {
        name = mEdtName.getText().toString();
        email = mEdtEmail.getText().toString();
        password = mEdtPassword.getText().toString();
        boolean isLogin = mDbOperations.loginUser(name, email, password);
        if (isLogin) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putBoolean("isOnline", true);
            editor.apply();
            openMainActvity();
        } else {
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }
}
