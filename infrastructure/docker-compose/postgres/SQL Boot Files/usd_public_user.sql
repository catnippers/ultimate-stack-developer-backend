create table "user"
(
    id       bigint       not null
        constraint user_pk
            primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    role     varchar(255) not null,
    email    varchar(255) not null
);

alter table "user"
    owner to postgres;

create unique index user_id_uindex
    on "user" (id);

INSERT INTO public."user" (id, username, password, role, email) VALUES (31, 'tbuga', '4dm1n?!', 'admin', 'kontakt@tomaszbuga.pl');