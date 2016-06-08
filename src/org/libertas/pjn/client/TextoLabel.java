package org.libertas.pjn.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TextoLabel extends Composite {
	private Label lbl = new Label();
	private TextBox txt = new TextBox();
	private VerticalPanel painel = new VerticalPanel();
	
	public TextoLabel(String titulo) {
		lbl.setText(titulo);
		
		painel.add(lbl);
		painel.add(txt);
		
		initWidget(painel);
	}
	
	public String getText() {
		return txt.getText();
	}
	public void setText(String text) {
		txt.setText(text);
	}
	

}
