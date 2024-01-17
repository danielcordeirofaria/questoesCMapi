CREATE TABLE tbl_questoes (
    id_questao VARCHAR(10) NOT NULL,
    ano_prova INT NOT NULL,
    numero_questao INT NOT NULL,
    enunciado TEXT NOT NULL,
    endereco_imagem TEXT,
    resposta_a TEXT NOT NULL,
    resposta_b TEXT NOT NULL,
    resposta_c TEXT NOT NULL,
    resposta_d TEXT NOT NULL,
    resposta_e TEXT NOT NULL,
    gabarito VARCHAR(1) NOT NULL CHECK (gabarito IN ('A', 'B', 'C', 'D', 'E')),
    materia VARCHAR(20) NOT NULL CHECK (materia IN ('matematica', 'portugues')),
    endereco_video TEXT,
    resolvido double,
    PRIMARY KEY (id_questao)
);
