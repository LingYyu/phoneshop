package com.ghw.org.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AllCheck {

	/** 
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
     * 此方法中前三位格式有： 
     * 13+任意数 
     * 15+除4的任意数 
     * 18+除1和4的任意数 
     * 17+除9的任意数 
     * 147 
     */  
	public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {  
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
	
	  /*
    校验过程： 
    1、从卡号最后一位数字开始，逆向将奇数位(1、3、5等等)相加。 
    2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，将个位十位数字相加，即将其减去9），再求和。 
    3、将奇数位总和加上偶数位总和，结果应该可以被10整除。       
    */   
        /** 
        * 校验银行卡卡号 
        */  
       public static boolean checkBankCard(String bankCard) {  
                if(bankCard.length() < 15 || bankCard.length() > 19) {
                    return false;
                }
                char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));  
                if(bit == 'N'){  
                    return false;  
                }  
                return bankCard.charAt(bankCard.length() - 1) == bit;  
       }  

       /** 
        * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位 
        * @param nonCheckCodeBankCard 
        * @return 
        */  
       public static char getBankCardCheckCode(String nonCheckCodeBankCard){  
           if(nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0  
                   || !nonCheckCodeBankCard.matches("\\d+")) {  
               //如果传的不是数据返回N  
               return 'N';  
           }  
           char[] chs = nonCheckCodeBankCard.trim().toCharArray();  
           int luhmSum = 0;  
           for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {  
               int k = chs[i] - '0';  
               if(j % 2 == 0) {  
                   k *= 2;  
                   k = k / 10 + k % 10;  
               }  
               luhmSum += k;             
           }  
           return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');  
       }  
       
       
       /**

   	* 

   	* @description:验证车牌号

   	* @param carNum

   	*            豫A106EK

   	* @return 合法：true 不合法：false

   	*/

   	public static boolean validateCarNum(String carNum) {

   	boolean result = false;

   	String[] provence = new String[] { "京", "津", "冀", "晋", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "渝",

   	"川", "黔", "滇", "藏", "陕", "甘", "青", "宁", "新", "港", "澳", "蒙" };

   	String reg = "[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}";

   	boolean firstChar = false;

   	if (carNum.length() > 0) {

   	firstChar = Arrays.asList(provence).contains(carNum.substring(0, 1));

   	}

   	try {

   	Pattern p = Pattern.compile(reg);

   	Matcher m = p.matcher(carNum);

   	if (m.matches() && firstChar) {

   	result = true;

   	} else {

   	result = false;

   	}

   	} catch (Exception e) {

   	e.printStackTrace();

   	}

   	return result;

   	}
       
   	
   	/**
   	 * 邮箱验证
   	 * @param email
   	 * @return
   	 */
    public static boolean checkEmail(String email){
		  boolean flag = false;
		  try{
		    String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		    Pattern regex = Pattern.compile(check);
		    Matcher matcher = regex.matcher(email);
		    flag = matcher.matches();
		   }catch(Exception e){
		    flag = false;
		   }
		  return flag;
		 }
	 
   	
	public static void main(String[] args) {	
		String s= "1111111111";
		boolean b = AllCheck.isChinaPhoneLegal(s);
		System.out.println(b);
		boolean s1 = AllCheck.checkBankCard("6217111111111329834");
		
		System.out.println(s1);
		
	}
}
