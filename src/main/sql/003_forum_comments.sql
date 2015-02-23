CREATE TABLE forum_comments(
  id INT PRIMARY KEY auto_increment ,
  user_id	 INT,
  topic_id INT,
  msg VARCHAR(255)
);