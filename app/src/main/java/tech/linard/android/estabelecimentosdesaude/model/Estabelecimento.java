package tech.linard.android.estabelecimentosdesaude.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by lucas on 26/11/16.
 */

public class Estabelecimento implements Parcelable {
    private String mCodCnes;
    private String mCodUnidade;
    private String mCodIbge;
    private String mCnpj;
    private String mNomeFantasia;
    private String mNatureza;
    private String mTipoUnidade;
    private String mEsferaAdministrativa;
    private String mRetencao;
    private String mFluxoClientela;
    private String mDescricaoCompleta;
    private String mTipoUnidadeCnes;
    private String mCategoriaUnidade;
    private String mLogradouro;
    private String mNumero;
    private String mBairro;
    private String mCidade;
    private String mUf;
    private String mCep;
    private String mTurnoAtendimento;
    private String mTelefone;

    private boolean mVinculoSus;
    private boolean mTemAtendimentoUrgencia;
    private boolean mTemAtendimentoAmbulatorial;
    private boolean mTemCentroCirurgico;
    private boolean mTemObstetra;
    private boolean mTemNeoNatal;
    private boolean mTemDialise;

    private double mLatitude;
    private double mLongitude;

    public Estabelecimento() {
    }

    private Estabelecimento(Parcel in) {
        this.mCodCnes = in.readString();
        this.mCodUnidade = in.readString();
        this.mCodIbge = in.readString();
        this.mCnpj = in.readString();
        this.mNomeFantasia = in.readString();
        this.mNatureza = in.readString();
        this.mTipoUnidade = in.readString();
        this.mEsferaAdministrativa = in.readString();
        this.mRetencao = in.readString();
        this.mFluxoClientela = in.readString();
        this.mDescricaoCompleta = in.readString();
        this.mTipoUnidadeCnes = in.readString();
        this.mCategoriaUnidade = in.readString();
        this.mLogradouro = in.readString();
        this.mNumero = in.readString();
        this.mBairro = in.readString();
        this.mCidade = in.readString();
        this.mUf = in.readString();
        this.mCep = in.readString();
        this.mTurnoAtendimento = in.readString();
        this.mTelefone = in.readString();

        boolean[] myBooleanArray = new boolean[7];
        in.readBooleanArray(myBooleanArray);

        this.mVinculoSus = myBooleanArray[0];
        this.mTemAtendimentoUrgencia = myBooleanArray[1];
        this.mTemAtendimentoAmbulatorial = myBooleanArray[2];
        this.mTemCentroCirurgico = myBooleanArray[3];
        this.mTemObstetra = myBooleanArray[4];
        this.mTemNeoNatal = myBooleanArray[5];
        this.mTemDialise = myBooleanArray[6];

        this.mLatitude = in.readDouble();
        this.mLongitude = in.readDouble();
    }

    public String getmCodCnes() {
        return mCodCnes;
    }

    public void setmCodCnes(String mCodCnes) {
        this.mCodCnes = mCodCnes;
    }

    public String getmCodUnidade() {
        return mCodUnidade;
    }

    public void setmCodUnidade(String mCodUnidade) {
        this.mCodUnidade = mCodUnidade;
    }

    public String getmCodIbge() {
        return mCodIbge;
    }

    public void setmCodIbge(String mCodIbge) {
        this.mCodIbge = mCodIbge;
    }

    public String getmCnpj() {
        return mCnpj;
    }

    public void setmCnpj(String mCnpj) {
        this.mCnpj = mCnpj;
    }

    public String getmNomeFantasia() {
        return mNomeFantasia;
    }

    public void setmNomeFantasia(String mNomeFantasia) {
        this.mNomeFantasia = mNomeFantasia;
    }

    public String getmNatureza() {
        return mNatureza;
    }

    public void setmNatureza(String mNatureza) {
        this.mNatureza = mNatureza;
    }

    public String getmTipoUnidade() {
        return mTipoUnidade;
    }

    public void setmTipoUnidade(String mTipoUnidade) {
        this.mTipoUnidade = mTipoUnidade;
    }

    public String getmEsferaAdministrativa() {
        return mEsferaAdministrativa;
    }

    public void setmEsferaAdministrativa(String mEsferaAdministrativa) {
        this.mEsferaAdministrativa = mEsferaAdministrativa;
    }

    public String getmRetencao() {
        return mRetencao;
    }

    public void setmRetencao(String mRetencao) {
        this.mRetencao = mRetencao;
    }

    public String getmFluxoClientela() {
        return mFluxoClientela;
    }

    public void setmFluxoClientela(String mFluxoClientela) {
        this.mFluxoClientela = mFluxoClientela;
    }

    public String getmDescricaoCompleta() {
        return mDescricaoCompleta;
    }

    public void setmDescricaoCompleta(String mDescricaoCompleta) {
        this.mDescricaoCompleta = mDescricaoCompleta;
    }

    public String getmTipoUnidadeCnes() {
        return mTipoUnidadeCnes;
    }

    public void setmTipoUnidadeCnes(String mTipoUnidadeCnes) {
        this.mTipoUnidadeCnes = mTipoUnidadeCnes;
    }

    public String getmCategoriaUnidade() {
        return mCategoriaUnidade;
    }

    public void setmCategoriaUnidade(String mCategoriaUnidade) {
        this.mCategoriaUnidade = mCategoriaUnidade;
    }

    public String getmLogradouro() {
        return mLogradouro;
    }

    public void setmLogradouro(String mLogradouro) {
        this.mLogradouro = mLogradouro;
    }

    public String getmNumero() {
        return mNumero;
    }

    public void setmNumero(String mNumero) {
        this.mNumero = mNumero;
    }

    public String getmBairro() {
        return mBairro;
    }

    public void setmBairro(String mBairro) {
        this.mBairro = mBairro;
    }

    public String getmCidade() {
        return mCidade;
    }

    public void setmCidade(String mCidade) {
        this.mCidade = mCidade;
    }

    public String getmUf() {
        return mUf;
    }

    public void setmUf(String mUf) {
        this.mUf = mUf;
    }

    public String getmCep() {
        return mCep;
    }

    public void setmCep(String mCep) {
        this.mCep = mCep;
    }

    public String getmTurnoAtendimento() {
        return mTurnoAtendimento;
    }

    public void setmTurnoAtendimento(String mTurnoAtendimento) {
        this.mTurnoAtendimento = mTurnoAtendimento;
    }

    public String getmTelefone() {
        if (TextUtils.isEmpty(this.mTelefone)) {
            mTelefone = "Telefone não cadastrado.";
        }
        return mTelefone;
    }

    public void setmTelefone(String mTelefone) {
        this.mTelefone = mTelefone;
    }

    public boolean ismVinculoSus() {
        return mVinculoSus;
    }

    public void setmVinculoSus(boolean mVinculoSus) {
        this.mVinculoSus = mVinculoSus;
    }

    public boolean ismTemAtendimentoUrgencia() {
        return mTemAtendimentoUrgencia;
    }

    public void setmTemAtendimentoUrgencia(boolean mTemAtendimentoUrgencia) {
        this.mTemAtendimentoUrgencia = mTemAtendimentoUrgencia;
    }

    public boolean ismTemAtendimentoAmbulatorial() {
        return mTemAtendimentoAmbulatorial;
    }

    public void setmTemAtendimentoAmbulatorial(boolean mTemAtendimentoAmbulatorial) {
        this.mTemAtendimentoAmbulatorial = mTemAtendimentoAmbulatorial;
    }

    public boolean ismTemCentroCirurgico() {
        return mTemCentroCirurgico;
    }

    public void setmTemCentroCirurgico(boolean mTemCentroCirurgico) {
        this.mTemCentroCirurgico = mTemCentroCirurgico;
    }

    public boolean ismTemObstetra() {
        return mTemObstetra;
    }

    public void setmTemObstetra(boolean mTemObstetra) {
        this.mTemObstetra = mTemObstetra;
    }

    public boolean ismTemNeoNatal() {
        return mTemNeoNatal;
    }

    public void setmTemNeoNatal(boolean mTemNeoNatal) {
        this.mTemNeoNatal = mTemNeoNatal;
    }

    public boolean ismTemDialise() {
        return mTemDialise;
    }

    public void setmTemDialise(boolean mTemDialise) {
        this.mTemDialise = mTemDialise;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmEndereco() {
        String logradouro;
        String numero;
        String bairro;
        String cidade;
        String uf;
        String mEndereco;
        mEndereco =       this.getmLogradouro()
                + ", " + this.getmNumero()
                + ", " + this.getmBairro()
                + ". " + this.getmCidade()
                + ", " + this.getmUf();
        return mEndereco;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getmCodCnes());
        parcel.writeString(getmCodUnidade());
        parcel.writeString(getmCodIbge());
        parcel.writeString(getmCnpj());
        parcel.writeString(getmNomeFantasia());
        parcel.writeString(getmNatureza());
        parcel.writeString(getmTipoUnidade());
        parcel.writeString(getmEsferaAdministrativa());
        parcel.writeString(getmRetencao());
        parcel.writeString(getmFluxoClientela());
        parcel.writeString(getmDescricaoCompleta());
        parcel.writeString(getmTipoUnidadeCnes());
        parcel.writeString(getmCategoriaUnidade());
        parcel.writeString(getmLogradouro());
        parcel.writeString(getmNumero());
        parcel.writeString(getmBairro());
        parcel.writeString(getmCidade());
        parcel.writeString(getmUf());
        parcel.writeString(getmCep());
        parcel.writeString(getmTurnoAtendimento());
        parcel.writeString(getmTelefone());

        boolean[] booleanArray = new boolean[7];

        booleanArray [0] = mVinculoSus;
        booleanArray [1] = mTemAtendimentoUrgencia;
        booleanArray [2] = mTemAtendimentoAmbulatorial;
        booleanArray [3] = mTemCentroCirurgico;
        booleanArray [4] = mTemObstetra;
        booleanArray [5] = mTemNeoNatal;
        booleanArray [6] = mTemDialise;

        parcel.writeBooleanArray(booleanArray);

        parcel.writeDouble(getmLatitude());
        parcel.writeDouble(getmLongitude());
    }
    public static final Parcelable.Creator<Estabelecimento> CREATOR
            = new Parcelable.Creator<Estabelecimento>() {

        @Override
        public Estabelecimento createFromParcel(Parcel in) {
            return new Estabelecimento(in);
        }

        @Override
        public Estabelecimento[] newArray(int size) {
            return new Estabelecimento[size];
        }
    };

}
