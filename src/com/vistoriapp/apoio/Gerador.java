package com.vistoriapp.apoio;

import java.util.ArrayList;
import java.util.List;

public class Gerador {

	private String nomeTabela;
	private List<String> lstColunas;

	public Gerador(String nomeTabela, String colunas) {
		this.nomeTabela = nomeTabela.toLowerCase();
		String[] arrColunas = colunas.split(",");
		lstColunas = new ArrayList<String>();
		for (int i = 0; i < arrColunas.length; i++) {
			lstColunas.add(arrColunas[i].trim().toLowerCase());
		}
	}

	public int size() {
		return lstColunas.size();
	}
	
	public String getNomeTabelaClass() {
		return convertToCamel(this.nomeTabela, true);
	}
	
	public String getNomeTabelaVar() {
		return convertToCamel(this.nomeTabela, false);
	}
	
	public String getNomeColunaGet(int position){
		return convertToCamel(this.lstColunas.get(position), true);
	}
	
	public String getNomeColunaConstante(int position){
		return this.lstColunas.get(position).toUpperCase();
	}
	
	public String getNomeTabela(){
		return this.nomeTabela;
	}
	
	public String getNomeColuna(int position){
		return this.lstColunas.get(position);
	}

	private String convertToCamel(String valor, boolean firstUpper) {
		valor = valor.toLowerCase();
		if (firstUpper) {
			valor = valor.substring(0, 1).toUpperCase() + valor.substring(1);
		}
		int indexOf_ = valor.indexOf("_");
		while (indexOf_ != -1) {
			valor = valor.substring(0, indexOf_)
					+ (valor.charAt(indexOf_ + 1) + "").toUpperCase()
					+ valor.substring(indexOf_ + 2);
			indexOf_ = valor.indexOf("_");
		}
		return valor;
	}

}
