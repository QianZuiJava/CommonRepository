# CommonRepository
# 技巧方法记录
---
## code-to-name 编码转名称
######  服务中国际化使用：存储编码，展示名称功能；在数据存储时，可以是编码名称 和 业务数据隔离存储
### 基础数据表结构

###    
     CREATE TABLE `hu_global_basedata_t` (
         `ID` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
         `GROUP_NAME` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据所在组编码',
         `ATTR_TYPE` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据属性类型',
         `ATTR_CODE` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据属性编码值',
         `ATTR_TEXT` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据展示值',
         `LANGUAGE` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据对应语种',
         `CREATER` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
         `CREATION_TIME` timestamp NOT NULL COMMENT '创建时间',
         `LAST_UPDATED_BY` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后更新人',
         `LAST_UPDATED_TIME` timestamp NOT NULL COMMENT '最后更新时间',
         PRIMARY KEY (`ID`),
         KEY `index_group_type_code_lanuage` (`GROUP_NAME`,`ATTR_TYPE`,`ATTR_CODE`,`LANGUAGE`)
       ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci



---- 
## log-anonymous 日志脱敏
######  在服务器日志打印时，避免姓名、电话、密码等敏感信息的打印；通过此工具实现匿名类别可配置


----
## config-center-server 配置中心服务端
## config-center        配置中心客户端
###### 自己实现的配置中心模块，主要是可以自主实现配置中心；目前只是实现了简单的拉取远端配置的功能；
###### 后期可以进行再次扩展，如页面，根据区域、开发环境、生产环境、部署单元、版本号等针对性配置；

### 配置中心服务端表结构
### 
    CREATE TABLE `hu_remote_config_t` (
      `ID` bigint(10) NOT NULL AUTO_INCREMENT,
      `CONFIG_KEY` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
      `CONFIG_VALUE` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
      `CREATER` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
      `CREATION_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
      `LAST_UPDATED_BY` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
      `LAST_UPDATED_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
      PRIMARY KEY (`ID`)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

---
## http-invoke-demo 远端地址调用RestTemplate
###### 远程RPC调用demo


