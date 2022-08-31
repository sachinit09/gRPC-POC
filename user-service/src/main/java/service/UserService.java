package service;

import dao.User;
import dao.UserDao;
import io.grpc.stub.StreamObserver;
import myorg.user.services.UserRequest;
import myorg.user.services.UserResponse;
import myorg.user.services.UserServiceGrpc.UserServiceImplBase;

public class UserService extends UserServiceImplBase{
	@Override
	public void getUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
		User user = new UserDao().getUser(request.getUsername());
		UserResponse.Builder userReBuilder  =  UserResponse.newBuilder().setUsername(user.getUsername()).setAge(user.getAge());
		responseObserver.onNext(userReBuilder.build());
		responseObserver.onCompleted();
	}
}
