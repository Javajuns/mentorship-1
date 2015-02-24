CREATE TABLE goods (
  id          INT PRIMARY KEY,
  name        VARCHAR(255),
  price       DOUBLE,
  category_id INT,
  rest        DOUBLE
);

ALTER TABLE goods ADD CONSTRAINT fk_category_id
FOREIGN KEY (category_id)
REFERENCES PUBLIC.CATEGORY (id);

CREATE INDEX idx_name ON goods (name);
