CREATE TABLE users (
   id  INT PRIMARY KEY AUTO_INCREMENT,
   login VARCHAR(35),
   first_name VARCHAR(35),
   second_name VARCHAR(35),
   email VARCHAR(35),
   date_created DATE,
   is_admin INT
);


CREATE TABLE orders(
  FOREIGN KEY (id)
  user_id INT,
  goods_id INT,
  amount INT
  );