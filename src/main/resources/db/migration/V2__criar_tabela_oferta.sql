CREATE TABLE oferta (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    id_produto BIGINT(20) NOT NULL,
    nome VARCHAR(40) NOT NULL,
    descricao VARCHAR(50) DEFAULT NULL,
    is_ativo BOOLEAN DEFAULT 1 NOT NULL,
    valor DECIMAL(8, 2) NOT NULL,
    data_fim DATETIME DEFAULT NULL,
    data_inclusao DATETIME NOT NULL,
    data_atualizacao DATETIME DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);