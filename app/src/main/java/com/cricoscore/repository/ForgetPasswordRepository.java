package com.cricoscore.repository;

import android.util.Log;

import com.cricoscore.ApiResponse.SignUpResponse;
import com.cricoscore.ParamBody.ForgetPasswordBody;
import com.cricoscore.ParamBody.LoginBody;
import com.cricoscore.ParamBody.LoginThroughPhoneNumberBody;
import com.cricoscore.Utils.Toaster;
import com.cricoscore.retrofit.ApiRequest;
import com.cricoscore.retrofit.RetrofitRequest;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgetPasswordRepository {

    private static final String TAG = ForgetPasswordRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public ForgetPasswordRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public void getForgetPassword(ForgetPasswordBody loginBody, LoginRepository.ILoginResponse iLoginResponse){
        Call<SignUpResponse> initiateLogin = apiRequest.getForgotPassword(loginBody);
        initiateLogin.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                Log.e(TAG,response+"");

                if(response.isSuccessful()){
                    iLoginResponse.onResponse(response.body(),false);
                }else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Log.e(TAG,jObjError.toString());
                        iLoginResponse.onResponse(response.body(),true);
                        Toaster.customToast(jObjError.getString("message"));
                    } catch (Exception e) {
                        Toaster.customToast(e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                iLoginResponse.onFailure(t);
            }
        });
    }

    public interface IForgetResponse{
        void onResponse(SignUpResponse signUpResponse, Boolean status);
        void onFailure(Throwable t);
    }
}
