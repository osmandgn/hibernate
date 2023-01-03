package s08Practice;

import org.hibernate.Session;

import static s08Practice.HBUtils.*;

public class Saver {
    public static void main(String[] args) {

        Passport passport = new Passport(1, "CT123");
        Citizen citizen = new Citizen(1,"Osman", "Dogan", passport);
        passport.setCitizen(citizen);

        saveObject(passport);
        saveObject(citizen);

        commitAndClose();



    }
}
