-- Copiando estrutura para tabela gsaairsoft.financedepartment
CREATE TABLE IF NOT EXISTS `financedepartment` (
                                                   `registered` bigint NOT NULL AUTO_INCREMENT,
                                                   `payment_received` decimal NOT NULL,
                                                   `date_Payment` date NOT NULL,
                                                   `received_by` bigint not null ,
                                                   PRIMARY KEY (`registered`),
                                                   KEY `received_by` (`received_by`),
                                                   CONSTRAINT `financedepartment` FOREIGN KEY (`received_by`) REFERENCES `people` (`id`)
);

