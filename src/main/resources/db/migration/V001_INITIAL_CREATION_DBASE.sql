-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_school;

-- Создание таблицы Product
CREATE TABLE IF NOT EXISTS my_school.student
(
    id    serial,
    name  text NOT NULL,
    email text NOT NULL,
    primary key (id)
);

-- Создание таблицы Order
CREATE TABLE IF NOT EXISTS my_school.mark
(
    id         serial,
    discipline text    NOT NULL,
    value      integer NOT NULL,
    primary key (id)
);
