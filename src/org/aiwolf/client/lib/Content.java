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
import org.aiwolf.common.data.Talk;

/**
 * <div lang="ja">発話内容クラス。ContentBuilderで生成あるいは発話テキストをparseして生成</div>
 *
 * <div lang="en">Class for the content of a utterance. Constructed by ContentBuilder, or parsing the uttered text.</div>
 */
public class Content implements Cloneable {

	public static final Content SKIP = new Content(new SkipContentBuilder());
	public static final Content OVER = new Content(new OverContentBuilder());

	private String text = null;
	private Operator operator = null;
	private Topic topic = null;
	private Agent subject = null;
	private Agent target = null;
	private Role role = null;
	private Species result = null;
	private TalkType talkType = null;
	private int talkDay = -1;
	private int talkID = -1;
	private List<Content> contentList = new ArrayList<>();
	private int day = -1;

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
			day = builder.getDay();
		}
	}

	private static final String regAgent = "\\p{Upper}?\\p{Lower}*\\[?\\d*\\]?";
	private static final Pattern skipPattern = Pattern.compile("^" + Talk.SKIP + "$");
	private static final Pattern overPattern = Pattern.compile("^" + Talk.OVER + "$");
	private static final Pattern agreePattern = Pattern.compile("^(" + regAgent + ")\\s*AGREE\\s+(\\p{Upper}+)\\s+day(\\d+)\\s+ID:(\\d+)$");
	private static final Pattern disagreePattern = Pattern.compile("^(" + regAgent + ")\\s*DISAGREE\\s+(\\p{Upper}+)\\s+day(\\d+)\\s+ID:(\\d+)$");
	private static final Pattern estimatePattern = Pattern.compile("^(" + regAgent + ")\\s*ESTIMATE\\s+(" + regAgent + "|ANY)\\s+(\\p{Upper}+)$");
	private static final Pattern comingoutPattern = Pattern.compile("^(" + regAgent + ")\\s*COMINGOUT\\s+(" + regAgent + "|ANY)\\s+(\\p{Upper}+)$");
	private static final Pattern divinedPattern = Pattern.compile("^(" + regAgent + ")\\s*DIVINED\\s+(" + regAgent + "|ANY)\\s+(\\p{Upper}+)$");
	private static final Pattern identifiedPattern = Pattern.compile("^(" + regAgent + ")\\s*IDENTIFIED\\s+(" + regAgent + "|ANY)\\s+(\\p{Upper}+)$");
	private static final Pattern attackPattern = Pattern.compile("^(" + regAgent + ")\\s*ATTACK\\s+(" + regAgent + "|ANY)$");
	private static final Pattern divinationPattern = Pattern.compile("^(" + regAgent + ")\\s*DIVINATION\\s+(" + regAgent + "|ANY)$");
	private static final Pattern guardPattern = Pattern.compile("^(" + regAgent + ")\\s*GUARD\\s+(" + regAgent + "|ANY)$");
	private static final Pattern guardedPattern = Pattern.compile("^(" + regAgent + ")\\s*GUARDED\\s+(" + regAgent + "|ANY)$");
	private static final Pattern votePattern = Pattern.compile("^(" + regAgent + ")\\s*VOTE\\s+(" + regAgent + "|ANY)$");
	private static final Pattern requestPattern = Pattern.compile("^(" + regAgent + ")\\s*REQUEST\\s*(" + regAgent + "|ANY)\\s+\\((.*)\\)$");
	private static final Pattern becausePattern = Pattern.compile("^(" + regAgent + ")\\s*BECAUSE\\s+(\\(.*\\))$");
	private static final Pattern andPattern = Pattern.compile("^(" + regAgent + ")\\s*AND\\s+(\\(.*\\))$");
	private static final Pattern orPattern = Pattern.compile("^(" + regAgent + ")\\s*OR\\s+(\\(.*\\))$");
	private static final Pattern xorPattern = Pattern.compile("^(" + regAgent + ")\\s*XOR\\s+(\\(.*\\))$");
	private static final Pattern notPattern = Pattern.compile("^(" + regAgent + ")\\s*NOT\\s+\\((.*)\\)$");
	private static final Pattern dayPattern = Pattern.compile("^(" + regAgent + ")\\s*DAY\\s+(\\d+)\\s+\\((.*)\\)$");

	// かっこで囲んだ2つのContentの文字列から，2つのContentを抽出する
	static List<Content> getContents(String input) {
		List<Content> contents = new ArrayList<>();
		int length = input.length();
		int stackPtr = 0;
		int start = 0;
		for (int i = 0; i < length; i++) {
			if (input.charAt(i) == '(') {
				if (stackPtr == 0) {
					start = i;
				}
				stackPtr++;
			} else if (input.charAt(i) == ')') {
				stackPtr--;
				if (stackPtr == 0) {
					contents.add(new Content(input.substring(start + 1, i)));
				}
			}
		}
		return contents;
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
		String trimmed = input.trim();
		// SKIP
		Matcher m = skipPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.SKIP;
			makeText();
			return;
		}
		// OVER
		m = overPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.OVER;
			makeText();
			return;
		}
		// AGREE
		m = agreePattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.AGREE;
			subject = Agent.getAgent(getInt(m.group(1)));
			try {
				talkType = TalkType.valueOf(m.group(2));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			talkDay = getInt(m.group(3));
			talkID = getInt(m.group(4));
			makeText();
			return;
		}
		// DISAGREE
		m = disagreePattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.DISAGREE;
			subject = Agent.getAgent(getInt(m.group(1)));
			try {
				talkType = TalkType.valueOf(m.group(2));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			talkDay = getInt(m.group(3));
			talkID = getInt(m.group(4));
			makeText();
			return;
		}
		// ESTIMATE
		m = estimatePattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.ESTIMATE;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			if (!m.group(3).equals("ANY")) {
				try {
					role = Role.valueOf(m.group(3));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			makeText();
			return;
		}
		// COMINGOUT
		m = comingoutPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.COMINGOUT;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			if (!m.group(3).equals("ANY")) {
				try {
					role = Role.valueOf(m.group(3));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			makeText();
			return;
		}
		// DIVINED
		m = divinedPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.DIVINED;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			try {
				result = Species.valueOf(m.group(3));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			makeText();
			return;
		}
		// IDENTIFIED
		m = identifiedPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.IDENTIFIED;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			try {
				result = Species.valueOf(m.group(3));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			makeText();
			return;
		}
		// ATTACK
		m = attackPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.ATTACK;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			makeText();
			return;
		}
		// DIVINATION
		m = divinationPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.DIVINATION;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			makeText();
			return;
		}
		// GUARD
		m = guardPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.GUARD;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			makeText();
			return;
		}
		// GUARDED
		m = guardedPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.GUARDED;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			makeText();
			return;
		}
		// VOTE
		m = votePattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.VOTE;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			makeText();
			return;
		}
		// REQUEST
		m = requestPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.OPERATOR;
			operator = Operator.REQUEST;
			subject = Agent.getAgent(getInt(m.group(1)));
			target = Agent.getAgent(getInt(m.group(2)));
			Content newContent = new Content(m.group(3));
			if (target == null && !m.group(2).equals("ANY")) {// AIWolf protocol ver2
				target = newContent.subject;
			}
			contentList.add(newContent);
			makeText();
			return;
		}
		// BECAUSE
		m = becausePattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.OPERATOR;
			operator = Operator.BECAUSE;
			subject = Agent.getAgent(getInt(m.group(1)));
			contentList = getContents(m.group(2));
			makeText();
			return;
		}
		// AND
		m = andPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.OPERATOR;
			operator = Operator.AND;
			subject = Agent.getAgent(getInt(m.group(1)));
			contentList = getContents(m.group(2));
			makeText();
			return;
		}
		// OR
		m = orPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.OPERATOR;
			operator = Operator.OR;
			subject = Agent.getAgent(getInt(m.group(1)));
			contentList = getContents(m.group(2));
			makeText();
			return;
		}
		// XOR
		m = xorPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.OPERATOR;
			operator = Operator.XOR;
			subject = Agent.getAgent(getInt(m.group(1)));
			contentList = getContents(m.group(2));
			makeText();
			return;
		}
		// NOT
		m = notPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.OPERATOR;
			operator = Operator.NOT;
			subject = Agent.getAgent(getInt(m.group(1)));
			contentList.add(new Content(m.group(2)));
			makeText();
			return;
		}
		// DAY
		m = dayPattern.matcher(trimmed);
		if (m.find()) {
			topic = Topic.OPERATOR;
			operator = Operator.DAY;
			subject = Agent.getAgent(getInt(m.group(1)));
			day = getInt(m.group(2));
			contentList.add(new Content(m.group(3)));
			makeText();
			return;
		}
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
	 * <div lang="ja">発話の日付を返す</div>
	 *
	 * <div lang="en">Returns the date of content.</div>
	 * 
	 * @return <div lang="ja">日付</div>
	 *
	 *         <div lang="en">Date.</div>
	 */
	public int getDay() {
		return day;
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

		String trimmed = input.trim();
		// SKIP
		Matcher m = skipPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// OVER
		m = overPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// AGREE
		m = agreePattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// DISAGREE
		m = disagreePattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// ESTIMATE
		m = estimatePattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// COMINGOUT
		m = comingoutPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// DIVINED
		m = divinedPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// IDENTIFIED
		m = identifiedPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// ATTACK
		m = attackPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// DIVINATION
		m = divinationPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// GUARD
		m = guardPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// GUARDED
		m = guardedPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// VOTE
		m = votePattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// REQUEST
		m = requestPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// BECAUSE
		m = becausePattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// AND
		m = andPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// OR
		m = orPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// XOR
		m = xorPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// NOT
		m = notPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}
		// DAY
		m = dayPattern.matcher(trimmed);
		if (m.find()) {
			return true;
		}

		return false;
	}

	private void makeText() {
		switch (topic) {
		case SKIP:
			text = SKIP.getText();
			break;
		case OVER:
			text = OVER.getText();
			break;
		case AGREE:
			text = new AgreeContentBuilder(subject, talkType, talkDay, talkID).getText();
			break;
		case DISAGREE:
			text = new DisagreeContentBuilder(subject, talkType, talkDay, talkID).getText();
			break;
		case ESTIMATE:
			text = new EstimateContentBuilder(subject, target, role).getText();
			break;
		case COMINGOUT:
			text = new ComingoutContentBuilder(subject, target, role).getText();
			break;
		case DIVINED:
			text = new DivinedResultContentBuilder(subject, target, result).getText();
			break;
		case IDENTIFIED:
			text = new IdentContentBuilder(subject, target, result).getText();
			break;
		case ATTACK:
			text = new AttackContentBuilder(subject, target).getText();
			break;
		case DIVINATION:
			text = new DivinationContentBuilder(subject, target).getText();
			break;
		case GUARD:
			text = new GuardCandidateContentBuilder(subject, target).getText();
			break;
		case GUARDED:
			text = new GuardedAgentContentBuilder(subject, target).getText();
			break;
		case VOTE:
			text = new VoteContentBuilder(subject, target).getText();
			break;
		case OPERATOR:
			switch (operator) {
			case REQUEST:
				text = new RequestContentBuilder(subject, target, contentList.get(0)).getText();
				break;
			case BECAUSE:
				text = new BecauseContentBuilder(subject, contentList.get(0), contentList.get(1)).getText();
				break;
			case AND:
				text = new AndContentBuilder(subject, contentList.get(0), contentList.get(1)).getText();
				break;
			case OR:
				text = new OrContentBuilder(subject, contentList.get(0), contentList.get(1)).getText();
				break;
			case XOR:
				text = new XorContentBuilder(subject, contentList.get(0), contentList.get(1)).getText();
				break;
			case NOT:
				text = new NotContentBuilder(subject, contentList.get(0)).getText();
				break;
			case DAY:
				text = new DayContentBuilder(subject, day, contentList.get(0)).getText();
				break;
			default:
				break;
			}
			break;
		default:
			break;
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

	@Override
	public boolean equals(Object content) {
		if (content instanceof Content && text != null) {
			return text.equals(((Content) content).getText());
		}
		return false;
	}

}
