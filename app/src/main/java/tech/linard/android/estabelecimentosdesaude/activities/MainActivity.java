package tech.linard.android.estabelecimentosdesaude.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.google.android.gms.maps.GoogleMap;

import tech.linard.android.estabelecimentosdesaude.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Spinner mUfSpinner;
    private Spinner mEspecialidadeSpinner;
    private Spinner mCategoriaSpinner;
    private String mUf;
    private String mEspecialidade;
    private String mCategoria;
    private String mPagina = "0";
    private String mQuantidade = "30";
    private CheckBox checkBoxVinculoSUS;
    private String mVinculoSUS = "";
    private Button mPesquisaButton;
    private Button mMapasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isLogged()) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    private String montaURL() {
        final String BASE_URL =
                "http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/estabelecimentos?";
        final String UF_PARAM = "uf";
        final String CATEGORIA_PARAM = "categoria";
        final String ESPECIALIDADE_PARAM = "especialidade";
        final String VINCULO_SUS_PARAM = "vinculoSus";
        final String PAGINA_PARAM = "pagina";
        final String QUANTIDADE_PARAM = "quantidade";

        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(UF_PARAM, mUf)
                .appendQueryParameter(CATEGORIA_PARAM, mCategoria)
                .appendQueryParameter(ESPECIALIDADE_PARAM, mEspecialidade)
                .appendQueryParameter(VINCULO_SUS_PARAM, mVinculoSUS)
                .appendQueryParameter(PAGINA_PARAM, mPagina)
                .appendQueryParameter(QUANTIDADE_PARAM, mQuantidade)
                .build();
        return builtUri.toString();
    }

    private void initializeViews() {
        mUfSpinner = (Spinner) findViewById(R.id.spinner_uf);
        ArrayAdapter<CharSequence> ufAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.uf_array,
                        android.R.layout.simple_spinner_item);
        ufAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mUfSpinner.setAdapter(ufAdapter);
        mUfSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (mUfSpinner.getSelectedItem().equals("Todas")) {
                    mUf  = "";
                } else {
                mUf = (String) mUfSpinner.getSelectedItem();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mUf = "";
            }
        });

        mEspecialidadeSpinner = (Spinner) findViewById(R.id.spinner_especialidade);
        ArrayAdapter<CharSequence> especialidadeAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.especialidade_array,
                        android.R.layout.simple_spinner_item);
        especialidadeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mEspecialidadeSpinner.setAdapter(especialidadeAdapter);
        mEspecialidadeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (mEspecialidadeSpinner.getSelectedItem().equals("Todas")) {
                    mEspecialidade = "";
                } else {
                    mEspecialidade = (String) mEspecialidadeSpinner.getSelectedItem();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mEspecialidade = "";
            }
        });

        mCategoriaSpinner = (Spinner) findViewById(R.id.spinner_categoria);
        ArrayAdapter<CharSequence> categoriaAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.categoria_array,
                        android.R.layout.simple_spinner_item);
        categoriaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCategoriaSpinner.setAdapter(categoriaAdapter);
        mCategoriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (mCategoriaSpinner.getSelectedItem().equals("Todas")) {
                    mCategoria = "";
                } else {
                    mCategoria= (String) mCategoriaSpinner.getSelectedItem();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mCategoria = "";
            }
        });

        checkBoxVinculoSUS = (CheckBox) findViewById(R.id.checkbox_vinculo_sus);
        checkBoxVinculoSUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxVinculoSUS.isChecked()) {
                    mVinculoSUS = "Sim";
                } else {
                    mVinculoSUS = "";
                }
            }
        });
        mPesquisaButton = (Button) findViewById(R.id.btn_pesquisar);
        mPesquisaButton.setOnClickListener(this);

        mMapasButton = (Button) findViewById(R.id.btn_open_map);
        mMapasButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pesquisar:
                Intent intent = new Intent(this, ResultActiviity.class);
                intent.putExtra("URL", montaURL());
                startActivity(intent);
                break;
            case R.id.btn_open_map:
                startActivity(new Intent(this, MapsActivity.class));
                break;
        }
    }
}
