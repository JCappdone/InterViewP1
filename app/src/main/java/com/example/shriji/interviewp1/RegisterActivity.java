package com.example.shriji.interviewp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shriji.interviewp1.database.DBOperations;
import com.example.shriji.interviewp1.models.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edtName)
    EditText mEdtName;
    @BindView(R.id.edtEmail)
    EditText mEdtEmail;
    @BindView(R.id.edtPassword)
    EditText mEdtPassword;
    @BindView(R.id.btnRegister)
    Button mBtnRegister;
    @BindView(R.id.btnCancel)
    Button mBtnCancel;
    private DBOperations mDbOperations;
    private UserModel mModel;
    private String name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mDbOperations = new DBOperations(this);
        mDbOperations.openDB();

    }

    private void getData() {

        name = mEdtName.getText().toString();
        email = mEdtEmail.getText().toString();
        password = mEdtPassword.getText().toString();
    }

    @OnClick({R.id.btnRegister, R.id.btnCancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnRegister:
                getData();
                mModel = new UserModel(name,email,password);
                long userCount = mDbOperations.insertUsers(mModel);
                if(userCount == -1){
                    Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this,LoginActivity.class);
                    intent.putExtra("MODEL",mModel);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.btnCancel:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
