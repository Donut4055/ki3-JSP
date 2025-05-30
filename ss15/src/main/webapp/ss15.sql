CREATE DATABASE ss15;
USE ss15;

-- Tạo bảng product
CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DECIMAL(15,2) NOT NULL,
                         description TEXT
);

-- Stored Procedure: Thêm sản phẩm
DELIMITER $$
CREATE PROCEDURE insert_product(
    IN p_name VARCHAR(255),
    IN p_price DECIMAL(15,2),
    IN p_description TEXT
)
BEGIN
    INSERT INTO product (name, price, description)
    VALUES (p_name, p_price, p_description);
END$$
DELIMITER ;

-- Stored Procedure: Sửa sản phẩm
DELIMITER $$
CREATE PROCEDURE update_product(
    IN p_id INT,
    IN p_name VARCHAR(255),
    IN p_price DECIMAL(15,2),
    IN p_description TEXT
)
BEGIN
    UPDATE product
    SET name = p_name,
        price = p_price,
        description = p_description
    WHERE id = p_id;
END$$
DELIMITER ;

-- Stored Procedure: Xóa sản phẩm
DELIMITER $$
CREATE PROCEDURE delete_product(IN p_id INT)
BEGIN
    DELETE FROM product WHERE id = p_id;
END$$
DELIMITER ;

-- Stored Procedure: Lấy tất cả sản phẩm
DELIMITER $$
CREATE PROCEDURE get_all_products()
BEGIN
    SELECT * FROM product;
END$$
DELIMITER ;

-- Stored Procedure: Lấy sản phẩm theo id
DELIMITER $$
CREATE PROCEDURE get_product_by_id(IN p_id INT)
BEGIN
    SELECT * FROM product WHERE id = p_id;
END$$
DELIMITER ;

-- Stored Procedure: Tìm kiếm sản phẩm theo tên
DELIMITER $$
CREATE PROCEDURE search_product_by_name(IN p_name VARCHAR(255))
BEGIN
    SELECT * FROM product WHERE name LIKE CONCAT('%', p_name, '%');
END$$
DELIMITER ;


CREATE TABLE review (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        idProduct INT,
                        idUser INT,
                        rating INT,
                        comment TEXT,
                        FOREIGN KEY (idProduct) REFERENCES product(id)
);

CREATE TABLE users (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      email VARCHAR(100) NOT NULL UNIQUE,
                      password VARCHAR(100) NOT NULL
);


-- Bảng giỏ hàng
CREATE TABLE IF NOT EXISTS cart (
                                    idCart INT AUTO_INCREMENT PRIMARY KEY,
                                    idUser INT NOT NULL,
                                    idProduct INT NOT NULL,
                                    quantity INT NOT NULL,
                                    FOREIGN KEY (idUser) REFERENCES users(id),
                                    FOREIGN KEY (idProduct) REFERENCES product(id)
);

-- Bảng đơn hàng
CREATE TABLE IF NOT EXISTS `order` (
                                       orderId INT AUTO_INCREMENT PRIMARY KEY,
                                       idUser INT NOT NULL,
                                       recipientName VARCHAR(255) NOT NULL,
                                       address VARCHAR(500) NOT NULL,
                                       phonenumber VARCHAR(20) NOT NULL,
                                       orderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                                       FOREIGN KEY (idUser) REFERENCES users(id)
);

-- Bảng chi tiết đơn hàng
CREATE TABLE IF NOT EXISTS order_detail (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            orderId INT NOT NULL,
                                            productId INT NOT NULL,
                                            quantity INT NOT NULL,
                                            currentPrice DECIMAL(15,2) NOT NULL,
                                            FOREIGN KEY (orderId) REFERENCES `order`(orderId),
                                            FOREIGN KEY (productId) REFERENCES product(id)
);


-- Thêm sản phẩm vào giỏ hàng
DELIMITER $$
CREATE PROCEDURE insert_cart(
    IN p_idUser INT,
    IN p_idProduct INT,
    IN p_quantity INT
)
BEGIN
    DECLARE existing INT;
    SELECT COUNT(*) INTO existing FROM cart WHERE idUser = p_idUser AND idProduct = p_idProduct;
    IF existing > 0 THEN
        UPDATE cart SET quantity = quantity + p_quantity WHERE idUser = p_idUser AND idProduct = p_idProduct;
    ELSE
        INSERT INTO cart (idUser, idProduct, quantity) VALUES (p_idUser, p_idProduct, p_quantity);
    END IF;
END$$
DELIMITER ;

-- Lấy giỏ hàng theo idUser
DELIMITER $$
CREATE PROCEDURE get_cart_by_user(IN p_idUser INT)
BEGIN
    SELECT c.idCart, c.idUser, c.idProduct, c.quantity, p.name, p.price
    FROM cart c JOIN product p ON c.idProduct = p.id
    WHERE c.idUser = p_idUser;
END$$
DELIMITER ;

-- Xóa sản phẩm khỏi giỏ hàng
DELIMITER $$
CREATE PROCEDURE delete_cart_item(IN p_idCart INT)
BEGIN
    DELETE FROM cart WHERE idCart = p_idCart;
END$$
DELIMITER ;

-- Thêm đơn hàng
DELIMITER $$
CREATE PROCEDURE insert_order(
    IN p_idUser INT,
    IN p_recipientName VARCHAR(255),
    IN p_address VARCHAR(500),
    IN p_phonenumber VARCHAR(20),
    OUT p_orderId INT
)
BEGIN
    INSERT INTO `order` (idUser, recipientName, address, phonenumber) VALUES (p_idUser, p_recipientName, p_address, p_phonenumber);
    SET p_orderId = LAST_INSERT_ID();
END$$
DELIMITER ;

-- Thêm chi tiết đơn hàng
DELIMITER $$
CREATE PROCEDURE insert_order_detail(
    IN p_orderId INT,
    IN p_productId INT,
    IN p_quantity INT,
    IN p_currentPrice DECIMAL(15,2)
)
BEGIN
    INSERT INTO order_detail (orderId, productId, quantity, currentPrice) VALUES (p_orderId, p_productId, p_quantity, p_currentPrice);
END$$
DELIMITER ;

-- Lấy danh sách đơn hàng theo idUser
DELIMITER $$
CREATE PROCEDURE get_orders_by_user(IN p_idUser INT)
BEGIN
    SELECT * FROM `order` WHERE idUser = p_idUser ORDER BY orderDate DESC;
END$$
DELIMITER ;

-- Lấy chi tiết đơn hàng
DELIMITER $$
CREATE PROCEDURE get_order_details(IN p_orderId INT)
BEGIN
    SELECT od.id, od.orderId, od.productId, od.quantity, od.currentPrice, p.name
    FROM order_detail od
             JOIN product p ON od.productId = p.id
    WHERE od.orderId = p_orderId;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE find_order_by_id(IN p_orderId INT)
BEGIN
    SELECT * FROM `order` WHERE orderId = p_orderId;
END$$
DELIMITER ;


CREATE TABLE cv (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        full_name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        phone_number VARCHAR(20) NOT NULL,
                        education VARCHAR(255),
                        experience TEXT,
                        skills TEXT
);
DELIMITER $$
CREATE PROCEDURE insert_cv(
    IN p_full_name VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_phone_number VARCHAR(20),
    IN p_education VARCHAR(255),
    IN p_experience TEXT,
    IN p_skills TEXT
)
BEGIN
    INSERT INTO cv (full_name, email, phone_number, education, experience, skills)
    VALUES (p_full_name, p_email, p_phone_number, p_education, p_experience, p_skills);
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE update_cv(
    IN p_id BIGINT,
    IN p_full_name VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_phone_number VARCHAR(20),
    IN p_education VARCHAR(255),
    IN p_experience TEXT,
    IN p_skills TEXT
)
BEGIN
    UPDATE cv
    SET full_name = p_full_name,
        email = p_email,
        phone_number = p_phone_number,
        education = p_education,
        experience = p_experience,
        skills = p_skills
    WHERE id = p_id;
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE delete_cv(
    IN p_id BIGINT
)
BEGIN
    DELETE FROM cv WHERE id = p_id;
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE get_cv_by_id(
    IN p_id BIGINT
)
BEGIN
    SELECT * FROM cv WHERE id = p_id;
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE get_all_cvs()
BEGIN
    SELECT * FROM cv;
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE search_cv(
    IN p_keyword VARCHAR(255)
)
BEGIN
    SELECT * FROM cv
    WHERE full_name LIKE CONCAT('%', p_keyword, '%')
       OR email LIKE CONCAT('%', p_keyword, '%');
END$$
DELIMITER ;
