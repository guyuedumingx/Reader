package base;

import analyzeRule.AnalyzeUrl;
import analyzeRule.SSLSocketClient;
import help.EncodeConverter;
import model.impl.IHttpGetApi;
import model.impl.IHttpPostApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import util.TextUtils;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


public class BaseModelImpl {
    private static OkHttpClient httpClient;

    public static BaseModelImpl getInstance() {
        return new BaseModelImpl();
    }

    public Response<String> getResponseO(AnalyzeUrl analyzeUrl) {
        switch (analyzeUrl.getUrlMode()) {
            case POST:
                return getRetrofitString(analyzeUrl.getHost(), analyzeUrl.getCharCode())
                        .create(IHttpPostApi.class)
                        .postMap(analyzeUrl.getPath(),
                                analyzeUrl.getQueryMap(),
                                analyzeUrl.getHeaderMap());
            case GET:
                IHttpGetApi api = getRetrofitString(analyzeUrl.getHost(), analyzeUrl.getCharCode())
                        .create(IHttpGetApi.class);
                Response<String> map = api.getMap(analyzeUrl.getPath(),
                        analyzeUrl.getQueryMap(),
                        analyzeUrl.getHeaderMap());
                return map;
            default:
                return getRetrofitString(analyzeUrl.getHost(), analyzeUrl.getCharCode())
                        .create(IHttpGetApi.class)
                        .get(analyzeUrl.getPath(),
                                analyzeUrl.getHeaderMap());
        }
    }

    public Retrofit getRetrofitString(String url) {
        return new Retrofit.Builder().baseUrl(url)
                //增加返回值为字符串的支持(以实体类返回)
                .addConverterFactory(EncodeConverter.create())
                //增加返回值为Observable<T>的支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build();
    }

    public Retrofit getRetrofitString(String url, String encode) {
        return new Retrofit.Builder().baseUrl(url)
                //增加返回值为字符串的支持(以实体类返回)
                .addConverterFactory(EncodeConverter.create(encode))
                //增加返回值为Observable<T>的支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build();
    }

    synchronized public static OkHttpClient getClient() {
        if (httpClient == null) {
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .sslSocketFactory(SSLSocketClient.getSSLSocketFactory(), SSLSocketClient.createTrustAllManager())
                    .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                    .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                    .addInterceptor(getHeaderInterceptor())
                    .build();
        }
        return httpClient;
    }

    private static Interceptor getHeaderInterceptor() {
        return chain -> {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Keep-Alive", "300")
                    .addHeader("Connection", "Keep-Alive")
                    .addHeader("Cache-Control", "no-cache")
                    .build();
            return chain.proceed(request);
        };
    }

    protected Response<String> setCookie(Response<String> response, String tag) {
        if (!response.raw().headers("Set-Cookie").isEmpty()) {
            StringBuilder cookieBuilder = new StringBuilder();
            for (String s : response.raw().headers("Set-Cookie")) {
                String[] x = s.split(";");
                for (String y : x) {
                    if (!TextUtils.isEmpty(y)) {
                        cookieBuilder.append(y).append(";");
                    }
                }
            }
            String cookie = cookieBuilder.toString();
            if (!TextUtils.isEmpty(cookie)) {
            }
        }
        return null;
    }

    private class Web {
        private String content;
        private String js = "document.documentElement.outerHTML";

        Web(String content) {
            this.content = content;
        }
    }
}
