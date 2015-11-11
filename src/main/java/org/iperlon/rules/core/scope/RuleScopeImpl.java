package org.iperlon.rules.core.scope;

import org.iperlon.rules.core.annotations.Context;
import org.iperlon.rules.core.domain.Rule;
import org.iperlon.rules.core.domain.RulesContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.Ordered;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class RuleScopeImpl implements Scope, BeanFactoryPostProcessor, Ordered {


    public Object get(String s, ObjectFactory<?> objectFactory) {
        Rule rule = RulesGameSynchronizationManager.getCurrentRule();
        if(rule == null) {
            RulesContext rulesContext = RulesGameSynchronizationManager.getCurrentContext();
            rule = (Rule) objectFactory.getObject();

            for(Field field : rule.getClass().getDeclaredFields()) {
                Context context = field.getAnnotation(Context.class);
                if(context != null) {
                    ReflectionUtils.makeAccessible(field);
                    Object contextValue = rulesContext.get(context.value());
                    if(context.required() && contextValue == null) {
                        throw new RuntimeException("Rule context "+context.value() +" missing");
                    }
                    ReflectionUtils.setField(field, rule, contextValue);
                }
            }
            RulesGameSynchronizationManager.setCurrentRule(rule);
        }
        return rule;
    }

    public Object remove(String s) {
        return null;
    }

    public void registerDestructionCallback(String s, Runnable runnable) {
        System.out.println();
    }

    public Object resolveContextualObject(String s) {
        return null;
    }

    public String getConversationId() {
        return null;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope("rule", this);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
