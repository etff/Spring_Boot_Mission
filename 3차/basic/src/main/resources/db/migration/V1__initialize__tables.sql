create table board
(
    id         bigint(20) NOT NULL AUTO_INCREMENT,
    board_name varchar(100) not null,
    created_at timestamp,
    updated_at timestamp,
    primary key (id)
);

create table post
(
    id         bigint(20) NOT NULL AUTO_INCREMENT,
    title      varchar(100) NOT NULL,
    content    text         NOT NULL,
    password   varchar(20)  NOT NULL,
    board_id   bigint(20) NULL,
    writer_id  bigint(20) NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    primary key (id)
);

create table user
(
    id         bigint(20) NOT NULL AUTO_INCREMENT,
    user_id    varchar(20) NOT NULL,
    password   varchar(20) NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    primary key (id),
    UNIQUE KEY `user_id_unique` (`user_id`)
);

alter table post
    add constraint fk_post_to_board
        foreign key (board_id)
            references board (id);

alter table post
    add constraint fk_post_writer
        foreign key (writer_id)
            references user (id);
