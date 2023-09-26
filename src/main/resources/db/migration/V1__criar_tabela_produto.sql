CREATE TABLE produto (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    descricao VARCHAR(50) NOT NULL,
    is_ativo BOOLEAN NOT NULL,
    valor_sugerido DECIMAL(8, 2) NOT NULL COMMENT "Valor sugerido para a oferta",
    data_inclusao DATETIME NOT NULL,
    data_atualizacao DATETIME DEFAULT NULL,
    PRIMARY KEY (id)
);