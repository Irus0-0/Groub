package kr.or.ddit.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/sub"); //보낼 때 매핑하는 경로
		registry.setUserDestinationPrefix("/user"); //귓속말 기능
		/*
		 받을 때 /pub + controller mapping path(RequestMapping("/hello")) = /pub/hello로 설정해주는 경로
		stomp.send("/pub/hello")로 설정하면 됨
		*/
		registry.setApplicationDestinationPrefixes("/pub");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws")
		.setAllowedOrigins("*")
		.withSockJS();
	}
}
