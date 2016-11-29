package tech.linard.android.estabelecimentosdesaude.util;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.net.URL;
import java.util.List;

import tech.linard.android.estabelecimentosdesaude.model.Estabelecimento;

/**
 * Created by lucas on 26/11/16.
 */

public class EstabelecimentoLoader extends AsyncTaskLoader<List<Estabelecimento>> {
    private URL mUrl;

    public EstabelecimentoLoader(Context context, URL url) {
        super(context);
        mUrl = url;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Estabelecimento> loadInBackground() {
        return QueryUtils.fetchEstabelecimentoData(mUrl);
    }
}
