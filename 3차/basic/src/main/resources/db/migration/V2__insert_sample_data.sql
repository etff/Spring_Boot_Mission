insert into board (id, board_name, created_at, updated_at)
values (1, '취미', now(), null);

insert into board (id, board_name, created_at, updated_at)
values (2, '공부', now(), null);

insert into board (id, board_name, created_at, updated_at)
values (3, 'IT', now(), null);

insert into user (id, user_id, password, created_at, updated_at)
values (1, 'user1', 'test1234', now(), null);

insert into user (id, user_id, password, created_at, updated_at)
values (2, 'user2', 'test1234', now(), null);

insert into user (id, user_id, password, created_at, updated_at)
values (3, 'user3', 'test1234', now(), null);

insert into post (id, title, content, password, board_id, writer_id, created_at, updated_at)
values (1, 'test1', 'hello world1', 'test1234', 1, 1, now(), null);

insert into post (id, title, content, password, board_id, writer_id, created_at, updated_at)
values (2, 'test2', 'hello world2', 'test1234', 1, 2, now(), null);
