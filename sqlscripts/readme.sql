


/*
 * DESCRIPTION DE LA BASE DE DONNEE

  La présence d'une ligne dans RECIPE_STEP_SUCCESSFUL représente la validation de l'étape par le membre.
  La boolean SUCCESSFUL dans note représente la validation de la recette par le membre.



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
GRANT SELECT ON recipe TO cookorico;
GRANT INSERT ON recipe TO cookorico;
GRANT UPDATE ON recipe TO cookorico;
GRANT DELETE ON recipe TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE recipe_id_recipe_seq TO cookorico;
