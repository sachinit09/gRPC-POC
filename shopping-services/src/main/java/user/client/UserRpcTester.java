package user.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserRpcTester {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8000").usePlaintext().build();
		UserClient userClient = new UserClient(channel);
		UserDetails userDetails =userClient.getUser("Sachin Kumar Jain");
		System.out.println(userDetails);
	}

}
