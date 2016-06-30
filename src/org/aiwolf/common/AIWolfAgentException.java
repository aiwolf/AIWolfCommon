package org.aiwolf.common;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">
 *
 * 人狼知能におけるエージェントの例外を扱うクラスです。<br>
 * サーバのリクエスト中に発生した例外をラップし、スローします。
 *
 * </div>
 *
 * <div lang="en">
 *
 * AI werewolf agent's exception.
 *
 * </div>
 *
 * @author tori
 *
 */
public class AIWolfAgentException extends AIWolfRuntimeException {

	private static final long serialVersionUID = -5897930222916624361L;

	Agent agent;
	String method;
	Throwable exception;

	/**
	 * <div lang="ja">人狼知能における例外を構築します。</div>
	 *
	 * <div lang="en">Create new AI wolf game's exception.</div>
	 *
	 * @param agent
	 *            <div lang="ja">例外を起こしたエージェント</div>
	 *
	 *            <div lang="en">Agent</div>
	 * @param method
	 *            <div lang="ja">例外が発生しているメソッド名</div>
	 *
	 *            <div lang="en">Method</div>
	 * @param exception
	 *            <div lang="ja">発生した例外</div>
	 *
	 *            <div lang="en">Exception</div>
	 */
	public AIWolfAgentException(Agent agent, String method, Throwable exception) {
		super();
		this.agent = agent;
		this.method = method;
		this.exception = exception;
	}

	/**
	 * <div lang="ja">例外を起こしたエージェントを返します。</div>
	 *
	 * <div lang="en">Get the agent who caused exception.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">例外を起こしたエージェント</div>
	 *
	 *         <div lang="en">Agent who caused exception</div>
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * <div lang="ja">例外が発生しているメソッド名を返します。</div>
	 *
	 * <div lang="en">Get the method which caused exception.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">例外が発生しているメソッド名</div>
	 *
	 *         <div lang="en">Method which caused exception</div>
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * <div lang="ja">発生した例外を返します。</div>
	 *
	 * <div lang="en">Get the exception.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">発生した例外</div>
	 *
	 *         <div lang="en">Exception</div>
	 */
	public Throwable getException() {
		return exception;
	}

	/* (非 Javadoc)
	 * @see java.lang.Throwable#printStackTrace()
	 */
	@Override
	public void printStackTrace() {
		if(exception != null){
			exception.printStackTrace();
		}
		super.printStackTrace();
	}

	/* (非 Javadoc)
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	@Override
	public void printStackTrace(PrintStream s) {
		if(exception != null){
			exception.printStackTrace(s);
		}
		super.printStackTrace(s);
	}

	/* (非 Javadoc)
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	@Override
	public void printStackTrace(PrintWriter s) {
		if(exception != null){
			exception.printStackTrace(s);
		}
		super.printStackTrace(s);
	}
}
