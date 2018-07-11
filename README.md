# 项目接口管理

### 项目介绍：  
> &nbsp;&nbsp;&nbsp;&nbsp;这个项目主要是用管理项目接口，在目前前后端分离的项目开始越来越多，
我们需要有一个平台去让程序员管理项目的接口。也让前端可以方便的进行接口查询，进行对接。  

### 项目开发流程
> 1、 项目框架搭建: Spring Boot + Spring + Druid + MyBatis + PageHelper  
> 2、 Token 身份验证， 使用JWT (Java Web Token) 规范  
> 3、 异常统一处理 `ExceptionAspect` , Token 拦截验证 `SecurityAspect`， 自定义异常 `ErrorCodeEnum`, 统一响应码 `StandardResponse`  
> 4、 分页处理 PageHelper
 
