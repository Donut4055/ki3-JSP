create database bt10;
use bt10;

CREATE TABLE movie (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       director VARCHAR(50) NOT NULL,
                       release_date DATE NOT NULL,
                       genre VARCHAR(30) NOT NULL,
                       poster VARCHAR(255)
);

-- Thêm phim mới
DELIMITER $$
CREATE PROCEDURE insert_movie(
    IN p_title VARCHAR(100),
    IN p_director VARCHAR(50),
    IN p_release_date DATE,
    IN p_genre VARCHAR(30),
    IN p_poster VARCHAR(255)
)
BEGIN
    INSERT INTO movie (title, director, release_date, genre, poster)
    VALUES (p_title, p_director, p_release_date, p_genre, p_poster);
END$$
DELIMITER ;

-- Sửa phim
DELIMITER $$
CREATE PROCEDURE update_movie(
    IN p_id INT,
    IN p_title VARCHAR(100),
    IN p_director VARCHAR(50),
    IN p_release_date DATE,
    IN p_genre VARCHAR(30),
    IN p_poster VARCHAR(255)
)
BEGIN
    UPDATE movie
    SET title = p_title,
        director = p_director,
        release_date = p_release_date,
        genre = p_genre,
        poster = p_poster
    WHERE id = p_id;
END$$
DELIMITER ;

-- Xóa phim
DELIMITER $$
CREATE PROCEDURE delete_movie(IN p_id INT)
BEGIN
    DELETE FROM movie WHERE id = p_id;
END$$
DELIMITER ;

-- Lấy tất cả phim
DELIMITER $$
CREATE PROCEDURE get_all_movies()
BEGIN
    SELECT * FROM movie;
END$$
DELIMITER ;

-- Tìm phim theo id
DELIMITER $$
CREATE PROCEDURE find_movie_by_id(IN p_id INT)
BEGIN
    SELECT * FROM movie WHERE id = p_id;
END$$
DELIMITER ;
