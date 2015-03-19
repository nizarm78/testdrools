package com.sample;

import java.util.*;

import org.kie.api.KieBase;
import org.kie.api.conf.KieBaseOption;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.aries.blueprint.factorybeans.KBaseOptions;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import ruletest.Subscriber;

public class mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initialize knowledge base
		KieHelper khelper = new KieHelper();
		
		// adding resource to knowledge base
		khelper.addResource(ResourceFactory.newClassPathResource("sample.bpmn"), ResourceType.BPMN2);
		khelper.addResource(ResourceFactory.newClassPathResource("ruletest.drl"), ResourceType.DRL);
		
		// building the default knowledge base
		KieBase kbase = khelper.build();
		
		// using the knowledge base to build the session base
		KieSession ksessionBase= kbase.newKieSession();
		
		// initializing process variables
		Map params = new HashMap<String, Subscriber>();
		params.put("subscriber", new Subscriber("nizar", 4));
		
		// starting the process using knowledge base, passing the process variables
		ksessionBase.startProcess("com.sample.bpmn.hello", params);
		
		// fire all rules
		ksessionBase.fireAllRules();
	}

}
