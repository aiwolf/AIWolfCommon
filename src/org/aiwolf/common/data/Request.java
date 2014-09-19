package org.aiwolf.common.data;

/**
 * 
 * @author tori
 *
 */
public enum Request {
	Name(true),
	Role(true),
	Talk(true),
	Whisper(true),
	Vote(true),
	Divine(true),
	Guard(true),
	Attack(true),
	Initialize(false),
	DailyInitialize(false),
	DailyFinish(false),
//	Update(false);
	Finish(false);
	
	boolean hasReturn;
	
	private Request(boolean hasReturn) {
		this.hasReturn = hasReturn;
	}
	
	public boolean hasReturn(){
		return hasReturn;
	}
}
