package org.libertas.pjn.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.libertas.pjn.client.Jogo;
import org.libertas.pjn.model.Conexao;

public class JogoDao {
	
	private Connection conexao;
    
    public JogoDao(){
        Conexao con = new Conexao();
        conexao = con.getConexao();
    }
	
	public boolean inserir(Jogo jogo) {
		try {
			String sql = "INSERT INTO jogo " 
					+ "(nome, ano, plataforma,classificacao) " 
					+ "VALUES (?,?,?,?)";
			PreparedStatement prep = conexao.prepareStatement(sql);
			prep.setString(1, jogo.getNome());
			prep.setInt(2, jogo.getAno());
			prep.setString(3, jogo.getPlataforma());
			prep.setString(4, jogo.getClassificacao());
			prep.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean alterar(Jogo jogo) {
		try {
			String sql = "UPDATE jogo " 
					+ "SET nome = ?,"
					+ "ano = ?, "
					+ "plataforma = ?,"
					+ "classificacao = ?  " 
					+ "WHERE id = ?";
			PreparedStatement prep = conexao.prepareStatement(sql);
			prep.setString(1, jogo.getNome());
			prep.setInt(2, jogo.getAno());
			prep.setString(3, jogo.getPlataforma());
			prep.setString(4, jogo.getClassificacao());
			prep.setInt(5, jogo.getId());
			prep.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean excluir(Jogo jogo) {
		try {
			String sql = "DELETE FROM jogo " 
					+ "WHERE id = ?";
			PreparedStatement prep = conexao.prepareStatement(sql);
			prep.setInt(1, jogo.getId());
			prep.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Jogo consultar(int id) {
		try {
			String sql = "SELECT * "
					+ "FROM jogo " 
					+ "WHERE id = ?";
			PreparedStatement prep = conexao.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet res = prep.executeQuery();
			
			Jogo jogo = new Jogo();
			if (res.next()) {
				jogo.setNome(res.getString("nome"));
				jogo.setAno(res.getInt("ano"));
				jogo.setPlataforma(res.getString("plataforma"));
				jogo.setClassificacao(res.getString("classificacao"));
				jogo.setId(res.getInt("id"));
			}
			return jogo;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Jogo> listar() {
		try {
			String sql = "SELECT * FROM jogo";
			PreparedStatement prep = conexao.prepareStatement(sql);
			ResultSet res = prep.executeQuery();
			
			ArrayList<Jogo> lista = new ArrayList<Jogo>();
			
			while (res.next()) {
				Jogo jogo = new Jogo();
				jogo.setNome(res.getString("nome"));
				jogo.setAno(res.getInt("ano"));
				jogo.setPlataforma(res.getString("plataforma"));
				jogo.setClassificacao(res.getString("classificacao"));
				jogo.setId(res.getInt("id"));
				lista.add(jogo);
			}
			return lista;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
