package com.liuyk.asimple.http;

import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercepts;
import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.liuyk.asimple.entity.Product;
import com.liuyk.asimple.entity.R;
import okhttp3.OkHttpClient;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.concurrent.TimeUnit;

@RetrofitClient(baseUrl = "${httpApi.baseUrl}")
@Intercepts({
        @Intercept(handler = TimeStampInterceptor.class, include = {"/**"}),
        @Intercept(handler = CommonHeaderInterceptor.class, include = {"/**"})
})
public interface HttpApi {

    @GET("/product/p/{id}")
    R<Product> getProduct(@Path("id") Long id);

    @OkHttpClientBuilder
    static OkHttpClient.Builder okhttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS);
    }
}
