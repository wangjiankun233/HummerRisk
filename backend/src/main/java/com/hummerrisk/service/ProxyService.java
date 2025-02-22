package com.hummerrisk.service;

import com.hummerrisk.base.domain.Proxy;
import com.hummerrisk.base.domain.ProxyExample;
import com.hummerrisk.base.mapper.ProxyMapper;
import com.hummerrisk.base.mapper.ext.ExtProxyMapper;
import com.hummerrisk.commons.constants.ResourceOperation;
import com.hummerrisk.commons.constants.ResourceTypeConstants;
import com.hummerrisk.commons.exception.HRException;
import com.hummerrisk.commons.utils.SessionUtils;
import com.hummerrisk.controller.request.proxy.ProxyRequest;
import com.hummerrisk.i18n.Translator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author harris
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProxyService {

    @Resource
    private ProxyMapper proxyMapper;

    @Resource
    private ExtProxyMapper extProxyMapper;

    public Proxy insert(Proxy proxy) throws Exception {

        Integer id = proxy.getId();
        Proxy proxy1 = proxyMapper.selectByPrimaryKey(id);
        if (proxy1 != null) {
            HRException.throwException(Translator.get("proxy_id_already_exists"));
        } else {
            createProxy(proxy);
        }
        return proxy;
    }

    public void createProxy(Proxy proxy) throws Exception {
        proxy.setCreateTime(System.currentTimeMillis());
        proxy.setUpdateTime(System.currentTimeMillis());
        // 密码使用 MD5
        proxy.setProxyPassword(proxy.getProxyPassword());
        proxyMapper.insertSelective(proxy);
        OperationLogService.log(SessionUtils.getUser(), proxy.getProxyIp(), proxy.getProxyIp(), ResourceTypeConstants.PROXY.name(), ResourceOperation.CREATE, "i18n_create_proxy");
    }

    public List<Proxy> getProxyList() {
        ProxyExample example = new ProxyExample();
        example.setOrderByClause("update_time desc");
        return proxyMapper.selectByExample(example);
    }

    public List<Proxy> getProxyListWithRequest(ProxyRequest request) {
        return extProxyMapper.getProxyListWithRequest(request);
    }

    public void deleteProxy(int proxyId) {
        Proxy proxy = proxyMapper.selectByPrimaryKey(proxyId);
        proxyMapper.deleteByPrimaryKey(proxyId);
        OperationLogService.log(SessionUtils.getUser(), proxy.getProxyIp(), proxy.getProxyIp(), ResourceTypeConstants.PROXY.name(), ResourceOperation.DELETE, "i18n_delete_proxy");
    }

    public void updateProxy(Proxy proxy) {
        proxy.setUpdateTime(System.currentTimeMillis());
        proxyMapper.updateByPrimaryKeySelective(proxy);
        OperationLogService.log(SessionUtils.getUser(), proxy.getProxyIp(), proxy.getProxyIp(), ResourceTypeConstants.PROXY.name(), ResourceOperation.UPDATE, "i18n_update_proxy");
    }

}
