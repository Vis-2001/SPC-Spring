package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import java.util.Random;
@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(UserMessage message) throws Exception {
		char sym = message.getNum1();
		if(sym!='s'&&sym!='p'&&sym!='c'){
			return new Greeting("Play properly ");
		}
		Random rand = new Random();
		int ub = 3;
		int num = rand.nextInt(ub);
		if(num==0){
			if(sym == 's') return new Greeting("Computer Stone : Stone You. Draw ");
			if(sym == 'p') return new Greeting("Computer Stone : Paper You. Win ");
			if(sym == 'c') return new Greeting("Computer Stone : Scissor You. Lose ");
		}
		if(num==1){
			if(sym == 's') return new Greeting("Computer Paper : Stone You. Lose ");
			if(sym == 'p') return new Greeting("Computer Paper : Paper You. Draw ");
			if(sym == 'c') return new Greeting("Computer Paper : Scissor You. Win ");
		}
		if(num==2){
			if(sym == 's') return new Greeting("Computer Scissor : Stone You. Win ");
			if(sym == 'p') return new Greeting("Computer Scissor : Paper You. Lose ");
			if(sym == 'c') return new Greeting("Computer Scissor : Scissor You. Draw ");
		}
		return new Greeting("Play properly ");
	}

}
