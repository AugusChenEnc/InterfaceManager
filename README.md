# 项目接口管理

### 项目介绍：  
> &nbsp;&nbsp;&nbsp;&nbsp;这个项目主要是用管理项目接口，在目前前后端分离的项目开始越来越多，
我们需要有一个平台去让程序员管理项目的接口。也让前端可以方便的进行接口查询，进行对接。  

### 项目开发流程：
> 1、 项目框架搭建: Spring Boot + Spring + Druid + MyBatis + PageHelper  
> 2、 Token 身份验证， 使用JWT (Java Web Token) 规范  
> 3、 异常统一处理 `ExceptionAspect`   
> 4、 Token 拦截验证 `SecurityAspect`  
> 5、 自定义异常 `ErrorCodeEnum`   
> 6、 统一响应码 `StandardResponse`    
> 7、 分页处理 PageHelper  
> 8、 JsTree 可以右键可以拖拽  
 
### 项目开发规则：
> 后端开发规则  
> 1、符合阿里巴巴规范  
>   
> 前端开发规则  
> 1、class 和 id 的命名都以au开头,例如：au-xxx  
> 2、vue组件命名以az开头,例如：az-xxx  
> 3、使用rem或者em 替代px
>   
> 数据库命名规则  
> 1、im_xxx 是普通表  
> 2、cm_xxx 是固定值表（既可以预估的，例如什么Type）  
> 2、sm_xxx 是系统表（和系统有关的如系统配置）

持续更新...
