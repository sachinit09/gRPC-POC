package dao;

public class User {
	private int id;
	private String username;
	private String name;
	private int age;
	private String gender;
	public User(UserBuilder userBuilder) {
		this.id = userBuilder.id;
		this.username = userBuilder.username;
		this.name = userBuilder.name;
		this.age = userBuilder.age;
		this.gender = userBuilder.gender;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getGender() {
		return gender;
	}
	static class UserBuilder {
		private int id;
		private String username;
		private String name;
		private int age;
		private String gender;
		
		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public UserBuilder setId(int id) {
			this.id = id;
			return this;
		}
		
		public UserBuilder setUsername(String username) {
			this.username = username;
			return this;
		}
		
		public UserBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder setGender(String gender) {
			this.gender = gender;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
}
