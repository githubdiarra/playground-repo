package com.comsates.hotspot;

import org.junit.Test;

import com.comsates.hotspot.user.Profile;
import com.comsates.hotspot.user.UserGenerator;

public class UserTest {

	UserGenerator gen = new UserGenerator();
	
	@Test
	public void batchTest() throws Exception{
		gen.generateUsers(Profile.BODJEL, 1000);
		gen.generateUsers(Profile.WELTARE, 1000);
		gen.generateUsers(Profile.KAIRA, 1000);
	}
}
