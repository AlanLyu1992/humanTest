package org.struts.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.struts.action.Action;

public class ConfigParser {
	public static List<Action> actions = new ArrayList<Action>();
	static {		
		SAXReader reader = new SAXReader();		
	    try {
			Document document = reader.read(
					new File(ConfigParser.class.getClassLoader().getResource("struts.xml").getPath()));
			Element root = document.getRootElement();
			Iterator packageIter = root.elementIterator("package");
			while(packageIter.hasNext()){
				Element packageEle = (Element)packageIter.next();
				String namespace = packageEle.attributeValue("namespace");
				Iterator actionIter = packageEle.elementIterator("action");
				while(actionIter.hasNext()){
					Element actionEle = (Element)actionIter.next();
					String name = actionEle.attributeValue("name");
					String className = actionEle.attributeValue("class");
					String methodName = actionEle.attributeValue("method");
					Action action = new Action();
					action.setUriPattern(namespace + "/" + name);
					action.setClassName(className);
					action.setMethodName(methodName);
					Iterator resultIter = actionEle.elementIterator("result");
					while(resultIter.hasNext()){
						Element resultEle = (Element)resultIter.next();
						String key = resultEle.attributeValue("name");
						String value = resultEle.getTextTrim();
						action.getResults().put(key, value);
					}
					actions.add(action);
				}
			}
			System.out.println(actions);
	    } catch (DocumentException e) {
			e.printStackTrace();
		}		
	}
}
