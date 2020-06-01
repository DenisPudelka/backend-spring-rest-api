# Backend projekat

## API

API je interfejs, predstavlja neki sloj koji omogućava lakšu i standardizovanu
komunikaciju među aplikacijama. Detalji kako sprovodi neki program neku funkciju 
je skriveno iza unutar programa. 

Na primer, kad se pritisne dugme da se ugasi računar, svašta se tu dešava iza,
što je u suštini nebitno za korisnika, bitan je jedino rezultat
Primerice zamisli da imaš ogromnu bazu podataka koja je korisna određenoj grupi ljudi, da bi ti korisnici imali korist neku
od tih podataka, ti bi morala da napraviš neki interfejs da bi korisnici 
mogli lakše da koriste tu bazu podataka, tipa recimo da korisnici preko
aplikacije pošalju neko ime, pa ta aplikacija da vrati iz baze podataka
sve redove koje sadrže to ime

REST API je poseban stil softverske arhitekture za API, obično se koristi
JSON format za komunikaciju između aplikacija
Primer ovao izgleda:
{
	"ime":"Johnny",
	"prezime":"Depp"
}
JSON

JSON je format koji se koristi za slanje podataka na internetu, 
alternative složenijem XML format.


MVC arhitektura
To je jedna od arhitektura koja se često koristi za izgradnju web aplikcija.
Model - View - Controller
View je korisnički interfejs, to jest ono što vidimo
Controller je ono iza u kodu šta ne vidimo
Controller određuje šta će korisnik videti, koji "View" to jest šta će da prikaže u brauzeru
Na primer kontroler čita url /login, pa će kontroler prikazati korisniku 
formu za login itd
ili /student/ime/ana ako je u pitanju neka databaza kontroler bi verovatno(ako
je tako isprogramirano) prikazao podatke o studentu kojem je ime ana
i
## Baza podataka
PostgresSQL je server za bazu podataka
A SQL je samo standardizovani jezik koji se koristi za izvršavanje "query"-ija
za baze podataka
recimo "SHOW * FROM student" prikaže sve redove tabele student

## Projekat fajl struktura
Glavni fajlovi i klase za projekat se nalaze unutar
src/main (neka te podseti "main" - glavno na eng.)

unutar toga imamo java i resource
Java tu su razne klase, kod koji je pisan
A za Resources su razni konfiguracioni fajlovi, skripte i razni resursi


Da se pokrene aplikacija uđe se na src/main/java/rppim 
i pored naših paketa imamo tamo RppImApplication
Desni klik, run as, i run as Spring Boot App

## Paketi - Packages

Imamo ctrl, jpa, reps

ctrl - kontroler paket
tu su svi kontroleri za naš projekat
jpa - služi za predstavljanje i povezivanje klase/objekta sa baza podataka
reps - dodatne funkcije za pretraživanje, npr po imenu

Kontroler za Student, Projekat, Grupa Smer
GrupaRestController - to je kontroler posvećen klasi Grupa, on služi za prihvatanje requesta i prikazivanje podataka vezano za tabelu Grupa u bazi podaka. Na primer ako pošaljemo DELETE request
na link /grupa/2 on će obrisati grupu koja ima id = 2

## Requestovi

GET, POST, PUT, DELETE
