CREATE TABLE `training`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `end_date`    date           DEFAULT NULL,
    `end_time`    time           DEFAULT NULL,
    `fee`         decimal(19, 2) DEFAULT NULL,
    `musername`   varchar(128)   DEFAULT NULL,
    `profile`     varchar(2048)  DEFAULT NULL,
    `sname`       varchar(128)   DEFAULT NULL,
    `start_date`  date           DEFAULT NULL,
    `start_time`  time           DEFAULT NULL,
    `year_of_exp` int(11)        DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKo4g8gtr7nfb5s56d5l1fqjafg` (`musername`,`sname`)
);

CREATE TABLE student_training
(
    id                     bigint PRIMARY KEY                       NOT NULL,
    amount_received        decimal(10, 0) DEFAULT 0,
    last_updated_by        varchar(255),
    last_updated_timestamp timestamp      DEFAULT CURRENT_TIMESTAMP NOT NULL,
    rating                 int            DEFAULT 10,
    status                 varchar(255),
    uusername              varchar(128),
    cid                    bigint,
    UNIQUE KEY `UKm4nk7pqyocwy7qqepe9ntak80` (`cid`,`uusername`)
);
