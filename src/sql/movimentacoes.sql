-- apontamento1.movimentacoes definition

        CREATE TABLE `movimentacoes` (
        `codigo` int NOT NULL AUTO_INCREMENT,
        `tipo_movimento` enum('ENTRADA','SAIDA') NOT NULL,
        `produto_id` int NOT NULL,
        `quantidade` int NOT NULL,
        PRIMARY KEY (`codigo`),
        KEY `produto_id` (`produto_id`),
        CONSTRAINT `movimentacoes_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`codigo`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- apontamento1.movimentacoes definition

        CREATE TABLE `movimentacoes` (
          `codigo` int NOT NULL AUTO_INCREMENT,
          `tipo_movimento` enum('ENTRADA','SAIDA') NOT NULL,
          `produto_id` int NOT NULL,
          `quantidade` int NOT NULL,
          PRIMARY KEY (`codigo`),
          KEY `produto_id` (`produto_id`),
          CONSTRAINT `movimentacoes_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`codigo`)
        ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;