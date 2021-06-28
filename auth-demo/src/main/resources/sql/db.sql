CREATE TABLE `auth_auth_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT 'Ȩ������',
  `auth_code` varchar(100) NOT NULL COMMENT 'Ȩ�ޱ���',
  `auth_desc` varchar(100) NOT NULL COMMENT 'Ȩ������',
  `parent_code` varchar(100) NOT NULL COMMENT '����Ȩ�޵����',
  `parent_desc` varchar(100) NOT NULL COMMENT '����Ȩ�޵�����',
  `child` int(1) NOT NULL COMMENT '�Ƿ�Ϊ�ӽڵ�',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '�⻧ID',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '������',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `updated_by` varchar(100) DEFAULT 'system' COMMENT '������',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `auth_role_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '����',
  `role_code` varchar(100) NOT NULL COMMENT '��ɫ����',
  `role_name` varchar(100) NOT NULL COMMENT '��ɫ����',
  `usable` int(1) NOT NULL COMMENT '���� 1 �� 0 ��',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '�⻧id',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '������',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `updated_by` varchar(100) DEFAULT 'system' COMMENT '������',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `auth_user_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '����',
  `user_account` varchar(100) NOT NULL COMMENT '�û��˺�',
  `usable` int(1) NOT NULL COMMENT '���� 1 �� 0��',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '�⻧id',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '������',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `updated_by` varchar(100) DEFAULT 'system' COMMENT '������',
  `updated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `auth_user_role_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '����',
  `role_code` varchar(100) NOT NULL COMMENT '��ɫ����',
  `user_account` varchar(100) NOT NULL COMMENT '�û��˺�',
  `usable` int(1) NOT NULL DEFAULT '1' COMMENT '��Ч 1 �� 0 ��',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '�⻧id',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '������',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `updated_by` varchar(100) DEFAULT 'system' COMMENT '������',
  `udpated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `auth_role_auth_t` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '����',
  `role_code` varchar(100) NOT NULL COMMENT '��ɫ����',
  `auth_id` bigint(64) NOT NULL COMMENT 'Ȩ��id',
  `tenant_id` bigint(64) DEFAULT NULL COMMENT '�⻧id',
  `usable` int(1) NOT NULL COMMENT '���� 1 �� 0 ��',
  `created_by` varchar(100) NOT NULL DEFAULT 'system' COMMENT '������',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `udpated_by` varchar(100) DEFAULT 'system' COMMENT '������',
  `udpated_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
