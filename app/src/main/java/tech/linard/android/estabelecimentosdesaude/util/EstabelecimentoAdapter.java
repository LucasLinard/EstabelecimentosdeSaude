package tech.linard.android.estabelecimentosdesaude.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tech.linard.android.estabelecimentosdesaude.R;
import tech.linard.android.estabelecimentosdesaude.model.Estabelecimento;

/**
 * Created by lucas on 26/11/16.
 */
public class EstabelecimentoAdapter extends ArrayAdapter<Estabelecimento> {
    public EstabelecimentoAdapter(Context context, List<Estabelecimento> estabelecimentoList) {
        super(context, 0, estabelecimentoList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.estabelecimento_list_item, parent, false);
        }
        Estabelecimento currentEstabelecimento = getItem(position);
        TextView nomeFantasia = (TextView) listItemView.findViewById(R.id.txt_nome_fantasia);
        TextView categoria = (TextView) listItemView.findViewById(R.id.txt_categoria);
        TextView bairro = (TextView) listItemView.findViewById(R.id.txt_local);
        ImageView icone = (ImageView) listItemView.findViewById(R.id.list_item_image);

        switch (currentEstabelecimento.getmCategoriaUnidade()) {
            case "HOSPITAL":
                icone.setImageResource(R.drawable.ic_local_hospital_black_24dp);
                break;
            case "POSTO DE SAÚDE":
                icone.setImageResource(R.drawable.ic_local_pharmacy_black_24dp);
                break;
            case "CONSULTÓRIO":
            case "CLÍNICA":
                icone.setImageResource(R.drawable.ic_person_pin_black_24dp);
                break;
            case "URGÊNCIA":
                icone.setImageResource(R.drawable.ic_local_convenience_store_black_24dp);
                break;
        }


        assert currentEstabelecimento != null;
        nomeFantasia.setText(currentEstabelecimento.getmNomeFantasia());
        categoria.setText(currentEstabelecimento.getmCategoriaUnidade());
        bairro.setText(currentEstabelecimento.getmCidade()
                + " - "
                + currentEstabelecimento.getmBairro());
        return listItemView;
    }
}

