------------------  Originalu uzduotis ---------------
2. IBAN numerių iš tekstinio failo tikrinimas. Vartotojo paprašoma įvesti failo kelią ir pavadinimą. Programa nuskaito failą ir sutikrina sąskaitos numerius. Rezultatus išveda į tokio pat pavadinimo failą su plėtiniu .out.

    Pradinio failo struktūra: kiekviena eilutė - vienas sąskaitos numeris IBAN. Pvz:
        AA051245445454552117989
        LT647044001231465456
        LT517044077788877777
        LT227044077788877777
        CC051245445454552117989

    Rezultato failo struktūra: IBAN;valid. Pvz:
        AA051245445454552117989;false
        LT647044001231465456;true
        LT517044077788877777;true
        LT227044077788877777;false
        CC051245445454552117989;false


------------------  Prideta mano paildomai ---------------
1. Sugebeti apdoroti kelis failus (virs 10.000 irasu) is karto (Multitread).
   ./input direktorija
2  Saugoti i atskirus failus pagal IBAN sali.
   ./output direktorija