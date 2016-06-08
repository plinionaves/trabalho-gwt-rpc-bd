package org.libertas.pjn.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CadastroJogo extends DialogBox {

	private TextoLabel txtNome = new TextoLabel("Nome");
	private TextoLabel txtClassificacao = new TextoLabel("Classificação");
	private TextoLabel txtAno = new TextoLabel("Ano");
	private TextoLabel txtPlataforma = new TextoLabel("Plataforma");
	private Button btnSalvar = new Button("Salvar");
	private Button btnCancelar = new Button("Cancelar");
	
	private VerticalPanel painel = new VerticalPanel();
	private HorizontalPanel painelBtn = new HorizontalPanel();
	
	private Jogo jogo;
	
	public CadastroJogo(Jogo jogo) {
		this.jogo = jogo;
		
		if(jogo.getId() > 0) {
			txtNome.setText(jogo.getNome());
			txtClassificacao.setText(jogo.getClassificacao());
			txtAno.setText(String.valueOf(jogo.getAno()));
			txtPlataforma.setText(jogo.getPlataforma());
		}
		
		painel.add(txtNome);
		painel.add(txtClassificacao);
		painel.add(txtAno);
		painel.add(txtPlataforma);
		painelBtn.add(btnSalvar);
		painelBtn.add(btnCancelar);
		painel.add(painelBtn);
		
		super.add(painel);
		
		btnSalvar.addClickHandler(new ClickHandlerCustom<Jogo>(jogo) {
			
			@Override
			public void onClick(ClickEvent event) {
				
				if(this.getObject().getId() == 0) {
					
					Jogo j = new Jogo();
					j.setNome(txtNome.getText());
					j.setClassificacao(txtClassificacao.getText());
					j.setAno(Integer.parseInt(txtAno.getText()));
					j.setPlataforma(txtPlataforma.getText());
					
					Servico.Util.getInstance().novoJogo(j, new AsyncCallback<Boolean>() {
						
						@Override
						public void onSuccess(Boolean result) {
							//Window.alert("Jogo cadastrado com sucesso!");
							hide();
							Main.getMain().listar();
						}
						
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Erro ao inserir jogo!");
						}
						
					});
					
				} else {
					
					this.getObject().setNome(txtNome.getText());
					this.getObject().setClassificacao(txtClassificacao.getText());
					this.getObject().setAno(Integer.parseInt(txtAno.getText()));
					this.getObject().setPlataforma(txtPlataforma.getText());
					Servico.Util.getInstance().alterarJogo(this.getObject(), new AsyncCallback<Boolean>() {
						
						@Override
						public void onSuccess(Boolean result) {
							hide();
							Main.getMain().listar();
							//Window.alert("Jogo alterado com sucesso!");
						}
						
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Erro ao alterar jogo!");
						}
					});
					
				}

			}
			
		});
		
		btnCancelar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
	}

}
