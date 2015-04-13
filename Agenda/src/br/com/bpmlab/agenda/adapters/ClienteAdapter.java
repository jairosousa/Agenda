package br.com.bpmlab.agenda.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.bpmlab.agenda.entidade.Cliente;

public class ClienteAdapter extends BaseAdapter {

	private Context ctx;
	private List<Cliente> lista;

	public ClienteAdapter(Context ctx, List<Cliente> lista) {
		this.ctx = ctx;
		this.lista = lista;
	}

	@Override
	public int getCount() {

		return lista.size();
	}

	@Override
	public Object getItem(int position) {

		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Cliente cliente = (Cliente) getItem(position);
		
		LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = layout.inflate(br.com.bpmlab.agenda.R.layout.listar, null);
		
		TextView txtID = (TextView) v.findViewById(br.com.bpmlab.agenda.R.id.textView1);
		txtID.setText(cliente.getId().toString());
		
		TextView txtNome = (TextView) v.findViewById(br.com.bpmlab.agenda.R.id.textView2);
		txtNome.setText(cliente.getNome().toString());
		
		return v;
	}

}
