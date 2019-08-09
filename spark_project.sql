CREATE TABLE spark_project.t_user_test (
                                           id INT(11) NOT NULL AUTO_INCREMENT,
                                           name VARCHAR(50) DEFAULT NULL,
                                           age INT(11) DEFAULT NULL,
                                           PRIMARY KEY (id)
)
    ENGINE = INNODB
    AUTO_INCREMENT = 1
    CHARACTER SET utf8
    COLLATE utf8_general_ci
    ROW_FORMAT = DYNAMIC;


CREATE TABLE spark_project.t_task (
                                      task_id INT(11) NOT NULL AUTO_INCREMENT,
                                      task_name VARCHAR(50) DEFAULT NULL,
                                      create_time VARCHAR(50) DEFAULT NULL,
                                      start_time VARCHAR(50) DEFAULT NULL,
                                      finish_time VARCHAR(50) DEFAULT NULL,
                                      task_type VARCHAR(50) DEFAULT NULL,
                                      task_status VARCHAR(2) DEFAULT NULL,
                                      task_param VARCHAR(255) DEFAULT NULL,
                                      PRIMARY KEY (task_id)
)
    ENGINE = INNODB
    AUTO_INCREMENT = 1
    CHARACTER SET utf8
    COLLATE utf8_general_ci
    COMMENT = '任务表'
    ROW_FORMAT = DYNAMIC;