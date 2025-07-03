package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Skeleton template for a controller test using MockMvc.
 *
 * You can use annotations from JUnit 5 such as @ParameterizedTest, @ValueSauce,
 * 
 * @CsvSource and @MethodSource for your test data.
 *
 *            Example usage of mockMvc for a GET request
 *            mockMvc.perform(get("/path-to-your-endpoint").param("your-query-param",
 *            param-value)) .andExpect(status().whateverStatusCodeYouExpect())
 *            .andExpect(content().string("string-you-expect-in-response")).
 *            .andExpect(jsonPath("$.jsonField").value("json-value-you-expect"));
 */
@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	DemoController cntl;

	// add your test cases here
	@DisplayName("Test1 Pass Hello")
	@Test
	public void test1() {
		String expect = "ell";
		String actual = cntl.checkString("Hello");
		assertEquals(expect, actual);

	}
	
	@DisplayName("Test2 Pass xyz")
	@Test
	public void test2() {
		String expect = "y";
		String actual = cntl.checkString("xyz");
		assertEquals(expect, actual);

	}
	
	@DisplayName("Test3 Pass ab")
	@Test
	public void test3() {
		String expect = "";
		String actual = cntl.checkString("ab");
		assertEquals(expect, actual);

	}
	
	@DisplayName("Test3 Pass 123%qwerty+")
	@Test
	public void test4() {
		String expect = "23_%qwerty";
		String actual = cntl.checkString("123%qwerty+");
		assertEquals(expect, actual);

	}
	@DisplayName("Test3 Pass a")
	@Test
	public void test5() {
		String expect = "Bad Request";
		String actual = cntl.checkString("a");
		assertEquals(expect, actual);
	

	}
}
