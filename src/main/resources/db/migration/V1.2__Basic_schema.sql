create table user_app
(
    id       serial primary key,
    username varchar not null check ( length(trim(username)) > 0 ) unique,
    password varchar
);

create table authority
(
    id        serial primary key,
    authority varchar not null check ( length(trim(authority)) > 0 ) unique
);

create table user_authority
(
    id           serial primary key,
    id_user      int not null references user_app (id),
    id_authority int not null references authority (id),
    constraint uk_user_app_authority unique (id_user, id_authority)
);