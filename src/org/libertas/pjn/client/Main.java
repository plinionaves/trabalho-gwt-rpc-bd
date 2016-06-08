package org.libertas.pjn.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Main implements EntryPoint {

	private VerticalPanel painel = new VerticalPanel();
	private Button btnListar = new Button("Listar");
	private Button btnNovo = new Button("Novo");
	private HorizontalPanel painelBtn = new HorizontalPanel();
	
	private static Main main;	
	public Main() {
		main = this;
		painelReference = painel;
	}
	
	private static VerticalPanel painelReference;
	public static VerticalPanel getPainel() {
		return painelReference;
	}
	
	@Override
	public void onModuleLoad() {
		
		painelBtn.add(btnListar);
		painelBtn.add(btnNovo);
		RootPanel.get().add(painelBtn);
		RootPanel.get().add(painel);
		
		listar();
		
		btnListar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				listar();
			}
		});
		btnNovo.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				novo();
			}
		});
		
	}
	
	public void novo() {
		Jogo jogo = new Jogo();
		CadastroJogo cad = new CadastroJogo(jogo);
		cad.center();
		cad.show();
	}
	
	public void listar() {
		Servico.Util.getInstance().listarJogos(new AsyncCallback<ArrayList<Jogo>>() {
			
			@Override
			public void onSuccess(ArrayList<Jogo> result) {
				painel.clear();
				if(result.size() > 0) {
					for (Jogo j : result) {
						ItemJogo item = new ItemJogo(j);
						painel.add(item);
					}
				} else{
					painel.add(new Label("Nenhum jogo cadastrado!"));
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Falha ao acesso Servidor");
			}
		});
	}
	
	public static Main getMain(){
		return main;
	}

}
