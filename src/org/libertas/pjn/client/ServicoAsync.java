package org.libertas.pjn.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServicoAsync {

	void listarJogos(AsyncCallback<ArrayList<Jogo>> callback);
	void novoJogo(Jogo j, AsyncCallback<Boolean> callback);
	void alterarJogo(Jogo j, AsyncCallback<Boolean> callback);
	void excluirJogo(Jogo j, AsyncCallback<Boolean> callback);
	
}
