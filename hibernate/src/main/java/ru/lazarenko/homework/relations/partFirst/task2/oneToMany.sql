/*one to many*/
create table categories
(
    id   int primary key auto_increment,
    name varchar(15)
);

create table products
(
    id          int primary key auto_increment,
    title       varchar(30) not null,
    price       double      not NULL,
    category_id int,
    constraint category_fk
        foreign key (category_id) references categories (id)
);

insert into categories value (null, "Auto"),
(null, "Food");

insert into products value (null, "BMW", 500000, 1),
(null, "VW", 100000, 1),
(null, "Chocolate", 100, 2),
(null, "Scoda", 10000, null),
(null, "Scoda", 350000, 1),
(null, "Bread", 50, 2);

select c.name as "category", p.title, p.price
from categories c
         right join products p
                    on p.category_id = c.id;
