CREATE TABLE forum_comments(
  id INT PRIMARY KEY,
  user_id	 INT,
  topic_id INT,
  msg VARCHAR(255),
  date_created DATE
);

ALTER TABLE forum_comments ADD CONSTRAINT fk_user_id
FOREIGN KEY (user_id)
REFERENCES PUBLIC.users(id);

ALTER TABLE forum_comments ADD CONSTRAINT fk_topic_id
FOREIGN KEY (topic_id)
REFERENCES PUBLIC.forum_topics(id);

CREATE INDEX idx_user_id ON forum_comments(user_id);

CREATE INDEX idx_topic_id ON forum_comments(topic_id);
