-- INIT DATABASE

DROP TABLE IF EXISTS app_user;

CREATE TABLE IF NOT EXISTS app_user (
    user_id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'USER') NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO app_user (user_id, username, password, role, creation_date) VALUES
(1001, 'user1', 'password1', 'USER', NOW()),
(1002, 'user2', 'password2', 'USER', NOW()),
(1003, 'admin', 'pass', 'ADMIN', NOW());

INSERT INTO todo_item (todo_id, user_id, title, description, completed) VALUES
(2001, 1001, 'Buy groceries', 'Milk, Bread, Eggs', FALSE),
(2002, 1002, 'Read book', 'Finish reading the novel', FALSE),
(2003, 1003, 'Workout', NULL, TRUE);
