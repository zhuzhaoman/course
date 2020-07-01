package com.course.server.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @author zhuzhaoman
 * @date 2020/6/30 0030 23:39
 * @description 描述
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 定义一个切点
     */
    @Pointcut("execution(public * com.course.*.controller..*Controller.*(..))")
    public void controllerPointcut() {}

    @Before("controllerPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("##############" + uuid);
        // 日志编号
        MDC.put("UUID", uuid.substring(0,8));

        // 开始打印请求日志
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        // 打印业务操作
        String nameCn = "";
        if (name.contains("list") || name.contains("query")) {
            nameCn = "查询";
        } else if (name.contains("save")){
            nameCn = "保存";
        } else if (name.contains("delete")) {
            nameCn = "删除";
        } else {
            nameCn = "操作";
        }

        // 使用反射，获取业务名称
        Class clazz = signature.getDeclaringType();
        Field field;
        String businessName = "";

        try {
            field = clazz.getField("BUSINESS_NAME");
            if (!StringUtils.isEmpty(field)) {
                businessName = (String) field.get(clazz);
            }
        } catch (NoSuchFieldException e) {
            LOGGER.error("为获取到业务名称：", e);
        } catch (IllegalAccessException e) {
            LOGGER.error("获取业务名称失败：", e);
        }

        // 打印请求信息
        LOGGER.info("------------------ 【{}】{}开始 ------------------", businessName, nameCn);
        LOGGER.info("请求地址：{} {}", request.getRequestURL().toString(), request.getMethod());
        LOGGER.info("类名方法：{}.{}", signature.getDeclaringTypeName(), name);
        LOGGER.info("远程地址：{}", request.getRemoteAddr());

        // 打印请求参数
        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest
            || args[i] instanceof ServletResponse) {
                continue;
            }
            arguments[i] = args[i];
        }

        // 排出字段，敏感字段或太长的字段不显示
        String[] excludeProperties = {"shard"};
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(excludeProperties);
        LOGGER.info("请求参数: {}", JSONObject.toJSONString(arguments, excludefilter)); // 为空的会不打印，但是像图片等长字段也会打印
    }

    @Around("controllerPointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 排除字段，敏感字段或太长的字段不显示
        String[] excludeProperties = {"password", "shard"};
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(excludeProperties);
        LOGGER.info("返回结果: {}", JSONObject.toJSONString(result, excludefilter));
        LOGGER.info("------------- 结束 耗时：{} ms -------------", System.currentTimeMillis() - startTime);
        return result;
    }

}
