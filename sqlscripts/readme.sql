


/*
 * DESCRIPTION DE LA BASE DE DONNEE

  La présence d'une ligne dans RECIPE_STEP_SUCCESSFUL représente la validation de l'étape par le membre.
  La boolean SUCCESSFUL dans note représente la validation de la recette par le membre.


Trigramme:
ADM ==> ADMINISTRATOR
CMT ==> COMMENT
IGD ==> INGREDIENT
IIR ==> INGREDIENT_IN_RECIPE
LVL ==> LEVEL
MBR ==> MEMBER
NOT ==> NOTE
PIC ==> PICTURE
PIR ==> PICTURE_IN_RECIPE
POL ==> PICTURE_OF_LEVEL
POI ==> PICTURE_OF_INGREDIENT
POU ==> PICTURE_OF_USER
RCP ==> RECIPE
RSS ==> RECIPE_STEP_SUCCESSFUL
RST ==> RECIPE_STEP
TAG ==> TAG
TTI ==> TAG_TO_INGREDIENT
TTR ==> TAG_TO_RECIPE
TST ==> TASTE
UIR ==> USTENSIL_IN_RECIPE
UST ==> USTENSIL




*/


/* POUR SELECTIONNER UN ENUM 
 */
select enum_range(NULL::tag_type)

/* POUR AFFICHER TOUTE LES TABLES
 */
\dt;

/* POUR AFFICHER LE SCHEMA D'UNE TABLE
 */
\d+ tablename;


/* équivalent a un type serial (si on primary = type integer)
 * http://www.postgresql.org/docs/8.3/interactive/datatype-numeric.html#DATATYPE-SERIAL
 */
CREATE SEQUENCE MEMBER_ID_MEMBER_SEQ;

ALTER TABLE MEMBER
  ALTER COLUMN id_member SET DEFAULT nextval('MEMBER_ID_MEMBER_SEQ'),
  ALTER COLUMN id_member SET NOT NULL;

ALTER SEQUENCE MEMBER_ID_MEMBER_SEQ OWNED BY MEMBER.ID_MEMBER;



/*
si des droits manquent
*/
GRANT SELECT, INSERT, UPDATE, DELETE ON recipe TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE recipe_id_recipe_seq TO cookorico;

GRANT SELECT ON administrator TO cookorico;
GRANT INSERT ON administrator TO cookorico;
GRANT UPDATE ON administrator TO cookorico;
GRANT DELETE ON administrator TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE member_mbr_id_member_seq TO cookorico;
