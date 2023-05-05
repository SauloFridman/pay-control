
-- Copiando dados para a tabela gsaairsoft.people: ~8 rows (aproximadamente)
CREATE TABLE IF NOT EXISTS `people` (`id` bigint NOT NULL AUTO_INCREMENT primary key,
 `nome` varchar(255) not null , `contact` varchar(255), `nasc` date, `category` varchar(180))



