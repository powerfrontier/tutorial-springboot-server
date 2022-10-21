INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);

INSERT INTO CUSTOMER(id, name) VALUES (1, 'Alberto');
INSERT INTO CUSTOMER(id, name) VALUES (2, 'Manuel');
INSERT INTO CUSTOMER(id, name) VALUES (3, 'Andrés');
INSERT INTO CUSTOMER(id, name) VALUES (4, 'Laia');
INSERT INTO CUSTOMER(id, name) VALUES (5, 'Esteban');
INSERT INTO CUSTOMER(id, name) VALUES (6, 'Rosa');

INSERT INTO BORROW(id, game_id, customer_id, start_date, finish_date) VALUES (1, 1, 1, '2022-10-01', '2022-10-04');
INSERT INTO BORROW(id, game_id, customer_id, start_date, finish_date) VALUES (2, 2, 2, '2022-10-03', '2022-10-06');
INSERT INTO BORROW(id, game_id, customer_id, start_date, finish_date) VALUES (3, 2, 1, '2022-01-01', '2022-01-23');
INSERT INTO BORROW(id, game_id, customer_id, start_date, finish_date) VALUES (4, 2, 5, '2022-12-09', '2022-12-16');
INSERT INTO BORROW(id, game_id, customer_id, start_date, finish_date) VALUES (5, 3, 1, '2022-05-01', '2022-06-04');
INSERT INTO BORROW(id, game_id, customer_id, start_date, finish_date) VALUES (6, 3, 3, '2022-11-01', '2022-11-04');

