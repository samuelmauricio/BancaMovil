package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper {


    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table usuarios(_ID integer primary key autoincrement, Nombre text, " +
                "Tarjeta int, Clave_internet int);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Metodo para abrir la bd
    public void abrir(){
        this.getWritableDatabase();
    }

    //Metodo para cerrar la bd
    public void cerrar(){
        this.close();
    }

    //Metodo para insertar registros en la tabla usuarios
    public void insertarReg(String nom, String tarjeta, String clave_internet){
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nom);
        valores.put("Tarjeta", tarjeta);
        valores.put("Clave_internet",clave_internet);
        this.getWritableDatabase().insert("usuarios", null, valores);
    }

    //Metodo para validar si el usuario existe
    public Cursor consultarUsu(String tarjeta, String clave_internet) throws SQLException{
        Cursor mCursor = null;

        mCursor = this.getReadableDatabase().query("usuarios", new String[]{"_ID, Nombre, Tarjeta, Clave_internet"},
                "Tarjeta like'"+tarjeta+"' and Clave_internet like '"+clave_internet+ "'",
                null, null, null, null);

        return mCursor;
    }

}
