

-- Create types
CREATE TYPE TAG_TYPE AS ENUM ('Origine','Type de nourriture','Saveur');

CREATE TYPE UNIT_OF_MEASUREMENT AS ENUM ('gramme(s)','millilitre(s)','unité(s)', 'cuillère(s) à soupe', 'centilitre(s)');

/*
devenu inutile depuis que difficulty est un nombre.
CREATE TYPE DIFFICULTY AS ENUM ('Facile','Moyen','Difficile')
*/
CREATE TYPE ADMIN_RANK AS ENUM ('Administrateur','Moderateur');

CREATE TYPE DISH_TYPE AS ENUM ('Dessert','Entree','Plat');

CREATE TYPE GENDER AS ENUM ('M','F','U');


-- Create schemas

-- Create tables
CREATE TABLE IF NOT EXISTS MEMBER
(
    MBR_ID_MEMBER SERIAL NOT NULL UNIQUE,
    MBR_USERNAME VARCHAR(255) NOT NULL UNIQUE,
    MBR_FIRSTNAME VARCHAR(255),
    MBR_LASTNAME VARCHAR(255),
    MBR_EMAIL VARCHAR(255) NOT NULL UNIQUE,
    MBR_PASSWORD VARCHAR(255) NOT NULL,
    MBR_EXPERIENCE INTEGER DEFAULT 0 NOT NULL,
    MBR_LEVEL INTEGER DEFAULT 1 NOT NULL,
    MBR_SALT VARCHAR(255),
    MBR_GENDER GENDER,
    MBR_DISABLED BOOLEAN DEFAULT false NOT NULL,
    MBR_BIRTHDAY DATE,
    MBR_MAIN_PICTURE INTEGER,
    MBR_CITY VARCHAR(255),
    MBR_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    MBR_MODIF_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    PRIMARY KEY(MBR_ID_MEMBER)
);

CREATE TABLE IF NOT EXISTS INGREDIENT
(
    IGD_ID_INGREDIENT SERIAL NOT NULL UNIQUE,
    IGD_NAME VARCHAR(255) NOT NULL UNIQUE,
    IGD_DESCRIPTION TEXT,
    IGD_MAIN_PICTURE INTEGER,
    IGD_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    IGD_MODIF_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    IGD_VALIDATION BOOLEAN DEFAULT false NOT NULL,
    IGD_DISABLED BOOLEAN DEFAULT false NOT NULL,
    PRIMARY KEY(IGD_ID_INGREDIENT)
);

CREATE TABLE IF NOT EXISTS TAG
(
    TAG_ID_TAG SERIAL NOT NULL UNIQUE,
    TAG_NAME VARCHAR(255) NOT NULL UNIQUE,
    TAG_TYPE TAG_TYPE,
    TAG_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    PRIMARY KEY(TAG_ID_TAG)
);

CREATE TABLE IF NOT EXISTS TASTE
(
    TST_ID_TASTE SERIAL NOT NULL UNIQUE,
    TST_FK_ID_MEMBER INTEGER NOT NULL,
    TST_FK_ID_INGREDIENT INTEGER NOT NULL,
    TST_GRADING INTEGER DEFAULT 0 NOT NULL,
    TST_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    TST_MODIF_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    PRIMARY KEY(TST_ID_TASTE)
);

CREATE TABLE IF NOT EXISTS RECIPE
(
    RCP_ID_RECIPE SERIAL NOT NULL UNIQUE,
    RCP_NAME VARCHAR(255) NOT NULL,
    RCP_DESCRIPTION TEXT,
    RCP_PREPARATION_TIME INTEGER,
    RCP_COOKING_TIME INTEGER,
    RCP_FK_CREATOR INTEGER NOT NULL,
    RCP_DISH_TYPE VARCHAR(255),
    RCP_DIFFICULTY INTEGER DEFAULT 0 NOT NULL,
    RCP_DRAFT BOOLEAN DEFAULT true NOT NULL,
    RCP_MAIN_PICTURE INTEGER,
    RCP_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    RCP_MODIF_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    RCP_VALIDATION BOOLEAN DEFAULT false NOT NULL,
    RCP_VALIDATOR INTEGER,
    RCP_DISABLED BOOLEAN DEFAULT false NOT NULL,
    RCP_EXPERIENCE_VAL INTEGER DEFAULT 0 NOT NULL,
    PRIMARY KEY(RCP_ID_RECIPE)
);

CREATE TABLE IF NOT EXISTS TAG_TO_INGREDIENT
(
    TTI_ID_TAG_TO_INGREDIENT SERIAL NOT NULL UNIQUE,
    TTI_FK_ID_TAG INTEGER,
    TTI_FK_ID_INGREDIENT INTEGER,
    TTI_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    PRIMARY KEY(TTI_ID_TAG_TO_INGREDIENT)
);

CREATE TABLE IF NOT EXISTS INGREDIENT_IN_RECIPE
(
    IIR_ID_INGREDIENT_IN_RECIPE SERIAL NOT NULL UNIQUE,
    IIR_FK_ID_INGREDIENT INTEGER NOT NULL,
    IIR_FK_ID_RECIPE INTEGER NOT NULL,
    IIR_QUANTITY INTEGER NOT NULL,
    IIR_MEASUREMENT UNIT_OF_MEASUREMENT NOT NULL,
    PRIMARY KEY(IIR_ID_INGREDIENT_IN_RECIPE)
);

CREATE TABLE IF NOT EXISTS PICTURE
(
    PIC_ID_PICTURE SERIAL NOT NULL UNIQUE,
    PIC_FK_ID_MEMBER INTEGER NOT NULL,
    PIC_FILE_PATH VARCHAR(255) NOT NULL,
    PIC_FILE_NAME VARCHAR(255) NOT NULL,
    PIC_TITLE VARCHAR(255),
    PIC_DESCRIPTION VARCHAR(1024),
    PIC_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    PIC_DISABLED BOOLEAN DEFAULT false NOT NULL,
    PRIMARY KEY(PIC_ID_PICTURE)
);

CREATE TABLE IF NOT EXISTS RECIPE_STEP
(
    RST_ID_RECIPE_STEP SERIAL NOT NULL UNIQUE,
    RST_FK_ID_RECIPE INTEGER NOT NULL,
    RST_RANK INTEGER,
    RST_NAME VARCHAR(255) NOT NULL,
    RST_DESCRIPTION TEXT,
    RST_DURATION_TIME INTEGER,
    RST_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    RST_MODIF_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    RST_DISABLED BOOLEAN DEFAULT false NOT NULL,
    PRIMARY KEY(RST_ID_RECIPE_STEP)
);

CREATE TABLE IF NOT EXISTS TAG_TO_RECIPE
(
    TTR_ID_TAG_TO_RECIPE SERIAL NOT NULL UNIQUE,
    TTR_FK_ID_TAG INTEGER NOT NULL,
    TTR_FK_ID_RECIPE INTEGER NOT NULL,
    TTR_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    PRIMARY KEY(TTR_ID_TAG_TO_RECIPE)
);

CREATE TABLE IF NOT EXISTS COMMENT
(
    CMT_ID_COMMENT SERIAL NOT NULL UNIQUE,
    CMT_FK_ID_RECIPE INTEGER NOT NULL,
    CMT_FK_ID_MEMBER INTEGER NOT NULL,
    CMT_TITLE VARCHAR(255) NOT NULL,
    CMT_DESCRIPTION TEXT NOT NULL,
    CMT_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    CMT_MODIF_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    CMT_VALIDATION BOOLEAN DEFAULT false NOT NULL,
    CMT_VALIDATOR INTEGER,
    CMT_DISABLED BOOLEAN DEFAULT false NOT NULL,
    PRIMARY KEY(CMT_ID_COMMENT)
);

CREATE TABLE IF NOT EXISTS NOTE
(
    NOT_ID_NOTE SERIAL NOT NULL UNIQUE,
    NOT_FK_ID_MEMBER INTEGER,
    NOT_FK_ID_RECIPE INTEGER,
    NOT_FK_ID_COMMENT INTEGER NOT NULL UNIQUE,
    NOT_RATING INTEGER,
    NOT_SUCCESSFUL BOOLEAN DEFAULT false NOT NULL,
    NOT_CREATION_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    NOT_MODIF_DATE TIMESTAMP DEFAULT statement_timestamp() NOT NULL,
    PRIMARY KEY(NOT_ID_NOTE)
);

CREATE TABLE IF NOT EXISTS PICTURE_IN_RECIPE
(
    PIR_ID_PICTURE_IN_RECIPE SERIAL NOT NULL UNIQUE,
    PIR_FK_ID_RECIPE INTEGER NOT NULL,
    PIR_FK_ID_PICTURE INTEGER NOT NULL,
    PIR_FK_ID_COMMENT INTEGER,
    PRIMARY KEY(PIR_ID_PICTURE_IN_RECIPE)
);

CREATE TABLE IF NOT EXISTS ADMINISTRATOR
(
    ADM_ID_ADMINISTRATOR INTEGER NOT NULL UNIQUE,
    ADM_RANK ADMIN_RANK,
    PRIMARY KEY(ADM_ID_ADMINISTRATOR)
);

CREATE TABLE IF NOT EXISTS PICTURE_OF_INGREDIENT
(
    POI_ID_PICTURE_OF_INGREDIENT SERIAL NOT NULL UNIQUE,
    POI_FK_ID_INGREDIENT INTEGER,
    POI_FK_ID_PICTURE INTEGER,
    PRIMARY KEY(POI_ID_PICTURE_OF_INGREDIENT)
);

CREATE TABLE IF NOT EXISTS PICTURE_OF_USER
(
    POU_ID_PICTURE_OF_USER INTEGER NOT NULL UNIQUE,
    PRIMARY KEY(POU_ID_PICTURE_OF_USER)
);

CREATE TABLE IF NOT EXISTS RECIPE_STEP_SUCCESSFUL
(
    RSS_ID_RECIPE_STEP_SUCCESSFUL SERIAL NOT NULL UNIQUE,
    RSS_ID_MEMBER INTEGER NOT NULL,
    RSS_ID_RECIPE_STEP INTEGER NOT NULL,
    PRIMARY KEY(RSS_ID_RECIPE_STEP_SUCCESSFUL)
);

CREATE TABLE IF NOT EXISTS LEVEL
(
    LVL_ID_LEVEL SERIAL NOT NULL,
    LVL_LABEL VARCHAR(100) NOT NULL,
    LVL_MAIN_PICTURE INTEGER,
    LVL_XP_MIN INTEGER NOT NULL,
    LVL_XP_MAX INTEGER NOT NULL,
    LVL_NUM INTEGER NOT NULL UNIQUE,
    PRIMARY KEY(LVL_ID_LEVEL)
);

CREATE TABLE IF NOT EXISTS PICTURE_OF_LEVEL
(
    POL_ID_PICTURE_OF_LEVEL INTEGER NOT NULL,
    PRIMARY KEY(POL_ID_PICTURE_OF_LEVEL)
);

CREATE TABLE IF NOT EXISTS USTENSIL
(
    UST_ID_USTENSIL SERIAL NOT NULL,
    UST_LABEL_USTENSIL VARCHAR(255) NOT NULL,
    PRIMARY KEY(UST_ID_USTENSIL)
);

CREATE TABLE IF NOT EXISTS USTENSIL_IN_RECIPE
(
    UIR_ID_USTENSIL_IN_RECIPE SERIAL NOT NULL,
    UIR_FK_ID_RECIPE SERIAL NOT NULL,
    UIR_FK_USTENSIL SERIAL NOT NULL,
    PRIMARY KEY(UIR_ID_USTENSIL_IN_RECIPE)
);


CREATE TABLE IF NOT EXISTS PRODUCER
(
    PRD_ID_PRODUCER SERIAL NOT NULL,
    PRD_CITY VARCHAR(255),
    PRD_NAME VARCHAR(255),
    PRD_DESCRIPTION TEXT,
    PRD_PICPATH VARCHAR(255),
    PRIMARY KEY(PRD_ID_PRODUCER)
);

CREATE TABLE IF NOT EXISTS INGREDIENT_OF_PRODUCER
(
    IOP_ID_INGREDIENT_OF_PRODUCER SERIAL NOT NULL,
    IOP_FK_ID_INGREDIENT SERIAL,
    IOP_FK_ID_PRODUCER SERIAL,
    PRIMARY KEY(IOP_ID_INGREDIENT_OF_PRODUCER)
);


-- Create FKs
ALTER TABLE TASTE
    ADD    FOREIGN KEY (TST_FK_ID_MEMBER)
    REFERENCES MEMBER(MBR_ID_MEMBER)
    MATCH SIMPLE
;
    
ALTER TABLE RECIPE
    ADD    FOREIGN KEY (RCP_FK_CREATOR)
    REFERENCES MEMBER(MBR_ID_MEMBER)
    MATCH SIMPLE
;
    
ALTER TABLE TASTE
    ADD    FOREIGN KEY (TST_FK_ID_INGREDIENT)
    REFERENCES INGREDIENT(IGD_ID_INGREDIENT)
    MATCH SIMPLE
;
    
ALTER TABLE TAG_TO_INGREDIENT
    ADD    FOREIGN KEY (TTI_FK_ID_TAG)
    REFERENCES TAG(TAG_ID_TAG)
    MATCH SIMPLE
;
    
ALTER TABLE TAG_TO_INGREDIENT
    ADD    FOREIGN KEY (TTI_FK_ID_INGREDIENT)
    REFERENCES INGREDIENT(IGD_ID_INGREDIENT)
    MATCH SIMPLE
;
    
ALTER TABLE INGREDIENT_IN_RECIPE
    ADD    FOREIGN KEY (IIR_FK_ID_INGREDIENT)
    REFERENCES INGREDIENT(IGD_ID_INGREDIENT)
    MATCH SIMPLE
;
    
ALTER TABLE INGREDIENT_IN_RECIPE
    ADD    FOREIGN KEY (IIR_FK_ID_RECIPE)
    REFERENCES RECIPE(RCP_ID_RECIPE)
    MATCH SIMPLE
;
    
ALTER TABLE TAG_TO_RECIPE
    ADD    FOREIGN KEY (TTR_FK_ID_TAG)
    REFERENCES TAG(TAG_ID_TAG)
    MATCH SIMPLE
;
    
ALTER TABLE TAG_TO_RECIPE
    ADD    FOREIGN KEY (TTR_FK_ID_RECIPE)
    REFERENCES RECIPE(RCP_ID_RECIPE)
    MATCH SIMPLE
;
    
ALTER TABLE RECIPE_STEP
    ADD    FOREIGN KEY (RST_FK_ID_RECIPE)
    REFERENCES RECIPE(RCP_ID_RECIPE)
    MATCH SIMPLE
;
    
ALTER TABLE COMMENT
    ADD    FOREIGN KEY (CMT_FK_ID_MEMBER)
    REFERENCES MEMBER(MBR_ID_MEMBER)
    MATCH SIMPLE
;
    
ALTER TABLE COMMENT
    ADD    FOREIGN KEY (CMT_FK_ID_RECIPE)
    REFERENCES RECIPE(RCP_ID_RECIPE)
    MATCH SIMPLE
;
    
ALTER TABLE NOTE
    ADD    FOREIGN KEY (NOT_FK_ID_RECIPE)
    REFERENCES RECIPE(RCP_ID_RECIPE)
    MATCH SIMPLE
;
    
ALTER TABLE NOTE
    ADD    FOREIGN KEY (NOT_FK_ID_MEMBER)
    REFERENCES MEMBER(MBR_ID_MEMBER)
    MATCH SIMPLE
;
    
ALTER TABLE NOTE
    ADD    FOREIGN KEY (NOT_FK_ID_COMMENT)
    REFERENCES COMMENT(CMT_ID_COMMENT)
    MATCH SIMPLE
;
    
ALTER TABLE PICTURE_IN_RECIPE
    ADD    FOREIGN KEY (PIR_FK_ID_RECIPE)
    REFERENCES RECIPE(RCP_ID_RECIPE)
    MATCH SIMPLE
;
    
ALTER TABLE PICTURE_IN_RECIPE
    ADD    FOREIGN KEY (PIR_FK_ID_COMMENT)
    REFERENCES COMMENT(CMT_ID_COMMENT)
    MATCH SIMPLE
;
    
ALTER TABLE PICTURE_IN_RECIPE
    ADD    FOREIGN KEY (PIR_FK_ID_PICTURE)
    REFERENCES PICTURE(PIC_ID_PICTURE)
    MATCH SIMPLE
;
    
ALTER TABLE ADMINISTRATOR
    ADD    FOREIGN KEY (ADM_ID_ADMINISTRATOR)
    REFERENCES MEMBER(MBR_ID_MEMBER)
    MATCH SIMPLE
;
    
ALTER TABLE RECIPE
    ADD    FOREIGN KEY (RCP_VALIDATOR)
    REFERENCES ADMINISTRATOR(ADM_ID_ADMINISTRATOR)
    MATCH SIMPLE
;
    
ALTER TABLE COMMENT
    ADD    FOREIGN KEY (CMT_VALIDATOR)
    REFERENCES ADMINISTRATOR(ADM_ID_ADMINISTRATOR)
    MATCH SIMPLE
;
    
ALTER TABLE PICTURE
    ADD    FOREIGN KEY (PIC_FK_ID_MEMBER)
    REFERENCES MEMBER(MBR_ID_MEMBER)
    MATCH SIMPLE
;
    
ALTER TABLE PICTURE_OF_INGREDIENT
    ADD    FOREIGN KEY (POI_FK_ID_INGREDIENT)
    REFERENCES INGREDIENT(IGD_ID_INGREDIENT)
    MATCH SIMPLE
;
    
ALTER TABLE PICTURE_OF_INGREDIENT
    ADD    FOREIGN KEY (POI_FK_ID_PICTURE)
    REFERENCES PICTURE(PIC_ID_PICTURE)
    MATCH SIMPLE
;
    
ALTER TABLE PICTURE_OF_USER
    ADD    FOREIGN KEY (POU_ID_PICTURE_OF_USER)
    REFERENCES PICTURE(PIC_ID_PICTURE)
    MATCH SIMPLE
;
    
ALTER TABLE MEMBER
    ADD    FOREIGN KEY (MBR_MAIN_PICTURE)
    REFERENCES PICTURE_OF_USER(POU_ID_PICTURE_OF_USER)
    MATCH SIMPLE
;
    
ALTER TABLE MEMBER
    ADD    FOREIGN KEY (MBR_LEVEL)
    REFERENCES LEVEL(LVL_ID_LEVEL)
    MATCH SIMPLE
;

ALTER TABLE RECIPE_STEP_SUCCESSFUL
    ADD    FOREIGN KEY (RSS_ID_RECIPE_STEP)
    REFERENCES RECIPE_STEP(RST_ID_RECIPE_STEP)
    MATCH SIMPLE
;
    
ALTER TABLE RECIPE_STEP_SUCCESSFUL
    ADD    FOREIGN KEY (RSS_ID_MEMBER)
    REFERENCES MEMBER(MBR_ID_MEMBER)
    MATCH SIMPLE
;
    
    
ALTER TABLE LEVEL
    ADD    FOREIGN KEY (LVL_MAIN_PICTURE)
    REFERENCES PICTURE_OF_LEVEL(POL_ID_PICTURE_OF_LEVEL)
    MATCH SIMPLE
;
    
ALTER TABLE PICTURE_OF_LEVEL
    ADD    FOREIGN KEY (POL_ID_PICTURE_OF_LEVEL)
    REFERENCES PICTURE(PIC_ID_PICTURE)
    MATCH SIMPLE
;
    
ALTER TABLE USTENSIL_IN_RECIPE
    ADD    FOREIGN KEY (UIR_FK_USTENSIL)
    REFERENCES USTENSIL(UST_ID_USTENSIL)
    MATCH SIMPLE
;
    
ALTER TABLE USTENSIL_IN_RECIPE
    ADD    FOREIGN KEY (UIR_FK_ID_RECIPE)
    REFERENCES RECIPE(RCP_ID_RECIPE)
    MATCH SIMPLE
;
    
ALTER TABLE INGREDIENT
    ADD    FOREIGN KEY (IGD_MAIN_PICTURE)
    REFERENCES PICTURE_OF_INGREDIENT(POI_ID_PICTURE_OF_INGREDIENT)
    MATCH SIMPLE
;
    
ALTER TABLE RECIPE
    ADD    FOREIGN KEY (RCP_MAIN_PICTURE)
    REFERENCES PICTURE_IN_RECIPE(PIR_ID_PICTURE_IN_RECIPE)
    MATCH SIMPLE
;

ALTER TABLE INGREDIENT_OF_PRODUCER
    ADD    FOREIGN KEY (IOP_FK_ID_PRODUCER)
    REFERENCES PRODUCER(PRD_ID_PRODUCER)
    MATCH SIMPLE
;
    
ALTER TABLE INGREDIENT_OF_PRODUCER
    ADD    FOREIGN KEY (IOP_FK_ID_INGREDIENT)
    REFERENCES INGREDIENT(IGD_ID_INGREDIENT)
    MATCH SIMPLE
;




-- Alter constraints
ALTER TABLE NOTE
    ADD CONSTRAINT note_unique_member_recipe UNIQUE(NOT_FK_ID_MEMBER,NOT_FK_ID_RECIPE)
;

ALTER TABLE RECIPE_STEP_SUCCESSFUL
    ADD CONSTRAINT recipe_step_successful_unique UNIQUE (RSS_ID_MEMBER,RSS_ID_RECIPE_STEP)
;

