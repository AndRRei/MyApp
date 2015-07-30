drop table users
create table users(
id serial unique not null,
username varchar(100) unique not null,
password varchar(100) unique not null,
enabled integer,
role_id integer references roles(id),
primary key (id)
);
drop table roles
create table roles(
id serial unique not null,
role varchar(20) unique not null,
primary key (id)
);