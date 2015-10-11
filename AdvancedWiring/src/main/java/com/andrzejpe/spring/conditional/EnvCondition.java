package com.andrzejpe.spring.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by jedrek on 2015-10-11.
 */
public class EnvCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String foo = conditionContext.getEnvironment().getProperty("com.andrzejpe.foo");
        return (foo != null && foo.equals("fighters"));
    }
}
