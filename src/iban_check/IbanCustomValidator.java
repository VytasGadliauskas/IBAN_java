package iban_check;


public class IbanCustomValidator {
    private final String country;
    private final boolean isValid;

    public IbanCustomValidator(String iBan) {
        String countryCode = iBan.substring(0, 2);
        String[] lineConst = IbanData.getIbanDataByCountryCode(countryCode);

        if (lineConst.length > 0) {
            int lengthConstant = Integer.parseInt(lineConst[1]);
            this.country = lineConst[0];
            String bBan = lineConst[2];
            String ibanFormat = lineConst[3];
            this.isValid = iBan.length() == lengthConstant;
        } else {
            this.country = "OTHER";
            this.isValid = false;
            System.out.println(CollorCodes.ANSI_RED.ansiCode + "IBAN number " + iBan + " not in COUNTRY table." + CollorCodes.ANSI_RESET.ansiCode);
        }
    }

    public String getCountry() {
        return country;
    }

    public boolean isValid() {
        return isValid;
    }

}
