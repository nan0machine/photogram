INSERT INTO users (id, name, email, password, role) VALUES (70, 'Nick', 'nick@mail.com', '$2y$12$tr1bSiBILQw9xEngXXr6gOBQDmR7QF0vADS5DCKfHXfymoKTnFbFi', 'USER');

INSERT INTO posts (id, owner_id, description, photo_name) VALUES (70, 70, 'Hello World', 'photo1.jpg');
INSERT INTO posts (id, owner_id, description, photo_name) VALUES (71, 70, 'Hi there', 'photo2.jpg');
