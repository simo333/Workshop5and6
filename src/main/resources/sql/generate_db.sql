CREATE DATABASE workshop5
    CHARACTER SET utf8
    COLLATE utf8mb4_unicode_ci;

CREATE TABLE books
(
    id        int auto_increment primary key,
    isbn      varchar(255),
    title     varchar(255),
    author    varchar(255),
    publisher varchar(255),
    type      varchar(255)
);

