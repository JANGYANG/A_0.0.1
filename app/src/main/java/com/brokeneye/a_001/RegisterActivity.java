package com.brokeneye.a_001;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static android.app.AlertDialog.*;

/**
 * Created by a007 on 2017. 2. 6..
 */

public class RegisterActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_register);

        final EditText idText = (EditText) findViewById(R.id.idText_register);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText_register);
        final EditText passwordConfirmText = (EditText) findViewById(R.id.passwordText_confirm);
        final EditText nameText = (EditText) findViewById(R.id.name_register);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker_register);

        final Button registerButton = (Button) findViewById(R.id.registerButton_register);

        registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){



                String userID = idText.getText().toString();
                String userPassword = passwordText.getText().toString();
                String userPasswordConfirm = passwordConfirmText.getText().toString();
                String userName = nameText.getText().toString();
                String userBirth = "10";

                Integer userBirth_year = datePicker.getYear();
                Integer userBirth_month = datePicker.getMonth() + 1;
                Integer userBirth_day = datePicker.getDayOfMonth();




                //empty and password check
                if(userID.isEmpty()){
                    Toast.makeText(RegisterActivity.this,R.string.UserIDConfirm_toast,Toast.LENGTH_LONG).show();
                }else if(userPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this,R.string.PasswordConfirm_toast,Toast.LENGTH_LONG).show();
                }else if(userName.isEmpty()){
                    Toast.makeText(RegisterActivity.this,R.string.UserNameConfirm_toast,Toast.LENGTH_LONG).show();
                }else if(userPassword.equals(userPasswordConfirm) == false){
                    Toast.makeText(RegisterActivity.this,R.string.PasswordConfirm_toast,Toast.LENGTH_LONG).show();
                }else{

                    Response.Listener<String> responseListener = new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {

                            try {

                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if(success)
                                {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("회원 등록에 성공했습니다.")
                                            .setPositiveButton("확인", null)
                                            .create()
                                            .show();

                                    finish();
                                }
                                else
                                {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("회원 등록에 성공했습니다.")
                                            .setNegativeButton("다시 시도", null)
                                            .create()
                                            .show();
                                }


                            } catch (JSONException e) {

                                e.printStackTrace();

                            }
                        }

                    };

                    RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userName,
                            userBirth_year.toString(), userBirth_month.toString(), userBirth_day.toString(),
                            responseListener);

                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);

                    queue.add(registerRequest);

                }


            }

        });



    }


}
