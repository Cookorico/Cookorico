
/* FUNCTION TO MODIF DATE WITH NOW WHEN CALLED*/
CREATE OR REPLACE FUNCTION update_modified_column()	
RETURNS TRIGGER AS $$
BEGIN
    NEW.modif_date = now();
    RETURN NEW;	
END;
$$ language 'plpgsql';


/* MEMBER MODIF DATE*/
CREATE TRIGGER update_member_modif_date BEFORE UPDATE ON MEMBER FOR EACH ROW EXECUTE PROCEDURE  update_modified_column();

/* INGREDIENT MODIF DATE*/
CREATE TRIGGER update_ingredient_modif_date BEFORE UPDATE ON INGREDIENT FOR EACH ROW EXECUTE PROCEDURE  update_modified_column();

/* TASTE MODIF DATE*/
CREATE TRIGGER update_taste_modif_date BEFORE UPDATE ON TASTE FOR EACH ROW EXECUTE PROCEDURE  update_modified_column();

/* RECIPE MODIF DATE*/
CREATE TRIGGER update_recipe_modif_date BEFORE UPDATE ON RECIPE FOR EACH ROW EXECUTE PROCEDURE  update_modified_column();

/* RECIPE_STEP MODIF DATE*/
CREATE TRIGGER update_recipe_step_modif_date BEFORE UPDATE ON RECIPE_STEP FOR EACH ROW EXECUTE PROCEDURE  update_modified_column();

/* COMMENT MODIF DATE*/
CREATE TRIGGER update_comment_modif_date BEFORE UPDATE ON COMMENT FOR EACH ROW EXECUTE PROCEDURE  update_modified_column();

/* NOTE MODIF DATE*/
CREATE TRIGGER update_note_modif_date BEFORE UPDATE ON NOTE FOR EACH ROW EXECUTE PROCEDURE  update_modified_column();








