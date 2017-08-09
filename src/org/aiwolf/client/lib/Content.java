/**
 * Content.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">発話内容クラス。ContentBuilderで生成あるいは発話テキストをparseして生成</div>
 *
 * <div lang="en">Class for the content of a utterance. Constructed by ContentBuilder, or parsing the uttered text.</div>
 */
public class Content implements Cloneable {

	public static final Content SKIP = new Content(new SkipContentBuilder());
	public static final Content OVER = new Content(new OverContentBuilder());

	String text = null;
	Operator operator = null;
	Topic topic = null;
	Agent subject = null;
	Agent target = null;
	Role role = null;
	Species result = null;
	TalkType talkType = null;
	int talkDay = -1;
	int talkID = -1;
	List<Content> contentList = new ArrayList<>();

	@Override
	public Content clone() {
		Content clone = null;
		try {
			clone = (Content) super.clone();
			// clone.contentList = new ArrayList<Content>(contentList);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	/**
	 * <div lang="ja">発話テキストを返す</div>
	 *
	 * <div lang="en">Returns the uttered text.</div>
	 * 
	 * @return <div lang="ja">発話テキスト</div>
	 *
	 *         <div lang="en">The uttered text.</div>
	 */
	public String getText() {
		return text;
	}

	/**
	 * <div lang="ja">発話内容の演算子を返す</div>
	 *
	 * <div lang="en">Returns the operator of this content.</div>
	 * 
	 * @return <div lang="ja">演算子。単文の場合は{@code null}</div>
	 *
	 *         <div lang="en">The operator, or {@code null} when it is a simple sentence.</div>
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * <div lang="ja">発話内容の主語を返す</div>
	 *
	 * <div lang="en">Returns the subject of this content.</div>
	 * 
	 * @return <div lang="ja">主語。省略された場合{@code null}</div>
	 *
	 *         <div lang="en">The subject, or {@code null} if omitted.</div>
	 */
	public Agent getSubject() {
		return subject;
	}

	/**
	 * <div lang="ja">発話内容のトピックを返す</div>
	 *
	 * <div lang="en">Returns the topic of this content.</div>
	 * 
	 * @return <div lang="ja">トピック。複文の場合は{@code null}</div>
	 *
	 *         <div lang="en">The topic, or {@code null} when it is a complex sentence.</div>
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * <div lang="ja">発話内容中の目的エージェントを返す。発話が単文で，かつTopicが(DIS)AGREE以外で有効</div>
	 *
	 * <div lang="en">Returns the objective agent of this content. Valid when it is a simple sentence and the topic is other than (DIS)AGREE.</div>
	 * 
	 * @return <div lang="ja">目的エージェント。無効の場合は{@code null}</div>
	 *
	 *         <div lang="en">The objective agent, or {@code null} when it is invalid.</div>
	 */
	public Agent getTarget() {
		return target;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている役職を返す。発話が単文で，かつTopicがCOMINGOUTとESTIMATEのとき有効</div>
	 *
	 * <div lang="en">Returns the role referred in this content. Valid when it is a simple sentence and the topic is COMINGOUT or ESTIMATE.</div>
	 * 
	 * @return <div lang="ja">言及されている役職。無効の場合は{@code null}</div>
	 *
	 *         <div lang="en">The referred role, or {@code null} when it is invalid.</div>
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている判定結果を返す。発話が単文で，かつTopicがDIVINEDとINQUESTEDのとき有効</div>
	 *
	 * <div lang="en">Returns the result of the judgment referred in this content. Valid when it is a simple sentence and the topic is DIVINED or INQUESTED.</div>
	 * 
	 * @return <div lang="ja">言及されている判定結果。無効の場合は{@code null}</div>
	 *
	 *         <div lang="en">The referred result, or {@code null} when it is invalid.</div>
	 */
	public Species getResult() {
		return result;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている発言のタイプを返す。発話が単文で，かつTopicが(DIS)AGREEのとき有効</div>
	 *
	 * <div lang="en">Returns the type of the utterance referred in this content. Valid when it is a simple sentence and the topic is (DIS)AGREE.</div>
	 * 
	 * @return <div lang="ja">言及されている発言のタイプ。無効の場合は{@code null}</div>
	 *
	 *         <div lang="en">The type of utterance, or {@code null} when it is invalid.</div>
	 */
	public TalkType getTalkType() {
		return talkType;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている発言の日を返す。発話が単文で，かつTopicが(DIS)AGREEのとき有効</div>
	 *
	 * <div lang="en">Returns the day of the utterance referred in this content. Valid when it is a simple sentence and the topic is (DIS)AGREE.</div>
	 * 
	 * @return <div lang="ja">言及されている発言の日。無効の場合は-1</div>
	 *
	 *         <div lang="en">The day of the referred utterance, or -1 when it is invalid.</div>
	 */
	public int getTalkDay() {
		return talkDay;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている発言のIDを返す。発話が単文で，かつTopicが(DIS)AGREEのとき有効</div>
	 *
	 * <div lang="en">Returns the ID of the utterance referred in this content. Valid when it is a simple sentence and the topic is (DIS)AGREE.</div>
	 * 
	 * @return <div lang="ja">言及されている発言のID。無効の場合は-1</div>
	 *
	 *         <div lang="en">The ID of the referred utterance, or -1 when it is invalid.</div>
	 */
	public int getTalkID() {
		return talkID;
	}

	/**
	 * <div lang="ja">発話内容が複文・重文の場合，節のリストを返す</div>
	 *
	 * <div lang="en">Returns the list of clauses in case of complex or compound sentence.</div>
	 * 
	 * @return <div lang="ja">節のリスト。単文の場合は{@code null}</div>
	 *
	 *         <div lang="en">The list of clauses, or {@code null} in case of simple sentence.</div>
	 */
	public List<Content> getContentList() {
		return contentList;
	}

	/**
	 * <div lang="ja">指定したContentBuilderによりContentを構築する</div>
	 *
	 * <div lang="en">Constructs a Content by the given ContentBuilder.</div>
	 * 
	 * @param builder
	 *            <div lang="ja">発話内容に応じたContentBuilder</div>
	 *
	 *            <div lang="en">ContentBuilder for the content.</div>
	 */
	public Content(ContentBuilder builder) {
		operator = builder.getOperator();
		subject = builder.getSubject();
		text = builder.getText();
		if (operator == null) {
			topic = builder.getTopic();
			target = builder.getTarget();
			role = builder.getRole();
			result = builder.getResult();
			talkType = builder.getTalkType();
			talkDay = builder.getTalkDay();
			talkID = builder.getTalkID();
		} else {
			contentList = builder.getContentList();
		}
	}

	/**
	 * <div lang="ja">発話テキストによりContentを構築する</div>
	 *
	 * <div lang="en">Constructs a Content from the uttered text.</div>
	 * 
	 * @param input
	 *            <div lang="ja">発話テキスト</div>
	 *
	 *            <div lang="en">The uttered text.</div>
	 */
	public Content(String input) {
		text = input;
		String s = getSentence(input);
		if (s != null) { // Complex sentence.
			topic = Topic.OPERATOR;
			operator = Operator.REQUEST;
			contentList.add(new Content(s));
		} else { // Simple sentence. Implicit subject means it equals to the utterer.
			String[] split = text.split("\\s+");
			int offset = 0;
			if (split[0].startsWith("Agent")) { // Explicit subject.
				subject = Agent.getAgent(getInt(split[0]));
				offset = 1;
			}

			topic = Topic.getTopic(split[0 + offset]);

			int targetId = -1;
			if (split.length >= 2 + offset && split[1 + offset].startsWith("Agent")) {
				targetId = getInt(split[1 + offset]);
			}

			switch (topic) {
			case SKIP:
			case OVER:
				break;

			case AGREE:
			case DISAGREE:
				// ex. TALK day4 ID:38
				try {
					talkType = TalkType.valueOf(split[1 + offset]);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					talkType = null;
				}
				talkDay = getInt(split[2 + offset]);
				talkID = getInt(split[3 + offset]);
				break;

			case ESTIMATE:
			case COMINGOUT:
				// Topic Target Role
				target = Agent.getAgent(targetId);
				try {
					role = Role.valueOf(split[2 + offset]);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					role = null;
				}
				break;

			case DIVINED:
			case IDENTIFIED:
				// Topic Target Result
				target = Agent.getAgent(targetId);
				try {
					result = Species.valueOf(split[2 + offset]);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					result = null;
				}
				break;

			case ATTACK:
			case DIVINATION:
			case GUARD:
			case GUARDED:
			case VOTE:
				target = Agent.getAgent(targetId);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * <div lang="ja">発話テキストが有効かどうかを返す．</div>
	 * 
	 * <div lang="en">Returns whether or not the uttered text is valid.</div>
	 * 
	 * @param input
	 *            <div lang="ja">被チェックテキスト</div>
	 *
	 *            <div lang="en">The text to be checked.</div>
	 * 
	 * @return <div lang="ja">有効である場合{@code true}，そうでなければ{@code false}</div>
	 *
	 *         <div lang="en">{@code true} if the text is valid, otherwise {@code false}.</div>
	 */
	public static boolean validate(String input) {
		if (input == null) {
			return false;
		}

		String s = getSentence(input);
		if (s != null) {
			return validate(s);
		} else { // Simple sentence.
			String[] split = input.split("\\s+");
			int length = split.length;
			if (length == 0) {
				return false;
			}

			int offset = 0;
			if (split[0].startsWith("Agent")) {
				offset = 1;
			}

			Topic topic = Topic.getTopic(split[0 + offset]);
			if (topic == null) {
				return false;
			}

			switch (topic) {
			case SKIP:
			case OVER:
				if (split.length != 1 + offset) {
					return false;
				}
				return true;
			case AGREE:
			case DISAGREE:
				if (split.length != 4 + offset) {
					return false;
				}
				try {
					TalkType.valueOf(split[1 + offset]);
				} catch (IllegalArgumentException e) {
					return false;
				}
				if (getInt(split[2 + offset]) == -1 || getInt(split[3 + offset]) == -1) {
					return false;
				}
				return true;

			case ESTIMATE:
			case COMINGOUT:
				if (split.length != 3 + offset) {
					return false;
				}

				if (!split[1 + offset].startsWith("Agent") || getInt(split[1 + offset]) == -1) {
					return false;
				}

				try {
					Role.valueOf(split[2 + offset]);
				} catch (IllegalArgumentException e) {
					return false;
				}
				return true;

			case DIVINED:
			case IDENTIFIED:
				if (split.length != 3 + offset) {
					return false;
				}

				if (!split[1 + offset].startsWith("Agent") || getInt(split[1 + offset]) == -1) {
					return false;
				}

				try {
					Species.valueOf(split[2 + offset]);
				} catch (IllegalArgumentException e) {
					return false;
				}
				return true;

			case ATTACK:
			case DIVINATION:
			case GUARD:
			case GUARDED:
			case VOTE:
				if (split.length != 2 + offset) {
					return false;
				}

				if (!split[1 + offset].startsWith("Agent") || getInt(split[1 + offset]) == -1) {
					return false;
				}
				return true;

			default:
				return false;
			}
		}
	}

	private static final Pattern intPattern = Pattern.compile("-?[\\d]+");

	private static int getInt(String text) {
		Matcher m = intPattern.matcher(text);
		if (m.find()) {
			return Integer.parseInt(m.group());
		}
		return -1;
	}

	private static final Pattern requestPattern = Pattern.compile("REQUEST\\((.+?)\\)");

	private static String getSentence(String text) {
		Matcher m = requestPattern.matcher(text);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}

	@Override
	public boolean equals(Object content) {
		if (content instanceof Content && text != null) {
			return text.equals(((Content) content).getText());
		}
		return false;
	}

}
