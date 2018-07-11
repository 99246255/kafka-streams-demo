package cn.dazd.iris.cloud.labsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LabSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabSysApplication.class, args);
	}
}
