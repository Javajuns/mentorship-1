CREATE TABLE orders(
  id INT PRIMARY KEY,
  date_created DATE,
  user_id INT,
  goods_id INT,
  amount DOUBLE
  );

ALTER TABLE orders ADD CONSTRAINT fk_goods_id
FOREIGN KEY (goods_id)
REFERENCES PUBLIC.goods(id);

