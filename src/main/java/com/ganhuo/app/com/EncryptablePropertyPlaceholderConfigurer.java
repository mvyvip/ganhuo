/*
 * Copyright 2014-2024 the https://github.com/xiaoxing598/itganhuo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * This project consists of JAVA private school online learning community group Friends co-creator [QQ group 329232140].
 * 本项目由JAVA私塾在线学习社区群友共同创作[QQ群329232140];
 * See the list of IT dry technology sharing network [http://www.itganhuo.cn/teams].
 * 作者名单详见IT干货技术分享网[http://www.itganhuo.cn/teams];
 * The author does not guarantee the quality of the project and its stability, reliability, and security does not bear any responsibility.
 * 作者不保证本项目质量并对其稳定性、可靠性和安全性不承担任何责任.
 */
package com.ganhuo.app.com;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.ganhuo.app.exception.InternalException;


/**
 * <h2>
 * 	容器启动时通过PropertyPlaceholderConfigurer类读取jdbc.properties文件里的数据库加密配置信息，
 * 	使用自定义一个继承PropertyPlaceholderConfigurer的类实现解密。
 * </h2>
 * <dl>
 * <dt>功能描述</dt>
 * <dd>无</dd>
 * <dt>使用规范</dt>
 * <dd>无</dd>
 * </dl>
 * @version V1.0
 * @date 2016年1月8日 下午5:00:31 
 * @author lt
 */
public class EncryptablePropertyPlaceholderConfigurer extends
        PropertyPlaceholderConfigurer {

    private final static Logger log = LogManager
            .getLogger(EncryptablePropertyPlaceholderConfigurer.class.getName());

    private String key;

    public EncryptablePropertyPlaceholderConfigurer(String key) {
        log.debug("key={}", key);
        this.key = key;
    }

    @SuppressWarnings("all")
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactory, Properties props)
            throws BeansException {
        try {
			Iterator it=props.entrySet().iterator();
			
			// 遍历properties并解密
        	while(it.hasNext()){
        	    Map.Entry entry=(Map.Entry)it.next();
        	    props.setProperty(entry.getKey().toString(),new String(
        	    			Aes.decrypt(Aes.parseHexStr2Byte(entry.getValue().toString()), key)
	    		));
        	}
        	
            super.processProperties(beanFactory, props);

        } catch (Exception e) {
            throw new InternalException(log, e);
        }
    }

}
