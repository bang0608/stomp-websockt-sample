package com.example.messagingstompwebsocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	@MessageMapping("/hello/{room}")
	@SendTo("/topic/greetings/{room}")
	public SocketVO socket(SocketVO message) throws Exception {
		logger.info("**********");
		logger.info("GreetingController:socket:SocketVO");
		logger.info(message.getUserName());
		logger.info(message.getContent());
		logger.info("**********");
		String userName = message.getUserName();
		String content = message.getContent();
		SocketVO result = new SocketVO(userName,content);
		return result;
	}

	//	@MessageMapping("/fleet/{fleetId}/driver/{driverId}")
//	public void simple(@DestinationVariable String fleetId, @DestinationVariable String driverId) {
//		simpMessagingTemplate.convertAndSend("/topic/fleet/" + fleetId, new Simple(fleetId, driverId));
//	}
//https://stackoverflow.com/questions/27047310/path-variables-in-spring-websockets-sendto-mapping

}