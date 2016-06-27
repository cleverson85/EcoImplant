package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.example.drawerlayout.R;

public class ListaMenu {
	
	private static List<ListaModelo> grupo = new ArrayList<ListaModelo>();
	private static ArrayList<Object> subItem = new ArrayList<Object>();
	private static ArrayList<ListaModeloSub> item = new ArrayList<ListaModeloSub>();
		
	public static List<ListaModelo> loadItemMenu(){
		
		grupo.add(new ListaModelo(R.layout.activity_main, R.drawable.ic_home, "Home"));
		grupo.add(new ListaModelo(R.layout.fragment_consc, R.drawable.ic_conscient, "Conscientização"));
		grupo.add(new ListaModelo(R.layout.fragment_descarte, R.drawable.ic_descarte, "Descarte"));
		grupo.add(new ListaModelo(R.layout.fragment_locais, R.drawable.ic_location, "Locais"));
		grupo.add(new ListaModelo(R.layout.fragment_nreciclavel, R.drawable.ic_naoreciclav, "Não Recicláveis"));
		grupo.add(new ListaModelo(R.layout.fragment_jogos, R.drawable.ic_jogos, "Jogos"));
		grupo.add(new ListaModelo(R.layout.fragment_reuso, R.drawable.ic_recycle, "Reutilizar"));
		grupo.add(new ListaModelo(R.layout.fragment_tecnica, R.drawable.ic_gear, "Ass. Técnica"));
		grupo.add(new ListaModelo(R.layout.fragment_sugest, R.drawable.ic_sugest, "Sugestões"));
				
		return grupo;
	}
	
	public static List<ListaModelo> loadItemMenuSemId(){
				
		grupo.add(new ListaModelo(R.drawable.ic_home, "Home"));
		grupo.add(new ListaModelo(R.drawable.ic_conscient, "Conscientização"));
		grupo.add(new ListaModelo(R.drawable.ic_descarte, "Descarte"));
		grupo.add(new ListaModelo(R.drawable.ic_location, "Locais"));
		grupo.add(new ListaModelo(R.drawable.ic_naoreciclav, "Não Recicláveis"));
		grupo.add(new ListaModelo(R.drawable.ic_jogos, "Jogos"));
		grupo.add(new ListaModelo(R.drawable.ic_recycle, "Reutilizar"));
		grupo.add(new ListaModelo(R.drawable.ic_gear, "Ass. Técnica"));
		grupo.add(new ListaModelo(R.drawable.ic_sugest, "Sugestões"));
				
		return grupo;
	}
	
	public static List<Object> loadItemMenuSub() {
		
		/**
		 * Add Data For Conscientizar
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "Artigos"));
		item.add(new ListaModeloSub(0, "Videos"));
		subItem.add(item);
		/**
		 * Add Data For Descarte
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "Como descartar"));
		item.add(new ListaModeloSub(0, "Descarte Delivery"));
		item.add(new ListaModeloSub(0, "Reciclando empresas"));
		subItem.add(item);
		/**
		 * Add Data For Locais
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "Mapas"));
		item.add(new ListaModeloSub(0, "Telefones"));
		subItem.add(item);
		/**
		 * Add Data For Não Recicláveis
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "O que fazer?"));
		item.add(new ListaModeloSub(0, "Como descartar tóxicos?"));
		subItem.add(item);
		/**
		 * Add Data For Reutilizar
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "Por que reutilizar?"));
		item.add(new ListaModeloSub(0, "Ouse e Use"));
		item.add(new ListaModeloSub(0, "Videos"));
		subItem.add(item);
		
		return subItem;
	}
}
