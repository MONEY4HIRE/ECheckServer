package com.whut.core.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
  public static boolean isNull(String str)
  {
    boolean result = false;
    if (str == null) {
      result = true;
    }
    return result;
  }

  public static boolean isEmpty(String value)
  {
    if ((isNull(value)) || (value.trim().length() == 0)) {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(StringBuffer value)
  {
    if ((value == null) || (isNull(value.toString())) || (value.toString().trim().length() == 0))
    {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(Integer value)
  {
    if (value == null) {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(Long value)
  {
    if (value == null) {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(Float value)
  {
    if (value == null) {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(Double value)
  {
    if (value == null) {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(Object[] value)
  {
    if (value == null) {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(List value)
  {
    if (value == null) {
      return true;
    }
    return false;
  }

  public static boolean isNull(Integer str)
  {
    return isEmpty(str);
  }

  public static boolean isNull(Long str)
  {
    return isEmpty(str);
  }

  public static boolean isNull(Float str)
  {
    return isEmpty(str);
  }

  public static boolean isNull(Double str)
  {
    return isEmpty(str);
  }

  public static boolean isNull(Object[] str)
  {
    return isEmpty(str);
  }

  public static boolean isNull(List str)
  {
    return isEmpty(str);
  }

  public static String checkNull(String str, String value)
  {
    if ((isEmpty(str)) && (value != null)) {
      str = value;
    }
    return str;
  }

  public static String checkNull(String str)
  {
    if (str == null) {
      str = "";
    }
    return str;
  }

  public static String trim(String str)
  {
    String result = str;
    StringBuffer temp = null;
    if ((result == null) || (result.trim().length() == 0)) {
      return result;
    }
    temp = new StringBuffer("");
    for (int i = 0; i < result.length(); i++) {
      if (result.charAt(i) != ' ')
      {
        temp.append(result.charAt(i));
      }
    }
    result = temp.toString();

    return result;
  }

  public static int getWordCount(String str)
  {
    int length = 0;
    if (isEmpty(str) == true) {
      return length;
    }
    int i = 0; for (int len = str.length(); i < len; i++) {
      int ascii = Character.codePointAt(str, i);
      if ((ascii >= 0) && (ascii <= 255))
        length++;
      else {
        length += 2;
      }
    }
    return length;
  }

  public static int getWordCountReg(String str)
  {
    int length = 0;
    if (isEmpty(str) == true) {
      return length;
    }
    str = str.replaceAll(" [^\\x00-\\xff] ", "**");
    length = str.length();
    return length;
  }

  public static boolean arrIsEmpty(String[] param)
  {
    boolean result = true;
    if ((param != null) && (param.length > 0)) {
      int i = 0; for (int len = param.length; i < len; i++) {
        if (!isEmpty(param[i])) {
          result = false;
          break;
        }
      }
    }
    return result;
  }

  public static String javaConvert(String str)
  {
    if (isEmpty(str) == true) {
      return str;
    }
    str = str.replaceAll("\\", "\\u005c");
    str = str.replaceAll("'", "\\u0027");
    str = str.replaceAll("\"", "\\u0022");
    return str;
  }

  public static String arrJoin(String[] param)
  {
    return arrJoin(param, null);
  }

  public static String arrJoin(String[] param, String splitStr)
  {
    if (param == null) {
      return null;
    }
    StringBuffer result = new StringBuffer("");
    if (isEmpty(splitStr) == true) {
      splitStr = ":";
    }
    if ((param != null) && (param.length > 0)) {
      int i = 0; for (int len = param.length; i < len; i++) {
        if (i > 0) {
          result.append(splitStr);
        }
        result.append(param[i]);
      }
    }
    return result.toString();
  }

  public static String arrToString(String[] param)
  {
    return arrJoin(param, null);
  }

  public static String arrToString(String[] param, String splitStr)
  {
    return arrJoin(param, splitStr);
  }

  public static String[] parseStrToArr(String str, String format)
  {
    if (str == null)
      return null;
    String[] arr = str.split(format);
    return arr;
  }

  /*public static String encrypt(byte[] bytes)
  {
    return Base64.encrypt(bytes);
  }

  public static byte[] unEncrypt(String str)
  {
    return Base64.unEncrypt(str);
  }

  public static String encode(String str, String encoding)
  {
    return Base64.encodeByEncoding(str, encoding);
  }

  public static String decode(String str, String encoding)
  {
    return Base64.decodeByEncoding(str, encoding);
  }*/

  public static String zeroString(String str, int size)
  {
    str = str == null ? "" : str.trim();
    char[] ch = str.toCharArray();
    int len = ch.length;
    int lens = size - len;
    if (lens <= 0) {
      return str;
    }
    String rStr = "";
    for (int i = 0; i < size; i++) {
      if (lens > i) {
        rStr = rStr + "0";
      }
      else
        rStr = rStr + ch[(i - lens)];
    }
    return rStr;
  }

  public static String replace(String from, String to, String source)
  {
    if ((source == null) || (from == null) || (to == null))
      return null;
    StringBuffer str = new StringBuffer("");
    int index = -1;
    while ((index = source.indexOf(from)) != -1) {
      str.append(source.substring(0, index) + to);
      source = source.substring(index + from.length());
      index = source.indexOf(from);
    }
    str.append(source);
    return str.toString();
  }

  public static boolean isInteger(String str)
  {
    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
    return pattern.matcher(str).matches();
  }

  public static boolean isDouble(String str)
  {
    Pattern pattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
    return pattern.matcher(str).matches();
  }

  public static boolean isLetter(String str)
  {
    if ((str == null) || (str.length() < 0)) {
      return false;
    }
    Pattern pattern = Pattern.compile("[\\w\\.-_]*");
    return pattern.matcher(str).matches();
  }

  public static boolean isOverLen(String str, int len)
  {
    boolean result = false;
    int tempLen = getWordCountReg(str);
    if (tempLen > len) {
      result = true;
    }
    return result;
  }

  public static boolean isEmail(String email)
  {
    if ((email == null) || (email.length() < 1) || (email.length() > 256)) {
      return false;
    }
    Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");

    return pattern.matcher(email).matches();
  }

  public static boolean isChinese(String str)
  {
    Pattern pattern = Pattern.compile("[Α-￥]+$");
    return pattern.matcher(str).matches();
  }

  public static boolean isBlank(String str)
  {
    return (str == null) || (str.trim().length() == 0);
  }

  public static boolean isPrime(int x)
  {
    if ((x <= 7) && (
      (x == 2) || (x == 3) || (x == 5) || (x == 7))) {
      return true;
    }
    int c = 7;
    if (x % 2 == 0)
      return false;
    if (x % 3 == 0)
      return false;
    if (x % 5 == 0)
      return false;
    int end = (int)Math.sqrt(x);
    while (c <= end) {
      if (x % c == 0) {
        return false;
      }
      c += 4;
      if (x % c == 0) {
        return false;
      }
      c += 2;
      if (x % c == 0) {
        return false;
      }
      c += 4;
      if (x % c == 0) {
        return false;
      }
      c += 2;
      if (x % c == 0) {
        return false;
      }
      c += 4;
      if (x % c == 0) {
        return false;
      }
      c += 6;
      if (x % c == 0) {
        return false;
      }
      c += 2;
      if (x % c == 0) {
        return false;
      }
      c += 6;
    }
    return true;
  }

  

  public static boolean isHandset(String handset)
  {
    try
    {
      String regex = "^1[\\d]{10}$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(handset);
      return matcher.matches(); } catch (RuntimeException e) {
    }
    return false;
  }

  public static String getRepeatString(int repeatTime, String metaString)
  {
    String repeatString = null;
    if ((repeatTime > 0) && (metaString != null)) {
      int intMetatStringLength = metaString.length();
      if (intMetatStringLength == 0) {
        repeatString = "";
      } else {
        StringBuffer tempStringBuffer = new StringBuffer(repeatTime * intMetatStringLength);

        for (int i = 0; i < repeatTime; i++) {
          tempStringBuffer.append(metaString);
        }
        repeatString = tempStringBuffer.toString();
      }
    }
    return repeatString;
  }

  public static String[] strToArray(String str)
  {
    String[] result = null;
    String splitStr = null;
    try
    {
      if (isEmpty(str) == true) {
        return result;
      }

      if (str.indexOf(":") >= 0) {
        splitStr = ":";
      }
      else if (str.indexOf(";") >= 0) {
        splitStr = ";";
      }
      else if (str.indexOf(",") >= 0) {
        splitStr = ",";
      }

      result = strToArray(str, splitStr);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return result;
  }

  public static String[] strToArray(String str, String splitStr)
  {
    String[] result = null;
    List tempList = null;
    try
    {
      if (isEmpty(str) == true) {
        return result;
      }
      if (splitStr == null) {
        splitStr = "$$";
      }
      StringTokenizer st = new StringTokenizer(str, splitStr);
      tempList = new ArrayList();
      while (st.hasMoreElements() == true) {
        tempList.add(st.nextToken());
      }
      if (tempList.size() > 0) {
        int size = tempList.size();
        result = new String[size];
        for (int i = 0; i < size; i++) {
          result[i] = ((String)tempList.get(i));
        }
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return result;
  }

  public static boolean idInArr(String[] param, String id)
  {
    boolean result = false;
    if ((param != null) && (param.length > 0) && (!isEmpty(id))) {
      int i = 0; for (int len = param.length; i < len; i++) {
        if (id.equals(param[i]) == true) {
          result = true;
          break;
        }
      }
    }
    return result;
  }

  public static List strToList(String str)
  {
    List result = null;
    String splitStr = null;
    try
    {
      if (isEmpty(str) == true) {
        return result;
      }

      if (str.indexOf(":") >= 0) {
        splitStr = ":";
      }
      else if (str.indexOf(";") >= 0) {
        splitStr = ";";
      }
      else if (str.indexOf(",") >= 0) {
        splitStr = ",";
      }

      result = strToList(str, splitStr);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return result;
  }

  public static List strToList(String str, String splitStr)
  {
    List result = null;
    try {
      if (isEmpty(str) == true) {
        return result;
      }
      if (splitStr == null) {
        splitStr = "$$";
      }
      StringTokenizer st = new StringTokenizer(str, splitStr);
      result = new ArrayList();
      while (st.hasMoreElements() == true)
        result.add(st.nextToken());
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return result;
  }

  public static boolean match(String str, String regex)
  {
    boolean result = false;
    if ((isEmpty(str) == true) || (isEmpty(regex) == true))
    {
      return result;
    }
    result = str.matches(regex);
    return result;
  }
}
