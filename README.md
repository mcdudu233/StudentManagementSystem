# Spring框架的学生管理系统

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

`sql`：数据库语句

`static`：网页静态文件 css js img

`templates`：网页模板

---

## 构建&部署

先`cd sms`到本项目主文件夹下，然后打包成 **war** 包：

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