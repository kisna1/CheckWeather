package com.org.checkweather.network.interfaces;

import com.org.sahistock.network.model.BaseResponse;
import com.org.sahistock.network.model.BizDetail;
import com.org.sahistock.network.model.BizProduct;
import com.org.sahistock.network.model.BizReqOTP;
import com.org.sahistock.network.model.BizReqProduct;
import com.org.sahistock.network.model.BizReqVerOTP;
import com.org.sahistock.network.model.BizResOTP;
import com.org.sahistock.network.model.BizType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("BusinessTypes")
    Call<List<BizType>> doGetBizTypes();

    @GET("Business")
    Call<List<BizDetail>> doGetBizDetails();

    @GET("Products")
    Call<List<BizProduct>> doGetBizProducts();

    @POST("Products")
    Call<BaseResponse> doPostSaveBizProduct(@Body BizReqProduct product);

    @POST("GenerateOTP")
    Call<BizResOTP> doPostGenerateOTP(@Body BizReqOTP otpReq);

    @POST("VerifyOTP")
    Call<BaseResponse> doPostVerifyOTP(@Body BizReqVerOTP otpReq);

}
