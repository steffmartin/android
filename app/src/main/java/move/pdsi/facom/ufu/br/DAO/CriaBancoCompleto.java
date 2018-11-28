package move.pdsi.facom.ufu.br.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mirandagab on 08/07/2018.
 */
public class CriaBancoCompleto extends SQLiteOpenHelper {

    public static volatile CriaBancoCompleto instancia;

    public static final String NOME_BANCO      = "move.db";
    public static final int VERSAO_BANCO       = 2;

    //TABELAS

    //TABELA MEIO DE TRANSPORTE
    public static final String TABELA_MEIODETRANSPORTE     = "meiodetransporte";
    //COLUNAS MEIO DE TRANSPORTE
    public static final String MEIODETRANSPORTE_ID         = "id";
    public static final String MEIODETRANSPORTE_DESCRICAO  = "descricao";
    public static final String MEIODETRANSPORTE_TIPO       = "tipo";
    //CREATE MEIO DE TRANSPORTE
    public static final String CREATE_TABLE_MEIODETRANSPORTE = "CREATE TABLE IF NOT EXISTS "+ TABELA_MEIODETRANSPORTE + "("
            + MEIODETRANSPORTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MEIODETRANSPORTE_DESCRICAO + " VARCHAR,"
            + MEIODETRANSPORTE_TIPO + " VARCHAR"
            + ");";

    //TABELA EVENTO
    public static final String TABELA_EVENTO               = "evento";
    //COLUNAS EVENTO
    public static final String EVENTO_ID                   = "id";
    public static final String EVENTO_MEIODETRANSPORTE_ID  = "meiodetransporte_id";
    public static final String EVENTO_DATA                 = "data";
    //CREATE EVENTO
    public static final String CREATE_TABLE_EVENTO = "CREATE TABLE IF NOT EXISTS " + TABELA_EVENTO + "("
            + EVENTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EVENTO_MEIODETRANSPORTE_ID + " INTEGER,"
            +" FOREIGN KEY("+ EVENTO_MEIODETRANSPORTE_ID + ") REFERENCES " + TABELA_MEIODETRANSPORTE + "(" + MEIODETRANSPORTE_ID + ")"
            + ");";

    //TABELA VIAGEM
    public static final String TABELA_VIAGEM       = "viagem";
    //COLUNAS VIAGEM
    public static final String VIAGEM_EVENTOID     = "evento_id";
    public static final String VIAGEM_INICIO       = "inicio";
    public static final String VIAGEM_FIM          = "fim";
    public static final String VIAGEM_DISTANCIA    = "distancia";
    //CREATE VIAGEM
    public static final String CREATE_TABLE_VIAGEM = "CREATE TABLE IF NOT EXISTS " + TABELA_VIAGEM+ "("
            + VIAGEM_EVENTOID + " INTEGER PRIMARY KEY,"
            + VIAGEM_INICIO + " DATETIME,"
            + VIAGEM_FIM+ " DATETIME,"
            + VIAGEM_DISTANCIA + " FLOAT,"
            +" FOREIGN KEY(" + VIAGEM_EVENTOID+ ") REFERENCES " + TABELA_EVENTO + "(" + EVENTO_ID + ")"
            + ");";

    //TABELA GASTO
    public static final String TABELA_GASTO        = "gasto";
    //COLUNAS GASTO
    public static final String GASTO_EVENTOID      = "evento_id";
    public static final String GASTO_TIPOGASTO     = "tipo";
    public static final String GASTO_VALOR         = "valor";
    public static final String GASTO_OBSERVACAO    = "observacao";
    //CREATE GASTO
    //Criação de tabela Gasto
    public static final String CREATE_TABLE_GASTO = "CREATE TABLE IF NOT EXISTS " + TABELA_GASTO+ "("
            + GASTO_EVENTOID + " INTEGER PRIMARY KEY,"
            + GASTO_TIPOGASTO + " INTEGER NOT NULL,"
            + GASTO_VALOR + " NUMERIC,"
            + GASTO_OBSERVACAO + " VARCHAR,"
            +" FOREIGN KEY("+ GASTO_EVENTOID + ") REFERENCES " + TABELA_EVENTO + "(" + EVENTO_ID + ")"
            + ");";

    //TABELA ALUGADO
    public static final String TABELA_ALUGADO                  = "alugado";
    //COLUNAS ALUGADO
    public static final String ALUGADO_MEIODETRANSPORTE_ID     = "meiodetranposrte_id";
    public static final String ALUGADO_LOCADORA                = "locadora";
    public static final String ALUGADO_MARCA                   = "marca";
    public static final String ALUGADO_MODELO                  = "modelo";
    public static final String ALUGADO_COR                     = "cor";
    //CREATE ALUGADO
    public static final String CREATE_TABLE_ALUGADO = "CREATE TABLE IF NOT EXISTS " + TABELA_ALUGADO+ "("
            + ALUGADO_MEIODETRANSPORTE_ID + " INTEGER PRIMARY KEY,"
            + ALUGADO_LOCADORA + " VARCHAR,"
            + ALUGADO_MARCA + " VARCHAR,"
            + ALUGADO_MODELO + " VARCHAR,"
            + ALUGADO_COR + " VARCHAR,"
            +" FOREIGN KEY(" + ALUGADO_MEIODETRANSPORTE_ID + ") REFERENCES "+ TABELA_MEIODETRANSPORTE + "(" + MEIODETRANSPORTE_ID + ")"
            + ");";

    //TABELA COMPARTILHADO
    public static final String TABELA_COMPARTILHADO                = "compartilhado";
    //COLUNAS COMPARTILHADO
    public static final String COMPARTILHADO_MEIODETRANSPORTE_ID   = "meiodetransporte_id";
    public static final String COMPARTILHADO_EMPRESA               = "empresa";
    //CREATE COMPARTILHADO
    public static final String CREATE_TABLE_COMPARTILHADO = "CREATE TABLE IF NOT EXISTS "+ TABELA_COMPARTILHADO + "("
            + COMPARTILHADO_MEIODETRANSPORTE_ID + " INTEGER PRIMARY KEY,"
            + COMPARTILHADO_EMPRESA + " VARCHAR,"
            +" FOREIGN KEY(" + COMPARTILHADO_MEIODETRANSPORTE_ID + ") REFERENCES " + TABELA_MEIODETRANSPORTE + "(" + MEIODETRANSPORTE_ID + ")"
            + ");";

    //TABELA PUBLICO
    public static final String TABELA_PUBLICO                  = "publico";
    //COLUNAS PUBLICO
    public static final String PUBLICO_MEIODETRANSPORTE_ID     = "meiodetransporte_id";
    public static final String PUBLICO_EMPRESA                 = "empresa";
    //CREATE PUBLICO
    public static final String CREATE_TABLE_PUBLICO = "CREATE TABLE IF NOT EXISTS " + TABELA_PUBLICO + "("
            + PUBLICO_MEIODETRANSPORTE_ID+ " INTEGER PRIMARY KEY,"
            + PUBLICO_EMPRESA + " VARCHAR,"
            +" FOREIGN KEY(" + PUBLICO_MEIODETRANSPORTE_ID+ ") REFERENCES " + TABELA_MEIODETRANSPORTE + "(" + MEIODETRANSPORTE_ID + ")"
            + ");";

    //TABELA PARTICULAR
    public static final String TABELA_PARTICULAR               = "particular";
    //COLUNAS PARTICULAR
    public static final String PARTICULAR_MEIODETRANSPORTE_ID  = "meiodetransporte_id";
    public static final String PARTICULAR_MARCA                = "marca";
    public static final String PARTICULAR_MODELO               = "modelo";
    public static final String PARTICULAR_COR                  = "cor";
    //CREATE PARTICULAR
    public static final String CREATE_TABLE_PARTICULAR = "CREATE TABLE IF NOT EXISTS " + TABELA_PARTICULAR+ "("
            + PARTICULAR_MEIODETRANSPORTE_ID + " INTEGER PRIMARY KEY,"
            + PARTICULAR_MARCA+ " VARCHAR,"
            + PARTICULAR_MODELO + " VARCHAR,"
            + PARTICULAR_COR + " VARCHAR,"
            + "FOREIGN KEY(" + PARTICULAR_MEIODETRANSPORTE_ID+ ") REFERENCES " + TABELA_MEIODETRANSPORTE + "(" + MEIODETRANSPORTE_ID + ")"
            + ");";

    //TABELA USUARIO
    public static final String TABELA_USUARIO          = "usuario";
    //COLUNAS USUARIO
    public static final String USUARIO_ID              = "id";
    public static final String USUARIO_NOME            = "nome";
    public static final String USUARIO_SOBRENOME       = "sobrenome";
    public static final String USUARIO_EMAIL           = "email";
    public static final String USUARIO_SENHA           = "senha";
    public static final String USUARIO_FACEBOOK        = "facebook";
    public static final String USUARIO_SINCRONIZAR     = "sincronizar";
    //CREATE USUARIO
    public static final String CREATE_TABLE_USUARIO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_USUARIO + "(" + USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + USUARIO_NOME + " VARCHAR NOT NULL,"
            + USUARIO_SOBRENOME + " VARCHAR NOT NULL,"
            + USUARIO_EMAIL + " VARCHAR NOT NULL,"
            + USUARIO_SENHA + " VARCHAR NOT NULL,"
            + USUARIO_FACEBOOK + " VARCHAR,"
            + USUARIO_SINCRONIZAR + " BOOL NOT NULL);";

    //TABELA ESTATISTICASCONTA
    public static final String TABELA_ESTATISTICASCONTA                = "estatisticasconta";
    //COLUNAS ESTATISTICASCONTA
    public static final String ESTATISTICASCONTA_USUARIOID             = "usuario_id";
    public static final String ESTATISTICASCONTA_QTDMEIOSTRANSPORTES   = "qtdmeiostransporte";
    public static final String ESTATISTICASCONTA_ULTIMOLOGIN           = "ultimologin";
    //CREATE ESTATISTICAS CONTA
    public static final String CREATE_TABLE_ESTATISTICASCONTA = "CREATE TABLE IF NOT EXISTS "+ TABELA_ESTATISTICASCONTA + "("
            + ESTATISTICASCONTA_USUARIOID+ " INTEGER PRIMARY KEY,"
            + ESTATISTICASCONTA_QTDMEIOSTRANSPORTES + " INTEGER,"
            + ESTATISTICASCONTA_ULTIMOLOGIN + " DATETIME,"
            + "FOREIGN KEY(" + ESTATISTICASCONTA_USUARIOID + ") REFERENCES " + TABELA_USUARIO + "(" + USUARIO_ID + ")"
            + ");";

    //TABELA ESTATISTICASMEIOTRANSPORTE
    public static final String TABELA_ESTATISTICASMEIOTRANSPORTE               = "estatisticasmeiotransporte";
    //COLUNAS ESTATISTICASMEIOTRANSPORTE
    public static final String ESTATISTICASMEIOTRANSPORTE_MEIODETRANSPORTE_ID  = "meiodetransporte_id";
    public static final String ESTATISTICASMEIOTRANSPORTE_MEDIA                = "media";
    public static final String ESTATISTICASMEIOTRANSPORTE_MAXIMO               = "maximo";
    public static final String ESTATISTICASMEIOTRANSPORTE_MINIMO               = "minino";
    public static final String ESTATISTICASMEIOTRANSPORTE_QTD                  = "qtd";
    //CREATE ESTATISTICAS MEIO DE TRANSPORTE
    public static final String CREATE_TABLE_ESTATISTICAMEIOTRANSPORTE = "CREATE TABLE IF NOT EXISTS "+ TABELA_ESTATISTICASMEIOTRANSPORTE + "("
            + ESTATISTICASMEIOTRANSPORTE_MEIODETRANSPORTE_ID + " INTEGER PRIMARY KEY,"
            + ESTATISTICASMEIOTRANSPORTE_MEDIA + " FLOAT,"
            + ESTATISTICASMEIOTRANSPORTE_MAXIMO + " FLOAT,"
            + ESTATISTICASMEIOTRANSPORTE_MINIMO + " FLOAT,"
            + ESTATISTICASMEIOTRANSPORTE_QTD + " INTEGER,"
            +" FOREIGN KEY(" + ESTATISTICASMEIOTRANSPORTE_MEIODETRANSPORTE_ID + ") REFERENCES "+ TABELA_MEIODETRANSPORTE + "(" + MEIODETRANSPORTE_ID + "));";

    //TABELA USUARIOHASMEIOTRANSPORTE
    public static final String TABELA_USUARIOHASMEIOTRANSPORTE                 = "usuario_has_meiodetransporte";
    //COLUNAS USUARIOHASMEIOTRANSPORTE
    public static final String USUARIOHASMEIOTRANSPORTE_USUARIO_ID             = "usuario_id";
    public static final String USUARIOHASMEIOTRANSPORTE_MEIODETRANSPORTE_ID    = "meiodetransporte_id";
    //CREATE USUARIO HAS MEIO TRANSPORTE
    public static final String CREATE_TABLE_USUARIOHASMEIODETRANSPORTE = "CREATE TABLE IF NOT EXISTS "+ TABELA_USUARIOHASMEIOTRANSPORTE + "("
            + USUARIOHASMEIOTRANSPORTE_USUARIO_ID + " INTEGER NOT NULL,"
            + USUARIOHASMEIOTRANSPORTE_MEIODETRANSPORTE_ID + " INTEGER NOT NULL,"
            +" PRIMARY KEY(" + USUARIOHASMEIOTRANSPORTE_USUARIO_ID + ","+ USUARIOHASMEIOTRANSPORTE_MEIODETRANSPORTE_ID + "),"
            +" FOREIGN KEY(" + USUARIOHASMEIOTRANSPORTE_USUARIO_ID + ") REFERENCES "+ TABELA_USUARIO + "(" + USUARIO_ID+ "),"
            +" FOREIGN KEY(" + USUARIOHASMEIOTRANSPORTE_MEIODETRANSPORTE_ID + ") REFERENCES "+ TABELA_MEIODETRANSPORTE + "(" + MEIODETRANSPORTE_ID + "));";


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
        db.execSQL(CREATE_TABLE_MEIODETRANSPORTE);
        db.execSQL(CREATE_TABLE_EVENTO);
        db.execSQL(CREATE_TABLE_VIAGEM);
        db.execSQL(CREATE_TABLE_GASTO);
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_ESTATISTICASCONTA);
        db.execSQL(CREATE_TABLE_ESTATISTICAMEIOTRANSPORTE);
        db.execSQL(CREATE_TABLE_USUARIOHASMEIODETRANSPORTE);
        db.execSQL(CREATE_TABLE_COMPARTILHADO);
        db.execSQL(CREATE_TABLE_ALUGADO);
        db.execSQL(CREATE_TABLE_PUBLICO);
        db.execSQL(CREATE_TABLE_PARTICULAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nada a fazer para a apresentação
    }
}