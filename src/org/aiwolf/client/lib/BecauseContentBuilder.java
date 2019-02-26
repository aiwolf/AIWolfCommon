/**
 * BecauseContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;
import java.util.Arrays;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">理由発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of a reason.</div>
 * 
 * @author otsuki
 *
 */
public class BecauseContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">行動の理由を述べるためのBecauseContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a BecauseContentBuilder to express the reason for an action (with no subject specified).</div>
	 * 
	 * @param reason
	 *            <div lang="ja">理由を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the reason.</div>
	 * @param action
	 *            <div lang="ja">行動を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the action.</div>
	 */
	public BecauseContentBuilder(Content reason, Content action) {
		this(Content.UNSPEC, reason, action);
	}

	/**
	 * <div lang="ja">行動の理由を述べるためのBecauseContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a BecauseContentBuilder to express the reason for an action.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">理由を述べるエージェント</div>
	 *
	 *            <div lang="en">The agent who expresses the reason.</div>
	 * @param reason
	 *            <div lang="ja">理由を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the reason.</div>
	 * @param action
	 *            <div lang="ja">行動を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the action.</div>
	 */
	public BecauseContentBuilder(Agent subject, Content reason, Content action) {
		topic = Topic.OPERATOR;
		operator = Operator.BECAUSE;
		this.subject = subject;
		contentList = new ArrayList<>(Arrays.asList(reason, action));
	}

}
