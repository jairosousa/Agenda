package br.com.bpmlab.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.btnCadastro).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arv) {
						startActivity(new Intent(getBaseContext(),
								Cadastro.class));
					}
				});

		findViewById(R.id.btnListar).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arv) {
						startActivity(new Intent(getBaseContext(), Listar.class));
					}
				});
	}
}
