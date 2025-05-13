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
CREATE TABLE employees (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         name VARCHAR(100) NOT NULL,
                                         email VARCHAR(100) NOT NULL UNIQUE,
                                         phone VARCHAR(20),
                                         position VARCHAR(50),
                                         birthday DATE,
                                         salary DOUBLE
);
CREATE TABLE products (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL,
                                        price DOUBLE NOT NULL,
                                        imageUrl VARCHAR(255)
);
CREATE TABLE product_cart (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            productId INT NOT NULL,
                                            quantity INT NOT NULL,
                                            FOREIGN KEY (productId) REFERENCES products(id) ON DELETE CASCADE
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

DELIMITER //

CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT id, name, price, imageUrl FROM products;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE AddProductToCart(IN productId INT, IN quantity INT)
BEGIN
    INSERT INTO product_cart (productId, quantity)
    VALUES (productId, quantity);
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE RemoveProductFromCart(IN productCartId INT)
BEGIN
    DELETE FROM product_cart WHERE id = productCartId;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE get_all_product_cart()
BEGIN
    SELECT pc.id, pc.productId, pc.quantity, p.name, p.price, p.imageUrl
    FROM product_cart pc
             JOIN products p ON pc.productId = p.id;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE GetProductById(IN productId INT)
BEGIN
    SELECT id, name, price, imageUrl FROM products WHERE id = productId;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE findAllEmployee()
BEGIN
    SELECT id, name, email, phone, position, birthday, salary FROM employees;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE add_employee(
    IN empName VARCHAR(100),
    IN empEmail VARCHAR(100),
    IN empPhone VARCHAR(20),
    IN empPosition VARCHAR(50),
    IN empBirthday DATE,
    IN empSalary DOUBLE
)
BEGIN
    INSERT INTO employees (name, email, phone, position, birthday, salary)
    VALUES (empName, empEmail, empPhone, empPosition, empBirthday, empSalary);
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE findEmployeeById(IN empId INT)
BEGIN
    SELECT id, name, email, phone, position, birthday, salary
    FROM employees WHERE id = empId;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE updateEmployeeById(
    IN empId INT,
    IN empName VARCHAR(100),
    IN empEmail VARCHAR(100),
    IN empPhone VARCHAR(20),
    IN empPosition VARCHAR(50),
    IN empBirthday DATE,
    IN empSalary DOUBLE
)
BEGIN
    UPDATE employees
    SET name = empName, email = empEmail, phone = empPhone,
        position = empPosition, birthday = empBirthday, salary = empSalary
    WHERE id = empId;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE deleteEmployeeById(IN empId INT)
BEGIN
    DELETE FROM employees WHERE id = empId;
END //

DELIMITER ;


