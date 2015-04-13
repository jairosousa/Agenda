package br.com.bpmlab.agenda;

import br.com.bpmlab.agenda.dao.ClienteDAO;
import br.com.bpmlab.agenda.entidade.Cliente;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends Activity {

	private Integer ID = 0;
	private EditText txtID;
	private EditText txtNome;
	private EditText txtEmail;
	private EditText txtEndereco;
	private EditText txtTelefone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editar);

		Intent it = getIntent();
		ID = it.getIntExtra("codigo", 1);

		Button btnOK = (Button) findViewById(R.id.btnOK);
		Button btnApagar = (Button) findViewById(R.id.btnApagar);

		final ClienteDAO dao = new ClienteDAO(getBaseContext());
		final Cliente cliente = dao.getById(ID);

		txtID = (EditText) findViewById(R.id.txtID);
		txtNome = (EditText) findViewById(R.id.txtNome);
		txtEmail = (EditText) findViewById(R.id.txtEmail);
		txtEndereco = (EditText) findViewById(R.id.txtEndereco);
		txtTelefone = (EditText) findViewById(R.id.txtTelefone);

		txtID.setText(cliente.getId().toString());
		txtNome.setText(cliente.getNome());
		txtEmail.setText(cliente.getEmail());
		txtEndereco.setText(cliente.getEndereco());
		txtTelefone.setText(cliente.getTelefone());

		btnApagar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Builder msg = new Builder(Editar.this);
				msg.setMessage("Deseja excluir o cliente "+cliente.getNome()+"?");
				msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (dao.delete(cliente)) {
							Toast.makeText(getBaseContext(), "Excluido com Sucesso", Toast.LENGTH_SHORT).show();
							finish();
						}
						
					}
				});
				
				msg.setNegativeButton("Não", null);
				
				msg.show();
				
			}
		});

		btnOK.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Cliente cliente = new Cliente();
				cliente.setId(ID);
				cliente.setNome(txtNome.getText().toString());
				cliente.setEmail(txtEmail.getText().toString());
				cliente.setEndereco(txtEndereco.getText().toString());
				cliente.setTelefone(txtTelefone.getText().toString());

				ClienteDAO dao = new ClienteDAO(getBaseContext());

				if (dao.update(cliente)) {
					Toast.makeText(getBaseContext(), "Atualizado com Sucesso",
							Toast.LENGTH_SHORT).show();
					finish();
				}
			}
		});

	}

}// fim activity