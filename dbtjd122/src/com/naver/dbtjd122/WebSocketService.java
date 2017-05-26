package com.naver.dbtjd122;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/websocket")
public class WebSocketService {
static List<Session> list = new ArrayList<Session>();

@OnMessage
public void onMessage(String message, Session session) 
	    throws IOException, InterruptedException {
	System.out.println("Received: " + message);
	for (Session s : list) {
		s.getBasicRemote().sendText(message);
	}

	  }

@OnOpen
public void onOpen( Session session) {
  System.out.println("Client connected");
  System.out.println("add:" + session);
	System.out.println("Client connected");
	list.add(session);

}

@OnClose
public void onClose( Session session) {
  System.out.println("Connection closed");
  System.out.println("del:" + session);
	System.out.println("Connection closed");
	list.remove(session);

}
}
