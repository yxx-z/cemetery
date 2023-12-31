package com.yxx.admin.controller;

import com.yxx.admin.model.request.LoginReq;
import com.yxx.admin.model.response.LoginRes;
import com.yxx.admin.service.AdminUserService;
import com.yxx.common.annotation.auth.ReleaseToken;
import com.yxx.common.annotation.log.OperationLog;
import com.yxx.common.annotation.response.ResponseResult;
import com.yxx.common.utils.satoken.StpAdminUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

/**
 * 管理员身份验证控制器
 *
 * @author yxx
 * @classname AdminAuthController
 * @since 2023/08/26
 */
@Slf4j
@Validated
@ResponseResult
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AdminAuthController {
    private final AdminUserService adminUserService;

    /**
     * 登录
     *
     * @param request 请求
     * @return {@link LoginRes }
     * @author yxx
     */
    @ReleaseToken
    @OperationLog(module = "鉴权模块", title = "pc登录")
    @PostMapping("/login")
    public LoginRes login(@Valid @RequestBody LoginReq request) {
        return adminUserService.login(request);
    }

    /**
     * 注销
     *
     * @author yxx
     */
    @OperationLog(module = "鉴权模块", title = "pc退出")
    @PostMapping("/logout")
    public void logout() {
        StpAdminUtil.logout();
    }
}
