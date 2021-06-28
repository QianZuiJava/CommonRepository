CREATE TABLE `auth_auth_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '权限主键',
  `auth_code` varchar(100) NOT NULL COMMENT '权限编码',
  `auth_desc` varchar(100) NOT NULL COMMENT '权限描述',
  `parent_code` varchar(100) NOT NULL COMMENT '父级权限点编码',
  `parent_desc` varchar(100) NOT NULL COMMENT '父级权限点描述',
  `child` int(1) NOT NULL COMMENT '是否为子节点',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '租户ID',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT 'system' COMMENT '更新人',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `auth_role_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(100) NOT NULL COMMENT '角色编码',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `usable` int(1) NOT NULL COMMENT '可用 1 是 0 否',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '租户id',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT 'system' COMMENT '更新人',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `auth_user_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_account` varchar(100) NOT NULL COMMENT '用户账号',
  `usable` int(1) NOT NULL COMMENT '可用 1 是 0否',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '租户id',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT 'system' COMMENT '更新人',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `auth_user_role_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(100) NOT NULL COMMENT '角色编码',
  `user_account` varchar(100) NOT NULL COMMENT '用户账号',
  `usable` int(1) NOT NULL DEFAULT '1' COMMENT '有效 1 是 0 否',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '租户id',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT 'system' COMMENT '更新人',
  `udpated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `auth_role_auth_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(100) NOT NULL COMMENT '角色编码',
  `auth_id` bigint(64) NOT NULL COMMENT '权限id',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '租户id',
  `usable` int(1) NOT NULL COMMENT '可用 1 是 0 否',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `udpated_by` varchar(100) DEFAULT 'system' COMMENT '更新人',
  `udpated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
