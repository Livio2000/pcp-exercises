/*
* HSLU I
* Module PCP
* ruedi.arnold@hslu.ch
*/

package ch.hslu.pcp.w8.lesson1.lambda;

import java.util.ArrayList;
import java.util.Collection;

public class Java8_1 {
    public static void main(String[] args) {
        Collection<Account> accounts;
        accounts = new ArrayList<>();
        accounts.add(new Account());
        accounts.forEach(a -> a.check());
        accounts.forEach(Account::check);
    }
}
