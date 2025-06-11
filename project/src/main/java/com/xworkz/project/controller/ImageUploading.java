package com.xworkz.project.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Component
@RequestMapping("/")
public class ImageUploading {

	@GetMapping("/image/{filename}")
	public void showImage(@PathVariable String filename, HttpServletResponse response) throws IOException {

		if (filename.contains("..")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "invalid file name.");
			return;
		}
		Path path = Paths.get("D:/ProjectImage/ItemImages");
		File file = path.toFile();
		if (!file.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "file not found");
			return;
		}
		try (InputStream buffer = new BufferedInputStream(new FileInputStream(file));
				ServletOutputStream out = response.getOutputStream()) {
			IOUtils.copy(buffer, out);
			response.flushBuffer();
		} catch (IOException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while serving image");
			e.printStackTrace();
		}
	}
}
