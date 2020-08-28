#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Niveau
#------------------------------------------------------------

CREATE TABLE Niveau(
        idNiveau Int  Auto_increment  NOT NULL ,
        libelle  Varchar (50) NOT NULL
	,CONSTRAINT Niveau_PK PRIMARY KEY (idNiveau)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Classe
#------------------------------------------------------------

CREATE TABLE Classe(
        idClasse Int  Auto_increment  NOT NULL ,
        nom      Varchar (50) NOT NULL ,
        idNiveau Int NOT NULL
	,CONSTRAINT Classe_PK PRIMARY KEY (idClasse)

	,CONSTRAINT Classe_Niveau_FK FOREIGN KEY (idNiveau) REFERENCES Niveau(idNiveau)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Eleve
#------------------------------------------------------------

CREATE TABLE Eleve(
        idEleve       Int  Auto_increment  NOT NULL ,
        Nom           Varchar (50) NOT NULL ,
        Prenom        Varchar (50) NOT NULL ,
        dateNaissance Date NOT NULL ,
        idClasse      Int NOT NULL
	,CONSTRAINT Eleve_PK PRIMARY KEY (idEleve)

	,CONSTRAINT Eleve_Classe_FK FOREIGN KEY (idClasse) REFERENCES Classe(idClasse)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Note
#------------------------------------------------------------

CREATE TABLE Note(
        idNote Int  Auto_increment  NOT NULL ,
        note   Varchar (50) NOT NULL ,
        date   Date NOT NULL
	,CONSTRAINT Note_PK PRIMARY KEY (idNote)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Matiere
#------------------------------------------------------------

CREATE TABLE Matiere(
        idMatiere Int  Auto_increment  NOT NULL ,
        libelle   Varchar (50) NOT NULL
	,CONSTRAINT Matiere_PK PRIMARY KEY (idMatiere)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TypeProf
#------------------------------------------------------------

CREATE TABLE TypeProf(
        idTypeProf Int  Auto_increment  NOT NULL ,
        libelle    Varchar (50) NOT NULL
	,CONSTRAINT TypeProf_PK PRIMARY KEY (idTypeProf)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Professeur
#------------------------------------------------------------

CREATE TABLE Professeur(
        idProf     Int  Auto_increment  NOT NULL ,
        Nom        Varchar (50) NOT NULL ,
        Prenom     Varchar (50) NOT NULL ,
        Tel        Varchar (10) NOT NULL ,
        mail       Varchar (10) NOT NULL ,
        idTypeProf Int NOT NULL
	,CONSTRAINT Professeur_PK PRIMARY KEY (idProf)

	,CONSTRAINT Professeur_TypeProf_FK FOREIGN KEY (idTypeProf) REFERENCES TypeProf(idTypeProf)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TypeMateriel
#------------------------------------------------------------

CREATE TABLE TypeMateriel(
        idTypeMateriel Int  Auto_increment  NOT NULL ,
        libelle        Varchar (50) NOT NULL
	,CONSTRAINT TypeMateriel_PK PRIMARY KEY (idTypeMateriel)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Matériel
#------------------------------------------------------------

CREATE TABLE Materiel(
        idMateriel     Int  Auto_increment  NOT NULL ,
        nom            Varchar (50) NOT NULL ,
        idTypeMateriel Int NOT NULL
	,CONSTRAINT Materiel_PK PRIMARY KEY (idMateriel)

	,CONSTRAINT Materiel_TypeMateriel_FK FOREIGN KEY (idTypeMateriel) REFERENCES TypeMateriel(idTypeMateriel)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Cour
#------------------------------------------------------------

CREATE TABLE Cour(
        idCour    Int  Auto_increment  NOT NULL ,
        intitule  Varchar (50) NOT NULL ,
        idMatiere Int NOT NULL
	,CONSTRAINT Cour_PK PRIMARY KEY (idCour)

	,CONSTRAINT Cour_Matiere_FK FOREIGN KEY (idMatiere) REFERENCES Matiere(idMatiere)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: RelClasseProfesseur
#------------------------------------------------------------

CREATE TABLE RelClasseProfesseur(
        idProf   Int NOT NULL ,
        idClasse Int NOT NULL
	,CONSTRAINT RelClasseProfesseur_PK PRIMARY KEY (idProf,idClasse)

	,CONSTRAINT RelClasseProfesseur_Professeur_FK FOREIGN KEY (idProf) REFERENCES Professeur(idProf)
	,CONSTRAINT RelClasseProfesseur_Classe0_FK FOREIGN KEY (idClasse) REFERENCES Classe(idClasse)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Rel_Note_Eleve 12
#------------------------------------------------------------

CREATE TABLE Rel_Note_Eleve(
        idNote  Int NOT NULL ,
        idEleve Int NOT NULL ,
        idCour  Int NOT NULL
	,CONSTRAINT Rel_Note_Eleve_PK PRIMARY KEY (idNote,idEleve,idCour)

	,CONSTRAINT Rel_Note_Eleve_Note_FK FOREIGN KEY (idNote) REFERENCES Note(idNote)
	,CONSTRAINT Rel_Note_Eleve_Eleve_FK FOREIGN KEY (idEleve) REFERENCES Eleve(idEleve)
	,CONSTRAINT Rel_Note_Eleve_Cour_FK FOREIGN KEY (idCour) REFERENCES Cour(idCour)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: Reservation 13
#------------------------------------------------------------

CREATE TABLE Reservation(
        idProf   Int NOT NULL ,
        IdMateriel Int NOT NULL,
		idCour Int NOT NULL,
		date   Date NOT NULL,
		heureDebut Time NOT NULL,
		heureFin Time NOT NULL
	,CONSTRAINT Reservation_PK PRIMARY KEY (idProf,IdMateriel,idCour)

	,CONSTRAINT Reservation_Professeur_FK FOREIGN KEY (idProf) REFERENCES Professeur(idProf)
	,CONSTRAINT Reservation_Materiel_FK FOREIGN KEY (IdMateriel) REFERENCES Materiel(IdMateriel)
	,CONSTRAINT Reservation_Cour_FK FOREIGN KEY (idCour) REFERENCES Cour(idCour)
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: RelCourProfClasse 14
#------------------------------------------------------------

CREATE TABLE RelCourProfClasse(
		idCour Int NOT NULL,
        IdClasse Int NOT NULL,
		idProf   Int NOT NULL,
		date   Date NOT NULL,
		heureDebut Time NOT NULL,
		heureFin Time NOT NULL
	,CONSTRAINT RelCourProfClasse_PK PRIMARY KEY (idCour,idClasse,idProf)

	,CONSTRAINT RelCourProfClasse_Cour_FK FOREIGN KEY (idCour) REFERENCES Cour(idCour)
	,CONSTRAINT RelCourProfClasse_Classe_FK FOREIGN KEY (IdClasse) REFERENCES Classe(IdClasse)
	,CONSTRAINT RelCourProfClasse_Professeur_FK FOREIGN KEY (idProf) REFERENCES Professeur(idProf)
)ENGINE=InnoDB;

CREATE TABLE Profil(
		idProfil Int NOT NULL,
		libelle Varchar(50)
	,CONSTRAINT Profil_PK PRIMARY KEY (idProfil)

)ENGINE=InnoDB;

CREATE TABLE User (
		idUser Int NOT NULL,
		login Varchar(50),
		password varchar(255),
		idProfil Int NOT NULL
	,CONSTRAINT User_PK PRIMARY KEY (idUser)
	
	,CONSTRAINT User_Profil_FK FOREIGN KEY (idProfil) REFERENCES Profil(idProfil)
)ENGINE=InnoDB;

CREATE TABLE RelUserClasse (
		idUser Int NOT NULL,
		idClasse Int NOT NULL
		
	,CONSTRAINT RelUserClasse_PK PRIMARY KEY (idUser,idClasse)
	
	,CONSTRAINT RelUserClasse_User_FK FOREIGN KEY (idUser) REFERENCES User(idUser)
	,CONSTRAINT RelUserClasse_Classe_FK FOREIGN KEY (idClasse) REFERENCES Classe(idClasse)
)ENGINE=InnoDB;