CREATE TABLE orders(
  id INT PRIMARY KEY AUTO_INCREMENT,
  date_created DATE,
  user_id INT,
  goods_id INT,
  amount DOUBLE
  );

ALTER TABLE orders ADD CONSTRAINT fk_orders_id
FOREIGN KEY (orders_id)
REFERENCES PUBLIC.ORDERS(id);

