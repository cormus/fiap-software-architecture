CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `senha` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefone` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cpf` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `logradouro` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numero` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `complemento` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bairro` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cidade` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `uf` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cep` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;