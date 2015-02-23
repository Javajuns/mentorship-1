CREATE TABLE orders(
  id INT PRIMARY KEY AUTO_INCREMENT,
  date_created DATE,
  user_id INT,
  goods_id INT,
  amount DOUBLE
  );