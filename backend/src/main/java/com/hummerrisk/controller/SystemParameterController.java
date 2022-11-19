package com.hummerrisk.controller;

import com.hummerrisk.base.domain.SystemParameter;
import com.hummerrisk.commons.constants.ParamConstants;
import com.hummerrisk.commons.constants.RoleConstants;
import com.hummerrisk.controller.handler.annotation.I18n;
import com.hummerrisk.service.SystemParameterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "系统设置")
@RestController
@RequestMapping(value = "/system")
public class SystemParameterController {
    @Resource
    private SystemParameterService systemParameterService;

    @ApiOperation(value = "编辑邮箱设置")
    @PostMapping("/edit/email")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public void editMail(@RequestBody List<SystemParameter> systemParameter) {
        systemParameterService.editMail(systemParameter);
    }

    @ApiOperation(value = "编辑企业微信设置")
    @PostMapping("/edit/wechat")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public void editWechat(@RequestBody List<SystemParameter> systemParameter) {
        systemParameterService.editWechat(systemParameter);
    }

    @ApiOperation(value = "编辑钉钉设置")
    @PostMapping("/edit/dingding")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public void editDingding(@RequestBody List<SystemParameter> systemParameter) {
        systemParameterService.editDingding(systemParameter);
    }

    @ApiOperation(value = "编辑检测参数设置")
    @PostMapping("/edit/scanSetting")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public void editScanSetting(@RequestBody List<SystemParameter> systemParameter) {
        systemParameterService.edit(systemParameter);
    }

    @ApiOperation(value = "测试连接")
    @PostMapping("/testConnection/{type}")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public void testConnection(@PathVariable String type, @RequestBody Map<String, String> hashMap) throws Exception {
        switch (type) {
            case "email":
                systemParameterService.testEmailConnection(hashMap);
                break;
            case "wechat":
                systemParameterService.testWechatConnection(hashMap);
                break;
            case "dingding":
                systemParameterService.testDingtalkConnection(hashMap);
                break;
            default:
                break;
        }
    }

    @ApiOperation(value = "版本信息")
    @GetMapping("/version")
    public String getVersion() {
        return systemParameterService.getVersion();
    }

    @I18n
    @ApiOperation(value = "邮件设置")
    @GetMapping("/mail/info")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public List<SystemParameter> mailInfo() {
        return systemParameterService.info(ParamConstants.Classify.MAIL.getValue());
    }

    @I18n
    @ApiOperation(value = "企业微信设置")
    @GetMapping("/wechat/info")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public List<SystemParameter> wechatInfo() {
        return systemParameterService.wechatInfo(ParamConstants.Classify.WECHAT.getValue());
    }

    @ApiOperation(value = "钉钉设置")
    @GetMapping("/dingding/info")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public List<SystemParameter> dingdingInfo() {
        return systemParameterService.dingdingInfo(ParamConstants.Classify.DINGDING.getValue());
    }

    @I18n
    @ApiOperation(value = "检测参数设置")
    @GetMapping("/scanSetting/info")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public List<SystemParameter> scanSettingInfo() {
        return systemParameterService.scanSettingInfo(ParamConstants.Classify.SCAN.getValue());
    }

    @I18n
    @ApiOperation(value = "消息通知")
    @GetMapping("/message/info")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public List<SystemParameter> messageInfo() {
        return systemParameterService.info(ParamConstants.Classify.MESSAGE.getValue());
    }

    @ApiOperation(value = "编辑消息通知")
    @PostMapping("/edit/message")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public void editMessage(@RequestBody List<SystemParameter> systemParameter) {
        systemParameterService.edit(systemParameter);
    }

    @ApiOperation(value = "刷新系统参数信息")
    @GetMapping("/updateSystem")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public void updateSystem() throws Exception {
        systemParameterService.updateSystem();
    }

    @I18n
    @ApiOperation(value = "查询系统参数信息")
    @GetMapping("/searchSystem")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public List<SystemParameter> searchSystem() throws Exception {
        return systemParameterService.info(ParamConstants.Classify.SYSTEM.getValue());
    }

    @I18n
    @ApiOperation(value = "更新漏洞库")
    @GetMapping("/updateVulnDb")
    @RequiresRoles(value = {RoleConstants.ADMIN})
    public void updateVulnDb() throws Exception {
        systemParameterService.updateVulnDb();
    }

}
