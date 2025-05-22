package com.example.ss10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadController {

    @Autowired
    private test cloudinaryService;

    @GetMapping("/upload")
    public String showForm() {
        return "/upload";
    }

    @PostMapping("/upload")
    public String handleUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        String imageUrl = cloudinaryService.uploadFile(file);
        model.addAttribute("imageUrl", imageUrl);
        return "/result";
    }
}
