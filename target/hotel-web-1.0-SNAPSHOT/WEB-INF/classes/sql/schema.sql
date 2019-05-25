create database hotel_db;

create table roles
(
  role_id   bigserial   not null
    constraint roles_pkey
    primary key,
  role_name varchar(10) not null
);

create unique index roles_role_id_uindex
  on roles (role_id);

create unique index roles_role_name_uindex
  on roles (role_name);

create table users
(
  user_id  bigserial not null
    constraint entities_pkey
    primary key,
  role_id  bigint    not null
    constraint users_roles_role_id_fk
    references roles,
  email    varchar   not null,
  password varchar   not null,
  name     varchar   not null,
  surname  varchar   not null
);

create unique index entities_entity_id_uindex
  on users (user_id);

create unique index entities_email_uindex
  on users (email);

create table service_levels
(
  level_id   bigserial not null,
  class_type char(10)  not null
);

create table hotel_rooms
(
  room_id          bigserial not null
    constraint hotel_rooms_pkey
    primary key,
  number_of_places integer   not null,
  service_level    bigint    not null
    constraint hotel_rooms_service_levels_level_id_fk
    references service_levels (level_id),
  price            bigint    not null
);

create unique index hotel_rooms_room_number_uindex
  on hotel_rooms (room_id);

create unique index service_level_level_id_uindex
  on service_levels (level_id);

create unique index service_level_class_type_uindex
  on service_levels (class_type);

create table orders
(
  order_id         bigserial not null,
  user_id          bigint    not null
    constraint orders_users_user_id_fk
    references users,
  check_in_date    timestamp not null,
  check_out_date   timestamp not null,
  service_level_id bigint    not null
    constraint orders_service_levels_level_id_fk
    references service_levels (level_id),
  room_id          bigint
    constraint orders_hotel_rooms_room_id_fk
    references hotel_rooms,
  order_time       timestamp not null
);