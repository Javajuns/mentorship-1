CREATE TABLE forum_topics (
  id INTEGER IDENTITY,
  subject VARCHAR(35),
  text VARCHAR(255),
  is_closed INT,
  date_created DATE
);