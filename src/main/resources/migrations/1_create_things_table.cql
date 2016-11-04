-- description: create things table
-- authoredAt: 1478273004000
-- up:

CREATE TABLE things (
  id int,
  name text,
  PRIMARY KEY (id)
);

-- down:

DROP TABLE things;
