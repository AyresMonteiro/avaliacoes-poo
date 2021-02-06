package atividade;

import java.text.DecimalFormat;

public class Real {
  public static String formatar(double value) {
    DecimalFormat formatador = new DecimalFormat("###,###.00");

    return formatador.format(value);
  }
}
