import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.UserService;

public class UserServer {
	private static final Logger logger = Logger.getLogger(UserServer.class.getName());
	private Server server;
	public static void main(String[] args) {
		final UserServer userServer = new UserServer();
		userServer.startServer();
		//Whenever user manually shutdown the application, server should stop
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				userServer.stopServer();
			}
		});
		userServer.blockServerThreadUntilTerminated();
	}
	private void startServer() {
		try {
		server = ServerBuilder.forPort(8000).addService(new UserService()).build();
		server.start();
		}catch(IOException e) {
			logger.log(Level.SEVERE, "Failed server startup");
		}
		logger.log(Level.INFO, "Succeded server startuo");
	}
	
	private void stopServer() {
		try {
			server.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Failed server shutdown");
		}
	}
	//allows to run server thread irrespective of main thread
	private void blockServerThreadUntilTerminated() {
		try {
			server.awaitTermination();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
