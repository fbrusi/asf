package br.com.asf.controller.repository;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;

@Startup
@Singleton
public class ContractStatusNotifier {

	@Resource
	private TimerService timerService;
	
	@Schedule(hour = "21", persistent = false)
	public void notifyClients() {
		
		//TODO Implementar...
	}
}
