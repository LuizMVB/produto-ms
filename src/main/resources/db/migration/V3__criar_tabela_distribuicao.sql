CREATE TABLE distribuicao (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    uf VARCHAR(2) NOT NULL,
    cidade VARCHAR(20) DEFAULT NULL,
    tipo_filial VARCHAR(12) NOT NULL COMMENT "Indica o tipo de filial quanto ao seu porte: - MERCEARIA; - MINIMERCADO; - SUPERMERCADO; - HIPERMERCADO",
    id_oferta BIGINT(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_oferta) REFERENCES oferta(id)
);