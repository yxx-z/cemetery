package com.yxx.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxx.admin.model.request.OperateLogReq;
import com.yxx.admin.model.response.OperateLogResp;
import com.yxx.admin.service.OperateAdminLogService;
import com.yxx.common.annotation.response.ResponseResult;
import com.yxx.common.annotation.satoken.SaAdminCheckRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

/**
 * 运营管理日志控制器
 *
 * @author yxx
 * @classname OperateAdminLogController
 * @since 2023/08/26
 */
@Slf4j
@Validated
@ResponseResult
@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
@SaAdminCheckRole("super_admin1")
public class OperateAdminLogController {
    private final OperateAdminLogService operateAdminLogService;

    /**
     * 身份验证登录日志数据分页
     *
     * @param req 要求事情
     * @return {@link Page }<{@link OperateLogResp }>
     * @author yxx
     */
    @PostMapping("/auth")
    public Page<OperateLogResp> authLogPage(@Valid @RequestBody OperateLogReq req) {
        return operateAdminLogService.authLogPage(req);
    }

    /**
     * 操作日志数据分页
     *
     * @param req 要求事情
     * @return {@link Page }<{@link OperateLogResp }>
     * @author yxx
     */
    @PostMapping("/operation")
    public Page<OperateLogResp> operationLogPage(@Valid @RequestBody OperateLogReq req) {
        return operateAdminLogService.operationLogPage(req);
    }
}
