/*one to one*/
create table bank_accounts
(
    id     int primary key auto_increment,
    number varchar(5) not null
);

create table person
(
    id        int primary key auto_increment,
    firstname varchar(15) not null,
    lastname  varchar(15) not null,
    number_id int,
    constraint person_fk
        foreign key (number_id) references bank_accounts (id)
);

insert into bank_accounts value (null,"55555"),
(null,"11111"),
(null,"12345");

insert into person value (null, "Make", "Smit", 1),
(null, "Kate", "Klipp", 2),
(null, "Peter", "M.", 3),
(null, "Filip", "J.", null);

select p.firstname, p.lastname, ba.number
from person p
         left join bank_accounts ba
                   on p.number_id = ba.id;

