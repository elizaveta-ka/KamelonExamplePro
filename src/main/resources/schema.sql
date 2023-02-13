DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      user_name VARCHAR(50) NOT NULL,
                      user_login VARCHAR(50) NOT NULL,
                      user_password VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS Quotes;
CREATE TABLE Quotes (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       score_quote INT,
                       user_id INT
);