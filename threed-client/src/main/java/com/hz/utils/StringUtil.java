package com.hz.utils;


import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class StringUtil
{
  static Logger logger = Logger.getLogger(StringUtil.class);

  public static void main(String[] args)
  {
  }

  public static String handleNULL(Object input)
  {
    if ((input != null) && 
      (input instanceof String))
      return handleNULL((String)input, "");

    return "";
  }

  public static String handleNULL(String input)
  {
    return handleNULL(input, "");
  }

  public static String handleNULL(String input, String def)
  {
    if ((input == null) || (input.trim().length() <= 0) || 
      (input.trim().toLowerCase().equals("null")))
      return def;

    return input.trim();
  }

  public static boolean isEmpty(String vStr)
  {
    if (vStr == null)
      return true;
    return (vStr.trim().length() <= 0);
  }

  public static String handleScale(double input, int scale)
  {
    BigDecimal bigDecimal = new BigDecimal(input);
    bigDecimal = bigDecimal.setScale(scale, 6);
    return handleNULL(bigDecimal.toString());
  }

  public static String handleScale(String input, int scale)
  {
    BigDecimal bigDecimal = new BigDecimal(input);
    bigDecimal = bigDecimal.setScale(scale, 6);
    return handleNULL(bigDecimal.toString());
  }

  public static String leadingChar(String input, int length, char ch)
  {
    input = handleNULL(input);
    char[] nils = new char[Math.max(0, length - input.length())];
    Arrays.fill(nils, ch);
    input = String.valueOf(nils) + input;
    return handleNULL(input);
  }

  public static String leadingZero(String input, int length)
  {
    return leadingChar(input, length, '0');
  }

  public static String convertFenToYuan(String fen)
  {
    return convertFenToYuan(Double.parseDouble(fen));
  }

  public static String convertFenToYuan(double fen)
  {
    String result;
    double yuan;
    try
    {
      yuan = fen / 100.0D;
      result = handleScale(yuan, 2);
    } catch (Exception ex) {
      result = "0.00";
    }
    return result;
  }

  public static String[] String2Array(String str, String delim)
  {
    if ((str == null) || (delim == null))
      return new String[0];

    StringTokenizer st = new StringTokenizer(str, delim);
    String[] retArr = new String[st.countTokens()];
    int i = 0;
    while (st.hasMoreTokens()) {
      retArr[i] = st.nextToken();
      ++i;
    }
    return retArr;
  }

  public static boolean containsValue(String[] a, String s)
  {
    boolean bRetVal = false;

    for (int i = 0; i < a.length; ++i)
      if (handleNULL(a[i]).equals(handleNULL(s))) {
        bRetVal = true;
        break;
      }


    return bRetVal;
  }

  public static String substringADSLSuffix(String s)
  {
    if (isEmpty(s))
      return "";

    if (s.indexOf("@") != -1)
      return s.substring(0, s.indexOf("@"));

    return s;
  }

  public static String replaceString(String vStr, String vOld, String vNew)
  {
    if (isEmpty(vStr))
      return "";

    String sRetVal = "";
    int pos = vStr.indexOf(vOld);

    while (pos != -1) {
      sRetVal = sRetVal + vStr.substring(0, pos) + vNew;
      vStr = vStr.substring(pos + vOld.length());

      pos = vStr.indexOf(vOld);
    }

    sRetVal = sRetVal + vStr;

    return sRetVal;
  }

  public static String intToStr(int vValue, int len, String vChar)
  {
    String sTemp = String.valueOf(vValue);

    if (!(vChar.equals(""))) {
      while (sTemp.length() < len)
        sTemp = vChar + sTemp;

    }

    return sTemp;
  }

  public static String intToStr(int vValue)
  {
    return intToStr(vValue, 0, "");
  }

  public static String arrayToString(String[] a, String sDivider)
  {
    String sRetVal = "";

    for (int i = 0; i < a.length; ++i)
      if (sRetVal.equals(""))
        sRetVal = a[i];
      else
        sRetVal = sRetVal + sDivider + a[i];


    return sRetVal;
  }

  public static String[] stringToArray(String vList, String vDelimiter)
  {
    Vector avList = new Vector();

    StringTokenizer st = new StringTokenizer(vList, vDelimiter);

    while (st.hasMoreTokens()) {
      avList.addElement(st.nextToken());
    }

    String[] aList = new String[avList.size()];
    avList.copyInto(aList);

    return aList;
  }

 
  public static String getRandomString(int vStrLength)
  {
    String s = "";
    for (int i = 1; i <= vStrLength; ++i) {
      int nextChar = (int)(Math.random() * 62.0D);
      if (nextChar < 10)
        s = s + nextChar;
      else if (nextChar < 36)
        s = s + (char)(nextChar - 10 + 97);
      else
        s = s + (char)(nextChar - 36 + 65);
    }
    return s;
  }

  public static String getRandomNumberString(int vStrLength) {
    String s = "";
    for (int i = 1; i <= vStrLength; ++i) {
      int nextChar = (int)(Math.random() * 10.0D);
      if (nextChar < 10)
        s = s + nextChar;
      else
        s = s + "0";
    }
    return s;
  }

  public static String truncate(String s, int maxlimit)
  {
    String sRetVal = "";
    if (s.length() > maxlimit) {
      sRetVal = s.substring(0, maxlimit);
    }

    return sRetVal;
  }

  public static boolean isValidEmail(String vEmailAddress) {
    Pattern pattern = Pattern.compile("^.+\\@(\\[?)[a-zA-Z0-9\\-\\.]+\\.([a-zA-Z]{2,20}|[0-9]{1,3})(\\]?)$");
    Matcher matcher = pattern.matcher(vEmailAddress);

    return matcher.matches();
  }

  public static boolean isValidMultiEmails(String vEmailAddress) {
    boolean bValidEmail = true;

    String[] aEmail = stringToArray(vEmailAddress, ",");

    for (int i = 0; i < aEmail.length; ++i)
      if ((!(isEmpty(aEmail[i]))) && 
        (!(isValidEmail(aEmail[i])))) {
        bValidEmail = false;
        break;
      }


    return bValidEmail;
  }

  public static String getLimitBytesString(String str, int len)
    throws Exception
  {
    if ((str == null) || (str.length() == 0))
      return str;
    int counterOfDoubleByte = 0;

    byte[] b = str.getBytes("GBK");
    if (b.length <= len)
      return str;
    for (int i = 0; i < len; ++i)
      if (b[i] < 0)
        ++counterOfDoubleByte;


    if (counterOfDoubleByte % 2 == 0)
      return new String(b, 0, len, "GBK");

    return new String(b, 0, len - 1, "GBK");
  }

  public static String getClob(Clob clob)
    throws SQLException
  {
    String str = "";
    if ((clob != null) && (clob.length() != 2802395718881378304L)) {
      try {
        str = clob.getSubString(2802398192782540800L, (int)clob.length());
      } catch (SQLException e) {
        if (logger.isInfoEnabled())
          logger.info("INFO:the current driver wants to start from 1,not 0," + 
            e.getMessage());

        str = clob.getSubString(2802398192782540801L, (int)clob.length());
      }
      int i = str.indexOf("<CLOB ");
      if (i >= 0)
        str = str.substring(0, i);
    }
    return str;
  }

  public static boolean isNumeric(String str)
  {
    Pattern pattern = Pattern.compile("[0-9]*");
    Matcher isNum = pattern.matcher(str);

    return (isNum.matches());
  }

  public static boolean isValidInteger(String sValue)
  {
    if (isEmpty(sValue))
      return false;

    for (int i = 0; i < sValue.length(); ++i) {
      char c = sValue.charAt(i);
      if ((c < '0') || (c > '9'))
        return false;
    }
    return true;
  }

  public static String getParameterFromURL(String url, String key)
  {
    if ((isEmpty(url)) || (isEmpty(key)))
      return "";
    String[] tmp1 = url.split("\\?");
    if (tmp1.length <= 1)
      return "";
    String[] tmp2 = tmp1[1].split("&");
    int length = tmp2.length;
    String tmp3 = null;
    String[] tmp4 = (String[])null;
    for (int i = 0; i < length; ++i) {
      tmp3 = tmp2[i];
      if (!(isEmpty(tmp3))) {
        tmp4 = tmp3.split("=");
        if (tmp4.length <= 1) {
          if (!(tmp4[0].equals(key))) continue;
          return "";
        }
        if (tmp4[0].equals(key))
          return tmp4[1];
      }
    }

    return "";
  }

  public static int convertBigDecimalToInt(BigDecimal bg)
  {
    if (bg == null)
      return 0;
    try
    {
      return bg.intValue(); } catch (Exception e) {
    }
    return 0;
  }

  public static String convertBigDecimalToStr(BigDecimal bg)
  {
    if (bg == null)
      return null;
    try
    {
      return String.valueOf(bg.intValue()); } catch (Exception e) {
    }
    return null;
  }
}