package com.liuyk.asimple.http;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import com.liuyk.asimple.web.inteceptor.AccessInterceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommonHeaderInterceptor extends BasePathMatchInterceptor {

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader(AccessInterceptor.TERMINAL_TYPE, "1")
                .addHeader(AccessInterceptor.VERSION, "100")
                .addHeader(AccessInterceptor.TOKEN, "XXXAAAXXAAXXAA").build();
        return chain.proceed(newRequest);
    }

}
