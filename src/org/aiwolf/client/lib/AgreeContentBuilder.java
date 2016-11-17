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
public class AgreeContentBuilder extends ContentBuilder {

	public AgreeContentBuilder(TalkType talkType, int talkDay, int talkID) {
		this.topic = Topic.AGREE;
		this.talkType = talkType;
		this.talkDay = talkDay;
		this.talkID = talkID;
		this.text = wordAttachment(new String[] { Topic.AGREE.toString(), talkType.toString(),
				"day" + String.valueOf(talkDay), "ID:" + String.valueOf(talkID) });
	}

}
