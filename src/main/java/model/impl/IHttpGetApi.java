package model.impl;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

import java.util.Map;

public interface IHttpGetApi {
    @GET
    Response<String> get(@Url String url,
                                     @HeaderMap Map<String, String> headers);

    @GET
    Response<String> getMap(@Url String url,
                                        @QueryMap(encoded = true) Map<String, String> queryMap,
                                        @HeaderMap Map<String, String> headers);

}

