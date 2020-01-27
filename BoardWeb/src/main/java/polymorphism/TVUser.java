package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		//Spring 컨테이너로 부터 필요한 객체를 LookUp(요청) 한다 
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
	}
}
