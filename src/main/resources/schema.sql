CREATE SCHEMA netology;

CREATE TABLE netology.customers
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    surname VARCHAR(20),
    age INTEGER,
    phone_number VARCHAR(16)
);

CREATE TABLE netology.orders
(
    id SERIAL PRIMARY KEY,
    date DATE,
    customer_id INTEGER REFERENCES netology.customers (id),
    product_name VARCHAR(20),
    amount DECIMAL
);

INSERT INTO netology.customers (name, surname, age, phone_number)
VALUES ('Alexey', ' Alexeev', 18, '+7 909 854 45 78'),
       ('Ivan', 'Ivanov', 19, '+7 910 126 45 87'),
       ('Petr', 'Petrov', 20, '+7 911 123 65 54'),
       ('alexey', 'petrov', 21, '+7 912 654 78 45'),
       ('ivan', 'Alexeev', 22, '+7 913 978 12 54'),
       ('PETR', 'ivaNOv', 23, '+7 914 321 45 87');

INSERT INTO netology.orders (date, customer_id, product_name, amount)
VALUES ('2023-05-23', 1, 'milk', 45.5),
       ('2023-05-27', 2, 'bread', 25.0),
       ('2023-05-25', 3, 'eggs', 19.99),
       ('2023-05-25', 1, 'cheese', 125.4),
       ('2023-05-24', 4, 'water', 33.54),
       ('2023-05-31', 4, 'chips', 149.0),
       ('2023-05-16', 6, 'beer', 66.6),
       ('2023-05-10', 5, 'tomatoes', 35.8),
       ('2023-05-14', 1, 'onion', 6.52),
       ('2023-05-25', 4, 'apple', 12.25);
