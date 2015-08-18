/**
 * 
 */
package org.aiwolf.common;

import org.aiwolf.common.data.Agent;

/**
 * @author tori
 *
 */
public class AiWolfAgentException extends AIWolfRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Agent agent;
	String method;
	Throwable exception;
	/**
	 * 
	 * @param agent
	 * @param method
	 * @param e
	 */
	public AiWolfAgentException(Agent agent, String method, Throwable e) {
		this.agent = agent;
		this.method = method;
		this.exception = e;
	}
	/**
	 * @return agent
	 */
	public Agent getAgent() {
		return agent;
	}
	/**
	 * @return method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @return exception
	 */
	public Throwable getException() {
		return exception;
	}


	
}
