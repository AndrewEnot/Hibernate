-- Dropping constraints for tables

ALTER TABLE my_school.mark ALTER COLUMN value DROP NOT NULL;
ALTER TABLE my_school.mark ALTER COLUMN discipline DROP NOT NULL;

ALTER TABLE my_school.student ALTER COLUMN name DROP NOT NULL;
ALTER TABLE my_school.student ALTER COLUMN email DROP NOT NULL;



