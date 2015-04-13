package br.com.bpmlab.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.bpmlab.agenda.DB;
import br.com.bpmlab.agenda.entidade.Cliente;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ClienteDAO {
	private static String table_name = "clientes";
	private static Context ctx;
	private static String[] columns = { "id", "nome", "email", "endereco","telefone" };

	public ClienteDAO(Context ctx) {
		this.ctx = ctx;
	}

	public boolean insert(Cliente cliente) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		ContentValues ctv = new ContentValues();
		ctv.put("nome", cliente.getNome());
		ctv.put("email", cliente.getEmail());
		ctv.put("endereco", cliente.getEndereco());
		ctv.put("telefone", cliente.getTelefone());

		return (db.insert(table_name, null, ctv) > 0);
	}

	public boolean delete(Cliente cliente) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		return (db.delete(table_name, "id=?", new String[] { cliente.getId()
				.toString() }) > 0);
	}

	public boolean update(Cliente cliente) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		ContentValues ctv = new ContentValues();
		ctv.put("nome", cliente.getNome());
		ctv.put("email", cliente.getEmail());
		ctv.put("endereco", cliente.getEndereco());
		ctv.put("telefone", cliente.getTelefone());

		return (db.update(table_name, ctv, "id=?", new String[] { cliente
				.getId().toString() }) > 0);
	}

	public Cliente getById(Integer ID) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();

		Cursor rs = db.query(table_name, columns, "id=?",
				new String[] { ID.toString() }, null, null, null);

		Cliente cliente = null;

		if (rs.moveToFirst()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt(rs.getColumnIndex("id")));
			cliente.setNome(rs.getString(rs.getColumnIndex("nome")));
			cliente.setEmail(rs.getString(rs.getColumnIndex("email")));
			cliente.setEndereco(rs.getString(rs.getColumnIndex("endereco")));
			cliente.setTelefone(rs.getString(rs.getColumnIndex("telefone")));
		}
		return cliente;
	}

	public List<Cliente> getAll() {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();

		Cursor rs = db.rawQuery("SELECT * FROM clientes", null);
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		while (rs.moveToNext()) {
			Cliente cliente = new Cliente(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			lista.add(cliente);
		}
		return lista;
	}

}
