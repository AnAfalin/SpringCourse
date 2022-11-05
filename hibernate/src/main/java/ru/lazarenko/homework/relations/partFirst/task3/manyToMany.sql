/*many to many*/
create table products
(
    id    int primary key auto_increment,
    title varchar(20) not null,
    price int         not null
);

create table buyers
(
    id   int primary key auto_increment,
    name varchar(20) not null,
    city varchar(10) not null
);

create table products_buyers
(
    product_id int,
    buyer_id   int,
    primary key (product_id, buyer_id),
    constraint product_fk
        foreign key (product_id) references buyers (id),
    constraint buyer_fk
        foreign key (buyer_id) references products (id)
);

insert into products
values (null, "TV", 50000),
       (null, "iPhone", 100000),
       (null, "Laptop", 150000);

insert into buyers
values (null, "Mike", "Moscow"),
       (null, "Kate", "Sochi"),
       (null, "Peter", "Saratov"),
       (null, "Sveta", "SP");

insert into products_buyers
values (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 3);

select b.name as "name buyer", b.city, p.title, p.price
from buyers b
         inner join products_buyers pd
                    on b.id = pd.buyer_id
         inner join products p
                    on pd.buyer_id = p.id;
 