
/*t_courses
1,C++
2,Java
3,C#
4,HTML CSS
5,JS
6,Python
*/

/*t_employees*/
/*1,asem@gmail.com,Asem Askarova,qweqwe,img1.jpg,1
2,kaisar@gmail.com,Kaisar Smagul,qwerty,img1.jpg,2
3,admin@gmail.com,Admin,asdasd,img1.jpg,4
4,samat@gmail.com,Samat Amantay,zxczxc,img1.jpg,2
5,marzhan@gmail.com,Marzhan Kairatova,zxcvbn,img1.jpg,2*/


/*t_employees_courses*/
/*2,1
4,1
4,3
5,2
2,2
5,4
4,5
*/

/*t_groups
1,09:00:00,12:00:00,SEP-191,2,2
2,09:00:00,12:00:00,SMP-192.1,3,4
3,12:00:00,15:00:00,SDE-180,1,4
4,12:00:00,15:00:00,DEP-182.1,4,5
*/

/*t_roles
1,Director,ROLE_DIRECTOR
2,Teacher,ROLE_TEACHER
3,Student,ROLE_STUDENT
4,Administrator,ROLE_ADMIN
*/

/*t_students
1,alex@gmail.com,Alex Kelvin,alex,img2.jpg,1
2,john@gmail.com,John Sparrow,john,img2.jpg,1
3,sally@gmail.com,Sally Fanning,sally,img2.jpg,1
4,kelly@gmail.com,Kelly Clarkson,kelly,img2.jpg,2
5,dave@gmail.com,Dave Dracula,dave,img2.jpg,2
6,liam@gmail.com,Liam Hemsworth,liam,img2.jpg,2
7,selena@gmail.com,Selena Gomes,selena,img2.jpg,3
8,dilan@gmail.com,Dilan Sprows,dilan,img2.jpg,3
9,cole@gmail.com,COle Sprows,cole,img2.jpg,3
*/




insert into t_courses (course_name)
values
('C++'),
('Java'),
('C#'),
('HTML CSS'),
('JS'),
('Python');

insert into t_roles(description, role)
values ('Director','ROLE_DIRECTOR'),
       ('Teacher','ROLE_TEACHER'),
       ('Student','ROLE_STUDENT'),
       ('Administrator','ROLE_ADMIN');

insert into t_groups(end_time, group_name, start_time, course_id, employee_id)
values ();


INSERT INTO t_employees(email, full_name, password, photo)
values
('asem@gmail.com','Asem Askarova','qweqwe','img1.jpg',1),
       ('kaisar@gmail.com','Kaisar Smagul','qwerty','img1.jpg',2),
       ('admin@gmail.com','Admin','asdasd','img1.jpg',4),
       ('samat@gmail.com','Samat Amantay','zxczxc','img1.jpg',2),
       ('marzhan@gmail.com','Marzhan Kairatova','zxcvbn','img1.jpg',2);
