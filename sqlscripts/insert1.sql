
/*TYPE TAG_TYPE AS ENUM ('Origine','Type de nourriture','Saveur')*/

/* -------------------- INSERT TAG -------------------- */
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Sucré','Saveur');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Salé','Saveur');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Amer','Saveur');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Acide','Saveur');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Umami','Saveur');

INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Végétarien','Type de nourriture');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Végétalien','Type de nourriture');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Agrume','Type de nourriture');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Boeuf','Type de nourriture');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Porc','Type de nourriture');

INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Italien','Origine');
INSERT INTO TAG(NAME,TAG_TYPE) VALUES('Japonais','Origine');


/* -------------------- INSERT INGREDIENT -------------------- */
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Banane','Fruit courbé et de couleur jaune');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Citron','Fruit presque rond et de couleur jaune');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Viande hachée','De la viande, hachée... et de boeuf... (sauf pour les chinois)');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Pied de porcs','Pour ceux qui aiment');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Oeuf','Un truc ovale et qui sort d on ne sait où');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Sel','Du sel');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Sucre','Du sucre');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Poivre','Du poivre');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Huile d''Olive','De l''huile qui vient des olives');
INSERT INTO INGREDIENT(NAME,DESCRIPTION) VALUES('Beurre','Du beurre, les produits laitiers sont nos amis pour la vie');



