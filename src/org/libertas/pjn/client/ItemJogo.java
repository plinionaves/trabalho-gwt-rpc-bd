package org.libertas.pjn.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ItemJogo extends Composite {

	private Label lblNome = new Label();
	private Label lblClassificacao = new Label();
	private Label lblAno = new Label();
	private Label lblPlataforma = new Label();
	private Button btnAlterar = new Button("A");
	private Button btnExcluir = new Button("X");
	private HorizontalPanel painel = new HorizontalPanel();
	private VerticalPanel painelV = new VerticalPanel();
	private Jogo jogo;
	
	public ItemJogo(Jogo jogo) {
		this.jogo = jogo;
		
		// css
		btnAlterar.setStyleName("btn-alterar");
		btnExcluir.setStyleName("btn-excluir");
		lblNome.setStyleName("lbl-nome");
		painel.setStyleName("item-jogo");
		
		lblNome.setText(jogo.getNome());
		lblNome.setWidth("300px");
		lblClassificacao.setText(jogo.getClassificacao());
		lblAno.setText(String.valueOf(jogo.getAno()));
		lblPlataforma.setText(jogo.getPlataforma());
		
		painel.add(lblNome);
		painel.add(lblClassificacao);
		painel.add(lblAno);
		painel.add(lblPlataforma);
		painel.add(btnAlterar);
		painel.add(btnExcluir);
		
		btnExcluir.addClickHandler(new ClickHandlerCustom<Jogo>(jogo) {
			
			@Override
			public void onClick(ClickEvent event) {
				//boolean excluir = Window.confirm("Deseja deletar este item?");
				
				//if(excluir) {
					Servico.Util.getInstance().excluirJogo(this.getObject(), new AsyncCallback<Boolean>() {
						
						@Override
						public void onSuccess(Boolean result) {
							/*if(result) {
								Window.alert("Jogo excluído com sucesso!");
								Main.getMain().listar();
							} else {
								Window.alert("Erro inesperado!");
							}*/
							Main.getMain().listar();
						}
						
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Erro ao excluir jogo!");
						}
						
					});
				//}
			}
		});
		
		btnAlterar.addClickHandler(new ClickHandlerCustom<Jogo>(jogo) {
			
			@Override
			public void onClick(ClickEvent event) {
				
				CadastroJogo cad = new CadastroJogo(this.getObject());
				cad.center();
				cad.show();
				
			}
		});
		
		initWidget(painel);
		
	}
	
}
