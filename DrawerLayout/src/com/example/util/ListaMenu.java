package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.example.drawerlayout.R;

public class ListaMenu {
	
	private ArrayList<ListaModelo> grupo = new ArrayList<ListaModelo>();
	private ArrayList<ListaModeloSub> item = new ArrayList<ListaModeloSub>();
	private ArrayList<ModeloGeral> itemGeral;	
	
	public ListaMenu(boolean id) {
		
		if(id){
			grupo.add(new ListaModelo(R.layout.activity_main, R.drawable.ic_home, "Home"));
			grupo.add(new ListaModelo(R.layout.fragment_consc, R.drawable.ic_conscient, "Conscientização"));
			grupo.add(new ListaModelo(R.layout.fragment_descarte, R.drawable.ic_descarte, "Descarte"));
			grupo.add(new ListaModelo(R.layout.fragment_locais, R.drawable.ic_location, "Locais"));
			grupo.add(new ListaModelo(R.layout.fragment_nreciclavel, R.drawable.ic_naoreciclav, "Não Recicláveis"));
			grupo.add(new ListaModelo(R.layout.fragment_jogos, R.drawable.ic_jogos, "Jogos"));
			grupo.add(new ListaModelo(R.layout.fragment_reuso, R.drawable.ic_recycle, "Reutilizar"));
			grupo.add(new ListaModelo(R.layout.fragment_tecnica, R.drawable.ic_gear, "Ass. Técnica"));
			grupo.add(new ListaModelo(R.layout.fragment_sugest, R.drawable.ic_sugest, "Sugestões"));
		}
		else 
		{
			grupo.add(new ListaModelo(R.drawable.ic_home, "Home"));
			grupo.add(new ListaModelo(R.drawable.ic_conscient, "Conscientização"));
			grupo.add(new ListaModelo(R.drawable.ic_descarte, "Descarte"));
			grupo.add(new ListaModelo(R.drawable.ic_location, "Locais"));
			grupo.add(new ListaModelo(R.drawable.ic_naoreciclav, "Não Recicláveis"));
			grupo.add(new ListaModelo(R.drawable.ic_jogos, "Jogos"));
			grupo.add(new ListaModelo(R.drawable.ic_recycle, "Reutilizar"));
			grupo.add(new ListaModelo(R.drawable.ic_gear, "Ass. Técnica"));
			grupo.add(new ListaModelo(R.drawable.ic_sugest, "Sugestões"));
		}
		
		itemGeral = loadItemMenuSub();
	}
	
	
	public ArrayList<ModeloGeral> getGrupo(){
		return itemGeral;
	}
	
	private ArrayList<ModeloGeral> loadItemMenuSub() {
		
		if(itemGeral == null) {
			itemGeral = new ArrayList<ModeloGeral>();
		}
		
		itemGeral.add(new ModeloGeral(grupo.get(0), null));
		
		/**
		 * Add Data For Conscientizar - 1
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "Artigos"));
		item.add(new ListaModeloSub(0, "Videos"));
		
		itemGeral.add(new ModeloGeral(grupo.get(1), item));
		
		/**
		 * Add Data For Descarte - 2
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "Como descartar"));
		item.add(new ListaModeloSub(0, "Descarte Delivery"));
		item.add(new ListaModeloSub(0, "Reciclando empresas"));
		
		itemGeral.add(new ModeloGeral(grupo.get(2), item));
		
		/**
		 * Add Data For Locais - 3
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "Mapas"));
		item.add(new ListaModeloSub(0, "Telefones"));
		
		itemGeral.add(new ModeloGeral(grupo.get(3), item));
		
		/**
		 * Add Data For Não Recicláveis - 4
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "O que fazer?"));
		item.add(new ListaModeloSub(0, "Como descartar tóxicos?"));
		
		itemGeral.add(new ModeloGeral(grupo.get(4), item));
		
		itemGeral.add(new ModeloGeral(grupo.get(5), null));
		
		/**
		 * Add Data For Reutilizar - 6
		 */
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(0, "Por que reutilizar?"));
		item.add(new ListaModeloSub(0, "Ouse e Use"));
		item.add(new ListaModeloSub(0, "Videos"));
		
		itemGeral.add(new ModeloGeral(grupo.get(6), item));
		
		itemGeral.add(new ModeloGeral(grupo.get(7), null));
		itemGeral.add(new ModeloGeral(grupo.get(8), null));
		
		return itemGeral;
		
	}
}

