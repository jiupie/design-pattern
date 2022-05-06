package com.wl.strategy;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 南顾北衫
 */
@Component
@Getter
public class FromSubmitHandlerFactory implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private static final Map<String, FormSubmitHandler> FORM_SUBMIT_HANDLER_MAP = new HashMap<>(8);

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(FormSubmitHandler.class).values().forEach(handler -> {
            FORM_SUBMIT_HANDLER_MAP.put(handler.getSubmitType(), handler);
        });

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 根据提交类型获取对应的处理器
     *
     * @param submitType 提交类型
     * @return 提交类型对应的处理器
     */
    public FormSubmitHandler getHandler(String submitType) {
        return FORM_SUBMIT_HANDLER_MAP.get(submitType);
    }


}
