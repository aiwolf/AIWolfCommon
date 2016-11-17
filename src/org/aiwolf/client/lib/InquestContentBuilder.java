/**
 * 
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Species;

/**
 * @author otsuki
 *
 */
public class InquestContentBuilder extends ContentBuilder {

	public InquestContentBuilder(Agent target, Species result) {
		this.topic = Topic.INQUESTED;
		this.target = target;
		// TODO resultの処理
		this.text = wordAttachment(
				new String[] { Topic.INQUESTED.toString(), String.valueOf(target.toString()), result.toString() });
	}

}
