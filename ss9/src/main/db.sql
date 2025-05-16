CREATE DATABASE IF NOT EXISTS movie_booking_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE movie_booking_db;

-- Bảng Customer
CREATE TABLE IF NOT EXISTS Customer (
                                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                        username VARCHAR(100) NOT NULL UNIQUE,
                                        phone VARCHAR(20),
                                        address VARCHAR(255),
                                        gender VARCHAR(10),
                                        email VARCHAR(100) UNIQUE
);

-- Bảng Users cho đăng nhập
CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     username VARCHAR(50) NOT NULL UNIQUE,
                                     password VARCHAR(255) NOT NULL,
                                     email VARCHAR(100) UNIQUE,
                                     role VARCHAR(20) DEFAULT 'USER',
                                     enabled BOOLEAN DEFAULT TRUE
);

-- Bảng Movie
CREATE TABLE IF NOT EXISTS Movie (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     title VARCHAR(200) NOT NULL,
                                     director VARCHAR(100),
                                     genre VARCHAR(100),
                                     description TEXT,
                                     duration INT, -- phút
                                     language VARCHAR(50)
);

-- Bảng ScreenRoom (phòng chiếu)
CREATE TABLE IF NOT EXISTS ScreenRoom (
                                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                          name VARCHAR(100) NOT NULL,
                                          capacity INT NOT NULL
);

-- Bảng Schedule (lịch chiếu)
CREATE TABLE IF NOT EXISTS Schedule (
                                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                        movie_id BIGINT NOT NULL,
                                        screen_room_id BIGINT NOT NULL,
                                        show_time DATETIME NOT NULL,
                                        FOREIGN KEY (movie_id) REFERENCES Movie(id),
                                        FOREIGN KEY (screen_room_id) REFERENCES ScreenRoom(id),
                                        format VARCHAR(10) NOT NULL DEFAULT '2D'
);

-- Bảng Seat (ghế)
CREATE TABLE IF NOT EXISTS Seat (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    seat_number VARCHAR(10) NOT NULL,
                                    is_booked BOOLEAN DEFAULT FALSE
);

-- Bảng trung gian ScreenRoom_Seat (mapping ghế - phòng chiếu)
CREATE TABLE IF NOT EXISTS ScreenRoom_Seat (
                                               screen_room_id BIGINT NOT NULL,
                                               seat_id BIGINT NOT NULL,
                                               PRIMARY KEY(screen_room_id, seat_id),
                                               FOREIGN KEY (screen_room_id) REFERENCES ScreenRoom(id),
                                               FOREIGN KEY (seat_id) REFERENCES Seat(id)
);

-- Bảng Ticket (vé)
CREATE TABLE IF NOT EXISTS Ticket (
                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                      customer_id BIGINT NOT NULL,
                                      schedule_id BIGINT NOT NULL,
                                      seat_id BIGINT NOT NULL,
                                      price DECIMAL(10,2) NOT NULL,
                                      FOREIGN KEY (customer_id) REFERENCES Customer(id),
                                      FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
                                      FOREIGN KEY (seat_id) REFERENCES Seat(id)
);

DELIMITER //

-- Stored Procedure: Lấy tất cả phim
CREATE PROCEDURE get_all_movies()
BEGIN
    SELECT id, title, director, genre, description, duration, language FROM Movie;
END //

-- Stored Procedure: Lấy phim theo ID
CREATE PROCEDURE get_movie_by_id(IN p_id BIGINT)
BEGIN
    SELECT id, title, director, genre, description, duration, language FROM Movie WHERE id = p_id;
END //

-- Stored Procedure: Lấy tất cả phòng chiếu
CREATE PROCEDURE get_all_screen_rooms()
BEGIN
    SELECT id, name, capacity FROM ScreenRoom;
END //

-- Stored Procedure: Lấy lịch chiếu theo phim
CREATE PROCEDURE get_schedules_by_movie(IN p_movie_id BIGINT)
BEGIN
    SELECT s.id, s.show_time, sr.id AS screen_room_id, sr.name AS screen_room_name
    FROM Schedule s
             JOIN ScreenRoom sr ON s.screen_room_id = sr.id
    WHERE s.movie_id = p_movie_id
    ORDER BY s.show_time;
END //

-- Stored Procedure: Lấy ghế theo phòng chiếu
CREATE PROCEDURE get_seats_by_screen_room(IN p_screen_room_id BIGINT)
BEGIN
    SELECT st.id, st.seat_number, st.is_booked
    FROM Seat st
             JOIN ScreenRoom_Seat srs ON st.id = srs.seat_id
    WHERE srs.screen_room_id = p_screen_room_id
    ORDER BY st.seat_number;
END //

-- Stored Procedure: Lấy ghế đã đặt theo lịch chiếu
CREATE PROCEDURE get_booked_seats_by_schedule(IN p_schedule_id BIGINT)
BEGIN
    SELECT seat_id FROM Ticket WHERE schedule_id = p_schedule_id;
END //

-- Stored Procedure: Đặt vé mới (insert vé và cập nhật trạng thái ghế)
CREATE PROCEDURE book_ticket(
    IN p_customer_id BIGINT,
    IN p_schedule_id BIGINT,
    IN p_seat_id BIGINT,
    IN p_price DOUBLE
)
BEGIN
    INSERT INTO Ticket(customer_id, schedule_id, seat_id, price)
    VALUES(p_customer_id, p_schedule_id, p_seat_id, p_price);
    UPDATE Seat SET is_booked = TRUE WHERE id = p_seat_id;
END //

-- Stored Procedure: Thêm khách hàng mới
CREATE PROCEDURE add_customer(
    IN p_username VARCHAR(100),
    IN p_phone VARCHAR(20),
    IN p_address VARCHAR(255),
    IN p_gender VARCHAR(10),
    IN p_email VARCHAR(100)
)
BEGIN
    INSERT INTO Customer(username, phone, address, gender, email)
    VALUES(p_username, p_phone, p_address, p_gender, p_email);
END //

-- Stored Procedure: Tìm người dùng đăng nhập (users table)
CREATE PROCEDURE find_user_login(
    IN p_username VARCHAR(100),
    IN p_password VARCHAR(255)
)
BEGIN
    SELECT * FROM users WHERE username = p_username AND password = p_password AND enabled = TRUE;
END //

DELIMITER ;

INSERT INTO Movie (title, director, genre, description, duration, language) VALUES
                                                                                ('Inception', 'Christopher Nolan', 'Sci-Fi/Action',
                                                                                 'A thief who steals corporate secrets through dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.',
                                                                                 148, 'English'),
                                                                                ('Parasite', 'Bong Joon Ho', 'Thriller/Drama',
                                                                                 'Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.',
                                                                                 132, 'Korean'),
                                                                                ('Interstellar', 'Christopher Nolan', 'Sci-Fi/Adventure',
                                                                                 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.',
                                                                                 169, 'English'),
                                                                                ('The Dark Knight', 'Christopher Nolan', 'Action/Crime',
                                                                                 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.',
                                                                                 152, 'English'),
                                                                                ('Avengers: Endgame', 'Anthony and Joe Russo', 'Action/Superhero',
                                                                                 'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. The remaining Avengers assemble once more in order to reverse Thanos'' actions and restore balance to the universe.',
                                                                                 181, 'English');

DROP PROCEDURE IF EXISTS get_schedules_by_movie;
DELIMITER //
CREATE PROCEDURE get_schedules_by_movie(IN p_movie_id BIGINT)
BEGIN
    SELECT
        s.id                                AS id,
        m.title                             AS movieTitle,
        s.show_time                         AS show_time,
        sr.id                               AS screen_room_id,
        sr.name                             AS screen_room_name,
        (sr.capacity
            - COALESCE((SELECT COUNT(*) FROM Ticket t WHERE t.schedule_id = s.id),0)
            )                                   AS availableSeats
    FROM Schedule s
             JOIN Movie      m  ON s.movie_id       = m.id
             JOIN ScreenRoom sr ON s.screen_room_id = sr.id
    WHERE s.movie_id = p_movie_id
    ORDER BY s.show_time;
END //
DELIMITER ;


-- 1. Khách hàng mẫu
INSERT INTO Customer (username, phone, address, gender, email) VALUES
                                                                   ('john_doe', '0123456789', '123 Main St', 'Male', 'john@example.com'),
                                                                   ('jane_smith', '0987654321', '456 Oak Ave', 'Female', 'jane@example.com');

-- 2. User mẫu (cho đăng nhập)
-- Lưu ý: mật khẩu ở đây là plaintext "password123", bạn nên mã hóa trong thực tế
INSERT INTO users (username, password, email, role, enabled) VALUES
                                                                 ('john_doe', 'password123', 'john@example.com', 'USER', TRUE),
                                                                 ('admin',    'adminpass',   'admin@theater.com', 'ADMIN', TRUE);

-- 3. Phim mẫu
INSERT INTO Movie (title, director, genre, description, duration, language) VALUES
                                                                                ('Inception', 'Christopher Nolan', 'Sci-Fi/Action',
                                                                                 'A thief who steals corporate secrets through dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.',
                                                                                 148, 'English'),
                                                                                ('Parasite', 'Bong Joon Ho', 'Thriller/Drama',
                                                                                 'Greed and class discrimination threaten the newly formed symbiotic relationship between two families.',
                                                                                 132, 'Korean'),
                                                                                ('Interstellar', 'Christopher Nolan', 'Sci-Fi/Adventure',
                                                                                 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.',
                                                                                 169, 'English');

-- 4. Phòng chiếu mẫu
INSERT INTO ScreenRoom (name, capacity) VALUES
                                            ('Room 1', 10),
                                            ('Room 2', 12);

-- 5. Ghế mẫu (A1–A5, B1–B5 cho mỗi phòng)
-- Tạo tổng 10 ghế; sẽ map vào phòng qua ScreenRoom_Seat
INSERT INTO Seat (seat_number) VALUES
                                   ('A1'),('A2'),('A3'),('A4'),('A5'),
                                   ('B1'),('B2'),('B3'),('B4'),('B5');

-- 6. Map ghế vào phòng chiếu
-- Giả sử ghế 1–5 cho Room 1; 6–10 cho Room 2
INSERT INTO ScreenRoom_Seat (screen_room_id, seat_id) VALUES
                                                          (1,1),(1,2),(1,3),(1,4),(1,5),
                                                          (2,6),(2,7),(2,8),(2,9),(2,10);

-- 7. Lịch chiếu mẫu
-- Chèn một số lịch chiếu cho từng phim
INSERT INTO Schedule (movie_id, screen_room_id, show_time) VALUES
                                                               (1, 1, '2025-06-01 18:00:00'),
                                                               (1, 2, '2025-06-01 20:30:00'),
                                                               (2, 1, '2025-06-02 17:00:00'),
                                                               (2, 2, '2025-06-02 19:30:00'),
                                                               (3, 1, '2025-06-03 16:00:00');

-- 8. Vé mẫu (có thể để trống hoặc tạo ví dụ)
-- Ví dụ: John đặt vé ghế A1 cho lịch 1
INSERT INTO Ticket (customer_id, schedule_id, seat_id, price) VALUES
    (1, 1, 1, 100.00);

-- Cập nhật ghế A1 thành đã đặt
UPDATE Seat SET is_booked = TRUE WHERE id = 1;
