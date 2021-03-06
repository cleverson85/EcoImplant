package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.example.drawerlayout.R;
import com.example.modelo.ListaModelo;
import com.example.modelo.ListaModeloSub;
import com.example.modelo.ModeloGeral;

public class ListaMenu {
	
	private ArrayList<ListaModelo> grupo = new ArrayList<ListaModelo>();
	private ArrayList<ListaModeloSub> item = new ArrayList<ListaModeloSub>();
	private ArrayList<ModeloGeral> itemGeral;	
	
	public ListaMenu() {
		
		grupo.add(new ListaModelo(R.layout.activity_main, R.drawable.ic_home, "Home"));
		grupo.add(new ListaModelo(R.layout.fragment_consc, R.drawable.ic_conscient, "Conscientiza��o"));
		grupo.add(new ListaModelo(R.layout.fragment_descarte, R.drawable.ic_descarte, "Descarte"));
		grupo.add(new ListaModelo(R.layout.fragment_locais, R.drawable.ic_location, "Locais"));
		grupo.add(new ListaModelo(R.layout.fragment_nreciclavel, R.drawable.ic_naoreciclav, "N�o Recicl�veis"));
		grupo.add(new ListaModelo(R.layout.activity_desenhar, R.drawable.ic_jogos, "Jogos"));
		grupo.add(new ListaModelo(R.layout.fragment_reuso, R.drawable.ic_recycle, "Reutilizar"));
		grupo.add(new ListaModelo(R.layout.fragment_tecnica, R.drawable.ic_gear, "Ass. T�cnica"));
		grupo.add(new ListaModelo(R.layout.fragment_sugest, R.drawable.ic_sugest, "Sugest�es"));
		
		itemGeral = loadItemMenuSub();
	}
	
	
	public ArrayList<ModeloGeral> getGrupo(){
		return itemGeral;
	}
	
	private ArrayList<ModeloGeral> loadItemMenuSub() {
		
		if(itemGeral == null) {
			itemGeral = new ArrayList<ModeloGeral>();
		}
		
		itemGeral.add(new ModeloGeral(grupo.get(0), null));		//Home
		
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(R.layout.fragment_artigos, "Artigos"));
		item.add(new ListaModeloSub(R.layout.fragment_videos, "Videos"));	
		itemGeral.add(new ModeloGeral(grupo.get(1), item));		//Add Data For Conscientizar - 1
		
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(R.layout.fragment_como_descartar, "Como Descartar"));
		item.add(new ListaModeloSub(R.layout.fragment_delivery, "Descarte Delivery"));
		item.add(new ListaModeloSub(R.layout.fragment_rec_empresas, "Reciclando Empresas"));
		itemGeral.add(new ModeloGeral(grupo.get(2), item));		//Add Data For Descarte - 2
		

		item = new ArrayList<ListaModeloSub>();
		//item.add(new ListaModeloSub(R.layout.fragment_mapas, "Mapas"));
		item.add(new ListaModeloSub(R.layout.fragment_contatos, "Cooperativas"));
		itemGeral.add(new ModeloGeral(grupo.get(3), item));		//Add Data For Locais - 3
		
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(R.layout.fragment_oq_fazer, "O Que Fazer?"));
		item.add(new ListaModeloSub(R.layout.fragment_toxicos, "Como Descartar T�xicos?"));
		itemGeral.add(new ModeloGeral(grupo.get(4), item));		//Add Data For N�o Recicl�veis - 4
		
		itemGeral.add(new ModeloGeral(grupo.get(5), null));		//Add Data For Jogos - 5
		
		item = new ArrayList<ListaModeloSub>();
		item.add(new ListaModeloSub(R.layout.fragment_pq_reutilizar, "Por Que Reutilizar?"));
		item.add(new ListaModeloSub(R.layout.fragment_ouse_use, "Ouse e Use"));
		item.add(new ListaModeloSub(R.layout.fragment_videos_reuse, "Videos"));
		itemGeral.add(new ModeloGeral(grupo.get(6), item));		//Add Data For Reutilizar - 6
		
		itemGeral.add(new ModeloGeral(grupo.get(7), null));		//7 - Ass. T�cnica
		itemGeral.add(new ModeloGeral(grupo.get(8), null));		//8 - Sugest�es
		
		return itemGeral;
		
	}
}

