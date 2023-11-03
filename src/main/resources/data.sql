insert into roles(role_name)
values ('ROLE_AUTHOR'),
       ('ROLE_STUDENT');

insert into users(username, password, is_active)
values ('cosqun', '12345', true),
       ('maqsud', '12345', true);

insert into authors(name, email, age, user_id)
values ('Cosqun', 'cosqun@gmail.com', '23', '1');

insert into students(name, email, age, user_id)
values ('Maqsud', 'cosqun.mammadov23@gmail.com', '23', '2');
