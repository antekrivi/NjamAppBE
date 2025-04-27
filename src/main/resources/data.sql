INSERT INTO restoran (
    id, ime_restorana, adresa, broj_telefona, email, radno_vrijeme, trenutno_otvoreno,
    pros_vrijeme_dostave, pros_ocjena_kupca, max_broj_narudzbi, michelin_zvijezdice, kratki_opis
) VALUES
      (1, 'Stari Kotac', 'Savska 11', '099-555-555', 'rest1@gmail.com',
       '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
       TRUE, 30, 4.5, 10, 1, 'Restoran s najboljom hranom u gradu'),

      (4, 'Kod Dede', 'Selska 22', '095-222-222', 'rest2@gmail.com',
       '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
       TRUE, 25, 4.0, 15, 0, 'Restoran s najgorom hranom u gradu'),

      (7, 'Pizza Planet', 'Vukovarska 33', '091-333-111', 'pizza@planet.com',
       '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
       TRUE, 40, 4.7, 8, 1, 'Najbolja pizza u svemiru'),

      (8, 'Green Garden', 'Zelena 9', '092-444-888', 'garden@eco.com',
       '{"Monday":"08:00-22:00","Tuesday":"08:00-22:00","Wednesday":"08:00-22:00","Thursday":"08:00-22:00","Friday":"08:00-22:00","Saturday":"10:00-23:00","Sunday":"Closed"}',
       TRUE, 20, 4.2, 12, 1, 'Zdravi obroci i veganske opcije'),

      (9, 'Burger Bomba', 'Heinzlova 7', '098-666-999', 'burger@bomba.com',
       '{"Monday":"10:00-23:00","Tuesday":"10:00-23:00","Wednesday":"10:00-23:00","Thursday":"10:00-23:00","Friday":"10:00-23:00","Saturday":"10:00-23:00","Sunday":"10:00-23:00"}',
       TRUE, 35, 4.6, 9, 0, 'Sočni burgeri s domaćim pecivima');
