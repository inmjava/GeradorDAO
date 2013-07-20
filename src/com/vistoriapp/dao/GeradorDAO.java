package com.vistoriapp.dao;

import com.vistoriapp.apoio.Gerador;

public class GeradorDAO  {
  protected static String nl;
  public static synchronized GeradorDAO create(String lineSeparator)
  {
    nl = lineSeparator;
    GeradorDAO result = new GeradorDAO();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL + "package com.vistoriapp.db;" + NL + "" + NL + "import android.content.ContentValues;" + NL + "import android.content.Context;" + NL + "import android.database.Cursor;" + NL + "import android.database.sqlite.SQLiteDatabase;" + NL + "import java.util.ArrayList;" + NL + "" + NL + "import com.vistoriapp.pojo.";
  protected final String TEXT_3 = ";" + NL + "" + NL + "public class ";
  protected final String TEXT_4 = "DAO {" + NL + "" + NL + "\tprivate Context context;" + NL + "\tprivate final String TABLE_NAME = \"";
  protected final String TEXT_5 = "\";" + NL + "\t";
  protected final String TEXT_6 = "private final String KEY_";
  protected final String TEXT_7 = " = \"";
  protected final String TEXT_8 = "\";" + NL + "\t";
  protected final String TEXT_9 = NL + NL + "\tpublic ";
  protected final String TEXT_10 = "DAO(Context context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "" + NL + "\tpublic void salvar";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = " ";
  protected final String TEXT_13 = ") {" + NL + "" + NL + "\t\tVistoriAppHelper helper = new VistoriAppHelper(this.context);" + NL + "\t\tSQLiteDatabase db = helper.getReadableDatabase();" + NL + "" + NL + "\t\tContentValues initialValues = new ContentValues();" + NL + "\t\t";
  protected final String TEXT_14 = "initialValues.put(KEY_";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ".get";
  protected final String TEXT_17 = "());" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\tdb.insert(TABLE_NAME, null, initialValues);" + NL + "" + NL + "\t\tdb.close();" + NL + "\t\thelper.close();" + NL + "\t}" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_19 = " findById(int id) {" + NL + "" + NL + "\t\tVistoriAppHelper helper = new VistoriAppHelper(this.context);" + NL + "\t\tSQLiteDatabase db = helper.getReadableDatabase();" + NL + "\t\tCursor dados = db.query(TABLE_NAME, new String[] { KEY_";
  protected final String TEXT_20 = "," + NL + "\t\t                                                   KEY_";
  protected final String TEXT_21 = " }, " + NL + "\t\t                        \"_id = ?\", new String[]{id+\"\"}, null, null, null);" + NL + "\t\t";
  protected final String TEXT_22 = " ";
  protected final String TEXT_23 = " = null;" + NL + "\t\tif (dados.moveToNext()) {" + NL + "\t\t\t";
  protected final String TEXT_24 = " = new ";
  protected final String TEXT_25 = "(); " + NL + "\t\t\t";
  protected final String TEXT_26 = ".setId(id);" + NL + "\t\t\t";
  protected final String TEXT_27 = ".set";
  protected final String TEXT_28 = "(dados.getString(";
  protected final String TEXT_29 = "));" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t}" + NL + "\t\tdados.close();" + NL + "\t\tdb.close();" + NL + "\t\thelper.close();" + NL + "\t\treturn ";
  protected final String TEXT_31 = ";" + NL + "\t}" + NL + "\t" + NL + "\tpublic ArrayList<";
  protected final String TEXT_32 = "> listAll";
  protected final String TEXT_33 = "() {" + NL + "" + NL + "\t\tVistoriAppHelper helper = new VistoriAppHelper(this.context);" + NL + "\t\tSQLiteDatabase db = helper.getReadableDatabase();" + NL + "\t\tCursor dados = db.query(TABLE_NAME, new String[] { \"_id\"," + NL + "\t\t                                                   KEY_";
  protected final String TEXT_34 = "," + NL + "\t\t                                                   KEY_";
  protected final String TEXT_35 = " }, " + NL + "\t\t                        null, null, null, null, null);" + NL + "\t\t                        " + NL + "\t\tArrayList<";
  protected final String TEXT_36 = "> lst";
  protected final String TEXT_37 = " = new ArrayList<";
  protected final String TEXT_38 = ">();" + NL + "\t\tif (dados.moveToNext()) {" + NL + "\t\t\t";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = " = new ";
  protected final String TEXT_41 = "(); " + NL + "\t\t\t";
  protected final String TEXT_42 = ".setId(dados.getInt(0));" + NL + "\t\t\t";
  protected final String TEXT_43 = ".set";
  protected final String TEXT_44 = "(dados.getString(";
  protected final String TEXT_45 = "));" + NL + "\t\t\t";
  protected final String TEXT_46 = "lst";
  protected final String TEXT_47 = ".add(";
  protected final String TEXT_48 = ");" + NL + "\t\t}" + NL + "\t\tdados.close();" + NL + "\t\tdb.close();" + NL + "\t\thelper.close();" + NL + "\t\treturn lst";
  protected final String TEXT_49 = ";" + NL + "\t}" + NL + "\t" + NL + "\tpublic boolean deleteById(int id){" + NL + "\t\t" + NL + "\t\tVistoriAppHelper helper = new VistoriAppHelper(this.context);" + NL + "\t\tSQLiteDatabase db = helper.getReadableDatabase();" + NL + "\t\tboolean excluiu = (db.delete(TABLE_NAME, \"_id = ?\", new String[]{id+\"\"}) > 0);" + NL + "\t\tdb.close();" + NL + "\t\thelper.close();" + NL + "\t\treturn excluiu;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_50 = NL;

	/*
	 * (non-javadoc)
	 * 
	 * @see IGenerator#generate(Object)
	 */
	public String generate(Gerador g)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(g.getNomeTabela());
    stringBuffer.append(TEXT_5);
     for(int i = 0; i < g.size(); i++){
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(g.getNomeColunaConstante(i));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(g.getNomeColuna(i));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_13);
     for(int i = 0; i < g.size(); i++){
		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(g.getNomeColunaConstante(i));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(g.getNomeColunaGet(i));
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(g.getNomeColunaConstante(0));
     for(int i = 1; i < g.size(); i++){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(g.getNomeColunaConstante(i));
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_26);
     for(int i = 0; i < g.size(); i++){
			
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(g.getNomeColunaGet(i));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(g.getNomeColunaConstante(0));
     for(int i = 1; i < g.size(); i++){
    stringBuffer.append(TEXT_34);
    stringBuffer.append(g.getNomeColunaConstante(i));
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_42);
     for(int i = 0; i < g.size(); i++){
			
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(g.getNomeColunaGet(i));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    return stringBuffer.toString();
  }
}