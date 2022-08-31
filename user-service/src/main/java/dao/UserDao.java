package dao;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User.UserBuilder().setAge(21).setGender("MALE").setId(1).setName("test").setUsername("Sachin Kumar Jain").build());
	}
	public User getUser(String username) {
		for(User user : users) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
