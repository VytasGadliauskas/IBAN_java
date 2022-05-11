package iban_check;

import java.util.ArrayList;

public class IbanData {
       // 2022-03-12 dienos duomenys https://en.wikipedia.org/wiki/International_Bank_Account_Number
       public static String[] getIbanDataByCountryCode (String countryCode){
            ArrayList<String> ibandata = new ArrayList();
            ibandata.add("ALBANIA,28,8n 16c,AL kk bbb s sss x cccc cccc cccc cccc");
            ibandata.add("ANDORRA,24,8n 12c,AD kk bbbb ssss cccc cccc cccc");
            ibandata.add("AUSTRIA,20,16n,AT kk bbbb b ccc cccc cccc");
            ibandata.add("AZERBAIJAN,28,4c 20n,AZ kk bbbb cccc cccc cccc cccc cccc");
            ibandata.add("BAHRAIN,22,4a 14c,BH kk bbbb cccc cccc cccc cc");
            ibandata.add("BELARUS,28,4c 4n 16c,BY kk bbbb aaaa cccc cccc cccc cccc");
            ibandata.add("BELGIUM,16,12n,BE kk bbb c cccc cc xx");
            ibandata.add("BOSNIA_AND_HERZEGOVINA,20,16n,BA kk bbb s ss cc cccc cc xx");
            ibandata.add("BRAZIL,29,23n 1a 1c,BR kk bbbb bbbb ssss s ccc cccc ccc t n");
            ibandata.add("BULGARIA,22,4a 6n 8c,BG kk bbbb ssss tt cc cccc cc");
            ibandata.add("COSTA_RICA,22,18n,CR kk 0 bbb cccc cccc cccc cc");
            ibandata.add("CROATIA,21,17n,HR kk bbbb bbb c cccc cccc c");
            ibandata.add("CYPRUS,28,8n 16c,CY kk bbb s ssss cccc cccc cccc cccc");
            ibandata.add("CZECH_REPUBLIC,24,20n,CZ kk bbbb ssss ss cc cccc cccc");
            ibandata.add("DENMARK,18,14n,DK kk bbbb cccc cccc c x");
            ibandata.add("DOMINICAN_REPUBLIC,28,4a 20n ,DO kk bbbb cccc cccc cccc cccc cccc");
            ibandata.add("EAST_TIMOR,23,19n,TL kk bbb c cccc cccc cccc c xx");
            ibandata.add("EGYPT,29,25n,EG kk bbbb ssss cccc cccc cccc cccc c");
            ibandata.add("EL_SALVADOR,28,4a 20n,SV kk bbbb cccc cccc cccc cccc cccc");
            ibandata.add("ESTONIA,20,16n,EE kk bb ss cccc cccc ccc x");
            ibandata.add("FAROE_ISLANDS,18,14n,FO kk bbbb cccc cccc c x");
            ibandata.add("FINLAND,18,14n,FI kk bbbb bb cc cccc c x");
            ibandata.add("FRANCE,27,10n 11c 2n,FR kk bbbb b sss ss cc cccc cccc c xx");
            ibandata.add("GEORGIA,22,2c 16n,GE kk bb cc cccc cccc cccc cc");
            ibandata.add("GERMANY,22,18n,DE kk bbbb bbbb cccc cccc cc");
            ibandata.add("GIBRALTAR,23,4a 15c,GI kk bbbb cccc cccc cccc ccc");
            ibandata.add("GREECE,27,7n 16c,GR kk bbb s sss c cccc cccc cccc ccc");
            ibandata.add("GREENLAND,18,14n,GL kk bbbb cccc cccc c x");
            ibandata.add("GUATEMALA,28,4c 20c,GT kk bbbb mm tt cccc cccc cccc cccc");
            ibandata.add("HUNGARY,28,24n,HU kk bbb s sss x cccc cccc cccc ccc x");
            ibandata.add("ICELAND,26,22n,IS kk bb ss tt cc cccc iiii iiii ii");
            ibandata.add("IRAQ,23,4a 15n,IQ kk bbbb sss c cccc cccc ccc");
            ibandata.add("IRELAND,22,4c 14n,IE kk aaaa bbbb bb cc cccc cc");
            ibandata.add("ISRAEL,23,19n,IL kk bbb s ss cc cccc cccc ccc");
            ibandata.add("ITALY,27,1a 10n 12c,IT kk x bbb bb ss sss c cccc cccc ccc");
            ibandata.add("JORDAN,30,4a 22n,JO kk bbbb ssss cccc cccc cccc cccc cc");
            ibandata.add("KAZAKHSTAN,20,3n 13c,KZ kk bbb c cccc cccc cccc");
            ibandata.add("KOSOVO,20,4n 10n 2n,XK kk bbbb cccc cccc cccc");
            ibandata.add("KUWAIT,30,4a 22c,KW kk bbbb cccc cccc cccc cccc cccc cc");
            ibandata.add("LATVIA,21,4a 13c,LV kk bbbb cccc cccc cccc c");
            ibandata.add("LEBANON,28,4n 20c,LB kk bbbb cccc cccc cccc cccc cccc");
            ibandata.add("LIBYA,25,21n,LY kk bbb s ss cc cccc cccc cccc c");
            ibandata.add("LIECHTENSTEIN,21,5n 12c,LI kk bbbb b ccc cccc cccc c");
            ibandata.add("LITHUANIA,20,16n,LT kk bbbb b ccc cccc cccc");
            ibandata.add("LUXEMBOURG,20,3n 13c,LU kk bbb c cccc cccc cccc");
            ibandata.add("NORTH_MACEDONIA,19,3n 10c 2n,MK kk bbb c cccc cccc c xx");
            ibandata.add("MALTA,31,4a 5n 18c,MT kk bbbb ssss s ccc cccc cccc cccc ccc");
            ibandata.add("MAURITANIA,27,23n,MR kk bbbb b sss ss cc cccc cccc c xx");
            ibandata.add("MAURITIUS,30,4a 19n 3a,MU kk bbbb bb ss cccc cccc cccc 000m mm");
            ibandata.add("MONACO,27,10n 11c 2n,MC kk bbbb b sss ss cc cccc cccc c xx");
            ibandata.add("MOLDOVA,24,2c 18c,MD kk bb cc cccc cccc cccc cccc");
            ibandata.add("MONTENEGRO,22,18n,ME kk bbb c cccc cccc cccc xx");
            ibandata.add("NETHERLANDS,18,4a 10n,NL kk bbbb cccc cccc cc");
            ibandata.add("NORWAY,15,11n,NO kk bbbb cccc cc x");
            ibandata.add("PAKISTAN,24,4c 16n,PK kk bbbb cccc cccc cccc cccc");
            ibandata.add("PALESTINIAN_TERRITORIES,29,4c 21n,PS kk bbbb cccc cccc cccc cccc cccc c");
            ibandata.add("POLAND,28,24n,PL kk bbb s sss x cccc cccc cccc cccc");
            ibandata.add("PORTUGAL,25,21n,PT kk bbbb ssss cccc cccc ccc x x");
            ibandata.add("QATAR,29,4a 21c,QA kk bbbb cccc cccc cccc cccc cccc c");
            ibandata.add("ROMANIA,24,4a 16c,RO kk bbbb cccc cccc cccc cccc");
            ibandata.add("SAINT_LUCIA,32,4a 24c,LC kk bbbb cccc cccc cccc cccc cccc cccc");
            ibandata.add("SAN_MARINO,27,1a 10n 12c,SM kk x bbb bb ss sss c cccc cccc ccc");
            ibandata.add("SAO_TOME_AND_PRÍNCIPE,25,21n,ST kk bbbb ssss cccc cccc cccc c");
            ibandata.add("SAUDI_ARABIA,24,2n 18c,SA kk bb cc cccc cccc cccc cccc");
            ibandata.add("SERBIA,22,18n,RS kk bbb c cccc cccc cccc xx");
            ibandata.add("SEYCHELLES,31,4a 20n 3a,SC kk bbbb bb ss nnnn nnnn nnnn nnnn mmm");
            ibandata.add("SLOVAKIA,24,20n,SK kk bbbb ssss ss cc cccc cccc");
            ibandata.add("SLOVENIA,19,15n,SI kk bb ss s ccc cccc c xx");
            ibandata.add("SPAIN,24,20n,ES kk bbbb ssss xx cc cccc cccc");
            ibandata.add("SUDAN,18,14n,SD kk bb cc cccc cccc cc");
            ibandata.add("SWEDEN,24,20n,SE kk bbb c cccc cccc cccc cccc");
            ibandata.add("SWITZERLAND,21,5n 12c,CH kk bbbb b ccc cccc cccc c");
            ibandata.add("TUNISIA,24,20n,TN kk bb ss s ccc cccc cccc cc xx");
            ibandata.add("TURKEY,26,5n 17c,TR kk bbbb b 0 cc cccc cccc cccc cc");
            ibandata.add("UKRAINE,29,6n 19c,UA kk bbbb bb cc cccc cccc cccc cccc c");
            ibandata.add("UNITED_ARAB_EMIRATES,23,3n 16n,AE kk bbb c cccc cccc cccc ccc");
            ibandata.add("UNITED_KINGDOM,22,4a 14n,GB kk bbbb ssss ss cc cccc cc");
            ibandata.add("VATICAN_CITY,22,3n 15n,VA kk bbb c cccc cccc cccc cc");
            ibandata.add("VIRGIN_ISLANDS_BRITISH,24,4c 16n,VG kk bbbb cccc cccc cccc cccc");

            for(int i=0; i<ibandata.size();i++){
                  String[] line = ibandata.get(i).split(",");
                  String code = line[3].substring(0,2);
                  if (code.equals(countryCode)){
                      return line;
                  }
            }
            String[] lineOther = {"OTHER","0","0","OTHER"};
            return  lineOther;
       }
}
