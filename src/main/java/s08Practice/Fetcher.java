package s08Practice;

import static s08Practice.HBUtils.*;

public class Fetcher {
    public static void main(String[] args) {

        Citizen ct = (Citizen) getObject(Citizen.class, 1);
        System.out.println(ct);

        commitAndClose();




    }
}
