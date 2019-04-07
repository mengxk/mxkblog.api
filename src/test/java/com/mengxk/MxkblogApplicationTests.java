package com.mengxk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MxkblogApplicationTests {

	@Test
	public void contextLoads() {
		String all = String.join("/", "S", "M","L");
		System.out.println(all);
	}

}
