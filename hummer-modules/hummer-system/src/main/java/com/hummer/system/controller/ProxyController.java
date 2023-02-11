package com.hummer.system.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hummer.common.core.constant.RoleConstants;
import com.hummer.common.core.domain.Proxy;
import com.hummer.common.core.domain.request.proxy.ProxyRequest;
import com.hummer.common.core.utils.PageUtils;
import com.hummer.common.core.utils.Pager;
import com.hummer.system.controller.handler.annotation.I18n;
import com.hummer.system.service.ProxyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "代理")
@RequestMapping("proxy")
@RestController
public class ProxyController {

    @Resource
    private ProxyService proxyService;

    @I18n
    @ApiOperation(value = "添加代理")
    @PostMapping("/add")
    @RequiresRoles(RoleConstants.ADMIN)
    public Proxy insertProxy(@RequestBody Proxy Proxy) throws Exception {
        return proxyService.insert(Proxy);
    }

    @I18n
    @ApiOperation(value = "代理列表")
    @PostMapping("/list/{goPage}/{pageSize}")
    @RequiresRoles(RoleConstants.ADMIN)
    public Pager<List<Proxy>> getProxyList(@PathVariable int goPage, @PathVariable int pageSize, @RequestBody ProxyRequest request) {
        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, proxyService.getProxyListWithRequest(request));
    }

    @ApiOperation(value = "删除代理")
    @GetMapping("/delete/{proxyId}")
    @RequiresRoles(RoleConstants.ADMIN)
    public void deleteProxy(@PathVariable(value = "proxyId") int proxyId) {
        proxyService.deleteProxy(proxyId);
    }

    @ApiOperation(value = "更新代理")
    @PostMapping("/update")
    @RequiresRoles(RoleConstants.ADMIN)
    public void updateProxy(@RequestBody Proxy proxy) {
        proxyService.updateProxy(proxy);
    }

    @I18n
    @ApiOperation(value = "所有代理")
    @GetMapping("/list/all")
    public List<Proxy> getProxyList() {
        return proxyService.getProxyList();
    }

}
