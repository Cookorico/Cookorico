


/* POUR SELECTIONNER UN ENUM */
select enum_range(NULL::tag_type)


/* équivalent a un type serial (si on primary = type integer)
 * http://www.postgresql.org/docs/8.3/interactive/datatype-numeric.html#DATATYPE-SERIAL
 */
CREATE SEQUENCE MEMBER_ID_MEMBER_SEQ;

ALTER TABLE MEMBER
  ALTER COLUMN id_member SET DEFAULT nextval('MEMBER_ID_MEMBER_SEQ'),
  ALTER COLUMN id_member SET NOT NULL;

ALTER SEQUENCE MEMBER_ID_MEMBER_SEQ OWNED BY MEMBER.ID_MEMBER;
