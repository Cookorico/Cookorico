
/*
Trigramme:
ADM ==> ADMINISTRATOR
CMT ==> COMMENT (serial)
IGD ==> INGREDIENT (serial)
IIR ==> INGREDIENT_IN_RECIPE (serial)
LVL ==> LEVEL (serial)
MBR ==> MEMBER (serial)
NOT ==> NOTE (serial)
PIC ==> PICTURE (serial)
PIR ==> PICTURE_IN_RECIPE (serial)
POL ==> PICTURE_OF_LEVEL
POI ==> PICTURE_OF_INGREDIENT (serial)
POU ==> PICTURE_OF_USER
RCP ==> RECIPE (serial)
RSS ==> RECIPE_STEP_SUCCESSFUL (serial)
RST ==> RECIPE_STEP (serial)
TAG ==> TAG (serial)
TTI ==> TAG_TO_INGREDIENT (serial)
TTR ==> TAG_TO_RECIPE (serial)
TST ==> TASTE (serial)
UIR ==> USTENSIL_IN_RECIPE (serial)
UST ==> USTENSIL (serial)
*/


GRANT SELECT, INSERT, UPDATE, DELETE ON ADMINISTRATOR TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON COMMENT TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE comment_cmt_id_comment_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON INGREDIENT TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE ingredient_igd_id_ingredient_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON INGREDIENT_IN_RECIPE TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE ingredient_in_recipe_iir_id_ingredient_in_recipe_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON LEVEL TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE level_lvl_id_level_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON MEMBER TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE member_mbr_id_member_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON NOTE TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE note_not_id_note_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON PICTURE TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE picture_pic_id_ingredient_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON PICTURE_IN_RECIPE TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE picture_in_recipe_pir_id_picture_in_recipe_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON PICTURE_OF_LEVEL TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON PICTURE_OF_INGREDIENT TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE picture_of_ingredient_poi_id_picture_of_ingredient_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON PICTURE_OF_USER TO cookorico

GRANT SELECT, INSERT, UPDATE, DELETE ON RECIPE TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE recipe_rcp_id_recipe_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON RECIPE_STEP_SUCCESSFUL TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE recipe_step_successful_rss_id_recipe_step_successful_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON RECIPE_STEP TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE recipe_step_igd_id_recipe_step_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON TAG TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE tag_tag_id_tag_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON TAG_TO_INGREDIENT TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE tag_to_ingredient_tti_id_tag_to_ingredient_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON TAG_TO_RECIPE TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE tag_to_recipe_ttr_id_tag_to_recipe_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON TASTE TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE taste_tst_id_taste_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON USTENSIL_IN_RECIPE TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE ustensil_in_recipe_uir_id_ustensil_in_recipe_seq TO cookorico;

GRANT SELECT, INSERT, UPDATE, DELETE ON USTENSIL TO cookorico;
GRANT USAGE, SELECT ON SEQUENCE ustensil_ust_id_ustensil_seq TO cookorico;




