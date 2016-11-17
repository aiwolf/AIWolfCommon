/**
 * 
 */
package org.aiwolf.client.lib;

import org.aiwolf.client.lib.TemplateTalkFactory.TalkType;
import org.aiwolf.common.data.Agent;

/**
 * @author otsuki
 *
 */
public class DisagreeContentBuilder extends ContentBuilder {

	public DisagreeContentBuilder(TalkType talkType, int talkDay, int talkID) {
		this.topic = Topic.DISAGREE;
		this.talkType = talkType;
		this.talkDay = talkDay;
		this.talkID = talkID;
		this.text = wordAttachment(new String[] { Topic.DISAGREE.toString(), talkType.toString(),
				"day" + String.valueOf(talkDay), "ID:" + String.valueOf(talkID) });
	}

}
