/**
 * InquiryContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;
import java.util.Arrays;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">照会発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of an inquiry.</div>
 * 
 * @author otsuki
 *
 */
public class InquiryContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">照会発話のためのInquiryContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a InquiryContentBuilder for the utterance of an inquiry (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被照会エージェント</div>
	 *
	 *            <div lang="en">The inquired agent.</div>
	 * @param content
	 *            <div lang="ja">照会事項を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the inquired matter.</div>
	 */
	public InquiryContentBuilder(Agent target, Content content) {
		this(Content.UNSPEC, target, content);
	}

	/**
	 * <div lang="ja">照会発話のためのInquiryContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a InquiryContentBuilder for the utterance of an inquiry.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">照会をするエージェント</div>
	 *
	 *            <div lang="en">The agent who inquires.</div>
	 * @param target
	 *            <div lang="ja">被照会エージェント</div>
	 *
	 *            <div lang="en">The inquired agent.</div>
	 * @param content
	 *            <div lang="ja">照会事項を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the inquired matter.</div>
	 */
	public InquiryContentBuilder(Agent subject, Agent target, Content content) {
		topic = Topic.OPERATOR;
		operator = Operator.INQUIRE;
		this.subject = subject;
		this.target = target;
		contentList = new ArrayList<>(Arrays.asList(content));
	}

}
