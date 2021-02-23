package com.liuyk.asimple.http;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TimeStampInterceptor extends BasePathMatchInterceptor {

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();
        HttpUrl newUrl = url.newBuilder().addQueryParameter("timestamp", String.valueOf(System.currentTimeMillis())).build();
        Request newQequest = request.newBuilder().url(newUrl).build();
        return chain.proceed(newQequest);
    }

}
