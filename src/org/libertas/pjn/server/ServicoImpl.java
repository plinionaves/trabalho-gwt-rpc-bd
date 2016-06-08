/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.libertas.pjn.server;

import java.util.ArrayList;

import org.libertas.pjn.client.Jogo;
import org.libertas.pjn.client.Servico;
import org.libertas.pjn.model.JogoDao;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServicoImpl extends RemoteServiceServlet implements Servico {
	
	@Override
	public ArrayList<Jogo> listarJogos() {
		JogoDao jDao = new JogoDao();
		return jDao.listar();
	}

	@Override
	public boolean novoJogo(Jogo j) {
		JogoDao jDao = new JogoDao();
		return jDao.inserir(j);
	}

	@Override
	public boolean alterarJogo(Jogo j) {
		JogoDao jDao = new JogoDao();
		return jDao.alterar(j);
	}

	@Override
	public boolean excluirJogo(Jogo j) {
		JogoDao jDao = new JogoDao();
		return jDao.excluir(j);
	}
	
}
