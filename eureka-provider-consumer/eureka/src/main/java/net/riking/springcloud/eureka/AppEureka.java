package net.riking.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.ReentrantLock;

@EnableEurekaServer
@SpringBootApplication
public class AppEureka {

	public static void main(String[] args) {

		List<String>  list =new LinkedList<>();

		Map<String,String> map=	new HashMap<>();
		System.out.println(1 << 4);
		map.put("xiali", "li");

		ReentrantLock reentrantLock=new ReentrantLock();
		reentrantLock.lock();


		ConcurrentLinkedDeque<String> concurrentLinkedDeque=  new ConcurrentLinkedDeque<>();
		concurrentLinkedDeque.offer("");

		new HashSet<>();
		//SpringApplication.run(AppEureka.class, args);
	}

}
