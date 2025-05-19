-- Korisnici
INSERT INTO korisnik (korisnicko_ime, lozinka, ime, prezime) VALUES
     ('user', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'Korisnik', 'Jedan'),
     ('admin', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'Admin', 'Jedan'),
     ('guest', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'Gost', 'Jedan');

-- Grupe
INSERT INTO grupa_korisnika (naziv) VALUES
    ('USER'),
    ('ADMIN');

-- Veze korisnik–grupa
INSERT INTO korisnik_grupa (korisnik_id, grupa_id) VALUES
   (1, 1),  -- user → USER
   (2, 1),  -- admin → USER
   (2, 2);  -- admin → ADMIN


INSERT INTO restoran (
    ime_restorana, adresa, broj_telefona, email, radno_vrijeme,
    trenutno_otvoreno, pros_vrijeme_dostave, pros_ocjena_kupca, max_broj_narudzbi,
    michelin_zvijezdice, kratki_opis, broj_stolova, godina_osnivanja
) VALUES
  ('Stari Kotac', 'Savska 11', '099-555-555', 'rest1@gmail.com',
   '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
   TRUE, 30, 4.5, 10, 1, 'Restoran s najboljom hranom u gradu', 25, 1992),

  ('Kod Dede', 'Selska 22', '095-222-222', 'rest2@gmail.com',
   '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
   TRUE, 25, 4.0, 15, 0, 'Restoran s najgorom hranom u gradu', 20, 2001),

  ('Pizza Planet', 'Vukovarska 33', '091-333-111', 'pizza@planet.com',
   '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
   TRUE, 40, 4.7, 8, 1, 'Najbolja pizza u svemiru', 12, 2005),

  ('Green Garden', 'Zelena 9', '092-444-888', 'garden@eco.com',
   '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
   TRUE, 20, 4.2, 12, 1, 'Zdravi obroci i veganske opcije', 9, 2002),

  ('Burger Bomba', 'Heinzlova 7', '098-666-999', 'burger@bomba.com',
   '{"Monday":"10:00-23:00","Tuesday":"10:00-23:00","Wednesday":"10:00-23:00","Thursday":"10:00-23:00","Friday":"10:00-23:00","Saturday":"10:00-23:00","Sunday":"10:00-23:00"}',
   FALSE, 35, 4.6, 9, 0, 'Sočni burgeri s domaćim pecivima', 6, 2019);


INSERT INTO recenzija (naslov, tekst, ocjena, restoran_id, datum_objave, korisnik_id) VALUES
      ('Odlična hrana', 'Hrana je bila savršena, preporučujem!', 5, 1, '2025-05-01 12:00:00', 1),
      ('Dobra usluga', 'Osoblje je bilo ljubazno i brzo.', 4, 1, '2025-05-03 15:30:00', 2),
      ('Prosječno', 'Hrana je bila dobra, ali ništa posebno.', 3, 4, '2025-04-28 18:00:00', 1),
      ('Loša usluga', 'Čekali smo predugo na narudžbu.', 2, 3, '2025-04-20 19:15:00', 2),
      ('Fantastična pizza', 'Najbolja pizza koju sam ikad probao!', 5, 3, '2025-05-05 13:45:00', 1), -- promijenjeno s 7 na 3
      ('Zelena oaza', 'Savršeno mjesto za vegane.', 4, 2, '2025-05-06 11:00:00', 2),
      ('Burgeri su odlični', 'Sočni i ukusni burgeri.', 5, 2, '2025-05-10 17:00:00', 1),
      ('Preporučujem svima', 'Savršeno mjesto za večeru.', 5, 1, '2025-05-11 20:00:00', 1);




