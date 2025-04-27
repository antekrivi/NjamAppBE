CREATE TABLE IF NOT EXISTS restoran (
    id IDENTITY,
    ime_restorana VARCHAR(255) NOT NULL,
    adresa VARCHAR(255) NOT NULL,
    broj_telefona VARCHAR(50),
    email VARCHAR(255),
    radno_vrijeme TEXT,
    trenutno_otvoreno BOOLEAN,
    pros_vrijeme_dostave INT,
    pros_ocjena_kupca DOUBLE,
    max_broj_narudzbi INT,
    michelin_zvijezdice INT,
    kratki_opis VARCHAR(500)
);
