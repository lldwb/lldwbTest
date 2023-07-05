create
database bookcard;

use
bookcard;

create table bookcard_info
(
    cid         int         not null auto_increment primary key,
    name        varchar(20) not null,
    sex         char(1)     not null,
    create_date datetime    not null,
    deposit     decimal     not null
);

insert into bookcard_info(name, sex, create_date, deposit)
values ('李狗', '男', '2023-1-1', 33.2);
insert into bookcard_info(name, sex, create_date, deposit)
values ('陈强', '男', '2023-4-1', 33.2);
insert into bookcard_info(name, sex, create_date, deposit)
values ('黄志豪', '男', '2023-8-1', 33.2);

select * from bookcard_info;