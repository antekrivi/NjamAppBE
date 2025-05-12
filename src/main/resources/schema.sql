CREATE TABLE IF NOT EXISTS restoran (
    id IDENTITY,
    ime_restorana VARCHAR(255) NOT NULL,
    adresa VARCHAR(255) NOT NULL,
    broj_telefona VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    radno_vrijeme TEXT NOT NULL,
    trenutno_otvoreno BOOLEAN NOT NULL,
    pros_vrijeme_dostave INT NOT NULL,
    pros_ocjena_kupca DOUBLE NOT NULL,
    max_broj_narudzbi INT NOT NULL,
    michelin_zvijezdice INT,
    kratki_opis VARCHAR(500) NOT NULL,
    broj_stolova INT NOT NULL,
    godina_osnivanja INT NOT NULL
);
CREATE TABLE IF NOT EXISTS recenzija(
    id IDENTITY,
    naslov VARCHAR(255) NOT NULL,
    tekst VARCHAR(500) NOT NULL,
    ocjena INT NOT NULL,
    restoran_id INT NOT NULL,
    FOREIGN KEY (restoran_id) REFERENCES restoran(id)
)