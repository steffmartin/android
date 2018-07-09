package move.pdsi.facom.ufu.br.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mirandagab on 08/07/2018.
 */
public class CriaBanco extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "move.db";
    private static final  int VERSAO_BANCO = 1;

    //TABELAS
    private static final String TABELA_TIPOSPARTICULAR              = "TipoParticular";
    private static final String TABELA_TIPOSPUBLICO                 = "TipoPublico";
    private static final String TABELA_MEIODETRANSPORTE             = "MeioDeTransporte";
    private static final String TABELA_TIPOSCOMPARTILHADO           = "TiposCompartilhado";
    private static final String TABELA_TIPOSALUGADO                 = "TiposAlugado";
    private static final String TABELA_TIPOGASTO                    = "TipoGasto";
    private static final String TABELA_USUARIO                      = "Usuario";
    private static final String TABELA_ANUNCIO                      = "Anuncio";
    private static final String TABELA_ESTATISTICASCONTA            = "EstatisticasConta";
    private static final String TABELA_EVENTO                       = "Evento";
    private static final String TABELA_ESTATISTICASMEIOTRANSPORTE   = "EstatisticasMeioTransporte";
    private static final String TABELA_USUARIOHASMEIOTRANSPORTE     = "Usuario_has_MeioDeTransporte";
    private static final String TABELA_COMPARTILHADO                = "Compartilhado";
    private static final String TABELA_ALUGADO                      = "Alugado";
    private static final String TABELA_GASTO                        = "Gasto";
    private static final String TABELA_PUBLICO                      = "Publico";
    private static final String TABELA_PARTICULAR                   = "Particular";
    private static final String TABELA_VIAGEM                       = "Viagem";

    //COLUNAS
    //nomes de colunas comuns
    private static final String KEY_ID                              = "_id";
    private static final String KEY_DESCRICAO                       = "descricao";

    //tabela Usuario - colunas
    private static final String KEY_NOME                            = "nome";
    private static final String KEY_SOBRENOME                       = "sobrenome";
    private static final String KEY_EMAIL                           = "email";
    private static final String KEY_SENHA                           = "senha";
    private static final String KEY_FACEBOOK                        = "facebook";
    private static final String KEY_SINCRONIZAR                     = "sincronizar";

    //tabela Anuncio - colunas
    private static final String KEY_ANUNCIANTE                      = "anunciante";
    private static final String KEY_IMAGEM                          = "imagem";
    private static final String KEY_TELEFONE                        = "telefone";
    private static final String KEY_WEBSITE                         = "website";
    private static final String KEY_APPURL                          = "appURL";

    //tabela EstatisticasConta - colunas
    private static final String KEY_USUARIOID                       = "Usuario_id";
    private static final String KEY_QTDMEIOSTRANSPORTES             = "qtdMeiosTransporte";
    private static final String KEY_ULTIMOLOGIN                     = "ultimoLogin";

    //tabela Evento - colunas
    private static final String KEY_MEIODETRANSPORTEID              = "MeioDeTransporte_id";

    //tabela EstatisticasMeioTransporte - colunas
    private static final String KEY_MEDIA                           = "media";
    private static final String KEY_MAXIMO                          = "maximo";
    private static final String KEY_MINIMO                          = "minino";
    private static final String KEY_QTD                             = "qtd";

    //tabela Compartilhado - colunas
    private static final String KEY_TIPOSCOMPARTILHADOID            = "TiposCompartilhado_id";
    private static final String KEY_EMPRESA                         = "empresa";

    //tabela Alugado - colunas
    private static final String KEY_TIPOSALUGADOID                  = "TiposAlugado_id";
    private static final String KEY_LOCADORA                        = "locadora";
    private static final String KEY_MARCA                           = "marca";
    private static final String KEY_MODELO                          = "modelo";
    private static final String KEY_COR                             = "cor";

    //tabela Gasto - colunas
    private static final String KEY_TIPOGASTOID                     = "TipoGasto_id";
    private static final String KEY_VALOR                           = "valor";
    private static final String KEY_OBSERVACAO                      = "observacao";

    //tabela Publico - colunas
    private static final String KEY_TIPOSPUBLICOID                  = "TiposPublico_id";

    //tabela Particular - colunas
    private static final String KEY_TIPOSPARTICULARID               = "TiposParticular_id";

    //tabela Viagem - colunas
    private static final String KEY_EVENTOID                        = "Eventos_id";
    private static final String KEY_INICIO                          = "inicio";
    private static final String KEY_FIM                             = "fim";
    private static final String KEY_DISTANCIA                       = "distancia";

    //CRIAÇÃO DE TABELAS
    //Criação de tabela TiposParticular
    private static final String CREATE_TABLE_TIPOSPARTICULAR = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSPARTICULAR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR NULL);";

    //Criação de tabela TiposPublico
    private static final String CREATE_TABLE_TIPOSPARTICULAR = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSPARTICULAR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR NULL);";

    //Criação de tabela MeioDeTransporte
    private static final String CREATE_TABLE_TIPOSPARTICULAR = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSPARTICULAR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR NULL);";

    //Criação de tabela TiposCompartilhado
    private static final String CREATE_TABLE_TIPOSPARTICULAR = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSPARTICULAR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR NULL);";

    //Criação de tabela TiposAlugado
    private static final String CREATE_TABLE_TIPOSALUGADO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSPARTICULAR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR NULL);";

    //Criação de tabela TipoGasto
    private static final String CREATE_TABLE_TIPOGASTO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOGASTO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR NULL);";

    private Context mContext;

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABELA);
    }
}
