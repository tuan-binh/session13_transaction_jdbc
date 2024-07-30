create database my_candidate;
use my_candidate;

create table candidates
(
    id         int auto_increment primary key,
    first_name varchar(50),
    last_name  varchar(50),
    dob        date,
    phone      varchar(11),
    email      varchar(100)
);

create table skills
(
    id   int auto_increment primary key,
    name varchar(100)
);

create table candidate_skill
(
    candidate_id int,
    skill_id     int,
    primary key (candidate_id, skill_id),
    foreign key (candidate_id) references candidates (id),
    foreign key (skill_id) references skills (id)
);

# procedure thêm mới ứng viên và trả về id vừa mới thêm (1 tham số out)
delimiter //
create procedure INSERT_CANDIDATE(newFirstName varchar(50), newLastName varchar(50), newDOB date, newPhone varchar(11),
                                  newEmail varchar(100), skillId int)
begin

    insert into candidates (first_name, last_name, dob, phone, email)
    values (newFirstName, newLastName, newDOB, newPhone, newEmail);


    insert into candidate_skill values (last_insert_id(), skillId);
end
//

call INSERT_CANDIDATE('hải','trần','2024-07-30','03698521447','hai@gmail.com',1);
