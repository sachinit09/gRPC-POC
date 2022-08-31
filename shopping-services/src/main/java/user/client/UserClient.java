package user.client;

import io.grpc.Channel;
import myorg.user.services.UserRequest;
import myorg.user.services.UserResponse;
import myorg.user.services.UserServiceGrpc;

public class UserClient {
	private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;
	
	public UserClient(Channel channel) {
		userServiceBlockingStub = UserServiceGrpc.newBlockingStub(channel);
	}
	
	public UserDetails getUser(String userName) {
		UserRequest userRequest = UserRequest.newBuilder().setUsername(userName).build();
		UserResponse response = userServiceBlockingStub.getUser(userRequest);
		UserDetails userDetails = new UserDetails();
		userDetails.setAge(response.getAge());
		userDetails.setUsername(response.getUsername());
		userDetails.setGender(response.getGender() != null ? response.getGender().toString() : "");
		return userDetails;
	}
}
