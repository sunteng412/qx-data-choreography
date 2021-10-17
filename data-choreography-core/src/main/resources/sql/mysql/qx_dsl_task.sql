CREATE TABLE IF NOT EXISTS `{tableName}` (
    `id` bigint(11)  NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `dsl_id` bigint(11)  NOT NULL  COMMENT 'dsl ID',
    `task_alias` varchar(32) COMMENT 'dsl任务别名',
    `task_desc` varchar(32) COMMENT '备注',
    `ret_generic_definition` json COMMENT '返回值定义',
    `task_params` json COMMENT '任务参数',
    `task_type` varchar(32) COMMENT '任务类型',
    `location` int(6) DEFAULT '1' COMMENT '任务类型',
    `input_depends_on` varchar(1024) COMMENT '入参依赖于',
    `timeout` int(11) DEFAULT '-1' COMMENT '超时时间',
    `max_retry_times` int(11) DEFAULT '0' COMMENT '最大重试次数',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='dsl主配置';