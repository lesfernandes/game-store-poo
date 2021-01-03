USE `gamestore` ;

drop table pedidos;
drop table compras;
drop table produtos;
drop table jogos;
drop table consoles;
drop table acessorios;

-- -----------------------------------------------------
-- insert de produtos para jogos
-- -----------------------------------------------------
insert into produtos values 
(null, "Quinta geração da franquia Pokémon", "Pokémon Black 2", 37.50),
(null, "Remake da segunda geração da franquia Pokémon", "Pokémon Soul Silver", 24.80),
(null, "Quarto jogo da série Souls", "Dark Souls 3", 20.70),
(null, "Barbie se aventura no hipismo", "Barbie Horse Adventures: Wild Horse Rescue", 7.00),
(null, "Jogo criado por Toby Fox e seu time", "Undertale", 10.50);

insert into jogos values
(null, null, 1, "RPG Japonês", 1),
(null, null, 1, "RPG Japonês", 2),
(null, 4, 1, "RPG estilo Souls", 3),
(null, null, 2, "Aventura", 4),
(null, 2, 1, "RPG", 5);

-- -----------------------------------------------------
-- insert de produtos para consoles
-- -----------------------------------------------------
insert into produtos values 
(null, "Console portátil produzido pela Nintendo, lançado em 2011", "Nintendo 3DS", 150.00),
(null, "Console de mesa revisado produzido pela Sony, lançado em 2016", "PlayStation 4 Slim", 390.00),
(null, "Console de mesa produzido pela Sony, lançado em 2000", "PlayStation 2", 100.00),
(null, "Console de mesa produzido pela Microsoft, lançado em 2017", "Xbox One X", 390.00);

insert into consoles values
(null, "64gb", "Azul especial", 6),
(null, "500gb", "Preto", 7),
(null, "128mb", "Preto", 8),
(null, "500gb", "Branco", 9);

-- -----------------------------------------------------
-- insert de produtos para acessórios
-- -----------------------------------------------------
insert into produtos values 
(null, "Acessório de expansão dos controles do Nintendo 3DS", "Nintendo 3DS Slide Pad", 21.90),
(null, "Acessório para carregamento de controles de PS4", "PS4 Controller Charger Station", 14.20);

insert into acessorios values
(null, "Circle Pad e triggers a mais", 10),
(null, "Cor preta led azul", 11);

-- -----------------------------------------------------
-- insert de clientes
-- -----------------------------------------------------

insert into clientes values 
(null, 28329, "Gabrielle Sandrone", "Av. dos Gamers", null),
(null, 12832, "Deividson Henry", "Rua Gamer da Silva", null);

-- -----------------------------------------------------
-- insert de pedidos
-- -----------------------------------------------------

insert into pedidos values 
(null, "2020-10-11", "Jogo Pokemon", 1, 1),
(null, "2020-10-11", "Console 3ds", 6, 1),
(null, "2020-10-11", "Acessório 3ds", 10, 1);

-- -----------------------------------------------------
-- insert de compras
-- -----------------------------------------------------

insert into compras values 
(null, "2020-10-11", "Jogo Pokemon", 1, 1),
(null, "2020-10-11", "Console 3ds", 6, 1),
(null, "2020-10-11", "Acessório 3ds", 10, 1);

-- -----------------------------------------------------
-- updates
-- -----------------------------------------------------
update jogos
set outras_informacoes = 'MEME'
where jogo_id = 1;

update consoles
set outras_informacoes = 'MEME'
where console_id = 1;

update acessorios
set outras_informacoes = 'MEME'
where acessorio_id = 1;

select * from produtos;
select * from jogos;
select * from consoles;
select * from acessorios;
select * from clientes;
select * from pedidos;
select * from compras where compra_id = 2;

INSERT INTO `compras` (`data`, `outras_informacoes`, `produto_id`, `cliente_id`) VALUES ('23', '23', '23', '1');
UPDATE `compras` SET `data` = '23', `outras_informacoes` = '23', `produto_id` = '23' WHERE (`compra_id` = '3');


/* Select por id */
select * from produtos p inner join jogos j on j.produto_id = p.produto_id where j.jogo_id = 3;

select * from produtos p inner join jogos j on j.produto_id = p.produto_id where j.outras_informacoes = 'MEME';

select * from produtos p inner join consoles c on c.produto_id = p.produto_id where c.console_id = 3;

select * from produtos p inner join consoles c on c.produto_id = p.produto_id where c.outras_informacoes = 'MEME';

select * from produtos p inner join acessorios a on a.produto_id = p.produto_id; -- where a.acessorio_id = 2;

select * from produtos p inner join acessorios a on a.produto_id = p.produto_id where a.outras_informacoes = 'MEME';

/* recuperar cliente que fez um pedido de um produto com id fornecido */
select * from clientes cli inner join pedidos pe on pe.cliente_id = cli.cliente_id inner join produtos p on p.produto_id = pe.produto_id where pe.produto_id = 6;

/* recuperar cliente que fez uma compra de um produto com id fornecido */
select * from clientes cli inner join compras cm on cm.cliente_id = cli.cliente_id inner join produtos p on p.produto_id = cm.produto_id where cm.produto_id = 6;

/* recuperar compras ou pedidos de um cliente com id fornecido*/

select * from compras cm inner join clientes cli on cli.cliente_id = cm.cliente_id where cli.cliente_id = 1;

select * from pedidos pe inner join clientes cli on cli.cliente_id = pe.cliente_id where cli.cliente_id = 1;

/* deleta linha da tabela 1 e tabela 2 onde variavel é valor informado*/

delete p, j from produtos p
inner join jogos j on j.produto_id = p.produto_id
where j.outras_informacoes = 'MEME';

delete p, c from produtos p
inner join consoles c on c.produto_id = p.produto_id
where c.outras_informacoes = 'MEME';

delete p, a from produtos p
inner join acessorios a on a.produto_id = p.produto_id
where a.outras_informacoes = 'MEME';

delete cm from compras cm
inner join clientes cli on cli.cliente_id = cm.cliente_id
where cm.cliente_id = 1;

delete pe from pedidos pe
inner join clientes cli on cli.cliente_id = pe.cliente_id
where cm.cliente_id = 1;

select * from produtos;
drop table produtos;

select * from compras 
inner join produtos on compras.produto_id = produtos.produto_id 
inner join clientes on clientes.cliente_id = compras.cliente_id 
where compras.compra_id = 1;

select * from pedidos 
inner join produtos on pedidos.produto_id = produtos.produto_id 
inner join clientes on clientes.cliente_id = compras.cliente_id 
where pedidos.pedido_id = 1;
