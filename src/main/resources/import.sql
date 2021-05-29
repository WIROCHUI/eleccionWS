INSERT INTO public.distrito(create_datetime, nombre)VALUES (current_timestamp, 'Ate');
INSERT INTO public.distrito(create_datetime, nombre)VALUES (current_timestamp, 'Lima');
INSERT INTO public.distrito(create_datetime, nombre)VALUES (current_timestamp, 'Molina');
INSERT INTO public.distrito(create_datetime, nombre)VALUES (current_timestamp, 'Santa Anita');

INSERT INTO public.institucion(create_datetime, direccion, nombre, id_distrito)	VALUES (current_timestamp, 'CALLE SAN ANDRES MZ G LOTE 1', '0031 ROBERT F. KENNEDY', 2)

INSERT INTO public.mesa(create_datetime, elector_participante, elector_total, numero_mesa,id_institucion)VALUES (current_timestamp, 0, 300, 034376, 1);
INSERT INTO public.mesa(create_datetime, elector_participante, elector_total, numero_mesa, id_institucion)VALUES (current_timestamp, 0, 300, 034377, 1);

INSERT INTO public.persona(apellido_materno, apellido_paterno, create_datetime, dni, nombre, id_distrito, id_institucion,id_mesa)VALUES ('Mendoza', 'Luna', current_timestamp, 87654321, 'Diego', 1, 1, 1);











