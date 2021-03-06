package model.impl;

import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.Map;

public interface IHttpPostApi {

        @FormUrlEncoded
        @POST
        Response<String> postMap(@Url String url,
                                             @FieldMap() Map<String, String> fieldMap,
                                             @HeaderMap Map<String, String> headers);

        @POST
        Response<String> postJson(@Url String url,
                                              @Body RequestBody body,
                                              @HeaderMap Map<String, String> headers);
}
