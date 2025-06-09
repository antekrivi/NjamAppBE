CREATE TABLE IF NOT EXISTS korisnik (
    id IDENTITY PRIMARY KEY,
    korisnicko_ime VARCHAR(50) NOT NULL,
    lozinka VARCHAR(255) NOT NULL,
    ime VARCHAR(50) NOT NULL,
    prezime VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS grupa_korisnika (
    id IDENTITY PRIMARY KEY,
    naziv VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS korisnik_grupa (
  korisnik_id INT NOT NULL,
  grupa_id INT NOT NULL,
  PRIMARY KEY (korisnik_id, grupa_id),
  FOREIGN KEY (korisnik_id) REFERENCES korisnik(id),
  FOREIGN KEY (grupa_id) REFERENCES grupa_korisnika(id)
);

CREATE TABLE IF NOT EXISTS restoran (
    id IDENTITY PRIMARY KEY,
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

CREATE TABLE IF NOT EXISTS recenzija (
     id IDENTITY PRIMARY KEY,
     naslov VARCHAR(255) NOT NULL,
     tekst VARCHAR(500) NOT NULL,
     ocjena INT NOT NULL,
     restoran_id INT NOT NULL,
     datum_objave TIMESTAMP,
     korisnik_id INT NOT NULL,
     FOREIGN KEY (restoran_id) REFERENCES restoran(id),
     FOREIGN KEY (korisnik_id) REFERENCES korisnik(id)
);
CREATE TABLE IF NOT EXISTS refresh_token (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      token VARCHAR(255) NOT NULL,
      expiry_date TIMESTAMP NOT NULL,
      user_id BIGINT NOT NULL,
      FOREIGN KEY (user_id) REFERENCES korisnik(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS  najpovoljniji_restorani(
    id IDENTITY PRIMARY KEY,
    restoran_id INT NOT NULL,
    datum DATE NOT NULL,
    FOREIGN KEY (restoran_id) REFERENCES restoran(id) ON DELETE CASCADE
);