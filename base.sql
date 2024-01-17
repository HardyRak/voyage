create database voyage;
\c voyage;

create table type(
    idtype serial not null primary key,
    nom varchar(50)
);

create table dure(
    idDure serial not null primary key,
    nom varchar(25)
);

create table voyage(
    idVoyage serial not null primary key,
    libelle varchar(50),
    idType int references type(idtype),
    dateDebut date,
    dateFin date
);

create table bouquet(
    idBouquet serial not null primary key,
    nom varchar(50),
    idType int references type(idType)
);

create table activite(
    idActivite serial not null primary key,
    nom varchar(50),
    prix decimal(9,2)
);

--------------------FAFANA------------------------
create table voyage_bouquet(
    idVoyage int references voyage(idVoyage),
    idBouquet int references bouquet(idBouquet)
);

create table bouquet_activite(
    idBouquet int references bouquet(idBouquet),
    idActivite int references activite(idActivite)
);

create table sex(
    idsex serial not null primary key,
    sex varchar(10)
);

create table client(
    idclient serial not null primary key,
    nom varchar(50),
    prenom varchar(50),
    idsex int references sex(idsex),
    naissance date
);

create table client_voyage(
    idVoyage int references voyage(idVoyage),
    idBouquet int references bouquet(idBouquet),
    idclient int references client(idclient)
);

-----------------------FAFANA---------------------
create table activite_voyage(
    idVoyage int,
    idDure int,
    idActivite int,
    idBouquet int,
    nombre int
    FOREIGN KEY(idVoyage) REFERENCES voyage(idVoyage),
    FOREIGN KEY(idDure) REFERENCES Dure(idDure),
    FOREIGN KEY(idActivite) REFERENCES activite(idActivite),
    FOREIGN KEY(idBouquet) REFERENCES bouquet(idBouquet)
    );

create table voyage_dure(
    idVoyage int,
    idDure int,
    FOREIGN KEY(idVoyage) REFERENCES voyage(idVoyage),
    FOREIGN KEY(idDure) REFERENCES Dure(idDure)
);

-------------------NIAMPY--------------------
create table voyage_activite(
     idVoyage int,
     idActivite int,
     nombreFoi int,
     idDure int,
     FOREIGN KEY(idDure) REFERENCES Dure(idDure),
     FOREIGN KEY(idVoyage) REFERENCES voyage(idVoyage),
     FOREIGN KEY(idActivite) REFERENCES activite(idActivite)
);

-----------------------MAKA activite amin Bouquet---------------------------------
create or replace view V_bouquet_activite as (SELECT bouquet.idBouquet,nom,idtype,idActivite FROM bouquet join bouquet_activite on bouquet.idBouquet=bouquet_activite.idBouquet);
create or replace view V_bouquet_activite_R as (SELECT V_bouquet_activite.idBouquet,activite.idActivite,activite.nom FROM V_bouquet_activite join activite on V_bouquet_activite.idActivite=activite.idActivite);

-----------------------MAKA bouquet amin Voyage-----------------------------------
create or replace view V_voyage_bouquet as (SELECT voyage.idVoyage,voyage.libelle,voyage.idtype,voyage.dateDebut,voyage.dateFin,voyage_bouquet.idBouquet from voyage join voyage_bouquet on voyage.idVoyage=voyage_bouquet.idVoyage);
create or replace view V_voyage_bouquet_R as (SELECT V_voyage_bouquet.idVoyage,bouquet.idBouquet,bouquet.nom,bouquet.idtype from V_voyage_bouquet join bouquet on V_voyage_bouquet.idBouquet=bouquet.idBouquet);

----------------------Maka duree bouquet (NIAMPY)--------------------------------
create or replace view v_voyage_dure_id as select voyage.idVoyage,idDure from voyage join voyage_dure on voyage.idVoyage=voyage_dure.idVoyage
create or replace view v_voyage_dure as select v_voyage_dure_id.idVoyage,v_voyage_dure_id.idDure,dure.typeDure from v_voyage_dure_id join dure on v_voyage_dure_id.idDure=dure.idDure

insert into sex(sex) values('Homme'),('Femme');

insert into activite(nom,prix) values('Piscine',1500),('Plonge',4000),('Randonne',1000);

insert into type(nom) values('International'),('Regional');
insert into dure(nom) values('court'),('long');


ALTER TABLE voyage
ADD COLUMN idBouquet int;

ALTER TABLE voyage
ADD CONSTRAINT fk_voyageBouquet
FOREIGN KEY (idBouquet) 
REFERENCES bouquet(idBouquet);

ALTER TABLE dure
RENAME COLUMN nom TO typeDure;

ALTER TABLE activite
DROP COLUMN prix cascade;

ALTER TABLE client_voyage
DROP COLUMN idBouquet;

ALTER TABLE activite add COLUMN cout decimal(9,2);

