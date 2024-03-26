package com.example.KeyboardArenaProject.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateIdUtils {
	public static String generateUserId(LocalDateTime signUpDate) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmmss");
		String date = signUpDate.format(dateFormatter);
		String time = signUpDate.format(timeFormatter);
		return "user_" + date + "_" + time;
	}
}