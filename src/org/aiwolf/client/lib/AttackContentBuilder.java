/**
 * 
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * @author otsuki
 *
 */
public class AttackContentBuilder extends ContentBuilder {

	public AttackContentBuilder(Agent target) {
		this.topic = Topic.ATTACK;
		this.target = target;
		this.text = wordAttachment(new String[] { Topic.ATTACK.toString(), String.valueOf(target.toString()) });
	}

}
