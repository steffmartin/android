package move.pdsi.facom.ufu.br.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mirandagab on 08/07/2018.
 */
public class CriaBancoCompleto extends SQLiteOpenHelper {

    private static volatile CriaBancoCompleto instancia;

    private static final String NOME_BANCO = "move.db";
    private static final int VERSAO_BANCO = 1;

    //TABELAS
    private static final String TABELA_TIPOSPARTICULAR = "TipoParticular";
    private static final String TABELA_TIPOSPUBLICO = "TipoPublico";
    private static final String TABELA_MEIODETRANSPORTE = "MeioDeTransporte";
    private static final String TABELA_TIPOSCOMPARTILHADO = "TiposCompartilhado";
    private static final String TABELA_TIPOSALUGADO = "TiposAlugado";
    private static final String TABELA_TIPOGASTO = "TipoGasto";
    private static final String TABELA_USUARIO = "Usuario";
    private static final String TABELA_ANUNCIO = "Anuncio";
    private static final String TABELA_ESTATISTICASCONTA = "EstatisticasConta";
    private static final String TABELA_EVENTO = "Evento";
    private static final String TABELA_ESTATISTICASMEIOTRANSPORTE = "EstatisticasMeioTransporte";
    private static final String TABELA_USUARIOHASMEIOTRANSPORTE = "Usuario_has_MeioDeTransporte";
    private static final String TABELA_COMPARTILHADO = "Compartilhado";
    private static final String TABELA_ALUGADO = "Alugado";
    private static final String TABELA_GASTO = "Gasto";
    private static final String TABELA_PUBLICO = "Publico";
    private static final String TABELA_PARTICULAR = "Particular";
    private static final String TABELA_VIAGEM = "Viagem";

    //COLUNAS
    //nomes de colunas comuns
    private static final String KEY_ID = "_id";
    private static final String KEY_DESCRICAO = "descricao";

    //tabela Usuario - colunas
    private static final String KEY_NOME = "nome";
    private static final String KEY_SOBRENOME = "sobrenome";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_SENHA = "senha";
    private static final String KEY_FACEBOOK = "facebook";
    private static final String KEY_SINCRONIZAR = "sincronizar";

    //tabela Anuncio - colunas
    private static final String KEY_ANUNCIANTE = "anunciante";
    private static final String KEY_IMAGEM = "imagem";
    private static final String KEY_TELEFONE = "telefone";
    private static final String KEY_WEBSITE = "website";
    private static final String KEY_APPURL = "appURL";

    //tabela EstatisticasConta - colunas
    private static final String KEY_USUARIOID = "Usuario_id";
    private static final String KEY_QTDMEIOSTRANSPORTES = "qtdMeiosTransporte";
    private static final String KEY_ULTIMOLOGIN = "ultimoLogin";

    //tabela Evento - colunas
    private static final String KEY_MEIODETRANSPORTEID = "MeioDeTransporte_id";

    //tabela EstatisticasMeioTransporte - colunas
    private static final String KEY_MEDIA = "media";
    private static final String KEY_MAXIMO = "maximo";
    private static final String KEY_MINIMO = "minino";
    private static final String KEY_QTD = "qtd";

    //tabela Compartilhado - colunas
    private static final String KEY_TIPOSCOMPARTILHADOID = "TiposCompartilhado_id";
    private static final String KEY_EMPRESA = "empresa";

    //tabela Alugado - colunas
    private static final String KEY_TIPOSALUGADOID = "TiposAlugado_id";
    private static final String KEY_LOCADORA = "locadora";
    private static final String KEY_MARCA = "marca";
    private static final String KEY_MODELO = "modelo";
    private static final String KEY_COR = "cor";

    //tabela Gasto - colunas
    private static final String KEY_TIPOGASTOID = "TipoGasto_id";
    private static final String KEY_VALOR = "valor";
    private static final String KEY_OBSERVACAO = "observacao";

    //tabela Publico - colunas
    private static final String KEY_TIPOSPUBLICOID = "TiposPublico_id";

    //tabela Particular - colunas
    private static final String KEY_TIPOSPARTICULARID = "TiposParticular_id";

    //tabela Viagem - colunas
    private static final String KEY_EVENTOID = "Eventos_id";
    private static final String KEY_INICIO = "inicio";
    private static final String KEY_FIM = "fim";
    private static final String KEY_DISTANCIA = "distancia";

    //CRIAÇÃO DE TABELAS
    //Criação de tabela TiposParticular
    private static final String CREATE_TABLE_TIPOSPARTICULAR = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSPARTICULAR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR);";

    //Criação de tabela TiposPublico
    private static final String CREATE_TABLE_TIPOSPUBLICO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSPUBLICO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR);";

    //Criação de tabela MeioDeTransporte
    private static final String CREATE_TABLE_MEIODETRANSPORTE = "CREATE TABLE IF NOT EXISTS "
            + TABELA_MEIODETRANSPORTE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR);";

    //Criação de tabela TiposCompartilhado
    private static final String CREATE_TABLE_TIPOSCOMPARTILHADO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSCOMPARTILHADO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR);";

    //Criação de tabela TiposAlugado
    private static final String CREATE_TABLE_TIPOSALUGADO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOSPARTICULAR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR);";

    //Criação de tabela TipoGasto
    private static final String CREATE_TABLE_TIPOGASTO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_TIPOGASTO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_DESCRICAO + " VARCHAR);";

    //Criação de tabela Usuario
    private static final String CREATE_TABLE_USUARIO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_USUARIO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NOME + " VARCHAR NOT NULL," + KEY_SOBRENOME + " VARCHAR NOT NULL,"
            + KEY_EMAIL + " VARCHAR NOT NULL," + KEY_SENHA + " VARCHAR NOT NULL,"
            + KEY_FACEBOOK + " VARCHAR," + KEY_SINCRONIZAR + " BOOL NOT NULL);";

    //Criação de tabela Anuncio
    private static final String CREATE_TABLE_ANUNCIO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_ANUNCIO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_ANUNCIANTE + " VARCHAR," + KEY_IMAGEM + " VARCHAR,"
            + KEY_TELEFONE + " VARCHAR," + KEY_WEBSITE + " VARCHAR,"
            + KEY_APPURL + " VARCHAR);";

    //Criação de tabela EstatisticasConta
    private static final String CREATE_TABLE_ESTATISTICASCONTA = "CREATE TABLE IF NOT EXISTS "
            + TABELA_ESTATISTICASCONTA + "(" + KEY_USUARIOID + " INTEGER PRIMARY KEY,"
            + KEY_QTDMEIOSTRANSPORTES + " INTEGER," + KEY_ULTIMOLOGIN + " DATETIME,"
            + "FOREIGN KEY(" + KEY_USUARIOID + ") REFERENCES " + TABELA_USUARIO + "("
            + KEY_ID + "));";

    //Criação de tabela Evento
    private static final String CREATE_TABLE_EVENTO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_EVENTO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_MEIODETRANSPORTEID + " INTEGER, FOREIGN KEY(" + KEY_MEIODETRANSPORTEID
            + ") REFERENCES " + TABELA_MEIODETRANSPORTE + "(" + KEY_ID + "));";

    //Criação de tabela EstatisticasMeioTransporte
    private static final String CREATE_TABLE_ESTATISTICAMEIOTRANSPORTE = "CREATE TABLE IF NOT EXISTS "
            + TABELA_ESTATISTICASMEIOTRANSPORTE + "(" + KEY_MEIODETRANSPORTEID + " INTEGER PRIMARY KEY,"
            + KEY_MEDIA + " FLOAT," + KEY_MAXIMO + " FLOAT," + KEY_MINIMO + " FLOAT,"
            + KEY_QTD + " INTEGER, FOREIGN KEY(" + KEY_MEIODETRANSPORTEID + ") REFERENCES "
            + TABELA_MEIODETRANSPORTE + "(" + KEY_ID + "));";

    //Criação de tabela Usuario_has_MeioDeTransporte
    private static final String CREATE_TABLE_USUARIOHASMEIODETRANSPORTE = "CREATE TABLE IF NOT EXISTS "
            + TABELA_USUARIOHASMEIOTRANSPORTE + "(" + KEY_USUARIOID + " INTEGER NOT NULL,"
            + KEY_MEIODETRANSPORTEID + " INTEGER NOT NULL, PRIMARY KEY(" + KEY_USUARIOID + ","
            + KEY_MEIODETRANSPORTEID + "), FOREIGN KEY(" + KEY_USUARIOID + ") REFERENCES "
            + TABELA_USUARIO + "(" + KEY_ID + "), FOREIGN KEY(" + KEY_MEIODETRANSPORTEID + ") REFERENCES "
            + TABELA_MEIODETRANSPORTE + "(" + KEY_ID + "));";

    //Criação de tabela Compartilhado
    private static final String CREATE_TABLE_COMPARTILHADO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_COMPARTILHADO + "(" + KEY_MEIODETRANSPORTEID + " INTEGER PRIMARY KEY,"
            + KEY_TIPOSCOMPARTILHADOID + " INTEGER NOT NULL," + KEY_EMPRESA + " VARCHAR, FOREIGN KEY("
            + KEY_MEIODETRANSPORTEID + ") REFERENCES " + TABELA_MEIODETRANSPORTE + "(" + KEY_ID + "),"
            + "FOREIGN KEY(" + KEY_TIPOSCOMPARTILHADOID + ") REFERENCES " + TABELA_TIPOSCOMPARTILHADO
            + "(" + KEY_ID + "));";

    //Criação de tabela Alugado
    private static final String CREATE_TABLE_ALUGADO = "CREATE TABLE IF NOT EXISTS " + TABELA_ALUGADO
            + "(" + KEY_MEIODETRANSPORTEID + " INTEGER PRIMARY KEY," + KEY_TIPOSALUGADOID + " INTEGER NOT NULL,"
            + KEY_LOCADORA + " VARCHAR," + KEY_MARCA + " VARCHAR," + KEY_MODELO + " VARCHAR,"
            + KEY_COR + " VARCHAR, FOREIGN KEY(" + KEY_MEIODETRANSPORTEID + ") REFERENCES "
            + TABELA_MEIODETRANSPORTE + "(" + KEY_ID + "), FOREIGN KEY(" + KEY_TIPOSALUGADOID
            + ") REFERENCES " + TABELA_TIPOSALUGADO + "(" + KEY_ID + "));";

    //Criação de tabela Gasto
    private static final String CREATE_TABLE_GASTO = "CREATE TABLE IF NOT EXISTS " + TABELA_GASTO
            + "(" + KEY_EVENTOID + " INTEGER PRIMARY KEY," + KEY_TIPOGASTOID + " INTEGER NOT NULL,"
            + KEY_VALOR + " NUMERIC," + KEY_OBSERVACAO + " VARCHAR, FOREIGN KEY("
            + KEY_EVENTOID + ") REFERENCES " + TABELA_EVENTO + "(" + KEY_ID + "), FOREIGN KEY("
            + KEY_TIPOGASTOID + ") REFERENCES " + TABELA_TIPOGASTO + "(" + KEY_ID + "));";

    //Criação de tabela Publico
    private static final String CREATE_TABLE_PUBLICO = "CREATE TABLE IF NOT EXISTS " + TABELA_PUBLICO
            + "(" + KEY_MEIODETRANSPORTEID + " INTEGER PRIMARY KEY," + KEY_TIPOSPUBLICOID + " INTEGER NOT NULL,"
            + KEY_EMPRESA + " VARCHAR, FOREIGN KEY(" + KEY_MEIODETRANSPORTEID + ") REFERENCES "
            + TABELA_MEIODETRANSPORTE + "(" + KEY_ID + "), FOREIGN KEY(" + KEY_TIPOSPUBLICOID
            + ") REFERENCES " + TABELA_TIPOSPUBLICO + "(" + KEY_ID + "));";

    //Criação de tabela Particular
    private static final String CREATE_TABLE_PARTICULAR = "CREATE TABLE IF NOT EXISTS " + TABELA_PARTICULAR
            + "(" + KEY_MEIODETRANSPORTEID + " INTEGER PRIMARY KEY," + KEY_TIPOSPARTICULARID + " INTEGER NOT NULL,"
            + KEY_MARCA + " VARCHAR," + KEY_MODELO + " VARCHAR," + KEY_COR + " VARCHAR,"
            + "FOREIGN KEY(" + KEY_MEIODETRANSPORTEID + ") REFERENCES "
            + TABELA_MEIODETRANSPORTE + "(" + KEY_ID + "), FOREIGN KEY(" + KEY_TIPOSPARTICULARID
            + ") REFERENCES " + TABELA_TIPOSPARTICULAR + "(" + KEY_ID + "));";

    //Criação de tabela Viagem
    private static final String CREATE_TABLE_VIAGEM = "CREATE TABLE IF NOT EXISTS " + TABELA_VIAGEM
            + "(" + KEY_EVENTOID + " INTEGER PRIMARY KEY," + KEY_INICIO + " DATETIME," + KEY_FIM
            + " DATETIME," + KEY_DISTANCIA + " FLOAT, FOREIGN KEY(" + KEY_EVENTOID
            + ") REFERENCES " + TABELA_EVENTO + "(" + KEY_ID + "));";

    private Context mContext;

    public CriaBancoCompleto(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.mContext = context;
    }

    public static CriaBancoCompleto getInstance(Context context) {
        if (instancia == null) {
            synchronized (CriaBancoCompleto.class) {
                if (instancia == null) {
                    instancia = new CriaBancoCompleto(context);
                }
            }
        }
        return instancia;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //criação das tabelas
        db.execSQL(CREATE_TABLE_TIPOSPARTICULAR);
        db.execSQL(CREATE_TABLE_TIPOSPUBLICO);
        db.execSQL(CREATE_TABLE_MEIODETRANSPORTE);
        db.execSQL(CREATE_TABLE_TIPOSCOMPARTILHADO);
        db.execSQL(CREATE_TABLE_TIPOSALUGADO);
        db.execSQL(CREATE_TABLE_TIPOGASTO);
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_ANUNCIO);
        db.execSQL(CREATE_TABLE_ESTATISTICASCONTA);
        db.execSQL(CREATE_TABLE_EVENTO);
        db.execSQL(CREATE_TABLE_ESTATISTICAMEIOTRANSPORTE);
        db.execSQL(CREATE_TABLE_USUARIOHASMEIODETRANSPORTE);
        db.execSQL(CREATE_TABLE_COMPARTILHADO);
        db.execSQL(CREATE_TABLE_ALUGADO);
        db.execSQL(CREATE_TABLE_GASTO);
        db.execSQL(CREATE_TABLE_PUBLICO);
        db.execSQL(CREATE_TABLE_PARTICULAR);
        db.execSQL(CREATE_TABLE_VIAGEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nada a fazer para a apresentação
    }
}