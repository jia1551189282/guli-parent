package com.atguigu.guli.service.edu.controller.admin;

import com.atguigu.guli.service.base.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjiajia
 * @date 2020/9/3 9:32
 */

@RestController
@CrossOrigin
@RequestMapping("/user")
public class LoginController {

    /**
     * 登录
     * @return 返回是否登录成功
     */
    @PostMapping("login")
    public R login(){

        return R.ok().data("token","admin");
    }

    /**
     * 用户信息
     * @return   用户信息
     */
    @GetMapping("info")
    public R userInfo(){

        return R.ok().data("name","佳佳").data("roles","[admin]").data("avatra","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
    }

    /**
     * 退出登录
     * @return  返回结果
     */
    @PostMapping("logout")
    public R logout(){
        return R.ok();
    }
}
