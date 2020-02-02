package wuhan_hospital;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;


public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {
	
	@Override
	public void onApplicationEvent(ApplicationStartingEvent applicationStarting) {

		System.out.println("========================================================");
		System.out.println("		Application is starting");
		System.out.println("========================================================");
	}
}
