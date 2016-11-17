/**
 * 
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * @author otsuki
 *
 */
public class GuardContentBuilder extends ContentBuilder {

	public GuardContentBuilder(Agent target) {
		this.topic = Topic.GUARDED;
		this.target = target;
		this.text = wordAttachment(new String[] { Topic.GUARDED.toString(), String.valueOf(target.toString()) });
	}

}
