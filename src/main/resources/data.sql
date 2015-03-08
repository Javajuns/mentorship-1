INSERT INTO category (id, name, parent_id) VALUES (1, 'Phones', null);
INSERT INTO category (id, name, parent_id) VALUES (2, 'Computers', NULL);
INSERT INTO category (id, name, parent_id) VALUES (3, 'Cars', NULL);
INSERT INTO users (login, date_created) VALUES ('ivan', '2015-03-17');
INSERT INTO users (login, first_name, second_name, email, date_created, is_admin)
VALUES ('prof', 'oleksiy', 'ostanin', 'tnd.prof@gmail.com', '2015-03-06', 1);
INSERT INTO goods (name, category_id) VALUES ('Lenovo t520', 1);
INSERT INTO goods (name, category_id) VALUES ('Asus K53SM', 1);
INSERT INTO goods (name, category_id) VALUES ('Samsung galaxy s4', 2);
INSERT INTO goods (name, category_id) VALUES ('Samsung galaxy s3', 2);
INSERT INTO goods (name, category_id) VALUES ('Audi S4', 3);
INSERT INTO goods (name, category_id) VALUES ('Porshe Carrera 911', 3);
