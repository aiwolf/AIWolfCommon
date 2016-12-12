/**
 * Content.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">発話内容クラス。ContentBuilderで生成あるいは発話テキストをparseして生成</div>
 *
 * <div lang="en">Class for content of utterance. Constructed by ContentBuilder or parsing uttered text.</div>
 */
public class Content {

	String text = null;
	Topic topic = null;
	Agent target = null;
	Role role = null;
	Species result = null;
	TalkType talkType = null;
	int talkDay = -1;
	int talkID = -1;

	/**
	 * <div lang="ja">発話テキストを返す</div>
	 *
	 * <div lang="en">Returns the uttered text.</div>
	 * 
	 * @return <div lang="ja">発話された文字列。定義上nullはありえない</div>
	 *
	 *         <div lang="en">String representing the uttered text. This can't be null because of its definition.</div>
	 */
	public String getText() {
		return text;
	}

	/**
	 * <div lang="ja">発話内容のトピックを返す</div>
	 *
	 * <div lang="en">Returns the topic of the content.</div>
	 * 
	 * @return <div lang="ja">発話内容のトピックを表すTopic。定義上nullはありえない</div>
	 *
	 *         <div lang="en">Topic representing the topic of the content. This can't be null because of its definition.</div>
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * <div lang="ja">発話内容中のターゲットエージェント。Topicが(DIS)AGREE以外で有効</div>
	 *
	 * <div lang="en">The target agent of the utterance. Valid except when the topic is (DIS)AGREE.</div>
	 * 
	 * @return <div lang="ja">ターゲットを表すAgent。Topicが(DIS)AGREEのときはnull</div>
	 *
	 *         <div lang="en">Agent representing the target or null when the topic is (DIS)AGREE.</div>
	 */
	public Agent getTarget() {
		return target;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている役職。TopicがCOMINGOUTとESTIMATEのとき有効</div>
	 *
	 * <div lang="en">The role referred in the content. Valid when the topic is COMINGOUT or ESTIMATE.</div>
	 * 
	 * @return <div lang="ja">言及されている役職を表すRole。TopicがCOMINGOUTとESTIMATE以外のときはnull</div>
	 *
	 *         <div lang="en">Role representing the referred role, or null when the topic is not COMINGOUT or ESTIMATE.</div>
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている判定結果。TopicがDIVINEDとINQUESTEDのとき有効</div>
	 *
	 * <div lang="en">The result of the judgment referred in the content. Valid when the topic is DIVINED or INQUESTED.</div>
	 * 
	 * @return <div lang="ja">言及されている結果を表すSpecies。TopicがDIVINEDとINQUESTED以外のときはnull</div>
	 *
	 *         <div lang="en">Species representing the result or null when the topic is not DIVINED or INQUESTED.</div>
	 */
	public Species getResult() {
		return result;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている発言のタイプ。Topicが(DIS)AGREEのとき有効</div>
	 *
	 * <div lang="en">The type of utterance referred in the content. Valid when the topic is (DIS)AGREE.</div>
	 * 
	 * @return <div lang="ja">言及されている発言のタイプを表すTalkType。Topicが(DIS)AGREE以外のときはnull</div>
	 *
	 *         <div lang="en">TalkType representing the type of utterance or null when the topic is not (DIS)AGREE.</div>
	 */
	public TalkType getTalkType() {
		return talkType;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている発言の日。Topicが(DIS)AGREEのとき有効</div>
	 *
	 * <div lang="en">The day of utterance referred in the content. Valid when the topic is (DIS)AGREE.</div>
	 * 
	 * @return <div lang="ja">言及されている発言の日を表す整数。Topicが(DIS)AGREE以外のときは-1</div>
	 *
	 *         <div lang="en">int representing the day of utterance or -1 when the topic is not (DIS)AGREE.</div>
	 */
	public int getTalkDay() {
		return talkDay;
	}

	/**
	 * <div lang="ja">発話内容中で言及されている発言のID。Topicが(DIS)AGREEのとき有効</div>
	 *
	 * <div lang="en">The ID of utterance referred in the content. Valid when the topic is (DIS)AGREE.</div>
	 * 
	 * @return <div lang="ja">言及されている発言のIDを表す整数。Topicが(DIS)AGREE以外のときは-1</div>
	 *
	 *         <div lang="en">int representing the ID of utterance or -1 when the topic is not (DIS)AGREE.</div>
	 */
	public int getTalkID() {
		return talkID;
	}

	/**
	 * <div lang="ja">指定したContentBuilderによりContentを構築する</div>
	 *
	 * <div lang="en">Constructs a Content by the given ContentBuilder.</div>
	 * 
	 * @param builder
	 *            <div lang="ja">発話内容に応じたContentBuilder</div>
	 *
	 *            <div lang="en">The ContentBuilder for the content of utterance.</div>
	 */
	public Content(ContentBuilder builder) {
		text = builder.getText();
		topic = builder.getTopic();
		target = builder.getTarget();
		role = builder.getRole();
		result = builder.getResult();
		talkType = builder.getTalkType();
		talkDay = builder.getTalkDay();
		talkID = builder.getTalkID();
	}

	/**
	 * <div lang="ja">発話テキストによりContentを構築する</div>
	 *
	 * <div lang="en">Constructs a Content from the uttered text.</div>
	 * 
	 * @param builder
	 *            <div lang="ja">発話テキストの文字列</div>
	 *
	 *            <div lang="en">String representing the uttered text.</div>
	 */
	public Content(String input) {
		text = input;

		String[] split = input.split("\\s+");

		topic = Topic.getTopic(split[0]); // Topicに存在しない場合null

		int agentId = -1;
		if (split.length >= 2 && split[1].startsWith("Agent")) {
			agentId = getInt(split[1]);
		}

		switch (topic) {
		case SKIP:
		case OVER:
			break;

		case AGREE:
		case DISAGREE:
			// ex. TALK day4 ID:38
			try {
				talkType = TalkType.valueOf(split[1]);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				talkType = null;
			}
			talkDay = getInt(split[2]);
			talkID = getInt(split[3]);
			break;

		case ESTIMATE:
		case COMINGOUT:
			// Topic Target Role
			target = Agent.getAgent(agentId);
			try {
				role = Role.valueOf(split[2]);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				role = null;
			}
			break;

		case DIVINED:
		case INQUESTED:
			// Topic Target Result
			target = Agent.getAgent(agentId);
			try {
				result = Species.valueOf(split[2]);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				result = null;
			}
			break;

		case ATTACK:
		case GUARDED:
		case VOTE:
			target = Agent.getAgent(agentId);
			break;

		default:
			break;
		}
	}

	/**
	 * <div lang="ja">発話テキストが有効かどうかを返す．</div>
	 * 
	 * <div lang="en">Returns whether or not the uttered text is valid.</div>
	 * 
	 * @param text
	 *            <div lang="ja">被チェックテキスト</div>
	 *
	 *            <div lang="en">The text to be checked that it is valid.</div>
	 * 
	 * @return <div lang="ja">有効である場合{@code true}，そうでなければ{@code false}</div>
	 *
	 *         <div lang="en">{@code true} if the text is valid, otherwise {@code false}.</div>
	 */
	public static boolean validate(String text) {
		String[] split = text.split("\\s+");
		int length = split.length;
		if (length == 0) {
			return false;
		}

		Topic topic = Topic.getTopic(split[0]);
		if (topic == null) {
			return false;
		}

		switch (topic) {
		case SKIP:
		case OVER:
			if (split.length != 1) {
				return false;
			}
			return true;
		case AGREE:
		case DISAGREE:
			if (split.length != 4) {
				return false;
			}
			try {
				TalkType.valueOf(split[1]);
			} catch (IllegalArgumentException e) {
				return false;
			}
			if (getInt(split[2]) == -1 || getInt(split[3]) == -1) {
				return false;
			}
			return true;

		case ESTIMATE:
		case COMINGOUT:
			if (split.length != 3) {
				return false;
			}

			if (!split[1].startsWith("Agent") || getInt(split[1]) == -1) {
				return false;
			}

			try {
				Role.valueOf(split[2]);
			} catch (IllegalArgumentException e) {
				return false;
			}
			return true;

		case DIVINED:
		case INQUESTED:
			if (split.length != 3) {
				return false;
			}

			if (!split[1].startsWith("Agent") || getInt(split[1]) == -1) {
				return false;
			}

			try {
				Species.valueOf(split[2]);
			} catch (IllegalArgumentException e) {
				return false;
			}
			return true;

		case GUARDED:
		case ATTACK:
		case VOTE:
			if (split.length != 2) {
				return false;
			}

			if (!split[1].startsWith("Agent") || getInt(split[1]) == -1) {
				return false;
			}
			return true;

		default:
			return false;
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

}
