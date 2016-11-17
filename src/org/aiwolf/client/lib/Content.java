package org.aiwolf.client.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aiwolf.client.lib.TemplateTalkFactory.TalkType;
import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Species;
import org.aiwolf.common.data.Talk;

/*
 * 発話をパースしたもの
 */
public class Content {

	//原文
	private final String text;

	//文章のトピック
	private final Topic topic;

	//文章上の対象プレイヤー
	private final Agent target;

	//カミングアウト結果や占い結果等
	private final State state;

	//TopicがAGREE,DISAGREEの時の対象発話のログの種類（囁きかどうか）
	@Deprecated
	private final TalkType talkType;

	//TopicがAGREE,DISAGREEの時の対象発話の日にち
	private final int talkDay;

	//TopicがAGREE,DISAGREEの時の対象発話のID
	private final int talkID;


	/**
	 * 発話全体のStringを返す
	 * @return
	 */
	public String getText(){
		return text;
	}

	/**
	 * 発話のトピックを返す
	 * @return
	 */
	public Topic getTopic(){
		return topic;
	}

	/**
	 * 発話の対象を返す．対象のない発話の場合はnull
	 * @return
	 */
	public Agent getTarget(){
		if(target != null){
			return target;
		}else{
			return null;
		}
	}

	/**
	 * TopicがESTIMATE,COMINGOUTの場合，そのRoleを返す．それ以外はnull
	 * @return
	 */
	public Role getRole(){
		if(state != null){
			return state.toRole();
		}else{
			return null;
		}
	}

	/**
	 * TopicがDIVINED,INQUESTEDの場合，そのRoleを返す．それ以外はnull
	 * @return
	 */
	public Species getResult(){
		if(state != null){
			return state.toSpecies();
		}else{
			return null;
		}
	}

	public TalkType getTalkType(){
		return talkType;
	}

	/**
	 * TopicがAGREE,DISAGREEの時，対象発話の発話日を返す．それ以外は-1
	 * @return
	 */
	public int getTalkDay(){
		return talkDay;
	}

	/**
	 * TopicがAGREE,DISAGREEの時，対象発話の発話IDを返す．それ以外は-1
	 * 発話日と発話IDでTalkとの一意性が取れる
	 * @return
	 */
	public int getTalkID(){
		return talkID;
	}

	/**
	 * parses uttered text and returns content of utterance
	 * 
	 * @param text
	 * @return
	 */
	public static Content parse(String text) {
		Builder builder = new Builder(text);
	
		// 原文を単語に分割
		String[] split = text.split("\\s+");// 一つ以上の空白で区切る
	
		// Topicの取得．解析できない場合null
		Topic topic = Topic.getTopic(split[0]);
		builder.topic(topic);
	
		int agentId = -1;
	
		if (split.length >= 2 && split[1].startsWith("Agent")) {
			agentId = getInt(split[1]);
		}
	
		switch (topic) {
		// 話すこと無し
		case SKIP:
		case OVER:
			break;
	
		// 同意系
		case AGREE:
		case DISAGREE:
			// Talk day4 ID38 みたいな形でくるので数字だけ取得
			builder.talkType(TalkType.parseTalkType(split[1])).talkDay(getInt(split[2])).talkID(getInt(split[3]));
			break;
	
		// "Topic Agent Role"
		case ESTIMATE:
		case COMINGOUT:
			builder.target(Agent.getAgent(agentId)).state(State.parseState(split[2]));
			break;
	
		// RESULT系
		case DIVINED:
		case INQUESTED:
			builder.state(State.parseState(split[2]));
		case GUARDED:
			builder.target(Agent.getAgent(agentId));
			break;
	
		// 投票系
		case ATTACK:
		case VOTE:
			builder.target(Agent.getAgent(agentId));
			break;
	
		default:
			break;
		}
	
		return builder.build();
	}

	/**
	 * Builder for Content
	 * 
	 * @author otsuki
	 *
	 */
	public static class Builder {
		private String text; // null
		private Topic topic; // null
		private Agent target; // null
		private State state; // null
		private TalkType talkType; // null
		private int talkDay = -1;
		private int talkID = -1;

		public Builder(String text) {
			this.text = text;
		}

		public Builder topic(Topic topic) {
			this.topic = topic;
			return this;
		}

		public Builder target(Agent target) {
			this.target = target;
			return this;
		}

		public Builder state(State state) {
			this.state = state;
			return this;
		}

		public Builder talkType(TalkType talkType) {
			this.talkType = talkType;
			return this;
		}

		public Builder talkDay(int talkDay) {
			this.talkDay = talkDay;
			return this;
		}

		public Builder talkID(int talkID) {
			this.talkID = talkID;
			return this;
		}

		public Content build() {
			return new Content(this);
		}
	}

	private Content(Builder builder) {
		text = builder.text;
		topic = builder.topic;
		target = builder.target;
		state = builder.state;
		talkType = builder.talkType;
		talkDay = builder.talkDay;
		talkID = builder.talkID;
	}

	static final private Pattern intPattern = Pattern.compile("-?[\\d]+");

	protected static int getInt(String text) {
		Matcher m = intPattern.matcher(text);
		if(m.find()){
			return Integer.parseInt(m.group());
		}
		return -1;
	}
}
