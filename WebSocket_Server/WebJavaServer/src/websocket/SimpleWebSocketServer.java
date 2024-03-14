package websocket;

import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONObject;

public class SimpleWebSocketServer extends WebSocketServer {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		final int PORT = 9000;	
		WebSocketServer server = new SimpleWebSocketServer(new InetSocketAddress(host,PORT));
		server.run();
	}
	
	public SimpleWebSocketServer(InetSocketAddress inetAddr){
		super(inetAddr);
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		// TODO Auto-generated method stub
		System.out.println(conn + " has diconnected");
		
	}

	@Override
	public void onError(WebSocket arg0, Exception arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(WebSocket arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handler) {
		// Stream 생성
		String hostIp = conn.getRemoteSocketAddress().getAddress().getHostAddress().toString();
		System.out.println(hostIp);
		
		JSONObject ackobj = new JSONObject();
		ackobj.put("cmd", "connect");
		ackobj.put("result", "Welcome to the Server");
		conn.send(ackobj.toString()); // 클라이언트한테 메시지 보내기
		
		
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		System.out.println("Server Started successfully!");
		
	}

}
