INSERT INTO category (id, name, parent_id) VALUES (1, 'Phones', null);
INSERT INTO category (id, name, parent_id) VALUES (2, 'Computers', NULL);
INSERT INTO category (id, name, parent_id) VALUES (3, 'Cars', NULL);
INSERT INTO users (date_created, login, first_name, second_name, email, is_admin) VALUES ('2015-03-17', 'ivan', 'Ivan', 'Kovalenko', 'ivan@example.com', false);
INSERT INTO users (date_created, login, first_name, second_name, email, is_admin) VALUES ('2015-03-06', 'prof', 'oleksiy', 'ostanin', 'tnd.prof@gmail.com', true);
INSERT INTO goods (name, category_id, price) VALUES ('Lenovo t520', 2, 2600);
INSERT INTO goods (name, category_id, price) VALUES ('Asus K53SM', 2, 2000);
INSERT INTO goods (name, category_id, price) VALUES ('Samsung galaxy s4', 1, 600);
INSERT INTO goods (name, category_id, price) VALUES ('Samsung galaxy s3', 1, 550);
INSERT INTO goods (name, category_id, price) VALUES ('Audi S4', 3, 60000);
INSERT INTO goods (name, category_id, price) VALUES ('Porshe Carrera 911', 3, 30000.0);
