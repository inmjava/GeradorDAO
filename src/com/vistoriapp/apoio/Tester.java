package com.vistoriapp.apoio;

import com.vistoriapp.dao.GeradorDAO;

public class Tester {
	
	public static void main(String[] args) {
		System.out.println(new GeradorDAO().generate(new Gerador("item_verificacao", "descricao ,dica")));
	}

}
