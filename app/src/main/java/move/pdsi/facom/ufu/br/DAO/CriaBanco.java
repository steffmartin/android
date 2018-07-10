package move.pdsi.facom.ufu.br.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mirandagab on 08/07/2018.
 */
public class CriaBanco extends SQLiteOpenHelper{

    private static volatile CriaBanco instancia;

    private static final String NOME_BANCO = "move.db";
    private static final  int VERSAO_BANCO = 1;

    //TABELAS
    public static final String TABELA_COMPARTILHADO                = "Compartilhado";
    public static final String TABELA_ALUGADO                      = "Alugado";
    public static final String TABELA_PUBLICO                      = "Publico";
    public static final String TABELA_PARTICULAR                   = "Particular";
    public static final String TABELA_VIAGEM                       = "Viagem";
    public static final String TABELA_INDICES                      = "Indices";

    //COLUNAS
    //nomes de colunas comuns
    public static final String KEY_ID                              = "_id";
    public static final String KEY_DESCRICAO                       = "descricao";
    public static final String KEY_TIPO                            = "tipo";

    //tabelas Compartilhado e Publico - colunas
    public static final String KEY_EMPRESA                         = "empresa";

    //tabela Alugado - colunas
    public static final String KEY_LOCADORA                        = "locadora";
    public static final String KEY_MARCA                           = "marca";
    public static final String KEY_MODELO                          = "modelo";
    public static final String KEY_COR                             = "cor";

    //tabela Particular - colunas
    public static final String KEY_MEDIA                           = "media";
    public static final String KEY_MAXIMO                          = "maximo";
    public static final String KEY_MINIMO                          = "minimo";

    //tabela Viagem - colunas
    public static final String KEY_INICIO                          = "inicio";
    public static final String KEY_FIM                             = "fim";
    public static final String KEY_DISTANCIA                       = "distancia";

    //tabela Indices - colunas
    public static final String KEY_TABELA                          = "tabela";
    public static final String KEY_VALOR                           = "valor";

    //CRIAÇÃO DE TABELAS
    //Criação de tabela Compartilhado
    private static final String CREATE_TABLE_COMPARTILHADO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_COMPARTILHADO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DESCRICAO
            + " TEXT," + KEY_TIPO + " TEXT," + KEY_EMPRESA + " TEXT)";

    //Criação de tabela Alugado
    private static final String CREATE_TABLE_ALUGADO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_ALUGADO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DESCRICAO
            + " TEXT," + KEY_TIPO + " TEXT," + KEY_LOCADORA + " TEXT," + KEY_MARCA
            + " TEXT," + KEY_MODELO + " TEXT," + KEY_COR + " TEXT)";

    //Criação de tabela Publico
    private static final String CREATE_TABLE_PUBLICO = "CREATE TABLE IF NOT EXISTS "
            + TABELA_PUBLICO + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DESCRICAO
            + " TEXT," + KEY_TIPO + " TEXT," + KEY_EMPRESA + " TEXT)";

    //Criação de tabela Particular
    private static final String CREATE_TABLE_PARTICULAR = "CREATE TABLE IF NOT EXISTS "
            + TABELA_PARTICULAR + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DESCRICAO
            + " TEXT," + KEY_TIPO + " TEXT," + KEY_MARCA + " TEXT," + KEY_MODELO + " TEXT,"
            + KEY_COR + " TEXT," + KEY_MEDIA + " REAL," + KEY_MAXIMO + " REAL," + KEY_MINIMO
            + " REAL)";

    //Criação de tabela Viagem
    private static final String CREATE_TABLE_VIAGEM = "CREATE TABLE IF NOT EXISTS "
            + TABELA_VIAGEM + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_INICIO + " REAL,"
            + KEY_FIM + " REAL," + KEY_DISTANCIA + " REAL)";

//     //Criação de tabela Indices
//    private static final String CREATE_TABLE_INDICES = "CREATE TABLE IF NOT EXISTS "
//             + TABELA_INDICES + "(" + KEY_TABELA + " TEXT," + KEY_VALOR + " INTEGER)";

    private Context mContext;

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.mContext = context;
    }

    public static CriaBanco getInstance(Context context){
        if (instancia == null){
            synchronized (CriaBanco.class){
                if (instancia == null){
                    instancia = new CriaBanco(context);
                }
            }
        }
        return instancia;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //criação das tabelas
        db.execSQL(CREATE_TABLE_PARTICULAR);
        db.execSQL(CREATE_TABLE_ALUGADO);
        db.execSQL(CREATE_TABLE_COMPARTILHADO);
        db.execSQL(CREATE_TABLE_PUBLICO);
        db.execSQL(CREATE_TABLE_VIAGEM);
//        db.execSQL(CREATE_TABLE_INDICES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nada a fazer para a apresentação
    }
}