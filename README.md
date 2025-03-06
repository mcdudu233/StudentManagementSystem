# Spring框架的学生管理系统

![](https://oss.mcso.top/wordpress/2025/03/20250304141508853.png?x-oss-process=image/watermark,text_bWNzby50b3A,color_FFFFFF,size_20,shadow_50)

> 这是一个课程设计的项目。
> 本项目基于 Spring Boot 架构和 MySQL 数据库，实现对于学生管理系统功能的基本实现。由于时间的限制，我们采用了前后端不分离的技术来快速完成学生管理系统的所有功能。

---

## 介绍

项目的整体介绍和构成：
[https://www.mcso.top/2025/03/04/spring%e6%a1%86%e6%9e%b6%e7%9a%84%e5%ad%a6%e7%94%9f%e7%ae%a1%e7%90%86%e7%b3%bb%e7%bb%9f/](https://www.mcso.top/2025/03/04/spring%e6%a1%86%e6%9e%b6%e7%9a%84%e5%ad%a6%e7%94%9f%e7%ae%a1%e7%90%86%e7%b3%bb%e7%bb%9f/)

---

## 项目结构

本项目基于 `gradle` 构建，源码位于本目录的 `src/main/java` 下，资源文件位于 `src/main/resources` 文件夹下。

### 源码

主程序位于 `top.mcso.sms.StudentManagementSystemApplication` ，直接运行可以启动这个项目。

`top.mcso.sms.confg`：Spring 配置

`top.mcso.sms.controller`：Spring 控制器

`top.mcso.sms.entity`：实体类

`top.mcso.sms.mapper`：Spring SQL处理类

`top.mcso.sms.service`：Spring 服务类

`top.mcso.sms.utils`：一些小工具，如时间转文本等等

### 资源文件

`sql/data`：数据库初始数据

`sql/schema`：数据库结构

`static`：网页静态文件 css js img

`templates`：网页模板

---

## 构建&部署

先到本项目主文件夹下：

```bash
cd sms
```

修改配置文件`./src/main/resources/application.properties`：

```bash
spring.application.name=StudentManagementSystem
server.port=80
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
# 前面的可以不用动
# 下面 MySQL配置 修改为自己的
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# 注意：这里的数据库 sms 必须自己先建立！！！
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/sms
spring.datasource.username=root
spring.datasource.password=root
```

然后打包成 **war** 包：

```bash
./gradlew bootWar
```

构建完成后 `build\libs` 目录下会生成 `sms-1.0.0-SNAPSHOT.war` 产物。

将 `sms-1.0.0-SNAPSHOT.war` 上传到 **tomcat** 服务器部署即可。

或者使用以下命令本地运行：

```bash
java -jar sms-1.0.0-SNAPSHOT.war
```

---

## 数据库

### 默认用户

| 用户名       | 密码     | 角色  | 
|-----------|--------|-----|
| admin     | admin  | 管理员 |
| Y00000001 | 123456 | 学生  |
| S0001     | 123456 | 老师  |

### 角色

`admin`是管理员，`student`是学生，`teacher`是老师。

---