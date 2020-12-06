INSERT INTO users (id, name, email, password ) VALUES (1, 'Nick', 'nick@mail.com', '$2a$10$CJg');

INSERT INTO posts (id, owner_id, description) VALUES (1, 1, 'Hello World');
INSERT INTO posts (id, owner_id, description) VALUES (2, 1, 'Hi there');

INSERT INTO photos (id, uri, post_id) VALUES (1, 'photo1.jpg', 2);
INSERT INTO photos (id, uri, post_id) VALUES (2, 'photo2.jpg', 1);