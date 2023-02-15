DROP TABLE IF EXISTS users;
CREATE TABLE users (
                       user_id INT AUTO_INCREMENT  PRIMARY KEY,
                       user_name VARCHAR(50) NOT NULL,
                       user_login VARCHAR(50) NOT NULL,
                       user_password VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS quotes;
CREATE TABLE quotes (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        score_quote INT,
                        user_id INT
);
DROP TABLE IF EXISTS scores;
CREATE TABLE scores (
                        score_id INT AUTO_INCREMENT PRIMARY KEY,
                        date_score DATE,
                        history_score INT,
                        quote_id INT
);

