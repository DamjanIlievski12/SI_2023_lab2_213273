Дамјан Илиевски 213273




![CFG_Graph](https://github.com/DamjanIlievski12/SI_2023_lab2_213273/assets/128407267/17da0ab8-755d-4c4b-b50e-b0061cd1aa9b)






Цикломатската комплексност е 11. Резултатот го добив броејќи ги сите затворени региони во графот + надворешниот регион. Може да се пресмета и преку бројот на предикатни јазли + 1.

EVERY BRANCH

Test case 1: User user = null. Овој test case е за се препокрие влагањето во првиот if во кодот.

Test case 2: User user = new User (null, "cccc", "damjangmailcom"). Го покрива влагањето во if (user.getUsername()==null) и if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8)

Test case 3: boolean function (new User("us1", "dada sdad", "us1@gmail.com"), Collections.emptyList()). Со ова се покрива влагањето во третиот if-услов без влагање во loopot, како и влегување во else делот подоле.

Test case 4: boolean function(new User("us1", "dadasdad", "us1@gmail.com"),createList(new User("us1", "something2123", "us1frfr@gmail.com"), new User("user2", "something2123", "us1@gmail.com")). Се влага во првиот for loop и се посетуваат и двата if. 

Test case 5: boolean function(new User("us1", "dada$###sdad", "us1@gmail.com"), Collections.emptyList()). Покрива влегување во if-условот во последниот for loop.

Со овие 5 тест примери, сите разгранувања се покриени и поминати.

MULTIPLE CONDITION

if (user==null || user.getPassword()==null || user.getEmail()==null)

Можни услови:

T || X || X

F || T || X

F || F || T

F || F || F

Test case 1: RuntimeException ex; ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<>())); assertTrue(ex.getMessage() == "Mandatory information missing!"); Се тестира првиот услов, односно важно е само user да биде има вредност null.

Test case 2: ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("us1", null, "us1@gmail.com"), new ArrayList<>())); assertTrue(ex.getMessage() == "Mandatory information missing!"); Се тестира вториот услов, user не смее да е null, no user.password мора да е null.

Test case 3: ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("us1", "something132", null), new ArrayList<>())); assertTrue(ex.getMessage() == "Mandatory information missing!"); Се тестира третиот услов, user i user.password не смее да се null, а user.email = null

Test case 4: boolean result = SILab2.function(new User("us1", "something132", "user@gmai.com"), new ArrayList<>()); assertFalse(result); user==user.password==user.email==null, не влага во if-oт и си продолжува со другиот дел од програмата.

