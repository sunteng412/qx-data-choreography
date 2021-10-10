CREATE TABLE IF NOT EXISTS `{tableName}` (
    `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(32) COMMENT 'dsl配置名',
    `dsl_desc` varchar(32) COMMENT '备注',
    `outputs` json COMMENT '输出参数',
    `timeout` int(11) DEFAULT '-1' COMMENT '超时时间',
    `max_retry_times` int(11) DEFAULT '0' COMMENT '最大重试次数',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='dsl主配置';