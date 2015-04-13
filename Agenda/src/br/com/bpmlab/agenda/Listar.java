package br.com.bpmlab.agenda;

import br.com.bpmlab.agenda.adapters.ClienteAdapter;
import br.com.bpmlab.agenda.dao.ClienteDAO;
import br.com.bpmlab.agenda.entidade.Cliente;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Listar extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	}
	// Codigo para recuperar um objeto com o click da tela,
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Cliente cliente = (Cliente) l.getAdapter().getItem(position);
		startActivity(new Intent("EdicaoCliente").putExtra("codigo", cliente.getId()));
//		Toast.makeText(getBaseContext(), cliente.getId().toString(), Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		ClienteDAO dao = new ClienteDAO(getBaseContext());
		setListAdapter(new ClienteAdapter(getBaseContext(), dao.getAll()));
	}

}
