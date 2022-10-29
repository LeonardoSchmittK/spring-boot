INSERT INTO public.produto(descricao,preco_unitario) VALUES ('Arroz Tio Joao','15.49');
INSERT INTO public.produto(descricao,preco_unitario) VALUES ('Feijao Mae Joana','15.49');
INSERT INTO public.produto(descricao,preco_unitario) VALUES ('Televisao ','2515.49');


-- INSERT INTO public.usuario(login,nome,senha) VALUES('logiin','leoschmittk','leoschmittk2/');

INSERT INTO public.usuario(data_atualizacao,data_cadastro, login,nome, senha) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)),timezone('utc',CURRENT_TIMESTAMP(0)),'blabla','logggbla','senha123');

-- INSERT INTO public.telefone(numero,tipo,id_usuario)  VALUES('48999906804','Celular',1);