package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/api/user-output/{word}")
	public ResponseEntity<Object> getUserOutput(@PathVariable(value = "word") String word) {

		if (word.length() < 2) {
			return new ResponseEntity<>("Minimum two Character", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(checkString(word), HttpStatus.OK);
	}

	public String checkString(String str) {

		String res = "", temp = "";
		if (str.length() < 2) {
			return "Bad Request";
		}
		temp = str.substring(1, str.length() - 1);
		Character[] splChar = { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '_', '=' };
		List<Character> list = Arrays.asList(splChar);

		for (int i = 0; i < temp.length(); i++) {
			char ch = temp.charAt(i);
			// checking spl exist or not
			if (list.contains(ch)) {
				res += "_" + ch;
			} else
				res += "" + ch;

		}

		return res;
	}
}
