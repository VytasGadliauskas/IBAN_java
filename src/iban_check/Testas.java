package iban_check;

public class Testas {
    public static void main(String[] args) {
        String iBan = "AD3387670514954277682883";
        System.out.println(iBan);
        String swappedIban = iBan.substring(4) + iBan.substring(0, 4);
        System.out.println(swappedIban);
        char[] iBanChars = swappedIban.toCharArray();
        String ibanInNumbers ="";
        for (char el: iBanChars) {
            int value = Integer.parseInt(Character.toString(el), 36);
            ibanInNumbers = ibanInNumbers + String.valueOf(value);
        }
        System.out.println(ibanInNumbers);

       // String aa = swappedIban.chars().reduce(0, (int previousMod, int _char) -> {
        //            int value = Integer.parseInt(Character.toString((char) _char), 36);

        //System.out.println(aa);


          //          int factor = value < 10 ? 10 : 100;
         //        ((factor * previousMod + value) % 97);




    }


}
