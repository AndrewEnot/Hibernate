-- Making constraints for tables and adding column to my_school.mark

ALTER TABLE my_school.mark ADD COLUMN fk_student_id integer default null;
ALTER TABLE my_school.mark ADD foreign key (fk_student_id) references my_school.student (id);

ALTER TABLE my_school.mark ALTER COLUMN value SET NOT NULL;
ALTER TABLE my_school.mark ALTER COLUMN discipline SET NOT NULL;

ALTER TABLE my_school.student ALTER COLUMN name SET NOT NULL;
ALTER TABLE my_school.student ALTER COLUMN email SET NOT NULL;



