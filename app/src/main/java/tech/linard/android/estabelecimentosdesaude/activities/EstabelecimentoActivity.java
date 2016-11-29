package tech.linard.android.estabelecimentosdesaude.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import tech.linard.android.estabelecimentosdesaude.R;
import tech.linard.android.estabelecimentosdesaude.model.Estabelecimento;

public class EstabelecimentoActivity extends BaseActivity implements View.OnClickListener {

    Estabelecimento currentEstabelecimento;
    TextView txtNomeFantasia;
    TextView txtFuncionamento;
    TextView txtEndereco;
    TextView txtTelefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento);
        Intent intent = getIntent();
        currentEstabelecimento = intent.getParcelableExtra("estabelecimento");
        preencheCampos();
        adicionaListener();
    }

    private void adicionaListener() {
        txtEndereco.setOnClickListener(this);
        findViewById(R.id.img_endereço).setOnClickListener(this);
    }

    private void preencheCampos() {
        txtFuncionamento = (TextView) findViewById(R.id.detail_turno);
        txtFuncionamento.setText(currentEstabelecimento.getmTurnoAtendimento());

        txtNomeFantasia = (TextView) findViewById(R.id.detail_nome_fantasia);
        txtNomeFantasia.setText(currentEstabelecimento.getmNomeFantasia());

        txtTelefone = (TextView) findViewById(R.id.detail_telefone);
        txtTelefone.setText(currentEstabelecimento.getmTelefone());

        txtEndereco = (TextView) findViewById(R.id.detail_endereco);
        txtEndereco.setText(currentEstabelecimento.getmEndereco());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_endereco:
                String location = "geo:"
                        + currentEstabelecimento.getmLatitude()
                        +  ","
                        + currentEstabelecimento.getmLongitude()
                        +"?q="
                        + currentEstabelecimento.getmLogradouro()
                        + "+"
                        + currentEstabelecimento.getmCidade()
                        ;

                Uri gmmIntentUri = Uri.parse(location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;
            case R.id.img_endereço:
                Intent intent = new Intent(this, MapsActivity.class);

                intent.putExtra("COORDENADAS", new LatLng(
                        currentEstabelecimento.getmLatitude(),
                        currentEstabelecimento.getmLongitude()));
                intent.putExtra("NOME", currentEstabelecimento.getmNomeFantasia());
                startActivity(intent);
        }
    }
}
