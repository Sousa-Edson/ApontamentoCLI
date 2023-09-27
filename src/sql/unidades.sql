-- apontamento1.unidades definition

CREATE TABLE `unidades` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- apontamento1.produtos definition

CREATE TABLE `produtos` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `unidade_id` int NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `unidade_id` (`unidade_id`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`unidade_id`) REFERENCES `unidades` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;