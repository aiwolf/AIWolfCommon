/**
 * DayContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;
import java.util.Arrays;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">日付付加ビルダークラス</div>
 * 
 * <div lang="en">Builder class to give date information to the content.</div>
 * 
 * @author otsuki
 *
 */
public class DayContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">発話内容に日付情報を与えるためのDayContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a DayContentBuilder to give date information to the content (with no subject specified).</div>
	 * 
	 * @param day
	 *            <div lang="ja">日付</div>
	 *
	 *            <div lang="en">The date.</div>
	 * @param content
	 *            <div lang="ja">日付情報を与えられる{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} given the date information.</div>
	 */
	public DayContentBuilder(int day, Content content) {
		this(Content.UNSPEC, day, content);
	}

	/**
	 * <div lang="ja">発話内容に日付情報を与えるためのDayContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a DayContentBuilder to give date information to the content.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">発話エージェント</div>
	 *
	 *            <div lang="en">The agent who utters.</div>
	 * @param day
	 *            <div lang="ja">日付</div>
	 *
	 *            <div lang="en">The date.</div>
	 * @param content
	 *            <div lang="ja">日付情報を与えられる{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} given the date information.</div>
	 */
	public DayContentBuilder(Agent subject, int day, Content content) {
		topic = Topic.OPERATOR;
		operator = Operator.DAY;
		this.subject = subject;
		this.day = day;
		contentList = new ArrayList<>(Arrays.asList(content));
	}

}
