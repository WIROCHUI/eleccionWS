INSERT INTO public.distrito(create_datetime, nombre)VALUES (current_timestamp, 'Ate');
INSERT INTO public.distrito(create_datetime, nombre)VALUES (current_timestamp, 'Lima');
INSERT INTO public.distrito(create_datetime, nombre)VALUES (current_timestamp, 'Molina');
INSERT INTO public.distrito(create_datetime, nombre)VALUES (current_timestamp, 'Santa Anita');

INSERT INTO public.institucion(create_datetime, direccion, nombre, id_distrito)	VALUES (current_timestamp, 'CALLE SAN ANDRES MZ G LOTE 1', '0031 ROBERT F. KENNEDY', 1)
INSERT INTO public.institucion(create_datetime, direccion, nombre, id_distrito)	VALUES (current_timestamp, 'UCV 116 - ZONA G', 'LOSA DEPORTIVA UCV 116', 1)

INSERT INTO persona(apellido_materno, apellido_paterno, create_datetime, dni, flg_grabado, nombre,peru_libre,fuerza_popular,total_voto_emitido,voto_blanco,voto_impugnado,voto_nulo,id_distrito, id_institucion)VALUES ('Mendoza', 'Luna', current_timestamp, 87654321, 1, 'Diego', 100, 90, 250, 45, 5, 25, 1, 1);
INSERT INTO persona(apellido_materno, apellido_paterno, create_datetime, dni, flg_grabado, nombre,peru_libre,fuerza_popular,total_voto_emitido,voto_blanco,voto_impugnado,voto_nulo,id_distrito, id_institucion)VALUES ('PERLA', 'DELE', current_timestamp, 87654322, 1, 'ANA', 200, 55, 85, 63, 5, 7, 1, 1);
INSERT INTO persona(apellido_materno, apellido_paterno, create_datetime, dni, flg_grabado, nombre,peru_libre,fuerza_popular,total_voto_emitido,voto_blanco,voto_impugnado,voto_nulo,id_distrito, id_institucion)VALUES ('WAR', 'DULK', current_timestamp, 87654323, 0, 'OSCAR', 0, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO persona(apellido_materno, apellido_paterno, create_datetime, dni, flg_grabado, nombre,peru_libre,fuerza_popular,total_voto_emitido,voto_blanco,voto_impugnado,voto_nulo,id_distrito, id_institucion)VALUES ('ORGA', 'GUERRA', current_timestamp, 87654324, 0, 'EDY', 0, 0, 0, 0, 0, 0, 1, 1);










