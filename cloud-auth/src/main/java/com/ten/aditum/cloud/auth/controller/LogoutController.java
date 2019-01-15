package com.ten.aditum.cloud.auth.controller;

import com.ten.aditum.cloud.auth.util.StatusCode;
import com.ten.aditum.cloud.auth.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-12-07
 * Time: 19:17
 */
@RestController
public class LogoutController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @DeleteMapping(value = "/exit")
    public @ResponseBody
    Result revokeToken(String access_token) {
        Result msg = new Result();
        if (consumerTokenServices.revokeToken(access_token)) {
            msg.setCode(StatusCode.SUCCESS_CODE);
            msg.setMsg("注销成功");
        } else {
            msg.setCode(StatusCode.FAILURE_CODE);
            msg.setMsg("注销失败");
        }
        return msg;
    }
}
