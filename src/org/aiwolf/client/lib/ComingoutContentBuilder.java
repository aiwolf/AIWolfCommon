/**
 * 
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;

/**
 * @author otsuki
 *
 */
public class ComingoutContentBuilder extends ContentBuilder {

	public ComingoutContentBuilder(Agent target, Role role) {
		this.topic = Topic.COMINGOUT;
		this.target = target;
		// TODO roleの処理
		this.text = wordAttachment(
				new String[] { Topic.COMINGOUT.toString(), String.valueOf(target.toString()), role.toString() });
	}

}
