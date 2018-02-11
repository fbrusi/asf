package br.com.asf.controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Startup
@Singleton
public class DocumentStatusNotifier {

	@Resource
	private TimerService timerService;
	
	@PostConstruct
	public void createSchedule() {
		
		ScheduleExpression expression = new ScheduleExpression();
		expression.hour("21");
		
		TimerConfig config = new TimerConfig();
		config.setInfo(expression.toString());
		config.setPersistent(false);
		
		timerService.createCalendarTimer(expression, config);
	}
	
	@Schedule(hour = "22", persistent = false)
	public void notifyClientsWithAnnotation() {
		
		System.out.println("Foi com anotação");
		sendReport();
	}
	
	@Timeout
	public void notifyClients(Timer timer) {
		
		System.out.println("Foi com parametrização");
		sendReport();
	}
	
	private void sendReport() {
		//TODO Implementar envio de relatório aos clientes
	}
}
