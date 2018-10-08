package com.yrz.userservice.client.hystrix;


import com.yrz.userservice.client.AuthServiceClient;
import com.yrz.userservice.entity.JWT;
import org.springframework.stereotype.Component;

/**
 * Created by fangzhipeng on 2017/5/31.
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
