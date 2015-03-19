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
		KieHelper khelper = new KieHelper();
		khelper.addResource(ResourceFactory.newClassPathResource("sample.bpmn"), ResourceType.BPMN2);
		khelper.addResource(ResourceFactory.newClassPathResource("ruletest.drl"), ResourceType.DRL);

		KieBase kbase = khelper.build();
		
		KieSession ksessionBase= kbase.newKieSession();
		
		Map params = new HashMap<String, Subscriber>();
		params.put("subscriber", new Subscriber("nizar", 4));
		
		ksessionBase.startProcess("com.sample.bpmn.hello", params);
		
		ksessionBase.fireAllRules();
	}

}
