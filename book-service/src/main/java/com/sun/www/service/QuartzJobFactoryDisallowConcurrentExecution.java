package com.sun.www.service;

import com.sun.www.bean.ScheduleJobBean;
import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author chenjianlin
 * @Description: 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 * @date 2014年4月24日 下午5:05:47
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {
    public final Logger log = Logger.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJobBean scheduleJob = (ScheduleJobBean) context.getMergedJobDataMap().get("scheduleJobBean");
        TaskUtils.invokMethod(scheduleJob);

    }
}