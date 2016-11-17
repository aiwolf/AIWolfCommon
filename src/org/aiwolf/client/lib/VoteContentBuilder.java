/**
 * 
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * @author otsuki
 *
 */
public class VoteContentBuilder extends ContentBuilder {

	public VoteContentBuilder(Agent target) {
		this.topic = Topic.VOTE;
		this.target = target;
		this.text = wordAttachment(new String[] { Topic.VOTE.toString(), String.valueOf(target.toString()) });
	}

}
