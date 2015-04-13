package br.com.bpmlab.agenda;


import br.com.bpmlab.agenda.dao.ClienteDAO;
import br.com.bpmlab.agenda.entidade.Cliente;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends Activity {

	private EditText txtNome;
	private EditText txtEmail;
	private EditText txtEndereco;
	private EditText txtTelefone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);

		Button btnOK = (Button) findViewById(R.id.btnOK);
		txtNome = (EditText) findViewById(R.id.txtNome);
		txtEmail = (EditText) findViewById(R.id.txtEmail);
		txtEndereco = (EditText) findViewById(R.id.txtEndereco);
		txtTelefone = (EditText) findViewById(R.id.txtTelefone);

		btnOK.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Cliente cliente = new Cliente();
				cliente.setNome(txtNome.getText().toString());
				cliente.setEmail(txtEmail.getText().toString());
				cliente.setEndereco(txtEndereco.getText().toString());
				cliente.setTelefone(txtTelefone.getText().toString());
				
				ClienteDAO dao = new ClienteDAO(getBaseContext());
				
				if (dao.insert(cliente)) {
					Toast.makeText(getBaseContext(), "Cadastro feito com sucesso", Toast.LENGTH_SHORT).show();
					finish();
				}
			}
		});

	}
}//fim activity
