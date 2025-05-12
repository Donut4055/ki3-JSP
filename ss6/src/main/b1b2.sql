CREATE DATABASE library;
USE library;

CREATE TABLE books (
                       book_code   VARCHAR(20) PRIMARY KEY,
                       title       VARCHAR(200) NOT NULL,
                       author      VARCHAR(100) NOT NULL,
                       category    VARCHAR(50),
                       quantity    INT NOT NULL
);

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(100),
                       phone VARCHAR(20)
);


DELIMITER //
CREATE PROCEDURE sp_insert_book(
    IN p_code VARCHAR(20), IN p_title VARCHAR(200),
    IN p_author VARCHAR(100), IN p_category VARCHAR(50),
    IN p_quantity INT
)
BEGIN
    INSERT INTO books(book_code,title,author,category,quantity)
    VALUES(p_code,p_title,p_author,p_category,p_quantity);
END;
//

CREATE PROCEDURE sp_select_all_books()
BEGIN
    SELECT * FROM books;
END;
//

CREATE PROCEDURE sp_select_book(IN p_code VARCHAR(20))
BEGIN
    SELECT * FROM books WHERE book_code = p_code;
END;
//

CREATE PROCEDURE sp_update_book(
    IN p_code VARCHAR(20), IN p_title VARCHAR(200),
    IN p_author VARCHAR(100), IN p_category VARCHAR(50),
    IN p_quantity INT
)
BEGIN
    UPDATE books
    SET title = p_title,
        author = p_author,
        category = p_category,
        quantity = p_quantity
    WHERE book_code = p_code;
END;
//

CREATE PROCEDURE sp_delete_book(IN p_code VARCHAR(20))
BEGIN
    DELETE FROM books WHERE book_code = p_code;
END;
//

CREATE PROCEDURE sp_search_books(IN p_kw VARCHAR(200))
BEGIN
    SELECT *
    FROM books
    WHERE title LIKE p_kw OR book_code = p_kw;
END;
//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_insert_user(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255),
    IN p_email    VARCHAR(100),
    IN p_phone    VARCHAR(20)
)
BEGIN
    INSERT INTO users(username, password, email, phone)
    VALUES(p_username, p_password, p_email, p_phone);
END;
//

-- 3. Stored procedure để lấy user theo username
CREATE PROCEDURE sp_select_user_by_username(
    IN p_username VARCHAR(50)
)
BEGIN
    SELECT id, username, password, email, phone
    FROM users
    WHERE username = p_username;
END;
//
DELIMITER ;