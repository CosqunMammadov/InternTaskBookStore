insert into roles(role_name)
values ('ROLE_AUTHOR'),
       ('ROLE_STUDENT');

-- (12345)
-- (12345)
insert into users(username, password, is_active)
values ('cosqun', '$2a$12$JGYyROlRdc1wOBswNWmHDOLt/lLZZvhOJGeL3jDiJSAPmwVMksSeu', true),
       ('maqsud', '$2a$12$ZjQUavnMV3RubpaG5EUWhuXLjixR8xAtieb.Aoka7JcWr/KREQ3Ai', true);

insert into authors(name, email, age, user_id)
values ('Cosqun', 'cosqun@gmail.com', '23', '1');

insert into students(name, email, age, user_id)
values ('Maqsud', 'cosqun.mammadov23@gmail.com', '23', '2');

insert into books(name, author_id)
values ('1984', '1'),
       ('The fault in our stars', '1'),
       ('Thanks for the memories', '1');

insert into authors_students(author_id, student_id)
values ('1', '1');

insert into students_books(student_id, book_id)
values ('1', '1'),
       ('1', '2');

insert into users_roles(user_id, role_id)
values ('1', '1');
