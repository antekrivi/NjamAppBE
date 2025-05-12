INSERT INTO restoran (
    id, ime_restorana, adresa, broj_telefona, email, radno_vrijeme, trenutno_otvoreno, pros_vrijeme_dostave,
    pros_ocjena_kupca, max_broj_narudzbi, michelin_zvijezdice, kratki_opis, broj_stolova, godina_osnivanja
) VALUES
      (1, 'Stari Kotac', 'Savska 11', '099-555-555', 'rest1@gmail.com',
       '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
       TRUE, 30, 4.5, 10, 1, 'Restoran s najboljom hranom u gradu', 25, 1992),

      (4, 'Kod Dede', 'Selska 22', '095-222-222', 'rest2@gmail.com',
       '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
       TRUE, 25, 4.0, 15, 0, 'Restoran s najgorom hranom u gradu', 20, 2001),

      (7, 'Pizza Planet', 'Vukovarska 33', '091-333-111', 'pizza@planet.com',
       '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
       TRUE, 40, 4.7, 8, 1, 'Najbolja pizza u svemiru', 12, 2005),

      (8, 'Green Garden', 'Zelena 9', '092-444-888', 'garden@eco.com',
       '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
       TRUE, 20, 4.2, 12, 1, 'Zdravi obroci i veganske opcije', 9, 2002),

      (9, 'Burger Bomba', 'Heinzlova 7', '098-666-999', 'burger@bomba.com',
       '{"Monday":"10:00-23:00","Tuesday":"10:00-23:00","Wednesday":"10:00-23:00","Thursday":"10:00-23:00","Friday":"10:00-23:00","Saturday":"10:00-23:00","Sunday":"10:00-23:00"}',
       FALSE, 35, 4.6, 9, 0, 'Sočni burgeri s domaćim pecivima', 6, 2019);
INSERT INTO recenzija (
    id, naslov, tekst, ocjena, restoran_id)
VALUES
      (1, 'Odlična hrana', 'Hrana je bila savršena, preporučujem!', 5, 1),
      (2, 'Dobra usluga', 'Osoblje je bilo ljubazno i brzo.', 4, 1),
      (3, 'Prosječno', 'Hrana je bila dobra, ali ništa posebno.', 3, 4),
      (4, 'Loša usluga', 'Čekali smo predugo na narudžbu.', 2, 4),
      (5, 'Fantastična pizza', 'Najbolja pizza koju sam ikad probao!', 5, 7),
      (6, 'Zelena oaza', 'Savršeno mjesto za vegane.', 4, 8),
      (7, 'Burgeri su odlični', 'Sočni i ukusni burgeri.', 5, 9),
      (8, 'Preporučujem svima', 'Savršeno mjesto za večeru.', 5, 1
)