package com.yxx.business.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxx.business.model.request.OperateLogReq;
import com.yxx.business.model.response.OperateLogResp;
import com.yxx.business.service.OperateLogService;
import com.yxx.common.annotation.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

/**
 * 操作日志控制器
 *
 * @author yxx
 * @classname OperateLogController
 * @since 2023/08/26
 */
@Slf4j
@Validated
@ResponseResult
@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
@SaCheckRole("super_admin")
public class OperateLogController {
    private final OperateLogService operateLogService;

    /**
     * 身份验证登录日志数据分页
     *
     * @param req 要求事情
     * @return {@link Page }<{@link OperateLogResp }>
     * @author yxx
     */
    @PostMapping("/auth")
    public Page<OperateLogResp> authLogPage(@Valid @RequestBody OperateLogReq req) {
        return operateLogService.authLogPage(req);
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
        return operateLogService.operationLogPage(req);
    }
}
