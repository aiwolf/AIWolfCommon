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
public class DivineContentBuilder extends ContentBuilder {

	public DivineContentBuilder(Agent target, Species result) {
		this.topic = Topic.DIVINED;
		this.target = target;
		// TODO resultの処理
		this.text = wordAttachment(
				new String[] { Topic.DIVINED.toString(), String.valueOf(target.toString()), result.toString() });
	}

}
