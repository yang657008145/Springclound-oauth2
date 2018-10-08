package com.yrz.userservice.web;
import com.yrz.userservice.utils.VerifyCodeUtils;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;


/**
 * <p>Description: [invite系统里的邀请码重新发送接口]</p>
 * Created on 2017年11月16日 下午2:42:59
 * @author  <a href="mailto: 15175223269@163.com">全冉</a>
 * @version 1.0
 * Copyright (c) 2017 北京全冉科技有限公司
 */
@RestController
@RequestMapping("/invitationCode")
public class InvitationCodeController {
    @RequestMapping(method = RequestMethod.GET)
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成验证码的图片
        VerifyCodeUtils code = new VerifyCodeUtils();
        BufferedImage image = code.createImage();
        // 设置响应头通知浏览器以图片的形式打开
        response.setContentType("image/jpeg");
        // 设置响应头控制浏览器不要缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setIntHeader("Expires",-1);
        // 将图片变成流写给浏览器
        OutputStream os=response.getOutputStream();
        ImageIO.write(image, "jpg", os);
        // 清空关闭流
        os.flush();
        os.close();
        os=null;
        response.flushBuffer();
        System.out.println(code.getText());
    }
}
