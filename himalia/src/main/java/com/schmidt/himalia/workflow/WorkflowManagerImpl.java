/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.schmidt.himalia.logging.Log;
import com.schmidt.himalia.logging.LogFactory;
import com.schmidt.himalia.restful.Model;

/**
 * the work flow manager that is able to load work flow from resource file in class path
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@ApplicationScoped
public class WorkflowManagerImpl implements WorkflowManager {

	/**
	 * the resource name
	 */
	public static final String RESOURCE = "META-INF/schmidt-aw01-workflow.xml";
	
	/**
	 * the logger
	 */
	private Log log = LogFactory.getLog(WorkflowManagerImpl.class);
	
	/**
	 * the state manager that is used to find predefined state
	 */
	@Inject private StateManager stateManager;
	
	/**
	 * the bean manager
	 */
	@Inject private BeanManager beanManager;
	
	/**
	 * all predefined work flow
	 */
	private Map<String, WorkflowImpl> workflows = new HashMap<String, WorkflowImpl>();
	
	/**
	 * @param node the node
	 * @param name the attribute name
	 * @return the attribute value
	 */
	private String getAttribute(final Node node, final String name) {
		return node.getAttributes().getNamedItem(name).getNodeValue();
	}
	
	/**
	 * @param workflowNode load work flow from a node that defines work flow
	 * @return the work flow
	 * @throws WorkflowException if fail to load work flow
	 */
	private WorkflowImpl load(final Node workflowNode) throws WorkflowException {
		
		String workflowType = this.getAttribute(workflowNode, "type");
		String workflowName = this.getAttribute(workflowNode, "name");
		WorkflowImpl workflow = new WorkflowImpl(workflowType, workflowName);
		
		NodeList nodes = workflowNode.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			
			Node stateNode = nodes.item(i);
			if (stateNode.getNodeName().equals("state")) {
				
				String stateId = this.getAttribute(stateNode, "id");
				Bean<?> bean = this.stateManager.getStateBean(workflowType, stateId);
				if (bean == null) {
					throw new WorkflowException(
							"State " + stateId + " is not defined in work flow " + workflowName
					);
				}
				
				String stateType = this.stateManager.getType(bean);
				if (workflowType.equals(stateType)) {
					workflow.add(this.getAttribute(stateNode, "name"), bean);
				} else {
					throw new WorkflowException(
							"State " + stateId + " type is not same as work flow " + workflowName
					);
				}
			}
		}
		return workflow;
	}
	
	/**
	 * load all defined work flows from resource files
	 * 
	 * @param builder the XML document builder
	 * @param url the resource URL
	 */
	private void load(final DocumentBuilder builder, final URL url) {
		
		try (InputStream in = url.openStream()) {
			
			Document document = builder.parse(url.openStream());
			NodeList nodes = document.getDocumentElement().getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				
				Node workflowNode = nodes.item(i);
				if (workflowNode.getNodeName().equals("workflow")) {
					
					WorkflowImpl workflow = this.load(workflowNode);
					if (this.workflows.containsKey(workflow.getName())) {
						this.log.error(
								"Work flow [{}] already exists when loads resource [{}]", workflow, url.toString()
						);
					} else {
						this.workflows.put(workflow.getName(), workflow);
					}
				}
			}
		} catch (IOException e) {
			this.log.error("Fail to open resource [{}] when load work flow", url.toString(), e);
		} catch (SAXException e) {
			this.log.error("Fail to parse work flow resource [{}] as XML", url.toString(), e);
		} catch (WorkflowException e) {
			this.log.error("Fail to load work flow from resource [{}]", url.toString(), e);
		}
	}
	
	/**
	 * load work flow from every model
	 */
	@PostConstruct public void init() {
		
		Enumeration<URL> urls = null;
		try {
			urls = this.getClass().getClassLoader().getResources(WorkflowManagerImpl.RESOURCE);
		} catch (IOException e) {
			this.log.error("Fail to load [{}] from resource class path", WorkflowManagerImpl.RESOURCE, e);
			return;
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		while (urls.hasMoreElements()) {
			
			URL url = urls.nextElement();
			this.log.debug("Try to load work flow from resource [{}]", url.toString());
			try {
				this.load(factory.newDocumentBuilder(), url);
			} catch (ParserConfigurationException e) {
				this.log.error("Fail to create XML document builder when load work flow resource", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.workflow.WorkflowManager#process(
	 * 	java.lang.String, java.lang.String, java.lang.String, java.lang.String
	 * )
	 */
	@Override
	public Model process(
			final String workflow, final String state, final String step, final String id) throws WorkflowException {
		
		WorkflowImpl workflowImpl = this.workflows.get(workflow);
		if (workflowImpl == null) {
			throw new WorkflowException("Work flow " + workflow + " does not exist");
		}
		return workflowImpl.process(this.beanManager, state, step, id);
	}
}
