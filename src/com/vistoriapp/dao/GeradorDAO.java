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
  protected final String TEXT_2 = NL + NL + "public class ";
  protected final String TEXT_3 = "DAO {" + NL + "" + NL + "\tprivate Context context;" + NL + "\tprivate final String TABLE_NAME = \"";
  protected final String TEXT_4 = "\";" + NL + "\t";
  protected final String TEXT_5 = "private final String KEY_";
  protected final String TEXT_6 = " = \"";
  protected final String TEXT_7 = "\";" + NL + "\t";
  protected final String TEXT_8 = NL + NL + "\tpublic ";
  protected final String TEXT_9 = "DAO(Context context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "" + NL + "\tpublic void salvar";
  protected final String TEXT_10 = "(";
  protected final String TEXT_11 = " ";
  protected final String TEXT_12 = ") {" + NL + "" + NL + "\t\tVistoriAppHelper helper = new VistoriAppHelper(this.context);" + NL + "" + NL + "\t\t// helper = new VistoriAppHelper(this.context);" + NL + "\t\tSQLiteDatabase db = helper.getReadableDatabase();" + NL + "" + NL + "\t\tContentValues initialValues = new ContentValues();" + NL + "\t\t";
  protected final String TEXT_13 = "initialValues.put(KEY_";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ".get";
  protected final String TEXT_16 = "());" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\tdb.insert(TABLE_NAME, null, initialValues);" + NL + "" + NL + "\t\tdb.close();" + NL + "\t\thelper.close();" + NL + "\t}" + NL + "}";
  protected final String TEXT_18 = NL;

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
    stringBuffer.append(g.getNomeTabela());
    stringBuffer.append(TEXT_4);
     for(int i = 0; i < g.size(); i++){
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(g.getNomeColunaConstante(i));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(g.getNomeColuna(i));
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(g.getNomeTabelaClass());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_12);
     for(int i = 0; i < g.size(); i++){
		
    stringBuffer.append(TEXT_13);
    stringBuffer.append(g.getNomeColunaConstante(i));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(g.getNomeTabelaVar());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(g.getNomeColunaGet(i));
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}