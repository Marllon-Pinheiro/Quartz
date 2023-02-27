package br.com.quartzapp;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzAppApplication {

	public static void main(String[] args) {
		
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.start();
			
			JobDetail job = JobBuilder.newJob(AtivoJob.class)
					.withIdentity("AtivoJOB","ativo01").build();
			
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("AtivoTRIGGER","ativo01")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();
			
			scheduler.scheduleJob(job, trigger);
			
		} catch(SchedulerException ex) {
			ex.printStackTrace();
		}
	}

}

