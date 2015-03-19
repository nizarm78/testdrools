package com.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.TaskSummary;

import ruletest.Subscriber;

/**
 * This is a sample file to launch a process.
 */
public class ProcessTest extends JbpmJUnitBaseTestCase {

	@Test
	public void testProcess() {
		RuntimeManager manager = createRuntimeManager("sample.bpmn");
		RuntimeEngine engine = getRuntimeEngine(null);
		KieSession ksession = engine.getKieSession();
		
		Map params = new HashMap<String, Subscriber>();
		params.put("subscriber", new Subscriber("nizar", 4));
		
		ProcessInstance processInstance = ksession.startProcess("com.sample.bpmn.hello", params);
				//("com.sample.bpmn.hello", params);
		ksession.fireAllRules();
		assertProcessInstanceActive(processInstance.getId(), ksession);
		

		assertProcessInstanceCompleted(processInstance.getId(), ksession);
		
		manager.disposeRuntimeEngine(engine);
		manager.close();
	}
	
	public ProcessTest() {
		super(true, true);
	}

}