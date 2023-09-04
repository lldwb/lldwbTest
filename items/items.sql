create database items;

use items;

create table Item_info
(
    Item_id     int         not null auto_increment primary key,
    Item_name   varchar(20) not null,
    Item_price  decimal     not null,
    create_time datetime    not null,
    status      int         not null
);

insert into Item_info(Item_name, Item_price, create_time, status)
values ('李狗', 12, '2023-1-1', 1);
insert into Item_info(Item_name, Item_price, create_time, status)
values ('陈强', 12, '2023-4-1', 1);
insert into Item_info(Item_name, Item_price, create_time, status)
values ('黄志豪', 12, '2023-8-1', 0);
insert into Item_info(Item_name, Item_price, create_time, status)
values ('骚憋', 6, '2023-8-1', 0);

select *
from Item_info;