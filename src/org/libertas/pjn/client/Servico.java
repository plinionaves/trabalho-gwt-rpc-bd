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
package org.libertas.pjn.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Servico")
public interface Servico extends RemoteService {
	
	public ArrayList<Jogo> listarJogos();
	public boolean novoJogo(Jogo j);
	public boolean alterarJogo(Jogo j);
	public boolean excluirJogo(Jogo j);
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static ServicoAsync instance;
		public static ServicoAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Servico.class);
			}
			return instance;
		}
	}
}
