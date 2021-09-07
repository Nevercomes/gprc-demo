package com.example.grpcdemo;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 用于标记 GrpcService，将被 Spring 扫描并加入到 GrpcServer 中
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface GrpcService {
}
