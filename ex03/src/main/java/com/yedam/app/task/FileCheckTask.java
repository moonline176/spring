package com.yedam.app.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class FileCheckTask {
	
	//@Scheduled(cron = "15,25 * * * *" ) //p.601참고 초/간격 or 초,초 or 분~분
	public void checkFile() {
		log.info("file check........========");
		log.info("==================");
	}
	
}
