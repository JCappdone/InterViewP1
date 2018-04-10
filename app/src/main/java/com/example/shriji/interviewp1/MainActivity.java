package com.example.shriji.interviewp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.shriji.interviewp1.models.SiteModel;
import com.example.shriji.interviewp1.models.UrlModel;
import com.example.shriji.interviewp1.models.UserModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.shriji.interviewp1.LoginActivity.MY_GLOBAL_PREF;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnLogout)
    Button mBtnLogout;
    private WebServices mWebServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mWebServices = WebServices.retrofit.create(WebServices.class);
        Call<SiteModel> model = mWebServices.model();
        model.enqueue(new Callback<SiteModel>() {
            @Override
            public void onResponse(Call<SiteModel> call, Response<SiteModel> response) {
                SiteModel model1 = response.body();
                Log.d("", "onResponse:----------------- "+model1.getUrlModels().size());
                showCustomDialog(model1.getUrlModels());
            }

            @Override
            public void onFailure(Call<SiteModel> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @OnClick(R.id.btnLogout)
    public void onViewClicked() {

        SharedPreferences.Editor editor = getSharedPreferences(MY_GLOBAL_PREF, MODE_PRIVATE).edit();
        editor.remove("isOnline");
        editor.apply();
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
        finish();
    }

    private void showCustomDialog(List<UrlModel> urlModels) {
   /*     CustomDialogFragment customDialog = new CustomDialogFragment(urlModels);
        customDialog.show(getSupportFragmentManager(), "CustomDialogFragment");
   */

        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
     /*   final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Hardik");
        arrayAdapter.add("Archit");
        arrayAdapter.add("Jignesh");
        arrayAdapter.add("Umang");
        arrayAdapter.add("Gatti");

*/
        ArrayAdapter<UrlModel> arrayAdapter = new ArrayAdapter<UrlModel>(this, android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(urlModels);
        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builderSingle.show();

    }

}
