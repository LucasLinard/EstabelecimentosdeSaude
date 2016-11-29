package tech.linard.android.estabelecimentosdesaude.activities;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import tech.linard.android.estabelecimentosdesaude.R;
import tech.linard.android.estabelecimentosdesaude.model.Estabelecimento;
import tech.linard.android.estabelecimentosdesaude.util.EstabelecimentoAdapter;
import tech.linard.android.estabelecimentosdesaude.util.EstabelecimentoLoader;

public class ResultActiviity extends BaseActivity
    implements LoaderManager.LoaderCallbacks<List<Estabelecimento>> {
    private static final String LOG_TAG = ResultActiviity.class.getName();
    private static final int ESTABELECIMENTO_LOADER_ID = 1;
    private EstabelecimentoAdapter mEstabelecimentoAdapter;
    URL TCU_URL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String receivedString = intent.getStringExtra("URL");
        Log.d(LOG_TAG, receivedString);
        try {
            TCU_URL = new URL(receivedString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // List View
        final ListView estabelecimentosList = (ListView) findViewById(R.id.estabelecimentos_list);
        mEstabelecimentoAdapter = new EstabelecimentoAdapter(this, new ArrayList<Estabelecimento>());
        estabelecimentosList.setAdapter(mEstabelecimentoAdapter);
        estabelecimentosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Estabelecimento currentEstabelecimento = mEstabelecimentoAdapter.getItem(i);
                Intent intent = new Intent(getApplicationContext(), EstabelecimentoActivity.class);
                intent.putExtra("estabelecimento", currentEstabelecimento);
                startActivity(intent);
            }
        });

        //Loader
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(ESTABELECIMENTO_LOADER_ID, null, this);
     }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public Loader<List<Estabelecimento>> onCreateLoader(int i, Bundle bundle) {
        showProgressDialog();
        Log.e(LOG_TAG, "onCreateLoader");
        return new EstabelecimentoLoader(this, TCU_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Estabelecimento>> loader, List<Estabelecimento> estabelecimentos) {
        hideProgressDialog();
        Log.e(LOG_TAG, "onLoadFinished");
        mEstabelecimentoAdapter.clear();
        if (estabelecimentos != null && !estabelecimentos.isEmpty()) {
            mEstabelecimentoAdapter.addAll(estabelecimentos);
        }
    }
     @Override
    public void onLoaderReset(Loader<List<Estabelecimento>> loader) {
        Log.e(LOG_TAG, "onLoaderReset");
        mEstabelecimentoAdapter.clear();
    }
}
