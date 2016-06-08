package org.libertas.pjn.client;

import com.google.gwt.event.dom.client.ClickEvent;

public class ClickHandlerCustom<T> implements com.google.gwt.event.dom.client.ClickHandler {
	
	private T object;
	
	public ClickHandlerCustom(T object){
		this.object = object;
	}
	
	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	
}
