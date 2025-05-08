<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giới Thiệu Bản Thân</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 15px;
        }
        section {
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        p {
            font-size: 16px;
            line-height: 1.6;
            color: #555;
        }
        .intro {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
        }
        .intro img {
            border-radius: 50%;
            width: 150px;
            height: 150px;
            object-fit: cover;
            margin-right: 20px;
        }
        .about-me {
            display: flex;
            align-items: center;
            margin-top: 20px;
        }
        .about-me div {
            max-width: 500px;
        }
    </style>
</head>
<body>

<header>
    <h1>Giới Thiệu Về Bản Thân</h1>
</header>

<section>
    <div class="intro">
        <div class="about-me">
            <img src="https://via.placeholder.com/150" alt="Ảnh đại diện">
            <div>
                <h2>Nguyễn Đức Bình</h2>
                <p><strong>Giới thiệu:</strong> Tôi là một sinh viên đam mê lập trình và phát triển phần mềm. Tôi đang học chuyên ngành Công nghệ Thông tin tại Đại học Thương mại. Ngoài học tập, tôi còn yêu thích các hoạt động nghiên cứu và học hỏi về công nghệ mới, đặc biệt là trong lĩnh vực lập trình web và ứng dụng di động.</p>
                <p><strong>Sở thích:</strong> Tôi thích chơi game, đọc sách về khoa học và công nghệ, và tham gia các hoạt động tình nguyện.</p>
                <p><strong>Liên hệ:</strong> email: <a href="mailto:nguyenbinh@gmail.com">nguyenbinh@gmail.com</a></p>
            </div>
        </div>
    </div>
</section>
</body>
</html>
